package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.udacity.shoestore.databinding.FragmentAddShoeBinding
import com.udacity.shoestore.models.ShoeListViewModel

/** Allow to add a new shoe. */
class AddShoeFragment : Fragment() {

    private lateinit var binding: FragmentAddShoeBinding

    private val viewModel: ShoeListViewModel by activityViewModels() {
        ShoeListViewModel.Factory()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_add_shoe,
            container,
            false
        )
        return binding.root
    }
}