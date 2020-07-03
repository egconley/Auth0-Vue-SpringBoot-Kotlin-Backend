package com.egconley.MovieReviewBoard.Security

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer

@Configuration
@EnableResourceServer
// Automatically enables a Spring Security filter that authenticates incoming requests.
class SecurityConfig : ResourceServerConfigurerAdapter() {

    @Value("\${security.oauth2.resource.id}")
    private lateinit var resourceId: String

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
                .mvcMatchers("/helloworld").authenticated()
                .anyRequest().permitAll()
    }

    @Throws(Exception::class)
    override fun configure(resources: ResourceServerSecurityConfigurer) {
        resources.resourceId(resourceId)
    }
}