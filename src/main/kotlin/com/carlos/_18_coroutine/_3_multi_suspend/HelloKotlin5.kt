package com.carlos._18_coroutine._3_multi_suspend

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/*
    使用async进行结构化并发程序开发
 */
fun main()  = runBlocking {
    val millis = measureTimeMillis {
        val initSum = initSum()
        println("result :$initSum")
    }
    println("total time:$millis")

}

//coroutineScope 待作用域中所有子协程完成其任务后才退出
//相关知识点可以回顾之前的内容
private suspend fun initSum() = coroutineScope {
    val value1 = async { initValue1() }
    val value2 = async { initValue2() }
//    return@coroutineScope value1.await() + value2.await()
    value1.await() + value2.await()
}

private suspend fun initValue1(): Int {
    delay(2000)
    return 13

}

private suspend fun initValue2(): Int {
    delay(3000)
    return 14

}