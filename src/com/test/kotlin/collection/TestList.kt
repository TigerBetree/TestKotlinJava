package com.test.kotlin.collection

fun main() {
    val list: List<Int> = listOf()
    println(list)
    println(list::class)
    val list2 = list.toMutableList()
    list2.add(111)
    list2.add(222)
    println(list2)

    val mList = mutableListOf<Int>()
    mList.add(1)
    mList.add(2)
    println(mList)

    val list1 = arrayListOf(1, 2, 3)
    list1.add(4)
    list1.add(5)
    println(list1)
    println(list1::class.java)
    val iterator = list1.iterator()
    while (iterator.hasNext()) {
        print(iterator.next())
    }
    println()
    list1.forEach {
        print(it)
    }
    println()
    println(list1.firstOrNull())

    val list3 = listOf(1, 2, 3, 4, 5, 6)
    println(list3.reduce { sum, next -> sum + next })

    val list4 = listOf("a", "b", "c")
    println(list4.reduceRight { total, s -> total + s })
    println(list4.reduceRight { total, s -> s + total })
    println(list4.map { it -> listOf(it + 1, it + 2, it + 3) })
    println(list4.flatMap { it -> listOf(it + 1, it + 2, it + 3) })

    // 分组
    val words = listOf("a", "abc", "ab", "def", "abcd")
    println(words.groupBy { it.length })

    println(list3.zip(list4))

    val map = mutableMapOf(1 to "a", 2 to "b", 3 to "c")
    println(map)
    map.entries.forEach {
        println("key = " + it.key + ", value = " + it.value)
    }
}