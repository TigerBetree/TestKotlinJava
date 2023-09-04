package com.test.kotlin.demo1

/**
 * Created by ZhangTao on 18/6/21.
 */

fun main(args: Array<String>) {
    val user = User(1, "name", PlayerViewType.VIP("VIP播放器"))
    PlayerUI.get().showPlayer(user)
}