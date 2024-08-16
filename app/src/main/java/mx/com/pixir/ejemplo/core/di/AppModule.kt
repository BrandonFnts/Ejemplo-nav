package mx.com.pixir.ejemplo.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mx.com.pixir.ejemplo.data.repository.example.ExampleRepository
import mx.com.pixir.ejemplo.domain.usecase.example.ExampleUseCases
import mx.com.pixir.ejemplo.domain.usecase.example.GetExample
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideExampleUseCases(exampleRepository: ExampleRepository) = ExampleUseCases(
        getExample = GetExample(exampleRepository)
    )

}