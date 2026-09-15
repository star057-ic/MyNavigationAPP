package com.jeiu.mynavigationapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.jeiu.mynavigationapp.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // HomeFragment에서 넘어온 "subject" 전달값 수신
        val subject = arguments?.getString("subject") ?: "선택없음"
        binding.txtResult.text = "선택한 항목: $subject"

        // 이전 화면으로 복귀
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    // ViewBinding 메모리 해제
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}