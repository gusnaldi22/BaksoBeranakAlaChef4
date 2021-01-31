package com.example.baksoberanakalachef

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase


class TambahMakananActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var etNama : EditText
    private lateinit var etDetail : EditText
    private lateinit var btnSave  : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_makanan)

        etNama = findViewById(R.id.etNama)
        etDetail = findViewById(R.id.etDetail)
        btnSave = findViewById(R.id.btn_simpan)

        btnSave.setOnClickListener(this)
    }

    override fun onClick(check: View) {
        saveData()

    }

    private fun saveData() {
        val nama = etNama.text.toString().trim()
        val detail = etDetail.text.toString().trim()
        if(nama.isEmpty())
        {
            etNama.error = "Isi Nama Baksonya"
        }
        if(detail.isEmpty())
        {
            etDetail.error = "Isi Detail Baksonya"
        }
        val ref = FirebaseDatabase.getInstance().getReference("makanan")

        val mknId = ref.push().key

        val mkn = Makanan(mknId,nama,detail)

        if (mknId != null) {
            ref.child(mknId).setValue(mkn).addOnCompleteListener{
                Toast.makeText(applicationContext, "Data Berhasil di Tambahkan" , Toast.LENGTH_SHORT).show()
                val intentSimpan = Intent(this@TambahMakananActivity, MakananActivity::class.java)
                startActivity(intentSimpan)
            }
        }
    }


}