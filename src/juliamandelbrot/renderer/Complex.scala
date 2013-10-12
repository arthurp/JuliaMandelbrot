package juliamandelbrot.renderer
object Complex{
  implicit def fromDouble(real: Double) = Complex(real,0)
}

case class Complex (real: Double, imaginary : Double){
  def +(c: Complex) = Complex (c.real + real,c.imaginary + imaginary)
  def *(c: Complex) = Complex(real * c.real - imaginary * c.imaginary, imaginary * c.real + real * c.imaginary)
  
}