package dev.amal.ecommerceconcept

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import dagger.hilt.android.AndroidEntryPoint
import dev.amal.ecommerceconcept.fragments.home_store_fragment.HomeStoreViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val homeStoreViewModel by viewModels<HomeStoreViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                homeStoreViewModel.stateFlow.value.isLoading
            }
        }
        setContentView(R.layout.activity_main)
    }
}