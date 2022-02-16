package com.carlos._18_coroutine._3_multi_suspend

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

/*
    异步风格的函数
 */

fun main() {
    val elapsedTime = measureTimeMillis {
        val value1 = initValue1Async()
        val value2 = initValue2Async()
        runBlocking {
            println("the result is:${value1.await() + value2.await()}")
        }

    }


    print("total time:$elapsedTime")
}


private suspend fun initValue1(): Int {
    delay(2000)
    return 13

}

private suspend fun initValue2(): Int {
    delay(3000)
    return 14

}

private fun initValue1Async() = GlobalScope.async {
    initValue1()
}

//private fun initValue1Async(): Deferred<Int> = GlobalScope.async {
//    initValue1()
//}

//private val initValue2Async = GlobalScope.async {
//    initValue2()
//}

private fun initValue2Async() = GlobalScope.async {
    initValue2()
}