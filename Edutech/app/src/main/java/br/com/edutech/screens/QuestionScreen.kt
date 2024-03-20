package br.com.edutech.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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

import androidx.compose.runtime.*

@Composable
fun AnswerButton(
    correct: Int,
    number: Int,
    answer: String
) {
    var isClicked by remember { mutableStateOf(false) }

    Button(
        onClick = { isClicked = true },
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isClicked) {
                if (number == correct) Color.Green else Color.Red
            } else {
                Color.Gray // Cor padrão quando o botão não foi clicado
            }
        )
    ) {
        Text(text = answer.toString())
    }
}

@Composable
fun QuestionScreen(navController: NavController, subject: String) {
    var selectedAnswer by remember { mutableStateOf(0) }
    val correct = 1

    var question = ""

    if (subject == "matemática") {
        question = "Quanto é 40 / 2?"
    } else if (subject == "geografia") {
        question = "Qual a capital de Portugal?"
    } else if (subject == "física") {
        question = "Qual é a unidade de medida da força?"
    } else if (subject == "história") {
        question = "Quem foi o primeiro presidente do Brasil?"
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(
                top = 50.dp,
                start = 20.dp,
                end = 20.dp
            )
    ) {
        Text(
            text = "Escolha a correta",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.height(50.dp))

        Text(
            text = question,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(30.dp))

        var answers = listOf<String>()

        if (subject == "matemática") {
            answers = listOf("10", "20", "30")
        } else if (subject == "geografia") {
            answers = listOf("Porto", "Lisboa", "Coimbra")
        } else if (subject == "física") {
            answers = listOf("Quilos", "Newton", "Tesla")
        } else if (subject == "história") {
            answers = listOf("Getúlio Vargas", "Deodoro da Fonseca", "Tancredo Neves")
        }

        // Renderização dos botões de resposta usando a lista de respostas
        answers.forEachIndexed { index, answer ->
            AnswerButton(
                correct = correct,
                number = index,
                answer = answer
            )
            if (index < answers.size - 1) {
                Spacer(modifier = Modifier.height(10.dp))
            }
        }

        Spacer(modifier = Modifier.height(40.dp))

        // Botão Voltar
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = { navController.navigate("main") },
                modifier = Modifier.fillMaxWidth(0.4f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.LightGray
                ),
            ) {
                Text(text = "Voltar")
            }
        }
    }
}
