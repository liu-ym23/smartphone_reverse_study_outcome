package com.bumptech.glide.load.resource.drawable;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.DefaultOnHeaderDecodedListener;
import com.bumptech.glide.util.ByteBufferUtil;
import com.bumptech.glide.util.Util;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class AnimatedWebpDecoder {
    private final ArrayPool arrayPool;
    private final List<ImageHeaderParser> imageHeaderParsers;

    private static final class AnimatedImageDrawableResource implements Resource<Drawable> {
        private static final int ESTIMATED_NUMBER_OF_FRAMES = 2;
        private final AnimatedImageDrawable imageDrawable;

        @Override // com.bumptech.glide.load.engine.Resource
        /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
        public /* bridge */ /* synthetic */ Drawable get2() {
            return get();
        }

        AnimatedImageDrawableResource(AnimatedImageDrawable r1) {
            this.imageDrawable = r1;
        }

        @Override // com.bumptech.glide.load.engine.Resource
        public Class<Drawable> getResourceClass() {
            return Drawable.class;
        }

        @Override // com.bumptech.glide.load.engine.Resource
        public Drawable get() {
            return this.imageDrawable;
        }

        @Override // com.bumptech.glide.load.engine.Resource
        public int getSize() {
            return ((this.imageDrawable.getIntrinsicWidth() * this.imageDrawable.getIntrinsicHeight()) * Util.getBytesPerPixel(Bitmap.Config.ARGB_8888)) * 2;
        }

        @Override // com.bumptech.glide.load.engine.Resource
        public void recycle() {
            this.imageDrawable.stop();
            this.imageDrawable.clearAnimationCallbacks();
        }
    }

    private static final class ByteBufferAnimatedWebpDecoder implements ResourceDecoder<ByteBuffer, Drawable> {
        private final AnimatedWebpDecoder delegate;

        @Override // com.bumptech.glide.load.ResourceDecoder
        public /* bridge */ /* synthetic */ Resource<Drawable> decode(ByteBuffer r1, int r2, int r3, Options r4) throws IOException {
            return decode2(r1, r2, r3, r4);
        }

        @Override // com.bumptech.glide.load.ResourceDecoder
        public /* bridge */ /* synthetic */ boolean handles(ByteBuffer r1, Options r2) throws IOException {
            return handles2(r1, r2);
        }

        ByteBufferAnimatedWebpDecoder(AnimatedWebpDecoder r1) {
            this.delegate = r1;
        }

        /* JADX INFO: renamed from: handles, reason: avoid collision after fix types in other method */
        public boolean handles2(ByteBuffer r1, Options r2) throws IOException {
            return this.delegate.handles(r1);
        }

        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public Resource<Drawable> decode2(ByteBuffer r1, int r2, int r3, Options r4) throws IOException {
            ImageDecoder.Source r5 = ImageDecoder.createSource(r1);
            return this.delegate.decode(r5, r2, r3, r4);
        }
    }

    private static final class StreamAnimatedWebpDecoder implements ResourceDecoder<InputStream, Drawable> {
        private final AnimatedWebpDecoder delegate;

        @Override // com.bumptech.glide.load.ResourceDecoder
        public /* bridge */ /* synthetic */ Resource<Drawable> decode(InputStream r1, int r2, int r3, Options r4) throws IOException {
            return decode2(r1, r2, r3, r4);
        }

        @Override // com.bumptech.glide.load.ResourceDecoder
        public /* bridge */ /* synthetic */ boolean handles(InputStream r1, Options r2) throws IOException {
            return handles2(r1, r2);
        }

        StreamAnimatedWebpDecoder(AnimatedWebpDecoder r1) {
            this.delegate = r1;
        }

        /* JADX INFO: renamed from: handles, reason: avoid collision after fix types in other method */
        public boolean handles2(InputStream r1, Options r2) throws IOException {
            return this.delegate.handles(r1);
        }

        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public Resource<Drawable> decode2(InputStream r1, int r2, int r3, Options r4) throws IOException {
            ImageDecoder.Source r5 = ImageDecoder.createSource(ByteBufferUtil.fromStream(r1));
            return this.delegate.decode(r5, r2, r3, r4);
        }
    }

    public static ResourceDecoder<InputStream, Drawable> streamDecoder(List<ImageHeaderParser> r2, ArrayPool r3) {
        return new StreamAnimatedWebpDecoder(new AnimatedWebpDecoder(r2, r3));
    }

    public static ResourceDecoder<ByteBuffer, Drawable> byteBufferDecoder(List<ImageHeaderParser> r2, ArrayPool r3) {
        return new ByteBufferAnimatedWebpDecoder(new AnimatedWebpDecoder(r2, r3));
    }

    private AnimatedWebpDecoder(List<ImageHeaderParser> r1, ArrayPool r2) {
        this.imageHeaderParsers = r1;
        this.arrayPool = r2;
    }

    boolean handles(ByteBuffer r2) throws IOException {
        return isHandled(ImageHeaderParserUtils.getType(this.imageHeaderParsers, r2));
    }

    boolean handles(InputStream r3) throws IOException {
        return isHandled(ImageHeaderParserUtils.getType(this.imageHeaderParsers, r3, this.arrayPool));
    }

    private boolean isHandled(ImageHeaderParser.ImageType r1) {
        if (r1 != ImageHeaderParser.ImageType.ANIMATED_WEBP) goto L5;
        return true;
    L5:
        return false;
    }

    Resource<Drawable> decode(ImageDecoder.Source r1, int r2, int r3, Options r4) throws IOException {
        Drawable r0 = ImageDecoder.decodeDrawable(r1, new DefaultOnHeaderDecodedListener(r2, r3, r4));
        if ((r0 instanceof AnimatedImageDrawable) == false) goto L7;
        return new AnimatedImageDrawableResource((AnimatedImageDrawable) r0);
    L7:
        throw new IOException("Received unexpected drawable type for animated webp, failing: " + r0);
    }
}
