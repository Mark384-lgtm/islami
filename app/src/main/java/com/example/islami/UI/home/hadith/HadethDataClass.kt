package com.example.islami.UI.home.hadith

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

class HadethDataClass(
    var title: String,
    var content: String
) : Parcelable

