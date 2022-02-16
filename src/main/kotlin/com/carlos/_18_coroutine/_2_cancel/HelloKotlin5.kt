package com.carlos._18_coroutine._2_cancel

import kotlinx.coroutines.*



/**
 * 当我们在协程的finally块钟使用了挂起函数时，会导致cancellationException异常，原因在于运行
 * 该代码块的协程已经被取消了。通常情况下，这并不会产生什么问题，因为大多数关闭操作（比如输说取消一个job、关闭网络连接）通常都是非阻塞的，
 * 并不需要使用挂起函数；然而，在极少数情况下，当我们在一个取消的协程中进行挂起操作时，我们可以将相应的代码放置到withContext(NonCancellable){}
 * 当中，在这种结构中，我们实际上使用了withContext函数于NoCancellable上下文
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

            //使用withContext(NonCancellable){}让程序正常执行
            withContext(NonCancellable){
                delay(1000)//finally中使用了挂起函数
                println("在delay后执行的代码片段")
            }
        }
    }
    println("hello")
    delay(1000)
    job.cancelAndJoin()
    println("welcome")
}

//fun main() = runBlocking {
//    val job = launch {
//        try {
//
//            repeat(100){
//                println("$it")
//                delay(300)
//            }
//        }finally {
//            println("finally语句块执行了")
//
//            delay(1000)
//            println("在delay后执行的代码片段")
//        }
//    }
//    println("hello")
//    delay(1000)
//    job.cancelAndJoin()
//    println("welcome")
//}