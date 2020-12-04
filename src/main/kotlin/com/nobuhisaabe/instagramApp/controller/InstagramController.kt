package com.nobuhisaabe.instagramApp.controller

import com.nobuhisaabe.instagramApp.component.SlackApiComponent
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping


@Controller
class InstagramController(){
    @RequestMapping("/instagram")
    fun instagram(): String {
        return "index"
    }
}