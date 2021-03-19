package com.example.firebasetest.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.firebasetest.R
import com.example.firebasetest.databinding.ItemDetailFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ItemDetailFragment : Fragment() {

    companion object {
        fun newInstance() = ItemDetailFragment()
    }

    private lateinit var viewModel: ItemDetailViewModel
    private lateinit var binding: ItemDetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ItemDetailFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ItemDetailViewModel::class.java)

        binding.createNewItemBtn.setOnClickListener {
            viewModel.onClickAdd(
                item_name = binding.itemNameText.text.toString(),
                item_url = binding.itemUrlText.text.toString()
            )
        }

        viewModel.navigateToHome.observe(viewLifecycleOwner, {
            if (it == true) {
                this.findNavController().navigate(R.id.action_itemDetailFragment_to_homeFragment)
                viewModel.onCompleteNavigation()
            }
        })

    }

}