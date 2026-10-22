package com.bytedance.services.apm;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface TraceExtraInfoFlagInf {
    public static final int GET_IO = 2;
    public static final int GET_NET = 1;
    public static final int GET_THREAD = 3;
}
