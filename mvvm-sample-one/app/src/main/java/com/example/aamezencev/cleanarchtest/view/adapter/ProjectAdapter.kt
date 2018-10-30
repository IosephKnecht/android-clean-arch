package com.example.aamezencev.cleanarchtest.view.adapter

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aamezencev.cleanarchtest.R
import com.example.aamezencev.cleanarchtest.service.data.Project

class ProjectAdapter : RecyclerView.Adapter<ProjectAdapter.ViewHolder>() {

    var projectList = listOf<Project>()
    var projectListener: ((Project) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.project_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = projectList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val project = projectList[position]

        holder.apply {
            name.text = project.name
            languages.text = String.format(itemView.context.getString(R.string.languages), project.language)
            projectWatchers.text = String.format(itemView.context.getString(R.string.watchers), project.watchers)
        }.itemView.setOnClickListener { projectListener?.invoke(project) }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.name)!!
        val languages = itemView.findViewById<TextView>(R.id.languages)!!
        val projectWatchers = itemView.findViewById<TextView>(R.id.project_watchers)!!
    }
}