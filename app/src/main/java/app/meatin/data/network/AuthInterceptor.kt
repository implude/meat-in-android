package app.meatin.data.network

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest: Request = chain.request().newBuilder().apply {
            if (AuthenticationStore.token != null) {
                addHeader("Authorization", "Bearer ${AuthenticationStore.token!!.accessToken}")
            }
        }.build()

        return chain.proceed(newRequest)
    }
}
