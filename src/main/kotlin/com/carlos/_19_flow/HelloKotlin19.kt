package com.carlos._19_flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/*
    Flow的打平

    Flatten Flow

    Flow<Flow<Int>> --> Flow<Int>
    将二维的Flow转成一维的Flow
 */

private fun myMethod(i: Int): Flow<String> = flow {
    emit("$i:First")
    kotlinx.coroutines.delay(200)
    emit("$i:Second")

}

fun main() = runBlocking {

    val startTime = System.currentTimeMillis()
    (1..3).asFlow()
        .onEach { delay(100) }
        .flatMapConcat { i -> myMethod(i) }
        .collect { println("$it at ${System.currentTimeMillis() - startTime} ms") }


}