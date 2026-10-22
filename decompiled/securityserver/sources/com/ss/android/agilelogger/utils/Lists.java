package com.ss.android.agilelogger.utils;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class Lists {
    public Lists() {
    }

    public static <T> boolean isEmpty(List<T> r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.size() == 0) goto L7;
        return false;
    }
}
