## Work Sample

### RESTful Beer :beers: Webservice
This is a simple proof of concept RESTful API built with Java 8, Spring Boot, Hibernate, JPA, H2, Maven, & jUnit. The API is basically a handful of GET endpoints that intereact with an in-memory database of nearly 6000 beers and over 1400 breweries. Beer data was sourced from the [Open Beer DB](https://openbeerdb.com/).


### Endpoints
- Get All beers :beers:^ 
[http://localhost:8888/beers](http://localhost:8888/beers)
- Get beer :beer: by ID
[http://localhost:8888/beers/{beerId}](http://localhost:8888/beers/{beerId})
- Search for beers by name fragment 
[http://localhost:8888/beers/search/{beerName}](http://localhost:8888/beers/search/{beerName})

- Get All breweries^ 
[http://localhost:8888/breweries](http://localhost:8888/breweries})
- Get brewery by ID [http://localhost:8888/breweries/{breweryId}](http://localhost:8888/breweries/{breweryId})
- Search for breweries by name fragment 
[http://localhost:8888/breweries/search/{breweryName}](http://localhost:8888/breweries/search/{breweryName})

> ^ These endpoints are really slow since they get all beer and brewery entries from the database and are not paged. See future work.



### Future Work
- [ ] Implement Create, Update, & Delete endpoints for Beers & Breweries
- [ ] Implement CRUD endpoints for Categories & Styles
- [ ] More thorough unit and integration tests 
- [ ] Customize logging
- [ ] Implement HATEOAS
- [ ] Utilize Stream API
- [ ] Implement more robust search
- [ ] Page results for requests with large result sets
- [ ] Implement view layer
- [ ] More robust/descriptive error handling
- [ ] Prevent editing of LastModified values when no changes have been made to the entity

:beer::beers::beer::beers::beer::beers::beer::beers::beer::beers::beer::beers::beer::beers::beer::beers::beer::beers::beer::beers::beer::beers::beer::beers::beer::beers::beer::beers::beer::beers::beer::beers::beer::beers::beer::beers::beer: