package com.carlos._19_flow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext


private fun log(msg: String) = println("[${Thread.currentThread().name}],$msg")
private fun myMethod(): Flow<Int> = flow {

//    withContext(Dispatchers.Default) {
//        log("started")
//        for (i in 1..3) {
//            Thread.sleep(2000L)
//            emit(i)
//        }
//    }
    /*
    Exception in thread "main" java.lang.IllegalStateException: Flow invariant is violated:
		Flow was collected in [BlockingCoroutine{Active}@16031dc2, BlockingEventLoop@16099ef2],
		but emission happened in [DispatchedCoroutine{Active}@49b0a063, Dispatchers.Default].
		Please refer to 'flow' documentation or use 'flowOn' instead
     */

    log("started")
    for (i in 1..3) {
        Thread.sleep(2000L)
        emit(i)
        log("Emit：$i")
    }
}

fun main() = runBlocking {
    myMethod().flowOn(Dispatchers.Default).collect { log("Collect:$it") }

    delay(1000L)
    log("finished")



}