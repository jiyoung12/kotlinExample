package com.jiyoung.kotilnexample.ui.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel

abstract class BaseViewModel<D> protected constructor(application: Application) : AndroidViewModel(application) {
}