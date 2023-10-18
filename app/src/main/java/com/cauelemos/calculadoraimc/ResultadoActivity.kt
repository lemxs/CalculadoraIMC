package com.cauelemos.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultadoActivity : AppCompatActivity() {

    private lateinit var textPeso: TextView
    private lateinit var textAltura: TextView
    private lateinit var textResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        textPeso = findViewById(R.id.text_peso)
        textAltura = findViewById(R.id.text_altura)
        textResultado = findViewById(R.id.text_resultado)

        val bundle = intent.extras
        if( bundle != null ){
            val peso = bundle.getDouble("peso")
            val altura = bundle.getDouble("altura")

            textPeso.text = "Peso informado: $peso kg"
            textAltura.text = "Altura informada: $altura m"

            val imc = peso / (altura * altura)

            if (imc < 18.5){
                textResultado.text = "Baixo"
            } else if(imc>=18.5 && imc<=24.9){
                textResultado.text = "Normal"
            } else if(imc>=25 && imc<=29.9){
                textResultado.text = "Sobrepeso"
            } else {
                textResultado.text = "Obesidade"
            }
        }
    }
}