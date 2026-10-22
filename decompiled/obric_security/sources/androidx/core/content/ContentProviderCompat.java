package androidx.core.content;

import android.content.ContentProvider;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class ContentProviderCompat {
    private ContentProviderCompat() {
    }

    public static Context requireContext(ContentProvider r1) {
        Context r2 = r1.getContext();
        if (r2 == null) goto L6;
        return r2;
    L6:
        throw new IllegalStateException("Cannot find context from the provider.");
    }
}
