package com.android.settingslib;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Process;
import android.os.UserHandle;
import android.util.ArraySet;
import com.GlobalProxyLancet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class SliceBroadcastRelay {
    public static final String ACTION_REGISTER = "com.android.settingslib.action.REGISTER_SLICE_RECEIVER";
    public static final String ACTION_UNREGISTER = "com.android.settingslib.action.UNREGISTER_SLICE_RECEIVER";
    public static final String EXTRA_FILTER = "filter";
    public static final String EXTRA_RECEIVER = "receiver";
    public static final String EXTRA_URI = "uri";
    public static final String SYSTEMUI_PACKAGE = "com.android.systemui";
    private static final String TAG = "SliceBroadcastRelay";
    private static final Set<Uri> sRegisteredUris = null;

    public SliceBroadcastRelay() {
    }

    static {
        sRegisteredUris = new ArraySet();
    }

    public static void registerReceiver(Context r2, Uri r3, Class<? extends BroadcastReceiver> r4, IntentFilter r5) {
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Registering Uri for broadcast relay: " + r3);
        sRegisteredUris.add(r3);
        Intent r0 = new Intent(ACTION_REGISTER);
        r0.setPackage("com.android.systemui");
        r0.putExtra(EXTRA_URI, ContentProvider.maybeAddUserId(r3, Process.myUserHandle().getIdentifier()));
        r0.putExtra(EXTRA_RECEIVER, new ComponentName(r2.getPackageName(), r4.getName()));
        r0.putExtra("filter", r5);
        r2.sendBroadcastAsUser(r0, UserHandle.SYSTEM);
    }

    public static void unregisterReceivers(Context r4, Uri r5) {
        Set<Uri> r0 = sRegisteredUris;
        if (r0.contains(r5) == true) goto L5;
        return;
    L5:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Unregistering uri broadcast relay: " + r5);
        Intent r1 = new Intent(ACTION_UNREGISTER);
        r1.setPackage("com.android.systemui");
        r1.putExtra(EXTRA_URI, ContentProvider.maybeAddUserId(r5, Process.myUserHandle().getIdentifier()));
        r4.sendBroadcastAsUser(r1, UserHandle.SYSTEM);
        r0.remove(r5);
    }
}
