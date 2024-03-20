package br.com.edutech.screens

import android.database.sqlite.SQLiteConstraintException
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.edutech.database.repository.UserRepository
import br.com.edutech.model.User

@Composable
fun RegisterScreen(navController: NavController) {
    val context = LocalContext.current
    val userRepository = UserRepository(context)

    var name = remember {
        mutableStateOf("")
    }

    var email = remember {
        mutableStateOf("")
    }

    var password = remember {
        mutableStateOf("")
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(top = 50.dp)
    )
    {
        Text(
            text = "Cadastre-se",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(50.dp))

        OutlinedTextField(
            value = name.value,
            onValueChange = {name.value = it},
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            label = { Text("Nome") },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Person, contentDescription = "", tint = Color.Green)
            },
            shape = RoundedCornerShape(16.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Green
            ),

        )

        OutlinedTextField(
            value = email.value,
            onValueChange = {email.value = it},
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            label = { Text("E-mail") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            leadingIcon = {
                Icon(imageVector = Icons.Default.Email, contentDescription = "", tint = Color.Green)
            },
            shape = RoundedCornerShape(16.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Green
            )
        )

        OutlinedTextField(
            value = password.value,
            onValueChange = {password.value = it},
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            label = { Text("Senha") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            leadingIcon = {
                Icon(imageVector = Icons.Default.Lock, contentDescription = "", tint = Color.Green)
            },
            shape = RoundedCornerShape(16.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Green
            )
        )

        ElevatedButton(
            onClick = {
                val user = User(id = 0, name = name.value, email = email.value, password = password.value)
                try {
                    val res = userRepository.create(user)
                    Log.d("UserRepository", "Resultado do cadastro: $res")
                    if (res > 0) navController.navigate("login")
                } catch (e: SQLiteConstraintException) {

                }

            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Green
            ),
            modifier = Modifier
                .width(300.dp)
                .padding(top = 30.dp)
        ) {
            Text(
                text = "Cadastrar",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

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
                Text(text = "Fazer Login")
            }
        }
    }
}