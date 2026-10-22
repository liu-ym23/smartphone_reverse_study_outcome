package androidx.core.app;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Pair;

/* JADX INFO: loaded from: classes.dex */
public class ActivityOptionsCompat {
    public static final String EXTRA_USAGE_TIME_REPORT = "android.activity.usage_time";
    public static final String EXTRA_USAGE_TIME_REPORT_PACKAGES = "android.usage_time_packages";

    @RequiresApi(16)
    public static class ActivityOptionsCompatImpl extends ActivityOptionsCompat {
        private final ActivityOptions mActivityOptions;

        public ActivityOptionsCompatImpl(ActivityOptions r1) {
            this.mActivityOptions = r1;
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        public Rect getLaunchBounds() {
            return this.mActivityOptions.getLaunchBounds();
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        public void requestUsageTimeReport(@NonNull PendingIntent r1) {
            this.mActivityOptions.requestUsageTimeReport(r1);
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        @NonNull
        public ActivityOptionsCompat setLaunchBounds(@Nullable Rect r2) {
            return new ActivityOptionsCompatImpl(this.mActivityOptions.setLaunchBounds(r2));
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

    public ActivityOptionsCompat() {
    }

    @NonNull
    public static ActivityOptionsCompat makeBasic() {
        return new ActivityOptionsCompatImpl(ActivityOptions.makeBasic());
    }

    @NonNull
    public static ActivityOptionsCompat makeClipRevealAnimation(@NonNull View r1, int r2, int r3, int r4, int r5) {
        return new ActivityOptionsCompatImpl(ActivityOptions.makeClipRevealAnimation(r1, r2, r3, r4, r5));
    }

    @NonNull
    public static ActivityOptionsCompat makeCustomAnimation(@NonNull Context r1, int r2, int r3) {
        return new ActivityOptionsCompatImpl(ActivityOptions.makeCustomAnimation(r1, r2, r3));
    }

    @NonNull
    public static ActivityOptionsCompat makeScaleUpAnimation(@NonNull View r1, int r2, int r3, int r4, int r5) {
        return new ActivityOptionsCompatImpl(ActivityOptions.makeScaleUpAnimation(r1, r2, r3, r4, r5));
    }

    @NonNull
    public static ActivityOptionsCompat makeSceneTransitionAnimation(@NonNull Activity r1, @NonNull View r2, @NonNull String r3) {
        return new ActivityOptionsCompatImpl(ActivityOptions.makeSceneTransitionAnimation(r1, r2, r3));
    }

    @NonNull
    public static ActivityOptionsCompat makeTaskLaunchBehind() {
        return new ActivityOptionsCompatImpl(ActivityOptions.makeTaskLaunchBehind());
    }

    @NonNull
    public static ActivityOptionsCompat makeThumbnailScaleUpAnimation(@NonNull View r1, @NonNull Bitmap r2, int r3, int r4) {
        return new ActivityOptionsCompatImpl(ActivityOptions.makeThumbnailScaleUpAnimation(r1, r2, r3, r4));
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

    @NonNull
    public static ActivityOptionsCompat makeSceneTransitionAnimation(@NonNull Activity r4, Pair<View, String>... r5) {
        if (r5 == null) goto L7;
        android.util.Pair[] r0 = new android.util.Pair[r5.length];
        int r1 = 0;
    L5:
        if (r1 >= r5.length) goto L9;
        Pair<View, String> r2 = r5[r1];
        r0[r1] = android.util.Pair.create(r2.first, r2.second);
        r1 = r1 + 1;
    L9:
        return new ActivityOptionsCompatImpl(ActivityOptions.makeSceneTransitionAnimation(r4, r0));
    L7:
        r0 = null;
        goto L9
    }
}
