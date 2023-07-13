package com.example.fashionday.di

import com.example.fashionday.data.repository.PlaceRepository
import com.example.fashionday.data.repository.PlaceRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface PlaceModule {

    @Singleton
    @Binds
    fun bindPlaceRepository(repository: PlaceRepositoryImpl): PlaceRepository

}