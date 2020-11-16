package com.nobuhisaabe.instagramApp.component.model


data class GetInstagramRequest(
        val userId: String,
        val accessToken: String
) {

    fun getUrl(): String{
        return userId + "/media?access_token=" + accessToken
    }
}

