package androidx.slice.widget;

import android.content.Context;
import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
class SliceMetrics {
    protected void logHidden() {
    }

    protected void logTouch(int r1, Uri r2) {
    }

    protected void logVisible() {
    }

    SliceMetrics() {
    }

    public static SliceMetrics getInstance(Context r1, Uri r2) {
        return new SliceMetricsWrapper(r1, r2);
    }
}
