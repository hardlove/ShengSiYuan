package com.carlos._04_interface

open class BaseClass {
    open fun methon(): String {
        return "hello"
    }
}
//抽象类对普通类的继承
abstract class ChildClass : BaseClass() {
    abstract fun test()
    override fun methon(): String {
        return super.methon()+" child"
    }
}