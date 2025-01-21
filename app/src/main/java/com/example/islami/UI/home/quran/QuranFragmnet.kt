package com.example.islami.UI.home.quran

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R
import com.example.islami.UI.ChapterDetails.ChapterDetailsActivity


class QuranFragmnet : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragmnet_quran, container, false)
    }

    lateinit var rv_quran: RecyclerView
    lateinit var ref_MyAdapter: Adapter_sur
    val ArSuras: List<String> = listOf(
        "الفاتحه",
        "البقرة",
        "آل عمران",
        "النساء",
        "المائدة",
        "الأنعام",
        "الأعراف",
        "الأنفال",
        "التوبة",
        "يونس",
        "هود",
        "يوسف",
        "الرعد",
        "إبراهيم",
        "الحجر",
        "النحل",
        "الإسراء",
        "الكهف",
        "مريم",
        "طه",
        "الأنبياء",
        "الحج",
        "المؤمنون",
        "النّور",
        "الفرقان",
        "الشعراء",
        "النّمل",
        "القصص",
        "العنكبوت",
        "الرّوم",
        "لقمان",
        "السجدة",
        "الأحزاب",
        "سبأ",
        "فاطر",
        "يس",
        "الصافات",
        "ص",
        "الزمر",
        "غافر",
        "فصّلت",
        "الشورى",
        "الزخرف",
        "الدّخان",
        "الجاثية",
        "الأحقاف",
        "محمد",
        "الفتح",
        "الحجرات",
        "ق",
        "الذاريات",
        "الطور",
        "النجم",
        "القمر",
        "الرحمن",
        "الواقعة",
        "الحديد",
        "المجادلة",
        "الحشر",
        "الممتحنة",
        "الصف",
        "الجمعة",
        "المنافقون",
        "التغابن",
        "الطلاق",
        "التحريم",
        "الملك",
        "القلم",
        "الحاقة",
        "المعارج",
        "نوح",
        "الجن",
        "المزّمّل",
        "المدّثر",
        "القيامة",
        "الإنسان",
        "المرسلات",
        "النبأ",
        "النازعات",
        "عبس",
        "التكوير",
        "الإنفطار",
        "المطفّفين",
        "الإنشقاق",
        "البروج",
        "الطارق",
        "الأعلى",
        "الغاشية",
        "الفجر",
        "البلد",
        "الشمس",
        "الليل",
        "الضحى",
        "الشرح",
        "التين",
        "العلق",
        "القدر",
        "البينة",
        "الزلزلة",
        "العاديات",
        "القارعة",
        "التكاثر",
        "العصر",
        "الهمزة",
        "الفيل",
        "قريش",
        "الماعون",
        "الكوثر",
        "الكافرون",
        "النصر",
        "المسد",
        "الإخلاص",
        "الفلق",
        "الناس"
    )


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val surList = createSur() //create sur objects from sur names
        initattributes(view, surList)//assign and create attributes objects
        addRvItemsClicks()// adding click to recyclarView
        addRvItemDecoration()// adding horizontal separationlines between items
        CountVerses()
        rv_quran.adapter = ref_MyAdapter
    }

    private fun CountVerses() {

        ref_MyAdapter.versesCount = Adapter_sur.CountLines { position ->
            var lineCount = 0
            context?.assets?.open("${position + 1}.txt")?.bufferedReader(Charsets.UTF_8)
                .use { reader ->
                    while (reader?.readLine() != null) {
                        lineCount++
                    }
                }
            return@CountLines lineCount
        }
    }

    private fun initattributes(view: View, surList: MutableList<SurDataCLass>) {
        rv_quran = view.findViewById(R.id.rv_sur)// reference our rv
        ref_MyAdapter = Adapter_sur(surList)// create Adapter object
    }

    private fun addRvItemsClicks() {
        ref_MyAdapter.ref_ItemComponetClick = Adapter_sur.ItemComponentClick { position, title ->
            val intent: Intent = Intent(context, ChapterDetailsActivity::class.java)
            intent.putExtra(ChapterDetailsActivity.Extra_title, title)
            intent.putExtra(ChapterDetailsActivity.Extra_position, position)
            startActivity(intent)
        }
    }

    private fun createSur(): MutableList<SurDataCLass> {
        val listSur: MutableList<SurDataCLass> = mutableListOf()
        for (name in ArSuras) {
            listSur.add(SurDataCLass(name))
        }
        return listSur
    }

    private fun addRvItemDecoration() {
        val dividerItemDecoration = DividerItemDecoration(
            rv_quran.context,
            (rv_quran.layoutManager as LinearLayoutManager).orientation
        )
        rv_quran.addItemDecoration(dividerItemDecoration)

    }

}