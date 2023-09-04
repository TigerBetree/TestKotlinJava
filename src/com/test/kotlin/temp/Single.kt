package com.test.kotlin.temp

class Single private constructor() {
    companion object {
        fun get(): Single {
            return Holder.instance
        }
    }

    private object Holder {
        val instance = Single()
    }

    override fun toString(): String {
        return "Single"
    }
}