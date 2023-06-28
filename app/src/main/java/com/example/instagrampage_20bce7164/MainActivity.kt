package com.example.instagrampage_20bce7164

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Row(horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Top,
                modifier = Modifier
                    .fillMaxSize()) {
                Text(text = "English (India)")
                Image(
                    painter = painterResource(id = R.drawable.ic_baseline_arrow_drop_down_24),
                    contentDescription = "")
            }
            Column(verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(all = 20.dp)){

                Image(
                    painter = painterResource(id = R.drawable.ic_instalogo),
                    contentDescription = "",
                    Modifier
                        .padding(top = 50.dp)
                        .size(size = 200.dp)
                )

                var user by remember {
                    mutableStateOf("")
                }
                TextField(value = user,
                    onValueChange = {user = it},
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text(text = "Phone number, email or username") })

                var password by rememberSaveable { mutableStateOf("") }
                var passwordVisible by rememberSaveable { mutableStateOf(false) }

                TextField(
                    value = password,
                    onValueChange = { password = it },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    placeholder = { Text("Password") },
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    trailingIcon = {
                        val image = if (passwordVisible)
                            Icons.Filled.Visibility
                        else Icons.Filled.VisibilityOff

                        IconButton(onClick = {passwordVisible = !passwordVisible}){
                            Icon(imageVector  = image, contentDescription = "")
                        }
                    }
                )

                Button(onClick = {
                    Toast.makeText(applicationContext,
                        "Button Clicked",
                        Toast.LENGTH_SHORT).show()
                },
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    colors = ButtonDefaults.buttonColors(Color.Blue)) {
                    Text(text = "Log In", color = Color.White)
                }

                Row(Modifier.padding(top = 20.dp)){
                    Text(text = "Forgot your login details? ")
                    Text("Get help logging in.", fontWeight = FontWeight.Bold)
                }

                Text(text = "OR", Modifier.padding(top = 20.dp))

                Row(Modifier.padding(top = 20.dp)){
                    Image(painter = painterResource(id = R.drawable.facebook), 
                        contentDescription = "",
                        Modifier.size(size = 30.dp))
                    
                    Text(text = "Log in with Facebook", Modifier.padding(start = 5.dp, top = 5.dp), color = Color.Blue)
                }

                Row(Modifier.padding(top = 140.dp)){
                    Text(text = "Don't have an account? ")
                    Text("Sign up.", fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}
