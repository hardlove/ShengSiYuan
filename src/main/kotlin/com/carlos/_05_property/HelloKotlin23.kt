package com.carlos._05_property

class ExtensionText {
    fun add(a: Int, b: Int) = a + b
}

fun ExtensionText.multi(a: Int, b: Int): Int {
    return a * b
}


open class AA (){
   open fun a() {
        println("a.......")
    }
}

class BB : AA() {

    override fun a() {
        println("b>a.......")
    }

}

/**
 * 扩展方法
 *
 * 扩展方式是动态解析，并不会插入原类中
 * 扩展函数的解析是静态分发的，而是不是动态的，即扩展时不支持多态的 调用值取决于对象的声明类型（Java取决于实例化的对象类型 即动态解析）
 * 调用是由对象的声明类型决定的，而不是由对象的实际类型决定的
 */
fun AA.b(): Unit {
    println("AA.b........")
}
fun BB.a() {
    println("BB.a.....")
}

fun main(args: Array<String>) {

    val extensionText = ExtensionText()
    val add = extensionText.add(1, 3)
    println(add)
    val multi = extensionText.multi(3, 4)
    println(multi)



    AA().a()
    AA().b()

    BB().a()

}