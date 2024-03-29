package com.example.g15_comp304sec001_lab4_ex02.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.g15_comp304sec001_lab4_ex02.R
import com.example.g15_comp304sec001_lab4_ex02.ui.theme.G15_COMP304Sec001_Lab4_Ex02Theme

@Composable
fun ProgramLogo() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 50.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProgramLogoPreview() {
    G15_COMP304Sec001_Lab4_Ex02Theme {
        ProgramLogo()
    }
}