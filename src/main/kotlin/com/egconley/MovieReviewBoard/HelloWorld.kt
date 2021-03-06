package com.egconley.MovieReviewBoard

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.core.Ordered
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter
import java.util.*
import javax.servlet.Filter

@RestController
@EnableResourceServer
class HelloWorldController {

    @Value("\${frontend}")
    private lateinit var frontendurl: String

    @GetMapping("/helloworld")
    fun greet(): String {
        return "helloworld!"
    }

    // Adds cross-origin support to the backend API.
    // Sets the Access-Control-Allow-Origin header on HTTP responses sent by the server.
    // Setting the value of this header to http://localhost:8080 signals the browser
    // that it is okay for this domain to make a request to the server.
    @Bean
    fun simpleCorsFilter(): FilterRegistrationBean<*> {
        val source = UrlBasedCorsConfigurationSource()
        val config = CorsConfiguration()
        config.allowCredentials = true
        // *** URL below needs to match the Vue client URL and port ***
        config.allowedOrigins = Collections.singletonList(frontendurl)
        config.allowedMethods = Collections.singletonList("*")
        config.allowedHeaders = Collections.singletonList("*")
        source.registerCorsConfiguration("/**", config)
        val bean = FilterRegistrationBean<Filter>(CorsFilter(source))
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE)
        return bean
    }
}