package ru.mdude21.tutu.presentation.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import ru.mdude21.tutu.R
import ru.mdude21.tutu.databinding.FragmentRepoInfoBinding
import ru.mdude21.tutu.presentation.adapters.ReposListAdapter
import ru.mdude21.tutu.presentation.viewmodels.RepoListViewModel

@AndroidEntryPoint
class RepoListFragment : Fragment(R.layout.fragment_repo_info) {

    private val viewModel: RepoListViewModel by viewModels()
    private val binding by viewBinding(FragmentRepoInfoBinding::bind)
    private var repoAdapter = ReposListAdapter()
    private val args: RepoListFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val result = args.user
        viewModel.getReposListByLogin(result.login)

        viewModel.reposList.observe(viewLifecycleOwner) {
            binding.reposList.apply {
                adapter = repoAdapter
                layoutManager = LinearLayoutManager(requireContext())
                val dividerItemDecoration = DividerItemDecoration(
                    context,
                    (layoutManager as LinearLayoutManager).orientation
                )
                addItemDecoration(dividerItemDecoration)
            }
            repoAdapter.setReposList(it)

            repoAdapter.setOnClickListener { reposItem ->
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(reposItem.html_url))
                startActivity(browserIntent)
            }
        }

    }
}