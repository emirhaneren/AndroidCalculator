package com.eren.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    fun btnNumberTik(view: View) {
        if(newOperator){
            showNumbers.setText("")
        }
        newOperator=false
        var btnSec = view as Button
        var btnTikDeger:String = showNumbers.text.toString()

        when(btnSec.id){
            btn0.id->{
                btnTikDeger+="0"
            }
            btn1.id->{
                btnTikDeger+="1"
            }
            btn2.id->{
                btnTikDeger+="2"
            }
            btn3.id->{
                btnTikDeger+="3"
            }
            btn4.id->{
                btnTikDeger+="4"
            }
            btn5.id->{
                btnTikDeger+="5"
            }
            btn6.id->{
                btnTikDeger+="6"
            }
            btn7.id->{
                btnTikDeger+="7"
            }
            btn8.id->{
                btnTikDeger+="8"
            }
            btn9.id->{
                btnTikDeger+="9"
            }
            btnarteks.id->{
                btnTikDeger="-"+btnTikDeger
            }
        }
        showNumbers.setText(btnTikDeger)
    }

    var operator="*"
    var oldNumber=""
    var newOperator=true
    fun btnOpTik(view: View) {
        var btnSec = view as Button
        when(btnSec.id){
            btnblm.id->{
                operator="/"
            }
            btnx.id->{
                operator="X"
            }
            btneks.id->{
                operator="-"
            }
            btnart.id->{
                operator="+"
            }
        }
        oldNumber=showNumbers.text.toString()
        newOperator=true
    }

    fun btnSonTik(view: View){
        var newNumber=showNumbers.text.toString()
        var lastNumber:Double?=null
        when(operator){
            "/"->{
                lastNumber=oldNumber.toDouble()/newNumber.toDouble()
            }
            "X"->{
                lastNumber=oldNumber.toDouble()*newNumber.toDouble()
            }
            "-"->{
                lastNumber=oldNumber.toDouble()-newNumber.toDouble()
            }
            "+"->{
                lastNumber=oldNumber.toDouble()+newNumber.toDouble()
            }
        }
        showNumbers.setText(lastNumber.toString())
        newOperator=true
    }

    fun btnClr(view: View) {
        showNumbers.setText("0")
        newOperator=true
    }

    fun btnYzdTik(view: View) {
        var number:Double=showNumbers.text.toString().toDouble()/100
        showNumbers.setText(number.toString())
        newOperator=true
    }
}