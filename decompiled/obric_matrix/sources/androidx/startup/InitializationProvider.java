package androidx.startup;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class InitializationProvider extends ContentProvider {
    public InitializationProvider() {
    }

    @Override // android.content.ContentProvider
    public final int delete(@NonNull Uri r1, @Nullable String r2, @Nullable String[] r3) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override // android.content.ContentProvider
    @Nullable
    public final String getType(@NonNull Uri r1) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override // android.content.ContentProvider
    @Nullable
    public final Uri insert(@NonNull Uri r1, @Nullable ContentValues r2) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        Context r1 = getContext();
        if (r1 == null) goto L10;
        if (r1.getApplicationContext() == null) goto L11;
        AppInitializer.getInstance(r1).discoverAndInitialize();
        return true;
    L11:
        return true;
    L10:
        throw new StartupException("Context cannot be null");
    }

    @Override // android.content.ContentProvider
    @Nullable
    public final Cursor query(@NonNull Uri r1, @Nullable String[] r2, @Nullable String r3, @Nullable String[] r4, @Nullable String r5) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override // android.content.ContentProvider
    public final int update(@NonNull Uri r1, @Nullable ContentValues r2, @Nullable String r3, @Nullable String[] r4) {
        throw new IllegalStateException("Not allowed.");
    }
}
