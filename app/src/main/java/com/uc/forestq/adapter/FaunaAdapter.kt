package com.uc.forestq.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.uc.forestq.R
import com.uc.forestq.model.FaunaData
import com.uc.forestq.view.FaunaActivity
import org.w3c.dom.Text


class FaunaAdapter(private val dataSet: ArrayList<FaunaData>) :
        RecyclerView.Adapter<FaunaAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val faunaName: TextView
        val faunaPopulation: TextView
        val cardFauna: CardView

        init {
            faunaName = view.findViewById(R.id.fauna_name)
            faunaPopulation = view.findViewById(R.id.fauna_population)
            cardFauna = view.findViewById(R.id.card_fauna)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.card_fauna, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.faunaName.text = dataSet[position].fauna_name
        viewHolder.faunaPopulation.text = dataSet[position].fauna_population
        viewHolder.cardFauna.setOnClickListener{
            val intent = Intent(it.context, FaunaActivity::class.java)
            intent.putExtra("faunaId", dataSet[position].fauna_id)
            it.context.startActivity(intent)
        }
    }
    override fun getItemCount() = dataSet.size

}