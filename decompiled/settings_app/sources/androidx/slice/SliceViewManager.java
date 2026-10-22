package androidx.slice;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import java.util.Collection;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public abstract class SliceViewManager {

    public interface SliceCallback {
        void onSliceUpdated(Slice r1);
    }

    public abstract Slice bindSlice(Intent r1);

    public abstract Slice bindSlice(Uri r1);

    public abstract Collection<Uri> getSliceDescendants(Uri r1);

    public abstract Uri mapIntentToUri(Intent r1);

    public abstract void pinSlice(Uri r1);

    public abstract void registerSliceCallback(Uri r1, SliceCallback r2);

    public abstract void registerSliceCallback(Uri r1, Executor r2, SliceCallback r3);

    public abstract void unpinSlice(Uri r1);

    public abstract void unregisterSliceCallback(Uri r1, SliceCallback r2);

    public static SliceViewManager getInstance(Context r1) {
        return new SliceViewManagerWrapper(r1);
    }

    SliceViewManager() {
    }
}
