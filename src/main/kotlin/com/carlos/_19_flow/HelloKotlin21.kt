package com.carlos._19_flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

/*
    Flow Exception
 */
private fun myMethod(): Flow<Int> = flow {
    for (i in 1..3) {
        println("Emitting $i")
        emit(i)
        //发射端抛出异常
        check(i <= 1) {
            "Collected $i"
        }
    }
}

fun main() = runBlocking<Unit> {
    try {
        myMethod()
            .collect {
                println(it)
            }

    } catch (e: Exception) {
        println("Catch:$e")

    } finally {
    }

}