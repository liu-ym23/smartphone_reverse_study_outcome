package com.google.android.material.color;

import android.content.Context;
import android.content.res.loader.ResourcesLoader;
import android.content.res.loader.ResourcesProvider;
import android.os.ParcelFileDescriptor;
import android.system.Os;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class ColorResourcesLoaderCreator {
    private static final String TAG = "ColorResourcesLoaderCreator";

    static {
    }

    private ColorResourcesLoaderCreator() {
    }

    static ResourcesLoader create(Context r4, Map<Integer, Integer> r5) {
        byte[] r6 = ColorResourcesTableCreator.create(r4, r5);     // Catch: Exception -> L36
        Log.i(TAG, "Table created, length: " + r6.length);     // Catch: Exception -> L36
        if (r6.length != 0) goto L42;
        return null;
    L42:
        FileDescriptor r7 = Os.memfd_create("temp.arsc", 0);     // Catch: Throwable -> L31
        FileOutputStream r0 = new FileOutputStream(r7);     // Catch: Throwable -> L29
        r0.write(r6);     // Catch: Throwable -> L23
        ParcelFileDescriptor r8 = ParcelFileDescriptor.dup(r7);     // Catch: Throwable -> L23
        ResourcesLoader r2 = new ResourcesLoader();     // Catch: Throwable -> L16
        r2.addProvider(ResourcesProvider.loadFromTable(r8, null));     // Catch: Throwable -> L16
        if (r8 == null) goto L12;
        r8.close();     // Catch: Throwable -> L23
    L12:
        r0.close();     // Catch: Throwable -> L29
        if (r7 == null) goto L15;
        Os.close(r7);     // Catch: Exception -> L36
    L15:
        return r2;
    L16:
        th = move-exception;
        if (r8 != null) goto L40;
    L22:
        throw th;     // Catch: Throwable -> L23
    L40:
        r8.close();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L26
    L28:
        throw th;     // Catch: Throwable -> L29
    L26:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L29
    L29:
        th = th;
    L33:
        if (r7 == null) goto L35;
        Os.close(r7);     // Catch: Exception -> L36
    L35:
        throw th;     // Catch: Exception -> L36
    L31:
        th = th;
        r7 = null;
    L36:
        e = move-exception;
        Log.e(TAG, "Failed to create the ColorResourcesTableCreator.", e);
        return null;
    }
}
