package org.sopt.androidsemina_week1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import org.sopt.androidsemina_week1.databinding.ActivitySecondBinding
import org.sopt.androidsemina_week1.databinding.FragmentFollowerBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var binding : ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root

        initAdapter()
        initBottomNav()
        setContentView(view)
    }

    private fun initAdapter(){
        val fragmentList = listOf(ProfileFragment(),HomeFragment(),CameraFragment())

        viewPagerAdapter = ViewPagerAdapter(this)
        viewPagerAdapter.fragments.addAll(fragmentList)

        binding.vp2.adapter = viewPagerAdapter
    }

    private fun initBottomNav() {
        binding.vp2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position : Int) {
                binding.bottomNavigationView.menu.getItem(position).isChecked = true
            }
        })

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.menu_profile -> {
                    binding.vp2.currentItem = 0
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.menu_home -> {
                    binding.vp2.currentItem = 1
                    return@setOnNavigationItemSelectedListener true
                }
                else-> {
                    binding.vp2.currentItem = 2
                    return@setOnNavigationItemSelectedListener true
                }
            }
        }
    }

}