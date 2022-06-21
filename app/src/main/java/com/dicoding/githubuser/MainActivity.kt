package com.dicoding.githubuser

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.githubuser.data.adapter.ListGithubUserAdapter
import com.dicoding.githubuser.data.model.User

class MainActivity : AppCompatActivity() {
    private lateinit var rvUser: RecyclerView
    private val list = ArrayList<User>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "List User"

        rvUser = findViewById(R.id.rv_user)
        rvUser.setHasFixedSize(true)

        list.addAll(listUsers)
        showRecycleList()
    }

    private val listUsers: ArrayList<User>
    get() {
        val dataUsername = resources.getStringArray(R.array.username)
        val dataName = resources.getStringArray(R.array.name)
        val dataFollower = resources.getStringArray(R.array.followers)
        val dataFollowing = resources.getStringArray(R.array.following)
        val dataPhoto = resources.obtainTypedArray(R.array.avatar)
        val dataCompany = resources.getStringArray(R.array.company)
        val dataLocation = resources.getStringArray(R.array.location)
        val dataRepository = resources.getStringArray(R.array.repository)
        val listUser = ArrayList<User>()
        for (i in dataName.indices) {
            val user = User(dataName[i], dataFollower[i], dataFollowing[i], dataPhoto.getResourceId(i, -1), dataUsername[i], dataCompany[i], dataLocation[i], dataRepository[i])
            listUser.add(user)
        }
        return listUser
    }

    private fun showRecycleList() {
        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvUser.layoutManager = GridLayoutManager(this, 2)
        } else {
            rvUser.layoutManager = LinearLayoutManager(this)
        }
        val listUserAdapter = ListGithubUserAdapter(list)
        rvUser.adapter = listUserAdapter
    }


}