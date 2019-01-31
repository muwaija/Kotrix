package com.muwaija.kotrix

fun main(args: Array<String>) {

    val c1 = matrixOf(
            1, 2, 3,
            4, 5, 6,
            7, 8, 9
    )

    c1.shape = intArrayOf(3, 3)

    val c2 = matrixOf(
            1, 2, 3,
            4, 5, 6,
            7, 8, 9
    )

    c2.shape = intArrayOf(3, 3)


    val c3 = c1 f c2


}


infix fun <T : Number> Matrix<T>.f(v: Matrix<T>) {

}