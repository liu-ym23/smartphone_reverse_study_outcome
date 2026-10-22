package androidx.core.view.inputmethod;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class InputConnectionCompat {
    private static final String COMMIT_CONTENT_ACTION = "androidx.core.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT";
    private static final String COMMIT_CONTENT_CONTENT_URI_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI";
    private static final String COMMIT_CONTENT_CONTENT_URI_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_URI";
    private static final String COMMIT_CONTENT_DESCRIPTION_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
    private static final String COMMIT_CONTENT_DESCRIPTION_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
    private static final String COMMIT_CONTENT_FLAGS_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
    private static final String COMMIT_CONTENT_FLAGS_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
    private static final String COMMIT_CONTENT_INTEROP_ACTION = "android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT";
    private static final String COMMIT_CONTENT_LINK_URI_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
    private static final String COMMIT_CONTENT_LINK_URI_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
    private static final String COMMIT_CONTENT_OPTS_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
    private static final String COMMIT_CONTENT_OPTS_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
    private static final String COMMIT_CONTENT_RESULT_INTEROP_RECEIVER_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
    private static final String COMMIT_CONTENT_RESULT_RECEIVER_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
    public static final int INPUT_CONTENT_GRANT_READ_URI_PERMISSION = 1;

    /* JADX INFO: renamed from: androidx.core.view.inputmethod.InputConnectionCompat$2, reason: invalid class name */
    public class AnonymousClass2 extends InputConnectionWrapper {
        final /* synthetic */ OnCommitContentListener val$listener;

        public AnonymousClass2(InputConnection r1, boolean r2, OnCommitContentListener r3) {
            this.val$listener = r3;
            super(r1, r2);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean performPrivateCommand(String r2, Bundle r3) {
            if (InputConnectionCompat.handlePerformPrivateCommand(r2, r3, this.val$listener) == false) goto L7;
            return true;
        L7:
            return super.performPrivateCommand(r2, r3);
        }
    }

    public interface OnCommitContentListener {
        boolean onCommitContent(InputContentInfoCompat r1, int r2, Bundle r3);
    }

    @Deprecated
    public InputConnectionCompat() {
    }

    public static boolean commitContent(@NonNull InputConnection r5, @NonNull EditorInfo r6, @NonNull InputContentInfoCompat r7, int r8, @Nullable Bundle r9) {
        ClipDescription r0 = r7.getDescription();
        String[] r10 = EditorInfoCompat.getContentMimeTypes(r6);
        int r1 = r10.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L9;
        if (r0.hasMimeType(r10[r3]) == true) goto L7;
        r3 = r3 + 1;
        goto L3
    L7:
        return r5.commitContent((InputContentInfo) r7.unwrap(), r8, r9);
    L9:
        return false;
    }

    @NonNull
    public static InputConnection createWrapper(@NonNull final InputConnection r1, @NonNull EditorInfo r2, @NonNull final OnCommitContentListener r3) {
        if (r1 == null) goto L12;
        if (r2 == null) goto L10;
        if (r3 == null) goto L8;
        final boolean r0 = false;
        return new AnonymousClass1(r1, r0, r3);
    L8:
        throw new IllegalArgumentException("onCommitContentListener must be non-null");
    L10:
        throw new IllegalArgumentException("editorInfo must be non-null");
    L12:
        throw new IllegalArgumentException("inputConnection must be non-null");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    public static boolean handlePerformPrivateCommand(@Nullable String r7, @NonNull Bundle r8, @NonNull OnCommitContentListener r9) {
        ?? r0 = 0;
        r0 = 0;
        if (r8 != null) goto L6;
        return false;
    L6:
        if (TextUtils.equals(COMMIT_CONTENT_ACTION, r7) == false) goto L9;
        boolean r10 = false;
    L12:
        if (r10 == false) goto L16;
        String r2 = COMMIT_CONTENT_RESULT_INTEROP_RECEIVER_KEY;
    L52:
        ResultReceiver r3 = (ResultReceiver) r8.getParcelable(r2);     // Catch: Throwable -> L14
        if (r10 == false) goto L22;
        String r4 = COMMIT_CONTENT_CONTENT_URI_INTEROP_KEY;
    L50:
        Uri r5 = (Uri) r8.getParcelable(r4);     // Catch: Throwable -> L20
        if (r10 == false) goto L26;
        String r6 = COMMIT_CONTENT_DESCRIPTION_INTEROP_KEY;
    L27:
        ClipDescription r11 = (ClipDescription) r8.getParcelable(r6);     // Catch: Throwable -> L20
        if (r10 == false) goto L30;
        String r12 = COMMIT_CONTENT_LINK_URI_INTEROP_KEY;
    L31:
        Uri r13 = (Uri) r8.getParcelable(r12);     // Catch: Throwable -> L20
        if (r10 == false) goto L34;
        String r14 = COMMIT_CONTENT_FLAGS_INTEROP_KEY;
    L35:
        int r15 = r8.getInt(r14);     // Catch: Throwable -> L20
        if (r10 == false) goto L38;
        String r16 = COMMIT_CONTENT_OPTS_INTEROP_KEY;
    L39:
        Bundle r17 = (Bundle) r8.getParcelable(r16);     // Catch: Throwable -> L20
        if (r5 == null) goto L43;
        if (r11 == null) goto L43;
        r0 = r9.onCommitContent(new InputContentInfoCompat(r5, r11, r13), r15, r17);     // Catch: Throwable -> L20
    L43:
        if (r3 == 0) goto L45;
        r3.send(r0, null);
    L45:
        return r0;
    L38:
        r16 = COMMIT_CONTENT_OPTS_KEY;
        goto L39
    L34:
        r14 = COMMIT_CONTENT_FLAGS_KEY;
        goto L35
    L30:
        r12 = COMMIT_CONTENT_LINK_URI_KEY;
        goto L31
    L26:
        r6 = COMMIT_CONTENT_DESCRIPTION_KEY;
    L20:
        th = th;
        ResultReceiver r18 = r3;
    L46:
        if (r18 == null) goto L48;
        r18.send(0, null);
    L48:
        throw th;
    L22:
        r4 = COMMIT_CONTENT_CONTENT_URI_KEY;
    L14:
        th = th;
        r18 = null;
        goto L46
    L16:
        r2 = COMMIT_CONTENT_RESULT_RECEIVER_KEY;
        goto L52
    L9:
        if (TextUtils.equals(COMMIT_CONTENT_INTEROP_ACTION, r7) == false) goto L49;
        r10 = true;
        goto L12
    L49:
        return false;
    }
}
