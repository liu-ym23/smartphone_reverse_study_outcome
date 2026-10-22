package com.bytedance.bdturing.ttnet;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class BdTuringInitProvider extends ContentProvider {
    public BdTuringInitProvider() {
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri r1, @Nullable String r2, @Nullable String[] r3) {
        return 0;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri r1) {
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri r1, @Nullable ContentValues r2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        c.a();     // Catch: Exception -> L4
        return true;
    L4:
        e = move-exception;
        e.printStackTrace();
        return true;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri r1, @Nullable String[] r2, @Nullable String r3, @Nullable String[] r4, @Nullable String r5) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri r1, @Nullable ContentValues r2, @Nullable String r3, @Nullable String[] r4) {
        return 0;
    }
}
