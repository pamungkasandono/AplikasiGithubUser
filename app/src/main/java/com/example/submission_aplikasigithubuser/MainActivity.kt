package com.example.submission_aplikasigithubuser

import android.content.Intent
import android.content.res.TypedArray
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.submission_aplikasigithubuser.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: AdapterUsers
    private lateinit var binding: ActivityMainBinding
    private lateinit var dataName: Array<String>
    private lateinit var dataUsername: Array<String>
    private lateinit var dataPhoto: TypedArray
    private lateinit var dataCompanyName: Array<String>
    private lateinit var dataLocation: Array<String>
    private lateinit var dataRepo: Array<String>
    private lateinit var dataFollower: Array<String>
    private lateinit var dataFollowing: Array<String>

    private var users = arrayListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listView: ListView = binding.lvItem
        adapter = AdapterUsers(this)
        listView.adapter = adapter

        prepare()
        addItem()

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            Intent(this@MainActivity, DetailUser::class.java).apply {
                putExtra(DetailUser.EXTRA_DATA, users[position])
                startActivity(this)
            }

        }
    }

    private fun addItem() {
        for (i in dataName.indices) {
            val arrayUser = User(
                dataUsername[i],
                dataName[i],
                dataPhoto.getResourceId(i, -1),
                dataCompanyName[i],
                dataLocation[i],
                dataRepo[i],
                dataFollower[i],
                dataFollowing[i]
            )
            users.add(arrayUser)
        }
        adapter.users = users
    }

    private fun prepare() {
        dataName = resources.getStringArray(R.array.name)
        dataUsername = resources.getStringArray(R.array.username)
        dataPhoto = resources.obtainTypedArray(R.array.avatar)
        dataCompanyName = resources.getStringArray(R.array.company)
        dataLocation = resources.getStringArray(R.array.location)
        dataRepo = resources.getStringArray(R.array.repository)
        dataFollower = resources.getStringArray(R.array.followers)
        dataFollowing = resources.getStringArray(R.array.following)
    }
}