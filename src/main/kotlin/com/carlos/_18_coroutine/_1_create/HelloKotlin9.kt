package com.carlos._18_coroutine

import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

fun main() = runBlocking {

    repeat(100000) {
        thread {
            Thread.sleep(1000)
            println("A")
        }
    }

    println("hello world")
}