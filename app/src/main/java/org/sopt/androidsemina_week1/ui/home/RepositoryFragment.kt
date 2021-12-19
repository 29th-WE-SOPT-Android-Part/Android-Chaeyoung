package org.sopt.androidsemina_week1.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.sopt.androidsemina_week1.data.RepoData
import org.sopt.androidsemina_week1.databinding.FragmentRepositoryBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class RepositoryFragment : Fragment() {
    private lateinit var repositoryAdapter: RepositoryAdapter
    private var _binding : FragmentRepositoryBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRepositoryAdapter()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRepositoryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initRepositoryAdapter() {
        repositoryAdapter = RepositoryAdapter()
        binding.recyclerRepository.adapter = repositoryAdapter
        repositoryAdapter.repoList.addAll(
            listOf(
                RepoData("레포지토리1", "레포지토리설명입니다~~"),
                RepoData("레포지토리2", "레포지토리설명입니다~~"),
                RepoData("레포지토리3", "레포지토리설명입니다~~"),
                RepoData("레포지토리4", "레포지토리설명입니다~~")
            )
        )
        repositoryAdapter.notifyDataSetChanged()
    }
}