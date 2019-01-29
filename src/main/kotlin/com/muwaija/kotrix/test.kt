package com.muwaija.kotrix

import com.muwaija.kotrix.image.Image
import com.muwaija.kotrix.image.convolution3d
import javafx.application.Application
import javafx.embed.swing.SwingFXUtils
import javafx.scene.Scene
import javafx.scene.image.ImageView
import javafx.scene.layout.VBox
import javafx.stage.Stage
import java.awt.Color
import java.awt.image.BufferedImage

class test : javafx.application.Application() {
    override fun start(stage: Stage) {


        val kernel1 = matrixOf(
                1.0, 0.0, -1.0,
                2.0, 0.0, -2.0,
                1.0, 0.0, -1.0
        )

        kernel1.shape = intArrayOf(3, 3)

        val image = Image.imread("/Users/useruser/bitmap.png")!!
//        val image = Image.imread("/Users/useruser/Downloads/f12063879a29e672f675977fabdc89_jumbo.jpeg")!!

        val conv = convolution3d(image.toDouble(), kernel1).map(0, 255)
        val bf = BufferedImage(image.shape[0], image.shape[1], BufferedImage.TYPE_4BYTE_ABGR)
        val x = conv.shape[0]
        val y = conv.shape[1]

        logger.info("Min value in the matrix is: ${conv.min()}")
        logger.info("Max value in the matrix is: ${conv.max()}")
        for (i in 0 until x) {
            for (j in 0 until y) {


                val r = conv[i, j, 0].toInt()
                val g = conv[i, j, 1].toInt()
                val b = conv[i, j, 2].toInt()
                val a = conv[i, j, 3].toInt()

                bf.setRGB(i, j, Color(r, g, b, a).rgb)
            }

        }


        val imgView = ImageView()
        imgView.fitHeight = 400.0
        imgView.fitWidth = 400.0
        imgView.image = SwingFXUtils.toFXImage(bf, null)
        stage.scene = Scene(VBox(imgView))

        stage.show()
    }


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val matrix = Matrix<Double>(shape = intArrayOf(3, 3, 3))
            Application.launch(test::class.java)
            val image = Image.imread("/Users/useruser/bitmaptest.png")
            Image.imwrite(image!!, "/Users/useruser/bitmapimg21.png")
        }
    }
}