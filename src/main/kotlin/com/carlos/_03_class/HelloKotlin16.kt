package com.carlos._03_class

open class MyParent {
    open val name = "parent name"
    open val name1 = "parent name1"
    open var age = "parent age"
    open var age1 = "parent age1"
    open val sex = "parent sex"

}

/**
 * val 属性可以重写为val、var
 * var 属性可以重写var
 */
class MyChild(override var sex: String/*主构造方法中重写父类属性*/) : MyParent() {
    override val name: String
        get() {
            return "child name"
        }
    override var name1: String = "child name1"
    override var age: String = "child age"
}