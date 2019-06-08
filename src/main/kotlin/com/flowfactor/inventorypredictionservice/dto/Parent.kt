package com.flowfactor.inventorypredictionservice.dto


import com.fasterxml.jackson.annotation.JsonProperty

data class Parent(
    @JsonProperty("latt_long")
    val lattLong: String, // 52.883560,-1.974060
    @JsonProperty("location_type")
    val locationType: String, // Region / State / Province
    val title: String, // England
    val woeid: Int // 24554868
)