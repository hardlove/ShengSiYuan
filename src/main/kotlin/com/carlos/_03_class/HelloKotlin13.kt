package com.carlos._03_class

/**
 *主构造函数种 val name:Sting 这样写的是类的成员变量
 *
 * 主构造函数中所有参数都有默认值时，编译器会默认生成一个无参构造方法，并使用全参数的默认值
 */
class Student constructor(private val name: String = "小明", private var age: Int = 1) {
    fun printInfo(): String = "name=$name age=$age"
}

fun main(args: Array<String>) {
    //使用默认生成的无参构造方法
    val student = Student()
    println(student.printInfo())

    var student2 = Student(age = 3, name = "小李")
    println(student2.printInfo())

    student2 = Student("小李", 4)

    println(student2.printInfo())
}

