package com.uc.forestq.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.JsonArray
import com.uc.forestq.R
import com.uc.forestq.model.ArticleData
import com.uc.forestq.view.ArticleActivity
import org.w3c.dom.Text


class ArticleAdapter(private val dataSet: ArrayList<ArticleData>) :
    RecyclerView.Adapter<ArticleAdapter.ViewHolder>(){

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val articleTitle: TextView
        val articleDate: TextView
        val articleImage: ImageView

        val cardArticle: CardView

        init {
            articleTitle = view.findViewById(R.id.article_title)
            articleDate = view.findViewById(R.id.article_date)
            articleImage = view.findViewById(R.id.article_image)
            cardArticle = view.findViewById(R.id.card_article)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_article, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.articleTitle.text = dataSet[position].article_title
        viewHolder.articleDate.text = dataSet[position].article_date
        viewHolder.cardArticle.setOnClickListener{
            val intent = Intent(it.context, ArticleActivity::class.java)
            intent.putExtra("articleId", dataSet[position].article_id)
            it.context.startActivity(intent)
        }
    }
    override fun getItemCount() = dataSet.size

}