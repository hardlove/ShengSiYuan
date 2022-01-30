package com.carlos._03_class

/**
 * 默认就是public，区别于java，类名不需要和文件名相同
 * 定义了一个没有任何属性、方法的空类
 */
class Empty

/**
 * 主构造函数是类头的一部分，位于类名后面，可以带有参数
 */
class MyClass1 private constructor(val name: String)

/**
 * 主构造方法无可见性关键字修饰符以及注解修饰时，可以省略constructor关键字
 */
class MyClass2(val name: String, var age: Int){
}

class MyClass3( a: String,  age: Int){
    var name:String = a
        get() {
           return field
        }
    set(value) {
        field = "xiaoxiao $value\n"
    }

    init {
        print("name=$a age=$age\n")

    }
}

fun main() {
    val myClass3 = MyClass3("li", 3)
    print(myClass3.name)
    myClass3.name = "hong"
    print(myClass3.name)
}