package com.bytedance.platform.godzilla.common;

/* JADX INFO: loaded from: classes3.dex */
public interface UncaughtExceptionConsumer {
    boolean consumeUncaughtException(Thread r1, Throwable r2) throws Throwable;
}
