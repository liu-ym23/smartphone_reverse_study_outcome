package com.android.settings.slices;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;

/* JADX INFO: loaded from: classes2.dex */
public interface Sliceable {
    public static final int NO_RES = 0;

    default Class<? extends SliceBackgroundWorker> getBackgroundWorkerClass() {
        return null;
    }

    default IntentFilter getIntentFilter() {
        return null;
    }

    default int getSliceHighlightMenuRes() {
        return 0;
    }

    default Uri getSliceUri() {
        return null;
    }

    default boolean hasAsyncUpdate() {
        return false;
    }

    default boolean isPublicSlice() {
        return false;
    }

    default boolean isSliceable() {
        return false;
    }

    default boolean useDynamicSliceSummary() {
        return false;
    }

    static void setCopyContent(Context r0, CharSequence r1, CharSequence r2) {
        ((ClipboardManager) r0.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text", r1));
    }
}
