package dev.amal.feature_product_details.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.amal.core.utils.Constants
import dev.amal.feature_product_details.data.remote.ProductDetailsApi
import dev.amal.feature_product_details.data.repository.ProductDetailsRepositoryImpl
import dev.amal.feature_product_details.domain.repository.ProductDetailsRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProductDetailsModule {

    @Provides
    @Singleton
    fun provideProductDetailsApi(): ProductDetailsApi = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ProductDetailsApi::class.java)

    @Provides
    @Singleton
    fun provideStoreRepository(
        api: ProductDetailsApi
    ): ProductDetailsRepository = ProductDetailsRepositoryImpl(api)

}