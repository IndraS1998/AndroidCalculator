package com.example.newcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val clearBtn:Button = findViewById(R.id.clear)
    }
    /*      ###     STATE       ###*/
    private var op:String = ""
    private var firstOperand:String = ""


    /*      ###     METHODS     ####*/
    /*
    *       TODO
    *        1- a number cant contain two decimal points
    *        2- toggle negation
    * */
    fun onClickNumber(v : View){
        val editText = findViewById<EditText>(R.id.ET1)
        val clickedBtn: Button = v as Button
        var defaultStr: String = editText.text.toString()

        when(clickedBtn.id){
            R.id.button0 ->{
                defaultStr += "0"
            }
            R.id.button1 ->{
                defaultStr += "1"
            }
            R.id.button2 ->{
                defaultStr += "2"
            }
            R.id.button3 ->{
                defaultStr += "3"
            }
            R.id.button4 ->{
                defaultStr += "4"
            }
            R.id.button5 ->{
                defaultStr += "5"
            }
            R.id.button6 ->{
                defaultStr += "6"
            }
            R.id.button7 ->{
                defaultStr += "7"
            }
            R.id.button8 ->{
                defaultStr += "8"
            }
            R.id.button9 ->{
                defaultStr += "9"
            }
            R.id.point ->{
                defaultStr += "."
            }
            R.id.negate ->{
                defaultStr = "-$defaultStr"
            }
        }
        editText.setText(defaultStr)
    }

    /*
    *       TODO
    *        implement percentage
    * */
    fun onEval(v : View){
        var result:Double = 0.0
        val editText = findViewById<EditText>(R.id.ET1)
        val secondOperand:String = editText.text.toString()
        when(op){
            "+"->{result = firstOperand.toDouble() + secondOperand.toDouble()}
            "-"->{result = firstOperand.toDouble() - secondOperand.toDouble()}
            "/"->{result = firstOperand.toDouble() / secondOperand.toDouble()}
            "*"->{result = firstOperand.toDouble() * secondOperand.toDouble()}
        }
        editText.setText("$result")
    }

    /*
    *       TODO
    *        *cannot contain 2 operators
    * */
    fun onOperate(v : View){
        val editText = findViewById<EditText>(R.id.ET1)
        val btnClicked:Button = v as Button
        when(btnClicked.id){
            R.id.buttonDivide ->{
                op = "/"
            }
            R.id.buttonAdd ->{
                op = "+"
            }
            R.id.buttonSub ->{
                op = "-"
            }
            R.id.buttonMul ->{
                op = "*"
            }
            R.id.percent ->{
                op = "%"
            }
        }
        firstOperand = editText.text.toString()
        editText.setText("")
    }

    /*
    *       TODO
    *        implement onLongPress
    * */
    fun onClear(v : View){
        val editTextInput = findViewById<EditText>(R.id.ET1)
        firstOperand = ""
        editTextInput.setText("")
    }

    fun onDelete(v : View){
        val editTextInput = findViewById<EditText>(R.id.ET1)
        var originalText:String = editTextInput.text.toString()
        originalText = originalText.dropLast(1)
        editTextInput.setText(originalText.toString())
    }
}