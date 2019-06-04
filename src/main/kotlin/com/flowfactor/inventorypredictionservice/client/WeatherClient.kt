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

    fun getLocation() {
        logger.info("Getting all Verification Methods from VerifyInvestor")

        val url = "https://www.metaweather.com/api/location/search/?query=san"
        val getBookingResponse = restTemplate.getForEntity(URI.create(url), String::class.java)
//        return restTemplate.exchange(
//                uri("/verification_requests/verification_methods"),
//                HttpMethod.GET,
//                restTemplateConfig.httpHeaders(null),
//                typeRef<VerificationMethodsDto<VerificationMethodDto>>()
//        ).body!!
    }
}