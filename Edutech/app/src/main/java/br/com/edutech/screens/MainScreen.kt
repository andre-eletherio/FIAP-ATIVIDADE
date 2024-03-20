package br.com.edutech.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun MainScreen(navController: NavController) {
    val colors = listOf(Color.Blue, Color.Red, Color.Magenta, Color.Black, Color.Yellow, Color.Cyan, Color.Green)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(
                top = 50.dp,
                start = 20.dp,
                end = 20.dp
            )
            .fillMaxSize()
    ) {
        Text(
            text = "Matérias",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(50.dp))

        listOf("matemática", "geografia", "física", "história").forEachIndexed { index, subject ->
            SubjectContainer(
                subject = subject,
                color = colors.getOrElse(index % colors.size) { Color.Black },
                onClick = {navController.navigate("question/$subject")}
            )
            Spacer(modifier = Modifier.height(20.dp))
        }

        // Botão Voltar
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = { navController.navigate("login") },
                modifier = Modifier.fillMaxWidth(0.4f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.LightGray
                ),
            ) {
                Text(text = "Sair")
            }
        }
    }
}

@Composable
fun SubjectContainer(subject: String, color: Color, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color, shape = RoundedCornerShape(16.dp))
            .padding(32.dp)
            .clickable(onClick = onClick), // Adicionando o clique ao Box
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = subject.capitalize(),
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
    }
}
