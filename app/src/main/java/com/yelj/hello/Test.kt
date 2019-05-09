//package com.yelj.hello
//
///**
// * Author: Alex.ylj
// * 2019/3/25 14:06 Monday
// * Description:
// */
//
////val 只读的变量、类似java中的final形式
//val FINAL_HELLO: String = "hello"//指明数据类型
//val FINAL_HELLO_1 = "hello_1"//无需写数据类型，编译器自推导
//
////var 可读可写的变量
//var hello: String = "hello"
//var hello_1 = "hello_1"
//
//var a = 1
//var b = 3
//
//val list = listOf(1, 2, 3, 4)
//
//fun main(args: Array<String>) {
//    println(useStringTemplate(3, 4))
//    forTest()
//
//    //kotlin 没有三元表达式，if带返回值，所以可以用if else的形式返回
//    val max = if (a > b) a else b
//    println(max)
//    println(asList(1, 2, 3, 4, 5))
//}
//
///**
// * 使用字符串模板
// */
//fun useStringTemplate(a: Int, b: Int): String {
//    return "$a + $b = ${a + b}"
//}
//
///**
// * for循环
// */
//fun forTest() {
//    for (item in list) {
//        println(item)
//    }
//
//    for (index in list.indices) {
//        println("index: " + index.toString())
//    }
//
//    for ((index, value) in list.withIndex()) {
//        println("$index -> $value")
//    }
//
//    for (indexValue in list.withIndex()) {
//        println("${indexValue.index} -> ${indexValue.value}")
//    }
//}
//
///**
// * 使用 vararg 关键字，变长函数
// */
//fun <T> asList(vararg item: T): ArrayList<T> {
//    val result = ArrayList<T>()
//    for (t in item) {
//        result.add(t)
//    }
//    return result
//}
//
///**
// * 延迟加载 在用到helloYe变量的时候，才会去初始化
// */
//val helloYe by lazy {
//    "hello"
//}