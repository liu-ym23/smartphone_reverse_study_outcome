package com.android.launcher3.icons;

import android.content.Context;
import com.android.settingslib.R;

/* JADX INFO: loaded from: classes.dex */
public class IconFactory extends BaseIconFactory {
    private static IconFactory sPool;
    private static int sPoolId;
    private static final Object sPoolSync = null;
    private final int mPoolId;
    private IconFactory next;

    static {
        sPoolSync = new Object();
    }

    public static IconFactory obtain(Context r5) {
        Object r0 = sPoolSync;
        monitor-enter(r0);
        IconFactory r1 = sPool;     // Catch: Throwable -> L13
        if (r1 == null) goto L9;
        sPool = r1.next;     // Catch: Throwable -> L13
        r1.next = null;     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r1;
    L9:
        int r2 = sPoolId;     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return new IconFactory(r5, r5.getResources().getConfiguration().densityDpi, r5.getResources().getDimensionPixelSize(R.dimen.default_icon_bitmap_size), r2);
    L13:
        th = move-exception;
        throw th;
    }

    public static void clearPool() {
        Object r0 = sPoolSync;
        monitor-enter(r0);
        sPool = null;     // Catch: Throwable -> L8
        sPoolId++;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private IconFactory(Context r1, int r2, int r3, int r4) {
        super(r1, r2, r3);
        this.mPoolId = r4;
    }

    public void recycle() {
        Object r0 = sPoolSync;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (sPoolId == this.mPoolId) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        clear();     // Catch: Throwable -> L11
        this.next = sPool;     // Catch: Throwable -> L11
        sPool = this;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    @Override // com.android.launcher3.icons.BaseIconFactory, java.lang.AutoCloseable
    public void close() {
        recycle();
    }
}
