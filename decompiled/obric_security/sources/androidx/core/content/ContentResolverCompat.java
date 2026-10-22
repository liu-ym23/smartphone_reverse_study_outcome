package androidx.core.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.OperationCanceledException;

/* JADX INFO: loaded from: classes.dex */
public final class ContentResolverCompat {

    static class Api16Impl {
        private Api16Impl() {
        }

        static Cursor query(ContentResolver r0, Uri r1, String[] r2, String r3, String[] r4, String r5, CancellationSignal r6) {
            return r0.query(r1, r2, r3, r4, r5, r6);
        }
    }

    private ContentResolverCompat() {
    }

    public static Cursor query(ContentResolver r7, Uri r8, String[] r9, String r10, String[] r11, String r12, androidx.core.os.CancellationSignal r13) {
        if (r13 != null) goto L14;
        Object r14 = null;
    L7:
        return Api16Impl.query(r7, r8, r9, r10, r11, r12, (CancellationSignal) r14);
    L4:
        e = move-exception;
        if ((e instanceof OperationCanceledException) == true) goto L12;
        throw e;
    L12:
        throw new androidx.core.os.OperationCanceledException();
    L14:
        r14 = r13.getCancellationSignalObject();     // Catch: Exception -> L4
        goto L7
    }
}
