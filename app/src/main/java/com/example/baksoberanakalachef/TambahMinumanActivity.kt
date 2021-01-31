package com.example.baksoberanakalachef

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase


class TambahMinumanActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var etNama : EditText
    private lateinit var etDetail : EditText
    private lateinit var btnSave  : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_minuman)

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
            etNama.error = "Isi Nama Minumnya"
        }
        if(detail.isEmpty())
        {
            etDetail.error = "Isi Detail Minumnya"
        }
        val ref = FirebaseDatabase.getInstance().getReference("minuman")

        val mnmId = ref.push().key

        val mnm = Minuman(mnmId,nama,detail)

        if (mnmId != null) {
            ref.child(mnmId).setValue(mnm).addOnCompleteListener{
                Toast.makeText(applicationContext, "Data Berhasil di Tambahkan" , Toast.LENGTH_SHORT).show()
                val intentSimpan = Intent(this@TambahMinumanActivity, MinumanActivity::class.java)
                startActivity(intentSimpan)
            }
        }
    }


}