package com.carlos._18_coroutine._5_debug

import kotlinx.coroutines.Job
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

private fun log(logMessage: String) = println("[${Thread.currentThread().name}] $logMessage")
fun main() = runBlocking <Unit>{
    //newSingleThreadContext.use{} 会自动调用close释放资源
    newSingleThreadContext("Context1").use { ctx1->
        newSingleThreadContext("Context2").use { ctx2->
            runBlocking(ctx1) {
                log("Started in Context1")
                withContext(ctx2){
                    log("working in Context2")
                }
                log("Back to Context1")
            }


        }
    }

}