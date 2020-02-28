package dev.hyuwah.sandbox.ane.advanced.pepe.di

import dagger.Module
import dagger.Provides
import dev.hyuwah.sandbox.ane.advanced.pepe.data.ExampleServiceApi
import dev.hyuwah.sandbox.ane.advanced.pepe.data.ExampleServiceApiImpl
import javax.inject.Singleton

@Module
class ServiceModule {

    @Singleton
    @Provides
    fun provideExampleServiceApi(): ExampleServiceApi {
        return ExampleServiceApiImpl()
    }

}