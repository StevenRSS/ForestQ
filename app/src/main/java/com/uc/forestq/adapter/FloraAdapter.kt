package com.uc.forestq.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.uc.forestq.R
import com.uc.forestq.model.FloraData
import com.uc.forestq.view.FloraActivity
import org.w3c.dom.Text


class FloraAdapter(private val dataSet: ArrayList<FloraData>) :
    RecyclerView.Adapter<FloraAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val floraName: TextView
        val floraPopulation: TextView
        val cardFlora: CardView

        init {
            floraName = view.findViewById(R.id.flora_name)
            floraPopulation = view.findViewById(R.id.flora_population)
            cardFlora = view.findViewById(R.id.card_flora)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_flora, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.floraName.text = dataSet[position].flora_name
        viewHolder.floraPopulation.text = dataSet[position].flora_population
        viewHolder.cardFlora.setOnClickListener{
            val intent = Intent(it.context, FloraActivity::class.java)
            intent.putExtra("floraId", dataSet[position].flora_id)
            it.context.startActivity(intent)
        }
    }
    override fun getItemCount() = dataSet.size

}