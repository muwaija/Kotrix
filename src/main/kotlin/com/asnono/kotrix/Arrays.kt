package com.asnono.kotrix

import java.util.*
import kotlin.collections.ArrayList


data class Matrix<T>(val elements: ArrayList<T> = arrayListOf(), var shape: IntArray = intArrayOf(1)) {
//    var shape: IntArray = IntArray(1)
//    var data : Array<T> = elements



    operator fun get(i: Int) = elements[i]
    operator fun get(vararg arg: Int): T {


        val total = {
            var t = 1
            for (i in arg)
               t *= i
            t
        }

        val required = total()
        if (required > elements.size)
            throw IndexOutOfBoundsException("Index Out Of Bound")

        return elements[required]

    }

    fun set(i: Int, d: T) {
        elements.add(i,d)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Matrix<*>

        if (elements != other.elements) return false
        if (!Arrays.equals(shape, other.shape)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = elements.hashCode()
        result = 31 * result + Arrays.hashCode(shape)
        return result
    }

}



fun matrixOf(vararg elements: Int): Matrix<Int> {
    return Matrix(elements.toList() as ArrayList<Int>, intArrayOf(1))
}

fun matrixOf(vararg elements: ArrayList<Int>): Matrix<Int> {
    val list = arrayListOf<Int>()
    var size = 0
    elements.forEach {
        list.plus(it)
    }
    return Matrix(list, intArrayOf(1))
}

public operator fun Matrix<Int>.plus(p : Matrix<Int>): Matrix<Int> {

    if (!this.shape.contentEquals(p.shape))
        throw Exception("Array size error : cannot sum ${this.shape} with ${p.shape}")

    val res = Matrix<Int>(shape=shape)
    for (i in  0 until elements.size ) {
        res.set(i,this[i] + p[i])

    }

    return res

}