package com.salehtz.fillterapp.dependencyinjection

import com.salehtz.fillterapp.repositories.EditImageRepository
import com.salehtz.fillterapp.viewmodels.EditImageViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { EditImageViewModel(editImageRepository = get()) }
}