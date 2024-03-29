package com.example.g15_comp304sec001_lab4_ex02.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.g15_comp304sec001_lab4_ex02.ui.theme.G15_COMP304Sec001_Lab4_Ex02Theme
import com.example.g15_comp304sec001_lab4_ex02.ui.theme.MyThemeTypography

@Composable
fun ProgramHeader(title: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = title,
            style = MyThemeTypography.bodyLarge,
            modifier = Modifier.headerModifier(),
            textAlign = TextAlign.Center
        )
    }
}
fun Modifier.headerModifier(): Modifier = composed {
    this
        .fillMaxWidth()
        .padding(vertical = 20.dp)
        .clip(RoundedCornerShape(10.dp))
        .background(MaterialTheme.colorScheme.secondary)
        .padding(20.dp)
}

@Preview(showBackground = true)
@Composable
fun ProgramHeaderPreview() {
    G15_COMP304Sec001_Lab4_Ex02Theme {
        ProgramHeader(title = "CENTENNIAL COLLEGE PROGRAMS")
    }
}