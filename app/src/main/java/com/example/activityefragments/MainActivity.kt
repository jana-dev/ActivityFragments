package com.example.activityefragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var buttonAbrir: Button

    //onCreate é o primeiro método que é chamado
    //ele é usado para inicializar a activity
    //é chamado apenas uma vez até a activity ser destruida
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("ciclo_vida", "onCreate")

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        buttonAbrir = findViewById(R.id.btn_abrir)
        buttonAbrir.setOnClickListener {
            val intent = Intent(this, DetalhesActivity::class.java)

            //Passar parametros para a outra tela
            intent.putExtra("série", "Game of Thrones")
            intent.putExtra("classificação", 5)

            startActivity(intent)
        }
    }

    //onStart é chamado logo após o onCreate e e define que a activity está sendo inicializada, tornado visivel para o usuario
    override fun onStart() {
        super.onStart()
        //Carregar dados
        Log.i("ciclo_vida", "onStart")
    }

    //onResume é chamado logo após o onStart e define que a activity está em primeiro plano
    //Nessa fase já permite a interação com o usuário
    override fun onResume() {
        super.onResume()
        Log.i("ciclo_vida", "onResume")
    }

    //onPause é chamado assim que outra activity passa para primeiro plano
    override fun onPause() {
        super.onPause()
        Log.i("ciclo_vida", "onPause")
    }

    //onStop é chamado assim que a activity perde o foco e é 'coberta' totalmente
    override fun onStop() {
        super.onStop()
        Log.i("ciclo_vida", "onStop")
    }

    //onRestart é chamado assim que a activity volta para o primeiro plano
    override fun onRestart() {
        super.onRestart()
        Log.i("ciclo_vida", "onRestart")
    }

    //onDestroy é chamado assim que a activity é destruida
    override fun onDestroy() {
        super.onDestroy()
        Log.i("ciclo_vida", "onDestroy")
    }
}