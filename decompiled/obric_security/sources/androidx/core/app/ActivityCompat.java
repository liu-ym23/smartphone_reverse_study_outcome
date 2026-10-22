package androidx.core.app;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.LocusId;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.Display;
import android.view.DragEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.content.LocusIdCompat;
import androidx.core.os.BuildCompat;
import androidx.core.view.DragAndDropPermissionsCompat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ActivityCompat extends ContextCompat {
    private static PermissionCompatDelegate sDelegate;

    /* JADX INFO: renamed from: androidx.core.app.ActivityCompat$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ Activity val$activity;
        final /* synthetic */ String[] val$permissionsArray;
        final /* synthetic */ int val$requestCode;

        AnonymousClass1(String[] r1, Activity r2, int r3) {
            this.val$permissionsArray = r1;
            this.val$activity = r2;
            this.val$requestCode = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            int[] r0 = new int[this.val$permissionsArray.length];
            PackageManager r1 = this.val$activity.getPackageManager();
            String r2 = this.val$activity.getPackageName();
            int r3 = this.val$permissionsArray.length;
            int r4 = 0;
        L3:
            if (r4 >= r3) goto L5;
            r0[r4] = r1.checkPermission(this.val$permissionsArray[r4], r2);
            r4 = r4 + 1;
            goto L3
        L5:
            ((OnRequestPermissionsResultCallback) this.val$activity).onRequestPermissionsResult(this.val$requestCode, this.val$permissionsArray, r0);
        }
    }

    static class Api16Impl {
        private Api16Impl() {
        }

        static void startActivityForResult(Activity r0, Intent r1, int r2, Bundle r3) {
            r0.startActivityForResult(r1, r2, r3);
        }

        static void startIntentSenderForResult(Activity r0, IntentSender r1, int r2, Intent r3, int r4, int r5, int r6, Bundle r7) throws IntentSender.SendIntentException {
            r0.startIntentSenderForResult(r1, r2, r3, r4, r5, r6, r7);
        }

        static void finishAffinity(Activity r0) {
            r0.finishAffinity();
        }
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static void finishAfterTransition(Activity r0) {
            r0.finishAfterTransition();
        }

        static void setEnterSharedElementCallback(Activity r0, android.app.SharedElementCallback r1) {
            r0.setEnterSharedElementCallback(r1);
        }

        static void setExitSharedElementCallback(Activity r0, android.app.SharedElementCallback r1) {
            r0.setExitSharedElementCallback(r1);
        }

        static void postponeEnterTransition(Activity r0) {
            r0.postponeEnterTransition();
        }

        static void startPostponedEnterTransition(Activity r0) {
            r0.startPostponedEnterTransition();
        }
    }

    static class Api22Impl {
        private Api22Impl() {
        }

        static Uri getReferrer(Activity r0) {
            return r0.getReferrer();
        }
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static void requestPermissions(Activity r0, String[] r1, int r2) {
            r0.requestPermissions(r1, r2);
        }

        static boolean shouldShowRequestPermissionRationale(Activity r0, String r1) {
            return r0.shouldShowRequestPermissionRationale(r1);
        }

        static void onSharedElementsReady(Object r0) {
            ((android.app.SharedElementCallback.OnSharedElementsReadyListener) r0).onSharedElementsReady();
        }
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static <T> T requireViewById(Activity r0, int r1) {
            return (T) r0.requireViewById(r1);
        }
    }

    static class Api30Impl {
        private Api30Impl() {
        }

        static void setLocusContext(Activity r0, LocusIdCompat r1, Bundle r2) {
            if (r1 != null) goto L4;
            LocusId r3 = null;
        L5:
            r0.setLocusContext(r3, r2);
            return;
        L4:
            r3 = r1.toLocusId();
            goto L5
        }

        static Display getDisplay(ContextWrapper r0) {
            return r0.getDisplay();
        }
    }

    static class Api31Impl {
        private Api31Impl() {
        }

        static boolean isLaunchedFromBubble(Activity r0) {
            return r0.isLaunchedFromBubble();
        }
    }

    public interface OnRequestPermissionsResultCallback {
        void onRequestPermissionsResult(int r1, String[] r2, int[] r3);
    }

    public interface PermissionCompatDelegate {
        boolean onActivityResult(Activity r1, int r2, int r3, Intent r4);

        boolean requestPermissions(Activity r1, String[] r2, int r3);
    }

    public interface RequestPermissionsRequestCodeValidator {
        void validateRequestPermissionsRequestCode(int r1);
    }

    static class SharedElementCallback21Impl extends android.app.SharedElementCallback {
        private final SharedElementCallback mCallback;

        SharedElementCallback21Impl(SharedElementCallback r1) {
            this.mCallback = r1;
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementStart(List<String> r1, List<View> r2, List<View> r3) {
            this.mCallback.onSharedElementStart(r1, r2, r3);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementEnd(List<String> r1, List<View> r2, List<View> r3) {
            this.mCallback.onSharedElementEnd(r1, r2, r3);
        }

        @Override // android.app.SharedElementCallback
        public void onRejectSharedElements(List<View> r1) {
            this.mCallback.onRejectSharedElements(r1);
        }

        @Override // android.app.SharedElementCallback
        public void onMapSharedElements(List<String> r1, Map<String, View> r2) {
            this.mCallback.onMapSharedElements(r1, r2);
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
        public void onSharedElementsArrived(List<String> r2, List<View> r3, final android.app.SharedElementCallback.OnSharedElementsReadyListener r4) {
            this.mCallback.onSharedElementsArrived(r2, r3, new ActivityCompat$SharedElementCallback21Impl$$ExternalSyntheticLambda0(r4));
        }

        static /* synthetic */ void lambda$onSharedElementsArrived$0(android.app.SharedElementCallback.OnSharedElementsReadyListener r0) {
            Api23Impl.onSharedElementsReady(r0);
        }
    }

    protected ActivityCompat() {
    }

    public static void setPermissionCompatDelegate(PermissionCompatDelegate r0) {
        sDelegate = r0;
    }

    public static PermissionCompatDelegate getPermissionCompatDelegate() {
        return sDelegate;
    }

    @Deprecated
    public static boolean invalidateOptionsMenu(Activity r0) {
        r0.invalidateOptionsMenu();
        return true;
    }

    public static void startActivityForResult(Activity r0, Intent r1, int r2, Bundle r3) {
        Api16Impl.startActivityForResult(r0, r1, r2, r3);
    }

    public static void startIntentSenderForResult(Activity r0, IntentSender r1, int r2, Intent r3, int r4, int r5, int r6, Bundle r7) throws IntentSender.SendIntentException {
        Api16Impl.startIntentSenderForResult(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    public static void finishAffinity(Activity r0) {
        Api16Impl.finishAffinity(r0);
    }

    public static void finishAfterTransition(Activity r0) {
        Api21Impl.finishAfterTransition(r0);
    }

    public static Uri getReferrer(Activity r0) {
        return Api22Impl.getReferrer(r0);
    }

    public static <T extends View> T requireViewById(Activity r0, int r1) {
        return (T) Api28Impl.requireViewById(r0, r1);
    }

    public static void setEnterSharedElementCallback(Activity r1, SharedElementCallback r2) {
        if (r2 == null) goto L4;
        SharedElementCallback21Impl r0 = new SharedElementCallback21Impl(r2);
    L5:
        Api21Impl.setEnterSharedElementCallback(r1, r0);
        return;
    L4:
        r0 = null;
        goto L5
    }

    public static void setExitSharedElementCallback(Activity r1, SharedElementCallback r2) {
        if (r2 == null) goto L4;
        SharedElementCallback21Impl r0 = new SharedElementCallback21Impl(r2);
    L5:
        Api21Impl.setExitSharedElementCallback(r1, r0);
        return;
    L4:
        r0 = null;
        goto L5
    }

    public static void postponeEnterTransition(Activity r0) {
        Api21Impl.postponeEnterTransition(r0);
    }

    public static void startPostponedEnterTransition(Activity r0) {
        Api21Impl.startPostponedEnterTransition(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void requestPermissions(Activity r6, String[] r7, int r8) {
        PermissionCompatDelegate r0 = sDelegate;
        if (r0 != null) goto L5;
    L7:
        HashSet r1 = new HashSet();
        int r2 = 0;
        int r3 = 0;
    L9:
        if (r3 >= r7.length) goto L20;
        if (TextUtils.isEmpty(r7[r3]) == true) goto L19;
        if (BuildCompat.isAtLeastT() == true) goto L17;
        if (TextUtils.equals(r7[r3], "android.permission.POST_NOTIFICATIONS") == false) goto L17;
        r1.add(Integer.valueOf(r3));
    L17:
        r3 = r3 + 1;
        goto L9
    L19:
        throw new IllegalArgumentException("Permission request for permissions " + Arrays.toString(r7) + " must not contain null or empty values");
    L20:
        int r4 = r1.size();
        if (r4 <= 0) goto L23;
        String[] r5 = new String[r7.length - r4];
    L24:
        if (r4 <= 0) goto L36;
        if (r4 != r7.length) goto L28;
        return;
    L28:
        int r9 = 0;
    L30:
        if (r2 >= r7.length) goto L36;
        if (r1.contains(Integer.valueOf(r2)) == true) goto L34;
        r5[r9] = r7[r2];
        r9 = r9 + 1;
    L34:
        r2 = r2 + 1;
    L36:
        if ((r6 instanceof RequestPermissionsRequestCodeValidator) == false) goto L38;
        ((RequestPermissionsRequestCodeValidator) r6).validateRequestPermissionsRequestCode(r8);
    L38:
        Api23Impl.requestPermissions(r6, r7, r8);
        return;
    L23:
        r5 = r7;
        goto L24
    L5:
        if (r0.requestPermissions(r6, r7, r8) == false) goto L7;
    }

    public static boolean shouldShowRequestPermissionRationale(Activity r1, String r2) {
        if (BuildCompat.isAtLeastT() == true) goto L9;
        if (TextUtils.equals("android.permission.POST_NOTIFICATIONS", r2) == false) goto L9;
        return false;
    L9:
        return Api23Impl.shouldShowRequestPermissionRationale(r1, r2);
    }

    public static boolean isLaunchedFromBubble(Activity r3) {
        if (Build.VERSION.SDK_INT < 31) goto L7;
        return Api31Impl.isLaunchedFromBubble(r3);
    L7:
        if (Build.VERSION.SDK_INT == 30) goto L9;
        return false;
    L9:
        if (Api30Impl.getDisplay(r3) != null) goto L11;
        return false;
    L11:
        if (Api30Impl.getDisplay(r3).getDisplayId() == 0) goto L16;
        return true;
    L16:
        return false;
    }

    public static DragAndDropPermissionsCompat requestDragAndDropPermissions(Activity r0, DragEvent r1) {
        return DragAndDropPermissionsCompat.request(r0, r1);
    }

    public static void recreate(Activity r0) {
        r0.recreate();
    }

    static /* synthetic */ void lambda$recreate$0(Activity r1) {
        if (r1.isFinishing() == false) goto L5;
        return;
    L5:
        if (ActivityRecreator.recreate(r1) == true) goto L9;
        r1.recreate();
        return;
    }

    public static void setLocusContext(Activity r0, LocusIdCompat r1, Bundle r2) {
        Api30Impl.setLocusContext(r0, r1, r2);
    }
}
