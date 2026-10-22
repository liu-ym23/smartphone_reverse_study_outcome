package androidx.core.view.inputmethod;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"PrivateConstructorForUtilityClass"})
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
    private static final String EXTRA_INPUT_CONTENT_INFO = "androidx.core.view.extra.INPUT_CONTENT_INFO";
    public static final int INPUT_CONTENT_GRANT_READ_URI_PERMISSION = 1;
    private static final String LOG_TAG = "InputConnectionCompat";

    @RequiresApi(25)
    static class Api25Impl {
        private Api25Impl() {
        }

        @DoNotInline
        static boolean commitContent(InputConnection r0, InputContentInfo r1, int r2, Bundle r3) {
            return r0.commitContent(r1, r2, r3);
        }
    }

    public interface OnCommitContentListener {
        boolean onCommitContent(@NonNull InputContentInfoCompat r1, int r2, @Nullable Bundle r3);
    }

    @Deprecated
    public InputConnectionCompat() {
    }

    static /* synthetic */ boolean a(View r5, InputContentInfoCompat r6, int r7, Bundle r8) {
        if (Build.VERSION.SDK_INT < 25) goto L16;
        if ((r7 & 1) == 0) goto L16;
        r6.requestPermission();     // Catch: Exception -> L12
        InputContentInfo r9 = (InputContentInfo) r6.unwrap();
        if (r8 != null) goto L10;
        r8 = new Bundle();
    L11:
        r8.putParcelable(EXTRA_INPUT_CONTENT_INFO, r9);
        goto L16
    L10:
        r8 = new Bundle(r8);
    L12:
        e = move-exception;
        Log.w(LOG_TAG, "Can't insert content from IME; requestPermission() failed", e);
        return false;
    L16:
        if (ViewCompat.performReceiveContent(r5, new ContentInfoCompat.Builder(new ClipData(r6.getDescription(), new ClipData.Item(r6.getContentUri())), 2).setLinkUri(r6.getLinkUri()).setExtras(r8).build()) == null) goto L18;
        return false;
    L18:
        return true;
    }

    public static boolean commitContent(@NonNull InputConnection r3, @NonNull EditorInfo r4, @NonNull InputContentInfoCompat r5, int r6, @Nullable Bundle r7) {
        if (Build.VERSION.SDK_INT >= 25) goto L5;
        int r8 = EditorInfoCompat.getProtocol(r4);
        boolean r1 = false;
        if (r8 != 2) goto L9;
        r1 = true;
    L14:
        Bundle r9 = new Bundle();
        if (r1 == false) goto L17;
        String r0 = COMMIT_CONTENT_CONTENT_URI_INTEROP_KEY;
    L18:
        r9.putParcelable(r0, r5.getContentUri());
        if (r1 == false) goto L21;
        String r2 = COMMIT_CONTENT_DESCRIPTION_INTEROP_KEY;
    L22:
        r9.putParcelable(r2, r5.getDescription());
        if (r1 == false) goto L25;
        String r10 = COMMIT_CONTENT_LINK_URI_INTEROP_KEY;
    L26:
        r9.putParcelable(r10, r5.getLinkUri());
        if (r1 == false) goto L29;
        String r11 = COMMIT_CONTENT_FLAGS_INTEROP_KEY;
    L30:
        r9.putInt(r11, r6);
        if (r1 == false) goto L33;
        String r12 = COMMIT_CONTENT_OPTS_INTEROP_KEY;
    L34:
        r9.putParcelable(r12, r7);
        if (r1 == false) goto L37;
        String r13 = COMMIT_CONTENT_INTEROP_ACTION;
    L39:
        return r3.performPrivateCommand(r13, r9);
    L37:
        r13 = COMMIT_CONTENT_ACTION;
        goto L39
    L33:
        r12 = COMMIT_CONTENT_OPTS_KEY;
        goto L34
    L29:
        r11 = COMMIT_CONTENT_FLAGS_KEY;
        goto L30
    L25:
        r10 = COMMIT_CONTENT_LINK_URI_KEY;
        goto L26
    L21:
        r2 = COMMIT_CONTENT_DESCRIPTION_KEY;
        goto L22
    L17:
        r0 = COMMIT_CONTENT_CONTENT_URI_KEY;
        goto L18
    L9:
        if (r8 == 3) goto L14;
        if (r8 == 4) goto L14;
        return false;
    L5:
        return Api25Impl.commitContent(r3, (InputContentInfo) r5.unwrap(), r6, r7);
    }

    @NonNull
    private static OnCommitContentListener createOnCommitContentListenerUsingPerformReceiveContent(@NonNull final View r1) {
        Preconditions.checkNotNull(r1);
        return new a(r1);
    }

    @NonNull
    public static InputConnection createWrapper(@NonNull View r0, @NonNull InputConnection r1, @NonNull EditorInfo r2) {
        return createWrapper(r1, r2, createOnCommitContentListenerUsingPerformReceiveContent(r0));
    }

    @NonNull
    @Deprecated
    public static InputConnection createWrapper(@NonNull final InputConnection r3, @NonNull EditorInfo r4, @NonNull final OnCommitContentListener r5) {
        ObjectsCompat.requireNonNull(r3, "inputConnection must be non-null");
        ObjectsCompat.requireNonNull(r4, "editorInfo must be non-null");
        ObjectsCompat.requireNonNull(r5, "onCommitContentListener must be non-null");
        final boolean r1 = false;
        if (Build.VERSION.SDK_INT < 25) goto L7;
        return new AnonymousClass1(r3, r1, r5);
    L7:
        if (EditorInfoCompat.getContentMimeTypes(r4).length != 0) goto L10;
        return r3;
    L10:
        return new AnonymousClass2(r3, r1, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    static boolean handlePerformPrivateCommand(@Nullable String r7, @Nullable Bundle r8, @NonNull OnCommitContentListener r9) {
        ?? r0 = 0;
        r0 = 0;
        if (r8 != null) goto L6;
        return false;
    L6:
        if (TextUtils.equals(COMMIT_CONTENT_ACTION, r7) == false) goto L9;
        boolean r10 = false;
    L12:
        if (r10 == false) goto L14;
        String r2 = COMMIT_CONTENT_RESULT_INTEROP_RECEIVER_KEY;
    L52:
        ResultReceiver r3 = (ResultReceiver) r8.getParcelable(r2);     // Catch: Throwable -> L44
        if (r10 == false) goto L18;
        String r4 = COMMIT_CONTENT_CONTENT_URI_INTEROP_KEY;
    L50:
        Uri r5 = (Uri) r8.getParcelable(r4);     // Catch: Throwable -> L42
        if (r10 == false) goto L22;
        String r6 = COMMIT_CONTENT_DESCRIPTION_INTEROP_KEY;
    L23:
        ClipDescription r11 = (ClipDescription) r8.getParcelable(r6);     // Catch: Throwable -> L42
        if (r10 == false) goto L26;
        String r12 = COMMIT_CONTENT_LINK_URI_INTEROP_KEY;
    L27:
        Uri r13 = (Uri) r8.getParcelable(r12);     // Catch: Throwable -> L42
        if (r10 == false) goto L30;
        String r14 = COMMIT_CONTENT_FLAGS_INTEROP_KEY;
    L31:
        int r15 = r8.getInt(r14);     // Catch: Throwable -> L42
        if (r10 == false) goto L34;
        String r16 = COMMIT_CONTENT_OPTS_INTEROP_KEY;
    L35:
        Bundle r17 = (Bundle) r8.getParcelable(r16);     // Catch: Throwable -> L42
        if (r5 == null) goto L39;
        if (r11 == null) goto L39;
        r0 = r9.onCommitContent(new InputContentInfoCompat(r5, r11, r13), r15, r17);     // Catch: Throwable -> L42
    L39:
        if (r3 == 0) goto L41;
        r3.send(r0, null);
    L41:
        return r0;
    L34:
        r16 = COMMIT_CONTENT_OPTS_KEY;
        goto L35
    L30:
        r14 = COMMIT_CONTENT_FLAGS_KEY;
        goto L31
    L26:
        r12 = COMMIT_CONTENT_LINK_URI_KEY;
        goto L27
    L22:
        r6 = COMMIT_CONTENT_DESCRIPTION_KEY;
    L42:
        th = th;
    L46:
        if (r3 == 0) goto L48;
        r3.send(0, null);
    L48:
        throw th;
    L18:
        r4 = COMMIT_CONTENT_CONTENT_URI_KEY;
    L44:
        th = th;
        r3 = 0;
        goto L46
    L14:
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
