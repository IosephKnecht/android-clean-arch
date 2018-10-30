package com.example.aamezencev.cleanarchtest.service.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.aamezencev.cleanarchtest.service.data.Project
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProjectRepository {
    companion object {
        private var projectRepository: ProjectRepository? = null

        @Synchronized
        fun instance(): ProjectRepository {
            if (projectRepository == null) {
                if (projectRepository == null) {
                    projectRepository = ProjectRepository()
                }
            }
            return projectRepository as ProjectRepository;
        }
    }

    private val gitHubService: GitHubService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(GitHubService.HTTPS_API_GITHUB_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        gitHubService = retrofit.create(GitHubService::class.java)
    }

    fun projectList(userId: String): LiveData<List<Project>> {
        val data = MutableLiveData<List<Project>>()

        gitHubService.projectList(userId).enqueue(object : Callback<List<Project>> {
            override fun onFailure(call: Call<List<Project>>, t: Throwable) {
                data.value = listOf()
            }

            override fun onResponse(call: Call<List<Project>>, response: Response<List<Project>>) {
                data.value = response.body()
            }
        })

        return data
    }

    fun projectDetails(userid: String, projectName: String): LiveData<Project> {
        val data = MutableLiveData<Project>()

        gitHubService.projectDetails(userid, projectName).enqueue(object : Callback<Project> {
            override fun onFailure(call: Call<Project>, t: Throwable) {
                data.value = null
            }

            override fun onResponse(call: Call<Project>, response: Response<Project>) {
                simulateDelay()
                data.value = response.body()
            }
        })

        return data
    }

    private fun simulateDelay() {
        try {
            Thread.sleep(10)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}