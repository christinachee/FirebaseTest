package com.example.firebasetest.di

import com.example.firebasetest.data.Repository
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun provideDatabase() = Firebase.firestore

    @Singleton
    @Provides
    fun provideRepository(remoteDatabase: FirebaseFirestore) = Repository(remoteDatabase)
}