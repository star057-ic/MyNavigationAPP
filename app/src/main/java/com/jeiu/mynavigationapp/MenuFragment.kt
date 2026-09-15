package com.jeiu.mynavigationapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.jeiu.mynavigationapp.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {

    private var _binding: FragmentMenuBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 각 과목 버튼 클릭 시 DetailFragment로 값 전달
        binding.btnAndroid.setOnClickListener {
            moveToDetail("Android")
        }

        binding.btnKotlin.setOnClickListener {
            moveToDetail("Kotlin")
        }

        // 이전 화면(HomeFragment)으로 복귀
        binding.btnBackHome.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun moveToDetail(subjectText: String) {
        val bundle = Bundle().apply {
            putString("subject", subjectText)
        }

        findNavController().navigate(
            R.id.action_menuFragment_to_detailFragment,
            bundle
        )
    }

    // ViewBinding 메모리 해제
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}