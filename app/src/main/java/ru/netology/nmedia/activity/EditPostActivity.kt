package ru.netology.nmedia.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.netology.nmedia.databinding.ActivityEditPostBinding
import ru.netology.nmedia.dto.Post

class EditPostActivity() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityEditPostBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = Intent()
        val input = Post(getIntent().getLongExtra("id",0),
            getIntent().getStringExtra("author").toString(),
            getIntent().getStringExtra("content").toString(),
            getIntent().getStringExtra("published").toString(),
            getIntent().getBooleanExtra("likedByMe", false),
            getIntent().getIntExtra("likes", 0)
        )
        binding.edit.setText(input.content)
        binding.ok.setOnClickListener {
            if (binding.edit.text.isNullOrBlank()) {
                setResult(Activity.RESULT_CANCELED, intent)
            } else {
                val content = binding.edit.text.toString()
                /*intent.putExtra(Intent.EXTRA_TEXT, content)
                intent.putExtra("popa", input.id)*/
                intent.putExtra("id", input.id)
                intent.putExtra("author", input.author)
                intent.putExtra("content", content)
                intent.putExtra("published", input.published)
                intent.putExtra("likedByMe", input.likedByMe)
                intent.putExtra("likes", input.likes)
                setResult(Activity.RESULT_OK, intent)
            }
            finish()
        }
    }
}

///val id: Long,
///val author: String,
///val content: String,
///val published: String,
///val likedByMe: Boolean,
///val likes: Int = 0,