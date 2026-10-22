package com.monitor.cloudmessage.utils;

import androidx.annotation.Nullable;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public class CollectionUtils {
    public CollectionUtils() {
    }

    public static boolean isEmpty(@Nullable Collection r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.isEmpty() == true) goto L7;
        return false;
    }
}
