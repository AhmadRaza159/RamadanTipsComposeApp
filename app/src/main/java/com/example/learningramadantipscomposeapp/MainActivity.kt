package com.example.learningramadantipscomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learningramadantipscomposeapp.data.repos.RamadanRepo
import com.example.learningramadantipscomposeapp.ui.theme.LearningRamadanTipsComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            LearningRamadanTipsComposeAppTheme {
                RamadanApp()
            }
        }
    }
}

@Composable
fun RamadanApp(){
    Scaffold(
        topBar = {
            Text(
                text = stringResource(R.string.app_name),
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.background(MaterialTheme.colorScheme.background).fillMaxWidth().padding(10.dp)
            )
        }
    ) {
        LazyColumn(contentPadding = it){
           items(RamadanRepo.ramadanDays){
               RamadanItem(it, modifier = Modifier.padding(8.dp, 4.dp))
           }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LearningRamadanTipsComposeAppTheme {
        RamadanApp()
    }
}