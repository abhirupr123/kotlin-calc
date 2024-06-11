package com.example.calculator

import android.icu.number.IntegerWidth
import android.os.Bundle
import android.text.BoringLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.calculator.ui.theme.CalculatorTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Box(
                        contentAlignment = Alignment.BottomEnd,
                        modifier = Modifier.background(color = Color.Black)
                    ) {
                        Box(modifier = Modifier.padding(bottom = 500.dp)) {
                            Text(
                                text = Global.text,
                                style = TextStyle(color = Color.White, fontSize = 80.sp),
                            )
                        }
                        Column {
                            Row {
                                Button(onClick = {
                                    if (l) {
                                        if (brac != "")
                                            sec += "0"
                                        else f += "0"
                                    } else if (op != "")
                                        b += "0"
                                    else a += "0"
                                    if (flag)
                                        Global.text += "0"
                                }) {
                                    Text(
                                        text = "0",
                                        color = Color.Black
                                    );
                                }
                                Button(onClick = {
                                    if (l) {
                                        if (brac != "")
                                            sec += "1"
                                        else f += "1"
                                    } else if (op != "")
                                        b += "1"
                                    else a += "1";
                                    if (!flag) {
                                        Global.text = "1"
                                        flag = true
                                    } else Global.text += "1"
                                })
                                {
                                    Text(
                                        text = "1",
                                        color = Color.Black
                                    );
                                }
                                Button(onClick = {
                                    if (l) {
                                        if (brac != "")
                                            sec += "2"
                                        else f += "2"
                                    } else if (op != "")
                                        b += "2"
                                    else a += "2";
                                    if (!flag) {
                                        Global.text = "2"
                                        flag = true
                                    } else Global.text += "2"
                                }) {
                                    Text(
                                        text = "2",
                                        color = Color.Black
                                    );
                                }
                                Button(onClick = {
                                    if (l) {
                                        if (brac != "")
                                            sec += "3"
                                        else f += "3"
                                    } else if (op != "")
                                        b += "3"
                                    else a += "3";
                                    if (!flag) {
                                        Global.text = "3"
                                        flag = true
                                    } else Global.text += "3"
                                })
                                {
                                    Text(
                                        text = "3",
                                        color = Color.Black
                                    );
                                }
                            }
                            Row {
                                Button(onClick = {
                                    if (l) {
                                        if (brac != "")
                                            sec += "4"
                                        else f += "4"
                                    } else if (op != "")
                                        b += "4"
                                    else a += "4";
                                    if (!flag) {
                                        Global.text = "4"
                                        flag = true
                                    } else Global.text += "4"
                                })
                                {
                                    Text(
                                        text = "4",
                                        color = Color.Black
                                    );
                                }
                                Button(onClick = {
                                    if (l) {
                                        if (brac != "")
                                            sec += "5"
                                        else f += "5"
                                    } else if (op != "")
                                        b += "5"
                                    else a += "5";
                                    if (!flag) {
                                        Global.text = "5"
                                        flag = true
                                    } else Global.text += "5"
                                })
                                {
                                    Text(
                                        text = "5",
                                        color = Color.Black
                                    );
                                }
                                Button(onClick = {
                                    if (l) {
                                        if (brac != "")
                                            sec += "6"
                                        else f += "6"
                                    } else if (op != "")
                                        b += "6"
                                    else a += "6"
                                    if (!flag) {
                                        Global.text = "6"
                                        flag = true
                                    } else Global.text += "6"
                                })
                                {
                                    Text(
                                        text = "6",
                                        color = Color.Black
                                    );
                                }
                                Button(onClick = {
                                    if (l) {
                                        if (brac != "")
                                            sec += "7"
                                        else f += "7"
                                    } else if (op != "")
                                        b += "7"
                                    else a += "7";
                                    if (!flag) {
                                        Global.text = "7"
                                        flag = true
                                    } else Global.text += "7"
                                })
                                {
                                    Text(
                                        text = "7",
                                        color = Color.Black
                                    );
                                }
                            }
                            Row {
                                Button(onClick = {
                                    if (l) {
                                        if (brac != "")
                                            sec += "8"
                                        else f += "8"
                                    } else if (op != "")
                                        b += "8"
                                    else a += "8";
                                    if (!flag) {
                                        Global.text = "8"
                                        flag = true
                                    } else Global.text += "8"
                                }) {
                                    Text(
                                        text = "8",
                                        color = Color.Black
                                    );
                                }
                                Button(onClick = {
                                    if (l) {
                                        if (brac != "")
                                            sec += "9"
                                        else f += "9"
                                    } else if (op != "")
                                        b += "9"
                                    else a += "9";
                                    if (!flag) {
                                        Global.text = "9"
                                        flag = true
                                    } else Global.text += "9"
                                })
                                {
                                    Text(
                                        text = "9",
                                        color = Color.Black
                                    );
                                }
                                Button(onClick = {
                                    if (l)
                                        brac = "+"
                                    else op = "+"
                                    Global.text += "+"
                                })
                                {
                                    Text(
                                        text = "+",
                                        color = Color.Black
                                    );
                                }
                                Button(onClick = {
                                    if (l)
                                        brac = "-"
                                    else op = "-"
                                    Global.text += "-"
                                })
                                {
                                    Text(
                                        text = "-",
                                        color = Color.Black
                                    );
                                }
                            }
                            Row {
                                Button(onClick = {
                                    if (l)
                                        brac = "*"
                                    else op = "*"
                                    Global.text += "*"
                                })
                                {
                                    Text(
                                        text = "X",
                                        color = Color.Black
                                    );
                                }
                                Button(onClick = {
                                    if (l)
                                        brac = "/"
                                    else op = "/"
                                    Global.text += "/"
                                })
                                {
                                    Text(
                                        text = "/",
                                        color = Color.Black
                                    );
                                }
                                Button(onClick = {
                                    operation()
                                    Global.text = res.toString()
                                })
                                {
                                    Text(
                                        text = "=",
                                        color = Color.Black
                                    );
                                }
                                Button(onClick = {
                                    Global.text = "0"
                                    res = 0
                                    b = ""
                                    a = ""
                                    flag = false
                                    l = false
                                    op = ""
                                }) {
                                    Text(
                                        text = "C",
                                        color = Color.Black
                                    )
                                }
                            }
                            Row {
                                Button(onClick = {
                                    if (!flag) {
                                        Global.text = "("
                                        flag = true
                                    } else Global.text += "("
                                    l = true

                                }) {
                                    Text(
                                        text = "(",
                                        color = Color.Black
                                    )
                                }
                                Button(onClick = {
                                    Global.text += ")"
                                    brack()
                                    l = false
                                }) {
                                    Text(
                                        text = ")",
                                        color = Color.Black
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}


var a: String = "";
var res: Int = 0;
var op: String = "";
var b: String = "";
var flag: Boolean = false;
var l: Boolean = false
var brac: String = ""
var f: String = ""
var sec: String = ""
var temp: Int = 0

fun operation() {
    if (a != "")
        res = Integer.parseInt(a)
    if (op == "+")
        res += Integer.parseInt(b)
    else if (op == "-")
        res -= Integer.parseInt(b)
    else if (op == "*")
        res *= Integer.parseInt(b)
    else if (op == "/")
        res /= Integer.parseInt(b)
    b = ""
    a = ""
}

fun brack() {
    if (brac == "+")
        temp = Integer.parseInt(f) + Integer.parseInt(sec)
    else if (brac == "-")
        temp = Integer.parseInt(f) - Integer.parseInt(sec)
    else if (brac == "*")
        temp = Integer.parseInt(f) * Integer.parseInt(sec)
    else if (brac == "/")
        temp = Integer.parseInt(f) / Integer.parseInt(sec)
    if (op == "")
        a = temp.toString()
    else b = temp.toString()
    f = ""
    sec = ""
    temp = 0
    brac = ""
}

object Global {
    var text by mutableStateOf("0")
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    CalculatorTheme {
//        Greeting("Android")
//    }
//}