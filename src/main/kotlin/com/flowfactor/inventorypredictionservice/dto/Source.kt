package com.flowfactor.inventorypredictionservice.dto


import com.fasterxml.jackson.annotation.JsonProperty

data class Source(
    @JsonProperty("crawl_rate")
    val crawlRate: Int, // 180
    val slug: String, // yahoo
    val title: String, // Yahoo
    val url: String // http://weather.yahoo.com/
)