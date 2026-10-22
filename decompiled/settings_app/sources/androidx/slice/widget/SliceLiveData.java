package androidx.slice.widget;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import androidx.collection.ArraySet;
import androidx.lifecycle.LiveData;
import androidx.slice.Slice;
import androidx.slice.SliceSpec;
import androidx.slice.SliceSpecs;
import androidx.slice.SliceStructure;
import androidx.slice.SliceViewManager;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class SliceLiveData {
    public static final SliceSpec OLD_BASIC = null;
    public static final SliceSpec OLD_LIST = null;
    public static final Set<SliceSpec> SUPPORTED_SPECS = null;

    private static class CachedLiveDataImpl extends LiveData<Slice> {
        private boolean mActive;
        final Context mContext;
        private final OnErrorListener mListener;
        private boolean mLive;
        List<Context> mPendingContext;
        List<Intent> mPendingIntent;
        List<Uri> mPendingUri;
        final SliceViewManager.SliceCallback mSliceCallback;
        private boolean mSliceCallbackRegistered;
        final SliceViewManager mSliceViewManager;
        SliceStructure mStructure;
        private final Runnable mUpdateSlice;
        Uri mUri;

        static /* synthetic */ void access$000(CachedLiveDataImpl r0, Object r1) {
            r0.postValue(r1);
        }

        static /* synthetic */ void access$100(CachedLiveDataImpl r0, Object r1) {
            r0.postValue(r1);
        }

        CachedLiveDataImpl(final Context r2, SliceViewManager r3, final InputStream r4, final OnErrorListener r5) {
            this.mPendingUri = new ArrayList();
            this.mPendingContext = new ArrayList();
            this.mPendingIntent = new ArrayList();
            this.mUpdateSlice = new AnonymousClass2(this);
            this.mSliceCallback = new AnonymousClass3(this);
            this.mContext = r2;
            this.mSliceViewManager = r3;
            this.mUri = null;
            this.mListener = r5;
            AsyncTask.execute(new AnonymousClass1(this, r2, r4, r5));
        }

        void goLive(Uri r3, Context r4, Intent r5) {
            this.mLive = true;
            this.mPendingUri.add(r3);
            this.mPendingContext.add(r4);
            this.mPendingIntent.add(r5);
            if (this.mActive == true) goto L5;
            return;
        L5:
            if (this.mSliceCallbackRegistered == true) goto L9;
            AsyncTask.execute(this.mUpdateSlice);
            this.mSliceViewManager.registerSliceCallback(this.mUri, this.mSliceCallback);
            this.mSliceCallbackRegistered = true;
            return;
        }

        @Override // androidx.lifecycle.LiveData
        protected void onActive() {
            this.mActive = true;
            if (this.mLive == true) goto L5;
            return;
        L5:
            if (this.mSliceCallbackRegistered == true) goto L9;
            AsyncTask.execute(this.mUpdateSlice);
            this.mSliceViewManager.registerSliceCallback(this.mUri, this.mSliceCallback);
            this.mSliceCallbackRegistered = true;
            return;
        }

        @Override // androidx.lifecycle.LiveData
        protected void onInactive() {
            this.mActive = false;
            if (this.mLive == true) goto L5;
            return;
        L5:
            if (this.mSliceCallbackRegistered == false) goto L9;
            this.mSliceViewManager.unregisterSliceCallback(this.mUri, this.mSliceCallback);
            this.mSliceCallbackRegistered = false;
            return;
        }

        void onSliceError(int r3, Throwable r4) {
            this.mListener.onSliceError(r3, r4);
            if (this.mLive == true) goto L5;
            return;
        L5:
            if (this.mSliceCallbackRegistered == false) goto L7;
            this.mSliceViewManager.unregisterSliceCallback(this.mUri, this.mSliceCallback);
            this.mSliceCallbackRegistered = false;
        L7:
            this.mLive = false;
        }
    }

    public interface OnErrorListener {
        public static final int ERROR_INVALID_INPUT = 3;
        public static final int ERROR_SLICE_NO_LONGER_PRESENT = 2;
        public static final int ERROR_STRUCTURE_CHANGED = 1;
        public static final int ERROR_UNKNOWN = 0;

        public @interface ErrorType {
        }

        void onSliceError(int r1, Throwable r2);
    }

    private static class SliceLiveDataImpl extends LiveData<Slice> {
        final Intent mIntent;
        final SliceViewManager.SliceCallback mSliceCallback;
        final SliceViewManager mSliceViewManager;
        private final Runnable mUpdateSlice;
        Uri mUri;

        static /* synthetic */ void access$200(SliceLiveDataImpl r0, Object r1) {
            r0.postValue(r1);
        }

        static /* synthetic */ void access$300(SliceLiveDataImpl r0, Object r1) {
            r0.postValue(r1);
        }

        SliceLiveDataImpl(Context r2, Uri r3) {
            this.mUpdateSlice = new AnonymousClass1(this);
            this.mSliceCallback = new AnonymousClass2(this);
            this.mSliceViewManager = SliceViewManager.getInstance(r2);
            this.mUri = r3;
            this.mIntent = null;
        }

        SliceLiveDataImpl(Context r2, Intent r3) {
            this.mUpdateSlice = new AnonymousClass1(this);
            this.mSliceCallback = new AnonymousClass2(this);
            this.mSliceViewManager = SliceViewManager.getInstance(r2);
            this.mUri = null;
            this.mIntent = r3;
        }

        @Override // androidx.lifecycle.LiveData
        protected void onActive() {
            AsyncTask.execute(this.mUpdateSlice);
            Uri r0 = this.mUri;
            if (r0 == null) goto L6;
            this.mSliceViewManager.registerSliceCallback(r0, this.mSliceCallback);
            return;
        }

        @Override // androidx.lifecycle.LiveData
        protected void onInactive() {
            Uri r0 = this.mUri;
            if (r0 == null) goto L6;
            this.mSliceViewManager.unregisterSliceCallback(r0, this.mSliceCallback);
            return;
        }
    }

    static {
        SliceSpec r0 = new SliceSpec("androidx.app.slice.BASIC", 1);
        OLD_BASIC = r0;
        SliceSpec r1 = new SliceSpec("androidx.app.slice.LIST", 1);
        OLD_LIST = r1;
        SUPPORTED_SPECS = new ArraySet(Arrays.asList(new SliceSpec[]{SliceSpecs.BASIC, SliceSpecs.LIST, r0, r1}));
    }

    public static LiveData<Slice> fromUri(Context r1, Uri r2) {
        return new SliceLiveDataImpl(r1.getApplicationContext(), r2);
    }

    public static LiveData<Slice> fromIntent(Context r1, Intent r2) {
        return new SliceLiveDataImpl(r1.getApplicationContext(), r2);
    }

    public static LiveData<Slice> fromStream(Context r1, InputStream r2, OnErrorListener r3) {
        return fromStream(r1, SliceViewManager.getInstance(r1), r2, r3);
    }

    public static LiveData<Slice> fromStream(Context r1, SliceViewManager r2, InputStream r3, OnErrorListener r4) {
        return new CachedLiveDataImpl(r1, r2, r3, r4);
    }

    private SliceLiveData() {
    }
}
