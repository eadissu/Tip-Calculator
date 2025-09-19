package com.example.tipcalculatorv3

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var tipCalc : TipCalculator

    private lateinit var tipET : EditText
    private lateinit var amountET : EditText
    private lateinit var tipTV : TextView
    private lateinit var totalTV : TextView

    private lateinit var button : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tipCalc = TipCalculator( 100.0, .20 )
        tipET = findViewById<EditText>( R.id.amount_percent )
        amountET = findViewById<EditText>( R.id.amount_bill )
        tipTV = findViewById<TextView>( R.id.amount_tip )
        totalTV = findViewById<TextView>( R.id.amount_total )

        button = findViewById<Button>( R.id.button )
        // set up event handling
        button.setOnClickListener { view -> calculate(  ) }
    }

    fun calculate( v : View ) {
        Log.w( "MainActivity", "Inside calculate, v is " + v )12345
    }
    fun calculate( ) {

        // retrieve user input
        var tipPercentS : String = tipET.text.toString()
        var amountS : String = amountET.text.toString()
        // ask model to perform some calculations and update the view
        try {
            var tip : Double = tipPercentS.toDouble() / 100
            var amount : Double = amountS.toDouble()
            // update the model
            tipCalc.setTip( tip )
            tipCalc.setAmount( amount )
            // update the view accordingly
            tipTV.text = tipCalc.formattedTip()
            totalTV.text = tipCalc.formattedTotal()

        } catch( nfe : NumberFormatException ) {
            // need to something here
            Log.w( "MainActivity", "user input missing")
        }
    }
}