package com.titouan.next.movilenext_lesson3_databinding.model

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.android.databinding.library.baseAdapters.BR

class Game(var name: String,
           val launchYear: Int,
           val imageUrl: String,
           rating: Double) : BaseObservable() {

    val isClassic = launchYear < 2000

    var rating = rating
        @Bindable get
        set(value) {
            if (field != value) {
                field = value
                notifyPropertyChanged(BR.rating)
            }
        }

}