package com.muwaija.kotrix.image

import com.muwaija.kotrix.Matrix
import com.muwaija.kotrix.logger
import java.awt.Color
import java.awt.Component
import java.awt.Frame
import java.awt.Graphics
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import java.awt.image.BufferedImage
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import javax.imageio.ImageIO


object Image {


    fun imread(path: String): Matrix<Int>? {

        if (!Files.exists(Paths.get(path)))
            return null


        val file = File(path)


        val img = ImageIO.read(file)
        val x = img.width
        val y = img.height
        val z = 4
        logger.info("image width $x")
        logger.info("image height $y")
        var s = System.currentTimeMillis()
        val result = Matrix<Int>(shape = intArrayOf(x, y, z))
        println("Initialize time = ${System.currentTimeMillis() - s}")
        s = System.currentTimeMillis()

        for (dx in 0 until x) {

            for (dy in 0 until y) {
                val color = Color(img.getRGB(dx, dy))
                val blue = color.blue
                val red = color.red
                val green = color.green
                val alpha = color.alpha

                result[dx, dy, 0] = red
                result[dx, dy, 1] = green
                result[dx, dy, 2] = blue
                result[dx, dy, 3] = alpha

                if (result[dx, dy, 0] != red || result[dx, dy, 2] != blue || result[dx, dy, 1] != green) {
                    logger.info("$dx $dy  exact Color = $red, $green, $blue, $alpha .. " +
                            "found color ${result[dx, dy, 0]}, ${result[dx, dy, 1]}, ${result[dx, dy, 2]}, ${result[dx, dy, 3]}")
                }

            }

        }

        logger.info("total time : ${System.currentTimeMillis() - s}")
        return result
    }


    fun imwrite(a: Matrix<Int>, path: String) {

        val width = a.shape[0]
        val height = a.shape[1]
        val depth = if (a.shape.size > 2) a.shape[2] else 0
        println("Writing an image")
        logger.info("write width $width")
        logger.info("write height $height")
        val outputImage = BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB)
        logger.info("Depth = $depth")
        if (depth != 0) {
//            for (z in 0 until  depth) {
            for (y in 0 until height) {
                for (x in 0 until width) {

                    val red = a[x, y, 0]
                    val green = a[x, y, 1]
                    val blue = a[x, y, 2]
                    val alpha = a[x, y, 3]
//                        logger.info("Color = $red, $green, $blue")
                    outputImage.setRGB(x, y, Color(red, green, blue, alpha).rgb)
                }
            }
//            }
        } else {

            for (y in 0 until height) {
                for (x in 0 until width) {
                    val red = a[x, y, 0]
                    val green = a[x, y, 1]
                    val blue = a[x, y, 2]
                    val alpha = a[x, y, 3]
//                    outputImage.setRGB(x, y, red shl 16 or (green shl 8) or blue or -0x01000000)
                    outputImage.setRGB(x, y, Color(red, green, blue, alpha).rgb)
                }
            }
        }


        if (ImageIO.write(outputImage, "PNG", File(path)))
            logger.info("Image has saved")
        else
            logger.info("Image has not saved")

    }


    fun imshow(img: Matrix<Int>) {

        val width = img.shape[0]
        val height = img.shape[1]
        val depth = if (img.shape.size > 2) img.shape[2] else 0

        val bufferedImage = BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB)
        for (x in 0 until width) {
            for (y in 0 until height) {

                val red = img[x, y, 0]
                val green = img[x, y, 1]
                val blue = img[x, y, 2]
                val alpha = img[x, y, 3]
                bufferedImage.setRGB(x, y, Color(red, green, blue, alpha).rgb)
            }
        }


        ShowImage(bufferedImage)


    }

    private class ShowImage(image: BufferedImage) : Frame() {
        init {
            val margin = 20

            setSize(image.tileWidth + margin, image.tileHeight * 105 / 100 + margin)
            add(Image(image))
            isVisible = true

            addWindowListener(object : WindowAdapter() {
                override fun windowClosing(e: WindowEvent?) {
                    super.windowClosing(e)
                    System.exit(0)
                }
            })

        }


    }

    private class Image(var image: BufferedImage? = null) : Component() {

        init {
            setSize(image?.width ?: 0, image?.height ?: 0)
        }

        override fun paint(g: Graphics?) {
            super.paint(g)
            val margin = 10
            if (image != null) {
                g?.drawImage(image, margin, margin, image?.width ?: 0+margin, image?.height ?: 0+margin, null)
            }
        }


    }
}