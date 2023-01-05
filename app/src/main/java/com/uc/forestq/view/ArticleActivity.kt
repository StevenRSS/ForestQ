package com.uc.forestq.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.uc.forestq.databinding.ActivityArticleBinding
import com.uc.forestq.viewmodel.ArticleViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class ArticleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityArticleBinding
    private lateinit var viewModel: ArticleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        viewModel = ViewModelProvider(this)[ArticleViewModel::class.java]

        val articleId = intent.getIntExtra("articleId", 0)

        viewModel.getDetailArticle(articleId)

        viewModel.articleD.observe(this, Observer { response ->

            binding.articleDetailDate.apply {
                text = response.article_date
            }

            binding.articleDetailTitle.apply {
                text = response.article_title
            }

            binding.articleDetailContent.apply {
                text = response.article_content
            }
        })

    }
}