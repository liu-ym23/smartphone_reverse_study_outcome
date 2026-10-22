package com.bytedance.apm.agent.v2.instrumentation;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.bytedance.apm.agent.tracing.AutoPageTraceHelper;
import com.bytedance.apm.o.a.b;
import com.bytedance.apm.o.c.a;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class ActivityAgent {
    private static final String TAG = "ActivityInstrumentation";

    public ActivityAgent() {
    }

    @Keep
    public static void onTrace(String r1, String r2, boolean r3) {
        if (r3 == false) goto L9;
        if (a.f1673a == false) goto L9;
        if (TextUtils.equals("onResume", r2) == false) goto L9;
        b.a(r1, true);
    L9:
        if (a.f1674b == true) goto L11;
        return;
    L11:
        AutoPageTraceHelper.onTrace(r1, r2, r3);
    }
}
