package com.example.discountapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.discountapp.databinding.ActivityMainBinding
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            calculate_discount()
        }
    }

    private fun calculate_discount() {
        val amt=binding.editTextNumber.text.toString().toInt()
       val discount= when(binding.radioGroup.checkedRadioButtonId) {
           R.id.ra->0.10
           else -> 0.0
       }
//        Log.d("mmm",discount.toString())
        var disc=amt * discount
        val rtf=((disc*100).roundToInt())/100
//     Log.d("mmm",disc.toString())
        binding.total.text=amt.toString()
        binding.paybutton.text="Pay"
        val effective= amt-rtf
        binding.payable.text=effective.toString()
        binding.textView7.text="Payable"
        if(discount==0.10) {
            binding.imageView.setImageResource(R.drawable.img)
            binding.resmssg.text = "Congratulations! You earned 10% discount"
            binding.dis.text = rtf.toString()
        }
        else {
            binding.resmssg.text = "Sorry! No discount"
            binding.imageView.setImageResource(R.drawable.ic_launcher_foreground)
            binding.dis.text=""
        }

    }
}