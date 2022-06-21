package com.dicoding.githubuser.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.dicoding.githubuser.data.model.User
import com.dicoding.githubuser.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var detailBinding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)
        supportActionBar?.title = "Detail User"

        val detailUser = intent.getParcelableExtra<User>(INTENT_PARCELABLE)

        with(detailBinding){
            tvUsername.text = StringBuilder("Username: ").append(detailUser?.username)
            tvItemName.text = StringBuilder("Name: ").append(detailUser?.name)
            Glide.with(this@DetailActivity).apply {
                load(detailUser?.photo)
                .circleCrop()
                .into(ivItemPhoto)
            }
            tvItemFollower.text = StringBuilder("Follower: ").append(detailUser?.follower)
            tvItemFollowing.text = StringBuilder("Following: ").append(detailUser?.following)
            tvItemCompany.text = StringBuilder("Company: ").append(detailUser?.company)
            tvItemLocation.text = StringBuilder("Location: ").append(detailUser?.location)
            tvItemRepository.text = StringBuilder("Repository: ").append(detailUser?.repository)
        }
    }

    companion object {
        const val INTENT_PARCELABLE = "OBJECT_INTENT"
    }
}