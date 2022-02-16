package com.carlos._18_coroutine._6_deepin

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/*
    CoroutineName 上下文元素可以让我们对协程命名，以便能够输入可读性较好的日志信息
    使用JVM参数:-Dkotlinx.coroutines.debug


    eg:
    [main @main#1] hello // main x线程中的第一个协程
    [main @coroutine1#2] coroutine1 log // main x线程中的第二个协程
    [main @coroutine2#3] coroutine2 log // main x线程中的第三个协程
    [main @main#1] result is 40
 */


private fun log(logMessage: String) = println("[${Thread.currentThread().name}] $logMessage")

fun main() = runBlocking<Unit>(CoroutineName("main")) {
    log("hello")

   val value1 = async(CoroutineName("coroutine1")){
       delay(1000)
       log("coroutine1 log")
       20
    }

    val value2 = async(CoroutineName("coroutine2")){
        delay(1000)
        log("coroutine2 log")
        20
    }

    log("result is ${value1.await() + value2.await()}")



}
