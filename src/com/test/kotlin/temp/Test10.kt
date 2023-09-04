package com.test.kotlin.temp

import java.io.Serializable


fun main(args: Array<String>) {
    var p: Person? = Person("tiger")
    p = null
    println(p?.printName())

    if(p?.printName() == null){
        println("is null.")
    }

    var testDataClass = TestDataClass(1, "Tiger", 1235623975542)
    println(testDataClass.toString())
}


data class TestDataClass(
    var id: Int? = 0,
    var name: String? = "",
    var no: Long? = 0L
) : Serializable {
    companion object {
        private const val serialVersionUID: Long = 8844364050018163375L
    }
}

