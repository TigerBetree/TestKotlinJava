package com.test.kotlin.temp

import java.util.*

const val sD = 0

fun main() {
    var aa = AA()
    aa.str = "string"
    println(aa.str)

    var pp = PP(20)
    println(pp.age)
    pp.oneYearLater()
    println(pp.age)

//    sD = 1
}

class AA {
    var str: String? = ""
        get() {
            return "$field."
        }
        set(value) {
            field = "-$value"
        }
}

class PP(var birth: Int) {
    val age: Int
        get() {
            return Calendar.getInstance().get(Calendar.YEAR) - birth
        }

    fun oneYearLater() {
        birth--
    }
}