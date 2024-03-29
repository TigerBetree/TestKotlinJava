package com.test.kotlin.kymjs.kotlinprimer2.unit2

import java.util.*

/**
 * Created by ZhangTao on 18/7/8.
 */
class Person(var birthYear: Int) {
    val age: Int
        get() {
            return Calendar.getInstance().get(Calendar.YEAR) - birthYear
        }

    fun oneYearsLater() {
        birthYear--
    }
}