package com.example.islami.UI.home.hadith

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islami.UI.HadithDetails.HadithDetailsActivity
import com.example.islami.databinding.FragmnetHadithBinding

class HadithFragment : Fragment() {
    lateinit var binding: FragmnetHadithBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmnetHadithBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        readAhadeth()
    }


    fun readAhadeth() {
        val ahadethAdapterList: MutableList<HadethDataClass> = mutableListOf()
        val allFileContent = requireContext().assets.open("ahadeth.txt").bufferedReader()
            .use { it.readText() }
        val ahadethList = allFileContent.split('#')

        ahadethList.forEach { hadeth ->
            val hadethLines = hadeth.trim().split("\n").toMutableList()
            val title = hadethLines[0]
            //Log.i("hadeth title",title)
            hadethLines.removeAt(0)
            val h = HadethDataClass(
                title = title,
                content = hadethLines.joinToString("\n")
            )
            ahadethAdapterList.add(h)
        }

        setHadethAdapter(ahadethAdapterList)
    }

    private fun setHadethAdapter(ahadethAdapterList: List<HadethDataClass>) {
        val hadethAdapter = AdapterHadeth(ahadethAdapterList)
        hadethAdapter.onItemClickListner = AdapterHadeth.OnItemClickListner {
            val intent = Intent(context, HadithDetailsActivity::class.java)
            intent.putExtra(HadithDetailsActivity.Extra_hadithDetails, ahadethAdapterList[it])
            startActivity(intent)
        }
        binding.rvAhadith.adapter = hadethAdapter
    }



}