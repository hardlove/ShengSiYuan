package com.carlos._18_coroutine._2_cancel

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

/*
    又withTimeout函数调用所抛出的TimeoutCancellationException异常是CancellationException的字类，当该异常抛出时，我们并未
    在控制台上看到完整的异常堆栈信息，这是因为在取消的协程当中，CancellationException被认为是一种协程完成的正常原因而已。

    不过，我们在该示例中，是在main函数中使用了withTimeout函数调用

    既然CancellationException仅仅只是个异常而已，所有的资源也都会以通常的方式来关闭，那么我们就可以将相关代码放到一个try...catch块中；此外，
    Kotlin还提供了另外一个更加友好的函数调用：withTimeoutNull;从功能焦点来看，他非常类似于withTimeout,不过当超时发生时，它并不会抛出
    CancellationException异常，而是回直接返回null

    对于withTimeout函数调用来说，如果将其放到try..catch块中，那么调用形式就是下面这样：
    try{
        ...
    }catch(ex:TimeoutCancellationException){
        ...
    }


 */
fun main() = runBlocking {
    val result = withTimeoutOrNull(1900) {
        repeat(5) {
            println("hello $it")
            delay(200)
        }

      "completed"
    }
    println("result is:$result")


}