package tw.edu.pu.csim.s1131633.firebase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import tw.edu.pu.csim.s1131633.firebase.ui.theme.FirebaseTheme
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.ui.text.input.KeyboardType

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirebaseTheme {
                UserScoreScreen()
            }
        }
    }
}
@Composable
fun UserScoreScreen( userScoreViewModel: UserScoreViewModel = viewModel()
) {
    var user by remember { mutableStateOf("") }
    var score by remember { mutableStateOf("") }

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TextField(
            value = user,
            onValueChange = { user = it },
            label = { Text("姓名") },
            placeholder = { Text("請輸入您的姓名") }
        )
        Text("您輸入的姓名是：$user")
        Spacer(modifier = Modifier.size(10.dp))

        OutlinedTextField(
            value = score,
            onValueChange = { score = it },
            label = { Text("分數") },
            placeholder = { Text("請輸入您的分數") },
            keyboardOptions = KeyboardOptions
                (keyboardType = KeyboardType.Number)
        )
        Text("您的分數是：$score")
        Spacer(modifier = Modifier.size(10.dp))


        Button(onClick = {
            // 在按鈕點擊時，直接呼叫 ViewModel 的函式
            var userScore = UserScoreModel("子青", 39)
            userScoreViewModel.addUser(userScore)
        }) {
            Text("新增資料")
        }

        Button(onClick = {
            // 在按鈕點擊時，直接呼叫 ViewModel 的函式
            var userScore = UserScoreModel("子青", 21)
            userScoreViewModel.updateUser(userScore)
        }) {
            Text("新增/異動資料")
        }

        Button(onClick = {
            // 在按鈕點擊時，直接呼叫 ViewModel 的函式
            var userScore = UserScoreModel("子青", 21)
            userScoreViewModel.deleteUser(userScore)
        }) {
            Text("刪除資料")
        }
        Button(onClick = {
            // 在按鈕點擊時，直接呼叫 ViewModel 的函式
            var userScore = UserScoreModel("子青", 21)
            userScoreViewModel.getUser(userScore)
        }) {
            Text("查詢資料")
        }

        Button(onClick = {
            // 在按鈕點擊時，直接呼叫 ViewModel 的函式
            var userScore = UserScoreModel("子青", 21)
            userScoreViewModel.deleteUser(userScore)
        }) {
            Text("刪除資料")
        }

        Text(userScoreViewModel.message)
    }
}
