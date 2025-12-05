package com.example.a194_roomdatabase.view.route

import com.example.a194_roomdatabase.R

object DestinasiDetailSiswa {
    override val route = "detail_siswa"
    override val titleRes = R.string.detail_siswa
    const val itemIdArg = "idSiswa"
    val routeWithArgs = "$route/{$itemIdArg}"
}