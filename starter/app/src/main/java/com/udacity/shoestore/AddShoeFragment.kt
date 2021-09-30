package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentAddShoeBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeListViewModel

/** Allow to add a new shoe. */
class AddShoeFragment : Fragment() {

    private lateinit var binding: FragmentAddShoeBinding

    private val viewModel: ShoeListViewModel by activityViewModels()
    private var shoe: Shoe = Shoe("", "", "", "")

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
        binding.shoe = shoe
        binding.saveBtn.setOnClickListener { view ->
            viewModel.add(shoe)
            navigateToShoeList(view)
        }
        binding.cancelBtn.setOnClickListener { view ->
            navigateToShoeList(view)
        }
        return binding.root
    }

    private fun navigateToShoeList(view: View) {
        view.findNavController()
            .navigate(AddShoeFragmentDirections.actionAddShoeFragmentToShoeListFragment())
    }
}