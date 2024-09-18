package com.example.activityefragments

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetalhesActivity : AppCompatActivity() {

    lateinit var buttonFechar: Button
    lateinit var textFilme: TextView

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("ciclo_vida", "onCreate")
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalhes)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        buttonFechar = findViewById(R.id.btn_fecharTela)
        textFilme = findViewById(R.id.textFilme)

        val bundle = intent.extras //contém todos os parametros da outra tela
//        val serie = bundle?.getString("série")
//        val classificacao = bundle?.getInt("classificação")
//        val total = "$serie - $classificacao"
//        textFilme.text = total

        val filme = if(Build.VERSION.SDK_INT >= 33) { //versão >= 33
            bundle?.getSerializable("filme", Filme::class.java)
        }else{
            bundle?.getSerializable("filme") as Filme
        }

        //textFilme.text = "$filme"
        textFilme.text = "${filme?.nome} - ${filme?.descricao}"

        buttonFechar.setOnClickListener {
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        //Carregar dados
        Log.i("ciclo_vida", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("ciclo_vida", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("ciclo_vida", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("ciclo_vida", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("ciclo_vida", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("ciclo_vida", "onDestroy")
    }
}