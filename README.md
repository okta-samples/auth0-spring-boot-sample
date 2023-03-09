# Getting Started

Spring Boot Web application secured by Auth0

## OAuth 2.0 and OIDC with Auth0 by Okta

If you don't have a free Auth0 developer account, you can [Sign up](https://auth0.com/signup) for one.

Once you have an account log in using [Auth0 CLI](https://github.com/auth0/auth0-cli#installation).

```bash
$ auth0 login
```

Then, register your Spring Boot app on Auth0 using:

```bash
$ auth0 apps create \
  --name "Auth0 Spring Boot Sample" \
  --description "Auth0 Spring Boot Sample" \
  --type regular \
  --callbacks http://localhost:8080/login/oauth2/code/okta \
  --logout-urls http://localhost:8080
  --reveal
```

Configure the application. Update the `src/main/resources/application.properties` file with the following content:

```properties
okta.oauth2.issuer=YOUR_AUTH0_ORG_URI
okta.oauth2.client-id=YOUR_AUTH0_CLIENT_ID
```

Run 

```bash
OKTA_OAUTH2_CLIENT_SECRET=YOUR_AUTH0_CLIENT_SECRET ./gradlew bootRun
```

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.4/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.4/gradle-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.0.4/reference/htmlsingle/#web)
* [Thymeleaf](https://docs.spring.io/spring-boot/docs/3.0.4/reference/htmlsingle/#web.servlet.spring-mvc.template-engines)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)