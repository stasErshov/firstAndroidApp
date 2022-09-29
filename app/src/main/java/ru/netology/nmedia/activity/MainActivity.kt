package ru.netology.nmedia.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import ru.netology.nmedia.R
import ru.netology.nmedia.checkingNumberPeople
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.dto.Post

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val post = Post(
            id = 1,
            author = "Нетология. Университет интернет-профессий будущего",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
            published = "21 мая в 18:36",
            shareCountSum = 999,
            likes = 999,
            likedByMe = false
        )

        with(binding) {
            author.text = post.author
            published.text = post.published
            content.text = post.content
            shareCount.text = checkingNumberPeople(post.shareCountSum)
            likeCount.text = checkingNumberPeople(post.likes)
            if (post.likedByMe) {
                like.setImageResource(R.drawable.ic_licked_24)
            }
            likeCount.text = post.likes.toString()

            binding.root.setOnClickListener {
                Log.d("stuff", "stuff")
            }

            avatar.setOnClickListener {
                Log.d("stuff", "avatar")
            }

            like.setOnClickListener {
                post.likedByMe = !post.likedByMe
                like.setImageResource(
                    if (post.likedByMe) R.drawable.ic_licked_24 else R.drawable.ic_like_24
                )
                if (post.likedByMe)
                    post.likes++
                else
                    post.likes--
                likeCount.text = checkingNumberPeople(post.likes)
            }

            share.setOnClickListener {
                post.shareCountSum++
                shareCount.text = checkingNumberPeople(post.shareCountSum)
            }
        }
    }
}