package androidx.core.content;

import android.content.ContentProvider;
import android.content.Context;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public final class ContentProviderCompat {
    private ContentProviderCompat() {
    }

    @NonNull
    public static Context requireContext(@NonNull ContentProvider r1) {
        Context r2 = r1.getContext();
        if (r2 == null) goto L6;
        return r2;
    L6:
        throw new IllegalStateException("Cannot find context from the provider.");
    }
}
