package com.carlos._03_class

class Person constructor(val name: String, sex: Char, age: Int) {
    var age: Int
    val sex: Char

    init {
        println("初始化代码块 init...")
        println("name=$name")
        this.age = age
        this.sex = sex

    }


    constructor(name: String, age: Int) : this(name, '男', 1) {
        print("两个参数的次构造函数 name:$name  age:$age")
        this.age = age

    }

    constructor(name: String, age: Int, sex: Char) : this(name, age) {
        println("三个参数的次构造函数 name:$name age:$age sex:$sex")

    }

    override fun toString(): String {
        return "name=$name,age=$age,sex=$sex"
    }

}

fun main(args: Array<String>) {
    val person = Person("犇犇", 3, '男')
    println(person.toString())

}

