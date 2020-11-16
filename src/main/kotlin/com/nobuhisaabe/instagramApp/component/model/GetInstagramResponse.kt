package com.nobuhisaabe.instagramApp.component.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class GetInstagramResponse (
        @JsonProperty("data") val data: List<Data>,
        @JsonProperty("paging") val paging: Paging
)
data class Data (
        @JsonProperty("id") val id: String
)
data class Paging (
        @JsonProperty("cursors") val cursors: Cursors
)
data class Cursors  (
        @JsonProperty("before") val before: String,
        @JsonProperty("after") val after: String
)