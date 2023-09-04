package com.test.kotlin.temp

fun sumGTZero(c: Iterable<Int>): Int {
    var sum = 0
    c.filter { it > 1 }.forEach {
        sum += it
    }
    return sum
}

fun main(args: Array<String>) {
    var list = listOf(1, 2, 3, 4)
    println(sumGTZero(list))

    closureDemo()
}

fun closureDemo() {
    Thread {
        for (i in 1..10) {
            println("i = $i")
            Thread.sleep(1000)
        }
    }.start()

    Thread {
        for (j in 10..20) {
            println("j = $j")
            Thread.sleep(2000)
        }
        Thread.sleep(1000)
    }.start()
}