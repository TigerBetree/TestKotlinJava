package com.test.kotlin.temp

class Tiger constructor(name: String, age: Int){
    init {
        println("init.")
    }
}

class Tiger2(){

}

fun main(){
    var s = Tiger("tiger", 20)
    println(s)

    var t2 = Tiger2()
}