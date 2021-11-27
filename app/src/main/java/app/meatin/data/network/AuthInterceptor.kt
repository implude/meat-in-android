package app.meatin.data.network

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import okio.Buffer

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest: Request = chain.request().newBuilder().apply {
            if (AuthenticationStore.token != null) {
                addHeader("Authorization", "Bearer ${AuthenticationStore.token!!.accessToken}")
            }
        }.build()

        val sink = Buffer()
        newRequest.url().let(::println)
        newRequest.body()?.writeTo(sink)
        sink.readString(Charsets.UTF_8).let(::println)

        return chain.proceed(newRequest)
    }
}
