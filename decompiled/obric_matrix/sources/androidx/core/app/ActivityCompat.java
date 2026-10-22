package androidx.core.app;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.LocusId;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.Display;
import android.view.DragEvent;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.IdRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
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

    @RequiresApi(16)
    static class Api16Impl {
        private Api16Impl() {
        }

        @DoNotInline
        static void finishAffinity(Activity r0) {
            r0.finishAffinity();
        }

        @DoNotInline
        static void startActivityForResult(Activity r0, Intent r1, int r2, Bundle r3) {
            r0.startActivityForResult(r1, r2, r3);
        }

        @DoNotInline
        static void startIntentSenderForResult(Activity r0, IntentSender r1, int r2, Intent r3, int r4, int r5, int r6, Bundle r7) {
            r0.startIntentSenderForResult(r1, r2, r3, r4, r5, r6, r7);
        }
    }

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static void finishAfterTransition(Activity r0) {
            r0.finishAfterTransition();
        }

        @DoNotInline
        static void postponeEnterTransition(Activity r0) {
            r0.postponeEnterTransition();
        }

        @DoNotInline
        static void setEnterSharedElementCallback(Activity r0, android.app.SharedElementCallback r1) {
            r0.setEnterSharedElementCallback(r1);
        }

        @DoNotInline
        static void setExitSharedElementCallback(Activity r0, android.app.SharedElementCallback r1) {
            r0.setExitSharedElementCallback(r1);
        }

        @DoNotInline
        static void startPostponedEnterTransition(Activity r0) {
            r0.startPostponedEnterTransition();
        }
    }

    @RequiresApi(22)
    static class Api22Impl {
        private Api22Impl() {
        }

        @DoNotInline
        static Uri getReferrer(Activity r0) {
            return r0.getReferrer();
        }
    }

    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static void onSharedElementsReady(Object r0) {
            ((android.app.SharedElementCallback.OnSharedElementsReadyListener) r0).onSharedElementsReady();
        }

        @DoNotInline
        static void requestPermissions(Activity r0, String[] r1, int r2) {
            r0.requestPermissions(r1, r2);
        }

        @DoNotInline
        static boolean shouldShowRequestPermissionRationale(Activity r0, String r1) {
            return r0.shouldShowRequestPermissionRationale(r1);
        }
    }

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static <T> T requireViewById(Activity r0, int r1) {
            return (T) r0.requireViewById(r1);
        }
    }

    @RequiresApi(30)
    static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        static Display getDisplay(ContextWrapper r0) {
            return r0.getDisplay();
        }

        @DoNotInline
        static void setLocusContext(@NonNull Activity r0, @Nullable LocusIdCompat r1, @Nullable Bundle r2) {
            if (r1 != null) goto L4;
            LocusId r3 = null;
        L5:
            r0.setLocusContext(r3, r2);
            return;
        L4:
            r3 = r1.toLocusId();
            goto L5
        }
    }

    @RequiresApi(31)
    static class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        static boolean isLaunchedFromBubble(@NonNull Activity r0) {
            return r0.isLaunchedFromBubble();
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
    static class SharedElementCallback21Impl extends android.app.SharedElementCallback {
        private final SharedElementCallback mCallback;

        SharedElementCallback21Impl(SharedElementCallback r1) {
            this.mCallback = r1;
        }

        static /* synthetic */ void a(android.app.SharedElementCallback.OnSharedElementsReadyListener r0) {
            Api23Impl.onSharedElementsReady(r0);
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
        public void onSharedElementsArrived(List<String> r2, List<View> r3, final android.app.SharedElementCallback.OnSharedElementsReadyListener r4) {
            this.mCallback.onSharedElementsArrived(r2, r3, new a(r4));
        }
    }

    protected ActivityCompat() {
    }

    static /* synthetic */ void a(Activity r1) {
        if (r1.isFinishing() == false) goto L5;
        return;
    L5:
        if (ActivityRecreator.recreate(r1) == true) goto L9;
        r1.recreate();
        return;
    }

    public static void finishAffinity(@NonNull Activity r2) {
        if (Build.VERSION.SDK_INT < 16) goto L5;
        Api16Impl.finishAffinity(r2);
        return;
    L5:
        r2.finish();
    }

    public static void finishAfterTransition(@NonNull Activity r2) {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        Api21Impl.finishAfterTransition(r2);
        return;
    L5:
        r2.finish();
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static PermissionCompatDelegate getPermissionCompatDelegate() {
        return sDelegate;
    }

    @Nullable
    public static Uri getReferrer(@NonNull Activity r2) {
        if (Build.VERSION.SDK_INT >= 22) goto L5;
        Intent r3 = r2.getIntent();
        Uri r0 = (Uri) r3.getParcelableExtra("android.intent.extra.REFERRER");
        if (r0 == null) goto L9;
        return r0;
    L9:
        String r4 = r3.getStringExtra("android.intent.extra.REFERRER_NAME");
        if (r4 != null) goto L12;
        return null;
    L12:
        return Uri.parse(r4);
    L5:
        return Api22Impl.getReferrer(r2);
    }

    @Deprecated
    public static boolean invalidateOptionsMenu(Activity r0) {
        r0.invalidateOptionsMenu();
        return true;
    }

    public static boolean isLaunchedFromBubble(@NonNull Activity r4) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 31) goto L7;
        return Api31Impl.isLaunchedFromBubble(r4);
    L7:
        if (r0 != 30) goto L16;
        if (Api30Impl.getDisplay(r4) == null) goto L14;
        if (Api30Impl.getDisplay(r4).getDisplayId() == 0) goto L14;
        return true;
    L14:
        return false;
    L16:
        if (r0 == 29) goto L18;
        return false;
    L18:
        if (r4.getWindowManager().getDefaultDisplay() == null) goto L23;
        if (r4.getWindowManager().getDefaultDisplay().getDisplayId() == 0) goto L23;
        return true;
    L23:
        return false;
    }

    public static void postponeEnterTransition(@NonNull Activity r2) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.postponeEnterTransition(r2);
        return;
    }

    public static void recreate(@NonNull final Activity r2) {
        if (Build.VERSION.SDK_INT < 28) goto L5;
        r2.recreate();
        return;
    L5:
        new Handler(r2.getMainLooper()).post(new b(r2));
    }

    @Nullable
    public static DragAndDropPermissionsCompat requestDragAndDropPermissions(@NonNull Activity r0, @NonNull DragEvent r1) {
        return DragAndDropPermissionsCompat.request(r0, r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public static void requestPermissions(@NonNull final Activity r6, @NonNull String[] r7, @IntRange(from = 0) final int r8) {
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
        final String[] r5 = new String[r7.length - r4];
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
        if (Build.VERSION.SDK_INT < 23) goto L42;
        if ((r6 instanceof RequestPermissionsRequestCodeValidator) == false) goto L40;
        ((RequestPermissionsRequestCodeValidator) r6).validateRequestPermissionsRequestCode(r8);
    L40:
        Api23Impl.requestPermissions(r6, r7, r8);
        return;
    L42:
        if ((r6 instanceof OnRequestPermissionsResultCallback) == false) goto L54;
        new Handler(Looper.getMainLooper()).post(new AnonymousClass1(r5, r6, r8));
        return;
    L54:
        return;
    L23:
        r5 = r7;
        goto L24
    L5:
        if (r0.requestPermissions(r6, r7, r8) == false) goto L7;
    }

    @NonNull
    public static <T extends View> T requireViewById(@NonNull Activity r2, @IdRes int r3) {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        T r4 = (T) r2.findViewById(r3);
        if (r4 == null) goto L10;
        return r4;
    L10:
        throw new IllegalArgumentException("ID does not reference a View inside this Activity");
    L5:
        return (T) Api28Impl.requireViewById(r2, r3);
    }

    public static void setEnterSharedElementCallback(@NonNull Activity r2, @Nullable SharedElementCallback r3) {
        if (Build.VERSION.SDK_INT < 21) goto L9;
        if (r3 == null) goto L6;
        SharedElementCallback21Impl r0 = new SharedElementCallback21Impl(r3);
    L7:
        Api21Impl.setEnterSharedElementCallback(r2, r0);
        return;
    L6:
        r0 = null;
        goto L7
    }

    public static void setExitSharedElementCallback(@NonNull Activity r2, @Nullable SharedElementCallback r3) {
        if (Build.VERSION.SDK_INT < 21) goto L9;
        if (r3 == null) goto L6;
        SharedElementCallback21Impl r0 = new SharedElementCallback21Impl(r3);
    L7:
        Api21Impl.setExitSharedElementCallback(r2, r0);
        return;
    L6:
        r0 = null;
        goto L7
    }

    public static void setLocusContext(@NonNull Activity r2, @Nullable LocusIdCompat r3, @Nullable Bundle r4) {
        if (Build.VERSION.SDK_INT < 30) goto L6;
        Api30Impl.setLocusContext(r2, r3, r4);
        return;
    }

    public static void setPermissionCompatDelegate(@Nullable PermissionCompatDelegate r0) {
        sDelegate = r0;
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public static boolean shouldShowRequestPermissionRationale(@NonNull Activity r3, @NonNull String r4) {
        if (BuildCompat.isAtLeastT() == true) goto L8;
        if (TextUtils.equals("android.permission.POST_NOTIFICATIONS", r4) == false) goto L8;
        return false;
    L8:
        if (Build.VERSION.SDK_INT >= 23) goto L10;
        return false;
    L10:
        return Api23Impl.shouldShowRequestPermissionRationale(r3, r4);
    }

    public static void startActivityForResult(@NonNull Activity r2, @NonNull Intent r3, int r4, @Nullable Bundle r5) {
        if (Build.VERSION.SDK_INT < 16) goto L5;
        Api16Impl.startActivityForResult(r2, r3, r4, r5);
        return;
    L5:
        r2.startActivityForResult(r3, r4);
    }

    public static void startIntentSenderForResult(@NonNull Activity r2, @NonNull IntentSender r3, int r4, @Nullable Intent r5, int r6, int r7, int r8, @Nullable Bundle r9) {
        if (Build.VERSION.SDK_INT < 16) goto L5;
        Api16Impl.startIntentSenderForResult(r2, r3, r4, r5, r6, r7, r8, r9);
        return;
    L5:
        r2.startIntentSenderForResult(r3, r4, r5, r6, r7, r8);
    }

    public static void startPostponedEnterTransition(@NonNull Activity r2) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.startPostponedEnterTransition(r2);
        return;
    }
}
