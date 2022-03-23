package com.example.convertcurrency

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.btResult)
        val edtxt1: EditText = findViewById(R.id.ednum1)

        val resultTV: TextView = findViewById(R.id.textResult)
        var flag : String = ""


        val spinnerVal : Spinner = findViewById(R.id.spinnerV)
        var options = arrayOf("USD to JOD","EURO to JOD","JOD to USD","JOD to EURO")
        spinnerVal.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options )




        button.setOnClickListener{ view ->
            var x: Int = edtxt1.text.toString().toInt()


            if(spinnerVal.selectedItem =="USD to JOD")
                resultTV.text = usdtojod(x).toString();
            if(spinnerVal.selectedItem =="EURO to JOD")
                resultTV.text = eurotojod(x).toString();
            if(spinnerVal.selectedItem =="JOD to USD")
                resultTV.text = jodtousd(x).toString();
            if(spinnerVal.selectedItem =="JOD to EURO")
                resultTV.text = jodtoeuro(x).toString();


        }
        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2) //p2 is the index of selected item
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }
}
public fun usdtojod(a: Int): Double {
    return a*0.71
}
public fun eurotojod(a: Int): Double {
    return a*0.78
}
public fun jodtousd(a: Int): Double {
    return a*1.41
}
public fun jodtoeuro(a: Int): Double {
    return a*1.28
}
