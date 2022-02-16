package com.carlos._18_coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 每一个协程构建器（包括runBlocking）都会向其代码块作用域中添加一个CoroutineScope实例。我们可以在改作用域中启动协程，而无需显示将其join到到一起，这是因为外部协程会等待其作用域中所哟启动的协程全部完成后才会完成。
 */
fun main() = runBlocking {
    launch {
        delay(2000)
        println("Kotlin Coroutine")
    }
    println("Hello")
}