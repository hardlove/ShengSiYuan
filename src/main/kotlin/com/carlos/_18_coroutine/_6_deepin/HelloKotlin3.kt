package com.carlos._18_coroutine._6_deepin

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
    对于父子协程来说，父协程总是会等待其所有子协程的完成。对于父协程来说，它不必显示地去追踪由它所启动的所有子协程，同时也不必调用Job.join方法来等待子协程的完成。
 */
fun main() = runBlocking<Unit> {
    val job = launch {
        //开启5个子协程
        repeat(5) { i ->
            launch {
                delay((i + 1) * 1000L)
                println("coroutine $i 执行完毕")
            }
        }
        println("hello")
    }
    //挂起父协程，直到job完成
    job.join()
    println("world")
}