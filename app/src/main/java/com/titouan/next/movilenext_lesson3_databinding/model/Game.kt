package com.titouan.next.movilenext_lesson3_databinding.model

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.android.databinding.library.baseAdapters.BR
import com.titouan.next.movilenext_lesson3_databinding.utils.bindable

class Game(name: String,
           val launchYear: Int,
           val imageUrl: String,
           rating: Double) : BaseObservable() {

    val isClassic = launchYear < 2000

    @get:Bindable
    var rating by bindable(rating, BR.rating)

    @get:Bindable
    var name by bindable(name, BR.name)

}