package com.test.kotlin.temp

fun main() {
    println("a" + "b")

    test1()
//    println(test2(10))
//    println(test2(42))
//    println(test2(52))
//
//    println(stringLengthFunc("Android"))
//
//    println(stringMapper("Android Kotlin", { input -> input.length}))
//    println(stringMapper("Android") { input -> input.length})
}

fun stringMapper(str: String, mapper: (String) -> Int): Int {
    return mapper(str)
}

val stringLengthFunc: (String) -> Int = { input ->
    input.length
}

fun test2(count: Int): String {
    return if (count == 42) {
        "42"
    } else if (count > 42) {
        ">"
    } else {
        "<"
    }

//    return when {
//        count == 42 -> {
//            "42"
//        }
//        count > 42 -> {
//            ">"
//        }
//        else -> {
//            "<"
//        }
//    }
}

fun test1() {
    var wifiPassword = "?"
    val a = arrayOf("0", "1", "2", "6", "7", "h", "j")
    wifiPassword = arrayOf(5, 9, 6, 8, 2, 7, 0, 1, 4, 0, 3)
        .filter { it in a.indices }
        .also { println("-$it") }
        .map {
            println("+" + a[it])
            a[it]
        }
        .reduce { s1, s2 ->
            println("$s1-$s2")
            "$s1$s2"
        }
    println("wifiPassword : $wifiPassword")
}
