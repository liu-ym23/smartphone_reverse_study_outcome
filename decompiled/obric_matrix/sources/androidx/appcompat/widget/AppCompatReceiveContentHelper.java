package androidx.appcompat.widget;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.text.Selection;
import android.text.Spannable;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
final class AppCompatReceiveContentHelper {
    private static final String LOG_TAG = "ReceiveContent";

    @RequiresApi(24)
    private static final class OnDropApi24Impl {
        private OnDropApi24Impl() {
        }

        @DoNotInline
        static boolean onDropForTextView(@NonNull DragEvent r1, @NonNull TextView r2, @NonNull Activity r3) {
            r3.requestDragAndDropPermissions(r1);
            int r4 = r2.getOffsetForPosition(r1.getX(), r1.getY());
            r2.beginBatchEdit();
            Selection.setSelection((Spannable) r2.getText(), r4);     // Catch: Throwable -> L6
            ViewCompat.performReceiveContent(r2, new ContentInfoCompat.Builder(r1.getClipData(), 3).build());     // Catch: Throwable -> L6
            r2.endBatchEdit();
            return true;
        L6:
            th = move-exception;
            r2.endBatchEdit();
            throw th;
        }

        @DoNotInline
        static boolean onDropForView(@NonNull DragEvent r1, @NonNull View r2, @NonNull Activity r3) {
            r3.requestDragAndDropPermissions(r1);
            ViewCompat.performReceiveContent(r2, new ContentInfoCompat.Builder(r1.getClipData(), 3).build());
            return true;
        }
    }

    private AppCompatReceiveContentHelper() {
    }

    static boolean maybeHandleDragEventViaPerformReceiveContent(@NonNull View r4, @NonNull DragEvent r5) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 31) goto L5;
    L26:
        return false;
    L5:
        if (r0 < 24) goto L26;
        if (r5.getLocalState() != null) goto L26;
        if (ViewCompat.getOnReceiveContentMimeTypes(r4) == null) goto L26;
        Activity r1 = tryGetActivity(r4);
        if (r1 != null) goto L16;
        Log.i(LOG_TAG, "Can't handle drop: no activity: view=" + r4);
        return false;
    L16:
        if (r5.getAction() != 1) goto L20;
        return !(r4 instanceof TextView);
    L20:
        if (r5.getAction() != 3) goto L26;
        if ((r4 instanceof TextView) == false) goto L25;
        return OnDropApi24Impl.onDropForTextView(r5, (TextView) r4, r1);
    L25:
        return OnDropApi24Impl.onDropForView(r5, r4, r1);
    }

    static boolean maybeHandleMenuActionViaPerformReceiveContent(@NonNull TextView r5, int r6) {
        int r1 = 0;
        if (Build.VERSION.SDK_INT < 31) goto L5;
    L25:
        return false;
    L5:
        if (ViewCompat.getOnReceiveContentMimeTypes(r5) == null) goto L25;
        if (r6 != 16908322) goto L9;
    L11:
        ClipboardManager r2 = (ClipboardManager) r5.getContext().getSystemService("clipboard");
        if (r2 != null) goto L14;
        ClipData r3 = null;
    L16:
        if (r3 != null) goto L18;
    L24:
        return true;
    L18:
        if (r3.getItemCount() <= 0) goto L24;
        ContentInfoCompat.Builder r4 = new ContentInfoCompat.Builder(r3, 1);
        if (r6 == 16908322) goto L23;
        r1 = 1;
    L23:
        ViewCompat.performReceiveContent(r5, r4.setFlags(r1).build());
        goto L24
    L14:
        r3 = r2.getPrimaryClip();
        goto L16
    L9:
        if (r6 == 16908337) goto L11;
        goto L11
    }

    @Nullable
    static Activity tryGetActivity(@NonNull View r1) {
        Context r2 = r1.getContext();
    L4:
        if ((r2 instanceof ContextWrapper) == false) goto L10;
        if ((r2 instanceof Activity) == true) goto L8;
        r2 = ((ContextWrapper) r2).getBaseContext();
        goto L4
    L8:
        return (Activity) r2;
    L10:
        return null;
    }
}
