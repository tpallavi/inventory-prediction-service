package com.flowfactor.inventorypredictionservice.dto

data class ItemInventoryDTO(var sku: Long? = null,
                       var description: String? = null,
                       var quantity: Int = 0
                       )