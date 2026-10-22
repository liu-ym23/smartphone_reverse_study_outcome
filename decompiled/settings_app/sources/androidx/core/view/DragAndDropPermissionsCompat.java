package androidx.core.view;

import android.app.Activity;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;

/* JADX INFO: loaded from: classes.dex */
public final class DragAndDropPermissionsCompat {
    private final DragAndDropPermissions mDragAndDropPermissions;

    static class Api24Impl {
        private Api24Impl() {
        }

        static DragAndDropPermissions requestDragAndDropPermissions(Activity r0, DragEvent r1) {
            return r0.requestDragAndDropPermissions(r1);
        }

        static void release(DragAndDropPermissions r0) {
            r0.release();
        }
    }

    private DragAndDropPermissionsCompat(DragAndDropPermissions r1) {
        this.mDragAndDropPermissions = r1;
    }

    public static DragAndDropPermissionsCompat request(Activity r0, DragEvent r1) {
        DragAndDropPermissions r2 = Api24Impl.requestDragAndDropPermissions(r0, r1);
        if (r2 != null) goto L5;
        return null;
    L5:
        return new DragAndDropPermissionsCompat(r2);
    }

    public void release() {
        Api24Impl.release(this.mDragAndDropPermissions);
    }
}
