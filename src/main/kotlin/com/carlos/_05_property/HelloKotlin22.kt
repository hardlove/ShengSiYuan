package com.carlos._05_property

/*
可见性：private、protect、internal、public

private：只能在类中使用
protect:类中、子类中使用
internal:同一模块中使用
public:所有的地方都可使用

 */
open class Class1 {
    private var a = 2
    protected var b = 3
    internal  var c = 4
    public var d = 5

}

class Class2 {
    fun method1() {
        val class1 = Class1()
        //c d 可访问
        class1.c
        class1.d
    }

}
class Class3 : Class1() {
    fun method1() {
        //b c d 可访问
        this.b
        this.c
        this.b

    }
}


