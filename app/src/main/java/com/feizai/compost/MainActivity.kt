package com.feizai.compost

import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.feizai.compost.ui.theme.CompostTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompostTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }

    fun showToast(content: CharSequence) {
        Toast.makeText(
            this,
            content,
            Toast.LENGTH_SHORT
        ).show();
    }


    @Composable
    fun Greeting(name: String) {

        Column() {
            Text(
                text = "Hello $name!",
                color = Color.Blue,//文字颜色
                fontSize = 14.sp,//文字字体大小
                fontStyle = FontStyle.Normal,//正常文字
                fontWeight = FontWeight.Normal,//正常文字
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Cyan)
                    .clickable { showToast("HHH") },
                textAlign = TextAlign.Center, //文字居中
            )
            Button(
                onClick = { showToast("aaaa") },
                modifier = Modifier
                    .padding(10.dp),
                border = BorderStroke(2.dp, Color.Red),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Gray,
                    contentColor = Color.Yellow,
                    disabledBackgroundColor = Color.DarkGray,
                    disabledContentColor = Color.Black
                )
            ) {
                Text(
                    text = "aaa",
                    color = Color.Green,//文字颜色
                    fontSize = 14.sp,//文字字体大小
                    fontStyle = FontStyle.Normal,//正常文字
                    fontWeight = FontWeight.Normal,//正常文字
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Transparent),
                    textAlign = TextAlign.Center,
                )
            }

            Row() {
//                var textValue by savedInstanceState { "" }
//                TextField(value = textValue, onValueChange = { textValue = it })
            }

            Box() {

            }
        }


    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        CompostTheme {
            Greeting("Android")
        }
    }

}