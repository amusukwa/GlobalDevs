package com.example.globaltour.favorite

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.globaltour.R
import com.example.globaltour.city.City


class FavoriteAdapter(val context: Context, var favCityList: ArrayList<City>): RecyclerView.Adapter<FavoriteAdapter.FavCityViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavCityViewHolder {

        val itemView = LayoutInflater.from(context).inflate(R.layout.list_item_favorite, parent, false)
        return FavCityViewHolder(itemView)
    }

    override fun getItemCount(): Int = favCityList.size

    override fun onBindViewHolder(itemViewHolder: FavCityViewHolder, position: Int) {

        val city = favCityList[position]
        itemViewHolder.setData(city, position)
    }

    inner class FavCityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var currentPosition: Int = -1
        private var currentCity: City?   = null

        private val txvCityName = itemView.findViewById<TextView>(R.id.txv_city_name)
        private val imvCityImage= itemView.findViewById<ImageView>(R.id.imv_city)

        fun setData(city: City, position: Int) {

            txvCityName.text = city.name
            imvCityImage.setImageResource(city.imageId)

            this.currentPosition = position
            this.currentCity = city
        }
    }
}
