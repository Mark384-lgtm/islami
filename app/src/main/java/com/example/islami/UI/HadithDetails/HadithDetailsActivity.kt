package com.example.islami.UI.HadithDetails

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.islami.UI.home.hadith.HadethDataClass
import com.example.islami.databinding.ActivityHadithDetailsBinding

class HadithDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityHadithDetailsBinding
    var hadeth: HadethDataClass? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHadithDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initviews()
        binding.hadithTitle.text = hadeth?.title
        binding.content.hadithcontent.text = hadeth?.content

    }

    private fun initviews() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            hadeth = intent.getParcelableExtra(Extra_hadithDetails, HadethDataClass::class.java)
        }


    }

    companion object {
        val Extra_hadithDetails = "hadith content"
    }
}