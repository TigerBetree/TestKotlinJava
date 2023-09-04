package com.test.kotlin.coroutine



fun main(){
    firstDaemonDemo1()
}

fun firstDaemonDemo1(){
    val t = Thread{
        repeat(100){
            println("i = $it")
            Thread.sleep(500)
        }
    }
    t.isDaemon = true
    t.start()
    Thread.sleep(3000)
}