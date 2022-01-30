package com.carlos._05_property

class ThePerson(name: String, age: Int) {

    //val 只读  只有get方法
    val address: String
        get() {
            return "武胜县"
        }

    // var 可读、可写，有get和set方法
    var age: Int = age
        //filed 只能用在属性的get set方法中，表示背后真正存储值的事物
        get() {
            println("age get invoke")
            return field
        }
        //filed 只能用在属性的get set方法中，表示背后真正存储值的事物
        set(value) {
            println("age set invoke")
            field = value
        }


}

fun main() {
    val thePerson = ThePerson("犇犇", 1)
    thePerson.age
    thePerson.address

    thePerson.age = 3
    println("age:${thePerson.age}")
}