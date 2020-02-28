package dev.hyuwah.sandbox.ane.common

import android.app.Activity
import android.content.Intent

inline fun <reified T : Activity> Activity.start() {
    startActivity(Intent(this, T::class.java))
}