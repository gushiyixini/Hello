package com.yelj.hello

import java.lang.Exception

/**
 * Author: Alex.ylj
 * 2019/3/26 17:18 Tuesday
 * Description:
 */
fun main(args: Array<String>) {
    try {
        val x = args[0].toInt()
        when (x) {
//        is Int -> println("$x is Int")
            in 1..100 -> println("$x is in 1..100")
//        !in 1..100 -> println("$x is not in 1..100")
            args[1].toInt() -> println("$x == ${args[1]}")
            else -> {
                println("when else")
            }
        }
    } catch (e: Exception) {
        println(e.toString())
        e.printStackTrace()
    }
}