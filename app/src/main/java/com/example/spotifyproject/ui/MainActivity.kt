package com.example.spotifyproject.ui

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.spotifyproject.R
import com.example.utils.Constants
import com.spotify.android.appremote.api.ConnectionParams
import com.spotify.android.appremote.api.Connector
import com.spotify.android.appremote.api.SpotifyAppRemote
import com.spotify.android.appremote.api.error.CouldNotFindSpotifyApp
import com.spotify.protocol.types.PlayerState
import com.spotify.protocol.types.Track
import dagger.android.AndroidInjection


class MainActivity : AppCompatActivity() {

    companion object {
        private const val clientId = Constants.clientId
        private const val redirectedUrl = Constants.redirectedUrl

    }

    private var mSpotifyAppRemote: SpotifyAppRemote? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.apply {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            statusBarColor = Color.TRANSPARENT
        }
    }

    override fun onStart() {
        super.onStart()
        val connectionParams = ConnectionParams.Builder(clientId)
            .setRedirectUri(redirectedUrl)
            .showAuthView(true)
            .build()
        try {
            SpotifyAppRemote.connect(this, connectionParams,
                object : Connector.ConnectionListener {
                    override fun onConnected(spotifyAppRemote: SpotifyAppRemote) {
                        mSpotifyAppRemote = spotifyAppRemote
                        Log.d("MainActivity", "Connected! Yay!")

                        // Now you can start interacting with App Remote
                        connected()
                    }

                    override fun onFailure(throwable: Throwable) {
                        Log.e("MyActivity", "Error" + throwable.message, throwable)
                        // Something went wrong when attempting to connect! Handle errors here
                    }
                })
        } catch (e: CouldNotFindSpotifyApp) {
            Toast.makeText(this, "Please download spotify app", Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }

    }

    private fun connected() {
        // Play a playlist
        mSpotifyAppRemote!!.playerApi.play("spotify:playlist:37i9dQZF1DX2sUQwD7tbmL")

        // Subscribe to PlayerState

        // Subscribe to PlayerState
        mSpotifyAppRemote!!.playerApi
            .subscribeToPlayerState()
            .setEventCallback { playerState: PlayerState ->
                val track: Track? = playerState.track
                if (track != null) {
                    Log.d("MainActivity", track.name.toString() + " by " + track.artist.name)
                }
            }
    }

    override fun onStop() {
        super.onStop()
        SpotifyAppRemote.disconnect(mSpotifyAppRemote)
    }

}