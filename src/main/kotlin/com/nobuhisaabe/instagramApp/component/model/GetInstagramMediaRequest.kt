package com.nobuhisaabe.instagramApp.component.model

import org.springframework.beans.factory.annotation.Value

data class GetInstagramMediaRequest(
        val mediaId: String,
        val accessToken: String
) {
    @Value("\${instagram_api.baseurl}")
    val baseUrl: String = ""

    fun getUrl(): String{
        return baseUrl + mediaId + "?fields=id,media_type,media_url&access_token=" + accessToken
    }
}