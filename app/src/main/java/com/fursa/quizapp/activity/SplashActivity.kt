package com.fursa.quizapp.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.fursa.quizapp.R
import com.fursa.quizapp.utilities.ActivityUtilities

const val SPLASH_SCREEN_DURATION = 3000L

class SplashActivity : AppCompatActivity() {
    private lateinit var imageAppIcon: ImageView
    private lateinit var tvAppName: TextView
    private lateinit var tvAppQuote: TextView
    private lateinit var progressBar: ProgressBar
    private lateinit var constraintLayout: ConstraintLayout

    private lateinit var animation: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        imageAppIcon = findViewById(R.id.ivSplashIcon)
        tvAppName = findViewById(R.id.tvAppName)
        tvAppQuote = findViewById(R.id.tvAppDescription)
        progressBar = findViewById(R.id.progressBar)
        constraintLayout = findViewById(R.id.constraintLayout)

        animation = AnimationUtils.loadAnimation(this@SplashActivity, R.anim.rotate)
    }

    override fun onResume() {
        super.onResume()
        initProgressBar()
    }

    private fun initProgressBar() {
       constraintLayout.postDelayed({
            progressBar.visibility = View.GONE
            imageAppIcon.startAnimation(animation)
            animation.setAnimationListener(object : Animation.AnimationListener{
                override fun onAnimationRepeat(animation: Animation?) {
                    Toast.makeText(this@SplashActivity, "Repeat", Toast.LENGTH_LONG).show()
                }

                override fun onAnimationEnd(animation: Animation?) {
                    ActivityUtilities
                        .getInstance()
                        .invokeNewActivity(
                            this@SplashActivity,
                            MainActivity::class.java,
                            true)
                }

                override fun onAnimationStart(animation: Animation?) {
                    Toast.makeText(this@SplashActivity, "Start", Toast.LENGTH_LONG).show()
                }

            })
       }, SPLASH_SCREEN_DURATION)
    }
}
