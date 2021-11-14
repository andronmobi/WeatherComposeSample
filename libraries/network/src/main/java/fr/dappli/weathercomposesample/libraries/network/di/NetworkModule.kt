package fr.dappli.weathercomposesample.libraries.network.di

import android.content.Context
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import fr.dappli.weathercomposesample.libraries.network.AuthorizationInterceptor
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideHttpCache(
        @ApplicationContext context: Context
    ) = Cache(File(context.cacheDir, CACHE_DIRECTORY), CACHE_SIZE.toLong())

    @Provides
    @OpenWeatherOkHttpClient
    fun provideOpenWeatherOkHttpClient(
        cache: Cache,
        autorizationInterceptor: AuthorizationInterceptor
    ): OkHttpClient = OkHttpClient.Builder()
        .addNetworkInterceptor(autorizationInterceptor)
        .cache(cache)
        .build()

    @Provides
    @OpenWeatherRetrofit
    fun provideOpenWeatherRetrofit(
        gson: Gson,
        @OpenWeatherOkHttpClient okHttpClient: OkHttpClient
    ): Retrofit = Retrofit.Builder()
        .baseUrl("http://api.openweathermap.org") // TODO move the url to config class
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(okHttpClient)
        .build()

    @Provides
    @GeoGouvOkHttpClient
    fun provideGeoGouvOkHttpClient(
        cache: Cache
    ): OkHttpClient = OkHttpClient.Builder()
        .cache(cache)
        .build()

    @Provides
    @GeoGouvRetrofit
    fun provideGeoGouvRetrofit(
        gson: Gson,
        @GeoGouvOkHttpClient okHttpClient: OkHttpClient
    ): Retrofit = Retrofit.Builder()
        .baseUrl("http://api-adresse.data.gouv.fr") // TODO move the url to config class
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(okHttpClient)
        .build()

    private const val CACHE_DIRECTORY = "HttpResponseCache"
    private const val CACHE_SIZE = 10 * 1024 * 1024
}
