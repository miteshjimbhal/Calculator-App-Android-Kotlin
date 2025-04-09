package com.mjtech.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.mjtech.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding inflate
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        //0 to 9 button
        binding.btn00.setOnClickListener { binding.inputTextView.append("00") }
        binding.btn0.setOnClickListener { binding.inputTextView.append("0") }
        binding.btn1.setOnClickListener { binding.inputTextView.append("1") }
        binding.btn2.setOnClickListener { binding.inputTextView.append("2") }
        binding.btn3.setOnClickListener { binding.inputTextView.append("3") }
        binding.btn4.setOnClickListener { binding.inputTextView.append("4") }
        binding.btn5.setOnClickListener { binding.inputTextView.append("5") }
        binding.btn6.setOnClickListener { binding.inputTextView.append("6") }
        binding.btn7.setOnClickListener { binding.inputTextView.append("7") }
        binding.btn8.setOnClickListener { binding.inputTextView.append("8") }
        binding.btn9.setOnClickListener { binding.inputTextView.append("9") }

        //operator buttons
        binding.btnPlus.setOnClickListener { binding.inputTextView.append("+") }
        binding.btnMinus.setOnClickListener { binding.inputTextView.append("-") }
        binding.btnMulti.setOnClickListener { binding.inputTextView.append("*") }
        binding.btnDivide.setOnClickListener { binding.inputTextView.append("/") }
        binding.btnMod.setOnClickListener { binding.inputTextView.append("%") }
        binding.btnDot.setOnClickListener { binding.inputTextView.append(".") }

        //for button AC ( All Clear)
        binding.btnClear.setOnClickListener {
            binding.inputTextView.text = ""
            binding.outputTextView.text = ""
        }

        //button backspace / delete
        binding.btnBackspace.setOnClickListener {
            val input = binding.inputTextView.text.toString()
            if (input.isNotEmpty()) {
                binding.inputTextView.text = input.dropLast(1)
            }
        }

        //equal button
        binding.btnEqualTo.setOnClickListener {
            val expression = binding.inputTextView.text.toString()
            try {
                val result = ExpressionBuilder(expression).build().evaluate()
                binding.outputTextView.text = result.toString()
            }catch (e: Exception) {
                binding.outputTextView.text = "Error"
            }
        }
    }

    //fun to add input to textview
    private fun appendInput(value:String) {
        binding.inputTextView.append(value)
    }
}