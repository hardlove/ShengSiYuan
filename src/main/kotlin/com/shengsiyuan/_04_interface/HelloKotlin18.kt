package com.shengsiyuan._04_interface

import com.carlos._04_interface.staticMethod

open class BaseClass {
    open fun method() {

        staticMethod()
    }
}

//抽象类对普通类的继承可以做抽象继承
abstract class ChildClass : BaseClass() {
    abstract override fun method()
}