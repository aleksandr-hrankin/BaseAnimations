package ua.antibyte.baseanimations

import android.animation.AnimatorInflater
import android.animation.ObjectAnimator
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideSystemProgressBar()
        setContentView(R.layout.activity_main)

        startAnimation(police_car_image_view, R.animator.police_car_animation)
        startAnimation(helicopter_image_view, R.animator.helicopter_animation)
        startAnimation(cloud_image_view, R.animator.cloud_animation)
        startAnimation(sun_image_view, R.animator.sun_animation)
        startAnimation(billboard_1_image_view, R.animator.billboard_1_animation)
        startAnimation(billboard_2_text_view, R.animator.billboard_2_animation)
        startAnimation(billboard_3_text_view, R.animator.billboard_3_animation)
    }

    private fun startAnimation(view: View, resId: Int) {
        val anim = AnimatorInflater.loadAnimator(this, resId) as ObjectAnimator
        anim.apply {
            target = view
            start()
        }
    }

    private fun hideSystemProgressBar() {
        hideSystemUI();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            window.attributes.layoutInDisplayCutoutMode =
                WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
        }
    }

    private fun hideSystemUI() {
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LOW_PROFILE
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_IMMERSIVE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
    }
}