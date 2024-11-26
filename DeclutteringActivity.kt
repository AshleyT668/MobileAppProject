
package com.clutterfreeapp

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.clutterfreeapp.databinding.ActivityDeclutteringBinding

class DeclutteringActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDeclutteringBinding
    private val PICK_IMAGE_REQUEST = 1
    private var imageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeclutteringBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Handle category selection
        binding.spinnerServiceCategory.setOnItemSelectedListener { _, _, position, _ ->
            val category = resources.getStringArray(R.array.service_categories)[position]
            Toast.makeText(this, "Selected: $category", Toast.LENGTH_SHORT).show()
        }

        // Handle image upload
        binding.btnUploadImage.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            startActivityForResult(intent, PICK_IMAGE_REQUEST)
        }

        // Confirm booking
        binding.btnConfirmDecluttering.setOnClickListener {
            val category = binding.spinnerServiceCategory.selectedItem.toString()
            val rooms = binding.etRooms.text.toString()
            val description = binding.etDescription.text.toString()

            if (category.isNotEmpty() && rooms.isNotEmpty() && description.isNotEmpty()) {
                Toast.makeText(this, "Decluttering request confirmed!", Toast.LENGTH_LONG).show()
                // Proceed to save booking or send to backend
            } else {
                Toast.makeText(this, "Please fill in all details.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK) {
            imageUri = data?.data
            binding.imgPreview.setImageURI(imageUri)
        }
    }
}
