package com.carlos._19_flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.runBlocking

/*
    类似于catch运算符，onCompletion只会看到来自Flow上游的异常，但看不到Flow下游的异常

    已过时，新版本的已经可以观察到下游异常
 */

private fun myMethod(): Flow<Int> = (1..10).asFlow()
fun main() = runBlocking {
    myMethod().onCompletion { cause -> println("Flow Completion with $cause") }
        .collect {
            check(it <= 1) { "Collected $it" }
            println(it)
        }

}