package com.uc.forestq.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.HorizontalScrollView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.JsonObject
import com.uc.forestq.adapter.ArticleAdapter
import com.uc.forestq.adapter.FaunaAdapter
import com.uc.forestq.adapter.FloraAdapter
import com.uc.forestq.databinding.ActivityHomeBinding
import com.uc.forestq.databinding.ActivityMainBinding
import com.uc.forestq.helper.Const
import com.uc.forestq.model.*
import com.uc.forestq.viewmodel.ArticleViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var viewModel: ArticleViewModel
    private lateinit var articleAdapter: ArticleAdapter
    private lateinit var faunaAdapter: FaunaAdapter
    private lateinit var floraAdapter: FloraAdapter
    private lateinit var horizontalScrollView: LinearLayoutManager
    private lateinit var horizontalScrollView1: LinearLayoutManager
    private lateinit var articleLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        horizontalScrollView = LinearLayoutManager(this)
        horizontalScrollView.orientation = LinearLayoutManager.HORIZONTAL

        horizontalScrollView1 = LinearLayoutManager(this)
        horizontalScrollView1.orientation = LinearLayoutManager.HORIZONTAL

        articleLayoutManager = LinearLayoutManager(this)

        viewModel = ViewModelProvider(this)[ArticleViewModel::class.java]

        //Fauna Adapter RecyclerView
        viewModel.getFauna()

        viewModel.fauna.observe(this, Observer { response->

            binding.faunaRV.layoutManager = horizontalScrollView
            faunaAdapter = FaunaAdapter(response as ArrayList<FaunaData>)
            binding.faunaRV.adapter = faunaAdapter

        })

        //Flora Adapter RecyclerView
        viewModel.getFlora()
        
        viewModel.flora.observe(this, Observer { response->

            binding.floraRV.layoutManager = horizontalScrollView1
            floraAdapter = FloraAdapter(response as ArrayList<FloraData>)
            binding.floraRV.adapter = floraAdapter

        })

        //Article Adapter RecyclerView
        viewModel.getArticle()

        viewModel.article.observe(this, Observer { response->

            binding.articleRV.layoutManager = articleLayoutManager
            articleAdapter = ArticleAdapter(response as ArrayList<ArticleData>)
            binding.articleRV.adapter = articleAdapter
        })
    }
}