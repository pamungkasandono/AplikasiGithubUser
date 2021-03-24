package com.example.submission_aplikasigithubuser

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    var username: String,
    var name: String,
    var avatar: Int,
    var company: String,
    var location: String,
    var repo: String,
    var follower: String,
    var following: String
) : Parcelable