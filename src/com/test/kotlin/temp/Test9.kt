package com.test.kotlin.temp

fun main(args: Array<String>) {

    val format = "%-10s%-10s%-10s"
    println(String.format(format, "A", "B", "C"))


    val str = 123
    val combinStr1 = str.let { "$str world" }
    println(combinStr1)

    val combinStr2 = with(str) { "$str world" }
    println(combinStr2)

    val combinStr3 = str.run { "$str world " }
    println(combinStr3)

    val combinStr4 = str.apply { "$str world" }
    println(combinStr4)

    val combinStr5 = str.also { "$str world" }
    println(combinStr5)

    val stus = listOf(Stu("Alice", 29), Stu("Bob", 31))
    println(stus.filter { it.age > 30 })
    println(stus.filter { it.age > 30 }.map { it.name })
}

data class Stu(val name: String, val age: Int)
