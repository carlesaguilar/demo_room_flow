package dev.carlesav.tasklist.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.carlesav.tasklist.data.TasksDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    private const val TASKS_DATABASE_NAME = "tasks_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, TasksDatabase::class.java, TASKS_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideTasksDao(db: TasksDatabase) = db.getTasksDao()
}