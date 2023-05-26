package com.example.retrofitapi

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: UserAdaper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



       getData()
    }

    private fun getData() {

        val progressBar = ProgressDialog(this)
        progressBar.setMessage("Please wait while data is fetch")
        progressBar.show()

        RetrofitInstance.apiInterface.getAarti().enqueue(object : Callback<UserModel?> {
            override fun onResponse(call: Call<UserModel?>, response: Response<UserModel?>) {

                val userModel: UserModel? = response.body()

                progressBar.dismiss()

                recycler.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL,
                    false)
                recycler.itemAnimator =null

                adapter = userModel?.let { UserAdaper(it) }!!
                recycler.adapter = adapter
//                Toast.makeText(this@MainActivity, "data is fetching", Toast.LENGTH_SHORT).show()


            }

            override fun onFailure(call: Call<UserModel?>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                progressBar.dismiss()
            }
        })

        RetrofitInstance.apiInterface.getChalisa().enqueue(object : Callback<UserModel?> {
            override fun onResponse(call: Call<UserModel?>, response: Response<UserModel?>) {

                val userModel: UserModel? = response.body()

                progressBar.dismiss()

                recycler2.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL,
                    false)
                recycler2.itemAnimator =null

                adapter = userModel?.let { UserAdaper(it) }!!
                recycler2.adapter = adapter
//                Toast.makeText(this@MainActivity, "data is fetching", Toast.LENGTH_SHORT).show()


            }

            override fun onFailure(call: Call<UserModel?>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                progressBar.dismiss()
            }
        })
    }
}

