package com.jiyoung.kotilnexample.ui.news.vm

import android.app.Application
import androidx.databinding.ObservableBoolean
import com.jiyoung.kotilnexample.ui.base.BaseViewModel

class NewsListViewModel(application: Application) : BaseViewModel<Any>(application){
    var refresh = ObservableBoolean(false)
}