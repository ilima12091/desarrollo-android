package com.example.lazy_layouts_leccion_1.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lazy_layouts_leccion_1.R
import com.example.lazy_layouts_leccion_1.data_classes.Contact
import com.example.lazy_layouts_leccion_1.data_classes.Conversation
import com.example.lazy_layouts_leccion_1.data_classes.Message
import com.example.lazy_layouts_leccion_1.ui.components.ConversationsList

@Composable
fun MainScreen(modifier: Modifier) {
    val conversations = mutableListOf(
        Conversation(
            contact = Contact(
                name = "Ricardo",
                profilePicture = R.drawable.ic_launcher_foreground
            ),
            messages = listOf(
                Message(
                    "Hello!",
                    "02/09/2024"
                ),
                Message(
                    "Bye!",
                    "02/09/2024"
                )
            )
        ),
        Conversation(
            contact = Contact(
                name = "Walter",
                profilePicture = R.drawable.ic_launcher_background
            ),
            messages = listOf(
                Message(
                    "Hello!",
                    "01/09/2024"
                ),
                Message(
                    "Bye!",
                    "02/09/2024"
                )
            )
        ),
    )

    for (i in 0..3) {
        conversations += conversations
    }

    Column(modifier = modifier) {
        ConversationsList(conversations)
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen(modifier = Modifier)
}