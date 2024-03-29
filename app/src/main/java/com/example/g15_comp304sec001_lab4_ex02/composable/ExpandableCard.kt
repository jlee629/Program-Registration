package com.example.g15_comp304sec001_lab4_ex02.composable

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.g15_comp304sec001_lab4_ex02.data.Course
import com.example.g15_comp304sec001_lab4_ex02.data.Program
import com.example.g15_comp304sec001_lab4_ex02.ui.theme.CardBackgroundColor
import com.example.g15_comp304sec001_lab4_ex02.ui.theme.CourseNameTextStyle
import com.example.g15_comp304sec001_lab4_ex02.ui.theme.DescriptionTextStyle
import com.example.g15_comp304sec001_lab4_ex02.ui.theme.G15_COMP304Sec001_Lab4_Ex02Theme
import com.example.g15_comp304sec001_lab4_ex02.ui.theme.ProgramTitleTextStyle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpandableCard(
    title: String,
    textStyle: TextStyle,
    content: @Composable () -> Unit,
    extraTopMargin: Dp = 0.dp
) {
    var expanded by remember { mutableStateOf(false) }
    val rotationAngle by animateFloatAsState(if (expanded) 180f else 0f)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = extraTopMargin, bottom = 8.dp, start = 8.dp, end = 8.dp),
        colors = CardDefaults.cardColors(containerColor = CardBackgroundColor),
        onClick = { expanded = !expanded }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = title,
                    style = textStyle,
                    modifier = Modifier.weight(1f)
                )
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "Expand or collapse",
                    modifier = Modifier
                        .rotate(rotationAngle)
                        .size(24.dp),
                    tint = Color.DarkGray
                )
            }
            if (expanded) {
                content()
            }
        }
    }
}

@Composable
fun ProgramsLayer(programs: List<Program>) {
    LazyColumn {
        itemsIndexed(programs) { index, program ->
            ExpandableCard(
                title = program.name,
                textStyle = ProgramTitleTextStyle,
                content = { CoursesLayer(courses = program.courses) },
                extraTopMargin = if (index == 0) 16.dp else 8.dp
            )
        }
    }
}

@Composable
fun CoursesLayer(courses: List<Course>) {
    Column {
        courses.forEach { course ->
            ExpandableCard(
                title = course.name,
                textStyle = CourseNameTextStyle,
                content = {
                    Text(
                        text = course.description,
                        style = DescriptionTextStyle,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

    val sampleCourses = listOf(Course("Cloud Machine Learning", "Description of Cloud Machine Learning"))
    val samplePrograms = listOf(Program("Artificial Intelligence", sampleCourses))

    G15_COMP304Sec001_Lab4_Ex02Theme {
        ProgramsLayer(programs = samplePrograms)
    }
}