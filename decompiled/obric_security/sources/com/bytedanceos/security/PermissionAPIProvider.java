package com.bytedanceos.security;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import bytedanceos.util.LogTag;
import com.bytedanceos.security.multi.adpter.MultiSdkAdapter;
import com.bytedanceos.security.permission.NativePackagesListLoader;

/* JADX INFO: loaded from: classes2.dex */
public class PermissionAPIProvider extends ContentProvider {
    private static String EXTRA_RESULT = null;
    private static String TAG = "PermissionAPIProvider";
    private static Uri sUri;

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }

    public PermissionAPIProvider() {
    }

    static {
        sUri = Uri.parse("content://com.bytedanceos.security.apiprovider");
        EXTRA_RESULT = "extra_result";
    }

    @Override // android.content.ContentProvider
    public Bundle call(String method, String arg, Bundle extras) {
        LogTag.d(TAG, "call method: " + method);
        if (method == null) goto L24;
        Integer r0 = 0;
        if ("getPermissionCount".equals(method) == false) goto L22;
        PackageManager r3 = getContext().getPackageManager();
        if (r3 != null) goto L25;
    L19:
        LogTag.d(TAG, "result: " + r0);
        Bundle r2 = new Bundle();
        r2.putString(EXTRA_RESULT, String.valueOf(r0));
        return r2;
    L25:
        PackageInfo r4 = r3.getPackageInfo(arg, 0);     // Catch: PackageManager.NameNotFoundException -> L17
        if (r4 == null) goto L19;
        if (MultiSdkAdapter.sdkIsBeforeO() == false) goto L13;
        PackagePermissions r5 = PackagesListLoader.getEntry(r4, r3);     // Catch: PackageManager.NameNotFoundException -> L17
    L14:
        if (r5 == null) goto L19;
        r0 = Integer.valueOf(r5.getPermissionCount());     // Catch: PackageManager.NameNotFoundException -> L17
        goto L19
    L13:
        r5 = NativePackagesListLoader.getEntryWithDangerous(getContext(), r4, r3);     // Catch: PackageManager.NameNotFoundException -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L22:
        throw new IllegalArgumentException("PermissionAPIProvider: NOT support method " + method);
    L24:
        throw new IllegalArgumentException("PermissionAPIProvider: call method is null");
    }
}
