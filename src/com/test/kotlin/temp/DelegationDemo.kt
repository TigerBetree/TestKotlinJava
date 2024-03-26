package com.test.kotlin.temp

import java.util.*

/**
 * 代理模式
 *
 */


interface Subject {
    fun hello()
}

class RealSubject(val name: String) : Subject {
    override fun hello() {
        val now = Date()
        println("Hello, Real $name ! Now is $now")
    }
}

class ProxySubject(private val sb: Subject) : Subject by sb {
    override fun hello() {
        println("Before ! Now is ${Date()}")
        sb.hello()
        println("After ! Now is ${Date()}")
    }
}

fun main(){
    val subject = RealSubject("World")
    subject.hello()
    println("---------")
    val proxySubject = ProxySubject(subject)
    proxySubject.hello()
}