package com.carlos._05_property

/**
 * 非抽象类的非空类型属性必须构造方法中初始化 或者lateinit修饰
 * lateinit 只能用在类体的var属性上，不能用在一级构造函数中声明的属性上
 * lateinit 修饰的属性不能有get set方法
 * lateinit 修饰的var属性不能为可空变量
 *
 */
class CClass {
    /**
     * lateinit 延迟初始化 var 变量，该变量在使之前必须要初始化，否则会报异常：lateinit property XXX has not been initialized
     *
     */
    lateinit var xxx:String

    fun init() {
        this.xxx = "犇犇"
    }

}

fun main() {
    val cClass = CClass()
    cClass.init()
    print("${cClass.xxx}")
}