package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.signature.ObjectKey;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
class GifFrameLoader {
    private final BitmapPool bitmapPool;
    private final List<FrameCallback> callbacks;
    private DelayTarget current;
    private Bitmap firstFrame;
    private int firstFrameSize;
    private final GifDecoder gifDecoder;
    private final Handler handler;
    private int height;
    private boolean isCleared;
    private boolean isLoadPending;
    private boolean isRunning;
    private DelayTarget next;
    private OnEveryFrameListener onEveryFrameListener;
    private DelayTarget pendingTarget;
    private RequestBuilder<Bitmap> requestBuilder;
    final RequestManager requestManager;
    private boolean startFromFirstFrame;
    private Transformation<Bitmap> transformation;
    private int width;

    static class DelayTarget extends CustomTarget<Bitmap> {
        private final Handler handler;
        final int index;
        private Bitmap resource;
        private final long targetTime;

        @Override // com.bumptech.glide.request.target.Target
        public /* bridge */ /* synthetic */ void onResourceReady(Object r1, Transition r2) {
            onResourceReady((Bitmap) r1, r2);
        }

        DelayTarget(Handler r1, int r2, long r3) {
            this.handler = r1;
            this.index = r2;
            this.targetTime = r3;
        }

        Bitmap getResource() {
            return this.resource;
        }

        public void onResourceReady(Bitmap r3, Transition<? super Bitmap> r4) {
            this.resource = r3;
            Message r5 = this.handler.obtainMessage(1, this);
            this.handler.sendMessageAtTime(r5, this.targetTime);
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(Drawable r1) {
            this.resource = null;
        }
    }

    public interface FrameCallback {
        void onFrameReady();
    }

    private class FrameLoaderCallback implements Handler.Callback {
        static final int MSG_CLEAR = 2;
        static final int MSG_DELAY = 1;
        final /* synthetic */ GifFrameLoader this$0;

        FrameLoaderCallback(GifFrameLoader r1) {
            this.this$0 = r1;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message r3) {
            if (r3.what != 1) goto L7;
            DelayTarget r4 = (DelayTarget) r3.obj;
            this.this$0.onFrameReady(r4);
            return true;
        L7:
            if (r3.what != 2) goto L11;
            DelayTarget r5 = (DelayTarget) r3.obj;
            this.this$0.requestManager.clear(r5);
            return false;
        L11:
            return false;
        }
    }

    interface OnEveryFrameListener {
        void onFrameReady();
    }

    GifFrameLoader(Glide r9, GifDecoder r10, int r11, int r12, Transformation<Bitmap> r13, Bitmap r14) {
        this(r9.getBitmapPool(), Glide.with(r9.getContext()), r10, null, getRequestBuilder(Glide.with(r9.getContext()), r11, r12), r13, r14);
    }

    GifFrameLoader(BitmapPool r2, RequestManager r3, GifDecoder r4, Handler r5, RequestBuilder<Bitmap> r6, Transformation<Bitmap> r7, Bitmap r8) {
        this.callbacks = new ArrayList();
        this.requestManager = r3;
        if (r5 != null) goto L5;
        r5 = new Handler(Looper.getMainLooper(), new FrameLoaderCallback(this));
    L5:
        this.bitmapPool = r2;
        this.handler = r5;
        this.requestBuilder = r6;
        this.gifDecoder = r4;
        setFrameTransformation(r7, r8);
    }

    void setFrameTransformation(Transformation<Bitmap> r3, Bitmap r4) {
        this.transformation = (Transformation) Preconditions.checkNotNull(r3);
        this.firstFrame = (Bitmap) Preconditions.checkNotNull(r4);
        this.requestBuilder = this.requestBuilder.apply(new RequestOptions().transform(r3));
        this.firstFrameSize = Util.getBitmapByteSize(r4);
        this.width = r4.getWidth();
        this.height = r4.getHeight();
    }

    Transformation<Bitmap> getFrameTransformation() {
        return this.transformation;
    }

    Bitmap getFirstFrame() {
        return this.firstFrame;
    }

    void subscribe(FrameCallback r3) {
        if (this.isCleared == true) goto L13;
        if (this.callbacks.contains(r3) == true) goto L11;
        boolean r0 = this.callbacks.isEmpty();
        this.callbacks.add(r3);
        if (r0 == false) goto L14;
        start();
        return;
    L14:
        return;
    L11:
        throw new IllegalStateException("Cannot subscribe twice in a row");
    L13:
        throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
    }

    void unsubscribe(FrameCallback r2) {
        this.callbacks.remove(r2);
        if (this.callbacks.isEmpty() == false) goto L6;
        stop();
        return;
    }

    int getWidth() {
        return this.width;
    }

    int getHeight() {
        return this.height;
    }

    int getSize() {
        return this.gifDecoder.getByteSize() + this.firstFrameSize;
    }

    int getCurrentIndex() {
        DelayTarget r0 = this.current;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.index;
    }

    ByteBuffer getBuffer() {
        return this.gifDecoder.getData().asReadOnlyBuffer();
    }

    int getFrameCount() {
        return this.gifDecoder.getFrameCount();
    }

    int getLoopCount() {
        return this.gifDecoder.getTotalIterationCount();
    }

    private void start() {
        if (this.isRunning == false) goto L5;
        return;
    L5:
        this.isRunning = true;
        this.isCleared = false;
        loadNextFrame();
    }

    private void stop() {
        this.isRunning = false;
    }

    void clear() {
        this.callbacks.clear();
        recycleFirstFrame();
        stop();
        DelayTarget r0 = this.current;
        if (r0 == null) goto L5;
        this.requestManager.clear(r0);
        this.current = null;
    L5:
        DelayTarget r1 = this.next;
        if (r1 == null) goto L8;
        this.requestManager.clear(r1);
        this.next = null;
    L8:
        DelayTarget r2 = this.pendingTarget;
        if (r2 == null) goto L11;
        this.requestManager.clear(r2);
        this.pendingTarget = null;
    L11:
        this.gifDecoder.clear();
        this.isCleared = true;
    }

    Bitmap getCurrentFrame() {
        DelayTarget r0 = this.current;
        if (r0 == null) goto L6;
        return r0.getResource();
    L6:
        return this.firstFrame;
    }

    private void loadNextFrame() {
        if (this.isRunning == true) goto L5;
        return;
    L5:
        if (this.isLoadPending == false) goto L8;
        return;
    L8:
        if (this.startFromFirstFrame == true) goto L10;
    L14:
        DelayTarget r0 = this.pendingTarget;
        if (r0 == null) goto L18;
        this.pendingTarget = null;
        onFrameReady(r0);
        return;
    L18:
        this.isLoadPending = true;
        long r1 = SystemClock.uptimeMillis() + ((long) this.gifDecoder.getNextDelay());
        this.gifDecoder.advance();
        this.next = new DelayTarget(this.handler, this.gifDecoder.getCurrentFrameIndex(), r1);
        this.requestBuilder.apply(RequestOptions.signatureOf(getFrameSignature())).load(this.gifDecoder).into(this.next);
        return;
    L10:
        if (this.pendingTarget != null) goto L12;
        boolean r2 = true;
    L13:
        Preconditions.checkArgument(r2, "Pending target must be null when starting from the first frame");
        this.gifDecoder.resetFrameIndex();
        this.startFromFirstFrame = false;
        goto L14
    L12:
        r2 = false;
        goto L13
    }

    private void recycleFirstFrame() {
        Bitmap r0 = this.firstFrame;
        if (r0 == null) goto L6;
        this.bitmapPool.put(r0);
        this.firstFrame = null;
        return;
    }

    void setNextStartFromFirstFrame() {
        Preconditions.checkArgument(!this.isRunning, "Can't restart a running animation");
        this.startFromFirstFrame = true;
        DelayTarget r0 = this.pendingTarget;
        if (r0 == null) goto L6;
        this.requestManager.clear(r0);
        this.pendingTarget = null;
        return;
    }

    void setOnEveryFrameReadyListener(OnEveryFrameListener r1) {
        this.onEveryFrameListener = r1;
    }

    void onFrameReady(DelayTarget r4) {
        OnEveryFrameListener r0 = this.onEveryFrameListener;
        if (r0 == null) goto L5;
        r0.onFrameReady();
    L5:
        this.isLoadPending = false;
        if (this.isCleared == false) goto L10;
        this.handler.obtainMessage(2, r4).sendToTarget();
        return;
    L10:
        if (this.isRunning == true) goto L17;
        if (this.startFromFirstFrame == false) goto L14;
        this.handler.obtainMessage(2, r4).sendToTarget();
        return;
    L14:
        this.pendingTarget = r4;
        return;
    L17:
        if (r4.getResource() == null) goto L23;
        recycleFirstFrame();
        DelayTarget r1 = this.current;
        this.current = r4;
        int r5 = this.callbacks.size() - 1;
    L19:
        if (r5 < 0) goto L21;
        this.callbacks.get(r5).onFrameReady();
        r5 = r5 - 1;
        goto L19
    L21:
        if (r1 == null) goto L23;
        this.handler.obtainMessage(2, r1).sendToTarget();
    L23:
        loadNextFrame();
    }

    private static RequestBuilder<Bitmap> getRequestBuilder(RequestManager r2, int r3, int r4) {
        return r2.asBitmap().apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE).useAnimationPool(true).skipMemoryCache(true).override(r3, r4));
    }

    private static Key getFrameSignature() {
        return new ObjectKey(Double.valueOf(Math.random()));
    }
}
