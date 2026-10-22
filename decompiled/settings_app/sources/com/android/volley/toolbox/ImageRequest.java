package com.android.volley.toolbox;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyLog;

/* JADX INFO: loaded from: classes.dex */
public class ImageRequest extends Request<Bitmap> {
    public static final float DEFAULT_IMAGE_BACKOFF_MULT = 2.0f;
    public static final int DEFAULT_IMAGE_MAX_RETRIES = 2;
    public static final int DEFAULT_IMAGE_TIMEOUT_MS = 1000;
    private static final Object sDecodeLock = null;
    private final Bitmap.Config mDecodeConfig;
    private Response.Listener<Bitmap> mListener;
    private final Object mLock;
    private final int mMaxHeight;
    private final int mMaxWidth;
    private final ImageView.ScaleType mScaleType;

    @Override // com.android.volley.Request
    protected /* bridge */ /* synthetic */ void deliverResponse(Bitmap r1) {
        deliverResponse2(r1);
    }

    static {
        sDecodeLock = new Object();
    }

    public ImageRequest(String r3, Response.Listener<Bitmap> r4, int r5, int r6, ImageView.ScaleType r7, Bitmap.Config r8, Response.ErrorListener r9) {
        super(0, r3, r9);
        this.mLock = new Object();
        setRetryPolicy(new DefaultRetryPolicy(1000, 2, 2.0f));
        this.mListener = r4;
        this.mDecodeConfig = r8;
        this.mMaxWidth = r5;
        this.mMaxHeight = r6;
        this.mScaleType = r7;
    }

    @Deprecated
    public ImageRequest(String r9, Response.Listener<Bitmap> r10, int r11, int r12, Bitmap.Config r13, Response.ErrorListener r14) {
        this(r9, r10, r11, r12, ImageView.ScaleType.CENTER_INSIDE, r13, r14);
    }

    @Override // com.android.volley.Request
    public Request.Priority getPriority() {
        return Request.Priority.LOW;
    }

    private static int getResizedDimension(int r4, int r5, int r6, int r7, ImageView.ScaleType r8) {
        if (r4 != 0) goto L6;
        if (r5 != 0) goto L6;
        return r6;
    L6:
        if (r8 != ImageView.ScaleType.FIT_XY) goto L10;
        if (r4 != 0) goto L9;
        return r6;
    L9:
        return r4;
    L10:
        if (r4 == 0) goto L12;
        if (r5 != 0) goto L15;
        return r4;
    L15:
        double r0 = ((double) r7) / ((double) r6);
        if (r8 != ImageView.ScaleType.CENTER_CROP) goto L21;
        double r2 = r5;
        if ((((double) r4) * r0) < r2) goto L20;
        return r4;
    L20:
        return (int) (r2 / r0);
    L21:
        double r3 = r5;
        if ((((double) r4) * r0) > r3) goto L24;
        return r4;
    L24:
        return (int) (r3 / r0);
    L12:
        return (int) (r6 * (((double) r5) / ((double) r7)));
    }

    @Override // com.android.volley.Request
    protected Response<Bitmap> parseNetworkResponse(NetworkResponse r6) {
        Object r0 = sDecodeLock;
        monitor-enter(r0);
        Response<Bitmap> r5 = doParse(r6);     // Catch: Throwable -> L7 OutOfMemoryError -> L9
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r5;
    L9:
        e = move-exception;
        VolleyLog.e("Caught OOM for %d byte image, url=%s", new Object[]{Integer.valueOf(r6.data.length), getUrl()});     // Catch: Throwable -> L7
        return Response.error(new ParseError(e));
    L7:
        th = move-exception;
        throw th;
    }

    private Response<Bitmap> doParse(NetworkResponse r10) {
        byte[] r0 = r10.data;
        BitmapFactory.Options r1 = new BitmapFactory.Options();
        if (this.mMaxWidth == 0) goto L5;
    L7:
        r1.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(r0, 0, r0.length, r1);
        int r4 = r1.outWidth;
        int r5 = r1.outHeight;
        int r6 = getResizedDimension(this.mMaxWidth, this.mMaxHeight, r4, r5, this.mScaleType);
        int r9 = getResizedDimension(this.mMaxHeight, this.mMaxWidth, r5, r4, this.mScaleType);
        r1.inJustDecodeBounds = false;
        r1.inSampleSize = findBestSampleSize(r4, r5, r6, r9);
        Bitmap r2 = BitmapFactory.decodeByteArray(r0, 0, r0.length, r1);
        if (r2 != null) goto L10;
    L14:
        Bitmap r11 = r2;
    L15:
        if (r11 != null) goto L19;
        return Response.error(new ParseError(r10));
    L19:
        return Response.success(r11, HttpHeaderParser.parseCacheHeaders(r10));
    L10:
        if (r2.getWidth() <= r6) goto L12;
    L13:
        r11 = Bitmap.createScaledBitmap(r2, r6, r9, true);
        r2.recycle();
        goto L15
    L12:
        if (r2.getHeight() <= r9) goto L14;
    L5:
        if (this.mMaxHeight != 0) goto L7;
        r1.inPreferredConfig = this.mDecodeConfig;
        r11 = BitmapFactory.decodeByteArray(r0, 0, r0.length, r1);
        goto L15
    }

    @Override // com.android.volley.Request
    public void cancel() {
        super.cancel();
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mListener = null;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: deliverResponse, reason: avoid collision after fix types in other method */
    protected void deliverResponse2(Bitmap r2) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Response.Listener<Bitmap> r1 = this.mListener;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        if (r1 == null) goto L14;
        r1.onResponse(r2);
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    static int findBestSampleSize(int r4, int r5, int r6, int r7) {
        double r8 = Math.min(((double) r4) / ((double) r6), ((double) r5) / ((double) r7));
        float r9 = 1.0f;
    L3:
        float r10 = 2.0f * r9;
        if (r10 > r8) goto L7;
        r9 = r10;
        goto L3
    L7:
        return (int) r9;
    }
}
