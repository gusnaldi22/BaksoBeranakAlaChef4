package com.example.baksoberanakalachef

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*

class MinumanActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnTambah : Button
    private lateinit var ref : DatabaseReference
    private lateinit var mnmList : MutableList<Minuman>
    private lateinit var listMnm : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_minuman)

        ref = FirebaseDatabase.getInstance().getReference("minuman")

        btnTambah = findViewById(R.id.btn_tambahM)
        listMnm = findViewById(R.id.lv_mnm)
        btnTambah.setOnClickListener(this)
        mnmList = mutableListOf()
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                if (p0.exists()) {
                    mnmList.clear()
                    for (h in p0.children) {
                        val minuman = h.getValue(Minuman::class.java)
                        if (minuman != null) {
                            mnmList.add(minuman)
                        }
                    }
                    val adapter = MinumanAdapter(applicationContext, R.layout.item, mnmList)
                    listMnm.adapter = adapter
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }



    override fun onClick(check: View) {
        when(check.id) {
            R.id.btn_tambahM -> {
                val intentTambahM = Intent(this@MinumanActivity, TambahMinumanActivity::class.java)
                startActivity(intentTambahM)
            }
        }

    }


}