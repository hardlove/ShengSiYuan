package com.carlos._05_property
//扩展的作用域
/*
 扩展函数所定义在的类实例叫做分发接收者（dispatch receiver）
 扩展函数所扩展的那个类的实例叫做扩展接收者（extension receiver）
 当以上两个名字出现冲突时 扩展接收者优先级最高
* */
class DD {
    fun hello2() {

    }

}

fun DD.hello() {
    println("hello....")
    hello2()
    this.hello2()
    fun DD.say() {
        println("say......")
        hello2()
        hello()
    }

    this.say()
}
fun main(args: Array<String>) {
    val dd = DD()
    dd.hello2()
    dd.hello()

//    dd.say() 不可调用 因为 say()定义在DD.hello中，仅 DD.hello作用域中可用

}

