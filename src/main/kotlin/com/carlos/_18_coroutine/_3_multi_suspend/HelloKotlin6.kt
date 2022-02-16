package com.carlos._18_coroutine._3_multi_suspend

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/*
    关于协程的异常与取消问题

    协程的取消总是会沿着协程的层次体系向上进行传播
 */
fun main() = runBlocking<Unit> {
    try {
        failureComputation()
    } finally {
        println("computation failed")
    }

}

suspend fun failureComputation(): Int = coroutineScope {
    val value1 = async {
        try {
            delay(100000)
            50
        } finally {
            println("value1 was cancelled")
        }
    }
    val value2 = async<Int> {
        delay(2000)
        println("value2 was cancelled")
        throw Exception()
    }

    value1.await() + value2.await()

}