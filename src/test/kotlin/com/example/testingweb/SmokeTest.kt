package com.example.testingweb

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class SmokeTest(@Autowired val controller: HomeController) {

    @Test
    fun contextLoads() {
        assertThat(controller).isNotNull
    }
}