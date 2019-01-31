package com.muwaija.kotrix

fun main(args: Array<String>) {

    val c1 = matrixOf(
            1, 2,
            4, 5,
            7, 8
    )

    c1.shape = intArrayOf(3, 2)

    val c2 = matrixOf(
            1, 2, 3,
            4, 5, 6,
            7, 8, 9
    )

    c2.shape = intArrayOf(3, 3)

    val c3 = c2 matMul c1

    println(c3.toString())

}