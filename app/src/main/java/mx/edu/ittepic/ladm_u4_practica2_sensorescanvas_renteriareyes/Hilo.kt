package mx.edu.ittepic.ladm_u4_practica2_sensorescanvas_renteriareyes

class Hilo(p:MainActivity): Thread(){
    var puntero = p
    override fun run() {
        super.run()

        while (true){
            sleep(100)
            puntero.runOnUiThread {
                //todo lo que cambia se pone aqui
                //puntero.setTitle("ENTRA AQUI")
                if (puntero.sensorCerca == 0f){
                    puntero.miLienzo!!.nevarCopitos()
                }
            }
        }
    }



}//class