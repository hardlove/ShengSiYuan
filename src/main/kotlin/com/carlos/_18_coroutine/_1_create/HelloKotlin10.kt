package com.carlos._18_coroutine

import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

fun test(x: Int, action: () -> Unit) {
    action.invoke()//等价于    action()
    action()
}

fun test2(x: Int, action: (Int) -> Unit) {
    action.invoke(x)//等价于   action(x)
    action(x)
}

fun test3() {
}

fun test4(x: Int) {
}

fun test5(x: Int, action: (Int, Int) -> Unit) {
}

fun test6(x: Int, y: Int) {
}


fun main() {
    test(4) {
        println("hello world...")
    }
    test2(4) {
        println(it)
        println("hello world")
    }


    test(3, ::test3)
    test2(3,::test4)
    test5(4,::test6)

    test5(4, action = {x,y->
        println()
    })

}


