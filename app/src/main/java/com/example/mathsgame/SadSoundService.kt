package com.example.mathsgame

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder


class SadSoundService : Service() {
    var player: MediaPlayer? = null
    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onCreate() {
        player = MediaPlayer.create(this, R.raw.sad) //select music file
        player!!.isLooping = true //set looping
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        player!!.start()
        return START_NOT_STICKY
    }

    override fun onDestroy() {
        player!!.stop()
        player!!.release()
        stopSelf()
        super.onDestroy()
    }
}