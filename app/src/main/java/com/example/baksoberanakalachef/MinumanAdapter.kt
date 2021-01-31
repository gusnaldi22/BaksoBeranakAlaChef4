package com.example.baksoberanakalachef

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class MinumanAdapter(val mCtx : Context, val layoutResId : Int,val mnmList : List<Minuman> ) :ArrayAdapter<Minuman>(mCtx,layoutResId, mnmList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater : LayoutInflater = LayoutInflater.from(mCtx)

        val view : View = layoutInflater.inflate(layoutResId, null)

        val tvNama : TextView = view.findViewById(R.id.tv_Nama)
        val tvDetail : TextView = view.findViewById(R.id.tv_Detail)

        val minuman = mnmList[position]

        tvNama.text = minuman.nama
        tvDetail.text = minuman.detail

        return view
    }
}