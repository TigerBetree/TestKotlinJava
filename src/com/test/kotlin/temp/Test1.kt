package com.test.kotlin.temp

fun main() {
    twoAndThree { a, b -> a + b }
    twoAndThree({ a, b -> a - b })
    twoAndThree({ a, b -> a * b })
    twoAndThree({ a, b -> a / b })

    test05()
}

fun twoAndThree(operator: (Int, Int) -> Int) {
    val result = operator(2, 3)
    println("Result: $result")
}

enum class Delivery {
    STANDARD, EXPEDITED
}

fun getShippingCostCalculator(delivery: Delivery): (Int) -> Double {
    if (delivery == Delivery.EXPEDITED) {
        return { 6 + 2.1 * it }
    }
    return { 1.3 * it }
}

fun test05() {
    val cal1 = getShippingCostCalculator(Delivery.EXPEDITED)
    val cal2 = getShippingCostCalculator(Delivery.STANDARD)
    println("Ex costs ${cal1(5)}")
    println("St consts ${cal2(5)}")
}