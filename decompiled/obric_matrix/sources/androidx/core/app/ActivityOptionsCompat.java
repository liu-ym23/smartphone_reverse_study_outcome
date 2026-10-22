package androidx.core.app;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public class ActivityOptionsCompat {
    public static final String EXTRA_USAGE_TIME_REPORT = "android.activity.usage_time";
    public static final String EXTRA_USAGE_TIME_REPORT_PACKAGES = "android.usage_time_packages";

    @RequiresApi(16)
    private static class ActivityOptionsCompatImpl extends ActivityOptionsCompat {
        private final ActivityOptions mActivityOptions;

        ActivityOptionsCompatImpl(ActivityOptions r1) {
            this.mActivityOptions = r1;
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        public Rect getLaunchBounds() {
            if (Build.VERSION.SDK_INT >= 24) goto L7;
            return null;
        L7:
            return Api24Impl.getLaunchBounds(this.mActivityOptions);
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        public void requestUsageTimeReport(@NonNull PendingIntent r3) {
            if (Build.VERSION.SDK_INT < 23) goto L6;
            Api23Impl.requestUsageTimeReport(this.mActivityOptions, r3);
            return;
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        @NonNull
        public ActivityOptionsCompat setLaunchBounds(@Nullable Rect r3) {
            if (Build.VERSION.SDK_INT >= 24) goto L6;
            return this;
        L6:
            return new ActivityOptionsCompatImpl(Api24Impl.setLaunchBounds(this.mActivityOptions, r3));
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        public Bundle toBundle() {
            return this.mActivityOptions.toBundle();
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        public void update(@NonNull ActivityOptionsCompat r2) {
            if ((r2 instanceof ActivityOptionsCompatImpl) == false) goto L6;
            this.mActivityOptions.update(((ActivityOptionsCompatImpl) r2).mActivityOptions);
            return;
        }
    }

    @RequiresApi(16)
    static class Api16Impl {
        private Api16Impl() {
        }

        @DoNotInline
        static ActivityOptions makeCustomAnimation(Context r0, int r1, int r2) {
            return ActivityOptions.makeCustomAnimation(r0, r1, r2);
        }

        @DoNotInline
        static ActivityOptions makeScaleUpAnimation(View r0, int r1, int r2, int r3, int r4) {
            return ActivityOptions.makeScaleUpAnimation(r0, r1, r2, r3, r4);
        }

        @DoNotInline
        static ActivityOptions makeThumbnailScaleUpAnimation(View r0, Bitmap r1, int r2, int r3) {
            return ActivityOptions.makeThumbnailScaleUpAnimation(r0, r1, r2, r3);
        }
    }

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static ActivityOptions makeSceneTransitionAnimation(Activity r0, View r1, String r2) {
            return ActivityOptions.makeSceneTransitionAnimation(r0, r1, r2);
        }

        @SafeVarargs
        @DoNotInline
        static ActivityOptions makeSceneTransitionAnimation(Activity r0, Pair<View, String>... r1) {
            return ActivityOptions.makeSceneTransitionAnimation(r0, r1);
        }

        @DoNotInline
        static ActivityOptions makeTaskLaunchBehind() {
            return ActivityOptions.makeTaskLaunchBehind();
        }
    }

    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static ActivityOptions makeBasic() {
            return ActivityOptions.makeBasic();
        }

        @DoNotInline
        static ActivityOptions makeClipRevealAnimation(View r0, int r1, int r2, int r3, int r4) {
            return ActivityOptions.makeClipRevealAnimation(r0, r1, r2, r3, r4);
        }

        @DoNotInline
        static void requestUsageTimeReport(ActivityOptions r0, PendingIntent r1) {
            r0.requestUsageTimeReport(r1);
        }
    }

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static Rect getLaunchBounds(ActivityOptions r0) {
            return r0.getLaunchBounds();
        }

        @DoNotInline
        static ActivityOptions setLaunchBounds(ActivityOptions r0, Rect r1) {
            return r0.setLaunchBounds(r1);
        }
    }

    protected ActivityOptionsCompat() {
    }

    @NonNull
    public static ActivityOptionsCompat makeBasic() {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return new ActivityOptionsCompatImpl(Api23Impl.makeBasic());
    L7:
        return new ActivityOptionsCompat();
    }

    @NonNull
    public static ActivityOptionsCompat makeClipRevealAnimation(@NonNull View r2, int r3, int r4, int r5, int r6) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return new ActivityOptionsCompatImpl(Api23Impl.makeClipRevealAnimation(r2, r3, r4, r5, r6));
    L7:
        return new ActivityOptionsCompat();
    }

    @NonNull
    public static ActivityOptionsCompat makeCustomAnimation(@NonNull Context r2, int r3, int r4) {
        if (Build.VERSION.SDK_INT < 16) goto L7;
        return new ActivityOptionsCompatImpl(Api16Impl.makeCustomAnimation(r2, r3, r4));
    L7:
        return new ActivityOptionsCompat();
    }

    @NonNull
    public static ActivityOptionsCompat makeScaleUpAnimation(@NonNull View r2, int r3, int r4, int r5, int r6) {
        if (Build.VERSION.SDK_INT < 16) goto L7;
        return new ActivityOptionsCompatImpl(Api16Impl.makeScaleUpAnimation(r2, r3, r4, r5, r6));
    L7:
        return new ActivityOptionsCompat();
    }

    @NonNull
    public static ActivityOptionsCompat makeSceneTransitionAnimation(@NonNull Activity r2, @NonNull View r3, @NonNull String r4) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return new ActivityOptionsCompatImpl(Api21Impl.makeSceneTransitionAnimation(r2, r3, r4));
    L7:
        return new ActivityOptionsCompat();
    }

    @NonNull
    public static ActivityOptionsCompat makeSceneTransitionAnimation(@NonNull Activity r4, @Nullable androidx.core.util.Pair<View, String>... r5) {
        if (Build.VERSION.SDK_INT < 21) goto L13;
        Pair[] r0 = null;
        if (r5 == null) goto L11;
        r0 = new Pair[r5.length];
        int r1 = 0;
    L8:
        if (r1 >= r5.length) goto L11;
        r0[r1] = Pair.create(r5[r1].first, r5[r1].second);
        r1 = r1 + 1;
    L11:
        return new ActivityOptionsCompatImpl(Api21Impl.makeSceneTransitionAnimation(r4, r0));
    L13:
        return new ActivityOptionsCompat();
    }

    @NonNull
    public static ActivityOptionsCompat makeTaskLaunchBehind() {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return new ActivityOptionsCompatImpl(Api21Impl.makeTaskLaunchBehind());
    L7:
        return new ActivityOptionsCompat();
    }

    @NonNull
    public static ActivityOptionsCompat makeThumbnailScaleUpAnimation(@NonNull View r2, @NonNull Bitmap r3, int r4, int r5) {
        if (Build.VERSION.SDK_INT < 16) goto L7;
        return new ActivityOptionsCompatImpl(Api16Impl.makeThumbnailScaleUpAnimation(r2, r3, r4, r5));
    L7:
        return new ActivityOptionsCompat();
    }

    @Nullable
    public Rect getLaunchBounds() {
        return null;
    }

    public void requestUsageTimeReport(@NonNull PendingIntent r1) {
    }

    @NonNull
    public ActivityOptionsCompat setLaunchBounds(@Nullable Rect r1) {
        return this;
    }

    @Nullable
    public Bundle toBundle() {
        return null;
    }

    public void update(@NonNull ActivityOptionsCompat r1) {
    }
}
