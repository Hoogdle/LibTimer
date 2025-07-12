package com.example.librarytimer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.librarytimer.ui.theme.BackGroundColor

@Composable
fun Home(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackGroundColor)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ){
            Button(
                onClick = {}
            ) {
                Icon(
                    painter = painterResource(R.drawable.setting_icon),
                    contentDescription = "설정 아이콘입니다.",
                    tint = Color.White,
                    modifier = Modifier
                        .size(25.dp)
                        .offset(
                            x = -30.dp,
                            y = 30.dp
                        )
                        .clickable {  }
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .offset(
                    y = -50.dp
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
                    onClick = {},
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
        }
    }
}

@Composable
fun HomeButton(){

}
