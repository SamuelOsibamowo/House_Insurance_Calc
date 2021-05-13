package com.example.house_insurance_calc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.house_insurance_calc.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculatePayment.setOnClickListener { calculateInterest() }

    }

    private fun calculateInterest() {
        val stringInTextField = binding.housePrice.text.toString()
        val price = stringInTextField.toDoubleOrNull() ?: return

        var interest = when(binding.thirtyYearInterestRates.checkedRadioButtonId){
            R.id.BOA_interest_30 -> .0275
            else -> .03
        }
        interest /= 12

        val payment = price*(((1+interest).pow(360))*interest)
        val payment2 = ((1+interest).pow(360))-1
        val final = payment/payment2


        NumberFormat.getCurrencyInstance()
        val formattedPayment = NumberFormat.getCurrencyInstance().format(final)

        binding.thePayment.text = formattedPayment.toString()

        //testing how android studio reacts to changes




    }


}