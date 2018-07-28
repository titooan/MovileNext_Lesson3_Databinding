package com.titouan.next.movilenext_lesson3_databinding.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jakewharton.rxbinding2.widget.RxTextView
import com.titouan.next.movilenext_lesson3_databinding.R
import io.reactivex.BackpressureStrategy
import io.reactivex.rxkotlin.Flowables
import kotlinx.android.synthetic.main.activity_game_add.*

class GameAddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_add)

        val nameChangeObservable = RxTextView
                .textChanges(etName)
                .skip(1)
                .toFlowable(BackpressureStrategy.LATEST)

        val yearChangeObservable = RxTextView
                .textChanges(etYear)
                .skip(1)
                .toFlowable(BackpressureStrategy.LATEST)

        Flowables.combineLatest(nameChangeObservable, yearChangeObservable) { newName: CharSequence,
                                                                              newYear: CharSequence ->

            val nameValid = newName.length > 3
            if (!nameValid) etName.error = "Invalid name"

            val yearValid = newYear.length == 4
            if (!yearValid) etYear.error = "Invalid year"

            nameValid && yearValid
        }.subscribe { formValid ->
            btAdd.isEnabled = formValid
        }

    }
}
