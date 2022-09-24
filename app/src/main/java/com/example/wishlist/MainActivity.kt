package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var emails: List<Wish>

    lateinit var titleEditText: EditText
    lateinit var priceEditText: EditText
    lateinit var urlEditText: EditText
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        titleEditText = findViewById<EditText>(R.id.titleInput) as EditText
        priceEditText= findViewById<EditText>(R.id.priceInput) as EditText
        urlEditText = findViewById<EditText>(R.id.urlInput) as EditText
        button = findViewById<Button>(R.id.submitBtn) as Button


        // Lookup the RecyclerView in activity layout
        val emailsRv = findViewById<RecyclerView>(R.id.wishRv)
        // Fetch the list of emails
        emails = ArrayList()
        // Create adapter passing in the list of emails
        val adapter = WishAdapter(emails)
        // Attach the adapter to the RecyclerView to populate items
        emailsRv.adapter = adapter
        // Set layout manager to position the items
        emailsRv.layoutManager = LinearLayoutManager(this)

        button.setOnClickListener {
            val tle = titleEditText.text.toString()
            val prc = priceEditText.text.toString()
            val urL = urlEditText.text.toString()


            val newEmails = WishFetcher.addEmail(tle,prc,urL)
            // Add new emails to existing list of emails
            titleEditText.text.clear()
            priceEditText.text.clear()
            urlEditText.text.clear()
            (emails as MutableList<Wish>).addAll(newEmails)
            // Notify the adapter there's new emails so the RecyclerView layout is updated
            adapter.notifyDataSetChanged()

        }


    }
}