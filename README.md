## Work Sample

### RESTful Beer :beers: Webservice
This is a simple proof of concept RESTful API built with Java 8, Spring Boot, Hibernate, JPA, H2, Maven, & jUnit. The API is basically a handful of GET endpoints that intereact with an in-memory database of nearly 6000 beers and over 1400 breweries. Beer data was sourced from the [Open Beer DB](https://openbeerdb.com/).


### Endpoints
- **GET** All beers :beers:^ 
[http://localhost:8888/beers](http://localhost:8888/beers)
- **GET** beer :beer: by ID
[http://localhost:8888/beers/{beerId}](http://localhost:8888/beers/{beerId})
- **GET** all beers by name fragment 
[http://localhost:8888/beers/search/{beerName}](http://localhost:8888/beers/search/{beerName})

- **GET** All breweries^ 
[http://localhost:8888/breweries](http://localhost:8888/breweries})
- **GET** brewery by ID [http://localhost:8888/breweries/{breweryId}](http://localhost:8888/breweries/{breweryId})
- **GET** all breweries by name fragment 
[http://localhost:8888/breweries/search/{breweryName}](http://localhost:8888/breweries/search/{breweryName})

> ^ These endpoints are really slow since they get all beer and brewery entries from the database and are not paged. See future work.



### Future Work
- [ ] Swagger integration
- [ ] Category & Style DTOs
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
- [ ] Implement authentication

:beer::beers::beer::beers::beer::beers::beer::beers::beer::beers::beer::beers::beer::beers::beer::beers::beer::beers::beer::beers::beer::beers::beer::beers::beer::beers::beer::beers::beer::beers::beer::beers::beer::beers: