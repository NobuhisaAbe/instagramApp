package com.nobuhisaabe.instagramApp.component

import com.slack.api.Slack
import com.slack.api.methods.kotlin_extension.request.chat.blocks
import com.slack.api.methods.request.chat.ChatPostMessageRequest
import com.slack.api.methods.response.chat.ChatPostMessageResponse
import com.slack.api.model.block.Blocks.divider
import com.slack.api.model.block.Blocks.section
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.servlet.function.RequestPredicates.methods


@Component
class SlackApiComponent() {

    @Value("\${spring.profiles.active}")
    val env: String = ""
    @Value("\${gcp.baseurl}")
    val gcpBaseUrl: String = ""
    val slack = Slack.getInstance()
    var token: String = ""

    init {
        if (env == "prod") {
            token = getGcpMetaDataAccessToken()
        } else {
            token = "\${slack.token}"
        }
    }

    /**
     * ※productionのgcp環境のみ
     * slack用のaccesstokenを取得する。
     */
    fun getGcpMetaDataAccessToken(): String {
        println("!!!!! start getGcpMetaDataAccessToken !!!!!")

        val url = gcpBaseUrl + "SLACK_TOKEN"
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

    fun plainMessage(channel: String, message: String) {
        val request = ChatPostMessageRequest.builder()
                .channel(channel)
                .text(message)
                .build()
        val response: ChatPostMessageResponse = slack.methods(token).chatPostMessage(request)
    }

    fun blockMessage(channel: String, message: String) {
        val response = slack.methods(token).chatPostMessage { req -> req
                .channel(channel)
                .blocks {
                    section {
                        // "text" フィールドは plainText() や markdownText() を使って構築できます
                        markdownText("Hey <@U01DX3EQL5N>, thanks for submitting your report!")
                    }
                    divider()
/*
                    actions {
                        // JSON の構造と揃えるなら、ここに elements { } のブロックを置くこともできますが、省略しても構いません
                        // これは section ブロックの accessory についても同様です
                        button {
                            // plain_text だけを受け付けている場合は、plain_text 型の入力だけを受け付けます
                            text("Farmhouse", emoji = true)
                            value("v1")
                        }
                        button {
                            text("Kin Khao", emoji = true)
                            value("v2")
                        }
                    }
 */
                }
        }
    }
}