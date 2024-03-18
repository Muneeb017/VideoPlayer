package com.muneeb.videoplayer.ui.activity.navViewActivitys

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.muneeb.videoplayer.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.aboutTextName.text = "Developed By:  Muneeb Khalid"

        binding.aboutText.text =
            "Welcome to our video player app,\n" + "\n" + "We are thrilled to introduce you to our cutting-edge video player application, designed to provide you with the ultimate viewing experience. Whether you're streaming your favorite movies, binge-watching TV shows, or simply catching up on viral videos, our video player has you covered.\n" + "\n" + "Our app is equipped with an array of features to enhance your viewing pleasure. From seamless playback to customizable settings, we've thought of everything to ensure that you can enjoy your content exactly the way you want.\n" + "\n" + "But we didn't stop there. We understand that feedback is crucial to improving our app and tailoring it to your needs. That's why we welcome any suggestions or comments you may have. Your input helps us continue to innovate and refine our product.\n" + "\n" + "So go ahead, dive into your favorite videos with our video player app. And remember, we're here to make your viewing experience as enjoyable as possible. If you have any feedback or suggestions, feel free to reach out to us at support  muneebkhalid0017@gmail.com.\n" + "\n" + "Thank you for choosing our app!"
    }

}