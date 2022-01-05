package com.feizai.compose

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.feizai.compose.ui.theme.ComposeTheme
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration

class MainActivity : ComponentActivity() {

    var intentActivityResultLauncher:ActivityResultLauncher<Intent>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        intentActivityResultLauncher=
            registerForActivityResult(ActivityResultContracts.StartActivityForResult(),
                ActivityResultCallback { })
        setContent {
            ComposeTheme {
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
                onClick = {
                    intentActivityResultLauncher?.launch(
                        Intent(
                            this@MainActivity,
                //                            RecyclerActivity().javaClass,
                            RecyclerActivity::class.java
                        )

                    )
                },
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



            Row(modifier = Modifier.padding(10.dp)) {
                ShowTextField()
            }

            Column(Modifier.fillMaxWidth()) {
//                addContentView(
//                    ShowRecyclerview(),
//                    ViewGroup.LayoutParams(
//                        ViewGroup.LayoutParams.MATCH_PARENT,
//                        ViewGroup.LayoutParams.WRAP_CONTENT
//                    )
//                )
                generateList()
            }

            Box() {

            }
        }
    }

    @Composable
    fun generateList() {
        var listData: List<String> = ArrayList<String>()
        //准备数据
        for (i in 1..5) {
            listData += "aa"
            listData += "bb"
            listData += "cc"
            listData += "dd"
        }

        LazyColumn(content = {
            //头部内容
            item {
                Box(
                    modifier = Modifier
                        .background(Color.Blue)
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "头部", color = Color.Red)
                }
            }

            //列表内容
            items(listData) {
                Column(Modifier.clickable { showToast(it) }) {
                    Box(
                        modifier = Modifier
                            .background(Color.Yellow)
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "列表项：$it")
                    }
                    Box(
                        modifier = Modifier
                            .background(Color.Black)
                            .fillMaxWidth()
                            .padding(1.dp),
                        contentAlignment = Alignment.Center
                    ) {}
                }

            }

            //尾部内容
            item {
                Box(
                    modifier = Modifier
                        .background(Color.Blue)
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "尾部", color = Color.Red)
                }
            }
        }, modifier = Modifier.fillMaxWidth())
//        AdapterList(data = list) {
//            Card(
//                shape = MaterialTheme.shapes.medium,
//                modifier = Modifier
//                    .preferredSize(context.resources.displayMetrics.widthPixels.dp, 60.dp)
//                    .padding(10.dp)
//            ) {
//
//                Box(gravity = ContentGravity.Center) {
//                    ProvideEmphasis(EmphasisAmbient.current.medium) {
//                        Text(
//                            text = it,
//                            style = MaterialTheme.typography.body2
//                        )
//                    }
//                }
//
//            }
//            Spacer(modifier = Modifier.preferredHeight(10.dp))
//        }
    }

    @Composable
    fun ShowRecyclerview(): View {
        var myrecycler: RecyclerView = RecyclerView(this)
        var mydata: MutableList<String> = ArrayList<String>()
        mydata += "aa"
        mydata += "bb"
        mydata += "cc"
        mydata += "dd"
        myrecycler.layoutManager =
            LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        myrecycler.addItemDecoration(
            HorizontalDividerItemDecoration.Builder(this@MainActivity)
                .color(android.graphics.Color.BLACK)
                .size(2).build()
        )
        myrecycler.adapter = MyAdapter(this@MainActivity, mydata)
//        myrecycler.Recycler()
        return myrecycler
    }


    @Composable
    fun ShowTextField() {
        val mytext = rememberSaveable {
            mutableStateOf("")
        }
        TextField(
            value = mytext.value,
            onValueChange = { mytext.value = it },
            modifier = Modifier.fillMaxWidth(),
            maxLines = 1,
            label = { Text(text = "输入框") },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),//展示密文
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        ComposeTheme {
            Greeting("Android")
        }
    }

}