package com.carlos._18_coroutine._3_multi_suspend

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/*
    关于async的延迟执行

    我们可以通过将async方法的start参数设置为CoroutineStart.LAZY来实现协程的延迟执行
    在这种情况下，协程会在两种场景下去执行：调用Deferred的await方法或者调用Job的start方法。
 */
fun main()  = runBlocking {

    val totalTime = measureTimeMillis {
        val value1 = async(start = CoroutineStart.LAZY){ initValue1()}
        val value2 = async(start = CoroutineStart.LAZY){ initValue2()}

        println("hello world")
        Thread.sleep(6000)

        //尝试注释掉这两行代码，会变成串行执行
        value1.start()
        value2.start()


        //注意：如果不调用start方法，虽然await会触发协程的执行，但value2会等到value1执行完成之后才执行。这样就变成了串行执行，而不是并发
        val result1 = value1.await()
        val result2 = value2.await()

        println("$result1+$result2=${result1 + result2}")

    }
    println("total Times:$totalTime")

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
