package com.obric.server.security.guard;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SensitiveViewDetect {
    private static final String FREE_PAYMENT = "FREE_PAYMENT";
    private static final String MAYBE_FREE_PAYMENT = "MAYBE_FREE_PAYMENT";
    static final String SENSITIVE_FILE = "sen_data.json";
    private static final String SENSITIVE_POLICY = "sensitive_view";
    private static final String TAG = "SensitiveViewDetect";
    Set<String> mFreePaymentSet;
    Set<String> mMayBeFreePaymentSet;

    public SensitiveViewDetect() {
        this.mFreePaymentSet = new HashSet();
        this.mMayBeFreePaymentSet = new HashSet();
        String sensitiveData = GuardDataStorage.getPolicy(SENSITIVE_FILE);
        if (sensitiveData == null) goto L6;
        init(sensitiveData);
        return;
    }

    public void init(String sensitiveData) {
        JSONObject jsonObject = new JSONObject(sensitiveData);     // Catch: Exception -> L19
        JSONObject sensitiveViewObject = jsonObject.optJSONObject(SENSITIVE_POLICY);     // Catch: Exception -> L19
        if (sensitiveViewObject != null) goto L5;
        return;
    L5:
        JSONArray freePaymentArray = sensitiveViewObject.optJSONArray(FREE_PAYMENT);     // Catch: Exception -> L19
        if (freePaymentArray == null) goto L11;
        int i = 0;
    L9:
        if (i >= freePaymentArray.length()) goto L11;
        this.mFreePaymentSet.add(freePaymentArray.getString(i));     // Catch: Exception -> L19
        i = i + 1;     // Catch: Exception -> L19
    L11:
        JSONArray mayBeFreePaymentArray = sensitiveViewObject.optJSONArray(MAYBE_FREE_PAYMENT);     // Catch: Exception -> L19
        if (mayBeFreePaymentArray == null) goto L26;
        int i2 = 0;
    L14:
        if (i2 >= mayBeFreePaymentArray.length()) goto L27;
        this.mMayBeFreePaymentSet.add(mayBeFreePaymentArray.getString(i2));     // Catch: Exception -> L19
        i2 = i2 + 1;
        goto L14
    L27:
        return;
    L26:
        return;
    L19:
        e = move-exception;
        Log.e(TAG, "parse sensitive data failed, " + e.getMessage());
    }

    public int getActivityRiskType(String packageName, String activityName, Bundle extra) {
        if (TextUtils.isEmpty(packageName) == false) goto L5;
    L16:
        return 0;
    L5:
        if (TextUtils.isEmpty(activityName) == true) goto L16;
        String activityInfo = packageName + "/" + activityName;
        if (this.mFreePaymentSet.contains(activityInfo) == false) goto L12;
        return 2;
    L12:
        if (this.mMayBeFreePaymentSet.contains(activityInfo) == false) goto L15;
        return 10;
    L15:
        return 0;
    }
}
