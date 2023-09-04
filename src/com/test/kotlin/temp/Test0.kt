package com.test.kotlin.temp

fun main(args: Array<String>) {
    println("Hello.")
    var p = Person("Tiger")
    p.printName()
    p.sayHello()
    var p1 = Person("Tiger", "nam")
    p1.sayHello()

    println("------------")
    var names = arrayOf("a", "b", "c")
    for (name in names) {
        println(name)
    }
    var a = "a"
    if (a in names) {
        println("a is in.")
    }
    var d = "d"
    if (d !in names) {
        println("d not in.")
    }

    cases(1)
    cases("hello")
    cases(100L)
    cases(100)
    cases("aaa")
    cases(10.3f)

    println("------------")
    println(getStringLength("hello"))
    println(getStringLength(1000))
    var data1: String? = null
    printString(data1)
    var data2: String? = "Tiger"
    printString(data2)

    println("------------")

    val firstName: String = "Hu"
    val lastName: String? = null
    println("My name is ${getName(firstName, lastName)}")

    println("------------")
    println(Single.get().toString())

    function()

    var txt: String? = null
    println(txt?.length)
    txt = "txt"
    txt?.let {
        println("txt len : ${txt.length}")
    }

    val age = 18
    val name = "tiger"
//    println("name %d, age %d", name, age)
    println("name $name, age $age")

    Utils.sayMsg("tttttt")
}

object Utils {
    @JvmStatic
    fun sayMsg(msg: String?){
        println("$msg")
    }
}

fun cases(obj: Any) {
    when (obj) {
        1 -> println("1")
        "hello" -> println("hello")
        is Long -> println("Long")
        !is String -> println("Not String")
        else -> println("else.")
    }
}

fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        return obj.length
    }

//    if(obj !is String){
//        return -1
//    }

    return null
}

fun printString(data: String?) {
    data?.let {
        println("data is : " + data)
        return
    }
    println("data is null.")
}

fun say(str: String): String {
    return str
}

fun say2(str: String): String = str

fun say3(str: String = "hello"): String = str

fun getIntValue(value: Int) = value

fun hasEmpty(vararg strArray: String?): Boolean {
    for (str in strArray) {
//        if ("" == str || str == null) {
//            return true
//        }
        str ?: return true
    }

    return false
}

fun checkName(name: String?): String = name ?: "unknow"

fun getName(firstName: String?, lastName: String? = "unknow"): String {
    if (hasEmpty(firstName, lastName)) {
        lastName?.let {
            return@getName "${checkName(firstName)} $lastName"
        }
        firstName?.let {
            return@getName "$firstName ${checkName(lastName)}"
        }
    }
    return "$firstName $lastName"
}

// 嵌套函数
fun function(){
    val str = "hello!"

    fun say(count: Int = 10){
        println(str)
        if(count > 0){
            say(count - 1)
        }
    }

    say()
}