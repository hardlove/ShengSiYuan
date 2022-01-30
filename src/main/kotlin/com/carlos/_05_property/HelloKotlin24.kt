package com.carlos._05_property



class ExtensionProperty {

}

/*
扩展属性
 */
var ExtensionProperty.name: String
    get() = "犇犇"
    set(value) = TODO()

val  ExtensionProperty.sex: Char
    get() = '男'
fun main(args: Array<String>) {
    val extensionProperty = ExtensionProperty()
    extensionProperty.name= "小李"
    extensionProperty.sex
}