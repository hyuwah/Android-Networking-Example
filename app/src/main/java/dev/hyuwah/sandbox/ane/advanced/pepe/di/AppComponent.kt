package dev.hyuwah.sandbox.ane.advanced.pepe.di

import dagger.Component
import dev.hyuwah.sandbox.ane.advanced.pepe.presentation.ExamplePresenter
import javax.inject.Singleton

@Singleton
@Component(modules = [FactoryModule::class, ServiceModule::class])
interface AppComponent {

    fun inject(examplePresenter: ExamplePresenter)

}