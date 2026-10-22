package com.bytedance.apm.report;

import android.text.TextUtils;
import com.bytedance.apm.ApmContext;

/* JADX INFO: loaded from: classes.dex */
public class ExtendHeaderHelper {
    public static final String TEST_RUNTIME_KEY = "test_runtime";
    private static String sTestInfoPropPath;

    public ExtendHeaderHelper() {
    }

    public static String getTestInfoPropPath() {
        if (TextUtils.isEmpty(sTestInfoPropPath) == false) goto L6;
        sTestInfoPropPath = ApmContext.getContext().getExternalFilesDir(null).getParentFile().getAbsolutePath() + "/AutomationTestInfo.json";     // Catch: Throwable -> L7
    L6:
        return sTestInfoPropPath;
    }

    public static void setTestInfoPropPath(String r0) {
        sTestInfoPropPath = r0;
    }
}
