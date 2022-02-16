package com.carlos._18_coroutine._6_deepin

import kotlinx.coroutines.Job
import kotlinx.coroutines.isActive
import kotlinx.coroutines.runBlocking

/*
    Job的使用方式以及在Context中的具体应用：
    协程的Job是归属其上下文（Context）的一部分，Kotlin为为们提供了一种简洁的方式来通过协程上下文获取到协程自身的Job对象。
    我们可以通过coroutineContext[Job]表达式来访问上下文中的Job对象。
 */
fun main() = runBlocking<Unit> {
    val job: Job? = coroutineContext[Job]

    println(job)

    println(coroutineContext.isActive)//两种方式等价
    println(coroutineContext[Job]?.isActive)


}