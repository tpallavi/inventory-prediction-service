package com.flowfactor.inventorypredictionservice

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(value = [SpringExtension::class])

@SpringBootTest(
    classes = arrayOf(InventoryPredictionServiceApplication::class),
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class InventoryPredictionServiceApplicationTests {

}
