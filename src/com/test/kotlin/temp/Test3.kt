package com.test.kotlin.temp

import java.lang.StringBuilder

fun main(args: Array<String>) {
    var artist: String? = null;
    println(artist?.length)
    println(artist?.length ?: "empty")

    val list = listOf(2, 4, 0)
    println(printList(list, "-", "[", "]"))
}

fun <T> printList(
    collection: Collection<T>, separator: String,
    prefix: String, postfix: String
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) {
            result.append(separator)
        }
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

