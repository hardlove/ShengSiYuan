package com.carlos._18_coroutine._6_deepin

import kotlinx.coroutines.*

/*
    父子协程之间的关系
    当一个协程是通过另外一个协程的CoroutineScope来启动的，那么这个协程就会通过CoroutineScope.coroutineContext来继承其上下文信息，
    同时，新协程的Job就会成为父协程Job的一个孩子；当父协程被取消执行时，该父协程的所有孩子都会通过递归的方式一并取消执行。

    特殊情况:当我们使用GlobalScope来启动协程时，对应启动的新协程来说，其Job是没有父Job的。因此，它就不会绑定到其所启动的那个范围上，古其可以独立执行（这是一种特殊情况）
 */

fun main() = runBlocking<Unit> {
    val job = launch {
        async {
            repeat(1000) {
                println("child 1 --> $it")
                delay(100)
            }
        }
        async {
            repeat(1000) {
                println("child 2 --> $it")
                delay(100)
            }
        }


        GlobalScope.launch {
            repeat(1000) {
                println("GlobalScope.launch  --> $it")
                delay(100)
            }
        }
    }

    delay(2000)
    job.cancel()
    delay(2000)
    println("finish")
}