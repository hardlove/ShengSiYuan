package com.carlos._18_coroutine._6_deepin

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
    使用JVM参数:-Dkotlinx.coroutines.debug
 */
fun main() = runBlocking<Unit> (CoroutineName("myCoroutine1")){
    launch(Dispatchers.Default + CoroutineName("myCoroutine2")) {

        println("CoroutineContext 元素组合")
        println("thread is :${Thread.currentThread().name}")

    }

}