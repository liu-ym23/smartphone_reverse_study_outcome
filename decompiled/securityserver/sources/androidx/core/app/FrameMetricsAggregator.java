package androidx.core.app;

import android.app.Activity;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseIntArray;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class FrameMetricsAggregator {
    public static final int ANIMATION_DURATION = 256;
    public static final int ANIMATION_INDEX = 8;
    public static final int COMMAND_DURATION = 32;
    public static final int COMMAND_INDEX = 5;
    public static final int DELAY_DURATION = 128;
    public static final int DELAY_INDEX = 7;
    public static final int DRAW_DURATION = 8;
    public static final int DRAW_INDEX = 3;
    public static final int EVERY_DURATION = 511;
    public static final int INPUT_DURATION = 2;
    public static final int INPUT_INDEX = 1;
    private static final int LAST_INDEX = 8;
    public static final int LAYOUT_MEASURE_DURATION = 4;
    public static final int LAYOUT_MEASURE_INDEX = 2;
    public static final int SWAP_DURATION = 64;
    public static final int SWAP_INDEX = 6;
    public static final int SYNC_DURATION = 16;
    public static final int SYNC_INDEX = 4;
    public static final int TOTAL_DURATION = 1;
    public static final int TOTAL_INDEX = 0;
    private FrameMetricsBaseImpl mInstance;

    @RequiresApi(24)
    public static class FrameMetricsApi24Impl extends FrameMetricsBaseImpl {
        private static final int NANOS_PER_MS = 1000000;
        private static final int NANOS_ROUNDING_VALUE = 500000;
        private static Handler sHandler;
        private static HandlerThread sHandlerThread;
        private ArrayList<WeakReference<Activity>> mActivities;
        Window.OnFrameMetricsAvailableListener mListener;
        SparseIntArray[] mMetrics;
        int mTrackingFlags;

        public FrameMetricsApi24Impl(int r2) {
            this.mMetrics = new SparseIntArray[9];
            this.mActivities = new ArrayList();
            this.mListener = new AnonymousClass1(this);
            this.mTrackingFlags = r2;
        }

        @Override // androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public void add(Activity r5) {
            if (sHandlerThread != null) goto L5;
            HandlerThread r0 = new HandlerThread("FrameMetricsAggregator");
            sHandlerThread = r0;
            r0.start();
            sHandler = new Handler(sHandlerThread.getLooper());
        L5:
            int r1 = 0;
        L7:
            if (r1 > 8) goto L14;
            SparseIntArray[] r2 = this.mMetrics;
            if (r2[r1] != null) goto L13;
            if ((this.mTrackingFlags & (1 << r1)) == 0) goto L13;
            r2[r1] = new SparseIntArray();
        L13:
            r1 = r1 + 1;
            goto L7
        L14:
            r5.getWindow().addOnFrameMetricsAvailableListener(this.mListener, sHandler);
            this.mActivities.add(new WeakReference(r5));
        }

        public void addDurationItem(SparseIntArray r5, long r6) {
            if (r5 == null) goto L7;
            int r4 = (int) ((500000 + r6) / 1000000);
            if (r6 < 0) goto L8;
            r5.put(r4, r5.get(r4) + 1);
            return;
        L8:
            return;
        }

        @Override // androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public SparseIntArray[] getMetrics() {
            return this.mMetrics;
        }

        @Override // androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public SparseIntArray[] remove(Activity r4) {
            Iterator<WeakReference<Activity>> r0 = this.mActivities.iterator();
        L4:
            if (r0.hasNext() == false) goto L8;
            WeakReference<Activity> r1 = r0.next();
            if (r1.get() != r4) goto L4;
            this.mActivities.remove(r1);
        L8:
            r4.getWindow().removeOnFrameMetricsAvailableListener(this.mListener);
            return this.mMetrics;
        }

        @Override // androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public SparseIntArray[] reset() {
            SparseIntArray[] r0 = this.mMetrics;
            this.mMetrics = new SparseIntArray[9];
            return r0;
        }

        @Override // androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public SparseIntArray[] stop() {
            int r0 = this.mActivities.size() - 1;
        L3:
            if (r0 < 0) goto L9;
            WeakReference<Activity> r1 = this.mActivities.get(r0);
            Activity r2 = r1.get();
            if (r1.get() == null) goto L7;
            r2.getWindow().removeOnFrameMetricsAvailableListener(this.mListener);
            this.mActivities.remove(r0);
        L7:
            r0 = r0 - 1;
            goto L3
        L9:
            return this.mMetrics;
        }
    }

    public static class FrameMetricsBaseImpl {
        public FrameMetricsBaseImpl() {
        }

        public void add(Activity r1) {
        }

        public SparseIntArray[] getMetrics() {
            return null;
        }

        public SparseIntArray[] remove(Activity r1) {
            return null;
        }

        public SparseIntArray[] reset() {
            return null;
        }

        public SparseIntArray[] stop() {
            return null;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface MetricType {
    }

    public FrameMetricsAggregator() {
        this(1);
    }

    public void add(@NonNull Activity r1) {
        this.mInstance.add(r1);
    }

    @Nullable
    public SparseIntArray[] getMetrics() {
        return this.mInstance.getMetrics();
    }

    @Nullable
    public SparseIntArray[] remove(@NonNull Activity r1) {
        return this.mInstance.remove(r1);
    }

    @Nullable
    public SparseIntArray[] reset() {
        return this.mInstance.reset();
    }

    @Nullable
    public SparseIntArray[] stop() {
        return this.mInstance.stop();
    }

    public FrameMetricsAggregator(int r2) {
        this.mInstance = new FrameMetricsApi24Impl(r2);
    }
}
