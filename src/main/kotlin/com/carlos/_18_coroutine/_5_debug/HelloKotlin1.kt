package com.carlos._18_coroutine._5_debug

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/*
    协程的调试:使用JVM参数
    vm options: -Dkotlinx.coroutines.debug,加入该参数后，在打印线程名字的同时会打印相应的协程的名字
    一个线程下可以执行多个协程
 */
fun main() = runBlocking<Unit> {

    val a = async {
        log("hello world")
        delay(10000)
//        Thread.sleep(10000)
        10
    }
    val b = async {
        log("welcome")
        delay(10000)
        20
    }

    log("the result is ${a.await()+b.await()}")

}


private fun log(logMessage: String) = println("[${Thread.currentThread().name}] $logMessage")
