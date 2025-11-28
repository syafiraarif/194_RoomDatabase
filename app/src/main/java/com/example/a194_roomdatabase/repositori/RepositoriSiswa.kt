package com.example.a194_roomdatabase.repositori

import com.example.a194_roomdatabase.room.Siswa
import com.example.a194_roomdatabase.room.SiswaDao
import kotlinx.coroutines.flow.Flow

interface RepositoriSiswa {
    fun getAllSiswaStream(): Flow<List<Siswa>>

    suspend fun insertSiswa(siswa:Siswa)
}

