package com.example.weather.fragments

import android.Manifest
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.weather.R
import com.example.weather.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var pLauncher: ActivityResultLauncher<String> //лаунчер для разрешений
    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) { //проверка
        super.onViewCreated(view, savedInstanceState)
        checkPermission_launch()
    }

    private fun checkPermission_launch() {
        if (!isPermissionGranted(Manifest.permission.ACCESS_FINE_LOCATION)) {
            permissionListener()
            pLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION) //запускает запрос разрешения на доступ к геолокации у пользователя.
        }

    }

    private fun permissionListener() {
        //проверка в реальном времени
        pLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()){ //настраивается обработчик запроса разрешения, чтобы можно было обработать результат запроса.
            Toast.makeText(activity,"permission is :$it", Toast.LENGTH_LONG).show()
        }
    }





    companion object {
        @JvmStatic
        fun newInstance() =
            MainFragment()
    }



}
