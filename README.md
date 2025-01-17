# Basic E-Commerce Backend
Using Springboot with JPA and database is postgre SQl Make the serveral Controller.

## Features

- Fetch all the product details
- Fetch the product using its id (Primary Key)
- Add The Product with request Body Name, Brand, Description, its Category and its image
- Update the product details
- Delete the product
- Search the product with keyword (Here use the external query JPQL)

## Appendix

Using a different Annotation in this project:-

- @Controller: Marks a class as a Spring MVC controller that handles web requests.

- @RequestBody: Binds the HTTP request body to a method parameter (usually used for JSON or XML).

- @ResponseEntity: Represents the entire HTTP response, allowing control over status, headers, and body.

- @PathVariable: Extracts a value from the URI path and binds it to a method parameter.

- @RequestParam: Extracts a query parameter or form data from the HTTP request and binds it to a method parameter.

- @RequestPart: Extracts a part of a multipart/form-data request (e.g., file uploads) and binds it to a method parameter.

- @CrossOrigin: Enables Cross-Origin Resource Sharing (CORS) for a controller or specific methods, allowing requests from other origins.

-----------Many More Anotation is used-----------
