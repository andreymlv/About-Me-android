package ru.ndrmlv.aboutme

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import ru.ndrmlv.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val name: Name = Name("Andrey Malov")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.name = name
        binding.doneButton.setOnClickListener {
            addNick(it)
        }
    }

    private fun addNick(view: View) {
        binding.apply {
            name?.nick = nickEdit.text.toString()
            invalidateAll()
            nickEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nickText.visibility = View.VISIBLE
        }
        hideKeyboard(view)
    }

    private fun hideKeyboard(view: View) {
        val inputMethodManager =
            getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}