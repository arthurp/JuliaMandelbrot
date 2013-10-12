package juliamandelbrot.gui

import scala.swing._
import java.awt.Color
import scala.swing.event._
import java.awt.{ Color, Graphics2D, Point, geom }
import java.awt.image.BufferedImage
import java.awt.geom.AffineTransform
import juliamandelbrot.renderer.Complex

object App extends SimpleSwingApplication {
  val currentImage = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_RGB); 
  def renderImage(iterations : Int, topLeft : Complex, lowerRight : Complex) {
    for(x <- 0 until currentImage.getWidth(); 
        y <- 0 until currentImage.getHeight()) {
      val imaginaryDelta = topLeft.imaginary - lowerRight.imaginary
      val realDelta = lowerRight.real - topLeft.real 
      val c = Complex( x.toFloat / currentImage.getWidth() * realDelta + topLeft.real, 
    		  y.toFloat / currentImage.getHeight() * imaginaryDelta + lowerRight.imaginary)
      
    }
  }
  lazy val canvas = new Panel {
    background = Color.white
    preferredSize = new Dimension(200, 200)

    focusable = true
    listenTo(mouse.clicks)

    reactions += {
      case e: MousePressed =>
        requestFocusInWindow()
      case _: FocusLost => repaint()
    }

    override def paintComponent(g: Graphics2D) = {
      super.paintComponent(g)
      g.drawImage(currentImage, new AffineTransform(), null)
    }
  }
  
  
  
  def top = new MainFrame {
    title = "Mandelbrot Renderer"
    contents = canvas
  }
}