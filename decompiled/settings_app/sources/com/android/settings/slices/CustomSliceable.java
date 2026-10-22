package com.android.settings.slices;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.slice.Slice;

/* JADX INFO: loaded from: classes2.dex */
public interface CustomSliceable extends Sliceable {
    public static final int COLOR_NOT_TINTED = -1;

    Intent getIntent();

    Slice getSlice();

    @Override // com.android.settings.slices.Sliceable
    int getSliceHighlightMenuRes();

    Uri getUri();

    @Override // com.android.settings.slices.Sliceable
    default boolean isSliceable() {
        return true;
    }

    default void onNotifyChange(Intent r1) {
    }

    default PendingIntent getBroadcastIntent(Context r3) {
        return PendingIntent.getBroadcast(r3, 0, new Intent(getUri().toString()).setData(getUri()).setClass(r3, SliceBroadcastReceiver.class), 167772160);
    }

    static CustomSliceable createInstance(Context r4, Class<? extends CustomSliceable> r5) {
        return r5.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{r4.getApplicationContext()});
    L5:
        e = move-exception;
        throw new IllegalStateException("Invalid sliceable class: " + r5, e);
    }
}
