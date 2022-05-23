package ru.mdude21.tutu.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import ru.mdude21.tutu.R
import ru.mdude21.tutu.databinding.FragmentUserSearchBinding
import ru.mdude21.tutu.presentation.adapters.UserListAdapter
import ru.mdude21.tutu.presentation.viewmodels.UserSearchViewModel

@AndroidEntryPoint
class UserSearchFragment : Fragment(R.layout.fragment_user_search) {
    private val viewModel: UserSearchViewModel by viewModels()

    private val binding by viewBinding(FragmentUserSearchBinding::bind)
    private var userAdapter = UserListAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.userList.apply {
            adapter = userAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        viewModel.usersList.observe(viewLifecycleOwner) {
            userAdapter.setUserList(it)
        }
        viewModel.isLoad.observe(viewLifecycleOwner) {
            binding.progressBar.visibility = if (it) View.VISIBLE else View.GONE
        }

        binding.searchButton.setOnClickListener {
            viewModel.getUsersListByLogin(login = binding.searchInputEditText.text.toString())
        }
    }
}