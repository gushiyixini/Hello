package com.yelj.hello

/**
 * Author: Alex.ylj
 * 2019/3/27 15:29 Wednesday
 * Description:
 */
interface Driver {
    fun onDrive()
}

interface Writer {
    fun onWrite()
}

/**
 * by关键字 代理的方式
 */
class Manager(driver: Driver, writer: Writer) : Driver by driver, Writer by writer

class MyDriver : Driver {
    override fun onDrive() {
        println("开车")
    }
}

class MyWriter : Writer {
    override fun onWrite() {
        println("写作")
    }
}

class Manager1 : Driver, Writer {
    override fun onDrive() {
        println("开车")
    }

    override fun onWrite() {
        println("写作")
    }
}

class Manager2(write: Writer) : Driver, Writer by write {
    override fun onDrive() {

    }
}

fun main(args: Array<String>) {
    val myDriver = MyDriver()
    val myWriter = MyWriter()
    val manager = Manager(myDriver, myWriter)
    manager.onDrive()
    manager.onWrite()

    val manager1 = Manager1()
    manager1.onDrive()
    manager1.onWrite()

    val manager2 = Manager2(myWriter)
    manager2.onDrive()
    manager2.onWrite()
}