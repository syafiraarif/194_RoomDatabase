package com.example.a194_roomdatabase.view.uicontroller

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.a194_roomdatabase.view.DetailDataSiswa
import com.example.a194_roomdatabase.view.DetailSiswaScreen
import com.example.a194_roomdatabase.view.EditSiswaScreen
import com.example.a194_roomdatabase.view.EntrySiswaScreen
import com.example.a194_roomdatabase.view.HomeScreen
import com.example.a194_roomdatabase.view.route.DestinasiDetailSiswa
import com.example.a194_roomdatabase.view.route.DestinasiDetailSiswa.itemIdArg
import com.example.a194_roomdatabase.view.route.DestinasiEditSiswa
import com.example.a194_roomdatabase.view.route.DestinasiHome
import com.example.a194_roomdatabase.view.route.DestinasiEntry

@Composable
fun SiswaApp(navController: NavHostController= rememberNavController(), modifier: Modifier){
    HostNavigasi(navController = navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    NavHost(navController=navController, startDestination = DestinasiHome.route, modifier = Modifier)
    {
        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = { navController.navigate(DestinasiEntry.route) },
                navigateToItemUpdate = { navController.navigate("${DestinasiDetailSiswa.route}/${it}") },
                navigateBack = { navController.popBackStack() }
            )
        }
        composable(DestinasiEntry.route) {
            EntrySiswaScreen(navigateBack = { navController.popBackStack() })
        }

        composable(
            route = DestinasiDetailSiswa.routeWithArgs,
            arguments = listOf(navArgument(DestinasiDetailSiswa.itemIdArg) {
                type = NavType.IntType
            })
        ) {
            DetailSiswaScreen(

                navigateToEditItem = { navController.navigate("${DestinasiEditSiswa.route}/$it") },

                navigateBack = { navController.navigateUp() }
            )
        }

        composable(
            route = DestinasiEditSiswa.routeWithArgs,
            arguments = listOf(
                navArgument(itemIdArg) {
                    type = NavType.IntType
                    defaultValue = -1 // Pilihan: Menambahkan defaultValue untuk keamanan
                }
            )
        ) { backStackEntry -> // backStackEntry diperlukan jika Anda ingin mengakses argumen secara langsung di sini
            EditSiswaScreen(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() }
                // Anda mungkin perlu meneruskan argumen ke EditSiswaScreen
                // itemId = backStackEntry.arguments?.getInt(itemIdArg) ?: -1
            )
        }
    }
}