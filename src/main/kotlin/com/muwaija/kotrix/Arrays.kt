package com.muwaija.kotrix

import com.sun.istack.internal.logging.Logger
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.max

val logger = Logger.getLogger(Matrix::class.java)

data class Matrix<T : Number>(var elements: ArrayList<T> = arrayListOf(), var shape: IntArray = intArrayOf(1)) {
//    var shape: IntArray = IntArray(1)
//    var data : Array<T> = elements

    init {

        if (elements.isEmpty()) {
            elements = ArrayList()
            for (i in 0 until count()) {
                elements.add(0 as T)
            }
        }
    }

    private fun count(): Int {
        return count(shape)
    }

    private fun count(arg: IntArray): Int {
        var i = 1

        for (s in arg)
            i *= s
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
            var num = 1
            for (j in x + 1 until shape.size) {
                num *= shape[j]
            }
            c += i[x] * num


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
                logger.info("$x, $y")
                out.append(this[x, y])
                out.append(" ,")
            }

            out.append("]\n")
        }

        return out.toString() //super.toString()
    }


}

// [START Matrix operations]

public operator fun Matrix<Float>.div(x: Float): Matrix<Float> {
    val res = Matrix<Float>(shape = shape)
    for (i in 0 until elements.size)
        res[i] = elements[i] / x
    return res
}

public operator fun Matrix<Double>.div(x: Double): Matrix<Double> {
    val res = Matrix<Double>(shape = shape)
    for (i in 0 until elements.size)
        res[i] = elements[i] / x
    return res
}


@JvmName("FloatMatrixPlusInt")
public operator fun Matrix<Float>.plus(x: Int): Matrix<Float> {
    val res = Matrix<Float>(shape = shape)
    for (i in 0 until elements.size)
        res[i] = elements[i] + x
    return res
}

@JvmName("FloatMatrixPlusFloat")
public operator fun Matrix<Float>.plus(x: Float): Matrix<Float> {
    val res = Matrix<Float>(shape = shape)
    for (i in 0 until elements.size)
        res[i] = elements[i] + x
    return res
}

@JvmName("FloatMatrixPlusDouble")
public operator fun Matrix<Float>.plus(x: Double): Matrix<Double> {
    val res = Matrix<Double>(shape = shape)
    for (i in 0 until elements.size)
        res[i] = elements[i] + x

    return res
}

@JvmName("DoubleMatrixPlusInt")
public operator fun Matrix<Double>.plus(x: Int): Matrix<Double> {
    val res = Matrix<Double>(shape = shape)
    for (i in 0 until elements.size)
        res[i] = elements[i] + x
    return res
}

@JvmName("DoubleMatrixPlusFloat")
public operator fun Matrix<Double>.plus(x: Float): Matrix<Double> {
    val res = Matrix<Double>(shape = shape)
    for (i in 0 until elements.size)
        res[i] = elements[i] + x
    return res
}

@JvmName("DoubleMatrixPlusDouble")
public operator fun Matrix<Double>.plus(x: Double): Matrix<Double> {
    val res = Matrix<Double>(shape = shape)
    for (i in 0 until elements.size)
        res[i] = elements[i] + x

    return res
}

@JvmName("IntMatrixPlusInt")
public operator fun Matrix<Int>.plus(x: Int): Matrix<Int> {
    val res = Matrix<Int>(shape = shape)
    for (i in 0 until elements.size)
        res[i] = elements[i] + x
    return res
}

@JvmName("IntMatrixPlusFloat")
public operator fun Matrix<Int>.plus(x: Float): Matrix<Float> {
    val res = Matrix<Float>(shape = shape)
    for (i in 0 until elements.size)
        res[i] = elements[i] + x
    return res
}

@JvmName("IntMatrixPlusDouble")
public operator fun Matrix<Int>.plus(x: Double): Matrix<Double> {
    val res = Matrix<Double>(shape = shape)
    for (i in 0 until elements.size)
        res[i] = elements[i] + x

    return res
}

// Minus
@JvmName("FloatMatrixMinusInt")
public operator fun Matrix<Float>.minus(x: Int): Matrix<Float> {
    val res = Matrix<Float>(shape = shape)
    for (i in 0 until elements.size)
        res[i] = elements[i] - x
    return res
}

@JvmName("FloatMatrixMinusFloat")
public operator fun Matrix<Float>.minus(x: Float): Matrix<Float> {
    val res = Matrix<Float>(shape = shape)
    for (i in 0 until elements.size)
        res[i] = elements[i] - x
    return res
}

@JvmName("FloatMatrixMinusDouble")
public operator fun Matrix<Float>.minus(x: Double): Matrix<Double> {
    val res = Matrix<Double>(shape = shape)
    for (i in 0 until elements.size)
        res[i] = elements[i] - x

    return res
}

@JvmName("DoubleMatrixMinusInt")
public operator fun Matrix<Double>.minus(x: Int): Matrix<Double> {
    val res = Matrix<Double>(shape = shape)
    for (i in 0 until elements.size)
        res[i] = elements[i] - x
    return res
}

@JvmName("DoubleMatrixMinusFloat")
public operator fun Matrix<Double>.minus(x: Float): Matrix<Double> {
    val res = Matrix<Double>(shape = shape)
    for (i in 0 until elements.size)
        res[i] = elements[i] - x
    return res
}

@JvmName("DoubleMatrixMinusDouble")
public operator fun Matrix<Double>.minus(x: Double): Matrix<Double> {
    val res = Matrix<Double>(shape = shape)
    for (i in 0 until elements.size)
        res[i] = elements[i] - x

    return res
}

@JvmName("IntMatrixMinusInt")
public operator fun Matrix<Int>.minus(x: Int): Matrix<Int> {
    val res = Matrix<Int>(shape = shape)
    for (i in 0 until elements.size)
        res[i] = elements[i] - x
    return res
}

@JvmName("IntMatrixMinusFloat")
public operator fun Matrix<Int>.minus(x: Float): Matrix<Float> {
    val res = Matrix<Float>(shape = shape)
    for (i in 0 until elements.size)
        res[i] = elements[i] - x
    return res
}

@JvmName("IntMatrixMinusDouble")
public operator fun Matrix<Int>.minus(x: Double): Matrix<Double> {
    val res = Matrix<Double>(shape = shape)
    for (i in 0 until elements.size)
        res[i] = elements[i] - x

    return res
}


// [END Matrix operations]


fun <T : Number> Matrix<T>.toDouble(): Matrix<Double> {
    val matrix = Matrix<Double>(shape = shape)
    for (e in 0 until elements.size)
        matrix[e] = elements[e].toDouble()

    return matrix

}


fun <T : Number> Matrix<T>.toInt(): Matrix<Int> {
    val matrix = Matrix<Int>(shape = shape)
    for (e in 0 until elements.size)
        matrix[e] = elements[e].toInt()

    return matrix

}


@JvmName("MiniValueDoubleMatrix")
fun Matrix<Double>.min(): Double? {
    val comparator = kotlin.Comparator<Double> { n1, n2 -> (n1 - n2).toInt() }
    return elements.minWith(comparator)
}

@JvmName("MiniValueIntMatrix")
fun Matrix<Float>.min(): Float? {
    val comparator = kotlin.Comparator<Float> { n1, n2 -> (n1 - n2).toInt() }
    return elements.minWith(comparator)
}

@JvmName("MinValueFloatMatrix")
fun Matrix<Int>.min(): Int? {
    val comparator = kotlin.Comparator<Int> { n1, n2 -> n1 - n2 }
    return elements.minWith(comparator)
}


@JvmName("MaxValueDoubleMatrix")
fun Matrix<Double>.max(): Double? {
    val comparator = kotlin.Comparator<Double> { n1, n2 -> (n2 - n1).toInt() }
    return elements.minWith(comparator)
}

@JvmName("MaxValueIntMatrix")
fun Matrix<Float>.max(): Float? {
    val comparator = kotlin.Comparator<Float> { n1, n2 -> (n2 - n1).toInt() }
    return elements.minWith(comparator)
}

@JvmName("MaxValueFloatMatrix")
fun Matrix<Int>.max(): Int? {
    val comparator = kotlin.Comparator<Int> { n1, n2 -> n2 - n1 }
    return elements.minWith(comparator)
}


fun matrixOf(vararg elements: Int): Matrix<Int> {
    return Matrix(elements.toList() as ArrayList<Int>, intArrayOf(1))
}

@JvmName("matrixOfFloat")
fun matrixOf(vararg elements: Float): Matrix<Float> {
    return Matrix(elements.toList() as ArrayList<Float>, intArrayOf(1))
}

@JvmName("matrixOfDouble")
fun matrixOf(vararg elements: Double): Matrix<Double> {
    return Matrix(elements.toList() as ArrayList<Double>, intArrayOf(1))
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

public operator fun Matrix<Int>.plus(p: Matrix<Int>): Matrix<Int> {

    if (!this.shape.contentEquals(p.shape))
        throw Exception("Array size error : cannot sum ${this.shape} with ${p.shape}")

    val res = Matrix<Int>(shape = shape)
    for (i in 0 until elements.size) {
        res[i] = this[i] + p[i]

    }

    return res

}


fun Matrix<Float>.map(start: Float, end: Float): Matrix<Float> {
    val max = max() ?: 0F
    val min = min() ?: 0F
    val diff = max - min
    val toDiff = end - start
    val scale = diff / toDiff
    return ((this - min) / scale) + start
}

fun Matrix<Double>.map(start: Double, end: Double): Matrix<Double> {
    val max = max() ?: 0.0
    val min = min() ?: 0.0
    val diff = max - min
    val toDiff = end - start
    val scale = diff / toDiff
    return ((this - min) / scale) + start
}

@JvmName("DoubleMatrixMapFloat")
fun Matrix<Double>.map(start: Float, end: Float): Matrix<Double> {
    return map(start.toDouble(), end.toDouble())
}

@JvmName("DoubleMatrixMapInt")
fun Matrix<Double>.map(start: Int, end: Int): Matrix<Double> {
    return map(start.toDouble(), end.toDouble())
}

