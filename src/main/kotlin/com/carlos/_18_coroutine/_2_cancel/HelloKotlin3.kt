package com.carlos._18_coroutine._2_cancel

import kotlinx.coroutines.*

/*
    有两种方式可以让计算代码变为可取消的：
    1、周期性地调用一个挂起函数，改挂起函数会检查取消状态，比如说使用yield函数
    2、显示地检查取消状态
    如下示例采用第二种方式实现
    其中isActive是协程的一个扩展属性，它是通过CoroutineScope对象添加的
 */
fun main() = runBlocking {
    var startTime = System.currentTimeMillis()
    var i = 0L;
    val job = launch(Dispatchers.Default) {
        while (isActive && i < 20) {
//            yield()
            if (System.currentTimeMillis() > startTime) {
                println("job : I am sleeping ${i++}")
                startTime += 500L
            }
        }
    }

    delay(1300)
    println("hello world ")
    job.cancelAndJoin()
    println("welcome")

}