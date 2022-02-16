package com.carlos._18_coroutine._2_cancel

import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 使用finally来关闭资源
 * job与cancelAndJoin都会等待所有清理动作完成后才会继续往下执行
 */
fun main() = runBlocking {
    val job = launch {
        try {

            repeat(100){
                println("$it")
                delay(300)
            }
        }finally {
            println("finally语句块执行了")
        }
    }
    println("hello")
    delay(1000)
    job.cancelAndJoin()
    println("welcome")
}