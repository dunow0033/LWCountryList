package com.express.android.lwretrofit.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.net.Uri
import androidx.recyclerview.widget.RecyclerView
import com.express.android.lwretrofit.R
import com.express.android.lwretrofit.data.CountryModel
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import com.express.android.lwretrofit.databinding.CountryListRowBinding

class CountryListAdapter(val activity: Activity): RecyclerView.Adapter<CountryListAdapter.MyViewHolder>() {

    private var countryList: List<CountryModel>? = null

    fun setCountryList(countryList: List<CountryModel>?) {
        this.countryList = countryList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(CountryListRowBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(countryList?.get(position)!!, activity)
    }

    override fun getItemCount(): Int {
        if(countryList == null)return 0
        else return countryList?.size!!
    }

    class MyViewHolder(val binding: CountryListRowBinding): RecyclerView.ViewHolder(binding.root){
        val flagImage = binding.flagImage
        val tvName = binding.tvName
        val tvCapital = binding.tvCapital
        val tvRegion = binding.tvRegion

        fun bind(data: CountryModel, activity: Activity) {
            tvName.text = data.name +"(" + data.alpha2Code+")"
            tvCapital.text = "Capital: "+data.capital
            tvRegion.text = "Region: "+data.region

            GlideToVectorYou.justLoadImage(activity, Uri.parse(data.flag), flagImage)
        }
    }
}