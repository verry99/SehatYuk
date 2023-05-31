package com.example.fitnessapp.presentation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.fitnessapp.R

val InterFont = FontFamily(
    Font(R.font.inter_extralight, FontWeight.ExtraLight),
    Font(R.font.inter_light, FontWeight.Light),
    Font(R.font.inter_thin, FontWeight.Thin),
    Font(R.font.inter_regular, FontWeight.Normal),
    Font(R.font.inter_medium, FontWeight.Medium),
    Font(R.font.inter_semibold, FontWeight.SemiBold),
    Font(R.font.inter_bold, FontWeight.Bold),
    Font(R.font.inter_extrabold, FontWeight.ExtraBold),
    Font(R.font.inter_black, FontWeight.Black)
)

val Typography = Typography(

)

val Typography.title1: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = InterFont,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 24.sp
        )
    }


val Typography.title2: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = InterFont,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
    }

val Typography.title3: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = InterFont,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp
        )
    }

val Typography.body1: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = InterFont,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            color = Color.Gray
        )
    }

val Typography.body2: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = InterFont,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            color = Color.Gray
        )
    }