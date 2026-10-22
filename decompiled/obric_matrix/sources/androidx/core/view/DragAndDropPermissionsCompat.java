package androidx.core.view;

import android.app.Activity;
import android.os.Build;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
public final class DragAndDropPermissionsCompat {
    private final DragAndDropPermissions mDragAndDropPermissions;

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static void release(DragAndDropPermissions r0) {
            r0.release();
        }

        @DoNotInline
        static DragAndDropPermissions requestDragAndDropPermissions(Activity r0, DragEvent r1) {
            return r0.requestDragAndDropPermissions(r1);
        }
    }

    private DragAndDropPermissionsCompat(DragAndDropPermissions r1) {
        this.mDragAndDropPermissions = r1;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static DragAndDropPermissionsCompat request(@NonNull Activity r2, @NonNull DragEvent r3) {
        if (Build.VERSION.SDK_INT < 24) goto L8;
        DragAndDropPermissions r4 = Api24Impl.requestDragAndDropPermissions(r2, r3);
        if (r4 != null) goto L7;
        return null;
    L7:
        return new DragAndDropPermissionsCompat(r4);
    L8:
        return null;
    }

    public void release() {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        Api24Impl.release(this.mDragAndDropPermissions);
        return;
    }
}
