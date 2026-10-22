package com.android.settings.slices;

import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import com.android.settingslib.SliceBroadcastRelay;
import com.obric.olog.OLog;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class VolumeSliceHelper {
    private static final String TAG = "VolumeSliceHelper";
    static IntentFilter sIntentFilter;
    static Map<Uri, Integer> sRegisteredUri;

    public VolumeSliceHelper() {
    }

    static {
        sRegisteredUri = new ConcurrentHashMap();
    }

    static void registerIntentToUri(Context r3, IntentFilter r4, Uri r5, int r6) {
        OLog.d(TAG, "Registering uri for broadcast relay: " + r5);
        Map<Uri, Integer> r0 = sRegisteredUri;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sRegisteredUri.isEmpty() == false) goto L7;
        SliceBroadcastRelay.registerReceiver(r3, CustomSliceRegistry.VOLUME_SLICES_URI, VolumeSliceRelayReceiver.class, r4);     // Catch: Throwable -> L10
        sIntentFilter = r4;     // Catch: Throwable -> L10
    L7:
        sRegisteredUri.put(r5, Integer.valueOf(r6));     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
    }

    static boolean unregisterUri(Context r3, Uri r4) {
        if (sRegisteredUri.containsKey(r4) == true) goto L6;
        return false;
    L6:
        OLog.d(TAG, "Unregistering uri broadcast relay: " + r4);
        Map<Uri, Integer> r0 = sRegisteredUri;
        monitor-enter(r0);
        sRegisteredUri.remove(r4);     // Catch: Throwable -> L14
        if (sRegisteredUri.isEmpty() == false) goto L11;
        sIntentFilter = null;     // Catch: Throwable -> L14
        SliceBroadcastRelay.unregisterReceivers(r3, CustomSliceRegistry.VOLUME_SLICES_URI);     // Catch: Throwable -> L14
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return true;
    L14:
        th = move-exception;
        throw th;
    }

    static void onReceive(Context r4, Intent r5) {
        String r0 = r5.getAction();
        IntentFilter r1 = sIntentFilter;
        if (r1 == null) goto L26;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r1.hasAction(r0) == false) goto L31;
        String r2 = r5.getStringExtra(SliceBroadcastRelay.EXTRA_URI);
        if (r2 != null) goto L12;
        return;
    L12:
        if (CustomSliceRegistry.VOLUME_SLICES_URI.equals(ContentProvider.getUriWithoutUserId(Uri.parse(r2))) == true) goto L16;
        OLog.w(TAG, "Invalid uri: " + r2);
        return;
    L16:
        if ("android.media.VOLUME_CHANGED_ACTION".equals(r0) == false) goto L19;
        handleVolumeChanged(r4, r5);
        return;
    L19:
        if ("android.media.STREAM_MUTE_CHANGED_ACTION".equals(r0) == false) goto L22;
        handleMuteChanged(r4, r5);
        return;
    L22:
        if ("android.media.STREAM_DEVICES_CHANGED_ACTION".equals(r0) == false) goto L24;
        handleStreamChanged(r4, r5);
        return;
    L24:
        notifyAllStreamsChanged(r4);
        return;
    L31:
        return;
    }

    private static void handleVolumeChanged(Context r3, Intent r4) {
        if (r4.getIntExtra("android.media.EXTRA_VOLUME_STREAM_VALUE", -1) == r4.getIntExtra("android.media.EXTRA_PREV_VOLUME_STREAM_VALUE", -1)) goto L6;
        handleStreamChanged(r3, r4);
        return;
    }

    private static void handleMuteChanged(Context r2, Intent r3) {
        int r4 = r3.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1);
        handleStreamChanged(r2, r4);
        if (r4 != 2) goto L6;
        handleStreamChanged(r2, 5);
        return;
    }

    private static void handleStreamChanged(Context r2, Intent r3) {
        handleStreamChanged(r2, r3.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1));
    }

    private static void handleStreamChanged(Context r4, int r5) {
        Iterator<Map.Entry<Uri, Integer>> r0 = sRegisteredUri.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Map.Entry<Uri, Integer> r1 = r0.next();
        if (r1.getValue().intValue() != r5) goto L4;
        r4.getContentResolver().notifyChange(r1.getKey(), null);
        if (r5 == 2) goto L4;
        return;
    }

    private static void notifyAllStreamsChanged(final Context r2) {
        sRegisteredUri.keySet().forEach(new VolumeSliceHelper$$ExternalSyntheticLambda0(r2));
    }

    static /* synthetic */ void lambda$notifyAllStreamsChanged$0(Context r1, Uri r2) {
        r1.getContentResolver().notifyChange(r2, null);
    }
}
