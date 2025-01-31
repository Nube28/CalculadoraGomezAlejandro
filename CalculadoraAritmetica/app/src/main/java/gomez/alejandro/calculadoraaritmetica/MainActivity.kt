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
    private lateinit var btnUno: Button
    private lateinit var btnDos: Button
    private lateinit var btnTres: Button
    private lateinit var btnCuatro: Button
    private lateinit var btnCinco: Button
    private lateinit var btnSeis: Button
    private lateinit var btnSiete: Button
    private lateinit var btnOcho: Button
    private lateinit var btnNueve: Button
    private lateinit var btnCero: Button
    private lateinit var btnLimpiar: Button
    private lateinit var btnMulti: Button
    private lateinit var btnDivision: Button
    private lateinit var btnSuma: Button
    private lateinit var btnResta: Button
    private lateinit var btnIgual: Button
    private lateinit var txtResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnUno = findViewById(R.id.btnUno)
        btnDos = findViewById(R.id.btnDos)
        btnTres = findViewById(R.id.btnTres)
        btnCuatro = findViewById(R.id.btnCuatro)
        btnCinco = findViewById(R.id.btnCinco)
        btnSeis = findViewById(R.id.btnSeis)
        btnSiete = findViewById(R.id.btnSiete)
        btnOcho = findViewById(R.id.btnOcho)
        btnNueve = findViewById(R.id.btnNueve)
        btnCero = findViewById(R.id.btnCero)
        btnLimpiar = findViewById(R.id.btnLimpiar)
        btnMulti = findViewById(R.id.btnMulti)
        btnDivision = findViewById(R.id.btnDivision)
        btnSuma = findViewById(R.id.btnSuma)
        btnResta = findViewById(R.id.btnResta)
        btnIgual = findViewById(R.id.btnIgual)
        txtResultado = findViewById(R.id.txtResultado)

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

        btnLimpiar.setOnClickListener {
            txtResultado.text = ""
            limpiarEstado()
        }

        btnSuma.setOnClickListener{
            establecerOperacion("+")
            txtResultado.text = ""
        }

        btnResta.setOnClickListener{
            establecerOperacion("-")
            txtResultado.text = ""
        }

        btnMulti.setOnClickListener{
            establecerOperacion("*")
            txtResultado.text = ""
        }

        btnDivision.setOnClickListener{
            establecerOperacion("/")
            txtResultado.text = ""
        }

        btnIgual.setOnClickListener {
            if (operacion != null && valorPrimero != null) {
                val valorSegundo = txtResultado.text.toString().toDoubleOrNull()
                if (valorSegundo != null) {
                    val resultado = realizarOperacion(valorPrimero!!, valorSegundo, operacion!!)
                    txtResultado.text = resultado.toString()
                    limpiarEstado()
                } else {
                    txtResultado.text = "Error"
                }
            }
        }

    }

    private fun realizarOperacion(valor1: Double, valor2: Double, op: String): Double {
        return when (op) {
            "+" -> valor1 + valor2
            "-" -> valor1 - valor2
            "*" -> valor1 * valor2
            "/" -> if (valor2 != 0.0) valor1 / valor2 else Double.NaN
            else -> Double.NaN
        }
    }

    private fun establecerOperacion(op: String) {
        valorPrimero = txtResultado.text.toString().toDoubleOrNull()
        if (valorPrimero != null) {
            operacion = op
        }
    }

    private fun limpiarEstado() {
        operacion = null
        valorPrimero = null
    }
}