package com.bangkit.batikapp.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangkit.batikapp.R
import com.bangkit.batikapp.core.data.Resource
import com.bangkit.batikapp.core.ui.BatikAdapter
import com.bangkit.batikapp.databinding.FragmentHomeBinding
import com.bangkit.batikapp.detail.DetailBatikActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): ConstraintLayout? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val batikAdapter = BatikAdapter()
            batikAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailBatikActivity::class.java)
                intent.putExtra(DetailBatikActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

            homeViewModel.batik.observe(viewLifecycleOwner, { batik ->
                if (batik != null) {
                    when (batik) {
                        is Resource.Loading -> binding?.progressBar?.visibility = View.VISIBLE
                        is Resource.Success -> {
                            binding?.progressBar?.visibility = View.GONE
                            batikAdapter.setData(batik.data)
                        }
                        is Resource.Error -> {
                            binding?.progressBar?.visibility = View.GONE
                            binding?.viewError?.root?.visibility = View.VISIBLE
                            binding?.viewError?.tvError?.text = batik.message ?: getString(R.string.something_wrong)
                        }
                    }
                }
            })

            with(binding?.rvBatik) {
                this?.layoutManager = LinearLayoutManager(context)
                this?.setHasFixedSize(true)
                this?.adapter = batikAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}