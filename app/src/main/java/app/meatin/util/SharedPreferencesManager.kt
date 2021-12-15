package app.meatin.util

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys

class SharedPreferencesManager(val context: Context) {

    private val sharedPreferences = createEncryptedSharedPreferences()

    var loginEmail: String?
        get() = sharedPreferences.getString(KEY_EMAIL, null)
        set(value) = sharedPreferences.edit {
            putString(KEY_EMAIL, value)
        }

    var loginPassword: String?
        get() = sharedPreferences.getString(KEY_PASSWORD, null)
        set(value) = sharedPreferences.edit {
            putString(KEY_PASSWORD, value)
        }

    private fun createEncryptedSharedPreferences(): SharedPreferences {
        val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)

        return EncryptedSharedPreferences.create(
            "app_preferences",
            masterKeyAlias,
            context,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

    fun applyCredentials(email: String, password: String) {
        loginEmail = email
        loginPassword = password
    }

    companion object {
        const val KEY_EMAIL = "email"
        const val KEY_PASSWORD = "password"
    }
}
