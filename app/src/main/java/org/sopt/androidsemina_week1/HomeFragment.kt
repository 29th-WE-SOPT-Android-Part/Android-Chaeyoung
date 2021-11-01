package org.sopt.androidsemina_week1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import org.sopt.androidsemina_week1.databinding.FragmentHomeBinding
import org.sopt.androidsemina_week1.databinding.FragmentProfileBinding

class HomeFragment : Fragment() {
    private lateinit var tabViewPagerAdapter : TabViewPagerAdapter
    private lateinit var binding : FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        initAdapter()
        initTabLayout()

        return binding.root
    }

    private fun initAdapter() {
        val fragmentList = listOf(FollowerListFragment(), FollowingListFragment())
        tabViewPagerAdapter = TabViewPagerAdapter(this)
        tabViewPagerAdapter.fragmentList.addAll(fragmentList)
        binding.vp2.adapter = tabViewPagerAdapter
    }

    private fun initTabLayout() {
        val tabLabel = listOf("팔로워", "팔로잉")

        TabLayoutMediator(binding.prifileTl, binding.vp2) {
            tab, position -> tab.text = tabLabel[position]
        }.attach()
    }
}