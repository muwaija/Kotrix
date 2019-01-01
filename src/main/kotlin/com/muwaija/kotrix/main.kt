package com.muwaija.kotrix

import com.muwaija.kotrix.image.Image
import com.muwaija.kotrix.image.convolution3d
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
    val conved = convolution3d(image.toDouble(), kernel1).map(0, 255).toInt()
    Image.imwrite(conved, "/Users/useruser/bitmapimg1234.png")
    Image.imshow(image)
    Image.imshow(conved)
    val imge = ImageIO.read(File("/Users/useruser/bitmapimg1233.png"))


}