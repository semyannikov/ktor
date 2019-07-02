/*
 * Copyright 2014-2019 JetBrains s.r.o and contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package io.ktor.util.cio

import io.ktor.util.*
import io.ktor.utils.io.pool.*
import java.nio.*


internal const val DEFAULT_BUFFER_SIZE = 4098
internal const val DEFAULT_KTOR_POOL_SIZE = 2048

/**
 * The default ktor byte buffer pool
 */
@KtorExperimentalAPI
val KtorDefaultPool: ObjectPool<ByteBuffer> = ByteBufferPool()

@InternalAPI
@Suppress("KDocMissingDocumentation")
class ByteBufferPool : DefaultPool<ByteBuffer>(DEFAULT_KTOR_POOL_SIZE) {
    override fun produceInstance(): ByteBuffer = ByteBuffer.allocate(DEFAULT_BUFFER_SIZE)

    override fun clearInstance(instance: ByteBuffer): ByteBuffer = instance.apply { clear() }
}
