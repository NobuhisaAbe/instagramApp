package com.example.demo.controller

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class SampleControllerTest {

    @BeforeEach
    fun init() = println("init")

    @Test
    @DisplayName("succeeding test")
    fun success() {
        assertEquals(2,1+1)
    }

    @Test
    @Disabled("skipping test")
    fun skip() = println("skipp")
}


