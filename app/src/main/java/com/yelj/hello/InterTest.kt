package com.yelj.hello

/**
 * Author: Alex.ylj
 * 2019/3/31 14:47 Sunday
 * Description: 内部类练习
 */
//kotlin 默认的class是 public final，如果需要继承，需要用open关键字
open class Outer {

    private val outerA = "hello world"

    /**
     * 静态内部类
     * kotlin中，默认是静态的内部类，如需非静态的内部类，需要用关键字 inner 修饰
     */
    class Inner {
        fun hello() {
            println(Outer().outerA)
        }
    }

    /**
     * 非静态内部类
     */
    inner class NotStaticClass {
        private val outerA = "hello world???????"

        fun hello() {
            println(this@Outer.outerA)
            println(outerA)
        }
    }
}

/**
 * 匿名内部类
 */
interface OnClickListener {

    fun onClick()
}

class View {

    var clickListener: OnClickListener? = null
}

fun main(args: Array<String>) {
    val inner = Outer.Inner()
    val notStaticClass = Outer().NotStaticClass()
    inner.hello()
    notStaticClass.hello()

    //匿名内部类
    val view = View()
    view.clickListener = object : Outer(),OnClickListener {
        override fun onClick() {

        }
    }
}