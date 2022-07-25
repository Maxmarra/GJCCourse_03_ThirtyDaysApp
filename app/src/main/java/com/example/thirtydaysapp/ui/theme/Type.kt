package com.example.thirtydaysapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.thirtydaysapp.R

val Srirachaface = FontFamily(
    Font(R.font.pacifico_regular)
)

// Set of Material typography styles to start with
val Typography = Typography(
    displaySmall = TextStyle(
        fontFamily = Srirachaface,
        fontWeight = FontWeight.Normal,
        fontSize = 40.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = Srirachaface,
        fontWeight = FontWeight.Normal,
        fontSize = 30.sp
    ),
    titleLarge = TextStyle(
        fontFamily = Srirachaface,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = Srirachaface,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )
)
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
