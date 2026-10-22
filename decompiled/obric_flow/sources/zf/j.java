package zf;

import com.facebook.cache.disk.DiskStorageCache;
import com.facebook.cache.disk.DynamicDefaultDiskStorage;
import com.facebook.common.executors.ConstrainedExecutorService;
import com.facebook.common.internal.Suppliers;
import com.facebook.common.statfs.StatFsHelper;
import com.facebook.common.util.HashCodeUtil;
import com.facebook.common.util.UriUtil;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.drawee.backends.pipeline.DefaultDrawableFactory;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ArrayDrawable;
import com.facebook.drawee.drawable.DrawableProperties;
import com.facebook.drawee.drawable.DrawableUtils;
import com.facebook.drawee.drawable.FadeDrawable;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.drawable.RoundedColorDrawable;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.generic.WrappingUtils;
import com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl;
import com.facebook.fresco.animation.factory.ExperimentalBitmapAnimationDrawableFactory;
import com.facebook.imageformat.DefaultImageFormatChecker;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.bitmaps.ArtBitmapFactory;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.BitmapCountingMemoryCacheFactory;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheFactory;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheKey;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CountingLruMap;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.HashMapMemoryCache;
import com.facebook.imagepipeline.cache.StagingArea;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ProducerFactory;
import com.facebook.imagepipeline.core.ProducerSequenceFactory;
import com.facebook.imagepipeline.decoder.DefaultImageDecoder;
import com.facebook.imagepipeline.listener.ForwardingRequestListener;
import com.facebook.imagepipeline.memory.BucketsBitmapPool;
import com.facebook.imagepipeline.platform.DefaultDecoder;
import com.facebook.imagepipeline.platform.OreoDecoder;
import com.facebook.imagepipeline.producers.NetworkFetchProducer;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.transcoder.MultiImageTranscoderFactory;
import com.lynx.tasm.behavior.ui.image.FlattenUIImage;
import com.lynx.tasm.behavior.ui.image.UIImage;
import com.lynx.tasm.image.AutoSizeImage;

/* JADX INFO: loaded from: classes2.dex */
public final class j implements com.lynx.tasm.a {
    public final void a() {
        Class.forName(FlattenUIImage.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(wn.e.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(wn.h.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(wn.f.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(dn.f.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(UIImage.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(bg.a.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(AutoSizeImage.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(xn.f.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(xn.e.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(h.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(DefaultDrawableFactory.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(DefaultDecoder.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(PlatformBitmapFactory.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(CountingMemoryCache.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(CountingLruMap.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(DiskStorageCache.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(ProducerSequenceFactory.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(ImagePipeline.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(ExperimentalBitmapAnimationDrawableFactory.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(DefaultImageDecoder.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(BufferedDiskCache.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(ProducerFactory.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(NetworkFetchProducer.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(AnimatedFactoryV2Impl.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(PipelineDraweeControllerBuilder.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(BaseControllerListener.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(GenericDraweeHierarchyBuilder.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(RoundingParams.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(GenericDraweeHierarchy.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(ForwardingDrawable.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(DrawableProperties.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(DrawableUtils.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(WrappingUtils.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(ScaleTypeDrawable.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(ArrayDrawable.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(FadeDrawable.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(RoundedColorDrawable.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(ImageRequestBuilder.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(ImageDecodeOptionsBuilder.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(ImageDecodeOptions.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(ImageRequest.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(ImageRequest.RequestLevel.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(ImageRequest.CacheChoice.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(Priority.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(RotationOptions.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(ResizeOptions.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(UriUtil.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(BitmapMemoryCacheKey.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(HashCodeUtil.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(BucketsBitmapPool.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(BitmapCountingMemoryCacheFactory.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(HashMapMemoryCache.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(ConstrainedExecutorService.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(ImageFormatChecker.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(DynamicDefaultDiskStorage.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(StatFsHelper.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(ForwardingRequestListener.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(StagingArea.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(MultiImageTranscoderFactory.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(Suppliers.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(DefaultImageFormatChecker.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(BitmapMemoryCacheFactory.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(ArtBitmapFactory.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(OreoDecoder.class.getName());     // Catch: ClassNotFoundException -> L4
        Class.forName(BaseDataSubscriber.class.getName());     // Catch: ClassNotFoundException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }
}
