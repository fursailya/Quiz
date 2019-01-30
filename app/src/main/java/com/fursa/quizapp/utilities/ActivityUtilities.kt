package com.fursa.quizapp.utilities

import android.app.Activity
import android.content.Intent

class ActivityUtilities {

    companion object {
        private var instance: ActivityUtilities? = null

        fun getInstance(): ActivityUtilities {
            if(instance == null) {
                instance = ActivityUtilities()
            }

            return instance as ActivityUtilities
        }
    }

    fun invokeNewActivity(activity: Activity, tClass: Class<*>, shouldFinish: Boolean) {
        val intent = Intent(activity, tClass)
        activity.startActivity(intent)

        if(shouldFinish) {
            activity.finish()
        }
    }
}