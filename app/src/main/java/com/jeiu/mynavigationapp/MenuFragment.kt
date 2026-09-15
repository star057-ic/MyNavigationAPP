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
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 각 메뉴 선택 시 주문 정보(음식 이름) 전달
        binding.btnAmericano.setOnClickListener { moveToDetail("아메리카노 (1,500원)") }
        binding.btnLatte.setOnClickListener { moveToDetail("카페라떼 (2,500원)") }
        binding.btnHotChoco.setOnClickListener { moveToDetail("핫초코 (3,000원)") }

        binding.btnBackHome.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun moveToDetail(menuName: String) {
        val bundle = Bundle().apply {
            putString("subject", menuName) // Key 값 "subject" 유지
        }
        findNavController().navigate(
            R.id.action_menuFragment_to_detailFragment,
            bundle
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}