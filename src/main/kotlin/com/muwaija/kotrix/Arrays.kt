package com.muwaija.kotrix

import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.max


data class Matrix<T : Number>(var elements: ArrayList<T> = arrayListOf(), var shape: IntArray = intArrayOf(1)) {
//    var shape: IntArray = IntArray(1)
//    var data : Array<T> = elements

    init {

        elements = ArrayList()
        for (i in 0 until count()) {

            elements.add(0 as T)
        }
    }

    private fun count(): Int {
        return count(shape)
    }

    private fun count(arg: IntArray): Int {
        var i = 1

        for (s in arg)
            i *= s
        println("size is $i")
        return i

    }



    operator fun get(i: Int) = elements[i]
    operator fun get(vararg arg: Int): T {


        val required = getIndex(arg)
        if (required > elements.size)
            throw IndexOutOfBoundsException("Index Out Of Bound")

        return elements[required]

    }

    operator fun set(vararg i: Int, d: T) {
        elements[getIndex(i)] = d
    }

    private fun getIndex(i: IntArray): Int {
        var c = 0
        for (x in 0 until i.size - 1) {
            c += shape[x] * i[x]
        }
        c += i.last()
        return c
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


    override fun toString(): String {
        val out = StringBuilder()

//        if (shape.size == 2)
        for (x in 0 until shape[0]) {
            out.append("[")
            for (y in 0 until shape[1]) {
                out.append(this[x, y])
                out.append(" ,")
            }

            out.append("]\n")
        }

        return out.toString() //super.toString()
    }

}



fun matrixOf(vararg elements: Int): Matrix<Int> {
    return Matrix(elements.toList() as ArrayList<Int>, intArrayOf(1))
}

fun matrixOf(vararg elements: ArrayList<Int>): Matrix<Int> {
    val list = arrayListOf<Int>()
    var size = 0
    elements.forEach {
        list += it
        size = max(size, it.size)
    }
    return Matrix(list, intArrayOf(1))
}

public operator fun Matrix<Int>.plus(p : Matrix<Int>): Matrix<Int> {

    if (!this.shape.contentEquals(p.shape))
        throw Exception("Array size error : cannot sum ${this.shape} with ${p.shape}")

    val res = Matrix<Int>(shape = shape)
    for (i in  0 until elements.size ) {
        res[i] = this[i] + p[i]

    }

    return res

}