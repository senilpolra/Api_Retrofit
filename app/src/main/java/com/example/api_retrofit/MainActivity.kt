package com.example.api_retrofit

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.api_retrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getdata()
        binding.hello.setOnClickListener{
            getdata()
        }
    }

    private fun getdata() {

        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Please wait while data is fetch")
        progressDialog.show()

        RetrofitInstance.Api.getdata().enqueue(object : Callback<responceDataClass?> {
            override fun onResponse(
                call: Call<responceDataClass?>,
                response: Response<responceDataClass?>
            ) {
//                binding.hello.text=response.body()?.title
//                binding.hello.text= response.body()?.userId.toString()

                // Api ma Img lava mate
                Glide.with(this@MainActivity).load(response.body()?.url).into(binding.img);

                progressDialog.dismiss()
            }

            override fun onFailure(call: Call<responceDataClass?>, t: Throwable) {
                Toast.makeText(this@MainActivity,"${t.localizedMessage}",Toast.LENGTH_SHORT).show()

                progressDialog.dismiss()

            }

        })
    }
}