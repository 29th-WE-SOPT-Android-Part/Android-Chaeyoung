package org.sopt.androidsemina_week1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.sopt.androidsemina_week1.databinding.ActivityHomeBinding
import org.sopt.androidsemina_week1.databinding.ActivitySecondBinding
import org.sopt.androidsemina_week1.databinding.FragmentFollowerBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class followerFragment : Fragment() {
    private lateinit var followerAdapter : FollowerAdapter

    private var _binding : FragmentFollowerBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initFollowerAdapter()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
    _binding = FragmentFollowerBinding.inflate(layoutInflater, container, false)
    return binding.root
    }

    override fun onDestroyView() {
        //binding 객체 참조 해제
        super.onDestroyView()
        _binding = null
    }

    private fun initFollowerAdapter() {
        followerAdapter = FollowerAdapter()
        binding.recyclerFollow.adapter = followerAdapter
        followerAdapter.userList.addAll(
            listOf(
                UserData("심채영", "29기"),
                UserData("김철수", "1기"),
                UserData("신짱구", "2기"),
                UserData("신짱아", "23기"),
                UserData("유리", "24기")
            )
        )

        followerAdapter.notifyDataSetChanged()
    }
}
