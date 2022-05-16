package com.bahadiryildiz.bookdeneme.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bahadiryildiz.bookdeneme.R
import com.bahadiryildiz.bookdeneme.model.Book
import com.bahadiryildiz.bookdeneme.databinding.ItemviewBookBinding
import com.bumptech.glide.Glide

class Adapter () : RecyclerView.Adapter<Adapter.BookHolder>() {
    var imageClickListener: (String,Int) -> Unit = { _,_-> }
    val booklist: ArrayList<Book> = arrayListOf()

    inner class BookHolder(private val binding: ItemviewBookBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(book: Book) {
            binding.apply {
                tvBookName.text = book.bookName
                tvBookPrice.text = tvBookPrice.context.getString(R.string.book_price, book.bookPrice)
                Glide.with(imageView.context)
                    .load(book.bookImage)
                    .into(imageView)
                imageView.setOnClickListener {
                    imageClickListener(book.bookName,book.bookPrice)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookHolder {
        val binding = ItemviewBookBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BookHolder(binding)
    }

    override fun onBindViewHolder(holder: BookHolder, position: Int) {
            holder.bind(booklist[position])
    }

    override fun getItemCount(): Int {
        return booklist.size
    }
    fun veriyiGetir(bookListData: ArrayList<Book>) {
        booklist.clear()
        booklist.addAll(bookListData)
        notifyDataSetChanged()
    }

}