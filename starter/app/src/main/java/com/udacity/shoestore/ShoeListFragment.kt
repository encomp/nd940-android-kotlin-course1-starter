package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ItemSingleShoeBinding
import com.udacity.shoestore.models.ShoeListViewModel

/** List of shoes fragment. */
class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding

    private val viewModel: ShoeListViewModel by activityViewModels() {
        ShoeListViewModel.Factory()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_list,
            container,
            false
        )
        viewModel.shoes.observe(
            viewLifecycleOwner,
            { shoes ->
                shoes.forEach { shoe ->
                    val shoesBinding = DataBindingUtil.inflate<ItemSingleShoeBinding>(
                        inflater,
                        R.layout.item_single_shoe,
                        binding.shoesList,
                        false
                    )
                    shoesBinding.nameTextView.text = shoe.name
                    shoesBinding.companyTextView.text = shoe.company
                    shoesBinding.sizeTextView.text = shoe.size.toInt().toString()
                    binding.shoesList.addView(shoesBinding.root)
                }
            }
        )
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}
