package com.example.aamezencev.cleanarchtest.view.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.aamezencev.cleanarchtest.R
import com.example.aamezencev.cleanarchtest.service.data.Project


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        with(supportFragmentManager) {
            findFragmentByTag(ProjectListFragment.TAG)
                .takeIf { it == null }
                .let {
                    beginTransaction()
                        .add(R.id.fragment_container, ProjectListFragment.newInstance(), ProjectFragment.TAG)
                        .commit()
                }
        }
    }
}