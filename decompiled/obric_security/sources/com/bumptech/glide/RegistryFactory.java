package com.bumptech.glide;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.data.InputStreamRewinder;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.model.AssetUriLoader;
import com.bumptech.glide.load.model.ByteArrayLoader;
import com.bumptech.glide.load.model.ByteBufferEncoder;
import com.bumptech.glide.load.model.ByteBufferFileLoader;
import com.bumptech.glide.load.model.DataUrlLoader;
import com.bumptech.glide.load.model.DirectResourceLoader;
import com.bumptech.glide.load.model.FileLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.MediaStoreFileLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.ResourceLoader;
import com.bumptech.glide.load.model.ResourceUriLoader;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.model.StringLoader;
import com.bumptech.glide.load.model.UnitModelLoader;
import com.bumptech.glide.load.model.UriLoader;
import com.bumptech.glide.load.model.UrlUriLoader;
import com.bumptech.glide.load.model.stream.HttpGlideUrlLoader;
import com.bumptech.glide.load.model.stream.MediaStoreImageThumbLoader;
import com.bumptech.glide.load.model.stream.MediaStoreVideoThumbLoader;
import com.bumptech.glide.load.model.stream.QMediaStoreUriLoader;
import com.bumptech.glide.load.model.stream.UrlLoader;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableEncoder;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapImageDecoderResourceDecoder;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.ExifInterfaceImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.InputStreamBitmapImageDecoderResourceDecoder;
import com.bumptech.glide.load.resource.bitmap.ParcelFileDescriptorBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.ResourceBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.StreamBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.UnitBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.load.resource.bytes.ByteBufferRewinder;
import com.bumptech.glide.load.resource.drawable.AnimatedImageDecoder;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;
import com.bumptech.glide.load.resource.drawable.UnitDrawableDecoder;
import com.bumptech.glide.load.resource.file.FileDecoder;
import com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableEncoder;
import com.bumptech.glide.load.resource.gif.GifFrameResourceDecoder;
import com.bumptech.glide.load.resource.gif.StreamGifDecoder;
import com.bumptech.glide.load.resource.transcode.BitmapBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.BitmapDrawableTranscoder;
import com.bumptech.glide.load.resource.transcode.DrawableBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.GifDrawableBytesTranscoder;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.module.GlideModule;
import com.bumptech.glide.util.GlideSuppliers;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class RegistryFactory {
    private RegistryFactory() {
    }

    static GlideSuppliers.GlideSupplier<Registry> lazilyCreateAndInitializeRegistry(final Glide r1, final List<GlideModule> r2, final AppGlideModule r3) {
        return new AnonymousClass1(r1, r2, r3);
    }

    static Registry createAndInitRegistry(Glide r5, List<GlideModule> r6, AppGlideModule r7) {
        BitmapPool r0 = r5.getBitmapPool();
        ArrayPool r1 = r5.getArrayPool();
        Context r2 = r5.getGlideContext().getApplicationContext();
        GlideExperiments r3 = r5.getGlideContext().getExperiments();
        Registry r4 = new Registry();
        initializeDefaults(r2, r4, r0, r1, r3);
        initializeModules(r2, r5, r4, r6, r7);
        return r4;
    }

    private static void initializeDefaults(Context r19, Registry r20, BitmapPool r21, ArrayPool r22, GlideExperiments r23) {
        r20.register(new DefaultImageHeaderParser());
        r20.register(new ExifInterfaceImageHeaderParser());
        Resources r4 = r19.getResources();
        List<ImageHeaderParser> r5 = r20.getImageHeaderParsers();
        ByteBufferGifDecoder r6 = new ByteBufferGifDecoder(r19, r5, r21, r22);
        ResourceDecoder<ParcelFileDescriptor, Bitmap> r7 = VideoDecoder.parcel(r21);
        Downsampler r8 = new Downsampler(r20.getImageHeaderParsers(), r4.getDisplayMetrics(), r21, r22);
        if (r23.isEnabled(GlideBuilder.EnableImageDecoderForBitmaps.class) == false) goto L5;
        ResourceDecoder r9 = new InputStreamBitmapImageDecoderResourceDecoder();
        ResourceDecoder r10 = new ByteBufferBitmapImageDecoderResourceDecoder();
    L6:
        r20.append("Animation", InputStream.class, Drawable.class, AnimatedImageDecoder.streamDecoder(r5, r22));
        r20.append("Animation", ByteBuffer.class, Drawable.class, AnimatedImageDecoder.byteBufferDecoder(r5, r22));
        ResourceDrawableDecoder r11 = new ResourceDrawableDecoder(r19);
        BitmapEncoder r12 = new BitmapEncoder(r22);
        BitmapBytesTranscoder r13 = new BitmapBytesTranscoder();
        GifDrawableBytesTranscoder r15 = new GifDrawableBytesTranscoder();
        ContentResolver r16 = r19.getContentResolver();
        r20.append(ByteBuffer.class, new ByteBufferEncoder()).append(InputStream.class, new StreamEncoder(r22)).append(Registry.BUCKET_BITMAP, ByteBuffer.class, Bitmap.class, r10).append(Registry.BUCKET_BITMAP, InputStream.class, Bitmap.class, r9);
        if (ParcelFileDescriptorRewinder.isSupported() == false) goto L9;
        r20.append(Registry.BUCKET_BITMAP, ParcelFileDescriptor.class, Bitmap.class, new ParcelFileDescriptorBitmapDecoder(r8));
    L9:
        r20.append(Registry.BUCKET_BITMAP, AssetFileDescriptor.class, Bitmap.class, VideoDecoder.asset(r21));
        r20.append(Registry.BUCKET_BITMAP, ParcelFileDescriptor.class, Bitmap.class, r7).append(Bitmap.class, Bitmap.class, UnitModelLoader.Factory.getInstance()).append(Registry.BUCKET_BITMAP, Bitmap.class, Bitmap.class, new UnitBitmapDecoder()).append(Bitmap.class, r12).append(Registry.BUCKET_BITMAP_DRAWABLE, ByteBuffer.class, BitmapDrawable.class, new BitmapDrawableDecoder(r4, r10)).append(Registry.BUCKET_BITMAP_DRAWABLE, InputStream.class, BitmapDrawable.class, new BitmapDrawableDecoder(r4, r9)).append(Registry.BUCKET_BITMAP_DRAWABLE, ParcelFileDescriptor.class, BitmapDrawable.class, new BitmapDrawableDecoder(r4, r7)).append(BitmapDrawable.class, new BitmapDrawableEncoder(r21, r12)).append("Animation", InputStream.class, GifDrawable.class, new StreamGifDecoder(r5, r6, r22)).append("Animation", ByteBuffer.class, GifDrawable.class, r6).append(GifDrawable.class, new GifDrawableEncoder()).append(GifDecoder.class, GifDecoder.class, UnitModelLoader.Factory.getInstance()).append(Registry.BUCKET_BITMAP, GifDecoder.class, Bitmap.class, new GifFrameResourceDecoder(r21)).append(Uri.class, Drawable.class, r11).append(Uri.class, Bitmap.class, new ResourceBitmapDecoder(r11, r21)).register(new ByteBufferRewinder.Factory()).append(File.class, ByteBuffer.class, new ByteBufferFileLoader.Factory()).append(File.class, InputStream.class, new FileLoader.StreamFactory()).append(File.class, File.class, new FileDecoder()).append(File.class, ParcelFileDescriptor.class, new FileLoader.FileDescriptorFactory()).append(File.class, File.class, UnitModelLoader.Factory.getInstance()).register(new InputStreamRewinder.Factory(r22));
        if (ParcelFileDescriptorRewinder.isSupported() == false) goto L12;
        r20.register(new ParcelFileDescriptorRewinder.Factory());
    L12:
        ModelLoaderFactory<Integer, InputStream> r0 = DirectResourceLoader.inputStreamFactory(r19);
        ModelLoaderFactory<Integer, AssetFileDescriptor> r3 = DirectResourceLoader.assetFileDescriptorFactory(r19);
        ModelLoaderFactory<Integer, Drawable> r14 = DirectResourceLoader.drawableFactory(r19);
        r20.append(Integer.TYPE, InputStream.class, r0).append(Integer.class, InputStream.class, r0).append(Integer.TYPE, AssetFileDescriptor.class, r3).append(Integer.class, AssetFileDescriptor.class, r3).append(Integer.TYPE, Drawable.class, r14).append(Integer.class, Drawable.class, r14).append(Uri.class, InputStream.class, ResourceUriLoader.newStreamFactory(r19)).append(Uri.class, AssetFileDescriptor.class, ResourceUriLoader.newAssetFileDescriptorFactory(r19));
        ResourceLoader.UriFactory r1 = new ResourceLoader.UriFactory(r4);
        ResourceLoader.AssetFileDescriptorFactory r17 = new ResourceLoader.AssetFileDescriptorFactory(r4);
        ResourceLoader.StreamFactory r18 = new ResourceLoader.StreamFactory(r4);
        r20.append(Integer.class, Uri.class, r1).append(Integer.TYPE, Uri.class, r1).append(Integer.class, AssetFileDescriptor.class, r17).append(Integer.TYPE, AssetFileDescriptor.class, r17).append(Integer.class, InputStream.class, r18).append(Integer.TYPE, InputStream.class, r18);
        r20.append(String.class, InputStream.class, new DataUrlLoader.StreamFactory()).append(Uri.class, InputStream.class, new DataUrlLoader.StreamFactory()).append(String.class, InputStream.class, new StringLoader.StreamFactory()).append(String.class, ParcelFileDescriptor.class, new StringLoader.FileDescriptorFactory()).append(String.class, AssetFileDescriptor.class, new StringLoader.AssetFileDescriptorFactory()).append(Uri.class, InputStream.class, new AssetUriLoader.StreamFactory(r19.getAssets())).append(Uri.class, AssetFileDescriptor.class, new AssetUriLoader.FileDescriptorFactory(r19.getAssets())).append(Uri.class, InputStream.class, new MediaStoreImageThumbLoader.Factory(r19)).append(Uri.class, InputStream.class, new MediaStoreVideoThumbLoader.Factory(r19));
        r20.append(Uri.class, InputStream.class, new QMediaStoreUriLoader.InputStreamFactory(r19));
        r20.append(Uri.class, ParcelFileDescriptor.class, new QMediaStoreUriLoader.FileDescriptorFactory(r19));
        r20.append(Uri.class, InputStream.class, new UriLoader.StreamFactory(r16)).append(Uri.class, ParcelFileDescriptor.class, new UriLoader.FileDescriptorFactory(r16)).append(Uri.class, AssetFileDescriptor.class, new UriLoader.AssetFileDescriptorFactory(r16)).append(Uri.class, InputStream.class, new UrlUriLoader.StreamFactory()).append(URL.class, InputStream.class, new UrlLoader.StreamFactory()).append(Uri.class, File.class, new MediaStoreFileLoader.Factory(r19)).append(GlideUrl.class, InputStream.class, new HttpGlideUrlLoader.Factory()).append(byte[].class, ByteBuffer.class, new ByteArrayLoader.ByteBufferFactory()).append(byte[].class, InputStream.class, new ByteArrayLoader.StreamFactory()).append(Uri.class, Uri.class, UnitModelLoader.Factory.getInstance()).append(Drawable.class, Drawable.class, UnitModelLoader.Factory.getInstance()).append(Drawable.class, Drawable.class, new UnitDrawableDecoder()).register(Bitmap.class, BitmapDrawable.class, new BitmapDrawableTranscoder(r4)).register(Bitmap.class, byte[].class, r13).register(Drawable.class, byte[].class, new DrawableBytesTranscoder(r21, r13, r15)).register(GifDrawable.class, byte[].class, r15);
        ResourceDecoder<ByteBuffer, Bitmap> r2 = VideoDecoder.byteBuffer(r21);
        r20.append(ByteBuffer.class, Bitmap.class, r2);
        r20.append(ByteBuffer.class, BitmapDrawable.class, new BitmapDrawableDecoder(r4, r2));
        return;
    L5:
        r10 = new ByteBufferBitmapDecoder(r8);
        r9 = new StreamBitmapDecoder(r8, r22);
        goto L6
    }

    private static void initializeModules(Context r1, Glide r2, Registry r3, List<GlideModule> r4, AppGlideModule r5) {
        Iterator<GlideModule> r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L11;
        GlideModule r0 = r6.next();
        r0.registerComponents(r1, r2, r3);     // Catch: AbstractMethodError -> L8
    L8:
        e = move-exception;
        throw new IllegalStateException("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: " + r0.getClass().getName(), e);
    L11:
        if (r5 == null) goto L18;
        r5.registerComponents(r1, r2, r3);
        return;
    }
}
