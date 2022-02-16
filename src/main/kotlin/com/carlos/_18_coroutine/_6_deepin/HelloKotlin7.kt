package com.carlos._18_coroutine._6_deepin

import kotlinx.coroutines.*

/*
    ThreadLocal 相关
 */

val threadLocal = ThreadLocal<String>()

fun main() = runBlocking<Unit> {
    threadLocal.set("hello")
    println("pre main,current thread:${Thread.currentThread()}, threadLocal value:${threadLocal.get()}")

    val launch = launch(Dispatchers.Default + threadLocal.asContextElement("wold")) {
        println("launch start,current thread:${Thread.currentThread()}, threadLocal value:${threadLocal.get()}")
        yield()
        println("after yield,current thread:${Thread.currentThread()}, threadLocal value:${threadLocal.get()}")
    }
    launch.join()

    println("post main,current thread:${Thread.currentThread()}, threadLocal value:${threadLocal.get()}")
}

