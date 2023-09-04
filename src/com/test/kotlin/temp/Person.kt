package com.test.kotlin.temp

class Person(private var name: String) {

    private var desp: String? = null

    init {
        name = "liuhu"
    }

    constructor(name: String, desp: String): this(name){
        this.desp = desp
    }

    internal fun sayHello(){
        println("hello $name ${desp ?: desp }")
    }

    fun printName(){
        println(name)
    }
}

