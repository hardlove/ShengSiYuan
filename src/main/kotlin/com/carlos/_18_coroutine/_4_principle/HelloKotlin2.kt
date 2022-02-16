package com.carlos._18_coroutine._4_principle

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
    Dispatchers.Unconfined

    Dispatchers.Unconfined协程分发器会在调用者线程中去启动协程，但仅仅会持续到第一个挂起的；当挂起结束后程序恢复执行，它会继续
    协程代码的执行，但这时执行协程的线程是由之前所调用的挂起函数来决定（这个挂起函数是由哪个线程来执行的，那么后面的代码就会由这个线程来执行）。
    Dispatchers.Unconfined协程分发器适用于这样的一些协程：它既不会消耗CPU时间，同时也不会更新任何共享的数据（特定具体的线程）

    Dispatchers.Unconfined是一种高级的机制，它对于某些特殊的情况是有很好的帮助作用的：协程执行的分发是不需要的，或者会产生意料之外的副作用，
    这是因为协程中的操作必须要立刻执行。
 */

fun main() = runBlocking {
    launch(Dispatchers.Unconfined)
    {
        println("Dispatchers.Unconfined, thread:${Thread.currentThread().name}")// 第一个挂起点
        delay(300)//可以反推delay执行的线程：Dispatchers.Unconfined, thread:kotlinx.coroutines.DefaultExecutor
        println("Dispatchers.Unconfined, thread:${Thread.currentThread().name}")//Dispatchers.Unconfined, thread:kotlinx.coroutines.DefaultExecutor
    }
    launch {
        println("no params, thread:${Thread.currentThread().name}")
        delay(300)
        println("no params, thread:${Thread.currentThread().name}")
    }
    Unit
}