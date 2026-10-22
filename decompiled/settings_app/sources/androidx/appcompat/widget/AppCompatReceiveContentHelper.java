package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.text.Selection;
import android.text.Spannable;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
final class AppCompatReceiveContentHelper {
    private static final String LOG_TAG = "ReceiveContent";

    private static final class OnDropApi24Impl {
        private OnDropApi24Impl() {
        }

        static boolean onDropForTextView(DragEvent r1, TextView r2, Activity r3) {
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

        static boolean onDropForView(DragEvent r1, View r2, Activity r3) {
            r3.requestDragAndDropPermissions(r1);
            ViewCompat.performReceiveContent(r2, new ContentInfoCompat.Builder(r1.getClipData(), 3).build());
            return true;
        }
    }

    static boolean maybeHandleDragEventViaPerformReceiveContent(View r0, DragEvent r1) {
        return false;
    }

    static boolean maybeHandleMenuActionViaPerformReceiveContent(TextView r0, int r1) {
        return false;
    }

    private AppCompatReceiveContentHelper() {
    }

    static Activity tryGetActivity(View r1) {
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
