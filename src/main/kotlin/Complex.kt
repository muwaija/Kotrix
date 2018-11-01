import kotlin.math.*


data class Complex<T : Number>(var rel:T, var img :T)

fun Complex(rel: Int, img: Int) = Complex<Int>(rel, img)
fun Complex(rel: Float, img: Float) = Complex<Float>(rel, img)
fun Complex(rel: Double, img: Double) = Complex<Double>(rel, img)

public operator fun Int.not() = Complex(img= this.toFloat(), rel = 0f)
public operator fun Float.not() = Complex(img=this, rel = 0f)
public operator fun Double.not() = Complex(img=this.toFloat(),rel = 0f)

@JvmName("IntComplexConjugate")
public operator fun Complex<Int>.not() = Complex(rel, -1* img)
@JvmName("FloatComplexConjugate")
public operator fun Complex<Float>.not() = Complex(rel, -1* img)
@JvmName("DoubleComplexConjugate")
public operator fun Complex<Double>.not() = Complex(rel, -1* img)


@JvmName("IntComplexToFloat")
public fun Complex<Int>.toFloat() = Complex(rel.toFloat(), img.toFloat())
@JvmName("IntComplexToDouble")
public fun Complex<Int>.toDouble() = Complex(rel.toDouble(), img.toDouble())

@JvmName("FloatComplexToInt")
public fun Complex<Float>.toInt() = Complex(rel.toInt(), img.toInt())
@JvmName("FloatComplexToDouble")
public fun Complex<Float>.toDouble() = Complex(rel.toDouble(), img.toDouble())

@JvmName("DoubleComplexToInt")
public fun Complex<Double>.toInt() = Complex(rel.toInt(), img.toInt())
@JvmName("DoubleComplexToDouble")
public fun Complex<Double>.toFloat() = Complex(rel.toFloat(), img.toFloat())



@JvmName("IntComplexR")
public fun Complex<Int>.r() = sqrt((rel*rel + img * img).toDouble())
@JvmName("FloatComplexR")
public fun Complex<Float>.r() = sqrt(rel*rel + img * img)
@JvmName("DoubleComplexR")
public fun Complex<Double>.r() = sqrt(rel*rel + img * img)

@JvmName("IntComplexTeta")
public fun Complex<Int>.t() = atan(img / rel.toDouble() )
@JvmName("FloatComplexTeta")
public fun Complex<Float>.t() = atan(img / rel)
@JvmName("DoubleComplexTeta")
public fun Complex<Double>.t() = atan(img / rel)


// [start] complex<T:Number > + Float
@JvmName("FloatComplexPlusFloat")
public operator fun Complex<Float>.plus(p:Float)= Complex(rel=rel+p, img = img)
@JvmName("DoubleComplexPlusFloat")
public operator fun Complex<Double>.plus(p:Float) = Complex(rel=rel+p, img = img)
@JvmName("IntComplexPlusFloat")
public operator fun Complex<Int>.plus(p:Float) = Complex(rel=rel+p, img = img.toFloat())
// [end] complex<T:Number > + Float


// [start] complex<T:Number > + Int
@JvmName("FloatComplexPlusInt")
public operator fun Complex<Float>.plus(p:Int)= Complex(rel=rel+p, img = img)
@JvmName("DoubleComplexPlusInt")
public operator fun Complex<Double>.plus(p:Int) = Complex(rel=rel+p, img = img)
@JvmName("IntComplexPlusInt")
public operator fun Complex<Int>.plus(p:Int) = Complex(rel=rel+p, img = img.toFloat())
// [end] complex<T:Number > + Int



// [start] complex<T:Number > + Double
@JvmName("FloatComplexPlusDouble")
public operator fun Complex<Float>.plus(p:Double)= Complex(rel=rel+p, img = img)
@JvmName("DoubleComplexPlusDouble")
public operator fun Complex<Double>.plus(p:Double) = Complex(rel=rel+p, img = img)
@JvmName("IntComplexPlusDouble")
public operator fun Complex<Int>.plus(p:Double) = Complex(rel=rel+p, img = img.toFloat())
// [end] complex<T:Number > + double


// [start] Complex<T:Number> + Complex<T:Number>
//      [end] Complex<Int> + Complex<T:Number>
@JvmName("IntComplexPlusDoubleComplex")
public operator fun Complex<Int>.plus(c: Complex<Double>) = Complex(rel+c.rel, img + c.img)
@JvmName("IntComplexPlusFloatComplex")
public operator fun Complex<Int>.plus(c: Complex<Float>) = Complex(rel+c.rel, img + c.img)
@JvmName("IntComplexPlusIntComplex")
public operator fun Complex<Int>.plus(c: Complex<Int>) = Complex(rel+c.rel, img + c.img)
//      [end] Complex<Int> + Complex<T:Number>


//      [start] Complex<Float> + Complex<T:Number>
@JvmName("FloatComplexPlusDoubleComplex")
public operator fun Complex<Float>.plus(c: Complex<Double>) = Complex(rel+c.rel, img + c.img)
@JvmName("FloatComplexPlusFloatComplex")
public operator fun Complex<Float>.plus(c: Complex<Float>) = Complex(rel+c.rel, img + c.img)
@JvmName("FloatComplexPlusIntComplex")
public operator fun Complex<Float>.plus(c: Complex<Int>) = Complex(rel+c.rel, img + c.img)
//      [end] Complex<Float> + Complex<T:Number>

//      [Start] Complex<Double> + Complex<T:Number>
@JvmName("DoubleComplexPlusDoubleComplex")
public operator fun Complex<Double>.plus(c: Complex<Double>) = Complex(rel+c.rel, img + c.img)
@JvmName("DoubleComplexPlusFloatComplex")
public operator fun Complex<Double>.plus(c: Complex<Float>) = Complex(rel+c.rel, img + c.img)
@JvmName("DoubleComplexPlusIntComplex")
public operator fun Complex<Double>.plus(c: Complex<Int>) = Complex(rel+c.rel, img + c.img)
//      [end] Complex<Double> + Complex<T:Number>
// [end] Complex<T:Number> + Complex<T:Number>



// [start] Float + Complex<T:Number>
@JvmName("FloatPlusIntComplex")
public operator fun Float.plus(p:Complex<Int>) = Complex(rel=this+p.rel, img = p.img)
@JvmName("FloatPlusFloatComplex")
public operator fun Float.plus(p:Complex<Float>) = Complex(rel=this+p.rel, img = p.img)
@JvmName("FloatPlusDoubleComplex")
public operator fun Float.plus(p:Complex<Double>) = Complex(rel=this+p.rel, img = p.img)
// [end] Float + Complex<T:Number>

// [start] Int + Complex<T:Number>
@JvmName("IntPlusIntComplex")
public operator fun Int.plus(p:Complex<Int>) = Complex(rel=this+p.rel, img = p.img)
@JvmName("IntPlusFloatComplex")
public operator fun Int.plus(p:Complex<Float>) = Complex(rel=this+p.rel, img = p.img)
@JvmName("IntPlusDoubleComplex")
public operator fun Int.plus(p:Complex<Double>) = Complex(rel=this+p.rel, img = p.img)
// [end] Int + Complex<T:Number>


// [start] Double + Complex<T:Number>
@JvmName("DoublePlusIntComplex")
public operator fun Double.plus(p:Complex<Int>) = Complex(rel=this+p.rel, img = p.img)
@JvmName("DoublePlusFloatComplex")
public operator fun Double.plus(p:Complex<Float>) = Complex(rel=this+p.rel, img = p.img)
@JvmName("DoublePlusDoubleComplex")
public operator fun Double.plus(p:Complex<Double>) = Complex(rel=this+p.rel, img = p.img)
// [end] Double + Complex<T:Number>

// [start] Int - Complex<T:Number>
@JvmName("IntMinusIntComplex")
public operator fun Int.minus(p:Complex<Int>) = Complex(rel=this - p.rel, img = p.img)
@JvmName("IntMinusFloatComplex")
public operator fun Int.minus(p:Complex<Float>) = Complex(rel=this - p.rel, img = p.img)
@JvmName("IntMinusDoubleComplex")
public operator fun Int.minus(p:Complex<Double>) = Complex(rel=this - p.rel, img = p.img)
// [start] Int - Complex<T:Number>


// [start] Float - Complex<T:Number>
@JvmName("FloatMinusIntComplex")
public operator fun Float.minus(p:Complex<Int>) = Complex(rel=this - p.rel, img = p.img)
@JvmName("FloatMinusFloatComplex")
public operator fun Float.minus(p:Complex<Float>) = Complex(rel=this - p.rel, img = p.img)
@JvmName("FloatMinusDoubleComplex")
public operator fun Float.minus(p:Complex<Double>) = Complex(rel=this - p.rel, img = p.img)
// [start] Float - Complex<T:Number>


// [start] Double - Complex<T:Number>
@JvmName("DoubleMinusIntComplex")
public operator fun Double.minus(p:Complex<Int>) = Complex(rel=this - p.rel, img = p.img)
@JvmName("DoubleMinusFloatComplex")
public operator fun Double.minus(p:Complex<Float>) = Complex(rel=this - p.rel, img = p.img)
@JvmName("DoubleMinusDoubleComplex")
public operator fun Double.minus(p:Complex<Double>) = Complex(rel=this - p.rel, img = p.img)
// [start] Double - Complex<T:Number>


// [start] Complex<T:Number> - Complex<T:Number>
//      [end] Complex<Int> - Complex<T:Number>
@JvmName("IntComplexMinusDoubleComplex")
public operator fun Complex<Int>.minus(c: Complex<Double>) = Complex(rel - c.rel, img - c.img)
@JvmName("IntComplexMinusFloatComplex")
public operator fun Complex<Int>.minus(c: Complex<Float>) = Complex(rel - c.rel, img - c.img)
@JvmName("IntComplexMinusIntComplex")
public operator fun Complex<Int>.minus(c: Complex<Int>) = Complex(rel - c.rel, img - c.img)
//      [end] Complex<Int> - Complex<T:Number>


//      [start] Complex<Float> - Complex<T:Number>
@JvmName("FloatComplexMinusDoubleComplex")
public operator fun Complex<Float>.minus(c: Complex<Double>) = Complex(rel - c.rel, img - c.img)
@JvmName("FloatComplexMinusFloatComplex")
public operator fun Complex<Float>.minus(c: Complex<Float>) = Complex(rel - c.rel, img - c.img)
@JvmName("FloatComplexMinusIntComplex")
public operator fun Complex<Float>.minus(c: Complex<Int>) = Complex(rel - c.rel, img - c.img)
//      [end] Complex<Float> - Complex<T:Number>

//      [Start] Complex<Double> - Complex<T:Number>
@JvmName("DoubleComplexMinusDoubleComplex")
public operator fun Complex<Double>.minus(c: Complex<Double>) = Complex(rel - c.rel, img - c.img)
@JvmName("DoubleComplexMinusFloatComplex")
public operator fun Complex<Double>.minus(c: Complex<Float>) = Complex(rel - c.rel, img - c.img)
@JvmName("DoubleComplexMinusIntComplex")
public operator fun Complex<Double>.minus(c: Complex<Int>) = Complex(rel - c.rel, img - c.img)
//      [end] Complex<Double> - Complex<T:Number>
// [end] Complex<T:Number> - Complex<T:Number>






// [start] complex<T:Number > - Float
@JvmName("FloatComplexMinusFloat")
public operator fun Complex<Float>.minus(p:Float)= Complex(rel=rel-p, img = img)
@JvmName("DoubleComplexMinusFloat")
public operator fun Complex<Double>.minus(p:Float) = Complex(rel=rel-p, img = img)
@JvmName("IntComplexMinusFloat")
public operator fun Complex<Int>.minus(p:Float) = Complex(rel=rel-p, img = img)
// [end] complex<T:Number > - Float


// [start] complex<T:Number > - Int
@JvmName("FloatComplexMinusInt")
public operator fun Complex<Float>.minus(p:Int)= Complex(rel=rel-p, img = img)
@JvmName("DoubleComplexMinusInt")
public operator fun Complex<Double>.minus(p:Int) = Complex(rel=rel-p, img = img)
@JvmName("IntComplexMinusInt")
public operator fun Complex<Int>.minus(p:Int) = Complex(rel=rel-p, img = img)
// [end] complex<T:Number > - Int



// [start] complex<T:Number > - Double
@JvmName("FloatComplexMinusDouble")
public operator fun Complex<Float>.minus(p:Double)= Complex(rel=rel-p, img = img)
@JvmName("DoubleComplexMinusDouble")
public operator fun Complex<Double>.minus(p:Double) = Complex(rel=rel-p, img = img)
@JvmName("IntComplexMinusDouble")
public operator fun Complex<Int>.minus(p:Double) = Complex(rel=rel-p, img = img)
// [end] complex<T:Number > - double




// [start] Int * Complex<T:Number>
@JvmName("IntTimesIntComplex")
public operator fun Int.times(p:Complex<Int>) = p * this
@JvmName("IntTimesFloatComplex")
public operator fun Int.times(p:Complex<Float>) = p * this
@JvmName("IntTimesDoubleComplex")
public operator fun Int.times(p:Complex<Double>) = p * this
// [start] Int * Complex<T:Number>


// [start] Float * Complex<T:Number>
@JvmName("FloatTimesIntComplex")
public operator fun Float.times(p:Complex<Int>) =  p * this
@JvmName("FloatTimesFloatComplex")
public operator fun Float.times(p:Complex<Float>) =  p * this
@JvmName("FloatTimesDoubleComplex")
public operator fun Float.times(p:Complex<Double>) =  p * this
// [start] Float * Complex<T:Number>


// [start] Double * Complex<T:Number>
@JvmName("DoubleTimesIntComplex")
public operator fun Double.times(p:Complex<Int>) =  p * this
@JvmName("DoubleTimesFloatComplex")
public operator fun Double.times(p:Complex<Float>) =  p * this
@JvmName("DoubleTimesDoubleComplex")
public operator fun Double.times(p:Complex<Double>) =  p * this
// [start] Double * Complex<T:Number>



// [start] Complex<T:Number> * Int
@JvmName("IntComplexTimesInt")
public operator fun Complex<Int>.times(p:Int)  = Complex(this.rel * p, this.img * p)
@JvmName("FloatComplexTimesInt")
public operator fun Complex<Float>.times(p:Int)  = Complex(this.rel * p, this.img * p)
@JvmName("DoubleComplexTimesInt")
public operator fun Complex<Double>.times(p:Int)  = Complex(this.rel * p, this.img * p)
// [end] Complex<T:Number> * Int

// [start] Complex<T:Number> * Float
@JvmName("IntComplexTimesFloat")
public operator fun Complex<Int>.times(p:Float)  = Complex(this.rel * p, this.img * p)
@JvmName("FloatComplexTimesFloat")
public operator fun Complex<Float>.times(p:Float)  = Complex(this.rel * p, this.img * p)
@JvmName("DoubleComplexTimesFloat")
public operator fun Complex<Double>.times(p:Float)  = Complex(this.rel * p, this.img * p)
// [end] Complex<T:Number> * Float


// [start] Complex<T:Number> * Double
@JvmName("IntComplexTimesDouble")
public operator fun Complex<Int>.times(p:Double)  = Complex(this.rel * p, this.img * p)
@JvmName("FloatComplexTimesDouble")
public operator fun Complex<Float>.times(p:Double)  = Complex(this.rel * p, this.img * p)
@JvmName("DoubleComplexTimesDouble")
public operator fun Complex<Double>.times(p:Double)  = Complex(this.rel * p, this.img * p)
// [end] Complex<T:Number> * Double



// [start] Complex<T:Number> * Complex<T:Number>
//      [end] Complex<Int> * Complex<T:Number>
@JvmName("IntComplexTimesDoubleComplex")
public operator fun Complex<Int>.times(c: Complex<Double>) = Complex(rel * c.rel - img * c.img, img * c.rel + rel * c.img )
@JvmName("IntComplexTimesFloatComplex")
public operator fun Complex<Int>.times(c: Complex<Float>) = Complex(rel * c.rel - img * c.img, img * c.rel + rel * c.img )
@JvmName("IntComplexTimesIntComplex")
public operator fun Complex<Int>.times(c: Complex<Int>) = Complex(rel * c.rel - img * c.img, img * c.rel + rel * c.img )
//      [end] Complex<Int> * Complex<T:Number>


//      [start] Complex<Float> * Complex<T:Number>
@JvmName("FloatComplexTimesDoubleComplex")
public operator fun Complex<Float>.times(c: Complex<Double>) = Complex(rel * c.rel - img * c.img, img * c.rel + rel * c.img )
@JvmName("FloatComplexTimesFloatComplex")
public operator fun Complex<Float>.times(c: Complex<Float>) = Complex(rel * c.rel - img * c.img, img * c.rel + rel * c.img )
@JvmName("FloatComplexTimesIntComplex")
public operator fun Complex<Float>.times(c: Complex<Int>) = Complex(rel - c.rel, img - c.img)
//      [end] Complex<Float> * Complex<T:Number>

//      [Start] Complex<Double> * Complex<T:Number>
@JvmName("DoubleComplexTimesDoubleComplex")
public operator fun Complex<Double>.times(c: Complex<Double>) = Complex(rel * c.rel - img * c.img, img * c.rel + rel * c.img )
@JvmName("DoubleComplexTimesFloatComplex")
public operator fun Complex<Double>.times(c: Complex<Float>) = Complex(rel * c.rel - img * c.img, img * c.rel + rel * c.img )
@JvmName("DoubleComplexTimesIntComplex")
public operator fun Complex<Double>.times(c: Complex<Int>) = Complex(rel * c.rel - img * c.img, img * c.rel + rel * c.img )
//      [end] Complex<Double> * Complex<T:Number>
// [end] Complex<T:Number> * Complex<T:Number>

// [start] Complex<T:Number> / Int
@JvmName("IntComplexDivInt")
public operator fun Complex<Int>.div(p:Int)  = this * (1/p)
@JvmName("FloatComplexDivInt")
public operator fun Complex<Float>.div(p:Int)  = this * (1/p)
@JvmName("DoubleComplexDivInt")
public operator fun Complex<Double>.div(p:Int)  = this * (1/p)
// [end] Complex<T:Number> / Int


// [start] Complex<T:Number> / Float
@JvmName("IntComplexDivFloat")
public operator fun Complex<Int>.div(p:Float)  = this * (1/p)
@JvmName("FloatComplexDivFloat")
public operator fun Complex<Float>.div(p:Float)  = this * (1/p)
@JvmName("DoubleComplexDivFloat")
public operator fun Complex<Double>.div(p:Float)  = this * (1/p)
// [start] Complex<T:Number> / Float

// [end] Complex<T:Number> / Double
@JvmName("IntComplexDivDouble")
public operator fun Complex<Int>.div(p:Double)  = this * (1/p)
@JvmName("FloatComplexDivDouble")
public operator fun Complex<Float>.div(p:Double)  = this * (1/p)
@JvmName("DoubleComplexDivDouble")
public operator fun Complex<Double>.div(p:Double)  = this * (1/p)
// [end] Complex<T:Number> / Double


// [start] Int / Complex<T:Number>
@JvmName("IntDivIntComplex")
public operator fun Int.div(p:Complex<Int>) = this.toDouble() / p.toDouble()
@JvmName("IntDivFloatComplex")
public operator fun Int.div(p:Complex<Float>) = this.toDouble() / p.toDouble()
@JvmName("IntDivDoubleComplex")
public operator fun Int.div(p:Complex<Double>) = this.toDouble() / p
// [end] Int / Complex<T:Number>


// [start] Float / Complex<T:Number>
@JvmName("FloatDivIntComplex")
public operator fun Float.div(p:Complex<Int>) = this.toDouble() / p.toDouble()
@JvmName("FloatDivFloatComplex")
public operator fun Float.div(p:Complex<Float>) =  this.toDouble() / p.toDouble()
@JvmName("FloatDivDoubleComplex")
public operator fun Float.div(p:Complex<Double>) =  this.toDouble() / p
// [end] Float / Complex<T:Number>


// [start] Double / Complex<T:Number>
@JvmName("DoubleDivIntComplex")
public operator fun Double.div(p:Complex<Int>) =  this / p.toDouble()
@JvmName("DoubleDivFloatComplex")
public operator fun Double.div(p:Complex<Float>) =  this / p.toDouble()
@JvmName("DoubleDivDoubleComplex")
public operator fun Double.div(p:Complex<Double>) : Complex<Double> {
    val r = this / p.r()
    val t =  -p.t()
    return Complex(r * cos(t) , r * sin(t))
}
// [end] Double / Complex<T:Number>





// [start] Complex<T:Number> / Complex<T:Number>
//      [end] Complex<Int> / Complex<T:Number>
@JvmName("IntComplexDivDoubleComplex")
public operator fun Complex<Int>.div(c: Complex<Double>) =  this.toDouble() / c
@JvmName("IntComplexDivFloatComplex")
public operator fun Complex<Int>.div(c: Complex<Float>) =  this / c.toDouble()
@JvmName("IntComplexDivIntComplex")
public operator fun Complex<Int>.div(c: Complex<Int>) =  this / c.toDouble()
//      [end] Complex<Int> / Complex<T:Number>


//      [start] Complex<Float> / Complex<T:Number>
@JvmName("FloatComplexDivDoubleComplex")
public operator fun Complex<Float>.div(c: Complex<Double>) = this.toDouble() / c
@JvmName("FloatComplexDivFloatComplex")
public operator fun Complex<Float>.div(c: Complex<Float>) = this / c.toDouble()
@JvmName("FloatComplexDivIntComplex")
public operator fun Complex<Float>.div(c: Complex<Int>) = this / c.toDouble()
//      [end] Complex<Float> / Complex<T:Number>

//      [Start] Complex<Double> / Complex<T:Number>
@JvmName("DoubleComplexDivDoubleComplex")
public operator fun Complex<Double>.div(c: Complex<Double>) = this * ( 1 / c )
@JvmName("DoubleComplexDivFloatComplex")
public operator fun Complex<Double>.div(c: Complex<Float>) = this / c.toDouble()
@JvmName("DoubleComplexDivIntComplex")
public operator fun Complex<Double>.div(c: Complex<Int>) = this / c.toDouble()
//      [end] Complex<Double> * Complex<T:Number>
// [end] Complex<T:Number> * Complex<T:Number>






public infix fun Int.j( c : Int) = Complex(this, c)
public infix fun Double.j( c : Int) = Complex(this, c)
public infix fun Float.j( c : Int) = Complex(this, c)

public infix fun Int.j( c : Float) = Complex(this, c)
public infix fun Double.j( c : Float) = Complex(this, c)
public infix fun Float.j( c : Float) = Complex(this, c)


public infix fun Int.j( c : Double) = Complex(this, c)
public infix fun Double.j( c : Double) = Complex(this, c)
public infix fun Float.j( c : Double) = Complex(this, c)

