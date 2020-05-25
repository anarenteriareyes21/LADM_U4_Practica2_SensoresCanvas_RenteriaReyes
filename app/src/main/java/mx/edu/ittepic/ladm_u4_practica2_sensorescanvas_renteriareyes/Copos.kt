package mx.edu.ittepic.ladm_u4_practica2_sensorescanvas_renteriareyes

import android.graphics.Canvas
import android.graphics.Paint

class Copos(){
    //Declaracion de variables
    var x = 0f
    var y = 0f
    var r = 0f
    var IncY = 5f

    constructor(x:Int, y: Int, r: Int):this(){
        this.x = x.toFloat()
        this.y = y.toFloat()
        this.r = r.toFloat()
    }

    // -------- METODO PARA PINTAR LOS COPOS DE NIEVE ----//
    fun dibujar (c : Canvas, paint: Paint){
        c.drawCircle(x,y,r,paint)

    }
    //------------- METODO PARA QUE LOS COPOS CAIGAN ---//
    fun nevar(alto : Int){
        y += IncY
        if(y >= alto){
            y=-40f
        }

    }





}