package com.test.kotlin.singleton

class Singleton private constructor() {
    companion object {
        fun get(): Singleton {
            return Holder.instance
        }
    }

    private object Holder {
        val instance = Singleton()
    }

    fun doSomthing(){
        println("doSomthing.")
    }
}

fun main(){
    Singleton.get().doSomthing()
}
