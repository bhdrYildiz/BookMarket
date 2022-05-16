package com.bahadiryildiz.bookdeneme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bahadiryildiz.bookdeneme.databinding.ActivityBookDetailsBinding
import com.bahadiryildiz.bookdeneme.model.Book
import kotlinx.android.synthetic.main.activity_book_details.*
import kotlinx.android.synthetic.main.itemview_book.*

class BookDetails : AppCompatActivity() {
    private lateinit var binding : ActivityBookDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        tv_bookName2.text = intent.getStringExtra("bookName")
        tv_bookPrice2.text = intent.getStringExtra("bookPrice")
    }

}