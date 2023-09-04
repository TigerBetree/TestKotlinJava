package com.test.kotlin.temp

import java.util.*

fun <A, B, C> compose(f: (B) -> C, g: (A) -> B): (A) -> C {
    return { x -> f(g(x)) }
}

fun isOdd(x: Int) = x % 2 != 0
fun length(s: String) = s.length
fun main(args: Array<String>) {
    val oddLength = compose(::isOdd, ::length)
    val strings = listOf("a", "ab", "abc")
    println(strings.filter(oddLength))

    var a = 1
    println(a)
    println(a::class) // 类型
    println(a::class.java) // 对应的java类型

    val b = Date()
    println(b)
    println(b is Date)
    println(b::class.java)

    val s = """
fun helloworld(val name: String) {
    println("Hello, Kotlin")
}
    """
    println(s)

    println(null is Any)
    println(s is Any)
}