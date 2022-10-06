package com.example.clone.whatsapp.screen.chat.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.example.clone.whatsapp.data.local.chat
import com.example.clone.whatsapp.data.model.User

@ExperimentalFoundationApi
@Composable
fun ChatScreenView(user: User, onBackIconClick: () -> Unit, onMessageSend: (String) -> Unit) {
    Scaffold(
        bottomBar = { EditText(onMessageSend) },
        topBar = {
            ChatTopBar(user, onBackIconClick)
        },
        bodyContent = {
            ChatsScrollView(chat.toList())
        }
    )
}