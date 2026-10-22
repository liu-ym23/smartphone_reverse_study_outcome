package com.bytedance.watson.assist.api;

import android.content.Context;
import com.bytedance.watson.assist.core.AssistStatImp;

/* JADX INFO: loaded from: classes2.dex */
public class AssistStatFactory {
    public AssistStatFactory() {
    }

    public static IAssistStat create(Context r0) {
        if (r0 != null) goto L6;
        return null;
    L6:
        return AssistStatImp.getInstance(r0);
    }

    public static IAssistStat create(Context r0, AssistConfig r1) {
        if (r0 != null) goto L6;
        return null;
    L6:
        return AssistStatImp.createNewInstance(r0, r1);
    }
}
