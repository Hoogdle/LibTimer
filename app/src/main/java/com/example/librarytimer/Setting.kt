package com.example.librarytimer

import android.text.method.BaseKeyListener
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asComposePath
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.graphics.shapes.CornerRounding
import androidx.graphics.shapes.RoundedPolygon
import androidx.graphics.shapes.toPath
import androidx.navigation.NavController
import com.example.librarytimer.ui.theme.BackGroundColor
import com.example.librarytimer.ui.theme.TextColor
import com.example.librarytimer.ui.theme.TimerBackgroundColor

@Composable
fun Setting(
    navController: NavController,
    libHourTen: MutableState<Int>,
    libHourOne: MutableState<Int>,
    libMinTen: MutableState<Int>,
    libMinOne: MutableState<Int>,
    expendHourTen: MutableState<Int>,
    expendHourOne: MutableState<Int>,
    expendMinTen: MutableState<Int>,
    expendMinOne: MutableState<Int>,
    ){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackGroundColor)
    ){
        SettingClose(
            navController = navController
        )
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            SettingInfo(
                infoText = "도서관 이용시간",
                toggleText = ""
            )

            SettingTimeBox(libHourTen,libHourOne,libMinTen,libMinOne)
        }
    }
}

@Composable
fun SettingClose(
    navController: NavController
){
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {
        Button(
            colors = ButtonColors(
                containerColor = Color.Transparent,
                contentColor = Color.Transparent,
                disabledContentColor = Color.Transparent,
                disabledContainerColor = Color.Transparent
            ),
            onClick = {},
            shape = CircleShape,
            contentPadding = PaddingValues(0.dp),
            modifier = Modifier
                .size(25.dp)
                .offset(
                    x = -20.dp,
                    y = 40.dp
                )
        ) {
            Icon(
                painter = painterResource(R.drawable.info_icon),
                contentDescription = "설정 아이콘입니다.",
                tint = Color.White,
                modifier = Modifier
                    .size(25.dp)
                    .clickable {
                        navController.navigate("home")
                    }
            )
        }
    }
}

@Composable
fun SettingInfo(
    infoText: String,
    toggleText: String
){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){

        Button(
            onClick = {},
            contentPadding = PaddingValues(0.dp),
            modifier = Modifier
                .size(40.dp),
            shape = CircleShape,
            colors = ButtonColors(
                containerColor = Color.Transparent,
                contentColor = Color.White,
                disabledContentColor = Color.White,
                disabledContainerColor = Color.Transparent
            )
        ) {
            Icon(
                painter = painterResource(R.drawable.error),
                contentDescription = infoText + "설정 상세 정보입니다. 한 번 더 터치하여 시간 설정 방법을 안내 받으세요.",
                modifier = Modifier
                    .size(40.dp)
                    .clickable {  }
            )
        }

        Spacer(Modifier.width(15.dp))

        Text(
            text = infoText,
            style = TextStyle(
                color = Color.White,
                fontSize = 25.sp,
                textAlign = TextAlign.Center
            ),
        )
    }
}

@Composable
fun SettingTimeBox(
    hourTen: MutableState<Int>,
    hourMin: MutableState<Int>,
    minTen: MutableState<Int>,
    minOne: MutableState<Int>
){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        SettingTimeOneBox(hourTen,hourMin)
        SettingTimeOneBox(minTen, minOne)
    }
}

@Composable
fun SettingTimeOneBox(
    ten: MutableState<Int>,
    one: MutableState<Int>
){
    Row(
        horizontalArrangement = Arrangement.Center
    ){
        SettingTimeTextFiled(
            input = ten
        )
        SettingTimeTextFiled(
            input = one
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingTimeTextFiled(
    input: MutableState<Int>
){
    val interactionSource = remember { MutableInteractionSource() }

    BasicTextField(
        // 필터 입력 후 Action에 대해 정의

        value = "",
        onValueChange = {
        },
        modifier = Modifier
            .padding(
                start = 10.dp,
                end = 10.dp
            )
            .clip(RoundedCornerShape(10.dp))
            .background(
                color = Color.Transparent
            )
            .height(60.dp),
        singleLine = true,
        textStyle = TextStyle(
            color = TextColor,
            fontSize = 15.sp
        ),

        decorationBox = @Composable { innerTextField ->
            TextFieldDefaults.DecorationBox(
                placeholder = {
                    Text(
                        text = "새 테이블 이름",
                        color = TextColor,
                        style = TextStyle(
                            color = TextColor,
                            fontSize = 15.sp
                        ),
                    )
                },
                singleLine = true,
                visualTransformation = VisualTransformation.None,
                enabled = true,
                innerTextField = innerTextField,
                value = "",
                interactionSource = interactionSource,
                colors = TextFieldDefaults.colors(
                    focusedTextColor = TextColor,
                    unfocusedTextColor = TextColor,
                    focusedIndicatorColor = TimerBackgroundColor,
                    unfocusedIndicatorColor = TimerBackgroundColor,
                    cursorColor = TextColor,
                    unfocusedContainerColor = TimerBackgroundColor,
                    focusedContainerColor = TimerBackgroundColor,
                    errorContainerColor = TimerBackgroundColor,
                    disabledContainerColor = TimerBackgroundColor
                ),
            )
        }
    )
}