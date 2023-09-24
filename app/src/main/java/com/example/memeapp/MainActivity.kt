package com.example.memeapp

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {

//    private lateinit var iv_meme : ImageView
    private lateinit var binding:
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = ResultProfileBinding.inflate(layoutInflater)
        val view: View = binding.getRoot()
        setContentView(view)


        loadMeme()

    }

    fun loadMeme(){
//        val textView = findViewById<TextView>(R.id.text)
// ...

// Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url = "https://meme-api.com/gimme/2"

// Request a string response from the provided URL.
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            { response ->
                // Display the first 500 characters of the response string.
//                textView.text = "Response is: ${response.substring(0, 500)}"
                Log.d("Image Load", "Image Load Response is: ")
                    val url = response.getString("url")
                    Glide.with(this).load(url).into()

            },
            {
                Toast.makeText(this,"Something went wrong!", Toast.LENGTH_SHORT).show()
            })

// Add the request to the RequestQueue.
        queue.add(jsonObjectRequest)
    }
    fun shareMeme(view: View) {}
    fun nextMeme(view: View) {}
}