package com.salehtz.fillterapp.dependencyinjection

import com.salehtz.fillterapp.repositories.EditImageRepository
import com.salehtz.fillterapp.repositories.EditImageRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {
    factory<EditImageRepository> { EditImageRepositoryImpl(androidContext()) }
}