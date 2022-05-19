package dev.carlesav.tasklist.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.carlesav.tasklist.data.database.dao.TasksDao
import dev.carlesav.tasklist.data.repository.TasksRepositoryImpl
import dev.carlesav.tasklist.domain.repository.TasksRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideTasksRepository(
        dao: TasksDao,
    ): TasksRepository = TasksRepositoryImpl(
        dao = dao
    )
}