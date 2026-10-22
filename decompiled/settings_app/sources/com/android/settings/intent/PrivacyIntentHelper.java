package com.android.settings.intent;

import android.content.Intent;
import com.obric.capabilitykit.common.DispatchContext;

/* JADX INFO: loaded from: classes2.dex */
public class PrivacyIntentHelper {
    private static PrivacyIntentHelper sInstance;
    private DispatchContext dispatchContext;

    private PrivacyIntentHelper() {
    }

    public static PrivacyIntentHelper getInstance() {
        if (sInstance != null) goto L6;
        sInstance = new PrivacyIntentHelper();
    L6:
        return sInstance;
    }

    public void openPrivacyActivity(DispatchContext r3) {
        this.dispatchContext = r3;
        Intent r2 = new Intent(r3.getContext(), PrivacyIntentActivity.class);
        r2.setFlags(268468224);
        r3.getContext().startActivity(r2);
    }

    public DispatchContext getDispatchContext() {
        return this.dispatchContext;
    }
}
