package com.example.clone.whatsapp.screen.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.example.clone.whatsapp.data.local.addChat
import com.example.clone.whatsapp.data.model.User
import com.example.clone.whatsapp.screen.chat.ui.ChatScreenView
import com.example.clone.whatsapp.ui.WhatsAppTheme

@ExperimentalFoundationApi
class ChatFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val userName = arguments?.getString("userName") ?: ""
        val userImage = arguments?.getString("userImage") ?: ""

        return ComposeView(requireContext()).apply {
            setContent {
                WhatsAppTheme {
                    ChatScreenView(User(2, userName, userImage), {
                        requireActivity().onBackPressed()
                    }) { message ->
                        if (message.isNotEmpty()) {
                            addChat(message)
                        }
                    }
                }
            }
        }
    }
}