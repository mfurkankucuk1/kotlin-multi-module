package tr.mfk.networkmodule.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import tr.mfk.common.Constants.DATABASE_NAME
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): NoteDatabase {

        val dbBuilder = Room.databaseBuilder(
            context, NoteDatabase::class.java, DATABASE_NAME
        )
        return dbBuilder.allowMainThreadQueries().build()
    }

    @Singleton
    @Provides
    fun provideNoteDao(appDatabase: NoteDatabase): NoteDao {
        return appDatabase.getNoteDao()
    }
}