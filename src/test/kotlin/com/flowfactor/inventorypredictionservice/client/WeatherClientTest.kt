package com.flowfactor.inventorypredictionservice.client

import com.flowfactor.inventorypredictionservice.config.RestTemplateConfig
import io.specto.hoverfly.junit.core.Hoverfly
import io.specto.hoverfly.junit5.HoverflyExtension
import io.specto.hoverfly.junit5.api.HoverflyConfig
import io.specto.hoverfly.junit5.api.HoverflySimulate
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.web.client.RestTemplate
import okhttp3.OkHttpClient
import okhttp3.Request


//@HoverflyCore(mode = HoverflyMode.CAPTURE, config = HoverflyConfig(adminPort = 9888, proxyPort = 9500))
//@HoverflyCapture(path = "src/test/resources/hoverfly",
//        filename = "captured-simulation.json",
//        config = HoverflyConfig(captureAllHeaders = true, proxyLocalHost = true))
@HoverflySimulate(source = HoverflySimulate.Source(value = "src/test/resources/hoverfly/captured-simulation.json",
        type = HoverflySimulate.SourceType.FILE),
        config = HoverflyConfig(captureAllHeaders = true, proxyLocalHost = true),enableAutoCapture = true)
@ExtendWith(SpringExtension::class, HoverflyExtension::class)
@SpringBootTest(classes = arrayOf(RestTemplateConfig::class,WeatherClient::class))
class WeatherClientTest {

    @Autowired
    lateinit var restTemplate: RestTemplate
    @Autowired
    lateinit var weatherClient: WeatherClient

    @Test
    fun testWeather(hoverfly: Hoverfly) {
       hoverfly.start()
  //      hoverfly.simulate (SimulationSource.file(Paths.get("src/test/resources/simulation.json")))
//        val url = "https://www.metaweather.com/api/location/search/?query=London"
//        val getBookingResponse = restTemplate.getForEntity(URI.create(url), String::class.java)
//         println(getBookingResponse.body)

        val sslConfigurer = hoverfly.getSslConfigurer()
        val okHttpClient = OkHttpClient.Builder()
                .sslSocketFactory(sslConfigurer.getSslContext().getSocketFactory(), sslConfigurer.getTrustManager())
                .build()
        val request = Request.Builder()
                .url("https://www.metaweather.com/api/location/search/?query=London")
                .build()

        val response = okHttpClient.newCall(request).execute()

        //return getBookingResponse.body!!
//        val output = weatherClient.getLocation()
//        assertEquals("[{\"title\":\"London\",\"location_type\":\"City\",\"woeid\":44418,\"latt_long\":\"51.506321,-0.12714\"}]", output)
//        hoverfly.exportSimulation(Paths.get("src/test/resources/simulation.json"));
    //    hoverfly.reset();

    }


}