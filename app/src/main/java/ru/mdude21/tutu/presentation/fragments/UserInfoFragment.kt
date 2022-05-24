package ru.mdude21.tutu.presentation.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import dagger.hilt.android.AndroidEntryPoint
import ru.mdude21.tutu.R
import ru.mdude21.tutu.databinding.FragmentUserInfoBinding
import ru.mdude21.tutu.presentation.viewmodels.UserInfoViewModel

@AndroidEntryPoint
class UserInfoFragment : Fragment(R.layout.fragment_user_info) {
    private val viewModel: UserInfoViewModel by viewModels()
    private val binding by viewBinding(FragmentUserInfoBinding::bind)
    private var result: String? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFragmentResultListener("requestKey") { requestKey, bundle ->
            result = bundle.getString("bundleKey")
            result?.let {

                viewModel.getUserByLogin(result!!)
            }

            viewModel.user.observe(viewLifecycleOwner) {
                with(binding) {
                    loginTextView.text = it.login
                    nameTextView.text = it.name
                    emailTextView.text = it.email
                    countRepositoriesTextView.text = it.public_repos.toString()
                    countFollowersTextView.text = it.followers.toString()
                    countFollowingTextView.text = it.following.toString()
                    Glide.with(view)
                        .load(it.avatar_url)
                        .transform(CircleCrop())
                        .into(avatarInfoFragmentImageView)
                }
            }

        }


    }
}