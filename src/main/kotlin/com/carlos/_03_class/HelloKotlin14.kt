package com.carlos._03_class

/**
 * Kotlin的类默认都是final类型，不可继承。如有被继承，需要指定为open
 */
open class Parent(val name: String, var age: Int) {
    /**
     * Kotlin类的方法默认也是final类型，不可重写。如需重写，需要指定open
     */
    open fun sayHello() {
        println("hello $name")
    }

    /**
     * Kotlin类的方法默认也是final类型，不可重写
     */
    final fun eat() {

    }
}

class Child(name: String, age: Int) : Parent(name, age) {
    override fun sayHello() {
        super.sayHello()
        println("hello $name ...")
    }

}

/**
 * Kotlin子类没有主构造函数，所有的二级构造函数需要直接或间接调用super来初始化父类
 */
class Child2 : Parent {
    //直接调用父类super
    constructor(name: String, age: Int) : super(name, age)

    //间接调用父类super
    constructor(name: String, age: Int, sex: Char) : this(name, age)
}

fun main(args: Array<String>) {
    val child = Child("犇犇", 1)
    child.sayHello()
}
