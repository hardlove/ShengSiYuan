package com.shengsiyuan._02_differjava

fun main() {
    var array = intArrayOf(1, 2, 3, 4, 5)
    for (item: Int in array) {
        println(item)
    }
    for (item in array) {
        print("$item")
    }

    for (index: Int in array.indices) {
        println(array[index])
    }

    for (i in array.indices) {
        print("array[${i}=${array[i]}]")
    }

    array.forEach { println(it) }

    for ((index: Int, value: Int) in array.withIndex()) {
        println("array[${index}] = $value")
    }

    for ((index, value) in array.withIndex()) {
        println("array[${index}] = $value")
    }


}
