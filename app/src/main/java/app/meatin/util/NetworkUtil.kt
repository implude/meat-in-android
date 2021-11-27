package app.meatin.util

import retrofit2.Call

fun <T> launch(call: Call<T>): Result<T> = try {
    call.execute().let {
        if (it.isSuccessful) {
            Result.success(it.body()!!)
        } else {
            Result.failure(IllegalStateException(it.errorBody()!!.string()))
        }
    }
} catch (e: Exception) {
    Result.failure(e)
}
