package com.dicoding.githubuser.data.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.githubuser.data.model.User
import com.dicoding.githubuser.databinding.ItemRowUserBinding
import com.dicoding.githubuser.ui.DetailActivity

class ListGithubUserAdapter(private var listUser: ArrayList<User>): RecyclerView.Adapter<ListGithubUserAdapter.ListViewHolder>() {
    class ListViewHolder(binding: ItemRowUserBinding) : RecyclerView.ViewHolder(binding.root) {

        private val name = binding.tvItemName
        private val followers = binding.tvItemFollower
        private val following = binding.tvItemFollowing
        private val photo = binding.ivItemPhoto

        fun bind(item: User) {
            name.text = StringBuilder("Name: ").append(item.name)
            followers.text = StringBuilder("Follower: ").append(item.follower)
            following.text = StringBuilder("Following: ").append(item.following)
            Glide.with(itemView.context).apply {
                load(item.photo)
                .circleCrop()
                .into(photo)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val item = listUser[position]
        with(holder) {
            bind(item)
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailActivity::class.java)
                intent.putExtra(DetailActivity.INTENT_PARCELABLE, item)
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int = listUser.size
}
