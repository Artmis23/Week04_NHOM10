package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.login.R
import com.example.login.adapter.DataStoreAdapter
import com.example.login.databinding.ActivityRecycleviewDataStoreBinding
import com.example.login.model.DataStore
import com.example.login.viewmodel.MainViewModel


class RecycleviewDataStore : AppCompatActivity() {
    lateinit var binding: ActivityRecycleviewDataStoreBinding
    private val LIST_VIEW = "LIST_VIEW"
    private  val GRID_VIEW = "GRID_VIEW"
    var currentView = LIST_VIEW
    val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecycleviewDataStoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycleview_data_store)
//
//        val data = DataStore.getDataSet()
//        val adapter = DataStoreAdapter(data)
//        val lm = LinearLayoutManager(this)
//        binding.rvDataStore.layoutManager = lm
//        binding.rvDataStore.adapter = adapter

        listView()
        binding.floatingActionButton.setOnClickListener {
            if (currentView == LIST_VIEW){
                binding.floatingActionButton.setImageDrawable(
                    ContextCompat.getDrawable(
                        this@RecycleviewDataStore,
                        R.drawable.ic_list
                    )
                )
                gridView()
            } else{
                binding.floatingActionButton.setImageDrawable(
                    ContextCompat.getDrawable(
                        this@RecycleviewDataStore,
                        R.drawable.ic_grid
                    )
                )
                listView()
            }
        }

    }
    private fun listView(){
        currentView = LIST_VIEW
        binding.rvDataStore.layoutManager = LinearLayoutManager(this)
        binding.rvDataStore.adapter = DataStoreAdapter(DataStore.getDataSet())
    }

    private fun gridView(){
        currentView = GRID_VIEW
        binding.rvDataStore.layoutManager = GridLayoutManager(this,3)
        binding.rvDataStore.adapter = DataStoreAdapter(DataStore.getDataSet())
    }
}