package com.example.jetpack_compose_ui_exercises.exercise03

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


data class Transaction(
    val id: String,
    val title: String,
    val amount: String,
    val isIncome: Boolean,
    val icon: ImageVector

)

@Composable
fun Exercise03BankHomeScreen(
    balance: String = "$1,250.00",
   transactions: List<Transaction> = sampleTransactions(),


){
    val brandGreen = Color(0xFF0F8A4A)


    Scaffold(
        modifier = Modifier.fillMaxSize(), containerColor = Color.White,

        floatingActionButton = {
            FloatingActionButton(
                onClick = {  },
                containerColor = brandGreen,
                contentColor = Color.White,
                shape = CircleShape,
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add transaction")
            }
        },

        floatingActionButtonPosition = FabPosition.End,
        bottomBar = {
            BottomNavigationBar(
                selected = "home",
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 24.dp, vertical = 16.dp).background(Color.White)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.White)
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(76.dp)
                            .background(brandGreen),
                        contentAlignment = Alignment.TopEnd
                    ) {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = "Profile",
                            tint = Color.White.copy(alpha = 0.6f),
                            modifier = Modifier
                                .size(60.dp)
                                .padding(end = 12.dp, top = 8.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
                        Text(
                            text = "Bank",
                            fontSize = 34.sp,
                            fontWeight = FontWeight.SemiBold
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = balance,
                            fontSize = 34.sp,
                            fontWeight = FontWeight.ExtraBold
                        )

                        Text(
                            text = "Available balance",
                            color = Color.Gray,
                            fontSize = 16.sp,
                        )

                        Spacer(modifier = Modifier.height(12.dp))


                        Button(
                            onClick = { },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(48.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = brandGreen),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Text(text = "Transfer money", color = Color.White, fontSize = 18.sp)
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Recent transactions",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(start = 4.dp, bottom = 8.dp)
            )


            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                transactions.forEach { tx ->
                    TransactionCard(tx = tx)
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }
    }
}


@Composable
fun TransactionCard(tx: Transaction){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = Color(0xFFDDDDDD),
                shape = RoundedCornerShape(12.dp)
            ),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        )
    ) {
        Row(
            modifier = Modifier
                .padding(14.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Box(
                modifier = Modifier
                    .size(32.dp)
                    .clip(RoundedCornerShape(10.dp)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier.fillMaxSize(),
                    imageVector = tx.icon,
                    contentDescription = null,
                    tint = Color(0xFF0F8A4A)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(text = tx.title, fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
            }


            Text(
                text = buildAnnotatedString {
                    val text = tx.amount

                    if (tx.isIncome && text.isNotEmpty()) {

                        append(
                            AnnotatedString(
                                text.first().toString(),
                                spanStyle = SpanStyle(color = Color(0xFF0F8A4A))
                            )
                        )

                        append(text.drop(1))
                    } else {
                        append(text)
                    }
                },
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black,
                    fontSize = 18.sp
                )
            )
        }

    }


}



@Composable
fun BottomNavigationBar(selected: String){
    NavigationBar(modifier = Modifier.border(width = 1.dp,
        color = Color(0xFFDDDDDD)),
        containerColor = Color.White
    ) {
        NavigationBarItem(
            onClick = {/*TODO*/},
            label = { Text("Home")},
            icon = {Icon(Icons.Default.Home,contentDescription = "home")},
            selected = selected == "home",
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color(0xFF0F8A4A),
                unselectedIconColor = Color.Gray,
                selectedTextColor = Color(0xFF0F8A4A),
                unselectedTextColor = Color.Gray,
                indicatorColor = Color.Transparent
            )
        )
        NavigationBarItem(
            selected = selected == "cards",
            onClick = { /*TODO*/ },
            icon = { Icon(Icons.Default.Menu, contentDescription = "Cards") },
            label = { Text("Cards") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color(0xFF0F8A4A),
                unselectedIconColor = Color.Gray,
                selectedTextColor = Color(0xFF0F8A4A),
                unselectedTextColor = Color.Gray,
                indicatorColor = Color.Transparent
            )
        )
        NavigationBarItem(
            selected = selected == "stats",
            onClick = { /*TODO*/ },
            icon = { Icon(Icons.Default.MoreVert, contentDescription = "Stats") },
            label = { Text("Stats") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color(0xFF0F8A4A),
                unselectedIconColor = Color.Gray,
                selectedTextColor = Color(0xFF0F8A4A),
                unselectedTextColor = Color.Gray,
                indicatorColor = Color.Transparent
            )
        )

    }
}

fun sampleTransactions(): List<Transaction> = listOf(
    Transaction(
        id = "1",
        title = "Groceries",
        amount = "-$52.35",
        isIncome = false,
        icon = Icons.Default.ShoppingCart
    ),
    Transaction(
        id = "2",
        title = "Rent",
        amount = "-$850.00",
        isIncome = false,
        icon = Icons.Default.Home
    ),
    Transaction(
        id = "3",
        title = "Salary",
        amount = "+$1,500.00",
        isIncome = true,
        icon = Icons.Default.Add
    )
)




@Preview
@Composable
fun BankHomePreview(){
    MaterialTheme {
        Exercise03BankHomeScreen()
    }
}