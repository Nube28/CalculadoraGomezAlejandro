package gomez.alejandro.calculadoraaritmetica

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var operacion: String? = null
    private var valorPrimero: Double? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnUno: Button = findViewById(R.id.btnUno) as Button
        val btnDos: Button = findViewById(R.id.btnDos) as Button
        val btnTres: Button = findViewById(R.id.btnTres) as Button
        val btnCuatro: Button = findViewById(R.id.btnCuatro) as Button
        val btnCinco: Button = findViewById(R.id.btnCinco) as Button
        val btnSeis: Button = findViewById(R.id.btnSeis) as Button
        val btnSiete: Button = findViewById(R.id.btnSiete) as Button
        val btnOcho: Button = findViewById(R.id.btnOcho) as Button
        val btnNueve: Button = findViewById(R.id.btnNueve) as Button
        val btnCero: Button = findViewById(R.id.btnCero) as Button
        val btnLimpiar: Button = findViewById(R.id.btnLimpiar) as Button
        val btnMulti: Button = findViewById(R.id.btnMulti) as Button
        val btnDivision: Button = findViewById(R.id.btnDivision) as Button
        val btnSuma: Button = findViewById(R.id.btnSuma) as Button
        val btnResta: Button = findViewById(R.id.btnResta) as Button
        val btnIgual: Button = findViewById(R.id.btnIgual) as Button
        val txtResultado: TextView = findViewById(R.id.txtResultado) as TextView

        btnUno.setOnClickListener {
            txtResultado.text = "${txtResultado.text}1"
        }

        btnDos.setOnClickListener {
            txtResultado.text = "${txtResultado.text}2"
        }

        btnTres.setOnClickListener {
            txtResultado.text = "${txtResultado.text}3"
        }

        btnCuatro.setOnClickListener {
            txtResultado.text = "${txtResultado.text}4"
        }

        btnCinco.setOnClickListener {
            txtResultado.text = "${txtResultado.text}5"
        }

        btnSeis.setOnClickListener {
            txtResultado.text = "${txtResultado.text}6"
        }

        btnSiete.setOnClickListener {
            txtResultado.text = "${txtResultado.text}7"
        }

        btnOcho.setOnClickListener {
            txtResultado.text = "${txtResultado.text}8"
        }

        btnNueve.setOnClickListener {
            txtResultado.text = "${txtResultado.text}9"
        }

        btnCero.setOnClickListener {
            txtResultado.text = "${txtResultado.text}0"
        }

        btnSuma.setOnClickListener{
            establecerOperacion("+")
            txtResultado.text = ""
        }

    }

    private fun establecerOperacion(op: String) {
        valorPrimero = txtResultado.text.toString().toDoubleOrNull()
        if (valorPrimero != null) {
            operacion = op
        }
    }
}