package com.test.kotlin.temp

fun main() {
    System.out.println(user1.info())

    testLateInit()
    System.out.println(user2.info())

    println(user1 is Any)
}

class User(var name: String, var age: Int) {
    fun info(): String {
        return "[$name,$age]"
    }
}

val user1: User by lazy {
    User("A", 10)
}

lateinit var user2: User

fun testLateInit() {
    user2 = User("B", 15)
}


data class Student(val name: String, val sex: String, val age: Int)