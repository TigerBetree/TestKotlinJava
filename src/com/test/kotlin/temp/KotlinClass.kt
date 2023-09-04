package com.test.kotlin.temp

import java.math.BigInteger

class KotlinClass {
    companion object {
        const val INTEGER_ON = 1
        @JvmField val BIG_INTEGER_ONE = BigInteger.ONE

        @JvmStatic
        fun doWork() {
            System.out.println("KotlinClass -> doWork.")
        }
    }
}