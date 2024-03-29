package com.example.g15_comp304sec001_lab4_ex02

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.g15_comp304sec001_lab4_ex02.composable.ProgramHeader
import com.example.g15_comp304sec001_lab4_ex02.composable.ProgramLogo
import com.example.g15_comp304sec001_lab4_ex02.composable.ProgramsLayer
import com.example.g15_comp304sec001_lab4_ex02.data.Program
import com.example.g15_comp304sec001_lab4_ex02.ui.theme.G15_COMP304Sec001_Lab4_Ex02Theme
import com.example.g15_comp304sec001_lab4_ex02.viewmodel.ProgramsViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val programsViewModel = ViewModelProvider(this).get(ProgramsViewModel::class.java)
        setContent {
            G15_COMP304Sec001_Lab4_Ex02Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.tertiary
                ) {
                    ProgramsUI(programsViewModel)
                }
            }
        }
    }
}
@Composable
fun ProgramsUI(programsViewModel: ProgramsViewModel) {

    val programs = remember { mutableStateListOf<Program>() }

    // load programs asynchronously when the composable enters the composition
    LaunchedEffect(Unit) {
        programs.addAll(programsViewModel.loadPrograms())
    }

    Column(modifier = Modifier.fillMaxSize()) {
        ProgramHeader(title = "CENTENNIAL COLLEGE PROGRAMS")
        ProgramsLayer(programs = programs)
        ProgramLogo()
    }
}




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MaterialTheme {
    }
}
