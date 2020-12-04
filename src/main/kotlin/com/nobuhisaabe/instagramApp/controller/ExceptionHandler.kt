package com.nobuhisaabe.instagramApp.controller

import com.nobuhisaabe.instagramApp.component.SlackApiComponent
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus


@ControllerAdvice
class ExceptionHandler(
        private val slackApiComponent: SlackApiComponent
) {

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleException(exception: Exception): String {
        var message: String
        val newLine: String = "\n"

        message = "<message>" + newLine + exception.message.toString() + newLine
        message += "<stackTrace>" + newLine
        for (element in exception.stackTrace) {
            message += element.toString() + newLine
        }
        slackApiComponent.plainMessage("#app_message", message)
        return "error"
    }
}