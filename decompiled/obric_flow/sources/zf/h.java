package zf;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.drawee.backends.pipeline.DefaultDrawableFactory;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.BlurHashBitmapDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.imagepipeline.SizeDeterminer;
import com.facebook.imagepipeline.blurhash.BlurDecodeProducer;
import com.facebook.imagepipeline.blurhash.BlurHashConfig;
import com.facebook.imagepipeline.blurhash2.PreviewBlurHashProducer;
import com.facebook.imagepipeline.blurhash2.PreviewHashConfig;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheKey;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.cache.InstrumentedMemoryCache;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.lynx.fresco.FrescoImagePrefetchHelper;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.service.ILynxImageService;
import com.lynx.tasm.service.ILynxImageServiceExtension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements ILynxImageService, ILynxImageServiceExtension {
    public static volatile h f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DefaultDrawableFactory f23433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InstrumentedMemoryCache f23434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap f23435c;
    public Resources d;
    public final UiThreadImmediateExecutorService e;

    public h() {
        this.f23435c = new ConcurrentHashMap();
        this.d = null;
        this.e = UiThreadImmediateExecutorService.b();
    }

    public static h a() {
        if (f != null) goto L16;
        monitor-enter(h.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f != null) goto L11;
        f = new h();     // Catch: Throwable -> L9
    L11:
        monitor-exit(h.class);     // Catch: Throwable -> L9
    L16:
        return f;
    }

    public static void b(Bitmap r10, GenericDraweeHierarchy r11, ImageRequest r12, ScalingUtils.ScaleType r13, long r14, int r15, int r16, String r17) {
        if (r11 == null) goto L12;
        if (r12 == null) goto L13;
        if (r10 != null) goto L7;
    L10:
        r12.setPreviewError(r17);
        return;
    L7:
        if (r10.isRecycled() == true) goto L10;
        com.lynx.tasm.utils.j.f(new a(r10, r14, r12, r11, new BlurHashBitmapDrawable(r10, r15, r16, r13)));
        return;
    L13:
        return;
    }

    public static boolean c(xn.e r5, Drawable r10, xn.a r11) {
        return false;
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final boolean canParseUrl(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L6;
        return true;
    L6:
        if (r5.startsWith("file://") == false) goto L8;
    L16:
        return true;
    L8:
        if (r5.startsWith("content://") == true) goto L16;
        if (r5.startsWith("asset://") == true) goto L16;
        if (r5.startsWith("data:") == true) goto L16;
        return false;
    }

    @Override // com.lynx.tasm.service.ILynxImageServiceExtension
    public final an.c createBackgroundImageDrawable(Context r5, String r10) {
        if (LynxEnv.inst().getBackgroundImageLoader() == null) goto L6;
        ((com.lynx.tasm.ui.image.j) LynxEnv.inst().getBackgroundImageLoader()).getClass();
        return new com.lynx.tasm.ui.image.i(r5, r10);
    L6:
        return null;
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final void decodeImage(xn.e r10, xn.d r11) {
        if (r10 == null) goto L5;
        ImagePipeline r5 = Fresco.a().e();
        ImageDecodeOptions r12 = ImageDecodeOptions.e;
        ImageDecodeOptionsBuilder r13 = new ImageDecodeOptionsBuilder();
        r13.f8046b = r10.d;
        r13.d = true;
        ImageRequestBuilder r14 = ImageRequestBuilder.a(Uri.parse(r10.f23182a));
        r14.f8436c = new ResizeOptions(Integer.MAX_VALUE, Integer.MAX_VALUE, 2.1474836E9f);
        r14.e = new ImageDecodeOptions(r13);
        r5.a(r14.a(), null, ImageRequest.RequestLevel.f8431b, null).a(new oo.a(r10, r11), CallerThreadExecutor.f7644a);
        return;
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final void fetchImage(xn.e r12, xn.d r13, xn.a r14, Context r15) {
        if (this.d != null) goto L6;
        this.d = r15.getResources();
    L6:
        if (this.f23433a != null) goto L9;
        Resources r5 = this.d;
        Fresco.a().a();
        this.f23433a = new DefaultDrawableFactory(r5);
    L9:
        if (this.f23434b != null) goto L11;
        this.f23434b = Fresco.a().c();
    L11:
        ImageRequestBuilder r16 = ImageRequestBuilder.a(Uri.parse(r12.f23182a));
        ImageDecodeOptionsBuilder r10 = new ImageDecodeOptionsBuilder();
        r10.a(0);
        Bitmap.Config r11 = r12.d;
        if (r11 == null) goto L15;
        r10.f8046b = r11;
        r10.d = true;
    L15:
        if (r12.f == false) goto L17;
        r10.f8047c = new ag.a();
    L17:
        r16.d = RotationOptions.f8054c;
        r16.g = false;
        if (r12.e == true) goto L26;
        if (r12.g == false) goto L22;
        ResizeOptions r17 = new ResizeOptions(r12.f23183b, r12.f23184c, 2048.0f);
    L23:
        if (r17 == null) goto L26;
        r16.f8436c = r17;
        goto L26
    L22:
        r17 = null;
    L26:
        if (r12.f23185h == false) goto L28;
        r16.f8437h = Priority.f8050c;
    L28:
        ArrayList r18 = r12.f23186i;
        if (r18 != null) goto L31;
    L33:
        ImageRequest r19 = r16.a();
        InstrumentedMemoryCache r110 = this.f23434b;
        if (bg.a.f913a != null) goto L36;
        bg.a.f913a = Fresco.a().e().f;
    L36:
        DefaultCacheKeyFactory r20 = bg.a.f913a;
        if (r20 != null) goto L39;
        BitmapMemoryCacheKey r21 = null;
    L43:
        if (r110 == null) goto L47;
        if (r21 == null) goto L47;
        CloseableReference r111 = r110.a(r21);
    L48:
        if (r111 == null) goto L59;
        monitor-enter(r111);
        Object r22 = r111.f7671b.d();     // Catch: Throwable -> L56
        monitor-exit(r111);     // Catch: Throwable -> L56
        CloseableImage r23 = (CloseableImage) r22;
        if ((r23 instanceof CloseableStaticBitmap) == false) goto L59;
        CloseableStaticBitmap r24 = (CloseableStaticBitmap) r23;
        r13.e(new wn.b(new i4.a(r111)), r12, new xn.c(r24.getWidth(), r24.getHeight(), false));
        return;
    L56:
        th = move-exception;
        throw th;
    L59:
        b r25 = new b(this, r12, r13, r14);
        if (r12.f23185h == false) goto L63;
        mn.h.j().execute(new com.bytedance.android.anniex.scene.core.i(this, r19, r25, 25, false));
        return;
    L63:
        Fresco.a().e().a(r19, null, ImageRequest.RequestLevel.f8431b, null).a(r25, this.e);
        return;
    L47:
        r111 = null;
        goto L48
    L39:
        if (r19.f8422m == null) goto L41;
        r21 = r20.b(r19, null);
        goto L43
    L41:
        r21 = r20.a(r19, null);
        goto L43
    L31:
        if (r18.isEmpty() == true) goto L33;
        r16.f8438i = new ag.f(r12.f23186i, r12.d);
        goto L33
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final Object getImageSRPostProcessor() {
        return i.a();
    }

    @Override // com.lynx.tasm.service.ILynxImageServiceExtension
    public final void onLynxEnvSetup() {
        mn.h.i().execute(new so.e(10));
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final boolean pauseAnimation(Drawable r5) {
        return false;
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final void prefetchImage(String r5, Object r10, Map r11) {
        prefetchImage(r5, r10, r11, null);
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final void releaseAnimDrawable(Drawable r5) {
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final void releaseImage(xn.e r5) {
        if (r5 == null) goto L7;
        CloseableReference r10 = (CloseableReference) this.f23435c.remove(r5);
        if (r10 == null) goto L8;
        r10.close();
        return;
    L8:
        return;
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final boolean resumeAnimation(Drawable r5) {
        return false;
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final void setCustomImageDecoder(Object r5) {
        if ((r5 instanceof ImageDecodeOptionsBuilder) == false) goto L6;
        ag.a r10 = new ag.a();
        ((ImageDecodeOptionsBuilder) r5).f8047c = r10;
        return;
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final void setImageCacheChoice(String r5, Object r10) {
        if ((r10 instanceof ImageRequestBuilder) == false) goto L6;
        ImageRequestBuilder r11 = (ImageRequestBuilder) r10;
        r11.f = ImageRequest.CacheChoice.f8428a;
        r5.getClass();
        r11.f8441l = r5;
        return;
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final void setImagePlaceHolderHash(Object r13, Object r14, Object r15, String r16, String r17, int r18, int r19, int r20, int r21, boolean r22) {
        if ((r14 instanceof ImageRequest) == true) goto L5;
        return;
    L5:
        if ((r13 instanceof GenericDraweeHierarchy) == true) goto L7;
        return;
    L7:
        if ((r15 instanceof ScalingUtils.ScaleType) == true) goto L9;
        return;
    L9:
        if (r22 == true) goto L12;
        ImageRequest r10 = (ImageRequest) r14;
        r10.setPreviewUsed(true);
        r10.setPreviewAlgo(1);
        BlurHashConfig r11 = new BlurHashConfig(r18, r19);
        GenericDraweeHierarchy r5 = (GenericDraweeHierarchy) r13;
        ScalingUtils.ScaleType r12 = (ScalingUtils.ScaleType) r15;
        new BlurDecodeProducer(r16, r11, new e(r5, r10, r12, SystemClock.uptimeMillis(), r11, r16));
        return;
    L12:
        ImageRequest r23 = (ImageRequest) r14;
        r23.setPreviewUsed(true);
        r23.setPreviewAlgo(2);
        SystemClock.uptimeMillis();
        PreviewHashConfig r24 = new PreviewHashConfig(r21, r20, r18, r19);
        if (TextUtils.isEmpty(r17) == true) goto L16;
        new PreviewBlurHashProducer(r16, r17, r24, new f());
        return;
    L16:
        new PreviewBlurHashProducer(r16, r24, new g());
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final void setImageSRSize(Object r5, View r10) {
        if ((r5 instanceof ImageRequest) == false) goto L6;
        new SizeDeterminer(r10);
        ((ImageRequest) r5).getClass();
        return;
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final boolean startAnimation(Drawable r5) {
        return false;
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final boolean stopAnimation(Drawable r5) {
        return false;
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public final void prefetchImage(String r10, Object r11, Map r12, xn.d r13) {
        Map r5 = null;
        if (r12 != null) goto L5;
        String r14 = null;
    L6:
        if (r12 != null) goto L8;
        String r15 = null;
    L9:
        if (r12 == null) goto L12;
        r5 = (Map) r12.get("additional-custom-info");
    L12:
        Uri r16 = Uri.parse(r10);
        if (r16.getScheme() == null) goto L52;
        ImageRequestBuilder r17 = ImageRequestBuilder.a(r16);
        ImageDecodeOptionsBuilder r18 = new ImageDecodeOptionsBuilder();
        r18.f8046b = Bitmap.Config.ARGB_8888;
        r18.d = true;
        r18.a(0);
        r17.e = new ImageDecodeOptions(r18);
        if (r5 == null) goto L26;
        HashMap r19 = new HashMap();
        Iterator r20 = r5.entrySet().iterator();
    L19:
        if (r20.hasNext() == false) goto L25;
        Map.Entry r21 = (Map.Entry) r20.next();
        Object r22 = r21.getKey();
        if (r21.getValue() != null) goto L23;
        String r23 = "";
    L24:
        r19.put(r22, r23);
        goto L19
    L23:
        r23 = (String) r21.getValue();
        goto L24
    L25:
        r17.a(r19);
    L26:
        if (r15 != null) goto L28;
    L33:
        ImageRequest r24 = r17.a();
        if (r14 != null) goto L36;
    L38:
        if (r14 != null) goto L40;
    L42:
        Priority r25 = Priority.f8048a;
    L43:
        AbstractDataSource r26 = Fresco.a().e().a(r24, r11, r25);
        if (r13 == null) goto L51;
        r26.a(new d(r13, 0), CallerThreadExecutor.f7644a);
        return;
    L51:
        return;
    L40:
        if (r14.equals("medium") == false) goto L42;
        r25 = Priority.f8049b;
        goto L43
    L36:
        if (r14.equals(FrescoImagePrefetchHelper.PRIORITY_HIGH) == false) goto L38;
        r25 = Priority.f8050c;
        goto L43
    L28:
        if (r15.equals("bitmap") == false) goto L33;
        AbstractDataSource r27 = Fresco.a().e().a(r17.a(), r11);
        if (r13 == null) goto L50;
        r27.a(new d(r13, 1), CallerThreadExecutor.f7644a);
        return;
    L50:
        return;
    L52:
        return;
    L8:
        r15 = (String) r12.get("cacheTarget");
        goto L9
    L5:
        r14 = (String) r12.get("priority");
        goto L6
    }
}
