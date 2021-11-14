package fr.dappli.weathercomposesample.repo.geogouv.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import fr.dappli.weathercomposesample.libraries.network.di.GeoGouvRetrofit
import fr.dappli.weathercomposesample.repo.geogouv.GeoGouvApiService
import retrofit2.Retrofit

@Module
@InstallIn(ActivityRetainedComponent::class)
object GeoGouvApiServiceModule {

    @Provides
    fun provideGeoGouvApiService(
        @GeoGouvRetrofit retrofit: Retrofit
    ): GeoGouvApiService = retrofit.create(GeoGouvApiService::class.java)
}
