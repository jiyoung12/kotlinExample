package com.jiyoung.kotilnexample.common

import java.util.Locale
import javax.inject.Inject

class DeviceManager @Inject constructor() {

    fun getLocaleCode() = Locale.getDefault().country

    fun getLanguageCode() = Locale.getDefault().language

}