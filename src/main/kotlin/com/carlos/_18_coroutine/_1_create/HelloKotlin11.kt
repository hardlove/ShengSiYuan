package com.carlos._18_coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 被suspend关键字修饰的函数叫做挂起函数
 * 挂起函数（suspend function）
 * 挂起函数只能用在协程或者另外一个挂起函数中
 */
fun main() = runBlocking {
    launch {
        hello()
    }
    println("....")

}

suspend fun hello() {
    delay(200)
    println("hello 1")
    world()
    delay(1000)
    println("hello 2")

}

suspend fun world() {
    delay(4000)
    println("world")
}
