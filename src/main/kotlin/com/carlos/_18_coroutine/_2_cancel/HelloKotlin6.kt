package com.carlos._18_coroutine._2_cancel

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

/*
   我们在使用协程时，如果取消了协程，那么很大一部分原因在于协程的执行实际超过了我们的设定值。我们可以通过手工引用于协程对应的job的方式来启动一个单独的协程用于取消这个协程，
   不过kotlin提供了一个内建函数帮助我们又快又好的做到这一点
 */

fun main()  = runBlocking {
    withTimeout(1900){//限制协程只能执行1900毫秒
        repeat(1000){
            println("hello $it")
            delay(200)
        }
    }
}