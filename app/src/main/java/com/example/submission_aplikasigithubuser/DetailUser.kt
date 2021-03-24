package com.example.submission_aplikasigithubuser

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.submission_aplikasigithubuser.databinding.ActivityDetailUserBinding

class DetailUser : AppCompatActivity() {
    private lateinit var binding: ActivityDetailUserBinding

    companion object {
        const val EXTRA_DATA = "extra"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = intent.getParcelableExtra<User>(EXTRA_DATA) as User
        binding.tvFullname.text = user.name
        binding.tvUsername.text = user.username
        binding.tvCompanyName.text = user.company
        binding.tvLocation.text = user.location
        binding.tvRepository.text = user.repo
        binding.tvFollowers.text = user.follower
        binding.tvFollowing.text = user.following
        Glide
            .with(this)
            .load(user.avatar)
            .into(binding.civUserImage)
    }
}