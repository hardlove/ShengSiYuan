package com.carlos._06_dataclass

/**
 * 数据类 data class
 *
 * 1、数据类主构造函数至少要有一个属性
 * 2、所有主构造函数中，标记了var/val 的叫属性，不标记的叫参数。数据类的主构函数中所有属性都要标记为var/val
 */
data class Person(val name: String, var age: Int, var stress: String)



