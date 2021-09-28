package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
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
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.android.material.composethemeadapter.MdcTheme
import com.udacity.shoestore.databinding.FragmentWelcomeBinding

/** Defines the welcome fragment. */
class WelcomeFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_welcome,
            container,
            false
        )
        val composeView = binding.root.findViewById<ComposeView>(R.id.composeView)
        composeView.setContent {
            MdcTheme {
                Greeting()
            }
        }
        binding.seeInstructionsContainedButton.setOnClickListener { view ->
            val instructionsDirections =
                WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment()
            view.findNavController().navigate(instructionsDirections)
        }
        return binding.root
    }
}

@Composable
private fun Greeting() {
    Row(horizontalArrangement = Arrangement.Center) {
        Column {
            Text(
                text = stringResource(R.string.welcomeTextView),
                modifier = Modifier.padding(24.dp)
            )
            Text(
                text = stringResource(R.string.app_name),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colors.secondaryVariant,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}
