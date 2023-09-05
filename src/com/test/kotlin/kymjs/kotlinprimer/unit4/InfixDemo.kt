//package com.test.kotlin.kymjs.kotlinprimer.unit4
//
///**
// * Created by ZhangTao on 18/7/6.
// */
//
//sealed class CompareResult {
//    object LESS : CompareResult() {
//        override fun toString(): String {
//            return "小于"
//        }
//    }
//
//    object MORE : CompareResult() {
//        override fun toString(): String {
//            return "大于"
//        }
//    }
//
//    object EQUAL : CompareResult() {
//        override fun toString(): String {
//            return "等于"
//        }
//    }
//}
//
//infix fun Int.vs(num: Int): CompareResult =
//        if (this - num < 0) {
//            CompareResult.LESS
//        } else if (this - num > 0) {
//            CompareResult.MORE
//        } else {
//            CompareResult.EQUAL
//        }
//fun com.test.kotlin.test1.test1.com.test.kotlin.test1.main(args: Array<String>) {
//    println(5.vs(6))
//}
