package com.muwaija.kotrix.image

import com.muwaija.kotrix.Matrix


fun bound(value: Int, endIndex: Int): Int {
    if (value < 0)
        return 0
    return if (value < endIndex) value else endIndex - 1
}


fun <T : Number> convolution(a: Matrix<T>, b: Matrix<T>) {

}

//@JvmName("convolution2dFloat")
//fun convolution2d(input: Matrix<Float>, kernel: Matrix<Float>): Matrix<Float> {
//
//
//}

fun convolution2d(input: Matrix<Double>, kernel: Matrix<Double>): Matrix<Double> {
    if (input.shape.size != 2 || kernel.shape.size != 2)
        throw IllegalArgumentException("tow input matrix must be in 2 dimension")


    val inputWidth = input.shape[0]
    val inputHeight = input.shape[1]
    val kernelWidth = kernel.shape[0]
    val kernelHeight = kernel.shape[1]

    if (kernelWidth <= 0 || kernelWidth and 1 != 1)
        throw IllegalArgumentException("Kernel must have odd width")
    if (kernelHeight <= 0 || kernelHeight and 1 != 1)
        throw IllegalArgumentException("Kernel must have odd height")

    val kernelWidthRadius = kernelWidth.ushr(1)
    val kernelHeightRadius = kernelHeight.ushr(1)

    val outputData = Matrix<Double>(shape = intArrayOf(inputWidth, inputHeight))
    for (i in inputWidth - 1 downTo 0) {

        for (j in inputHeight - 1 downTo 0) {

            var newValue = 0.0
            for (kw in kernelWidth - 1 downTo 0)
                for (kh in kernelHeight - 1 downTo 0)

                    newValue += (kernel[kw, kh] * input[bound(i + kw - kernelWidthRadius, inputWidth), bound(j + kh - kernelHeightRadius, inputHeight)])


            outputData[i, j] = newValue
        }
    }
    return outputData

}


fun convolution3d(input: Matrix<Double>, kernel: Matrix<Double>): Matrix<Double> {

    if (input.shape.size != 3 || kernel.shape.size != 2)
        throw IllegalArgumentException("tow input matrix must be in 3 dimension")


    val inputWidth = input.shape[0]
    val inputHeight = input.shape[1]
    val inputDepth = input.shape[2]

    val kernelWidth = kernel.shape[0]
    val kernelHeight = kernel.shape[1]

    if (kernelWidth <= 0 || kernelWidth and 1 != 1)
        throw IllegalArgumentException("Kernel must have odd width")

    if (kernelHeight <= 0 || kernelHeight and 1 != 1)
        throw IllegalArgumentException("Kernel must have odd height")

    val kernelWidthRadius = kernelWidth.ushr(1)
    val kernelHeightRadius = kernelHeight.ushr(1)

    val outputData = Matrix<Double>(shape = intArrayOf(inputWidth, inputHeight, inputDepth))

    for (z in 0 until inputDepth) {

        for (i in inputWidth - 1 downTo 0) {

            for (j in inputHeight - 1 downTo 0) {

                var newValue = 0.0
                for (kw in kernelWidth - 1 downTo 0)

                    for (kh in kernelHeight - 1 downTo 0) {
                        val inp = input[bound(i + kw - kernelWidthRadius, inputWidth), bound(j + kh - kernelHeightRadius, inputHeight), z]
                        newValue += kernel[kw, kh] * inp

                    }


                outputData[i, j, z] = newValue
            }
        }

    }

    return outputData


}

