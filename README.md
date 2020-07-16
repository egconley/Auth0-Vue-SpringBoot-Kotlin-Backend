# Auth0-Vue-SpringBoot-Kotlin-Backend
Implementation of [Auth0 Blog Post](https://auth0.com/blog/vuejs-spring-boot-kotlin-and-graphql-building-modern-apps-part-1/) by Vladimir Fomene

This repo just contains the backend.  The associated frontend that calls the API can be found [here](https://github.com/egconley/Auth0-Vue-SpringBoot-Kotlin-Frontend).

Deployed frontend/backend: https://vue-spring-kotlin-graphql-fron.herokuapp.com/

## Built with:
- Kotlin
- Spring Boot

## Run on localhost
1. Clone this repo down to your local machine.
2. Add credentials:
    - Navigate to `application.properties` and enter the appropriate values for the following fields:
        - `security.oauth2.resource.id=your.auth0.API.identifier`
        - `security.oauth2.resource.jwk.keySetUri=https://your-auth0-tenant.auth0.com/.well-known/jwks.json`
        - `frontend=https://change.only.if.you.want.to.deploy.to.a.different.frontend`
4. Run `./gradlew bootRun` from the command line.
5. In your browser, navigate to `http://localhost:8888/helloworld?authorization=Bearer insert.your.access_token.from.the.Test.tab.of.the.associated.API.in.your.auth0.account`

## Deploying
1. Follow steps 1-3 above and be sure to edit the frontend url if deploying to a different frontend.
2. No special config variables or buildpacks needed.  Deploy and navigate to `https://your.deployed.site/helloworld?authorization=Bearer insert.your.access_token.from.the.Test.tab.of.the.associated.API.in.your.auth0.account`.
