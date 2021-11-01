package org.sopt.androidsemina_week1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.sopt.androidsemina_week1.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater)

        binding.followerBtn.setOnClickListener {
            setFollowerFragment()
        }

        binding.repositBtn.setOnClickListener {
            setRepoFragment()
        }
        return binding.root
    }

    private fun setRepoFragment() {
        val transaction = childFragmentManager.beginTransaction()
        transaction.replace(R.id.container_main, RepositoryFragment())
        transaction.commit()
    }

    private fun setFollowerFragment(){
        val transaction = childFragmentManager.beginTransaction()
        transaction.replace(R.id.container_main, followerFragment())
        transaction.commit()
    }
}