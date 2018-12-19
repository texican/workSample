package com.ciflores2.workSample;

import com.ciflores2.workSample.dto.BeerDto;
import com.ciflores2.workSample.dto.BreweryDto;
import com.ciflores2.workSample.jpa.entity.Address;
import com.ciflores2.workSample.service.BeerService;
import com.ciflores2.workSample.service.BreweryService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(value = BeerController.class, secure = false)
public class BeerControllerTest {

    @MockBean
    private BeerService beerService;
    
    @MockBean
    private BreweryService breweryService;


    private BeerDto beer1;
    private String beer1Json;
    private BeerDto beer2;
    private List<BeerDto> beers = new ArrayList<>();
    private Address address;
    private BreweryDto brewery1;
    private BreweryDto brewery2;
    private String brewery1Json;
    private List<BreweryDto> breweries = new ArrayList<>();
    private String allBreweriesJson;
    private String allBeersJson;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        beer1 = new BeerDto(2610l, "Catfish Cream Ale", 13l, "Agassiz Brewing", 8l, "North American Lager", 95l, "American-Style Lager", 5.0f, 0.0f, "");
        beer1Json = "{\"id\":2610,\"name\":\"Catfish Cream Ale\",\"breweryId\":13,\"breweryName\":\"Agassiz Brewing\",\"categoryId\":8,\"categoryName\":\"North American Lager\",\"styleId\":95,\"style\":\"American-Style Lager\",\"abv\":5.0,\"ibu\":0.0,\"description\":\"\"}";

        List<BeerDto> agassizBeers = new ArrayList<>();
        agassizBeers.add(beer1);

        address = new Address("PO Box 42008", "", "Winnipeg", "Manitoba", "0", "Canada");
        brewery1 = new BreweryDto(13l, "Agassiz Brewing", address, "1-204-233-4677", "", "", agassizBeers);
        brewery1Json = "{\"id\":13,\"name\":\"Agassiz Brewing\",\"beers\":[{\"id\":2610,\"name\":\"Catfish Cream Ale\",\"breweryId\":13,\"breweryName\":\"Agassiz Brewing\",\"categoryId\":8,\"categoryName\":\"North American Lager\",\"styleId\":95,\"style\":\"American-Style Lager\",\"abv\":5.0,\"ibu\":0.0,\"description\":\"\"}],\"address\":{\"address1\":\"PO Box 42008\",\"address2\":\"\",\"city\":\"Winnipeg\",\"state\":\"Manitoba\",\"zipCode\":\"0\",\"country\":\"Canada\"},\"phone\":\"1-204-233-4677\",\"website\":\"\",\"description\":\"\"}";


        beer2 = beer1;
        beers.add(beer1);
        beers.add(beer2);
        allBeersJson = "[" + beer1Json + ", " + beer1Json + "]";

        brewery2 = brewery1;
        breweries.add(brewery1);
        breweries.add(brewery2);
        allBreweriesJson = "[" + brewery1Json + ", " + brewery1Json + "]";
    }


    @Test
    public void getBeerById_HappyPath() throws Exception {
        when(beerService.findBeerById(beer1.getId())).thenReturn(beer1);

        makeGetCall("/beers/2610", beer1Json);

    }


    @Test
    public void getBreweryById_HappyPath() throws Exception {

        when(breweryService.findBreweryById(brewery1.getId())).thenReturn(brewery1);

        makeGetCall("/breweries/13", brewery1Json);
    }

    @Test
    public void getAllBeers_HappyPath() throws Exception {

        when(beerService.findAllBeers()).thenReturn(beers);

        makeGetCall("/beers", allBeersJson);
    }

    @Test
    public void getAllBreweries_HappyPath() throws Exception {

        when(breweryService.findAllBreweries()).thenReturn(breweries);

        makeGetCall("/breweries", allBreweriesJson);
    }

    private void makeGetCall(String uri, String expectedJsonString) throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                uri).accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println("Expected JSON: " + expectedJsonString);
        System.out.println("Response JSON: " + result.getResponse().getContentAsString());

        JSONAssert.assertEquals(expectedJsonString, result.getResponse()
                .getContentAsString(), false);
    }
}
