package com.example.fundamentosjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider

class MainActivity : ComponentActivity() {

    private lateinit var myViewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        myViewModel = ViewModelProvider(this)[ViewModel::class.java]

        setContent {
            MainScreen(myViewModel)
        }
    }
}

@Composable
fun MainScreen(exmpViewModel: ViewModel){

    var contadorView by remember {
        mutableStateOf(exmpViewModel.getContadorViewModel())
    }

    val contadorProvModelView by exmpViewModel.contadorView.collectAsState()

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Gray), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

        Row {
            Text(text = "CONTADOR", fontSize = 40.sp, color = Color.White, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            contadorView += 1
            exmpViewModel.incrementContador()
        }, modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black,
                backgroundColor = Color.LightGray
            )
        ){
            Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
            Text(text = "INCREMENTAR CONTADOR")
        }

        Button(onClick = {
            contadorView -= 1
            exmpViewModel.decrementContador()
        }, modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.LightGray,
                contentColor = Color.Red
            )
        ){
            Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = "Add")
            Text(text = "DECREMENTAR CONTADOR")
        }
        Text(text = "Contador da View = $contadorView", color = Color.White)
        Text(text = "Contador da ViewModel = $contadorProvModelView", color = Color.White)

        Spacer(modifier = Modifier.height(20.dp))

        BottomAppBar(
            backgroundColor = Color.DarkGray,
            contentColor = Color.LightGray,
            contentPadding = PaddingValues(7.dp),
            content = {
                Text("Eliel Andrade Matos Godoy", fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.width(130.dp))
                Text("RM: 22320", fontWeight = FontWeight.Bold)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    //MainScreen()
}