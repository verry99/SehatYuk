package com.example.fitnessapp.presentation.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.fitnessapp.presentation.ui.theme.body2
import com.example.fitnessapp.presentation.ui.theme.title3

@Composable
fun ArticleItem(
    imageUrl: String,
    title: String,
    description: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = title,
            Modifier
                .height(90.dp)
                .width(160.dp)
        )
        Spacer(Modifier.width(20.dp))
        Column {
            Text(
                text = title,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.title3
            )
            Text(
                text = description,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(0.dp, 5.dp, 0.dp, 0.dp)
            )
        }
    }
}

@Preview
@Composable
fun ArticleItemReview() {
    ArticleItem(
        imageUrl = "https://images.everydayhealth.com/images/swimming-overview-guide-1440x810.jpg",
        title = "Swimming: Health Benefits, How to Get Started, and How to Get Better at It",
        description = "Swimming is an activity that involves coordination of arm and leg motions to propel your body through water, according to the Encyclopedia Britannica definition. Those motions demand a lot of effort to overcome water’s natural resistance, meaning you’ll certainly strengthen your muscles when you swim. But swimming is primarily a form of cardiovascular exercise, says Kristopher Gagne, regional head swim coach at the Houston-area Life Time Swim facilities.\n" +
                "\n" +
                "Simply splashing around in a pool, lake, or ocean doesn’t automatically mean you’re swimming for exercise. But you don’t have to be into competitive swimming either to get something out of it. \"What separates a swimming workout from a leisurely swim is the structure and goal behind the swim,” says Todd Buckingham, PhD, a competitive triathlete and chief exercise physiologist at The Bucking Fit Life, a holistic fitness, nutrition, and mental health coaching program in East Lansing, Michigan.\n" +
                "\n" +
                "When you swim for exercise, you get a total-body workout, which means that most of your muscles are involved, which can improve muscle strength. According to Dr. Buckingham, the primary muscles used are the large muscles in your back (latissimus dorsi and trapezius), chest (pectoralis major), shoulders (deltoids), hips (glutes), legs (quadriceps and hamstrings), and midsection (abdominals). Your arms also play a key role in moving you through the water.\n" +
                "\n" +
                "There are four strokes used in swimming: backstroke, butterfly, breaststroke, and freestyle (also called the front crawl). Each style requires different muscles to work to varying degrees. “The backstroke, as the name implies, will require more muscles in the back to be used than in other strokes, but for the most part, all stroke styles use similar muscle groups,” Buckingham says.",
        modifier = Modifier.padding(10.dp)
    )
}