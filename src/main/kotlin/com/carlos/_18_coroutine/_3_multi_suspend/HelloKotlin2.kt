package com.carlos._18_coroutine._3_multi_suspend

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis


/*
    使用async和await实现并发

    从概念上，async就像是launch一样，它会开启一个单独的协程，这个协程是一个轻量级的线程，可以与其它协程并发工作。
    区别在于，launch会返回一个Job，但是Job并不会持有任何结果值；而async会返回一个Deferred，这是一个轻量级的非阻塞的future。
    它代表一个promise，可以在稍后提供一个结果值。
 */

fun main() = runBlocking {

    val totals = measureTimeMillis {
        //并发执行
        val initValue1 = async { initValue1()}
        val initValue2 = async { initValue2() }
        println("${initValue1.await()}+${initValue2.await()} = ${initValue1.await() + initValue2.await()}")
    }

    println("totals:$totals")


}

private suspend fun initValue1(): Int {
    delay(5000)
    println("initValue1")
    return 13

}


private suspend fun initValue2(): Int {
    delay(5000)
    println("initValue2")
    return 14

}