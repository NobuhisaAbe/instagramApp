package com.nobuhisaabe.instagramApp.component.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class GetInstagramMediaResponse(
        @JsonProperty("id") val id: String,
        @JsonProperty("media_type")val mediaType: String,
        @JsonProperty("media_url") val mediaUrl: String
)