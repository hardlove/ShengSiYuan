package com.carlos._05_property

class CompanionObjectExtension {
    companion object MYObj {

    }
}
//伴生对象扩展方法
fun CompanionObjectExtension.MYObj.method() {

}
//伴生对象扩展属性
val CompanionObjectExtension.MYObj.name:String
    get() {
        return "benben"
    }