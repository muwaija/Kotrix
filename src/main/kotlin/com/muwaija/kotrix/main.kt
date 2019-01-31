package com.muwaija.kotrix

import com.muwaija.kotrix.image.Image

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

    val image = Image.imread("/Users/ahmed/IdeaProjects/ColonCancer/CVC-ClinicDB/Original/1.tif")!!
    val g_image = Image.imread("/Users/ahmed/IdeaProjects/ColonCancer/CVC-ClinicDB/Ground Truth/1.tif")!!
//    val conved = convolution3d(image.toDouble(), kernel1).map(0, 255).toInt()
//    Image.imwrite(conved, "/Users/useruser/bitmapimg1234.png")
    Image.imshow(image)
    Image.imshow(g_image)
//    val imge = ImageIO.read(File("/Users/useruser/bitmapimg1233.png"))


}