package com.example.maishaboraapp

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var innterestRate: Double? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val num1= findViewById<TextView>(R.id.amounttextview)
        val interestpayable= findViewById<TextView>(R.id.interestpayable)
        val total= findViewById<TextView>(R.id.totalamount)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when(position) {
                    1 -> {
                        tvrate.text = "8%"
                        innterestRate= 0.08
                    }
                    2 -> {
                        tvrate.text = "15%"
                        innterestRate = 0.15
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        val rate= findViewById<TextView>(R.id.ratetextview)
        val confirm= findViewById<Button>(R.id.confirmbtn)
//        val adapter = ArrayAdapter.createFromResource(
//            this,
//            R.array.Terms,
//            android.R.layout.simple_spinner_item
//        )
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//        spinner.adapter = adapter
//        spinner.onItemSelectedListener = this
//
//        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//            val text: String = parent?.getItemAtPosition(position).toString()
//            rate.text = "15%"
//        }

        confirm.setOnClickListener {
            val rate1 = tvrate.text.toString()
            innterestRate?.let {
                val summ=  num1.text.toString().toInt()* it
                val totalamt =num1.text.toString().toInt()+ summ


                interestpayable.text = summ.toString()
                total.text= totalamt.toString()
            }




        }

    }
}


