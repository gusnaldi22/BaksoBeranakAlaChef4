package com.example.baksoberanakalachef

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class MakananAdapter(
    val mCtx : Context, val layoutResId : Int , val mknList: List<Makanan> ) :ArrayAdapter<Makanan>(mCtx, layoutResId, mknList)  {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater : LayoutInflater = LayoutInflater.from(mCtx)
        val view : View = layoutInflater.inflate(layoutResId,null)
        val tvNama : TextView = view.findViewById(R.id.tv_Nama)
        val tvDetail : TextView = view.findViewById(R.id.tv_Detail)

        val makanan = mknList[position]

        tvNama.text = makanan.nama
        tvDetail.text = makanan.detail

        return view
    }
}