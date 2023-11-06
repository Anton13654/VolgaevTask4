package com.aeincprojects.volgaevtask4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import by.kirich1409.viewbindingdelegate.viewBinding
import com.aeincprojects.volgaevtask4.databinding.ActivityMainBinding.bind
import com.aeincprojects.volgaevtask4.databinding.FragmentMessageBinding


class MessageFragment : Fragment(R.layout.fragment_message) {

    private val binding: FragmentMessageBinding by viewBinding(FragmentMessageBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var textMessage = "Сообщение"
        binding.messageText.text = textMessage

        binding.messageButton.setOnClickListener {
            val args = Bundle()
            val message = binding.messageText.text.toString()
            args.putString("Key", message)
            setFragmentResultListener(EditMessageFragment.REQUEST_KEY) { key, bundle ->
                textMessage = bundle.getString("Key")!!
                binding.messageText.text = textMessage
            }
            val editMessageFragment = EditMessageFragment()
            editMessageFragment.arguments = args
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, editMessageFragment)
                .addToBackStack(null)
                .commit()
        }

    }

}