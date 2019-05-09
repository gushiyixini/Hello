package com.yelj.hello

import java.lang.IllegalArgumentException

/**
 * Author: Alex.ylj
 * 2019/3/27 13:56 Wednesday
 * Description:
 */
interface InputDevice {

    fun inputDevice(event: Any)
}

/**
 * 定义接口 这里继承 InputDevice
 */
interface USBInputDevice : InputDevice

interface BleInputDevice : InputDevice

/**
 * 定义一个类，去使用接口
 */
private class Computer {

    fun addInputDevice(inputDevice: InputDevice) {
        when (inputDevice) {
            is USBInputDevice -> addUSBInputDevice(inputDevice)
            is BleInputDevice -> addBleInputDevice(inputDevice)
            else -> {
                throw IllegalArgumentException("不支持这种类型的设备")
            }
        }
    }

    fun addUSBInputDevice(usbDevice: USBInputDevice) {
        println("输入了一个usb设备 $usbDevice")
    }

    fun addBleInputDevice(bleDevice: BleInputDevice) {
        println("输入了一个ble设备 $bleDevice")
    }
}

/**
 * 定义了一个类，实现了接口
 */
private abstract class MouseDevice(val name: String) : USBInputDevice {

    override fun inputDevice(event: Any) {

    }

    override fun toString(): String {
        return name
    }
}

private class OtherMouse: MouseDevice("罗技鼠标")

fun main(args: Array<String>) {
    val computer = Computer()
//    computer.addInputDevice(MouseDevice("雷蛇鼠标"))
    computer.addInputDevice(OtherMouse())
}