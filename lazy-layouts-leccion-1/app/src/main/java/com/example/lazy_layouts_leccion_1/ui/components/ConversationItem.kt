package com.example.lazy_layouts_leccion_1.ui.components

import com.example.lazy_layouts_leccion_1.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lazy_layouts_leccion_1.data_classes.Contact
import com.example.lazy_layouts_leccion_1.data_classes.Conversation
import com.example.lazy_layouts_leccion_1.data_classes.Message

@Composable
fun ConversationItem(conversation: Conversation) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = conversation.contact.profilePicture),
                contentDescription = "Contact profile picture",
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = conversation.contact.name,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = conversation.messages.first().text,
                    color = Color.Gray
                )
            }
        }
        Text(
            text = conversation.messages.first().date,
            color = Color.Gray,
            modifier = Modifier.align(Alignment.TopEnd)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ConversationItemPreview() {
    ConversationItem(Conversation(
        contact = Contact("Test", R.drawable.ic_launcher_background),
        messages = listOf(Message("Message", "02/02/2024"))
    ))
}