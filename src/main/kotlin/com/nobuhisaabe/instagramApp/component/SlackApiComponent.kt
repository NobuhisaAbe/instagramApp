package com.nobuhisaabe.instagramApp.component

import com.slack.api.Slack
import com.slack.api.methods.kotlin_extension.request.chat.blocks
import com.slack.api.methods.request.chat.ChatPostMessageRequest
import com.slack.api.methods.response.chat.ChatPostMessageResponse
import com.slack.api.model.block.Blocks.divider
import com.slack.api.model.block.Blocks.section
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.servlet.function.RequestPredicates.methods


@Component
class SlackApiComponent() {

    val slack = Slack.getInstance()
    @Value("\${slack.token}")
    val token: String = ""

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