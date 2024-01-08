package com.salehtz.fillterapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.salehtz.fillterapp.R
import com.salehtz.fillterapp.data.ImageFilter
import com.salehtz.fillterapp.databinding.ItemContainerFilterBinding
import com.salehtz.fillterapp.listeners.ImageFilterListener

class ImageFiltersAdapter(
    private val imageFilters: List<ImageFilter>,
    private val imageFilterListener: ImageFilterListener
) :
    RecyclerView.Adapter<ImageFiltersAdapter.ImageFilterViewHolder>() {


    private var selectedImagePosition = 0
    private var previousSelectedPosition = 0


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageFilterViewHolder {
        val binding = ItemContainerFilterBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ImageFilterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageFilterViewHolder, position: Int) {
        with(holder) {
            with(imageFilters[position]) {
                binding.imageFilterPreview.setImageBitmap(filterPreview)
                binding.textFilterName.text = name
                binding.root.setOnClickListener {
                    if (selectedImagePosition != position) {
                        imageFilterListener.onFilterSelected(this)
                        previousSelectedPosition = selectedImagePosition
                        selectedImagePosition = position
                        with(this@ImageFiltersAdapter)
                        {
                            notifyItemChanged(previousSelectedPosition, Unit)
                            notifyItemChanged(selectedImagePosition, Unit)
                        }

                    }
                }
            }
            binding.textFilterName.setTextColor(
                ContextCompat.getColor(
                    binding.textFilterName.context,
                    if (selectedImagePosition == position)
                        R.color.primaryDark
                    else
                        R.color.primaryText
                )
            )
        }
    }

    override fun getItemCount() = imageFilters.size


    inner class ImageFilterViewHolder(val binding: ItemContainerFilterBinding) :
        RecyclerView.ViewHolder(binding.root)

}