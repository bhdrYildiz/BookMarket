package com.bahadiryildiz.bookdeneme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.bahadiryildiz.bookdeneme.adapter.Adapter
import com.bahadiryildiz.bookdeneme.databinding.ActivityMainBinding
import com.bahadiryildiz.bookdeneme.model.Book
import kotlinx.android.synthetic.main.activity_book_details.*
import kotlinx.android.synthetic.main.itemview_book.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var booklist : ArrayList<Book> = arrayListOf()
    private var adapter = Adapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        booklist.add(Book("Hayvan Çiftliği",25,"https://i.dr.com.tr/cache/600x600-0/originals/0000000105409-1.jpg"))
        booklist.add(Book("1984",34,"https://i.dr.com.tr/cache/600x600-0/originals/0000000064038-1.jpg"))
        booklist.add(Book("Cesur Yeni Dünya",34,"https://i.dr.com.tr/cache/600x600-0/originals/0000000066424-1.jpg"))
        booklist.add(Book("50 Soruda Evrim",32,"https://i.dr.com.tr/cache/500x400-0/originals/0001896416001-1.jpg"))
        booklist.add(Book("Tanzimat",56,"https://m.media-amazon.com/images/I/51Uv3M1JWeL._AC_SY1000_.jpg"))
        booklist.add(Book("Maymunlar Gezegeni",28,"https://img.kitapyurdu.com/v1/getImage/fn:11240119/wh:true/miw:200/mih:200"))
        booklist.add(Book("Kayıp Tanrılar Ülkesi",35,"https://static.nadirkitap.com/fotograf/6412/25/Kitap_2021103015124564127.jpg"))
        booklist.add(Book("Fareler ve İnsanlar",34,"https://i.dr.com.tr/cache/600x600-0/originals/0000000411500-1.jpg"))


        binding.rcyclerviewtext.layoutManager = GridLayoutManager(this,2)
        binding.rcyclerviewtext.adapter = adapter

        adapter.veriyiGetir(booklist)

        adapter.imageClickListener = { s: String, i: Int ->
            val intent = Intent(applicationContext,BookDetails::class.java)
            intent.putExtra("bookName",tv_bookName.text.toString())
            intent.putExtra("bookPrice",tv_bookPrice.text.toString())

            startActivity(intent)
        }

    }

}


