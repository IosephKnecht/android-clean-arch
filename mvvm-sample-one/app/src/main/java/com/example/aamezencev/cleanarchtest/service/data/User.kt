package com.example.aamezencev.cleanarchtest.service.data

import java.util.*

data class User(var login: String? = null,
                var id: Long = 0,
                var avatarUrl: String? = null,
                var gravatarId: String? = null,
                var url: String? = null,
                var htmlUrl: String? = null,
                var followersUrl: String? = null,
                var followingUrl: String? = null,
                var gistsUrl: String? = null,
                var starredUrl: String? = null,
                var subscriptionsUrl: String? = null,
                var organizationsUrl: String? = null,
                var reposUrl: String? = null,
                var eventsUrl: String? = null,
                var receivedEventsUrl: String? = null,
                var type: String? = null,
                var name: String? = null,
                var blog: String? = null,
                var location: String? = null,
                var email: String? = null,
                var publicRepos: Int = 0,
                var publicGists: Int = 0,
                var followers: Int = 0,
                var following: Int = 0,
                var createdAt: Date? = null,
                var updatedAt: Date? = null) {
}