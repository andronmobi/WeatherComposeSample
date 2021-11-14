package fr.dappli.weathercomposesample.libraries.network.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class GeoGouvRetrofit

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class GeoGouvOkHttpClient

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class OpenWeatherRetrofit

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class OpenWeatherOkHttpClient
