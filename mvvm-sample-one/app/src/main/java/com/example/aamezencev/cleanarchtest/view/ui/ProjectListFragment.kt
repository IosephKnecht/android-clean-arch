package com.example.aamezencev.cleanarchtest.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aamezencev.cleanarchtest.R
import com.example.aamezencev.cleanarchtest.service.data.Project
import com.example.aamezencev.cleanarchtest.view.adapter.ProjectAdapter
import com.example.aamezencev.cleanarchtest.viewModel.ProjectListViewModel
import kotlinx.android.synthetic.main.fragment_project_list.*


class ProjectListFragment : Fragment(), LifecycleOwner {

    companion object {
        const val TAG = "project_list_fragment"

        fun newInstance() = ProjectListFragment()
    }

    private lateinit var adapter: ProjectAdapter
    private lateinit var viewModel: ProjectListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        adapter = ProjectAdapter()

        adapter.projectListener = {
            if (lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
                show(it)
            }
        }

        return inflater.inflate(R.layout.fragment_project_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(ProjectListViewModel::class.java)
    }

    override fun onStart() {
        super.onStart()

        project_list?.apply {
            adapter = this@ProjectListFragment.adapter
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(false)
        }

        viewModel.projectListObservable.observe({ lifecycle }) {
            adapter.projectList = it
            adapter.notifyDataSetChanged()

            loading_projects.visibility = View.GONE
            projects_container.visibility = View.VISIBLE
        }
    }

    private fun show(project: Project) {
        fragmentManager!!.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fragment_container,
                ProjectFragment.newInstance(project.name),
                ProjectFragment.TAG)
            .commit()
    }
}