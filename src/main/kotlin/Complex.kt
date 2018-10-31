import kotlin.math.cos
import kotlin.math.cosh
import kotlin.math.sin
import kotlin.math.sqrt


data class Complex(var rel:Float, var img :Float){
    fun getR() = sqrt(rel*rel + img*img )
    fun getO() = cosh(img / rel)
}

public operator fun Int.not() = Complex(img= this.toFloat(), rel = 0f)
public operator fun Float.not() = Complex(img=this, rel = 0f)
public operator fun Double.not() = Complex(img=this.toFloat(),rel = 0f)


public operator fun Complex.plus(p:Float) = Complex(rel=rel+p, img = img)
public operator fun Complex.plus(p:Int) = Complex(rel=p + rel ,  img=img)
public operator fun Complex.plus(p:Double) = Complex(rel=p.toFloat() + rel ,img= img )
public operator fun Complex.plus(c: Complex) = Complex(rel+c.rel, img + c.img)

public operator fun Float.plus(p:Complex) = Complex(rel=this+p.rel, img = p.img)
public operator fun Int.plus(p:Complex) = Complex(rel=p.rel + this.toFloat() ,  img=p.img)
public operator fun Double.plus(p:Complex) = Complex(rel=p.rel + this.toFloat() ,img= p.img )


public operator fun Float.minus(p:Complex) = Complex(rel=this - p.rel, img = p.img)
public operator fun Int.minus(p:Complex) = Complex(rel=p.rel - this.toFloat() ,  img=p.img)
public operator fun Double.minus(p:Complex) = Complex(rel=p.rel - this.toFloat() ,img= p.img )



public operator fun Complex.minus(p:Float) = Complex(rel=rel-p, img=img)
public operator fun Complex.minus(p:Int) = Complex(rel=p - rel ,  img=img)
public operator fun Complex.minus(p:Double) = Complex(rel=p.toFloat() - rel , img=img )
public operator fun Complex.minus(c: Complex) = Complex(rel-c.rel, img - c.img)


public operator fun Complex.times(p:Float) : Complex{
    val r =getR() * p
    return Complex(r * cos(getO()), r * sin(getO()))
}
public operator fun Complex.times(p:Int) : Complex{
    val r =getR() * p
    return Complex(r * cos(getO()), r * sin(getO()))
}
public operator fun Complex.times(p:Double): Complex{
    val r =getR() * p.toFloat()
    return Complex(r * cos(getO()), r * sin(getO()))
}
public operator fun Complex.times(p:Complex): Complex{
    val r =getR() * p.getR()
    val teta = getO() + p.getO()
    return Complex(r * cos(teta), r * sin(teta))
}


public operator fun Complex.div(p:Float) : Complex{
    val r =getR() / p
    return Complex(r * cos(getO()), r * sin(getO()))
}
public operator fun Complex.div(p:Int): Complex{
    val r =getR() / p
    return Complex(r * cos(getO()), r * sin(getO()))
}
public operator fun Complex.div(p:Double) : Complex{
    val r =getR() / p.toFloat()
    return Complex(r * cos(getO()), r * sin(getO()))
}
public operator fun Complex.div(p:Complex) : Complex{
    val r =getR() / p.getR()
    val teta = getO() - p.getO()
    return Complex(r * cos(teta), r * sin(teta))
}


public infix fun Number.j( c : Number) = Complex(this.toFloat(), c.toFloat() )


