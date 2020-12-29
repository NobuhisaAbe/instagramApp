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

    @Value("\${spring.profiles.active}")
    val env: String = ""
    @Value("\${gcp.baseurl}")
    val gcpBaseUrl: String = ""
    @Value("\${instagram.baseurl}")
    val baseUrl: String = ""
    var userId: String = ""
    var accessToken: String = ""

    /**
     * 環境変数の初期化
     */
    fun initEnv() {
        if (env == "prod") {
            println("!!!!! enter prod section: " + env + " !!!!!")
            userId = getGcpMetaDataUserId()
            accessToken = getGcpMetaDataAccessToken()
        } else {
            println("!!!!! enter not prod section: " + env + "  !!!!!")
            userId = "\${instagram.userid}"
            accessToken = "\${instagram.accesstoken}"
        }
    }

    /**
     * ※productionのgcp環境のみ
     * instagram用のuseridを取得する。
     */
    fun getGcpMetaDataUserId(): String {
        println("!!!!! start getGcpMetaDataUserId() !!!!!")

        val url = gcpBaseUrl + "INSTAGRAM_USERID"
        println("!!!!!" + url + "!!!!!")
        val request: Request = Request.Builder().url(url).addHeader("Metadata-Flavor", "Google").get().build()
        println("!!!!! getGcpMetaDataUserId_request: " + request)

        val response: Response = OkHttpClient().newCall(request).execute()
        println("!!!!! getGcpMetaDataUserId_response: " + response)

        val userId: String = response.body()!!.string()
        println("!!!!! getGcpMetaDataUserId_userId: " + userId)

        println("!!!!! end getGcpMetaDataUserId() !!!!!")
        return userId

    }

    /**
     * ※productionのgcp環境のみ
     * instagram用のaccesstokenを取得する。
     */
    fun getGcpMetaDataAccessToken(): String {
        println("!!!!! start getGcpMetaDataAccessToken !!!!!")

        val url = gcpBaseUrl + "INSTAGRAM_ACCESSTOKEN"
        println("!!!!!" + url + "!!!!!")
        val request: Request = Request.Builder().url(url).addHeader("Metadata-Flavor", "Google").get().build()
        println("!!!!! getGcpMetaDataAccessToken_request: " + request)

        val response: Response = OkHttpClient().newCall(request).execute()
        println("!!!!! getGcpMetaDataAccessToken_response: " + response)

        val accessToken: String = response.body()!!.string()
        println("!!!!! getGcpMetaDataAccessToken_userId: " + accessToken)

        println("!!!!! end getGcpMetaDataUserId() !!!!!")
        return accessToken
    }

    /**
     * インスタグラム情報をapiで取得する。
     */
    fun getInstagram(): GetInstagramResponse {
        initEnv()
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
        initEnv()
        val url = baseUrl + GetInstagramMediaRequest(mediaId,accessToken).getUrl()
        val request: Request = Request.Builder().url(url).get().build()
        val response: Response = OkHttpClient().newCall(request).execute()
        val json: String? = response.body()?.string()
        val objectMapper: ObjectMapper =  ObjectMapper()
        val getInstagramMediaResponse: GetInstagramMediaResponse = objectMapper.readValue(json,GetInstagramMediaResponse::class.java)

        return getInstagramMediaResponse
    }

}