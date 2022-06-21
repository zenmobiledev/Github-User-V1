package com.dicoding.githubuser.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var name: String,
    var follower: String,
    var following: String,
    var photo: Int,
    var username: String,
    var company: String,
    var location: String,
    var repository: String
): Parcelable