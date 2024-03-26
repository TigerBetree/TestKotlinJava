package com.test.kotlin.demo

/**
 * Created by ZhangTao on 18/6/13.
 */

data class User(var id: Int,
                var name: String,
                var playerType: PlayerViewType = PlayerViewType.BLUE)
