package com.carlos._19_flow

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import java.lang.RuntimeException

/*
    Flow完成的声明式方法
    对于声明式来说，Flow提供了一个名为onCompletion中间操作，该操作会在Flow完成收集后得到调用

    onCompletion中间操作的一个优势在于它有一个可空的Throwable参数，可用作确定Flow的收集操作是正常完成还是异常完成的。
 */
private fun myMethod(): Flow<Int> = flow {
    emit(1)
    throw RuntimeException()
}


fun main() = runBlocking<Unit> {
    myMethod().onCompletion { cause ->
        if (cause != null) {
            println("onCompletion throwalbe:$cause")
        }
    }.catch { cause -> println("catch entered") }
        .collect { println(it) }

}

