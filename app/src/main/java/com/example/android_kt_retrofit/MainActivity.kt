package com.example.android_kt_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.android_kt_retrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val retroftiTraer = RetrofitClient.consumirApi.getTraer()

        retroftiTraer.enqueue(object : Callback<Persona>{
            override fun onResponse(call: Call<Persona>, response: Response<Persona>) {
                binding.tvMostrar.text = response.body().toString()
            }

            override fun onFailure(call: Call<Persona>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error al consultar Api Rest", Toast.LENGTH_SHORT).show()
            }
        })
    }
}