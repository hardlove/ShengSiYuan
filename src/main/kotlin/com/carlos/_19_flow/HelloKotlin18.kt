package com.carlos._19_flow

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.runBlocking

/*
    Flow的组合
 */

fun main() = runBlocking<Unit> {

    val nums = (1..5).asFlow()
    val strs = flowOf("one", "two", "three", "four", "five")
    nums.zip(strs) { x: Int, y: String ->
        "$x->$y"
    }.collect { println(it) }

}