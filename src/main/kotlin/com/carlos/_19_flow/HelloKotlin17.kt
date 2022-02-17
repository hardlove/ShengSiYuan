package com.carlos._19_flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis


/*
    Buffer （缓冲）
    有Buffer

    buffer的主要作用在于对发射的缓冲，减少等待时间。
    实际上，flowOn运算符本质上在遇到需要改变CoroutineDispatcher时也会使用同样的缓冲机制，只不过该实例并没有
    改变执行上下文而已。即，buffer没有改变上下文，而flowOn改变了上下文
 */
private fun myMethod() : Flow<Int> = flow {
    repeat(4) {
        delay(200L)//模拟了一个较为耗时的操作，该操作时候才开始流元素的发射
        emit(it)

    }

}

fun main() = runBlocking {
    val time = measureTimeMillis {
        myMethod()
            .buffer()//增加缓冲
            .collect {
            delay(300L)
            println(it) }
    }
    println("time:$time")
}
