package dev.amal.feature_home_store.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.amal.core.utils.Constants
import dev.amal.feature_home_store.data.remote.AllProductsApi
import dev.amal.feature_home_store.data.repository.AllProductsRepositoryImpl
import dev.amal.feature_home_store.domain.repository.AllProductsRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AllProductsModule {

    @Provides
    @Singleton
    fun provideProductDetailsApi(): AllProductsApi = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(AllProductsApi::class.java)

    @Provides
    @Singleton
    fun provideStoreRepository(
        api: AllProductsApi
    ): AllProductsRepository = AllProductsRepositoryImpl(api)

}