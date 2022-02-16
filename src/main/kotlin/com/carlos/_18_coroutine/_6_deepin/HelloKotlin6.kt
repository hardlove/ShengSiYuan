package com.carlos._18_coroutine._6_deepin

import kotlinx.coroutines.*

/*
    CoroutineScope绑定组件生命周期
 */
class Activity : CoroutineScope by CoroutineScope(Dispatchers.Default) {
    fun destroy() {
        cancel()
    }

    fun doSomething() {
        launch {
            repeat(9) {
                delay(100)
                println("coroutine $it is finished")

            }
        }


    }

}

fun main() = runBlocking<Unit> {
    val activity = Activity()
    activity.doSomething()
    println("协程启动....")
    delay(500L)
    println("销毁协程...")
    activity.cancel()
    delay(9000L)
    println("finished...")


}