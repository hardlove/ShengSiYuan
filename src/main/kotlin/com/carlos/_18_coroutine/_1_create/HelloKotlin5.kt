package com.carlos._18_coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    //job后台运行的一个任务，有生命周期，可取消
    val job = GlobalScope.launch {
        delay(1000)
        println("Kotlin Coroutine")

    }
    println("Hello")
    job.join()//挂起当前携程，直到job任务完成
    println("World")
}