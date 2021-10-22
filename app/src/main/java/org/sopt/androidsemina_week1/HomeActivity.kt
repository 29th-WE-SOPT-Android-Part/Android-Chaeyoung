package org.sopt.androidsemina_week1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import org.sopt.androidsemina_week1.databinding.ActivitySecondBinding
import org.sopt.androidsemina_week1.databinding.FragmentFollowerBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root

        binding.followerBtn.setOnClickListener {
            setFollowerFragment()
        }

        binding.repositBtn.setOnClickListener {
            setRepoFragment()
        }
        setContentView(view)
    }

    private fun setRepoFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.recycler_repository, RepositoryFragment())
        transaction.commit()
    }

    private fun setFollowerFragment(){

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.recycler_follow, followerFragment())
        transaction.commit()
    }

    /*
    private fun initFollowerAdapter() {
        followerAdaper = FollowerAdapter()
        binding.frameLayout.adapter = followerAdaper

        followerAdaper.userList.addAll(
            listOf(
                UserData("심채영", "29기"),
                UserData("심채영1", "29기"),
                UserData("심채영2", "29기"),
                UserData("심채영3", "29기"),
                UserData("심채영4", "29기"),
                UserData("심채영5", "29기"),
                UserData("심채영6", "29기"),
                UserData("심채영7", "29기"),
            )
        )

        followerAdaper.notifyDataSetChanged()
    }

    private fun initRepositoryAdapter() {
        repositoryAdapter = RepositoryAdapter()
        binding.frameLayout.adapter = repositoryAdapter

        repositoryAdapter.userList.addAll(
            listOf(
                UserData("레포지토리1", "레포지토리설명입니다~~"),
                UserData("채영1", "29기"),
                UserData("채영2", "29기"),
                UserData("채영3", "29기"),
                UserData("채영4", "29기"),
                UserData("채영5", "29기"),
                UserData("채영6", "29기"),
                UserData("채영7", "29기"),
            )
        )

        repositoryAdapter.notifyDataSetChanged()
    }
    */
}

/*
    private fun initTransactionEvent() {
        val fragment1 = followerFragment()
        val fragment2 = RepositoryFragment()

        supportFragmentManager.beginTransaction().add(R.id.frameLayout, fragment1).commit()
        binding.followerBtn.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()

            transaction.replace(R.id.frameLayout, fragment1)

        }
        binding.repositBtn.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            //
            transaction.replace(R.id.frameLayout, fragment2)

        }
    }
*/