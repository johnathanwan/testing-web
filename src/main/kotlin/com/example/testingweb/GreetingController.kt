package com.example.testingweb

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.*
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class GreetingController {

    @Autowired
    val service: GreetingService? = null

    @RequestMapping("/greeting")
    @ResponseBody
    fun greeting() = service!!.greet()
}

