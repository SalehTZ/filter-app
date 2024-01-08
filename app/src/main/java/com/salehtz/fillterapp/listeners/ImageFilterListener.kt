package com.salehtz.fillterapp.listeners

import com.salehtz.fillterapp.data.ImageFilter

interface ImageFilterListener {
    fun onFilterSelected(imageFilter: ImageFilter)
}