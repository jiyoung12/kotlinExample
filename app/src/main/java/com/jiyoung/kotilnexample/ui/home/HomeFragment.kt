package com.jiyoung.kotilnexample.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.content.pm.PackageManager
import android.util.Base64
import com.jiyoung.kotilnexample.ui.Log
import java.security.MessageDigest


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(com.jiyoung.kotilnexample.R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(com.jiyoung.kotilnexample.R.id.text_home)
        homeViewModel.text.observe(this, Observer {
            textView.text = it
        })
        getAppKeyHash()
        return root
    }

    private fun getAppKeyHash() {
        try {
            val info = context?.getPackageManager()?.getPackageInfo(context?.getPackageName(), PackageManager.GET_SIGNATURES).let {
                for (signature in it!!.signatures) {
                    val md: MessageDigest
                    md = MessageDigest.getInstance("SHA")
                    md.update(signature.toByteArray())
                    val something = String(Base64.encode(md.digest(), 0))
                    Log.e(something)
                }
            }

        } catch (e: Exception) {
            // TODO Auto-generated catch block
//            Log.e("name not found", e.toString())toString
        }

    }
}