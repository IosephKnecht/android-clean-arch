package com.example.aamezencev.cleanarchtest.service.repository

import com.example.aamezencev.cleanarchtest.service.data.Project
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface GitHubService {
    companion object {
        const val HTTPS_API_GITHUB_URL = "https://api.github.com/"
    }

    @GET("users/{user}/repos")
    fun projectList(@Path("user") user: String): Call<List<Project>>

    @GET("/repos/{user}/{reponame}")
    fun projectDetails(@Path("user") user: String, @Path("reponame") projectName: String): Call<Project>
}