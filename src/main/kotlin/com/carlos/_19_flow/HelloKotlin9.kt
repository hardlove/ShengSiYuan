package com.carlos._19_flow

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.runBlocking

/*
    transform


 */

fun main() = runBlocking<Unit> {
    (1..10).asFlow()
        .transform { input ->
            emit("my input :$input")
            emit("hello world")
        }.collect { println(it) }

}