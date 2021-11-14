package fr.dappli.weathercomposesample.repo.geogouv.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import fr.dappli.weathercomposesample.repo.geogouv.GeoGouvRepository
import fr.dappli.weathercomposesample.repo.geogouv.GeoGouvRepositoryImpl

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class GeoGouvRepositoryModule {

    @Binds
    abstract fun bindGeoGouvRepository(repositoryImpl: GeoGouvRepositoryImpl): GeoGouvRepository
}
