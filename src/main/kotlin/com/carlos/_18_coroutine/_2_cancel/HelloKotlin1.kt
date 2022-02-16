package com.carlos._18_coroutine._2_cancel

import kotlinx.coroutines.*

fun main() = runBlocking {
    val job = GlobalScope.launch {
        repeat(200) {
            delay(200)
            println("$it")
        }
    }
    delay(1100)
    println("hello world")
    launch {
        job.cancel()
//        job.cancel(CancellationException("just a try"))//指定取消原因
    }

//    job.cancel()//调用cancel并不是立刻就能完成取消
//    job.join()//挂起协程，直到job完成

//    job.cancelAndJoin()

    delay(10000)


    println("finish")
}
