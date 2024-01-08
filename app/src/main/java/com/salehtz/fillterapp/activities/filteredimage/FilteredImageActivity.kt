package com.salehtz.fillterapp.activities.filteredimage

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.salehtz.fillterapp.R
import com.salehtz.fillterapp.activities.editimage.EditImageActivity
import com.salehtz.fillterapp.databinding.ActivityFilteredImageBinding

class FilteredImageActivity : AppCompatActivity() {

    private lateinit var fileUri: Uri
    private lateinit var binding: ActivityFilteredImageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilteredImageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        displayFilteredImage()
        setListeners()
    }

    // Display final Image
    private fun displayFilteredImage() {
        intent.getParcelableExtra<Uri>(EditImageActivity.KEY_FILTERED_IMAGE_URI)?.let { imageUri ->
            fileUri = imageUri
            binding.filteredImagePreview.setImageURI(imageUri)
        }
    }

    private fun setListeners() {
        // Share button listener
        binding.fabShare.setOnClickListener {
            with(Intent(Intent.ACTION_SEND)) {
                putExtra(Intent.EXTRA_STREAM, fileUri)
                addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                type = "image/*"
                startActivity(this)
            }
        }
    }
}