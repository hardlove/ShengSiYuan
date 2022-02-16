package com.carlos._19_flow

import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking

/*
    限定数量的中间操作


 */
fun myNumbers(): kotlinx.coroutines.flow.Flow<Int> = flow {

    try {
        emit(1)
        emit(2)
        emit(3)
    } catch (e: Exception) {
        println(e)

    } finally {
        println("finished")
    }
}

fun main() = runBlocking {
    myNumbers().take(2)//实际上是通过异常来限定
        .collect { println(it) }

}