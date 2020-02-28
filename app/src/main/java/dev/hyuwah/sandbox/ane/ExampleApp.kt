package dev.hyuwah.sandbox.ane

import android.app.Application
import dev.hyuwah.sandbox.ane.advanced.pepe.di.AppComponent
import dev.hyuwah.sandbox.ane.advanced.pepe.di.DaggerAppComponent

class ExampleApp : Application() {

    companion object {
        fun getDaggerComponent(): AppComponent = DaggerAppComponent.create()
    }

    override fun onCreate() {
        super.onCreate()

    }

}