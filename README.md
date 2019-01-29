# #Kotrix

![img4](assets/img4.jpg)

Free and open source mathematical library for kotlin.

KOTRIX is based on kotlin for kotlin developers, create and compute your nd dimension matrix with it.

------

## Instalation:

we have not release version yet, But you can help us to complete the first version :) .

<br>

------

## 

## Getting Started

##### Complex Variable: 

```kotlin
val x = 2 j 3  // x = 2+j3
val y = 2 + 3! // y = 2+j3
val z = x + y  // z = 4+j6
```

<br>

##### Multi-dimensional Matrix:

You can define a multi-diminsional matrix and make any operations with it, like `+` , `/` , `-` , `*` for matrix by matrix , matrix by element or matrixs for element by element.

```kotlin
var matrix = matrixOf(1,2,3, 4,5,6, 7,8,9) // will return a Matrix<Int>
var floatMatrix = matrixOf(1F,2F,3F, 4F,5F,6F, 7F,8F,9F) // will return a Matrix<Float>
var doubleMatrix = matrixOf(1.0,2.0,3.0, 4.0,5.0,6.0, 7.0,8.0,9.0) // will return a Matrix<Double>
// setting matrix size to 3*3
matrix.shape = intarray(3,3)
// Matrix result is:
// [ [1, 2, 3]
//   [4, 5, 6]
//   [7, 8, 9] ]
```



##### Reading an image as Matrix:

```kotlin
var image = Image.imread("<yor-image-path>")
```

will return an instance of `Matrix<Int>` sized by `imageWidth*imageHeight*4` as image have a 4 colors `red` , `green`, `blue` and `alpha`,  



##### Showing an image Matrix:

```kotlin
var image = Image.imread("<yor-image-path>")
Image.imshow(image)
```



##### Maping matrix:

```kotlin
var matrix = Image.imread("<yor-image-path>")
val normMatrix = matrix.map(0,1) // normalizing matrix
val scaleMatrix = matrix.map(5,10) // scaling all matrix value between 5 and 10
```



# Todo

- [ ] add Options to `imread` function , like reading as gray scale and with `3` colors (not have an `alpha`)
- [ ] reatping option above for `imwrite` function.

### version and feature table:


| Version  | Feature                         |
| :------: | :------------------------------ |
| v0.0.0.1 | support Complex numbers         |
| v0.0.0.2 | support n dimension matrix      |
| v0.0.0.3 | adding imread function          |
| v0.0.0.4 | Fixing matrix index problem     |
| v0.0.0.5 | Supporting convolution function |
| v0.0.0.6 | adding imshow function          |
| v0.0.0.7 | adding map function.            |
|          |                                 |
|          |                                 |

