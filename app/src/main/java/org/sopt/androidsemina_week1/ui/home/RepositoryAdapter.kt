package org.sopt.androidsemina_week1.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.androidsemina_week1.data.RepoData
import org.sopt.androidsemina_week1.databinding.RepositoryListBinding

class RepositoryAdapter : RecyclerView.Adapter<RepositoryAdapter.RepositoryViewHolder>() {
    val repoList = mutableListOf<RepoData>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RepositoryViewHolder {
        val binding = RepositoryListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return RepositoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int){
        holder.onBind(repoList[position])
    }

    override fun getItemCount(): Int = repoList.size

    class RepositoryViewHolder(private val binding: RepositoryListBinding)
        : RecyclerView.ViewHolder(binding.root){
        fun onBind(data : RepoData){
            binding.tvRepoName.text = data.name
            binding.tvRepoIntro.text = data.introduce
        }
    }
}