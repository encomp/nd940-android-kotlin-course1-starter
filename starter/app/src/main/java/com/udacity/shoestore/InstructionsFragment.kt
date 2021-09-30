package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.google.android.material.composethemeadapter.MdcTheme
import com.udacity.shoestore.databinding.FragmentInstructionsBinding

/** Define the instructions fragment. */
class InstructionsFragment : Fragment() {

    private lateinit var binding: FragmentInstructionsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_instructions,
            container,
            false
        )
        val composeView = binding.root.findViewById<ComposeView>(R.id.composeView)
        composeView.setContent {
            MdcTheme {
                Greeting()
            }
        }
        binding.shopContainedButton.setOnClickListener { view ->
            view.findNavController().navigate(
                InstructionsFragmentDirections.actionInstructionsFragmentToShoeListFragment()
            )
        }
        return binding.root
    }
}

@Composable
private fun Greeting() {
    Row(horizontalArrangement = Arrangement.Center) {
        Column {
            Text(
                text = stringResource(R.string.instructionsTitleTextView),
                modifier = Modifier.padding(24.dp),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colors.secondaryVariant,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = stringResource(R.string.firstInstructionTextView),
                modifier = Modifier.padding(12.dp),
            )
            Text(
                text = stringResource(R.string.secondInstructionTextView),
                modifier = Modifier.padding(12.dp),
            )
            Text(
                text = stringResource(R.string.thirdInstructionTextView),
                modifier = Modifier.padding(12.dp),
            )
        }
    }
}