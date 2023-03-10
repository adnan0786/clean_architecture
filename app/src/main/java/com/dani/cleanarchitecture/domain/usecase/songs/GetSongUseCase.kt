package com.dani.cleanarchitecture.domain.usecase.songs

import androidx.appcompat.app.AppCompatActivity
import com.dani.cleanarchitecture.domain.model.Song
import com.dani.cleanarchitecture.domain.repository.SongRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetSongUseCase @Inject constructor(
    private val songRepository: SongRepository
) {

    suspend operator fun invoke(activity: AppCompatActivity): Flow<List<Song>> {
        songRepository.getAllDeviceSongs(activity)
        return songRepository.getDBSongs().map { it.map { songEntity -> songEntity.toSong() } }
    }
}