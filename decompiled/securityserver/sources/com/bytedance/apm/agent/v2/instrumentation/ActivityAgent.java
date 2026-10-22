package com.bytedance.apm.agent.v2.instrumentation;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.bytedance.apm.agent.helper.PageShowCallback;
import com.bytedance.apm.agent.tracing.AutoPageTraceHelper;
import com.bytedance.apm.agent.v2.InstructOperationSwitch;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class ActivityAgent {
    private static final String TAG = "ActivityInstrumentation";

    public ActivityAgent() {
    }

    @Keep
    public static void onTrace(String r1, String r2, boolean r3) {
        if (r3 == false) goto L9;
        if (InstructOperationSwitch.sUiSwitch == false) goto L9;
        if (TextUtils.equals("onResume", r2) == false) goto L9;
        PageShowCallback.onPageShowHideAction(r1, true);
    L9:
        if (InstructOperationSwitch.sPageLoadSwitch == true) goto L11;
        return;
    L11:
        AutoPageTraceHelper.onTrace(r1, r2, r3);
    }
}
