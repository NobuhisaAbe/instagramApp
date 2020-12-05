package com.nobuhisaabe.instagramApp.component

import com.fasterxml.jackson.databind.ObjectMapper
import com.nobuhisaabe.instagramApp.component.model.GetInstagramMediaRequest
import com.nobuhisaabe.instagramApp.component.model.GetInstagramMediaResponse
import com.nobuhisaabe.instagramApp.component.model.GetInstagramRequest
import com.nobuhisaabe.instagramApp.component.model.GetInstagramResponse
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class InstagramApiComponent() {

    @Value("\${instagram.baseurl}")
    val baseUrl: String = ""
    @Value("\${instagram.userid}")
    val userId: String = ""
    @Value("\${instagram.accesstoken}")
    val accessToken: String = ""

    /**
     * インスタグラム情報をapiで取得する。
     */
    fun getInstagram(): GetInstagramResponse {
        val url = baseUrl + GetInstagramRequest(userId,accessToken).getUrl()
        val request: Request = Request.Builder().url(url).get().build()
        val response: Response = OkHttpClient().newCall(request).execute()
        val json: String? = response.body()?.string()
        val objectMapper: ObjectMapper =  ObjectMapper()
        val getInstagramResponse: GetInstagramResponse = objectMapper.readValue(json,GetInstagramResponse::class.java)

        return getInstagramResponse
    }

    /**
     * インスタグラムのmedia情報をapiで取得する。
     */
    fun getInstagramMedia(mediaId: String): GetInstagramMediaResponse {

        val url = baseUrl + GetInstagramMediaRequest(mediaId,accessToken).getUrl()
        val request: Request = Request.Builder().url(url).get().build()
        val response: Response = OkHttpClient().newCall(request).execute()
        val json: String? = response.body()?.string()
        val objectMapper: ObjectMapper =  ObjectMapper()
        val getInstagramMediaResponse: GetInstagramMediaResponse = objectMapper.readValue(json,GetInstagramMediaResponse::class.java)

        return getInstagramMediaResponse
    }

}