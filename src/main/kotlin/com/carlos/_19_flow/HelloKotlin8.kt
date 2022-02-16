package com.carlos._19_flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/*
    Flow中间操作

    Flow的中间运算符的思想与Java Stream是完全一致的。

    Flow与Sequence之间在中间运算符上的重要差别在于：对于Flow来说，这些中间运算符内的代码块是可以调用挂起函数的。
 */

fun main() = runBlocking {
    flowOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        .filter { it > 3 }
        .map {
            delay(1000L)
            "hello $it"
        }
        .collect { println(it) }


}