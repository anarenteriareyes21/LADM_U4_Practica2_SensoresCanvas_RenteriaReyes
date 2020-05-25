package mx.edu.ittepic.ladm_u4_practica2_sensorescanvas_renteriareyes

import android.graphics.*
import android.view.View

public  class Lienzo(p:MainActivity) : View(p){
    var puntero = p
    var b = false
    var cat = FiguraGeometrica( BitmapFactory.decodeResource(resources,
        R.drawable.catblack),10,740)
    var copitos : Array<Copos> =
        Array(150){  //tamaño del arreglo
            Copos((0..1080).random(),(-980..0).random(),2) //mandar x,y,r a Copos
        }

    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        var p = Paint()

        //fondo
        p.color = Color.rgb(4,39,126)
        c.drawRect(0f,0f,1080f,1920f,p)

        //pasto
        //p.color = Color.rgb(82,155,93)
        p.color = Color.rgb(0,0,0)
        c.drawRect(0f,1900f,1080f,1100f,p)


        //-- Arbol ---/
        // -- base --
        //p.color = Color.rgb(83,77,48)
        p.color = Color.rgb(0,0,0)
        c.drawRect(150f,1200f,200f,1000f,p)
        // -- hojas --
        p.color = Color.rgb(0,0,0)
        c.drawCircle(175f,950f,80f,p)
        c.drawCircle(175f,860f,75f,p)
        c.drawCircle(250f,900f,75f,p)
        c.drawCircle(105f,900f,75f,p)

        // -- Luna -- //
        p.color = Color.rgb(255,255,255)
        c.drawCircle(280f,200f,150f,p)
        p.color = Color.rgb(4,39,126)
        c.drawCircle(290f,190f,150f,p)

        cat.pintar(c,p)

        //----------- PINTAR COPITOS DE NIEVE ----//
        p.color = Color.rgb(255,255,255)
        (0..copitos.size-1).forEach {
            copitos[it].dibujar(c,p)
        }
        invalidate()
    }


    /*---------------------------- PROXIMIDAD----------------------------*/
    fun estaCerca(){
        b = true
        var xv = cat.x.toInt()
        cat = FiguraGeometrica( BitmapFactory.decodeResource(resources,
            R.drawable.catmeow),xv,685)
        invalidate()
    }
    fun noEstaCerca(){
        b = false
    }

    fun nevarCopitos() {
        (copitos.indices).forEach() {
            copitos[it].nevar(width) //pasarle el ancho a la funcion
        }
        invalidate()
    }

    /*------------------------------------------ MOVIMIENTO------------------------------------*/
    fun moverDerecha(){
        var xv = cat.x.toInt()
        if(b){
            cat = FiguraGeometrica( BitmapFactory.decodeResource(resources,
                R.drawable.catmeow),xv,685)
        }else{
            cat = FiguraGeometrica( BitmapFactory.decodeResource(resources,
                R.drawable.catblack),xv,740)
        }

        cat.x += cat.incX
        if (cat.x >= 1050){
            cat.x = -300f
        }

    }
    fun moverIzquierda(){
        var xv = cat.x.toInt()
        if(b){
            cat = FiguraGeometrica( BitmapFactory.decodeResource(resources,
                R.drawable.catmeow),xv,685)
        }else{
            cat = FiguraGeometrica( BitmapFactory.decodeResource(resources,
                R.drawable.catblackdos),xv,740)
        }
        cat.x -= cat.incX
        if (cat.x <= -300){
            cat.x = 1050f
        }

    }




}