package com.obric.server.security;

import android.content.Context;
import android.util.Log;
import com.android.server.SystemService;

/* JADX INFO: loaded from: classes.dex */
public class ObricSecurityService extends SystemService {
    private static final String TAG = "ObricSecurityService";
    private final ObricSecurityServiceProxy proxy;

    public ObricSecurityService(Context context) {
        super(context);
        this.proxy = ObricSecurityServiceProxy.getInstance(context);
    }

    public void onStart() {
        if (this.proxy != null) goto L5;
        Log.e(TAG, "ObricSecurityService onStart failed.");
        return;
    L5:
        this.proxy.onStart();
    }

    public void onBootPhase(int phase) {
        if (this.proxy != null) goto L5;
        Log.e(TAG, "ObricSecurityService onBootPhase failed.");
        return;
    L5:
        this.proxy.onBootPhase(phase);
    }
}
