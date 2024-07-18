package com.example.api_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView

class video_set : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_set)

        val video = findViewById<VideoView>(R.id.video)
        video.setVideoPath("android.resource://" + packageName + "/" + R.raw.video)
        val med= MediaController(this)

        video.setMediaController(med);
        med.setAnchorView(video);
        video.start();
    }
}