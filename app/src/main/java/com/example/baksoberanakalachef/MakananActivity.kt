package com.example.baksoberanakalachef

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*

class MakananActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnTambah: Button
    private lateinit var ref : DatabaseReference
    private lateinit var mknList : MutableList<Makanan>
    private lateinit var listMkn : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_makanan)

        val ref = FirebaseDatabase.getInstance().getReference("makanan")

        btnTambah = findViewById(R.id.btn_tambah)
        listMkn = findViewById(R.id.lv_mkn)
        btnTambah.setOnClickListener(this)

        mknList = mutableListOf()

        ref.addValueEventListener(object : ValueEventListener
        {
            override fun onDataChange(p0: DataSnapshot) {
                if(p0.exists())
                {
                    mknList.clear()
                    for(h in p0.children)
                    {
                        val makanan = h.getValue(Makanan::class.java)
                        if (makanan != null) {
                            mknList.add(makanan)
                        }
                    }

                    val adapter = MakananAdapter(applicationContext, R.layout.item, mknList)
                    listMkn.adapter = adapter
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

    override fun onClick(check: View) {
        when (check.id) {
            R.id.btn_tambah -> {
                val intentTambah = Intent(this@MakananActivity, TambahMakananActivity::class.java)
                startActivity(intentTambah)
            }

        }

    }
}