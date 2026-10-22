package com.obric.server.security.keymanager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.obric.security.keymanager.KeyManager;
import com.obric.security.secretdata.SecretDataManager;
import com.obric.server.security.broadcast.IObricSecurityBroadcastPlugin;
import com.obric.server.security.broadcast.ObricSecurityBroadcast;
import com.obric.server.security.utils.Utils;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class ObricKeyManager {
    private static final int MAX_TIMEOUT = 1000;
    private static final String TAG = "ObricKeyManager";
    private final Context mContext;

    private class ObricBroadcastReceiver implements IObricSecurityBroadcastPlugin {
        final /* synthetic */ ObricKeyManager this$0;

        /* synthetic */ ObricBroadcastReceiver(ObricKeyManager r1, ObricKeyManagerIA r2) {
            this(r1);
        }

        private ObricBroadcastReceiver(ObricKeyManager r1) {
            this.this$0 = r1;
        }

        @Override // com.obric.server.security.broadcast.IObricSecurityBroadcastPlugin
        public void onReceive(Context context, Intent intent) {
            Log.i(ObricKeyManager.TAG, "onReceive " + intent.getAction());
            if (TextUtils.equals(intent.getAction(), "android.intent.action.PACKAGE_FULLY_REMOVED") == false) goto L5;
        L6:
            String packageName = intent.getData().getSchemeSpecificPart();
            int uid = intent.getIntExtra("android.intent.extra.UID", -1);
            if (uid != (-1)) goto L10;
            uid = Utils.getUidFromPkgName(ObricKeyManager.m101$$Nest$fgetmContext(this.this$0), packageName);
        L10:
            if (uid != ObricKeyManager.MAX_TIMEOUT) goto L13;
            Log.i(ObricKeyManager.TAG, "System uid app no need to clear data.");
            return;
        L13:
            Log.i(ObricKeyManager.TAG, "onReceive packageName:" + packageName + " uid:" + uid);
            int result = ObricKeyManager.m102$$Nest$mclearAppData(this.this$0, packageName, uid);
            Log.i(ObricKeyManager.TAG, "App data clear result:" + result);
            int result2 = ObricKeyManager.m103$$Nest$mclearAppKeyData(this.this$0, packageName, uid);
            Log.i(ObricKeyManager.TAG, "App key data clear result:" + result2);
            return;
        L5:
            if (TextUtils.equals(intent.getAction(), "android.intent.action.PACKAGE_DATA_CLEARED") == true) goto L6;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m101$$Nest$fgetmContext(ObricKeyManager r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$mclearAppData, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m102$$Nest$mclearAppData(ObricKeyManager r0, String r1, int r2) {
        return r0.clearAppData(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mclearAppKeyData, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m103$$Nest$mclearAppKeyData(ObricKeyManager r0, String r1, int r2) {
        return r0.clearAppKeyData(r1, r2);
    }

    ObricKeyManager(Context context) {
        this.mContext = context;
        ObricSecurityBroadcast.registerPlugin("keymanager", new ArrayList(Arrays.asList(new String[]{"android.intent.action.PACKAGE_FULLY_REMOVED", "android.intent.action.PACKAGE_DATA_CLEARED"})), new ObricBroadcastReceiver(this, null));
    }

    private int clearAppData(String pkgName, int uid) {
        SecretDataManager secDataManager = SecretDataManager.getInstance();
        if (secDataManager != null) goto L7;
        Log.e(TAG, "Get secret data manager failed!!");
        return -3;
    L7:
        return secDataManager.clearAppData(pkgName, uid, new Bundle());
    }

    private int clearAppKeyData(String pkgName, int uid) {
        KeyManager keyManager = KeyManager.getInstance();
        if (keyManager != null) goto L7;
        Log.e(TAG, "Get KeyManager failed!!");
        return -3;
    L7:
        return keyManager.clearAppKeyData(pkgName, uid, new Bundle());
    }
}
