package com.example.composeplayground.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextInputService
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeplayground.R

@Preview(
    showBackground = true,
    showSystemUi = true,
)
@Composable
fun LoginPrv() {
    LoginScreen()
}

@Composable
fun LoginScreen() {
    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        LoginHeader()
        Spacer(modifier = Modifier.height(64.dp))
        LoginTextField()
        Spacer(modifier = Modifier.height(32.dp))
        AutoLoginCheckbox()
        Spacer(modifier = Modifier.height(24.dp))
        InteractionTexts()
        Spacer(modifier = Modifier.height(128.dp))
        LoginButton()
    }
}

@Composable
fun LoginHeader() {
    Column(
        modifier = Modifier.padding(top = 94.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.dms_logo),
            contentDescription = null,
        )
        Text(text = "더 편한 기숙사 생활을 위해")
    }
}

@Composable
fun LoginTextField() {
    var id by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    Column {
        BasicTextField(
            value = id,
            onValueChange = { id = it },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .border(
                    width = 1.dp,
                    color = Color.Black,
                ),
            decorationBox = { innerTextField ->
                Box(
                    contentAlignment = Alignment.CenterStart,
                    modifier = Modifier.padding(start = 16.dp),
                ) {
                    if (id.isEmpty()) {
                        Text(
                            text = "아이디를 입력하세요",
                        )
                    }
                    innerTextField()
                }
            }
        )
        Spacer(modifier = Modifier.padding(bottom = 16.dp))
        Box(
            contentAlignment = Alignment.CenterEnd,
        ) {
            BasicTextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .border(
                        width = 1.dp,
                        color = Color.Black,
                    ),
                visualTransformation = if (passwordVisibility) PasswordVisualTransformation()
                else VisualTransformation.None,
                decorationBox = { innerTextField ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            contentAlignment = Alignment.CenterStart,
                            modifier = Modifier.padding(start = 16.dp).fillMaxWidth(0.9f),
                        ) {
                            if (password.isEmpty()) {
                                Text(
                                    text = "비밀번호를 입력하세요",
                                )
                            }
                            innerTextField()
                        }
                        Image(
                            painter = painterResource(
                                id = if (passwordVisibility) R.drawable.ic_visibility_on
                                else R.drawable.ic_visibility_off
                            ),
                            modifier = Modifier
                                .clickable {
                                    passwordVisibility = !passwordVisibility
                                },
                            contentDescription = null,
                        )
                    }
                }
            )
        }
    }
}

@Composable
fun AutoLoginCheckbox() {
    var autoLogin by remember { mutableStateOf(false) }
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = autoLogin,
            onCheckedChange = { autoLogin = !autoLogin },
            modifier = Modifier.size(width = 32.dp, height = 32.dp)
        )
        Text(
            text = "자동로그인"
        )
    }
}

@Composable
fun InteractionTexts() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "회원가입하기",
            modifier = Modifier.clickable {},
        )
        Text(text = "  |  ")
        Text(
            text = "아이디 찾기",
            modifier = Modifier.clickable {},
        )
        Text(text = "  |  ")
        Text(
            text = "비밀번호 변경",
            modifier = Modifier.clickable {}
        )
    }
}

@Composable
fun LoginButton() {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        onClick = {},
        colors = ButtonDefaults.buttonColors(Color(0xFF3D8AFF))
    ) {
        Text(
            text = "로그인",
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}