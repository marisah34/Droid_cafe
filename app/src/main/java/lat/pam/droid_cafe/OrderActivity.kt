package lat.pam.droid_cafe

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        var spinner = findViewById<Spinner>(R.id.spinner)
        val city = resources.getStringArray(R.array.City)
        val adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, city)
        spinner.adapter = adapter
    }
    fun onRadioButtonClicked(view: View) {
        // Is the button now checked?
        val checked = (view as RadioButton).isChecked
        when (view.getId()) {
            R.id.sameday -> if (checked) // Same day service
                displayToast(getString(R.string.same_day_messenger_service))


            R.id.nextday -> if (checked) // Next day delivery
                displayToast(getString(R.string.next_day_ground_delivery))


            R.id.pickup -> if (checked) // Pick up
                displayToast(getString(R.string.pick_up))


            else -> {}
        }
    }




    private fun displayToast(message: String) {
        Toast.makeText(
            applicationContext, message,
            Toast.LENGTH_SHORT
        ).show()
    }

}