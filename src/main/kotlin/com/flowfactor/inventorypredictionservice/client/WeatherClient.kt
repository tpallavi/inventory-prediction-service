package com.flowfactor.inventorypredictionservice.client

import com.flowfactor.inventorypredictionservice.config.RestTemplateConfig
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.net.URI

@Service
class WeatherClient(
    @Autowired
    private val restTemplate: RestTemplate,
    @Autowired
    private val restTemplateConfig: RestTemplateConfig) {

    private val logger = KotlinLogging.logger(this.javaClass.canonicalName)

    fun getLocation() : String {
        logger.info("Getting location for London")

        val url = "https://www.metaweather.com/api/location/search/?query=London"
       val getBookingResponse = restTemplate.getForEntity(URI.create(url), String::class.java)
       // println(getBookingResponse.body)
        return getBookingResponse.body!!
        //return ""
//        return restTemplate.exchange(
//                uri("/verification_requests/verification_methods"),
//                HttpMethod.GET,
//                restTemplateConfig.httpHeaders(null),
//                typeRef<VerificationMethodsDto<VerificationMethodDto>>()
//        ).body!!
    }
}