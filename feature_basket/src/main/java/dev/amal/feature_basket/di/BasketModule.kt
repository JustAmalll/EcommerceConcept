package dev.amal.feature_basket.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.amal.core.utils.Constants
import dev.amal.feature_basket.data.remote.BasketApi
import dev.amal.feature_basket.data.repository.BasketRepositoryImpl
import dev.amal.feature_basket.domain.repository.BasketRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BasketModule {

    @Provides
    @Singleton
    fun provideProductDetailsApi(): BasketApi = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(BasketApi::class.java)

    @Provides
    @Singleton
    fun provideStoreRepository(
        api: BasketApi
    ): BasketRepository = BasketRepositoryImpl(api)

}