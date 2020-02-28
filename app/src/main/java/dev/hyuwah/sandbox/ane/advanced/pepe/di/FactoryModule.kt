package dev.hyuwah.sandbox.ane.advanced.pepe.di

import dagger.Module
import dagger.Provides
import dev.hyuwah.sandbox.ane.advanced.pepe.data.ExampleServiceApi
import dev.hyuwah.sandbox.ane.advanced.pepe.domain.ExampleFactory
import dev.hyuwah.sandbox.ane.advanced.pepe.domain.ExampleFactoryImpl
import javax.inject.Singleton

@Module
class FactoryModule {

    @Singleton
    @Provides
    fun provideExampleFactory(exampleServiceApi: ExampleServiceApi): ExampleFactory {
        return ExampleFactoryImpl(exampleServiceApi)
    }

}