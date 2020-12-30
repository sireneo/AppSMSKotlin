package com.sijc.sms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //boton que permite enviar unmensaje de texto a un numero de celular
        button.setOnClickListener {
            val nrofono = txt_fono.text.toString()
            val mensaje = txt_sms.text.toString()
            try {
                val SmsAdmin = SmsManager.getDefault()
                SmsAdmin.sendTextMessage(nrofono,null,mensaje,null, null)
                Toast.makeText(this,"Mensaje enviado",Toast.LENGTH_SHORT).show()
                txt_fono.text.clear()
                txt_sms.text.clear()
            } catch (e: Exception){
                Toast.makeText(this, "Campos vacios, vuelva a escribir!", Toast.LENGTH_SHORT).show()
            }
        }

    }
}