## Spring Boot - Best Practices

This demo application has some proof concepts about the Spring article [(take a look here)!](https://marlo-wiki.atlassian.net/wiki/spaces/TEC/pages/55508995/Spring+Boot+Best+Practices). It consists in a demo microservice with two endpoints:

##### GET - /rates
- Retrieve a list of rates from fixer.io API. The response from fixer is mapped in a way to filter only BRL and AUD from the list of rates and return it to the final user.

##### POST - /rates
- Is a post example that insert the body from request into a database. 
