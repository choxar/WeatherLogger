//package com.example.weatherlogger.overview
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import androidx.fragment.app.viewModels
////import com.example.weatherlogger.databinding.FragmentOverviewBinding
//
//class OverviewFragment : Fragment() {
//    private val viewModel: OverviewViewModel by viewModels()
//
//    //var _binding: FragmentOverviewBinding? = null
//    private val binding get() = _binding!!
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//
//
//        _binding = FragmentOverviewBinding.inflate(inflater)
//
//        binding.lifecycleOwner = this
//        binding.viewModel = viewModel
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        binding.some.visibility = View.INVISIBLE
//        binding.details.visibility = View.INVISIBLE
//        binding.search.setOnClickListener {
//
//
//            val city = binding.name.text
//            viewModel.getData(city.toString())
//
//            binding.some.visibility = View.VISIBLE
//            binding.details.visibility = View.INVISIBLE
//            binding.more.visibility = View.VISIBLE
//        }
//        binding.more.setOnClickListener {
//            binding.more.visibility = View.GONE
//            binding.details.visibility = View.VISIBLE
//        }
//    }
//}