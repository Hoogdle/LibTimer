package com.example.librarytimer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.librarytimer.ui.theme.BackGroundColor
import com.example.librarytimer.ui.theme.OffColor
import com.example.librarytimer.ui.theme.OnColor
import com.example.librarytimer.ui.theme.TextColor

@Composable
fun Home(
    isOnOff: MutableState<Boolean>,
    navController: NavController
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackGroundColor)
    ){
        SettingIcon(navController)
        TimerSet(isOnOff)
        HomeText()
    }
}

@Composable
fun SettingIcon(
    navController: NavController
){
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ){
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
                painter = painterResource(R.drawable.setting_icon),
                contentDescription = "설정 아이콘입니다.",
                tint = Color.White,
                modifier = Modifier
                    .size(25.dp)
                    .clickable {
                        navController.navigate("setting")
                    }
            )
        }
    }
}

@Composable
fun TimerSet(
    isOnOff: MutableState<Boolean>
){
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .offset(
                y = -30.dp
            )
        ,
        verticalArrangement = Arrangement.Center
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Button(
                colors = ButtonColors(
                    contentColor = Color.Transparent,
                    containerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    disabledContentColor = Color.Transparent
                ),
                onClick = {
                    isOnOff.value = !isOnOff.value
                },
                shape = CircleShape,
                contentPadding = PaddingValues(0.dp),
                modifier = Modifier
                    .size(150.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.clock),
                    contentDescription = "타이머 시작 버튼입니다. 타이머를 시작하려면 버튼을 클릭해주세요.",
                    modifier = Modifier
                        .size(150.dp)
                )
            }
        }

        Spacer(Modifier.height(45.dp))
        HomeText()
        Spacer(Modifier.height(35.dp))
        HomeButton(isOnOff.value)
    }
}

@Composable
fun HomeText(){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ){
        Text(
            text = "LIB TIMER",
            style = TextStyle(
                color = Color.White,
                fontSize = 25.sp
            )
        )
    }
}

@Composable
fun HomeButton(
    isOnOff: Boolean
){
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ){
        Box(
            modifier = Modifier
                .width(100.dp)
                .height(45.dp)
                .clip(
                    RoundedCornerShape(7.dp)
                )
                .background(
                    if(isOnOff) {OnColor} else {OffColor}
                ),
                contentAlignment = Alignment.Center
        ){
            Text(
                text = if(isOnOff){"ON"} else {"OFF"},
                style = TextStyle(
                    color = TextColor,
                    fontSize = 25.sp,
                )
            )
        }
    }
}