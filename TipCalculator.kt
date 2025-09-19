package com.example.tipcalculatorv3

import android.util.Log
import java.text.NumberFormat

class TipCalculator {
    // instance variables
    private var amount : Double = 0.0
    private var tip : Double = .20

    private lateinit var nf : NumberFormat

    init {
        Log.w( "MainActivity", "Inside init" )
        nf = NumberFormat.getCurrencyInstance()
    }

    constructor( newAmount : Double, tip : Double ) {
        Log.w( "MainActivity", "Inside constructor" )
        setAmount( newAmount )
        setTip( tip )
    }

    fun setAmount( newAmount: Double ) : Unit {
        if( newAmount >= 0 )
            amount = newAmount
    }

    fun setAmount2( newAmount: Double ) : TipCalculator {
        if( newAmount >= 0 )
            amount = newAmount
        return this
    }

    fun setTip( tip : Double ) : Unit {
        if( tip >= 0 )
            this.tip = tip
    }

    fun setTip2( tip : Double ) : TipCalculator {
        if( tip >= 0 )
            this.tip = tip
        return this
    }

    fun total(  ) : Double {
        return amount * ( 1 + tip )
    }

    fun formattedTotal( ) : String {
        return nf.format( total( ))
    }

    fun tip(  ) : Double {
        return amount * tip
    }

    fun formattedTip( ) : String {
        return nf.format( tip( ))
    }


    companion object {
        const val TIP : Double = .20
        const val DAYS_IN_WEEK : Int = 7
    }
}