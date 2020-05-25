package mx.edu.ittepic.ladm_u4_practica2_sensorescanvas_renteriareyes

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.view.MotionEvent

class FiguraGeometrica (){
    var x = 0f
    var y = 0f
    var b= false
    var tipo = 1 //1 imagen
    var radio = 0f
    var ancho = 0f
    var alto = 0f
    var incX = 25
    var incY = 5
    var imagen : Bitmap?= null

    /*--------------------- CONSTRUCTOR PARA IMAGEN ---------------------*/
    constructor(imagen : Bitmap, x:Int, y: Int ): this() {
        this.x = x.toFloat()
        this.y = y.toFloat()
        this.imagen = imagen
        ancho = imagen!!.width.toFloat()
        alto = imagen!!.height.toFloat()

    }


    /*---------------------- FUNCION PARA PINTAR ------------------------*/
    fun pintar(c: Canvas, p: Paint){
        c.drawBitmap(imagen!!,x,y,p)

    }





}