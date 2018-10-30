package com.example.aamezencev.cleanarchtest.service.data

import java.util.*

data class Project(var id: Long? = null,
                   var name: String,
                   var fullName: String? = null,
                   var owner: User? = null,
                   var htmUrl: String? = null,
                   var description: String? = null,
                   var createdAt: Date? = null,
                   var updatedAt: Date? = null,
                   var pushedAt: Date? = null,
                   var gitUrl: String? = null,
                   var sshUrl: String? = null,
                   var cloneUrl: String? = null,
                   var svnUrl: String? = null,
                   var homePage: String? = null,
                   var stargazersCount: Int? = null,
                   var watchersCount: Int? = null,
                   var language: String? = null,
                   var hasIssue: Boolean? = null,
                   var hasDownloads: Boolean? = null,
                   var hasWiki: Boolean? = null,
                   var hasPages: Boolean? = null,
                   var forksCount: Int? = null,
                   var openIssueCount: Int? = null,
                   var forks: Int? = null,
                   var openIssue: Int? = null,
                   var watchers: Int? = null,
                   var defaultBranch: String? = null) {
}