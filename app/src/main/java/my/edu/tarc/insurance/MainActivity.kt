package my.edu.tarc.insurance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import my.edu.tarc.insurance.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    //TODO 2 : Create an instance of View Binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //TODO 3 : initialise view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener {
            //TODO 4 : Get input from the user
            val age = binding.spinnerAge.selectedItemPosition
            val gender = binding.radioGroupGender.checkedRadioButtonId
            val smoker = binding.checkBoxSmoker.isChecked
            var premium = 0

            when(age){
                0 -> {premium = 60 }
                1 -> {premium = 70}
                2 -> {premium = 90}
                3 -> {premium = 120}
                4 -> {premium = 150}
                5 -> {premium = 150}
            }
            //if(age==0){
            //    premium = 60
            //}
            if(gender == binding.radioButtonMale.id){
                when(age){
                    1 -> {premium += 50}
                    2 -> {premium += 100}
                    3 -> {premium += 150}
                    4 -> {premium += 200}
                    5 -> {premium += 200}
                }
                //if(age == 1){
                //    premium += 50
                //}else if(age == 2){
                //    premium += 100
                //}else if(age == 3){
                //    premium += 150
                //}else if(age == 4){
                //    premium += 200
                //}else if(age == 5){
                //    premium += 200
                //}
            }else if(gender == binding.radioButtonFemale.id) {
                when(age){
                    1 -> {premium += 100}
                    2 -> {premium += 150}
                    3 -> {premium += 200}
                    4 -> {premium += 250}
                    5 -> {premium += 300}
                }
            }

            if(smoker){
                when(age){
                    1 -> {premium += 100}
                    2 -> {premium += 150}
                    3 -> {premium += 200}
                    4 -> {premium += 250}
                    5 -> {premium += 300}
                }
            }

            val final_premium = NumberFormat.getCurrencyInstance().format(premium)
            binding.textViewPremium.text = final_premium


        }

        binding.buttonReset.setOnClickListener {


        }
    }
}