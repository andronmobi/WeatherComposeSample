package fr.dappli.weathercomposesample.libraries.network.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import java.io.File

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Reusable
    fun provideHttpCache(
        @ApplicationContext context: Context
    ) = Cache(File(context.cacheDir, CACHE_DIRECTORY), CACHE_SIZE.toLong())

    private const val CACHE_DIRECTORY = "HttpResponseCache"
    private const val CACHE_SIZE = 10 * 1024 * 1024
}
