package com.example.aamezencev.cleanarchtest.view.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.aamezencev.cleanarchtest.R
import com.example.aamezencev.cleanarchtest.viewModel.ProjectViewModel
import kotlinx.android.synthetic.main.fragment_project_details.*

class ProjectFragment : Fragment() {
    companion object {
        const val TAG = "project_fragment"
        private const val KEY_PROJECT_ID = "key_project_id"

        fun newInstance(projectId: String?) = ProjectFragment().apply {
            arguments = Bundle().apply {
                putString(KEY_PROJECT_ID, projectId)
            }
        }
    }

    private lateinit var viewModel: ProjectViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_project_details, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val factory = ProjectViewModel.Factory(activity!!.application, arguments!!.getString(KEY_PROJECT_ID))
        viewModel = ViewModelProviders.of(this@ProjectFragment, factory).get(ProjectViewModel::class.java)
    }

    override fun onStart() {
        super.onStart()

        viewModel.projectObservable.observe({ lifecycle }) {
            context?.apply {
                clone_url.text = String.format(getString(R.string.clone_url), it.cloneUrl)
                project_updated_at.text = String.format(getString(R.string.updated_at), it.updatedAt)
                project_created_at.text = String.format(getString(R.string.created_at), it.createdAt)
                project_open_issues.text = String.format(getString(R.string.open_issues), it.openIssue)
                project_watchers.text = String.format(getString(R.string.watchers), it.watchers)
                languages.text = String.format(getString(R.string.languages), it.language)
                project_desc.text = it.description
                name.text = it.name

                detail_container.visibility = View.VISIBLE
                loading_project.visibility = View.GONE
            }
        }
    }
}