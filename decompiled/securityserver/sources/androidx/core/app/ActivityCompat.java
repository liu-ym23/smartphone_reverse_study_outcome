package androidx.core.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.DragEvent;
import android.view.View;
import androidx.annotation.IdRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.core.view.DragAndDropPermissionsCompat;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ActivityCompat extends ContextCompat {
    private static PermissionCompatDelegate sDelegate;

    /* JADX INFO: renamed from: androidx.core.app.ActivityCompat$1, reason: invalid class name */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ Activity val$activity;
        final /* synthetic */ String[] val$permissions;
        final /* synthetic */ int val$requestCode;

        public AnonymousClass1(String[] r1, Activity r2, int r3) {
            this.val$permissions = r1;
            this.val$activity = r2;
            this.val$requestCode = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            int[] r0 = new int[this.val$permissions.length];
            PackageManager r1 = this.val$activity.getPackageManager();
            String r2 = this.val$activity.getPackageName();
            int r3 = this.val$permissions.length;
            int r4 = 0;
        L3:
            if (r4 >= r3) goto L5;
            r0[r4] = r1.checkPermission(this.val$permissions[r4], r2);
            r4 = r4 + 1;
            goto L3
        L5:
            ((OnRequestPermissionsResultCallback) this.val$activity).onRequestPermissionsResult(this.val$requestCode, this.val$permissions, r0);
        }
    }

    /* JADX INFO: renamed from: androidx.core.app.ActivityCompat$2, reason: invalid class name */
    public class AnonymousClass2 implements Runnable {
        final /* synthetic */ Activity val$activity;

        public AnonymousClass2(Activity r1) {
            this.val$activity = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.val$activity.isFinishing() == false) goto L5;
            return;
        L5:
            if (ActivityRecreator.recreate(this.val$activity) == true) goto L9;
            this.val$activity.recreate();
            return;
        }
    }

    public interface OnRequestPermissionsResultCallback {
        void onRequestPermissionsResult(int r1, @NonNull String[] r2, @NonNull int[] r3);
    }

    public interface PermissionCompatDelegate {
        boolean onActivityResult(@NonNull Activity r1, @IntRange(from = 0) int r2, int r3, @Nullable Intent r4);

        boolean requestPermissions(@NonNull Activity r1, @NonNull String[] r2, @IntRange(from = 0) int r3);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface RequestPermissionsRequestCodeValidator {
        void validateRequestPermissionsRequestCode(int r1);
    }

    @RequiresApi(21)
    public static class SharedElementCallback21Impl extends android.app.SharedElementCallback {
        private final SharedElementCallback mCallback;

        public SharedElementCallback21Impl(SharedElementCallback r1) {
            this.mCallback = r1;
        }

        @Override // android.app.SharedElementCallback
        public Parcelable onCaptureSharedElementSnapshot(View r1, Matrix r2, RectF r3) {
            return this.mCallback.onCaptureSharedElementSnapshot(r1, r2, r3);
        }

        @Override // android.app.SharedElementCallback
        public View onCreateSnapshotView(Context r1, Parcelable r2) {
            return this.mCallback.onCreateSnapshotView(r1, r2);
        }

        @Override // android.app.SharedElementCallback
        public void onMapSharedElements(List<String> r1, Map<String, View> r2) {
            this.mCallback.onMapSharedElements(r1, r2);
        }

        @Override // android.app.SharedElementCallback
        public void onRejectSharedElements(List<View> r1) {
            this.mCallback.onRejectSharedElements(r1);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementEnd(List<String> r1, List<View> r2, List<View> r3) {
            this.mCallback.onSharedElementEnd(r1, r2, r3);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementStart(List<String> r1, List<View> r2, List<View> r3) {
            this.mCallback.onSharedElementStart(r1, r2, r3);
        }

        @Override // android.app.SharedElementCallback
        @RequiresApi(23)
        public void onSharedElementsArrived(List<String> r3, List<View> r4, final android.app.SharedElementCallback.OnSharedElementsReadyListener r5) {
            this.mCallback.onSharedElementsArrived(r3, r4, new AnonymousClass1(this, r5));
        }
    }

    public ActivityCompat() {
    }

    public static void finishAffinity(@NonNull Activity r0) {
        r0.finishAffinity();
    }

    public static void finishAfterTransition(@NonNull Activity r0) {
        r0.finishAfterTransition();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static PermissionCompatDelegate getPermissionCompatDelegate() {
        return sDelegate;
    }

    @Nullable
    public static Uri getReferrer(@NonNull Activity r0) {
        return r0.getReferrer();
    }

    @Deprecated
    public static boolean invalidateOptionsMenu(Activity r0) {
        r0.invalidateOptionsMenu();
        return true;
    }

    public static void postponeEnterTransition(@NonNull Activity r0) {
        r0.postponeEnterTransition();
    }

    public static void recreate(@NonNull Activity r0) {
        r0.recreate();
    }

    @Nullable
    public static DragAndDropPermissionsCompat requestDragAndDropPermissions(Activity r0, DragEvent r1) {
        return DragAndDropPermissionsCompat.request(r0, r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void requestPermissions(@NonNull Activity r1, @NonNull String[] r2, @IntRange(from = 0) int r3) {
        PermissionCompatDelegate r0 = sDelegate;
        if (r0 == null) goto L8;
        if (r0.requestPermissions(r1, r2, r3) == false) goto L8;
        return;
    L8:
        if ((r1 instanceof RequestPermissionsRequestCodeValidator) == false) goto L10;
        ((RequestPermissionsRequestCodeValidator) r1).validateRequestPermissionsRequestCode(r3);
    L10:
        r1.requestPermissions(r2, r3);
    }

    @NonNull
    public static <T extends View> T requireViewById(@NonNull Activity r0, @IdRes int r1) {
        return (T) r0.requireViewById(r1);
    }

    public static void setEnterSharedElementCallback(@NonNull Activity r1, @Nullable SharedElementCallback r2) {
        if (r2 == null) goto L4;
        SharedElementCallback21Impl r0 = new SharedElementCallback21Impl(r2);
    L5:
        r1.setEnterSharedElementCallback(r0);
        return;
    L4:
        r0 = null;
        goto L5
    }

    public static void setExitSharedElementCallback(@NonNull Activity r1, @Nullable SharedElementCallback r2) {
        if (r2 == null) goto L4;
        SharedElementCallback21Impl r0 = new SharedElementCallback21Impl(r2);
    L5:
        r1.setExitSharedElementCallback(r0);
        return;
    L4:
        r0 = null;
        goto L5
    }

    public static void setPermissionCompatDelegate(@Nullable PermissionCompatDelegate r0) {
        sDelegate = r0;
    }

    public static boolean shouldShowRequestPermissionRationale(@NonNull Activity r0, @NonNull String r1) {
        return r0.shouldShowRequestPermissionRationale(r1);
    }

    public static void startActivityForResult(@NonNull Activity r0, @NonNull Intent r1, int r2, @Nullable Bundle r3) {
        r0.startActivityForResult(r1, r2, r3);
    }

    public static void startIntentSenderForResult(@NonNull Activity r0, @NonNull IntentSender r1, int r2, @Nullable Intent r3, int r4, int r5, int r6, @Nullable Bundle r7) {
        r0.startIntentSenderForResult(r1, r2, r3, r4, r5, r6, r7);
    }

    public static void startPostponedEnterTransition(@NonNull Activity r0) {
        r0.startPostponedEnterTransition();
    }
}
