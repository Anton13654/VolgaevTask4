package com.aeincprojects.volgaevtask4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.aeincprojects.volgaevtask4.databinding.FragmentEditMessageBinding


class EditMessageFragment : Fragment(R.layout.fragment_edit_message) {

    private val binding: FragmentEditMessageBinding by viewBinding(FragmentEditMessageBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val message = arguments?.getString("Key")

        binding.editTextMessage.setText(message)
        binding.editTextButton.setOnClickListener {
            val newMessage = binding.editTextMessage.text.toString()
            goBack(newMessage)
        }
    }

    private fun goBack(message: String){
        setFragmentResult(REQUEST_KEY, bundleOf("Key" to message))
        parentFragmentManager.popBackStack()
    }

    companion object {
        const val REQUEST_KEY = "Key2"
    }

}