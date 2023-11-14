package com.example.retrofit_pppb1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit_pppb1.ItemBuahAdapter.Buah
import com.example.retrofit_pppb1.ItemBuahAdapter.BuahItemAdapter
import com.example.retrofit_pppb1.databinding.ActivityMainBinding
import com.example.retrofit_pppb1.model.BuahData
import com.example.retrofit_pppb1.model.BuahModel
import com.example.retrofit_pppb1.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterBuah: BuahItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val client = ApiClient.getInstance()
        val response = client.getBuah()
        val buahDataList = ArrayList<BuahData>() // data yang mau dimasukkan

        response.enqueue(object : Callback<BuahModel> {
            override fun onResponse(call: Call<BuahModel>, response: Response<BuahModel>) {
                val thisResponse = response.body()
                val data = thisResponse?.result ?: emptyList()
                // pengecekan member
                if (data.isNotEmpty()){
                    for (item in data){
                        val itemBuahData = BuahData(
                            item.id,
                            item.title,
                            item.image
                        )
                        buahDataList.add(item)
                    }
                    adapterBuah = BuahItemAdapter(buahDataList) { buah ->
                        Toast.makeText(this@MainActivity, "Mantap Betul", Toast.LENGTH_SHORT).show()
                    }
                    with(binding){
                        rvItemLazday.apply {
                            adapter = adapterBuah
                            layoutManager = LinearLayoutManager(this@MainActivity)
                        }
                    }
                }
            }


            override fun onFailure(call: Call<BuahModel>, t: Throwable) {
                Log.d("error", "" + t.stackTraceToString())
            }

        })

    }
}