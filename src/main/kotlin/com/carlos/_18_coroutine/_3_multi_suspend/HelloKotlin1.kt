package com.carlos._18_coroutine._3_multi_suspend

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/*
    挂起函数的组合
 */

fun main() = runBlocking {

    val totals = measureTimeMillis {
        //串行执行
        val initValue1 = initValue1()
        val initValue2 = initValue2()
        println("$initValue1+$initValue2 = ${initValue1 + initValue2}")
    }

    println("totals:$totals")


}

private suspend fun initValue1(): Int {
    delay(5000)
    println("initValue1")
    return 13

}


private suspend fun initValue2(): Int {
    delay(5000)
    println("initValue2")
    return 14

}