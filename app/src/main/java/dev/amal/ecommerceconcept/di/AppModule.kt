package dev.amal.ecommerceconcept.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.amal.ecommerceconcept.common.Constants
import dev.amal.ecommerceconcept.data.remote.StoreApi
import dev.amal.ecommerceconcept.data.repository.StoreRepositoryImpl
import dev.amal.ecommerceconcept.domain.repository.StoreRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideStoreApi(): StoreApi = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(StoreApi::class.java)

    @Provides
    @Singleton
    fun provideStoreRepository(
        api: StoreApi
    ): StoreRepository = StoreRepositoryImpl(api)

}