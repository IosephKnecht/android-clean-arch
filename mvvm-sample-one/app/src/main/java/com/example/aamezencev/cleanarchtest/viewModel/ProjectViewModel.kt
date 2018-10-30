package com.example.aamezencev.cleanarchtest.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.aamezencev.cleanarchtest.service.data.Project
import com.example.aamezencev.cleanarchtest.service.repository.ProjectRepository

class ProjectViewModel(application: Application,
                       private val projectId: String?) : AndroidViewModel(application) {

    val projectObservable: LiveData<Project> = ProjectRepository.instance().projectDetails("Google", projectId!!)

    class Factory(private val application: Application,
                  private val projectId: String?) : ViewModelProvider.NewInstanceFactory() {


        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return ProjectViewModel(application, projectId) as T
        }
    }
}