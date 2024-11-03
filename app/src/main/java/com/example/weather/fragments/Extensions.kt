package com.example.weather.fragments

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

fun Fragment.isPermissionGranted(permission: String): Boolean {
    return ContextCompat.checkSelfPermission( //передает digit, а не boolean
        activity as AppCompatActivity, permission) == PackageManager.PERMISSION_GRANTED
}