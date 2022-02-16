package com.carlos._18_coroutine._2_cancel

import kotlinx.coroutines.*

/**
 * kotlinx.coroutines包下的所有挂起函数都是可以取消的
 * 他们会检查协程的取消状态，当取消时就会抛出CancellationException异常
 *
 * 不过，如协程正处于某个计算过程当中，并且没有检查取消状态，那么它就无法被取消。如下例子：
 */
fun main() = runBlocking {
    var startTime = System.currentTimeMillis()
    var i = 0;
    val job = launch(Dispatchers.Default) {

//        coroutineContext[Job]?.isCancelled
//        while (i < 20 && this.isActive) {//检查取消状态
//            if (System.currentTimeMillis() > startTime) {
//                println("job : I am sleeping 2 ${i++}")
//                startTime += 500
//            }
//        }

        while (i < 20) {
            if (System.currentTimeMillis() > startTime) {
                println("job : I am sleeping ${i++}")
                startTime += 500
            }
        }


    }

    delay(1300)
    println("hello world ")
    job.cancelAndJoin()
    println("welcome")

}