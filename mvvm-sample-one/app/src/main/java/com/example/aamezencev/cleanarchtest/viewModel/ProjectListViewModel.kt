package com.example.aamezencev.cleanarchtest.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.aamezencev.cleanarchtest.service.data.Project
import com.example.aamezencev.cleanarchtest.service.repository.ProjectRepository

class ProjectListViewModel(application: Application) : AndroidViewModel(application) {

    val projectListObservable: LiveData<List<Project>> =
        ProjectRepository.instance().projectList("Google")
}