package androidx.core.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.OperationCanceledException;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public final class ContentResolverCompat {

    @RequiresApi(16)
    static class Api16Impl {
        private Api16Impl() {
        }

        @DoNotInline
        static Cursor query(ContentResolver r0, Uri r1, String[] r2, String r3, String[] r4, String r5, CancellationSignal r6) {
            return r0.query(r1, r2, r3, r4, r5, r6);
        }
    }

    private ContentResolverCompat() {
    }

    @Nullable
    public static Cursor query(@NonNull ContentResolver r7, @NonNull Uri r8, @Nullable String[] r9, @Nullable String r10, @Nullable String[] r11, @Nullable String r12, @Nullable androidx.core.os.CancellationSignal r13) {
        if (Build.VERSION.SDK_INT < 16) goto L16;
        if (r13 != null) goto L20;
        Object r14 = null;
    L9:
        return Api16Impl.query(r7, r8, r9, r10, r11, r12, (CancellationSignal) r14);
    L6:
        e = move-exception;
        if ((e instanceof OperationCanceledException) == true) goto L14;
        throw e;
    L14:
        throw new androidx.core.os.OperationCanceledException();
    L20:
        r14 = r13.getCancellationSignalObject();     // Catch: Exception -> L6
        goto L9
    L16:
        if (r13 == null) goto L19;
        r13.throwIfCanceled();
    L19:
        return r7.query(r8, r9, r10, r11, r12);
    }
}
