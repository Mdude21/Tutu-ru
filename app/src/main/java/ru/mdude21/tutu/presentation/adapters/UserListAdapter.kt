package ru.mdude21.tutu.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import ru.mdude21.tutu.databinding.ItemUserBinding
import ru.mdude21.tutu.domain.models.UsersItem

class UserListAdapter : RecyclerView.Adapter<UserListAdapter.ViewHolder>() {

    private var users: List<UsersItem> = emptyList()

    inner class ViewHolder(private val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: UsersItem) {
            with(binding) {
                usernameTextView.text = user.login
                Glide.with(itemView)
                    .load(user.avatar_url)
                    .transform(CircleCrop())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(avatarImageView)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemUserBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(users[position])
        holder.itemView.setOnClickListener {
            onItemClickListener?.let { it(users[position]) }
        }
    }

    override fun getItemCount(): Int = users.size

    fun setUserList(users: List<UsersItem>) {
        this.users = users
    }

    private var onItemClickListener: ((UsersItem) -> Unit)? = null

    fun setOnClickListener(listener: (UsersItem) -> Unit) {
        onItemClickListener = listener
    }
}