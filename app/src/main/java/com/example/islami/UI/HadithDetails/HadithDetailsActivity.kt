package com.example.islami.UI.HadithDetails

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.islami.databinding.ActivityHadithDetailsBinding

class HadithDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityHadithDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = ActivityHadithDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    companion object {
        val Extra_hadithDetails = "hadith content"
    }
}