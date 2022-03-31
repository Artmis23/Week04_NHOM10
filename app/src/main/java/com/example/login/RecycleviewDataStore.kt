package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.login.R
import com.example.login.adapter.DataStoreAdapter
import com.example.login.databinding.ActivityRecycleviewDataStoreBinding
import com.example.login.model.DataStore
import com.example.login.viewmodel.MainViewModel

class RecycleviewDataStore : AppCompatActivity() {
    lateinit var binding: ActivityRecycleviewDataStoreBinding
    val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycleview_data_store)

        val data = DataStore.getDataSet()
        val adapter = DataStoreAdapter(data)
        val lm = LinearLayoutManager(this)
        binding.rvDataStore.layoutManager = lm
        binding.rvDataStore.adapter = adapter
    }
}