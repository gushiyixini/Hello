package com.yelj.hello

/**
 * Author: Alex.ylj
 * 2019/3/26 17:56 Tuesday
 * Description:
 */
fun main(args: Array<String>) {
    while (true) {
        try {
            println("请输入算式例如：3 + 4")
            val input = readLine() ?: break
            val split = input.trim().split(" ")
            if (split.size < 3) {
                throw IllegalArgumentException("参数格式不对")
            }
            val arg1 = split[0].toDouble()
            val op = split[1]
            val arg2 = split[2].toDouble()

            println("$arg1 $op $arg2 = ${MyOperation(op).apply(arg1, arg2)}")
        } catch (e: NumberFormatException) {
            println("请输入正确的算式")
        } catch (e: IllegalArgumentException) {
            println("数字之间需要用空格分隔")
        } catch (e: Exception) {
            e.printStackTrace()
        }
        println("再来一次？[Y]")
        val cmd = readLine()
        if (cmd == null || cmd.toLowerCase() != "y") {
            break
        }
    }
}

class MyOperation(op: String) {

//    constructor(op: String, al: Int, aa: Int) : this(op)

    val opFun: (left: Double, right: Double) -> Double

    init {
        opFun = when (op) {
            "+" -> { l, r -> l + r }
            "-" -> { l, r -> l - r }
            "*" -> { l, r -> l * r }
            "/" -> { l, r -> l / r }
            "%" -> { l, r -> l % r }
            else -> {
                throw UnsupportedOperationException(op)
            }
        }
    }

    fun apply(left: Double, right: Double): Double {
        return opFun(left, right)
    }

//    var mOp = ""
//
//    init {
//        mOp = op
//    }
//
//    fun opFun(l: Double, r: Double): Double {
//        return when (mOp) {
//            "+" -> l + r
//            "-" -> l - r
//            "*" -> l * r
//            "/" -> l / r
//            "%" -> l % r
//            else -> {
//                throw UnsupportedOperationException(mOp)
//            }
//        }
//    }
}