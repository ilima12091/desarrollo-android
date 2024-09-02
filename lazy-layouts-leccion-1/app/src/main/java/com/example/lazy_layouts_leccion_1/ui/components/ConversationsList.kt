package com.example.lazy_layouts_leccion_1.ui.components

import com.example.lazy_layouts_leccion_1.R
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.lazy_layouts_leccion_1.data_classes.Contact
import com.example.lazy_layouts_leccion_1.data_classes.Conversation
import com.example.lazy_layouts_leccion_1.data_classes.Message

@Composable
fun ConversationsList(
    conversations: List<Conversation>
) {
    LazyColumn {
        items(conversations) {
            ConversationItem(conversation = it)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ConversationsListPreview() {
    val conversations = listOf(
        Conversation(
            contact = Contact(
                name = "Test",
                profilePicture = R.drawable.ic_launcher_foreground
            ),
            messages = listOf(
                Message(
                    "Hello!",
                    "02/09/2024"
                )
            )
        ),
    )

    ConversationsList(conversations)
}