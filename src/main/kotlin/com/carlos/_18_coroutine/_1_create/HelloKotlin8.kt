package com.carlos._18_coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 协程是轻量级的
 */
fun main() = runBlocking {
    repeat(100000) {
        launch {
            delay(1000)
            println(it)
            println("A")
        }
    }

    repeat(100000, action = {it->
        launch {
            delay(1000)
            println(it)
            println("B")
        }
    })

    println("hello world")
}

//fun main() = runBlocking {
//
//    repeat(100000) {
//        thread {
//            Thread.sleep(1000)
//            println("A")
//        }
//    }
//
//    println("hello world")
//}