package com.nobuhisaabe.instagramApp.controller

import com.nobuhisaabe.instagramApp.domain.model.Instagram
import com.nobuhisaabe.instagramApp.service.InstagramService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class InstagramRestController(
        private val instagramService: InstagramService
){
    @RequestMapping("/instagram/v1/get/instagramlist")
    fun getInstagramList(): Instagram {
        return instagramService.getInstagram()
    }
}