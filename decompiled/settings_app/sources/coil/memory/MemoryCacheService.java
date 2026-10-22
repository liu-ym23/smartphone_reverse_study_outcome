package coil.memory;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import coil.EventListener;
import coil.ImageLoader;
import coil.decode.DataSource;
import coil.decode.DecodeUtils;
import coil.intercept.EngineInterceptor;
import coil.intercept.Interceptor;
import coil.request.ImageRequest;
import coil.request.Options;
import coil.request.RequestService;
import coil.request.SuccessResult;
import coil.size.Dimension;
import coil.size.Scale;
import coil.size.Size;
import coil.size.Sizes;
import coil.transform.Transformation;
import coil.util.Bitmaps;
import coil.util.Logger;
import coil.util.Requests;
import coil.util.Utils;
import com.bytedance.apm.constant.PerfConsts;
import com.obric.capabilitykit.common.Ext;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: MemoryCacheService.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 +2\u00020\u0001:\u0001+B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ(\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J5\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0001¢\u0006\u0002\b\u001cJ0\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J(\u0010\u001e\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#J&\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u000bJ \u0010(\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010)\u001a\u00020*R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u0004\u0018\u00010\n*\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\u000f*\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010¨\u0006,"}, d2 = {"Lcoil/memory/MemoryCacheService;", "", "imageLoader", "Lcoil/ImageLoader;", "requestService", "Lcoil/request/RequestService;", "logger", "Lcoil/util/Logger;", "(Lcoil/ImageLoader;Lcoil/request/RequestService;Lcoil/util/Logger;)V", "diskCacheKey", "", "Lcoil/memory/MemoryCache$Value;", "getDiskCacheKey", "(Lcoil/memory/MemoryCache$Value;)Ljava/lang/String;", "isSampled", "", "(Lcoil/memory/MemoryCache$Value;)Z", "getCacheValue", Ext.KEY_REQUEST, "Lcoil/request/ImageRequest;", "cacheKey", "Lcoil/memory/MemoryCache$Key;", PerfConsts.PERF_DISK_FILE_SIZE, "Lcoil/size/Size;", "scale", "Lcoil/size/Scale;", "isCacheValueValid", "cacheValue", "isCacheValueValid$coil_base_release", "isSizeValid", "newCacheKey", "mappedData", "options", "Lcoil/request/Options;", "eventListener", "Lcoil/EventListener;", "newResult", "Lcoil/request/SuccessResult;", "chain", "Lcoil/intercept/Interceptor$Chain;", "setCacheValue", "result", "Lcoil/intercept/EngineInterceptor$ExecuteResult;", "Companion", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MemoryCacheService {
    public static final Companion Companion = null;
    public static final String EXTRA_DISK_CACHE_KEY = "coil#disk_cache_key";
    public static final String EXTRA_IS_SAMPLED = "coil#is_sampled";
    public static final String EXTRA_TRANSFORMATION_INDEX = "coil#transformation_";
    public static final String EXTRA_TRANSFORMATION_SIZE = "coil#transformation_size";
    private static final String TAG = "MemoryCacheService";
    private final ImageLoader imageLoader;
    private final Logger logger;
    private final RequestService requestService;

    /* JADX INFO: compiled from: MemoryCacheService.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\u0016\u0010\u0006\u001a\u00020\u00048\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002R\u0016\u0010\b\u001a\u00020\u00048\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\t\u0010\u0002R\u0016\u0010\n\u001a\u00020\u00048\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0002R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcoil/memory/MemoryCacheService$Companion;", "", "()V", "EXTRA_DISK_CACHE_KEY", "", "getEXTRA_DISK_CACHE_KEY$coil_base_release$annotations", "EXTRA_IS_SAMPLED", "getEXTRA_IS_SAMPLED$coil_base_release$annotations", "EXTRA_TRANSFORMATION_INDEX", "getEXTRA_TRANSFORMATION_INDEX$coil_base_release$annotations", "EXTRA_TRANSFORMATION_SIZE", "getEXTRA_TRANSFORMATION_SIZE$coil_base_release$annotations", "TAG", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ void getEXTRA_DISK_CACHE_KEY$coil_base_release$annotations() {
        }

        public static /* synthetic */ void getEXTRA_IS_SAMPLED$coil_base_release$annotations() {
        }

        public static /* synthetic */ void getEXTRA_TRANSFORMATION_INDEX$coil_base_release$annotations() {
        }

        public static /* synthetic */ void getEXTRA_TRANSFORMATION_SIZE$coil_base_release$annotations() {
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public MemoryCacheService(ImageLoader r1, RequestService r2, Logger r3) {
        this.imageLoader = r1;
        this.requestService = r2;
        this.logger = r3;
    }

    public final MemoryCache.Key newCacheKey(ImageRequest r5, Object r6, Options r7, EventListener r8) {
        MemoryCache.Key r0 = r5.getMemoryCacheKey();
        if (r0 == null) goto L5;
        return r0;
    L5:
        r8.keyStart(r5, r6);
        String r4 = this.imageLoader.getComponents().key(r6, r7);
        r8.keyEnd(r5, r4);
        if (r4 != null) goto L8;
        return null;
    L8:
        List<Transformation> r9 = r5.getTransformations();
        Map<String, String> r1 = r5.getParameters().memoryCacheKeys();
        if (r9.isEmpty() == true) goto L11;
    L14:
        Map r10 = MapsKt.toMutableMap(r1);
        if ((!r9.isEmpty()) == false) goto L21;
        List<Transformation> r11 = r5.getTransformations();
        int r12 = r11.size();
        int r2 = 0;
    L17:
        if (r2 >= r12) goto L19;
        r10.put(EXTRA_TRANSFORMATION_INDEX + r2, r11.get(r2).getCacheKey());
        r2 = r2 + 1;
        goto L17
    L19:
        r10.put(EXTRA_TRANSFORMATION_SIZE, r7.getSize().toString());
    L21:
        return new MemoryCache.Key(r4, r10);
    L11:
        if (r1.isEmpty() == false) goto L14;
        return new MemoryCache.Key(r4, null, 2, null);
    }

    public final MemoryCache.Value getCacheValue(ImageRequest r9, MemoryCache.Key r10, Size r11, Scale r12) {
        if (r9.getMemoryCachePolicy().getReadEnabled() == true) goto L5;
        return null;
    L5:
        MemoryCache r0 = this.imageLoader.getMemoryCache();
        if (r0 == null) goto L8;
        MemoryCache.Value r1 = r0.get(r10);
    L9:
        if (r1 != null) goto L11;
        return null;
    L11:
        if (isCacheValueValid$coil_base_release(r9, r10, r1, r11, r12) == true) goto L13;
        return null;
    L13:
        return r1;
    L8:
        r1 = null;
        goto L9
    }

    public final boolean isCacheValueValid$coil_base_release(ImageRequest r3, MemoryCache.Key r4, MemoryCache.Value r5, Size r6, Scale r7) {
        if (this.requestService.isConfigValidForHardware(r3, Bitmaps.getSafeConfig(r5.getBitmap())) == true) goto L12;
        Logger r2 = this.logger;
        if (r2 != null) goto L7;
        return false;
    L7:
        if (r2.getLevel() > 3) goto L14;
        r2.log(TAG, 3, r3.getData() + ": Cached bitmap is hardware-backed, which is incompatible with the request.", null);
        return false;
    L14:
        return false;
    L12:
        return isSizeValid(r3, r4, r5, r6, r7);
    }

    private final boolean isSizeValid(ImageRequest r18, MemoryCache.Key r19, MemoryCache.Value r20, Size r21, Scale r22) {
        boolean r3 = isSampled(r20);
        if (Sizes.isOriginal(r21) == false) goto L12;
        if (r3 == false) goto L11;
        Logger r0 = this.logger;
        if (r0 != null) goto L8;
    L10:
        return false;
    L8:
        if (r0.getLevel() > 3) goto L10;
        r0.log(TAG, 3, r18.getData() + ": Requested original size, but cached image is sampled.", null);
        goto L10
    L11:
        return true;
    L12:
        String r4 = r19.getExtras().get(EXTRA_TRANSFORMATION_SIZE);
        if (r4 != null) goto L15;
        int r5 = r20.getBitmap().getWidth();
        int r1 = r20.getBitmap().getHeight();
        Dimension r10 = r21.getWidth();
        int r12 = Integer.MAX_VALUE;
        if ((r10 instanceof Dimension.Pixels) == false) goto L19;
        int r11 = ((Dimension.Pixels) r10).px;
    L20:
        Dimension r13 = r21.getHeight();
        if ((r13 instanceof Dimension.Pixels) == false) goto L23;
        r12 = ((Dimension.Pixels) r13).px;
    L23:
        double r14 = DecodeUtils.computeSizeMultiplier(r5, r1, r11, r12, r22);
        boolean r15 = Requests.getAllowInexactSize(r18);
        if (r15 == false) goto L32;
        double r16 = RangesKt.coerceAtMost(r14, 1.0d);
        if (Math.abs(((double) r11) - (((double) r5) * r16)) > 1.0d) goto L28;
        return true;
    L28:
        if (Math.abs(((double) r12) - (r16 * ((double) r1))) > 1.0d) goto L43;
        return true;
    L43:
        if (r14 != 1.0d) goto L45;
        boolean r6 = true;
    L47:
        if (r6 == true) goto L57;
        if (r15 == true) goto L57;
        Logger r2 = this.logger;
        if (r2 != null) goto L52;
        return false;
    L52:
        if (r2.getLevel() > 3) goto L72;
        r2.log(TAG, 3, r18.getData() + ": Cached image's request size (" + r5 + ", " + r1 + ") does not exactly match the requested size (" + r21.getWidth() + ", " + r21.getHeight() + ", " + r22 + ").", null);
        return false;
    L72:
        return false;
    L57:
        if (r14 <= 1.0d) goto L66;
        if (r3 == false) goto L75;
        Logger r7 = this.logger;
        if (r7 != null) goto L62;
        return false;
    L62:
        if (r7.getLevel() > 3) goto L74;
        r7.log(TAG, 3, r18.getData() + ": Cached image's request size (" + r5 + ", " + r1 + ") is smaller than the requested size (" + r21.getWidth() + ", " + r21.getHeight() + ", " + r22 + ").", null);
        return false;
    L74:
        return false;
    L75:
        return true;
    L66:
        return true;
    L45:
        r6 = false;
        goto L47
    L32:
        if (Utils.isMinOrMax(r11) == true) goto L38;
        if (Math.abs(r11 - r5) > 1) goto L43;
    L38:
        if (Utils.isMinOrMax(r12) == true) goto L69;
        if (Math.abs(r12 - r1) > 1) goto L43;
    L69:
        return true;
    L19:
        r11 = Integer.MAX_VALUE;
        goto L20
    L15:
        return Intrinsics.areEqual(r4, r21.toString());
    }

    public final boolean setCacheValue(MemoryCache.Key r4, ImageRequest r5, EngineInterceptor.ExecuteResult r6) {
        if (r5.getMemoryCachePolicy().getWriteEnabled() == true) goto L5;
        return false;
    L5:
        MemoryCache r3 = this.imageLoader.getMemoryCache();
        if (r3 == null) goto L22;
        if (r4 == null) goto L22;
        Drawable r7 = r6.getDrawable();
        if ((r7 instanceof BitmapDrawable) == false) goto L12;
        BitmapDrawable r8 = (BitmapDrawable) r7;
    L13:
        if (r8 == null) goto L22;
        Bitmap r9 = r8.getBitmap();
        if (r9 == null) goto L22;
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put(EXTRA_IS_SAMPLED, Boolean.valueOf(r6.isSampled()));
        String r10 = r6.getDiskCacheKey();
        if (r10 == null) goto L20;
        r0.put(EXTRA_DISK_CACHE_KEY, r10);
    L20:
        r3.set(r4, new MemoryCache.Value(r9, r0));
        return true;
    L12:
        r8 = null;
    L22:
        return false;
    }

    public final SuccessResult newResult(Interceptor.Chain r10, ImageRequest r11, MemoryCache.Key r12, MemoryCache.Value r13) {
        Bitmap r0 = r13.getBitmap();
        return new SuccessResult(new BitmapDrawable(r11.getContext().getResources(), r0), r11, DataSource.MEMORY_CACHE, r12, getDiskCacheKey(r13), isSampled(r13), Utils.isPlaceholderCached(r10));
    }

    private final boolean isSampled(MemoryCache.Value r1) {
        Object r0 = r1.getExtras().get(EXTRA_IS_SAMPLED);
        if ((r0 instanceof Boolean) == false) goto L5;
        Boolean r2 = (Boolean) r0;
    L6:
        if (r2 != null) goto L10;
        return false;
    L10:
        return r2.booleanValue();
    L5:
        r2 = null;
        goto L6
    }

    private final String getDiskCacheKey(MemoryCache.Value r1) {
        Object r0 = r1.getExtras().get(EXTRA_DISK_CACHE_KEY);
        if ((r0 instanceof String) == true) goto L7;
        return null;
    L7:
        return (String) r0;
    }
}
