package com.carlos._19_flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

/*
    Flow的取消

    Flow的取消实际上于协程的取消之间是一种协同的关系。对于Flow来说，它自身并没有引入任何新的取消点这样的概念，它对于取消是完全透明的。

    Flow的收集操作是可以取消的，前提是Flow在一个可以取消的挂起函数（如delay）中被挂起了，除此之外，我们无法通过其他方式来取消Flow的执行。
 */
private fun myMethod() : Flow<Int> = flow {
    for (i in 1..4) {
        kotlinx.coroutines.delay(200)
        println("emit value:$i")
        emit(i)
    }
}
fun main() = runBlocking {
    withTimeoutOrNull(500){
        myMethod().collect {
            println(it)
        }

    }
    println("finish")
}