package com.carlos._18_coroutine._4_principle

import kotlinx.coroutines.*
import java.util.concurrent.Executors

/*
    协程与线程直接的关系

    协程上下文与分发器（Coroutine Context与Dispatcher）
    协程总是会在某个上下文中执行，这个上下文实际上是由CoroutineContext类型的一个实例来表示的，该实例由Kotlin标准库来定义的
    协程上下文本质上是各种元素构成的集合。其中，主要的元素包括协程的Job，以及分发器。

    所谓的分发器，其主要功能就是确定由哪个线程来执行我们指定的协程代码。

    协程上下文包含了一个协程分发器（CoroutineDispatcher），协程分发器确定了到底由哪个线程或是线程池来执行我们指定的协程协程代码。协程
    分发器可以将协程的执行限制到一个具体指定的线程，也可以将协程的执行分发到一个线程池中，由线程池中的某个线程来执行我么指定的协程，
    还可以不加任何限制地去执行我们指定的协程代码（在这种情况下，我们指定的协程代码到底由哪个线程来执行是不确定的，它需要根据程序的实际执行情况方能确定；
    这种方式的协程分发器在一般的开发中使用极少，它只用着一些极为特殊的情况下）。

    程序分析:
    1、当通过launch来启动协程并不指定协程分发器时，它会继承启动它的那个CoroutineScope的上下文与分发器。对于该示例来说，它会继承
    runBlocking的上下文，而runBlocking则是运行在main线程当中。
    2、Dispatchers.Unconfined是一种很特殊的协程分发器，它在该示例中也是运行在main线程中，但实际上，其运行机制与不指定协程分发器时
    是完全不同的；在日常开发中使用极少。
    3、Dispatchers.Default是默认的协程分发器，当协程通过GlobalScope来启动的时候，它会使用该默认的协程分发器来启动协程，它会使用一个后台的共享线程池
    来运行我们的协程代码。因此，launch(Dispatcher.Default){}等价于GlobalScope.launch{}，其使用的线程有可能不一样。
    4、Executors.newCachedThreadPool().asCoroutineDispatcher()创建一个单线程的线程池，该线程池中线程用来执行我们所指定的协程代码。
    在实际的开发中，使用专门的线程来执行协程代码代价是非常高的，因此在协程执行完毕后，我们必须释放相应的资源，这里就需要使用close方法来关闭应用的协程分发器，
    从而释放掉资源；也可以将该协程分发器存储到一个顶层变量当中，以便在程序的其它地方复用。
 */


fun main() = runBlocking<Unit> {
    launch {
        println("no params,current thread name:${Thread.currentThread().name}")
    }

    launch(Dispatchers.Unconfined) {//Dispatchers.Unconfined 是一种非常特殊的协程分发器
//        delay(1000)
        println("Dispatchers.Unconfined, current thread name:${Thread.currentThread().name}")
    }

    GlobalScope.launch {
        println("GlobalScope.launch, current thread name:${Thread.currentThread().name}")
    }
    launch(Dispatchers.Default) {
        println("Dispatchers.Default, current thread name:${Thread.currentThread().name}")
    }

    //自定义线程池的方式提供分发器（注意：该种方式必须释放资源，或者作为顶层变量在其它地方复用）
    val thread = Executors.newCachedThreadPool().asCoroutineDispatcher()
    launch(thread) {
        println("Single thread executor, current thread name:${Thread.currentThread().name}")
        //释放资源
        thread.close()
    }

    launch(Dispatchers.IO) {
        println("Dispatchers.IO, current thread name:${Thread.currentThread().name}")
    }
//    launch(Dispatchers.Main) {
//        println("Dispatchers.Main, current thread name:${Thread.currentThread().name}")
//    }
}