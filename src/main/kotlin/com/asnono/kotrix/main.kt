package com.asnono.kotrix

import kotlin.math.PI

fun main(args: Array<String>) {
    var test1 = !PI
    val test2 = !5 + 7
    test1 += !2
    val test3 = 4 j  3
    val test4 = 3 / test3
    val test5 = test2 / test3
    println(test3)
    println(test4)
    println("Test 1 : $test1")
    println("Test 2 : $test2")
    println("Test 3 : $test3")
    println("Test 4 = 3/test2 : $test4")
    println("Test 5 : test2/test3 $test5")
    println("Test 5 : test2/test3 ${test5.toInt()}")

    val a = ArrayList<ArrayList<Int>>()
    val a2 = matrixOf(
            arrayListOf(1,2,3,4),
            arrayListOf(1,2,3,4)
    )

    println(a2.elements.toString())

    val r = arrayListOf(1,2,3,4)
    val r2 = arrayListOf(1,2,3,4)
    val r3 = r + r2
    println(r3)

}