package dev.amal.ecommerceconcept.fragments.splash_screen

import android.os.Handler
import android.os.Looper
import androidx.navigation.fragment.findNavController
import dev.amal.ecommerceconcept.R
import dev.amal.ecommerceconcept.common.BaseFragment
import dev.amal.ecommerceconcept.common.setDarkSystemBars
import dev.amal.ecommerceconcept.databinding.FragmentSplashBinding

class SplashFragment : BaseFragment<FragmentSplashBinding>(
    FragmentSplashBinding::inflate
) {

    override fun onCreateView() {
        activity?.window?.setDarkSystemBars(requireContext())

        Handler(Looper.myLooper()!!).postDelayed({
            findNavController().navigate(R.id.action_splashFragment_to_homeStoreFragment)
        }, 1200)
    }
}