package com.shengsiyuan._02_differjava

fun main() {
    val a: String = "hello \\n world"
    println(a)


    val b: String = """ hello
       \n | world
    """.trimMargin()
    println(b)
}