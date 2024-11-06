package com.example.recyclerview_grid

import Image
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recyclerview_grid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val adapterDisaster = ImageAdapter(generateDataDummy()){
                image ->
            Toast.makeText(this@MainActivity, "Source image: ${image.imgSource}", Toast.LENGTH_SHORT).show()
        }
        with(binding){
            rvImages.apply {
                adapter = adapterDisaster
                layoutManager = GridLayoutManager(this@MainActivity, 3)
            }
        }
    }

    fun generateDataDummy(): List<Image> {
        return listOf(
            Image(imgSource = "https://www.rwongphoto.com/images/xl/RW6955-2_web.jpg"),
            Image(imgSource = "https://composeclick.com/wp-content/uploads/2018/05/nature-1.jpg"),
            Image(imgSource = "https://www.maxfosterphotography.com/images/xl/Rise-Above.jpg"),
            Image(imgSource = "https://www.cartoonize.net/wp-content/uploads/2022/01/nature-photography.jpg"),
            Image(imgSource = "https://images.squarespace-cdn.com/content/v1/56bf55504c2f85a60a9b9fe5/1456362861375-B3ABTH337NGBFYQBUCUZ/image-asset.jpeg"),
            Image(imgSource = "https://upload.wikimedia.org/wikipedia/commons/c/c8/Altja_j%C3%B5gi_Lahemaal.jpg"),
            Image(imgSource = "https://www.lancasterconservancy.org/wp-content/uploads/2023/08/16019-0P1A6455-1-1024x683.jpg"),
            Image(imgSource = "https://silverlight.store/posts/wp-content/uploads/2023/11/jasper-boer-1fUu0dratoM-unsplash-scaled-1.jpg"),
            Image(imgSource = "https://www.lancasterconservancy.org/wp-content/uploads/2023/08/Kerry-Givens-Little-Brown-Mushrooms-Fern-Cliff-Nature-Preserve-Lancaster-County-PA-1024x683.jpg"),
        )
    }
}