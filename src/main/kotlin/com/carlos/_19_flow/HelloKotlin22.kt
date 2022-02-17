package com.carlos._19_flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking


/*
    Flow的完成
    Kotlin提供两种方式来实现Flow的完成
    1.命令式
    2.声明式
 */
private fun myMethod(): Flow<Int> = (1..10).asFlow()

fun main() = runBlocking<Unit> {
    //命令式
    try {
        myMethod().collect { println(it) }
    } finally {
        println("finish")

    }

    var name:String? = "CL"
    name = null

    run { }
    name.run {

        println("run.........")
    }
    name.apply {

    }
    name?.let {
        println("name?.let.........$it")
    }
    name.let {
        println("name.let.........$it")
    }
    name.also {

    }
    with(name) {}
    name.takeIf { true }
    name.takeUnless { true }

    repeat(2) {

    }

    println("===========")

}