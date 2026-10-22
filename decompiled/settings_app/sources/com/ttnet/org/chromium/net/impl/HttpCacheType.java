package com.ttnet.org.chromium.net.impl;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes5.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface HttpCacheType {
    public static final int DISABLED = 0;
    public static final int DISK = 1;
    public static final int MEMORY = 2;
}
