package com.dkproject.image_checkbox

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

// Do not ImageCheckbox(modifier=Modifier.size(xx.dp)) (x)
// ImageCheckbox(modifier=Modifier.padding(xx.dp) (o)
// please setting Image size -> checkboxSize
// you can adjust checkStroke depending on the checkboxSize
// you can change backgroundColor, checkColor, checkBox borderStroke
// set checkBoxImage Painter
// value is checkBox value
// you can change textStyle
@Composable
fun ImageCheckbox(
    modifier: Modifier = Modifier,
    checkboxSize: Dp,
    textvalue: String,
    checked: Boolean,
    shape: Shape = CircleShape,
    backgroundColor: Color = Color.LightGray,
    selectBackgroundColor: Color = Color.Gray,
    checkStroke: Float = 25f,
    checkColor: Color = Color.White,
    borderStroke: BorderStroke = BorderStroke(width = 0.dp, color = Color.Transparent),
    imagePainter: Painter,
    textStyle: TextStyle = LocalTextStyle.current,
    onCheckBoxClick: (Boolean, String) -> Unit,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            modifier = Modifier.size(checkboxSize),
            shape = shape,
            border = borderStroke
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = if (!checked) backgroundColor else selectBackgroundColor)
                    .clickable { onCheckBoxClick(!checked, textvalue) }
                    .padding(8.dp), painter = imagePainter, contentDescription = "",
                contentScale = ContentScale.Crop
            )
            if (checked) {
                Canvas(modifier = Modifier.size(checkboxSize)) {
                    drawLine(
                        color = checkColor,
                        start = Offset(size.width / 1.2f, size.height / 3.5f),
                        end = Offset(size.width / 2, size.height / 1.5f),
                        strokeWidth = checkStroke,
                        cap = StrokeCap.Round
                    )
                    drawLine(
                        color = checkColor,
                        start = Offset(size.width / 2, size.height / 1.5f),
                        end = Offset(size.width / 6.5f, size.height / 3.3f),
                        strokeWidth = checkStroke,
                        cap = StrokeCap.Round
                    )
                }
            }
        }
        Text(
            text = textvalue,
            style = textStyle
        )
    }
}