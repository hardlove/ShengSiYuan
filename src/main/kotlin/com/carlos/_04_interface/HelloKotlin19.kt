package com.carlos._04_interface

/**
 * Kotlin中没有java静态方法
 *
 * 可以使用对象声明或者伴生对象来代替java中的静态方法
 */

/**
 * 对象声明
 * 代替单例
 */
object MyObject {

    val name: String = "xxx"
    var age: String = "12"

    init {
        age = "23"
    }

    fun method() {
        println("method... age:$age  name:$name")
    }


}

class MyClass {
    /**
     * 伴生对象
     *
     * 每一个类只允许有一个伴生对象
     *
     * 伴生对象可以指定一个名字，如OBJName。如果没有指定，则编译器会默认提供名字Companion
     */
    companion object OBJName {
        const val name: String = "a"

        /**
         * @JvmStatic 可以将伴生对象的成员在JVM上真正生成类的静态方法
         */
        @JvmStatic
        fun method() {
            println("method>>>")
        }
    }

}

/**
 * 包级别的方法可代替java中的静态方法
 * Kotlin推荐使用包级别的方法实现java中的静态方法
 */
fun staticMethod() {
    print("staticMethod....")
}

fun main() {
    MyObject.name
    MyObject.method()

    MyClass.name
    MyClass.method()
    //redundant:多余的
    MyClass.OBJName.method()

    //MyObject 其实就是一个单例，即始终是同一个对象
    val myObject = MyObject
    val myObject1 = MyObject

    println("myObject ${myObject.hashCode()}")
    println("myObject1 ${myObject1.hashCode()}")

    staticMethod()


}