package ru.mdude21.tutu.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.mdude21.tutu.databinding.ItemRepoBinding
import ru.mdude21.tutu.domain.models.ReposItem

class ReposListAdapter : RecyclerView.Adapter<ReposListAdapter.ViewHolder>() {

    private var repos: List<ReposItem> = emptyList()

    inner class ViewHolder(private val binding: ItemRepoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(repo: ReposItem) {
            with(binding) {
                repoNameTextView.text = repo.name
                repoLanguageTextView.text = repo.language
                repoUpdateTextView.text = repo.updated_at
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemRepoBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(repos[position])
    }

    override fun getItemCount(): Int = repos.size

    fun setReposList(repos: List<ReposItem>) {
        this.repos = repos
    }

}