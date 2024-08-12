package com.jyhong.data.mapper

import com.jyhong.data.model.NetworkSource
import com.jyhong.domain.model.Source

internal fun NetworkSource.toModel() = Source(id = id, name = name)