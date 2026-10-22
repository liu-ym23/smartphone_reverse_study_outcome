package com.android.volley.toolbox;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.android.volley.VolleyError;

/* JADX INFO: loaded from: classes.dex */
public class NetworkImageView extends ImageView {
    private Bitmap mDefaultImageBitmap;
    private Drawable mDefaultImageDrawable;
    private int mDefaultImageId;
    private Bitmap mErrorImageBitmap;
    private Drawable mErrorImageDrawable;
    private int mErrorImageId;
    private ImageLoader.ImageContainer mImageContainer;
    private ImageLoader mImageLoader;
    private String mUrl;

    /* JADX INFO: renamed from: com.android.volley.toolbox.NetworkImageView$1, reason: invalid class name */
    class AnonymousClass1 implements ImageLoader.ImageListener {
        final /* synthetic */ NetworkImageView this$0;
        final /* synthetic */ boolean val$isInLayoutPass;

        AnonymousClass1(NetworkImageView r1, boolean r2) {
            this.this$0 = r1;
            this.val$isInLayoutPass = r2;
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError r1) {
            if (NetworkImageView.access$000(this.this$0) == 0) goto L6;
            NetworkImageView r0 = this.this$0;
            r0.setImageResource(NetworkImageView.access$000(r0));
            return;
        L6:
            if (NetworkImageView.access$100(this.this$0) == null) goto L9;
            NetworkImageView r2 = this.this$0;
            r2.setImageDrawable(NetworkImageView.access$100(r2));
            return;
        L9:
            if (NetworkImageView.access$200(this.this$0) == null) goto L14;
            NetworkImageView r3 = this.this$0;
            r3.setImageBitmap(NetworkImageView.access$200(r3));
            return;
        }

        @Override // com.android.volley.toolbox.ImageLoader.ImageListener
        public void onResponse(final ImageLoader.ImageContainer r2, boolean r3) {
            if (r3 == false) goto L8;
            if (this.val$isInLayoutPass == false) goto L8;
            this.this$0.post(new RunnableC00441(this, r2));
            return;
        L8:
            if (r2.getBitmap() == null) goto L11;
            this.this$0.setImageBitmap(r2.getBitmap());
            return;
        L11:
            if (NetworkImageView.access$300(this.this$0) == 0) goto L14;
            NetworkImageView r1 = this.this$0;
            r1.setImageResource(NetworkImageView.access$300(r1));
            return;
        L14:
            if (NetworkImageView.access$400(this.this$0) == null) goto L17;
            NetworkImageView r4 = this.this$0;
            r4.setImageDrawable(NetworkImageView.access$400(r4));
            return;
        L17:
            if (NetworkImageView.access$500(this.this$0) == null) goto L23;
            NetworkImageView r5 = this.this$0;
            r5.setImageBitmap(NetworkImageView.access$500(r5));
            return;
        }
    }

    static /* synthetic */ int access$000(NetworkImageView r0) {
        return r0.mErrorImageId;
    }

    static /* synthetic */ Drawable access$100(NetworkImageView r0) {
        return r0.mErrorImageDrawable;
    }

    static /* synthetic */ Bitmap access$200(NetworkImageView r0) {
        return r0.mErrorImageBitmap;
    }

    static /* synthetic */ int access$300(NetworkImageView r0) {
        return r0.mDefaultImageId;
    }

    static /* synthetic */ Drawable access$400(NetworkImageView r0) {
        return r0.mDefaultImageDrawable;
    }

    static /* synthetic */ Bitmap access$500(NetworkImageView r0) {
        return r0.mDefaultImageBitmap;
    }

    public NetworkImageView(Context r2) {
        this(r2, null);
    }

    public NetworkImageView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public NetworkImageView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }

    public void setImageUrl(String r1, ImageLoader r2) {
        Threads.throwIfNotOnMainThread();
        this.mUrl = r1;
        this.mImageLoader = r2;
        loadImageIfNecessary(false);
    }

    public void setDefaultImageResId(int r2) {
        this.mDefaultImageBitmap = null;
        this.mDefaultImageDrawable = null;
        this.mDefaultImageId = r2;
    }

    public void setDefaultImageDrawable(Drawable r2) {
        this.mDefaultImageId = 0;
        this.mDefaultImageBitmap = null;
        this.mDefaultImageDrawable = r2;
    }

    public void setDefaultImageBitmap(Bitmap r2) {
        this.mDefaultImageId = 0;
        this.mDefaultImageDrawable = null;
        this.mDefaultImageBitmap = r2;
    }

    public void setErrorImageResId(int r2) {
        this.mErrorImageBitmap = null;
        this.mErrorImageDrawable = null;
        this.mErrorImageId = r2;
    }

    public void setErrorImageDrawable(Drawable r2) {
        this.mErrorImageId = 0;
        this.mErrorImageBitmap = null;
        this.mErrorImageDrawable = r2;
    }

    public void setErrorImageBitmap(Bitmap r2) {
        this.mErrorImageId = 0;
        this.mErrorImageDrawable = null;
        this.mErrorImageBitmap = r2;
    }

    void loadImageIfNecessary(boolean r9) {
        int r0 = getWidth();
        int r1 = getHeight();
        ImageView.ScaleType r7 = getScaleType();
        boolean r3 = true;
        if (getLayoutParams() != null) goto L5;
        boolean r2 = false;
        boolean r5 = false;
    L13:
        if (r2 == false) goto L16;
        if (r5 == false) goto L16;
    L17:
        if (r0 != 0) goto L22;
        if (r1 != 0) goto L22;
        if (r3 == true) goto L22;
        return;
    L22:
        if (TextUtils.isEmpty(this.mUrl) == false) goto L28;
        ImageLoader.ImageContainer r10 = this.mImageContainer;
        if (r10 == null) goto L26;
        r10.cancelRequest();
        this.mImageContainer = null;
    L26:
        setDefaultImageOrNull();
        return;
    L28:
        ImageLoader.ImageContainer r4 = this.mImageContainer;
        if (r4 != null) goto L31;
    L36:
        if (r2 == false) goto L38;
        r0 = 0;
    L38:
        if (r5 == false) goto L40;
        int r6 = 0;
    L41:
        this.mImageContainer = this.mImageLoader.get(this.mUrl, new AnonymousClass1(this, r9), r0, r6, r7);
        return;
    L40:
        r6 = r1;
        goto L41
    L31:
        if (r4.getRequestUrl() == null) goto L36;
        if (this.mImageContainer.getRequestUrl().equals(this.mUrl) == false) goto L35;
        return;
    L35:
        this.mImageContainer.cancelRequest();
        setDefaultImageOrNull();
    L16:
        r3 = false;
        goto L17
    L5:
        if (getLayoutParams().width != (-2)) goto L7;
        r2 = true;
    L9:
        if (getLayoutParams().height != (-2)) goto L11;
        r5 = true;
        goto L13
    L11:
        r5 = false;
        goto L13
    L7:
        r2 = false;
        goto L9
    }

    private void setDefaultImageOrNull() {
        int r0 = this.mDefaultImageId;
        if (r0 == 0) goto L5;
        setImageResource(r0);
        return;
    L5:
        Drawable r1 = this.mDefaultImageDrawable;
        if (r1 == null) goto L8;
        setImageDrawable(r1);
        return;
    L8:
        Bitmap r2 = this.mDefaultImageBitmap;
        if (r2 == null) goto L11;
        setImageBitmap(r2);
        return;
    L11:
        setImageBitmap(null);
    }

    @Override // android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        loadImageIfNecessary(true);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        ImageLoader.ImageContainer r0 = this.mImageContainer;
        if (r0 == null) goto L5;
        r0.cancelRequest();
        setImageBitmap(null);
        this.mImageContainer = null;
    L5:
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }
}
