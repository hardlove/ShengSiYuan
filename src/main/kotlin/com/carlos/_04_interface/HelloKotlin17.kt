package com.carlos._04_interface

interface A {
    fun method2()
    fun method() {
        println("接口可以有实现的方法")
    }

}

open class B() {
    open fun method() {
        println("我是B的method方法。。。")
    }
}

class C : B(), A {
    override fun method2() {

        println("C...method2")
    }

    //多继承相同签名的方法 必须显示override ，supper必须加<>
    override fun method() {
        super<A>.method()
        super<B>.method()
    }


}

fun main() {
    val c = C()
    c.method()
    c.method2()
}