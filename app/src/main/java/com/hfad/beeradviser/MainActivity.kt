package com.hfad.beeradviser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState != null) {
            println("hello world")
        }
        val findBeer = findViewById<Button>(R.id.find_beer)
        findBeer.setOnClickListener {
            val beerColor = findViewById<Spinner>(R.id.beer_color)
            val brands = findViewById<TextView>(R.id.brands)
            val selectedColor = beerColor.selectedItem
            val beersList = getBeers(selectedColor.toString())
            brands.text = beersList.reduce { acc, item -> "$acc \n $item" }
        }
    }

    fun getBeers(color: String): List<String> {
        return when(color) {
            "Light" -> listOf("Jail Pale Ale", "Lager Lite")
            "Amber" -> listOf("Jack Amber", "Red Moose")
            "Brown" -> listOf("Brown Bear Beer", "Bock Brownie")
            else -> listOf("Gout Stout", "Dark Daniel")
        }
    }
}