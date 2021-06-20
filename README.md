# POST-redirect-GET

This is a small assignment Spring Web application, which serves as an example for the 
POST-redirect-GET pattern.

The application will run on port 8080 by default.

It exposes the following endpoints: `/form` and `/success`

The application provides a single text input form, which when submitted will 
redirect the client.

In case the form input string is *valid* - not blank and less then 10 chars long - 
the client will be redirected to the success page, where the original input will be reflected.

In case the form input string is *invalid*, the client will redirect back to the form,
 displaying a validation error.
