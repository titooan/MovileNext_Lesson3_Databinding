package com.titouan.next.movilenext_lesson3_databinding.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.titouan.next.movilenext_lesson3_databinding.R
import com.titouan.next.movilenext_lesson3_databinding.databinding.ActivityGameInfoBinding
import com.titouan.next.movilenext_lesson3_databinding.model.Game
import com.titouan.next.movilenext_lesson3_databinding.utils.contentView
import kotlinx.android.synthetic.main.activity_game_info.*


class GameInfoActivity : AppCompatActivity() {

//    private val binding: ActivityGameInfoBinding by lazy {
//        DataBindingUtil.setContentView<ActivityGameInfoBinding>(this, R.layout.activity_game_info)
//    }

    private val binding: ActivityGameInfoBinding by contentView(R.layout.activity_game_info)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.game = Game("First Game", 123, "https://upload.wikimedia.org/wikipedia/commons/b/b5/Kotlin-logo.png?uselang=fr", 4.0)

        tvName.setOnClickListener {
            binding.game = Game("Second Game", 456, "http://pogo-news-prod.s3.amazonaws.com/wp-content/uploads/2012/06/java-logo.jpg", 3.5)
        }

        tvRating.setOnClickListener {
            binding.game?.rating = 2.3
        }

    }
}
