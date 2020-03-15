package com.jiyoung.kotilnexample.ui.send

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.jiyoung.kotilnexample.ui.Log


class SendFragment : Fragment() {

    private lateinit var sendViewModel: SendViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        sendViewModel =
            ViewModelProviders.of(this).get(SendViewModel::class.java)
        val root =
            inflater.inflate(com.jiyoung.kotilnexample.R.layout.fragment_send, container, false)
        val textView: TextView = root.findViewById(com.jiyoung.kotilnexample.R.id.text_send)
        sendViewModel.text.observe(this, Observer {
            textView.text = it
        })
        testFun()
        return root
    }

   val name : String by lazy{
       Log.e("called lazy")
       "jiyoung"
   }

    fun testFun() {
        Log.e("call name before")
        Log.e("name is $name")
        Log.e("called name")
        Log.e("name is again $name")
        class User(val name : String, val age: Int)
        val lambda : (User) -> Int = User::age
    }

}

