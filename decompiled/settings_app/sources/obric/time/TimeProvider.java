package obric.time;

import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes5.dex */
public abstract class TimeProvider {
    static final boolean DEBUG = true;
    public static final long INVALID_TIME = -1;
    public static final long SYNCTING_TIME = -2;
    static final String TAG = "TimeProvider";
    protected Context mContext;
    private AtomicBoolean mInited;

    public interface OnTimeFetchedListener {
        void onTimeFetched(boolean r1);
    }

    private static class TimeProviderHolder {
        private static TimeProvider sTimeProvider;

        private TimeProviderHolder() {
        }

        static /* synthetic */ TimeProvider access$000() {
            return sTimeProvider;
        }

        static {
            sTimeProvider = new TimeProviderImpl();
        }
    }

    public abstract void cancelSyncTime();

    public abstract long getCurrentTimeMillis();

    public abstract long getNetworkTimeMillis();

    public abstract boolean startSyncTime(OnTimeFetchedListener r1);

    public TimeProvider() {
        this.mInited = new AtomicBoolean(false);
    }

    public static final TimeProvider getTimeProvider(Context r1) {
        TimeProviderHolder.access$000().init(r1);
        return TimeProviderHolder.access$000();
    }

    private void init(Context r3) {
        if (this.mInited.getAndSet(true) == false) goto L5;
        return;
    L5:
        if (r3 == null) goto L9;
        this.mContext = r3.getApplicationContext();
        return;
    L9:
        throw new IllegalArgumentException("context can't be null when first call TimeProvider instance.");
    }
}
