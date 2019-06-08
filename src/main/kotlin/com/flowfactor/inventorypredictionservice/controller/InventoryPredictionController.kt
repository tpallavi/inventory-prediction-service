package com.flowfactor.inventorypredictionservice.controller

import com.flowfactor.inventorypredictionservice.dto.ItemInventoryDTO
import com.flowfactor.inventorypredictionservice.service.InventoryPredictionService
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
//curl http://localhost:8080/prediction/1/2
@RestController
@RequestMapping("/prediction")
class InventoryPredictionController(private val inventoryPredictionService: InventoryPredictionService) {
    @GetMapping(value = ["/{storeId}/{sku}"])
    fun getAnticipatedSku(
        @PathVariable("storeId") storeId: Long?, @PathVariable("sku") sku: Long?
    ): ResponseEntity<ItemInventoryDTO> {
        return ok(inventoryPredictionService.getAnticipatedInventoryForSkuAndBranch(storeId.toString(), sku.toString()))
    }

}