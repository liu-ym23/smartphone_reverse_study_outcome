package com.bytedance.apm.core;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface ReportModeInf {
    public static final int DEGRADE = 2;
    public static final int NORMAL = 0;
    public static final int SMOOTH = 1;
}
