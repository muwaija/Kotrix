package com.muwaija.kotrix.Image

import com.muwaija.kotrix.Matrix
import java.awt.Color
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import javax.imageio.ImageIO


object Image {


    fun imread(path: String): Matrix<Float>? {

        if (!Files.exists(Paths.get(path)))
            return null


        val file = File(path)


        val img = ImageIO.read(file)
        val x = img.width
        val y = img.height
        val z = 4

        var s = System.currentTimeMillis()
        val result = Matrix<Float>(shape = intArrayOf(x, y, z))
        println("Initialize time = ${System.currentTimeMillis() - s}")
        s = System.currentTimeMillis()

        for (dx in 0 until x) {

            for (dy in 0 until y) {
                val color = Color(img.getRGB(dx, dy))
                val blue = color.blue
                val red = color.red
                val green = color.green
                val alpha = color.alpha

                result[dx, dy, 0] = red / 255F
                result[dx, dy, 1] = green / 255F
                result[dx, dy, 2] = blue / 255F
                result[dx, dy, 4] = alpha / 255F

            }

        }

        print("total time : ")
        println(System.currentTimeMillis() - s)
        return result
    }
}