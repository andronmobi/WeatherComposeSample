package fr.dappli.weathercomposesample.libraries.network

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthorizationInterceptor @Inject constructor(): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request= chain.request()
        val url = chain.request().url.newBuilder()
            .addQueryParameter(KEY_NAME, "32dd964e957faa8cb8a7f3b082e2deff") // TODO use resources
            .build()

        val requestWithKey = request.newBuilder().url(url).build()
        return chain.proceed(requestWithKey)
    }

    private companion object {
        const val KEY_NAME = "APPID"
    }
}
