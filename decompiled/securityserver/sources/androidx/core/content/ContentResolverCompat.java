package androidx.core.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.OperationCanceledException;
import androidx.core.os.CancellationSignal;

/* JADX INFO: loaded from: classes.dex */
public final class ContentResolverCompat {
    private ContentResolverCompat() {
    }

    public static Cursor query(ContentResolver r7, Uri r8, String[] r9, String r10, String[] r11, String r12, CancellationSignal r13) {
        if (r13 != null) goto L14;
        Object r14 = null;
    L7:
        return r7.query(r8, r9, r10, r11, r12, (android.os.CancellationSignal) r14);
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
