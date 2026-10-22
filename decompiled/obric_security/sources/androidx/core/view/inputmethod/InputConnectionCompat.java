package androidx.core.view.inputmethod;

import android.content.ClipData;
import android.content.ClipDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.ViewCompat;

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
    private static final String EXTRA_INPUT_CONTENT_INFO = "androidx.core.view.extra.INPUT_CONTENT_INFO";
    public static final int INPUT_CONTENT_GRANT_READ_URI_PERMISSION = 1;
    private static final String LOG_TAG = "InputConnectionCompat";

    /* JADX INFO: renamed from: androidx.core.view.inputmethod.InputConnectionCompat$2, reason: invalid class name */
    class AnonymousClass2 extends InputConnectionWrapper {
        final /* synthetic */ OnCommitContentListener val$listener;

        AnonymousClass2(InputConnection r1, boolean r2, OnCommitContentListener r3) {
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

    static class Api25Impl {
        private Api25Impl() {
        }

        static boolean commitContent(InputConnection r0, InputContentInfo r1, int r2, Bundle r3) {
            return r0.commitContent(r1, r2, r3);
        }
    }

    public interface OnCommitContentListener {
        boolean onCommitContent(InputContentInfoCompat r1, int r2, Bundle r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    static boolean handlePerformPrivateCommand(String r7, Bundle r8, OnCommitContentListener r9) {
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

    public static boolean commitContent(InputConnection r0, EditorInfo r1, InputContentInfoCompat r2, int r3, Bundle r4) {
        return Api25Impl.commitContent(r0, (InputContentInfo) r2.unwrap(), r3, r4);
    }

    @Deprecated
    public static InputConnection createWrapper(final InputConnection r1, EditorInfo r2, final OnCommitContentListener r3) {
        ObjectsCompat.requireNonNull(r1, "inputConnection must be non-null");
        ObjectsCompat.requireNonNull(r2, "editorInfo must be non-null");
        ObjectsCompat.requireNonNull(r3, "onCommitContentListener must be non-null");
        final boolean r0 = false;
        return new AnonymousClass1(r1, r0, r3);
    }

    public static InputConnection createWrapper(View r0, InputConnection r1, EditorInfo r2) {
        return createWrapper(r1, r2, createOnCommitContentListenerUsingPerformReceiveContent(r0));
    }

    private static OnCommitContentListener createOnCommitContentListenerUsingPerformReceiveContent(final View r1) {
        Preconditions.checkNotNull(r1);
        return new InputConnectionCompat$$ExternalSyntheticLambda0(r1);
    }

    static /* synthetic */ boolean lambda$createOnCommitContentListenerUsingPerformReceiveContent$0(View r5, InputContentInfoCompat r6, int r7, Bundle r8) {
        if ((r7 & 1) == 0) goto L14;
        r6.requestPermission();     // Catch: Exception -> L10
        InputContentInfo r9 = (InputContentInfo) r6.unwrap();
        if (r8 != null) goto L8;
        r8 = new Bundle();
    L9:
        r8.putParcelable(EXTRA_INPUT_CONTENT_INFO, r9);
        goto L14
    L8:
        r8 = new Bundle(r8);
    L10:
        e = move-exception;
        Log.w(LOG_TAG, "Can't insert content from IME; requestPermission() failed", e);
        return false;
    L14:
        if (ViewCompat.performReceiveContent(r5, new ContentInfoCompat.Builder(new ClipData(r6.getDescription(), new ClipData.Item(r6.getContentUri())), 2).setLinkUri(r6.getLinkUri()).setExtras(r8).build()) != null) goto L17;
        return true;
    L17:
        return false;
    }

    @Deprecated
    public InputConnectionCompat() {
    }
}
