package com.muwaija.kotrix

import com.muwaija.kotrix.image.Image
import com.muwaija.kotrix.image.convolution3d
import java.awt.Component
import java.awt.Frame
import java.awt.Graphics
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import java.io.File
import javax.imageio.ImageIO

fun main(args: Array<String>) {

    val kernel1 = matrixOf(
//            -1.0, -1.0, -1.0, -1.0, -1.0,
//            -1.0,  2.0,  2.0,  2.0, -1.0,
//            -1.0,  2.0,  8.0,  2.0, -1.0,
//            -1.0,  2.0,  2.0,  2.0, -1.0,
//            -1.0, -1.0, -1.0, -1.0, -1.0

            1.0, 0.0, -1.0,
            2.0, 0.0, -2.0,
            1.0, 0.0, -1.0
    )

    kernel1.shape = intArrayOf(3, 3)

    val image = Image.imread("/Users/useruser/bitmap.png")!!
    Image.imwrite(convolution3d(image.toDouble(), kernel1).map(0, 255).toInt(), "/Users/useruser/bitmapimg1233.png")

    val imge = ImageIO.read(File("/Users/useruser/bitmapimg1233.png"))
    val f = Frame("Hello world")
    f.setSize(600, 600)
    f.add(object : Component() {
        override fun paint(g: Graphics?) {
            super.paint(g)
            g?.drawImage(imge, 0, 0, null)
        }
    })

    f.addWindowListener(object : WindowAdapter() {
        override fun windowClosing(e: WindowEvent?) {
            super.windowClosing(e)
            System.exit(0)
        }
    })
    f.isVisible = true



}