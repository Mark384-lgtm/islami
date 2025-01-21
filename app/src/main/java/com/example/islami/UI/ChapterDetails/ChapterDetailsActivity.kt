package com.example.islami.UI.ChapterDetails

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R

class ChapterDetailsActivity : AppCompatActivity() {

    lateinit var SuraTitle: String
    var SuraPosition: Int = -1
    lateinit var rv_verses: RecyclerView
    lateinit var versesAdapter: VersesAdapter
    lateinit var Tv_title: TextView
    lateinit var toolbar: Toolbar
    lateinit var verses_list: MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter_details)
        initattributes()
        bindtitle()
        showBackbutton()
        rv_verses.adapter = versesAdapter
    }

    private fun readSuraVerses(): MutableList<String> {
        val sura = assets.open("${SuraPosition + 1}.txt").bufferedReader(Charsets.UTF_8)
            .use { it.readText() }
        Log.e("suraType", sura::class.simpleName ?: "unknown")
        val verses = sura.split('\n')
        Log.e("splitType", verses::class.simpleName ?: "unknown")
        Log.e("ArabicText", verses.toString())
        return verses.toMutableList()
    }

    private fun showBackbutton() {
        setSupportActionBar(toolbar)
        title = null
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }


    private fun bindtitle() {
        Tv_title.text = SuraTitle
    }

    private fun initattributes() {
        SuraPosition = intent.getIntExtra(Extra_position, -1)
        SuraTitle = intent.getStringExtra(Extra_title) ?: " "
        rv_verses = findViewById(R.id.rv_verses)
        Tv_title = findViewById(R.id.sura_title)
        toolbar = findViewById(R.id.toolbar_activitysura)
        verses_list = readSuraVerses()
        versesAdapter = VersesAdapter(verses_list)
    }

    companion object {
        val Extra_title = "title"
        val Extra_position = "position"
    }

}