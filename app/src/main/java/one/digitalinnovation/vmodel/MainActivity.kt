package one.digitalinnovation.vmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var txtContador: EditText
    lateinit var btnDados: Button
    lateinit var btnMostrar: Button
    lateinit var btnZerar: Button

    lateinit var  nViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initDados()
        initClick()
    }

    private fun initClick() {
        btnDados.setOnClickListener {
            nViewModel.Contador()
        }

        btnMostrar.setOnClickListener {
            Toast.makeText(applicationContext, "Valor Contador: ${nViewModel.nContador.value}", Toast.LENGTH_SHORT).show()
        }

        btnZerar.setOnClickListener {
            nViewModel.Zerador()
            Toast.makeText(this, "Valor do contador zerado", Toast.LENGTH_SHORT).show()
        }
    }


    private fun initDados() {
        nViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        txtContador = findViewById(R.id.txtContador)
        btnDados = findViewById(R.id.btnDados)
        btnMostrar = findViewById(R.id.btnMostrar)
        btnZerar = findViewById(R.id.btnZerar)
        nViewModel.nContador.observe(this, Observer { valor ->
            txtContador.setText(valor)
        })
    }
}