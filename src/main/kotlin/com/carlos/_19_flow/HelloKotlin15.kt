package com.carlos._19_flow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.runBlocking


/*
    flowOn
    借助于flowOn，可以让Flow在发射元素是所处的上下文于收集（终止操作）时所处的上下文是不同的。
    值得注意的是：flowOn运算符改变了Flow本身默认的顺序性。
    现在，收集操作实际上是发生在一个协程当中，而发生操作发生在另外一个协程当中（这一点至关重要）。
    flow运算符本质上会改变上下文中的CoroutineDispatcher，并且为上游flow创建另外一个协程。
 */

private fun log(msg: String) = println("[${Thread.currentThread().name}],$msg")
private fun myMethod(): Flow<Int> = flow {
    for (i in 1..3) {
        Thread.sleep(2000L)
        emit(i)
        log("Emit：$i")
    }
}.flowOn(Dispatchers.Default)

fun main() = runBlocking {
    myMethod().collect { log("Collect:$it") }


    log("finished")


}