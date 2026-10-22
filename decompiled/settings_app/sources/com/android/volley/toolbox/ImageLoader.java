package com.android.volley.toolbox;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ImageLoader {
    private int mBatchResponseDelayMs;
    private final HashMap<String, BatchedImageRequest> mBatchedResponses;
    private final ImageCache mCache;
    private final Handler mHandler;
    private final HashMap<String, BatchedImageRequest> mInFlightRequests;
    private final RequestQueue mRequestQueue;
    private Runnable mRunnable;

    private static class BatchedImageRequest {
        private final List<ImageContainer> mContainers;
        private VolleyError mError;
        private final Request<?> mRequest;
        private Bitmap mResponseBitmap;

        static /* synthetic */ Bitmap access$000(BatchedImageRequest r0) {
            return r0.mResponseBitmap;
        }

        static /* synthetic */ Bitmap access$002(BatchedImageRequest r0, Bitmap r1) {
            r0.mResponseBitmap = r1;
            return r1;
        }

        static /* synthetic */ List access$300(BatchedImageRequest r0) {
            return r0.mContainers;
        }

        public BatchedImageRequest(Request<?> r2, ImageContainer r3) {
            ArrayList r0 = new ArrayList();
            this.mContainers = r0;
            this.mRequest = r2;
            r0.add(r3);
        }

        public void setError(VolleyError r1) {
            this.mError = r1;
        }

        public VolleyError getError() {
            return this.mError;
        }

        public void addContainer(ImageContainer r1) {
            this.mContainers.add(r1);
        }

        public boolean removeContainerAndCancelIfNecessary(ImageContainer r2) {
            this.mContainers.remove(r2);
            if (this.mContainers.size() != 0) goto L6;
            this.mRequest.cancel();
            return true;
        L6:
            return false;
        }
    }

    public interface ImageCache {
        Bitmap getBitmap(String r1);

        void putBitmap(String r1, Bitmap r2);
    }

    public class ImageContainer {
        private Bitmap mBitmap;
        private final String mCacheKey;
        private final ImageListener mListener;
        private final String mRequestUrl;
        final /* synthetic */ ImageLoader this$0;

        static /* synthetic */ ImageListener access$400(ImageContainer r0) {
            return r0.mListener;
        }

        static /* synthetic */ Bitmap access$502(ImageContainer r0, Bitmap r1) {
            r0.mBitmap = r1;
            return r1;
        }

        public ImageContainer(ImageLoader r1, Bitmap r2, String r3, String r4, ImageListener r5) {
            this.this$0 = r1;
            this.mBitmap = r2;
            this.mRequestUrl = r3;
            this.mCacheKey = r4;
            this.mListener = r5;
        }

        public void cancelRequest() {
            Threads.throwIfNotOnMainThread();
            if (this.mListener != null) goto L5;
            return;
        L5:
            BatchedImageRequest r0 = (BatchedImageRequest) ImageLoader.access$100(this.this$0).get(this.mCacheKey);
            if (r0 != null) goto L8;
            BatchedImageRequest r1 = (BatchedImageRequest) ImageLoader.access$200(this.this$0).get(this.mCacheKey);
            if (r1 == null) goto L18;
            r1.removeContainerAndCancelIfNecessary(this);
            if (BatchedImageRequest.access$300(r1).size() != 0) goto L19;
            ImageLoader.access$200(this.this$0).remove(this.mCacheKey);
            return;
        L19:
            return;
        L18:
            return;
        L8:
            if (r0.removeContainerAndCancelIfNecessary(this) == false) goto L16;
            ImageLoader.access$100(this.this$0).remove(this.mCacheKey);
            return;
        }

        public Bitmap getBitmap() {
            return this.mBitmap;
        }

        public String getRequestUrl() {
            return this.mRequestUrl;
        }
    }

    public interface ImageListener extends Response.ErrorListener {
        void onResponse(ImageContainer r1, boolean r2);
    }

    static /* synthetic */ HashMap access$100(ImageLoader r0) {
        return r0.mInFlightRequests;
    }

    static /* synthetic */ HashMap access$200(ImageLoader r0) {
        return r0.mBatchedResponses;
    }

    static /* synthetic */ Runnable access$602(ImageLoader r0, Runnable r1) {
        r0.mRunnable = r1;
        return r1;
    }

    public ImageLoader(RequestQueue r3, ImageCache r4) {
        this.mBatchResponseDelayMs = 100;
        this.mInFlightRequests = new HashMap();
        this.mBatchedResponses = new HashMap();
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mRequestQueue = r3;
        this.mCache = r4;
    }

    public static ImageListener getImageListener(final ImageView r1, final int r2, final int r3) {
        return new AnonymousClass1(r3, r1, r2);
    }

    public boolean isCached(String r2, int r3, int r4) {
        return isCached(r2, r3, r4, ImageView.ScaleType.CENTER_INSIDE);
    }

    public boolean isCached(String r1, int r2, int r3, ImageView.ScaleType r4) {
        Threads.throwIfNotOnMainThread();
        String r5 = getCacheKey(r1, r2, r3, r4);
        if (this.mCache.getBitmap(r5) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public ImageContainer get(String r2, ImageListener r3) {
        return get(r2, r3, 0, 0);
    }

    public ImageContainer get(String r7, ImageListener r8, int r9, int r10) {
        return get(r7, r8, r9, r10, ImageView.ScaleType.CENTER_INSIDE);
    }

    public ImageContainer get(String r16, ImageListener r17, int r18, int r19, ImageView.ScaleType r20) {
        Threads.throwIfNotOnMainThread();
        String r12 = getCacheKey(r16, r18, r19, r20);
        Bitmap r2 = this.mCache.getBitmap(r12);
        if (r2 == null) goto L6;
        ImageContainer r9 = new ImageContainer(this, r2, r16, null, null);
        r17.onResponse(r9, true);
        return r9;
    L6:
        ImageContainer r14 = new ImageContainer(this, null, r16, r12, r17);
        r17.onResponse(r14, true);
        BatchedImageRequest r0 = this.mInFlightRequests.get(r12);
        if (r0 != null) goto L9;
        r0 = this.mBatchedResponses.get(r12);
    L9:
        if (r0 == null) goto L12;
        r0.addContainer(r14);
        return r14;
    L12:
        Request<Bitmap> r1 = makeImageRequest(r16, r18, r19, r20, r12);
        this.mRequestQueue.add(r1);
        this.mInFlightRequests.put(r12, new BatchedImageRequest(r1, r14));
        return r14;
    }

    protected Request<Bitmap> makeImageRequest(String r10, int r11, int r12, ImageView.ScaleType r13, final String r14) {
        return new ImageRequest(r10, new AnonymousClass2(this, r14), r11, r12, r13, Bitmap.Config.RGB_565, new AnonymousClass3(this, r14));
    }

    public void setBatchedResponseDelay(int r1) {
        this.mBatchResponseDelayMs = r1;
    }

    protected void onGetImageSuccess(String r2, Bitmap r3) {
        this.mCache.putBitmap(r2, r3);
        BatchedImageRequest r0 = this.mInFlightRequests.remove(r2);
        if (r0 == null) goto L6;
        BatchedImageRequest.access$002(r0, r3);
        batchResponse(r2, r0);
        return;
    }

    protected void onGetImageError(String r2, VolleyError r3) {
        BatchedImageRequest r0 = this.mInFlightRequests.remove(r2);
        if (r0 == null) goto L6;
        r0.setError(r3);
        batchResponse(r2, r0);
        return;
    }

    private void batchResponse(String r3, BatchedImageRequest r4) {
        this.mBatchedResponses.put(r3, r4);
        if (this.mRunnable != null) goto L6;
        Runnable r5 = new AnonymousClass4(this);
        this.mRunnable = r5;
        this.mHandler.postDelayed(r5, this.mBatchResponseDelayMs);
        return;
    }

    private static String getCacheKey(String r2, int r3, int r4, ImageView.ScaleType r5) {
        return new StringBuilder(r2.length() + 12).append("#W").append(r3).append("#H").append(r4).append("#S").append(r5.ordinal()).append(r2).toString();
    }
}
