package com.example.myapps

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.example.myapps.ui.theme.MyAppsTheme
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState

@ExperimentalPermissionsApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // TODO Template

        setContent {
            val permission = rememberMultiplePermissionsState(
                permissions = listOf(
                    Manifest.permission.RECORD_AUDIO,
                    Manifest.permission.CAMERA,
                )
            )
            val lifecycleOwner = LocalLifecycleOwner.current
            DisposableEffect(
                key1 = lifecycleOwner,
                effect = {
                    val observer = LifecycleEventObserver { _, ev ->
                        if (ev == Lifecycle.Event.ON_RESUME) {
                            permission.launchMultiplePermissionRequest()
                        }
                    }
                    lifecycleOwner.lifecycle.addObserver(observer)

                    onDispose {
                        lifecycleOwner.lifecycle.removeObserver(observer)
                    }
                })

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                permission.permissions.forEach { permissionState ->
                    when(permissionState.permission) {
                        Manifest.permission.CAMERA -> {
                            when {
                                permissionState.hasPermission -> {
                                    Text(text = "Camera permission has accepted")
                                }
                                permissionState.shouldShowRationale -> {
                                    Text(text = "Camera permission is needed to access camera")
                                }
                                !permissionState.hasPermission && !permissionState.shouldShowRationale -> {
                                    Text(text = "Camera permission already denied!, enable it in app setting!")
                                }
                            }
                        }
                        Manifest.permission.RECORD_AUDIO -> {
                            when {
                                permissionState.hasPermission -> {
                                    Text(text = "Record Audio permission has accepted")
                                }
                                permissionState.shouldShowRationale -> {
                                    Text(text = "Record Audio permission is needed to access camera")
                                }
                                !permissionState.hasPermission && !permissionState.shouldShowRationale -> {
                                    Text(text = "Camera permission already denied!, enable it in app setting!")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
