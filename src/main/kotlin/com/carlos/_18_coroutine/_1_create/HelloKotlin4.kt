package com.carlos._18_coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * runBlocking{} 创建一个新的携程并阻塞当前线程
 * 一般只在main()方法或测试中才使用
 */
fun main()  = runBlocking {
    GlobalScope.launch {//启动一个后台协程
        delay(1000)
        println("Kotlin Coroutine")
    }
    println("Hello")
    delay(2000)
    println("world")

}