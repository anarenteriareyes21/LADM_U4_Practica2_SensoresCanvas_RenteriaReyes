package mx.edu.ittepic.ladm_u4_practica2_sensorescanvas_renteriareyes

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Paint
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() , SensorEventListener {
    var hilo : Hilo ?= null
    var miLienzo : Lienzo ?= null
    var sensorCerca = 1f
    /*------------------------------ SENSORES---------------------*/
    lateinit var sensorManager : SensorManager //no asignar memoria ni null
    private lateinit var sensorManager2: SensorManager
    private var mProximity: Sensor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        miLienzo = Lienzo(this)
        setContentView(miLienzo)

        /*------------------ HILO-------------------*/
        hilo = Hilo(this)
        hilo!!.start()


        /*-------------------------- SENSOR DE PROXIMIDAD- -------------*/
        sensorManager2 = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensorManager2.registerListener(this,
            sensorManager2.getDefaultSensor(Sensor.TYPE_PROXIMITY),SensorManager.SENSOR_DELAY_NORMAL)
        mProximity = sensorManager2.getDefaultSensor(Sensor.TYPE_PROXIMITY)


        /*-------------------------- SENSOR GIROSCOPIO- -------------*/
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensorManager.registerListener(this,
            sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
            SensorManager.SENSOR_DELAY_NORMAL) //la clase es quien va a tener los metodos de lectura de los sensores: OnSensorChanged
        //CLASE, TIPO DE SENSOR, VELOCIDAD

    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {


    }

    override fun onSensorChanged(event: SensorEvent) {
        /*-------------------------- PROXIMIDAD----------------------------*/
        if(event.sensor.type == Sensor.TYPE_PROXIMITY){
            sensorCerca = event.values[0]
            val distance = event.values[0]
            if(distance <= 0 ){
                //EL DEDO ESTA ENCIMA
                setTitle("ESTA CERCA")
                miLienzo!!.estaCerca()

            }else{
                setTitle("NO CERCA")
                miLienzo!!.noEstaCerca()

            }
        }
        /*----------------------------- GIROSCOPIO----------------------------*/
        if(event.sensor.type == Sensor.TYPE_ACCELEROMETER){
            //setTitle("X: "+ miLienzo!!.cat.x)
            if(event.values[0] < 0 ){
                miLienzo!!.moverDerecha()

            }
            if (event.values[0] > 0){
                miLienzo!!.moverIzquierda()


            }
        }


    }
}
