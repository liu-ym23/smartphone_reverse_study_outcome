package coil.request;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.drawable.Drawable;
import android.icu.text.PluralRules;
import android.view.View;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import coil.decode.Decoder;
import coil.fetch.Fetcher;
import coil.memory.MemoryCache;
import coil.size.Dimension;
import coil.size.DisplaySizeResolver;
import coil.size.Precision;
import coil.size.Scale;
import coil.size.Size;
import coil.size.SizeResolver;
import coil.size.SizeResolvers;
import coil.size.Sizes;
import coil.size.ViewSizeResolver;
import coil.size.ViewSizeResolvers;
import coil.target.ImageViewTarget;
import coil.target.Target;
import coil.target.ViewTarget;
import coil.transform.Transformation;
import coil.transition.CrossfadeTransition;
import coil.transition.Transition;
import coil.util.Collections;
import coil.util.Contexts;
import coil.util.Requests;
import coil.util.Utils;
import com.android.settings.search.IndexDatabaseHelper;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.tracing.internal.TracingConstants;
import com.obric.capabilitykit.common.Ext;
import com.obric.oui.material.MaterialConfigFormatNames;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import obric.widget.calendar.MonthWeekEventsView;
import okhttp3.Headers;

/* JADX INFO: compiled from: ImageRequest.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bF\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0004\u008c\u0001\u008d\u0001Bõ\u0002\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u001c\u0010\u0013\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0015\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0016\u0018\u00010\u0014\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\u0006\u0010 \u001a\u00020!\u0012\u0006\u0010\"\u001a\u00020#\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010%\u001a\u00020#\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u0010'\u001a\u00020(\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u0010*\u001a\u00020(\u0012\u0006\u0010+\u001a\u00020,\u0012\u0006\u0010-\u001a\u00020,\u0012\u0006\u0010.\u001a\u00020,\u0012\u0006\u0010/\u001a\u00020,\u0012\u0006\u00100\u001a\u000201\u0012\u0006\u00102\u001a\u000203\u0012\u0006\u00104\u001a\u000205\u0012\u0006\u00106\u001a\u000207\u0012\b\u00108\u001a\u0004\u0018\u00010\n\u0012\b\u00109\u001a\u0004\u0018\u00010:\u0012\b\u0010;\u001a\u0004\u0018\u00010<\u0012\b\u0010=\u001a\u0004\u0018\u00010:\u0012\b\u0010>\u001a\u0004\u0018\u00010<\u0012\b\u0010?\u001a\u0004\u0018\u00010:\u0012\b\u0010@\u001a\u0004\u0018\u00010<\u0012\u0006\u0010A\u001a\u00020B\u0012\u0006\u0010C\u001a\u00020D¢\u0006\u0002\u0010EJ\u0015\u0010\u0087\u0001\u001a\u00020#2\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\t\u0010\u0089\u0001\u001a\u00020:H\u0016J\u0014\u0010\u008a\u0001\u001a\u00030\u008b\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007R\u0011\u0010\"\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0011\u0010$\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\bH\u0010GR\u0011\u0010%\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\bI\u0010GR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bN\u0010OR\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u0011\u0010.\u001a\u00020,¢\u0006\b\n\u0000\u001a\u0004\bR\u0010SR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\bT\u0010UR\u0011\u0010C\u001a\u00020D¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u0011\u0010A\u001a\u00020B¢\u0006\b\n\u0000\u001a\u0004\bX\u0010YR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010[R\u0011\u0010)\u001a\u00020(¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010]R\u0013\u0010^\u001a\u0004\u0018\u00010<8F¢\u0006\u0006\u001a\u0004\b_\u0010`R\u0010\u0010>\u001a\u0004\u0018\u00010<X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010=\u001a\u0004\u0018\u00010:X\u0082\u0004¢\u0006\u0004\n\u0002\u0010aR\u0013\u0010b\u001a\u0004\u0018\u00010<8F¢\u0006\u0006\u001a\u0004\bc\u0010`R\u0010\u0010@\u001a\u0004\u0018\u00010<X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010?\u001a\u0004\u0018\u00010:X\u0082\u0004¢\u0006\u0004\n\u0002\u0010aR\u0011\u0010-\u001a\u00020,¢\u0006\b\n\u0000\u001a\u0004\bd\u0010SR'\u0010\u0013\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0015\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0016\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\be\u0010fR\u0011\u0010\u001e\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\bg\u0010hR\u0011\u0010+\u001a\u00020,¢\u0006\b\n\u0000\u001a\u0004\bi\u0010SR\u0011\u00100\u001a\u000201¢\u0006\b\n\u0000\u001a\u0004\bj\u0010kR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\bl\u0010mR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\bn\u0010oR\u0011\u0010'\u001a\u00020(¢\u0006\b\n\u0000\u001a\u0004\bp\u0010]R\u0011\u0010*\u001a\u00020(¢\u0006\b\n\u0000\u001a\u0004\bq\u0010]R\u0011\u00106\u001a\u000207¢\u0006\b\n\u0000\u001a\u0004\br\u0010sR\u0013\u0010t\u001a\u0004\u0018\u00010<8F¢\u0006\u0006\u001a\u0004\bu\u0010`R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u00108\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\bv\u0010oR\u0012\u00109\u001a\u0004\u0018\u00010:X\u0082\u0004¢\u0006\u0004\n\u0002\u0010aR\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\bw\u0010xR\u0011\u0010&\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\by\u0010GR\u0011\u00104\u001a\u000205¢\u0006\b\n\u0000\u001a\u0004\bz\u0010{R\u0011\u00102\u001a\u000203¢\u0006\b\n\u0000\u001a\u0004\b|\u0010}R\u0011\u0010 \u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b~\u0010\u007fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0000\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0012\u0010/\u001a\u00020,¢\u0006\t\n\u0000\u001a\u0005\b\u0082\u0001\u0010SR\u0019\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\n\n\u0000\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0013\u0010\u001c\u001a\u00020\u001d¢\u0006\n\n\u0000\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001¨\u0006\u008e\u0001"}, d2 = {"Lcoil/request/ImageRequest;", "", "context", "Landroid/content/Context;", "data", "target", "Lcoil/target/Target;", "listener", "Lcoil/request/ImageRequest$Listener;", "memoryCacheKey", "Lcoil/memory/MemoryCache$Key;", "diskCacheKey", "", "bitmapConfig", "Landroid/graphics/Bitmap$Config;", "colorSpace", "Landroid/graphics/ColorSpace;", "precision", "Lcoil/size/Precision;", "fetcherFactory", "Lkotlin/Pair;", "Lcoil/fetch/Fetcher$Factory;", "Ljava/lang/Class;", "decoderFactory", "Lcoil/decode/Decoder$Factory;", "transformations", "", "Lcoil/transform/Transformation;", "transitionFactory", "Lcoil/transition/Transition$Factory;", "headers", "Lokhttp3/Headers;", TracingConstants.KEY_TAGS, "Lcoil/request/Tags;", "allowConversionToBitmap", "", "allowHardware", "allowRgb565", "premultipliedAlpha", "memoryCachePolicy", "Lcoil/request/CachePolicy;", "diskCachePolicy", "networkCachePolicy", "interceptorDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "fetcherDispatcher", "decoderDispatcher", "transformationDispatcher", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "sizeResolver", "Lcoil/size/SizeResolver;", "scale", "Lcoil/size/Scale;", "parameters", "Lcoil/request/Parameters;", "placeholderMemoryCacheKey", "placeholderResId", "", "placeholderDrawable", "Landroid/graphics/drawable/Drawable;", "errorResId", "errorDrawable", "fallbackResId", "fallbackDrawable", "defined", "Lcoil/request/DefinedRequestOptions;", "defaults", "Lcoil/request/DefaultRequestOptions;", "(Landroid/content/Context;Ljava/lang/Object;Lcoil/target/Target;Lcoil/request/ImageRequest$Listener;Lcoil/memory/MemoryCache$Key;Ljava/lang/String;Landroid/graphics/Bitmap$Config;Landroid/graphics/ColorSpace;Lcoil/size/Precision;Lkotlin/Pair;Lcoil/decode/Decoder$Factory;Ljava/util/List;Lcoil/transition/Transition$Factory;Lokhttp3/Headers;Lcoil/request/Tags;ZZZZLcoil/request/CachePolicy;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Landroidx/lifecycle/Lifecycle;Lcoil/size/SizeResolver;Lcoil/size/Scale;Lcoil/request/Parameters;Lcoil/memory/MemoryCache$Key;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;Lcoil/request/DefinedRequestOptions;Lcoil/request/DefaultRequestOptions;)V", "getAllowConversionToBitmap", "()Z", "getAllowHardware", "getAllowRgb565", "getBitmapConfig", "()Landroid/graphics/Bitmap$Config;", "getColorSpace", "()Landroid/graphics/ColorSpace;", "getContext", "()Landroid/content/Context;", "getData", "()Ljava/lang/Object;", "getDecoderDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "getDecoderFactory", "()Lcoil/decode/Decoder$Factory;", "getDefaults", "()Lcoil/request/DefaultRequestOptions;", "getDefined", "()Lcoil/request/DefinedRequestOptions;", "getDiskCacheKey", "()Ljava/lang/String;", "getDiskCachePolicy", "()Lcoil/request/CachePolicy;", "error", "getError", "()Landroid/graphics/drawable/Drawable;", "Ljava/lang/Integer;", "fallback", "getFallback", "getFetcherDispatcher", "getFetcherFactory", "()Lkotlin/Pair;", "getHeaders", "()Lokhttp3/Headers;", "getInterceptorDispatcher", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "getListener", "()Lcoil/request/ImageRequest$Listener;", "getMemoryCacheKey", "()Lcoil/memory/MemoryCache$Key;", "getMemoryCachePolicy", "getNetworkCachePolicy", "getParameters", "()Lcoil/request/Parameters;", "placeholder", "getPlaceholder", "getPlaceholderMemoryCacheKey", "getPrecision", "()Lcoil/size/Precision;", "getPremultipliedAlpha", "getScale", "()Lcoil/size/Scale;", "getSizeResolver", "()Lcoil/size/SizeResolver;", "getTags", "()Lcoil/request/Tags;", "getTarget", "()Lcoil/target/Target;", "getTransformationDispatcher", "getTransformations", "()Ljava/util/List;", "getTransitionFactory", "()Lcoil/transition/Transition$Factory;", "equals", PluralRules.KEYWORD_OTHER, "hashCode", "newBuilder", "Lcoil/request/ImageRequest$Builder;", "Builder", "Listener", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ImageRequest {
    private final boolean allowConversionToBitmap;
    private final boolean allowHardware;
    private final boolean allowRgb565;
    private final Bitmap.Config bitmapConfig;
    private final ColorSpace colorSpace;
    private final Context context;
    private final Object data;
    private final CoroutineDispatcher decoderDispatcher;
    private final Decoder.Factory decoderFactory;
    private final DefaultRequestOptions defaults;
    private final DefinedRequestOptions defined;
    private final String diskCacheKey;
    private final CachePolicy diskCachePolicy;
    private final Drawable errorDrawable;
    private final Integer errorResId;
    private final Drawable fallbackDrawable;
    private final Integer fallbackResId;
    private final CoroutineDispatcher fetcherDispatcher;
    private final Pair<Fetcher.Factory<?>, Class<?>> fetcherFactory;
    private final Headers headers;
    private final CoroutineDispatcher interceptorDispatcher;
    private final Lifecycle lifecycle;
    private final Listener listener;
    private final MemoryCache.Key memoryCacheKey;
    private final CachePolicy memoryCachePolicy;
    private final CachePolicy networkCachePolicy;
    private final Parameters parameters;
    private final Drawable placeholderDrawable;
    private final MemoryCache.Key placeholderMemoryCacheKey;
    private final Integer placeholderResId;
    private final Precision precision;
    private final boolean premultipliedAlpha;
    private final Scale scale;
    private final SizeResolver sizeResolver;
    private final Tags tags;
    private final Target target;
    private final CoroutineDispatcher transformationDispatcher;
    private final List<Transformation> transformations;
    private final Transition.Factory transitionFactory;

    /* JADX INFO: compiled from: ImageRequest.kt */
    @Metadata(d1 = {"\u0000®\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0016\u0010L\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\u00192\u0006\u0010N\u001a\u00020\u0019J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010O\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010O\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010O\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010P\u001a\u00020\u000eJ\u0006\u0010Q\u001a\u00020\u0006J\u0010\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u000e\u0010R\u001a\u00020\u00002\u0006\u0010O\u001a\u00020\tJ\u000e\u0010R\u001a\u00020\u00002\u0006\u0010S\u001a\u00020\u001fJ\u0010\u0010\u0011\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001J\u0010\u0010T\u001a\u00020\u00002\u0006\u0010T\u001a\u00020UH\u0007J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010W\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u00002\b\u0010X\u001a\u0004\u0018\u00010\u0019J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010Y\u001a\u00020\u001bJ\u000e\u0010V\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\u0013J\u0010\u0010Z\u001a\u00020\u00002\b\u0010[\u001a\u0004\u0018\u00010\u001dJ\u0010\u0010Z\u001a\u00020\u00002\b\b\u0001\u0010\\\u001a\u00020\u001fJ\u0010\u0010]\u001a\u00020\u00002\b\u0010[\u001a\u0004\u0018\u00010\u001dJ\u0010\u0010]\u001a\u00020\u00002\b\b\u0001\u0010\\\u001a\u00020\u001fJ\u0010\u0010^\u001a\u00020\u00002\u0006\u0010^\u001a\u00020_H\u0007J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\u0013J#\u0010$\u001a\u00020\u0000\"\n\b\u0000\u0010`\u0018\u0001*\u00020\u00012\f\u0010W\u001a\b\u0012\u0004\u0012\u0002H`0&H\u0086\bJ,\u0010$\u001a\u00020\u0000\"\b\b\u0000\u0010`*\u00020\u00012\f\u0010W\u001a\b\u0012\u0004\u0012\u0002H`0&2\f\u0010a\u001a\b\u0012\u0004\u0012\u0002H`0'J\u000e\u0010(\u001a\u00020\u00002\u0006\u0010(\u001a\u00020bJ\u000e\u0010*\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\u0013J\u0010\u0010+\u001a\u00020\u00002\b\u0010+\u001a\u0004\u0018\u00010,J\u0010\u0010+\u001a\u00020\u00002\b\u0010c\u001a\u0004\u0018\u00010dJÇ\u0001\u0010-\u001a\u00020\u00002#\b\u0006\u0010e\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\bg\u0012\b\bM\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020h0f2#\b\u0006\u0010i\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\bg\u0012\b\bM\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020h0f28\b\u0006\u0010j\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\bg\u0012\b\bM\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110l¢\u0006\f\bg\u0012\b\bM\u0012\u0004\b\b(m\u0012\u0004\u0012\u00020h0k28\b\u0006\u0010n\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\bg\u0012\b\bM\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110o¢\u0006\f\bg\u0012\b\bM\u0012\u0004\b\b(m\u0012\u0004\u0012\u00020h0kH\u0086\bJ\u0010\u0010-\u001a\u00020\u00002\b\u0010-\u001a\u0004\u0018\u00010.J\u0010\u0010/\u001a\u00020\u00002\b\u0010X\u001a\u0004\u0018\u000100J\u0010\u0010/\u001a\u00020\u00002\b\u0010X\u001a\u0004\u0018\u00010\u0019J\u000e\u00101\u001a\u00020\u00002\u0006\u0010Y\u001a\u00020\u001bJ\u000e\u00102\u001a\u00020\u00002\u0006\u0010Y\u001a\u00020\u001bJ\u000e\u00103\u001a\u00020\u00002\u0006\u00103\u001a\u00020pJ\u0010\u0010q\u001a\u00020\u00002\b\u0010[\u001a\u0004\u0018\u00010\u001dJ\u0010\u0010q\u001a\u00020\u00002\b\b\u0001\u0010\\\u001a\u00020\u001fJ\u0010\u00106\u001a\u00020\u00002\b\u0010X\u001a\u0004\u0018\u000100J\u0010\u00106\u001a\u00020\u00002\b\u0010X\u001a\u0004\u0018\u00010\u0019J\u000e\u00108\u001a\u00020\u00002\u0006\u00108\u001a\u000209J\u000e\u0010:\u001a\u00020\u00002\u0006\u0010O\u001a\u00020\tJ\u000e\u0010r\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\u0019J\u000e\u0010s\u001a\u00020\u00002\u0006\u0010X\u001a\u00020\u0019J\b\u0010t\u001a\u00020hH\u0002J\b\u0010u\u001a\u00020hH\u0002J\b\u0010v\u001a\u00020,H\u0002J\b\u0010w\u001a\u00020=H\u0002J\b\u0010x\u001a\u00020?H\u0002J\u000e\u0010@\u001a\u00020\u00002\u0006\u0010@\u001a\u00020=J\u0016\u0010y\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\u00192\u0006\u0010N\u001a\u00020\u0019J&\u0010z\u001a\u00020\u00002\u0006\u0010X\u001a\u00020\u00192\b\u0010N\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0019H\u0007J\u0016\u0010{\u001a\u00020\u00002\u0006\u0010|\u001a\u00020}2\u0006\u0010~\u001a\u00020}J\u000e\u0010{\u001a\u00020\u00002\u0006\u0010{\u001a\u00020\u007fJ\u000f\u0010{\u001a\u00020\u00002\u0007\u0010\u0080\u0001\u001a\u00020?J\u0010\u0010{\u001a\u00020\u00002\b\b\u0001\u0010{\u001a\u00020\u001fJ\u001a\u0010{\u001a\u00020\u00002\b\b\u0001\u0010|\u001a\u00020\u001f2\b\b\u0001\u0010~\u001a\u00020\u001fJ'\u0010\u0081\u0001\u001a\u00020\u0000\"\n\b\u0000\u0010`\u0018\u0001*\u00020\u00012\t\u0010\u0081\u0001\u001a\u0004\u0018\u0001H`H\u0086\b¢\u0006\u0003\u0010\u0082\u0001J2\u0010\u0081\u0001\u001a\u00020\u0000\"\b\b\u0000\u0010`*\u00020\u00012\u000e\u0010a\u001a\n\u0012\u0006\b\u0000\u0012\u0002H`0'2\t\u0010\u0081\u0001\u001a\u0004\u0018\u0001H`¢\u0006\u0003\u0010\u0083\u0001J\u000f\u0010B\u001a\u00020\u00002\u0007\u0010B\u001a\u00030\u0084\u0001J|\u0010D\u001a\u00020\u00002%\b\u0006\u0010e\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u001d¢\u0006\f\bg\u0012\b\bM\u0012\u0004\b\b(q\u0012\u0004\u0012\u00020h0f2%\b\u0006\u0010j\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u001d¢\u0006\f\bg\u0012\b\bM\u0012\u0004\b\b(Z\u0012\u0004\u0012\u00020h0f2#\b\u0006\u0010n\u001a\u001d\u0012\u0013\u0012\u00110\u001d¢\u0006\f\bg\u0012\b\bM\u0012\u0004\b\b(m\u0012\u0004\u0012\u00020h0fH\u0086\bJ\u0010\u0010D\u001a\u00020\u00002\b\u0010\u0085\u0001\u001a\u00030\u0086\u0001J\u0010\u0010D\u001a\u00020\u00002\b\u0010D\u001a\u0004\u0018\u00010EJ\u000e\u0010F\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\u0013J!\u0010G\u001a\u00020\u00002\u0013\u0010G\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020I0\u0087\u0001\"\u00020I¢\u0006\u0003\u0010\u0088\u0001J\u0014\u0010G\u001a\u00020\u00002\f\u0010G\u001a\b\u0012\u0004\u0012\u00020I0HJ\u0013\u0010\u0089\u0001\u001a\u00020\u00002\b\u0010\u0089\u0001\u001a\u00030\u008a\u0001H\u0007J\u000f\u0010J\u001a\u00020\u00002\u0007\u0010\u0089\u0001\u001a\u00020KR\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\f\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0083\u000e¢\u0006\u0004\n\u0002\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0083\u000e¢\u0006\u0004\n\u0002\u0010 R\u0010\u0010#\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010$\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030&\u0012\b\u0012\u0006\u0012\u0002\b\u00030'\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00107\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0083\u000e¢\u0006\u0004\n\u0002\u0010 R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010=X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010?X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010B\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030'\u0012\u0004\u0012\u00020\u0001\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010G\u001a\b\u0012\u0004\u0012\u00020I0HX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010J\u001a\u0004\u0018\u00010KX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u008b\u0001"}, d2 = {"Lcoil/request/ImageRequest$Builder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", Ext.KEY_REQUEST, "Lcoil/request/ImageRequest;", "(Lcoil/request/ImageRequest;Landroid/content/Context;)V", "allowConversionToBitmap", "", "allowHardware", "Ljava/lang/Boolean;", "allowRgb565", "bitmapConfig", "Landroid/graphics/Bitmap$Config;", "colorSpace", "Landroid/graphics/ColorSpace;", "data", "decoderDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "decoderFactory", "Lcoil/decode/Decoder$Factory;", "defaults", "Lcoil/request/DefaultRequestOptions;", "diskCacheKey", "", "diskCachePolicy", "Lcoil/request/CachePolicy;", "errorDrawable", "Landroid/graphics/drawable/Drawable;", "errorResId", "", "Ljava/lang/Integer;", "fallbackDrawable", "fallbackResId", "fetcherDispatcher", "fetcherFactory", "Lkotlin/Pair;", "Lcoil/fetch/Fetcher$Factory;", "Ljava/lang/Class;", "headers", "Lokhttp3/Headers$Builder;", "interceptorDispatcher", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "listener", "Lcoil/request/ImageRequest$Listener;", "memoryCacheKey", "Lcoil/memory/MemoryCache$Key;", "memoryCachePolicy", "networkCachePolicy", "parameters", "Lcoil/request/Parameters$Builder;", "placeholderDrawable", "placeholderMemoryCacheKey", "placeholderResId", "precision", "Lcoil/size/Precision;", "premultipliedAlpha", "resolvedLifecycle", "resolvedScale", "Lcoil/size/Scale;", "resolvedSizeResolver", "Lcoil/size/SizeResolver;", "scale", "sizeResolver", TracingConstants.KEY_TAGS, "", "target", "Lcoil/target/Target;", "transformationDispatcher", "transformations", "", "Lcoil/transform/Transformation;", "transitionFactory", "Lcoil/transition/Transition$Factory;", "addHeader", "name", "value", "enable", "config", IndexDatabaseHelper.MetaColumns.BUILD, "crossfade", "durationMillis", "decoder", "Lcoil/decode/Decoder;", "dispatcher", "factory", "key", "policy", "error", "drawable", "drawableResId", "fallback", "fetcher", "Lcoil/fetch/Fetcher;", ExifInterface.GPS_DIRECTION_TRUE, "type", "Lokhttp3/Headers;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onStart", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "", "onCancel", "onError", "Lkotlin/Function2;", "Lcoil/request/ErrorResult;", "result", "onSuccess", "Lcoil/request/SuccessResult;", "Lcoil/request/Parameters;", "placeholder", "removeHeader", "removeParameter", "resetResolvedScale", "resetResolvedValues", "resolveLifecycle", "resolveScale", "resolveSizeResolver", "setHeader", "setParameter", PerfConsts.PERF_DISK_FILE_SIZE, MaterialConfigFormatNames.WIDTH, "Lcoil/size/Dimension;", MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "Lcoil/size/Size;", "resolver", "tag", "(Ljava/lang/Object;)Lcoil/request/ImageRequest$Builder;", "(Ljava/lang/Class;Ljava/lang/Object;)Lcoil/request/ImageRequest$Builder;", "Lcoil/request/Tags;", "imageView", "Landroid/widget/ImageView;", "", "([Lcoil/transform/Transformation;)Lcoil/request/ImageRequest$Builder;", "transition", "Lcoil/transition/Transition;", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Builder {
        private boolean allowConversionToBitmap;
        private Boolean allowHardware;
        private Boolean allowRgb565;
        private Bitmap.Config bitmapConfig;
        private ColorSpace colorSpace;
        private final Context context;
        private Object data;
        private CoroutineDispatcher decoderDispatcher;
        private Decoder.Factory decoderFactory;
        private DefaultRequestOptions defaults;
        private String diskCacheKey;
        private CachePolicy diskCachePolicy;
        private Drawable errorDrawable;
        private Integer errorResId;
        private Drawable fallbackDrawable;
        private Integer fallbackResId;
        private CoroutineDispatcher fetcherDispatcher;
        private Pair<? extends Fetcher.Factory<?>, ? extends Class<?>> fetcherFactory;
        private Headers.Builder headers;
        private CoroutineDispatcher interceptorDispatcher;
        private Lifecycle lifecycle;
        private Listener listener;
        private MemoryCache.Key memoryCacheKey;
        private CachePolicy memoryCachePolicy;
        private CachePolicy networkCachePolicy;
        private Parameters.Builder parameters;
        private Drawable placeholderDrawable;
        private MemoryCache.Key placeholderMemoryCacheKey;
        private Integer placeholderResId;
        private Precision precision;
        private boolean premultipliedAlpha;
        private Lifecycle resolvedLifecycle;
        private Scale resolvedScale;
        private SizeResolver resolvedSizeResolver;
        private Scale scale;
        private SizeResolver sizeResolver;
        private Map<Class<?>, Object> tags;
        private Target target;
        private CoroutineDispatcher transformationDispatcher;
        private List<? extends Transformation> transformations;
        private Transition.Factory transitionFactory;

        /* JADX WARN: Multi-variable type inference failed */
        public Builder(ImageRequest r3) {
            this(r3, null, 2, 0 == true ? 1 : 0);
        }

        public final Builder setParameter(String r7, Object r8) {
            return setParameter$default(this, r7, r8, null, 4, null);
        }

        public Builder(Context r2) {
            this.context = r2;
            this.defaults = Requests.getDEFAULT_REQUEST_OPTIONS();
            this.data = null;
            this.target = null;
            this.listener = null;
            this.memoryCacheKey = null;
            this.diskCacheKey = null;
            this.bitmapConfig = null;
            this.colorSpace = null;
            this.precision = null;
            this.fetcherFactory = null;
            this.decoderFactory = null;
            this.transformations = CollectionsKt.emptyList();
            this.transitionFactory = null;
            this.headers = null;
            this.tags = null;
            this.allowConversionToBitmap = true;
            this.allowHardware = null;
            this.allowRgb565 = null;
            this.premultipliedAlpha = true;
            this.memoryCachePolicy = null;
            this.diskCachePolicy = null;
            this.networkCachePolicy = null;
            this.interceptorDispatcher = null;
            this.fetcherDispatcher = null;
            this.decoderDispatcher = null;
            this.transformationDispatcher = null;
            this.parameters = null;
            this.placeholderMemoryCacheKey = null;
            this.placeholderResId = null;
            this.placeholderDrawable = null;
            this.errorResId = null;
            this.errorDrawable = null;
            this.fallbackResId = null;
            this.fallbackDrawable = null;
            this.lifecycle = null;
            this.sizeResolver = null;
            this.scale = null;
            this.resolvedLifecycle = null;
            this.resolvedSizeResolver = null;
            this.resolvedScale = null;
        }

        public Builder(ImageRequest r2, Context r3) {
            this.context = r3;
            this.defaults = r2.getDefaults();
            this.data = r2.getData();
            this.target = r2.getTarget();
            this.listener = r2.getListener();
            this.memoryCacheKey = r2.getMemoryCacheKey();
            this.diskCacheKey = r2.getDiskCacheKey();
            this.bitmapConfig = r2.getDefined().getBitmapConfig();
            this.colorSpace = r2.getColorSpace();
            this.precision = r2.getDefined().getPrecision();
            this.fetcherFactory = r2.getFetcherFactory();
            this.decoderFactory = r2.getDecoderFactory();
            this.transformations = r2.getTransformations();
            this.transitionFactory = r2.getDefined().getTransitionFactory();
            this.headers = r2.getHeaders().newBuilder();
            this.tags = MapsKt.toMutableMap(r2.getTags().asMap());
            this.allowConversionToBitmap = r2.getAllowConversionToBitmap();
            this.allowHardware = r2.getDefined().getAllowHardware();
            this.allowRgb565 = r2.getDefined().getAllowRgb565();
            this.premultipliedAlpha = r2.getPremultipliedAlpha();
            this.memoryCachePolicy = r2.getDefined().getMemoryCachePolicy();
            this.diskCachePolicy = r2.getDefined().getDiskCachePolicy();
            this.networkCachePolicy = r2.getDefined().getNetworkCachePolicy();
            this.interceptorDispatcher = r2.getDefined().getInterceptorDispatcher();
            this.fetcherDispatcher = r2.getDefined().getFetcherDispatcher();
            this.decoderDispatcher = r2.getDefined().getDecoderDispatcher();
            this.transformationDispatcher = r2.getDefined().getTransformationDispatcher();
            this.parameters = r2.getParameters().newBuilder();
            this.placeholderMemoryCacheKey = r2.getPlaceholderMemoryCacheKey();
            this.placeholderResId = ImageRequest.access$getPlaceholderResId$p(r2);
            this.placeholderDrawable = ImageRequest.access$getPlaceholderDrawable$p(r2);
            this.errorResId = ImageRequest.access$getErrorResId$p(r2);
            this.errorDrawable = ImageRequest.access$getErrorDrawable$p(r2);
            this.fallbackResId = ImageRequest.access$getFallbackResId$p(r2);
            this.fallbackDrawable = ImageRequest.access$getFallbackDrawable$p(r2);
            this.lifecycle = r2.getDefined().getLifecycle();
            this.sizeResolver = r2.getDefined().getSizeResolver();
            this.scale = r2.getDefined().getScale();
            if (r2.getContext() != r3) goto L5;
            this.resolvedLifecycle = r2.getLifecycle();
            this.resolvedSizeResolver = r2.getSizeResolver();
            this.resolvedScale = r2.getScale();
            return;
        L5:
            this.resolvedLifecycle = null;
            this.resolvedSizeResolver = null;
            this.resolvedScale = null;
        }

        public /* synthetic */ Builder(ImageRequest r1, Context r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = r1.getContext();
        L5:
            this(r1, r2);
        }

        public final Builder data(Object r2) {
            this.data = r2;
            return this;
        }

        public final Builder memoryCacheKey(String r4) {
            MemoryCache.Key r0 = null;
            if (r4 == null) goto L6;
            r0 = new MemoryCache.Key(r4, null, 2, null);
        L6:
            return memoryCacheKey(r0);
        }

        public final Builder memoryCacheKey(MemoryCache.Key r2) {
            this.memoryCacheKey = r2;
            return this;
        }

        public final Builder diskCacheKey(String r2) {
            this.diskCacheKey = r2;
            return this;
        }

        public static /* synthetic */ Builder listener$default(Builder r0, ImageRequest$Builder$listener$1 r1, ImageRequest$Builder$listener$2 r2, ImageRequest$Builder$listener$3 r3, ImageRequest$Builder$listener$4 r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = ImageRequest$Builder$listener$1.INSTANCE;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = ImageRequest$Builder$listener$2.INSTANCE;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = ImageRequest$Builder$listener$3.INSTANCE;
        L12:
            if ((r5 & 8) == 0) goto L15;
            r4 = ImageRequest$Builder$listener$4.INSTANCE;
        L15:
            return r0.listener(new ImageRequest$Builder$listener$5(r1, r2, r3, r4));
        }

        public final Builder listener(Function1<? super ImageRequest, Unit> r2, Function1<? super ImageRequest, Unit> r3, Function2<? super ImageRequest, ? super ErrorResult, Unit> r4, Function2<? super ImageRequest, ? super SuccessResult, Unit> r5) {
            return listener(new ImageRequest$Builder$listener$5(r2, r3, r4, r5));
        }

        public final Builder listener(Listener r2) {
            this.listener = r2;
            return this;
        }

        public final Builder dispatcher(CoroutineDispatcher r2) {
            this.fetcherDispatcher = r2;
            this.decoderDispatcher = r2;
            this.transformationDispatcher = r2;
            return this;
        }

        public final Builder interceptorDispatcher(CoroutineDispatcher r2) {
            this.interceptorDispatcher = r2;
            return this;
        }

        public final Builder fetcherDispatcher(CoroutineDispatcher r2) {
            this.fetcherDispatcher = r2;
            return this;
        }

        public final Builder decoderDispatcher(CoroutineDispatcher r2) {
            this.decoderDispatcher = r2;
            return this;
        }

        public final Builder transformationDispatcher(CoroutineDispatcher r2) {
            this.transformationDispatcher = r2;
            return this;
        }

        public final Builder transformations(Transformation... r1) {
            return transformations(ArraysKt.toList(r1));
        }

        public final Builder transformations(List<? extends Transformation> r2) {
            this.transformations = Collections.toImmutableList(r2);
            return this;
        }

        public final Builder bitmapConfig(Bitmap.Config r2) {
            this.bitmapConfig = r2;
            return this;
        }

        public final Builder colorSpace(ColorSpace r2) {
            this.colorSpace = r2;
            return this;
        }

        public final Builder size(int r1) {
            return size(r1, r1);
        }

        public final Builder size(int r1, int r2) {
            return size(Sizes.Size(r1, r2));
        }

        public final Builder size(Dimension r2, Dimension r3) {
            return size(new Size(r2, r3));
        }

        public final Builder size(Size r1) {
            return size(SizeResolvers.create(r1));
        }

        public final Builder size(SizeResolver r2) {
            this.sizeResolver = r2;
            resetResolvedValues();
            return this;
        }

        public final Builder scale(Scale r2) {
            this.scale = r2;
            return this;
        }

        public final Builder precision(Precision r2) {
            this.precision = r2;
            return this;
        }

        public final /* synthetic */ <T> Builder fetcherFactory(Fetcher.Factory<T> r3) {
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            return fetcherFactory(r3, Object.class);
        }

        public final <T> Builder fetcherFactory(Fetcher.Factory<T> r2, Class<T> r3) {
            this.fetcherFactory = TuplesKt.to(r2, r3);
            return this;
        }

        public final Builder decoderFactory(Decoder.Factory r2) {
            this.decoderFactory = r2;
            return this;
        }

        public final Builder allowConversionToBitmap(boolean r2) {
            this.allowConversionToBitmap = r2;
            return this;
        }

        public final Builder allowHardware(boolean r2) {
            this.allowHardware = Boolean.valueOf(r2);
            return this;
        }

        public final Builder allowRgb565(boolean r2) {
            this.allowRgb565 = Boolean.valueOf(r2);
            return this;
        }

        public final Builder premultipliedAlpha(boolean r2) {
            this.premultipliedAlpha = r2;
            return this;
        }

        public final Builder memoryCachePolicy(CachePolicy r2) {
            this.memoryCachePolicy = r2;
            return this;
        }

        public final Builder diskCachePolicy(CachePolicy r2) {
            this.diskCachePolicy = r2;
            return this;
        }

        public final Builder networkCachePolicy(CachePolicy r2) {
            this.networkCachePolicy = r2;
            return this;
        }

        public final Builder headers(Headers r2) {
            this.headers = r2.newBuilder();
            return this;
        }

        public final Builder addHeader(String r2, String r3) {
            Headers.Builder r0 = this.headers;
            if (r0 != null) goto L5;
            r0 = new Headers.Builder();
            this.headers = r0;
        L5:
            r0.add(r2, r3);
            return this;
        }

        public final Builder setHeader(String r2, String r3) {
            Headers.Builder r0 = this.headers;
            if (r0 != null) goto L5;
            r0 = new Headers.Builder();
            this.headers = r0;
        L5:
            r0.set(r2, r3);
            return this;
        }

        public final Builder removeHeader(String r2) {
            Headers.Builder r0 = this.headers;
            if (r0 == null) goto L5;
            r0.removeAll(r2);
        L5:
            return this;
        }

        public final /* synthetic */ <T> Builder tag(T r3) {
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            return tag(Object.class, r3);
        }

        public final <T> Builder tag(Class<? super T> r2, T r3) {
            if (r3 != null) goto L7;
            Map<Class<?>, Object> r4 = this.tags;
            if (r4 == null) goto L11;
            r4.remove(r2);
        L11:
            return this;
        L7:
            LinkedHashMap r0 = this.tags;
            if (r0 != null) goto L10;
            r0 = new LinkedHashMap();
            this.tags = r0;
        L10:
            T r5 = r2.cast(r3);
            Intrinsics.checkNotNull(r5);
            r0.put(r2, r5);
            goto L11
        }

        public final Builder tags(Tags r2) {
            this.tags = MapsKt.toMutableMap(r2.asMap());
            return this;
        }

        public final Builder placeholderMemoryCacheKey(String r4) {
            MemoryCache.Key r0 = null;
            if (r4 == null) goto L6;
            r0 = new MemoryCache.Key(r4, null, 2, null);
        L6:
            return placeholderMemoryCacheKey(r0);
        }

        public final Builder placeholderMemoryCacheKey(MemoryCache.Key r2) {
            this.placeholderMemoryCacheKey = r2;
            return this;
        }

        public final Builder placeholder(int r2) {
            this.placeholderResId = Integer.valueOf(r2);
            this.placeholderDrawable = null;
            return this;
        }

        public final Builder placeholder(Drawable r2) {
            this.placeholderDrawable = r2;
            this.placeholderResId = 0;
            return this;
        }

        public final Builder error(int r2) {
            this.errorResId = Integer.valueOf(r2);
            this.errorDrawable = null;
            return this;
        }

        public final Builder error(Drawable r2) {
            this.errorDrawable = r2;
            this.errorResId = 0;
            return this;
        }

        public final Builder fallback(int r2) {
            this.fallbackResId = Integer.valueOf(r2);
            this.fallbackDrawable = null;
            return this;
        }

        public final Builder fallback(Drawable r2) {
            this.fallbackDrawable = r2;
            this.fallbackResId = 0;
            return this;
        }

        public final Builder target(ImageView r2) {
            return target(new ImageViewTarget(r2));
        }

        public static /* synthetic */ Builder target$default(Builder r0, ImageRequest$Builder$target$1 r1, ImageRequest$Builder$target$2 r2, ImageRequest$Builder$target$3 r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = ImageRequest$Builder$target$1.INSTANCE;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = ImageRequest$Builder$target$2.INSTANCE;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = ImageRequest$Builder$target$3.INSTANCE;
        L12:
            return r0.target(new ImageRequest$Builder$target$4(r1, r2, r3));
        }

        public final Builder target(Function1<? super Drawable, Unit> r2, Function1<? super Drawable, Unit> r3, Function1<? super Drawable, Unit> r4) {
            return target(new ImageRequest$Builder$target$4(r2, r3, r4));
        }

        public final Builder target(Target r2) {
            this.target = r2;
            resetResolvedValues();
            return this;
        }

        public final Builder crossfade(boolean r1) {
            if (r1 == false) goto L4;
            int r2 = 100;
        L6:
            return crossfade(r2);
        L4:
            r2 = 0;
            goto L6
        }

        public final Builder crossfade(int r5) {
            if (r5 <= 0) goto L5;
            boolean r3 = false;
            CrossfadeTransition.Factory r0 = new CrossfadeTransition.Factory(r5, r3, 2, null);
        L6:
            transitionFactory(r0);
            return this;
        L5:
            r0 = Transition.Factory.NONE;
            goto L6
        }

        public final Builder transitionFactory(Transition.Factory r2) {
            this.transitionFactory = r2;
            return this;
        }

        public final Builder lifecycle(LifecycleOwner r1) {
            if (r1 == null) goto L4;
            Lifecycle r2 = r1.getLifecycle();
        L6:
            return lifecycle(r2);
        L4:
            r2 = null;
            goto L6
        }

        public final Builder lifecycle(Lifecycle r2) {
            this.lifecycle = r2;
            return this;
        }

        public static /* synthetic */ Builder setParameter$default(Builder r0, String r1, Object r2, String r3, int r4, Object r5) {
            if ((r4 & 4) == 0) goto L8;
            if (r2 == null) goto L6;
            r3 = r2.toString();
            goto L8
        L6:
            r3 = null;
        L8:
            return r0.setParameter(r1, r2, r3);
        }

        public final Builder setParameter(String r2, Object r3, String r4) {
            Parameters.Builder r0 = this.parameters;
            if (r0 != null) goto L5;
            r0 = new Parameters.Builder();
            this.parameters = r0;
        L5:
            r0.set(r2, r3, r4);
            return this;
        }

        public final Builder removeParameter(String r2) {
            Parameters.Builder r0 = this.parameters;
            if (r0 == null) goto L5;
            r0.remove(r2);
        L5:
            return this;
        }

        public final Builder parameters(Parameters r2) {
            this.parameters = r2.newBuilder();
            return this;
        }

        public final Builder defaults(DefaultRequestOptions r2) {
            this.defaults = r2;
            resetResolvedScale();
            return this;
        }

        public final ImageRequest build() {
            Context r2 = this.context;
            Object r1 = this.data;
            if (r1 != null) goto L5;
            r1 = NullRequestData.INSTANCE;
        L5:
            Object r3 = r1;
            Target r4 = this.target;
            Listener r5 = this.listener;
            MemoryCache.Key r6 = this.memoryCacheKey;
            String r7 = this.diskCacheKey;
            Bitmap.Config r8 = this.bitmapConfig;
            if (r8 != null) goto L8;
            r8 = this.defaults.getBitmapConfig();
        L8:
            Bitmap.Config r9 = r8;
            ColorSpace r10 = this.colorSpace;
            Precision r11 = this.precision;
            if (r11 != null) goto L11;
            r11 = this.defaults.getPrecision();
        L11:
            Precision r12 = r11;
            Pair<? extends Fetcher.Factory<?>, ? extends Class<?>> r13 = this.fetcherFactory;
            Decoder.Factory r14 = this.decoderFactory;
            List<? extends Transformation> r15 = this.transformations;
            Transition.Factory r16 = this.transitionFactory;
            if (r16 != null) goto L14;
            r16 = this.defaults.getTransitionFactory();
        L14:
            Transition.Factory r17 = r16;
            Headers.Builder r18 = this.headers;
            if (r18 == null) goto L17;
            Headers r19 = r18.build();
        L18:
            Headers r110 = Utils.orEmpty(r19);
            Map<Class<?>, ? extends Object> r20 = this.tags;
            if (r20 == null) goto L21;
            Tags r21 = Tags.Companion.from(r20);
        L22:
            Tags r111 = Utils.orEmpty(r21);
            boolean r112 = this.allowConversionToBitmap;
            Boolean r22 = this.allowHardware;
            if (r22 == null) goto L25;
            boolean r23 = r22.booleanValue();
        L26:
            boolean r113 = r23;
            Boolean r24 = this.allowRgb565;
            if (r24 == null) goto L29;
            boolean r25 = r24.booleanValue();
        L30:
            boolean r26 = r25;
            boolean r27 = this.premultipliedAlpha;
            CachePolicy r28 = this.memoryCachePolicy;
            if (r28 != null) goto L33;
            r28 = this.defaults.getMemoryCachePolicy();
        L33:
            CachePolicy r29 = r28;
            CachePolicy r30 = this.diskCachePolicy;
            if (r30 != null) goto L36;
            r30 = this.defaults.getDiskCachePolicy();
        L36:
            CachePolicy r210 = r30;
            CachePolicy r31 = this.networkCachePolicy;
            if (r31 != null) goto L39;
            r31 = this.defaults.getNetworkCachePolicy();
        L39:
            CachePolicy r211 = r31;
            CoroutineDispatcher r32 = this.interceptorDispatcher;
            if (r32 != null) goto L42;
            r32 = this.defaults.getInterceptorDispatcher();
        L42:
            CoroutineDispatcher r212 = r32;
            CoroutineDispatcher r33 = this.fetcherDispatcher;
            if (r33 != null) goto L45;
            r33 = this.defaults.getFetcherDispatcher();
        L45:
            CoroutineDispatcher r213 = r33;
            CoroutineDispatcher r34 = this.decoderDispatcher;
            if (r34 != null) goto L48;
            r34 = this.defaults.getDecoderDispatcher();
        L48:
            CoroutineDispatcher r214 = r34;
            CoroutineDispatcher r35 = this.transformationDispatcher;
            if (r35 != null) goto L51;
            r35 = this.defaults.getTransformationDispatcher();
        L51:
            CoroutineDispatcher r215 = r35;
            Lifecycle r36 = this.lifecycle;
            if (r36 != null) goto L56;
            r36 = this.resolvedLifecycle;
            if (r36 != null) goto L56;
            r36 = resolveLifecycle();
        L56:
            Lifecycle r216 = r36;
            SizeResolver r37 = this.sizeResolver;
            if (r37 != null) goto L61;
            r37 = this.resolvedSizeResolver;
            if (r37 != null) goto L61;
            r37 = resolveSizeResolver();
        L61:
            SizeResolver r38 = r37;
            Scale r39 = this.scale;
            if (r39 != null) goto L66;
            r39 = this.resolvedScale;
            if (r39 != null) goto L66;
            r39 = resolveScale();
        L66:
            Scale r42 = r39;
            Parameters.Builder r40 = this.parameters;
            if (r40 == null) goto L69;
            Parameters r114 = r40.build();
        L71:
            return new ImageRequest(r2, r3, r4, r5, r6, r7, r9, r10, r12, r13, r14, r15, r17, r110, r111, r112, r113, r26, r27, r29, r210, r211, r212, r213, r214, r215, r216, r38, r42, Utils.orEmpty(r114), this.placeholderMemoryCacheKey, this.placeholderResId, this.placeholderDrawable, this.errorResId, this.errorDrawable, this.fallbackResId, this.fallbackDrawable, new DefinedRequestOptions(this.lifecycle, this.sizeResolver, this.scale, this.interceptorDispatcher, this.fetcherDispatcher, this.decoderDispatcher, this.transformationDispatcher, this.transitionFactory, this.precision, this.bitmapConfig, this.allowHardware, this.allowRgb565, this.memoryCachePolicy, this.diskCachePolicy, this.networkCachePolicy), this.defaults, null);
        L69:
            r114 = null;
            goto L71
        L29:
            r25 = this.defaults.getAllowRgb565();
            goto L30
        L25:
            r23 = this.defaults.getAllowHardware();
            goto L26
        L21:
            r21 = null;
            goto L22
        L17:
            r19 = null;
            goto L18
        }

        private final void resetResolvedValues() {
            this.resolvedLifecycle = null;
            this.resolvedSizeResolver = null;
            this.resolvedScale = null;
        }

        private final void resetResolvedScale() {
            this.resolvedScale = null;
        }

        private final Lifecycle resolveLifecycle() {
            Target r0 = this.target;
            if ((r0 instanceof ViewTarget) == false) goto L5;
            Context r2 = ((ViewTarget) r0).getView().getContext();
        L6:
            Lifecycle r3 = Contexts.getLifecycle(r2);
            if (r3 == null) goto L9;
            return r3;
        L9:
            return GlobalLifecycle.INSTANCE;
        L5:
            r2 = this.context;
            goto L6
        }

        private final SizeResolver resolveSizeResolver() {
            Target r0 = this.target;
            if ((r0 instanceof ViewTarget) == false) goto L19;
            View r3 = ((ViewTarget) r0).getView();
            if ((r3 instanceof ImageView) == false) goto L17;
            ImageView.ScaleType r1 = ((ImageView) r3).getScaleType();
            if (r1 != ImageView.ScaleType.CENTER) goto L9;
        L12:
            boolean r2 = true;
        L13:
            if (r2 == false) goto L17;
            return SizeResolvers.create(Size.ORIGINAL);
        L9:
            if (r1 == ImageView.ScaleType.MATRIX) goto L12;
            r2 = false;
        L17:
            return ViewSizeResolvers.create$default(r3, false, 2, null);
        L19:
            return new DisplaySizeResolver(this.context);
        }

        private final Scale resolveScale() {
            SizeResolver r0 = this.sizeResolver;
            View r2 = null;
            if ((r0 instanceof ViewSizeResolver) == false) goto L5;
            ViewSizeResolver r1 = (ViewSizeResolver) r0;
        L6:
            if (r1 == null) goto L11;
            View r3 = r1.getView();
            if (r3 == null) goto L11;
            r2 = r3;
        L18:
            if ((r2 instanceof ImageView) == false) goto L22;
            return Utils.getScale((ImageView) r2);
        L22:
            return Scale.FIT;
        L11:
            Target r4 = this.target;
            if ((r4 instanceof ViewTarget) == false) goto L14;
            ViewTarget r5 = (ViewTarget) r4;
        L15:
            if (r5 == null) goto L18;
            r2 = r5.getView();
            goto L18
        L14:
            r5 = null;
            goto L15
        L5:
            r1 = null;
            goto L6
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Migrate to 'fetcherFactory'.", replaceWith = @ReplaceWith(expression = "fetcherFactory<Any> { _, _, _ -> fetcher }", imports = {}))
        public final Builder fetcher(Fetcher r1) {
            Utils.unsupported();
            throw new KotlinNothingValueException();
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Migrate to 'decoderFactory'.", replaceWith = @ReplaceWith(expression = "decoderFactory { _, _, _ -> decoder }", imports = {}))
        public final Builder decoder(Decoder r1) {
            Utils.unsupported();
            throw new KotlinNothingValueException();
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Migrate to 'transitionFactory'.", replaceWith = @ReplaceWith(expression = "transitionFactory { _, _ -> transition }", imports = {}))
        public final Builder transition(Transition r1) {
            Utils.unsupported();
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: compiled from: ImageRequest.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0017J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u000bH\u0017ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcoil/request/ImageRequest$Listener;", "", "onCancel", "", Ext.KEY_REQUEST, "Lcoil/request/ImageRequest;", "onError", "result", "Lcoil/request/ErrorResult;", "onStart", "onSuccess", "Lcoil/request/SuccessResult;", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Listener {

        /* JADX INFO: compiled from: ImageRequest.kt */
        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class DefaultImpls {
            @Deprecated
            public static void onStart(Listener r0, ImageRequest r1) {
                Listener.access$onStart$jd(r0, r1);
            }

            @Deprecated
            public static void onCancel(Listener r0, ImageRequest r1) {
                Listener.access$onCancel$jd(r0, r1);
            }

            @Deprecated
            public static void onError(Listener r0, ImageRequest r1, ErrorResult r2) {
                Listener.access$onError$jd(r0, r1, r2);
            }

            @Deprecated
            public static void onSuccess(Listener r0, ImageRequest r1, SuccessResult r2) {
                Listener.access$onSuccess$jd(r0, r1, r2);
            }
        }

        default void onCancel(ImageRequest r1) {
        }

        default void onError(ImageRequest r1, ErrorResult r2) {
        }

        default void onStart(ImageRequest r1) {
        }

        default void onSuccess(ImageRequest r1, SuccessResult r2) {
        }

        static /* synthetic */ void access$onCancel$jd(Listener r0, ImageRequest r1) {
            super.onCancel(r1);
        }

        static /* synthetic */ void access$onError$jd(Listener r0, ImageRequest r1, ErrorResult r2) {
            super.onError(r1, r2);
        }

        static /* synthetic */ void access$onStart$jd(Listener r0, ImageRequest r1) {
            super.onStart(r1);
        }

        static /* synthetic */ void access$onSuccess$jd(Listener r0, ImageRequest r1, SuccessResult r2) {
            super.onSuccess(r1, r2);
        }
    }

    public /* synthetic */ ImageRequest(Context r1, Object r2, Target r3, Listener r4, MemoryCache.Key r5, String r6, Bitmap.Config r7, ColorSpace r8, Precision r9, Pair r10, Decoder.Factory r11, List r12, Transition.Factory r13, Headers r14, Tags r15, boolean r16, boolean r17, boolean r18, boolean r19, CachePolicy r20, CachePolicy r21, CachePolicy r22, CoroutineDispatcher r23, CoroutineDispatcher r24, CoroutineDispatcher r25, CoroutineDispatcher r26, Lifecycle r27, SizeResolver r28, Scale r29, Parameters r30, MemoryCache.Key r31, Integer r32, Drawable r33, Integer r34, Drawable r35, Integer r36, Drawable r37, DefinedRequestOptions r38, DefaultRequestOptions r39, DefaultConstructorMarker r40) {
        this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39);
    }

    public final Builder newBuilder() {
        return newBuilder$default(this, null, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ImageRequest(Context r3, Object r4, Target r5, Listener r6, MemoryCache.Key r7, String r8, Bitmap.Config r9, ColorSpace r10, Precision r11, Pair<? extends Fetcher.Factory<?>, ? extends Class<?>> r12, Decoder.Factory r13, List<? extends Transformation> r14, Transition.Factory r15, Headers r16, Tags r17, boolean r18, boolean r19, boolean r20, boolean r21, CachePolicy r22, CachePolicy r23, CachePolicy r24, CoroutineDispatcher r25, CoroutineDispatcher r26, CoroutineDispatcher r27, CoroutineDispatcher r28, Lifecycle r29, SizeResolver r30, Scale r31, Parameters r32, MemoryCache.Key r33, Integer r34, Drawable r35, Integer r36, Drawable r37, Integer r38, Drawable r39, DefinedRequestOptions r40, DefaultRequestOptions r41) {
        this.context = r3;
        this.data = r4;
        this.target = r5;
        this.listener = r6;
        this.memoryCacheKey = r7;
        this.diskCacheKey = r8;
        this.bitmapConfig = r9;
        this.colorSpace = r10;
        this.precision = r11;
        this.fetcherFactory = r12;
        this.decoderFactory = r13;
        this.transformations = r14;
        this.transitionFactory = r15;
        this.headers = r16;
        this.tags = r17;
        this.allowConversionToBitmap = r18;
        this.allowHardware = r19;
        this.allowRgb565 = r20;
        this.premultipliedAlpha = r21;
        this.memoryCachePolicy = r22;
        this.diskCachePolicy = r23;
        this.networkCachePolicy = r24;
        this.interceptorDispatcher = r25;
        this.fetcherDispatcher = r26;
        this.decoderDispatcher = r27;
        this.transformationDispatcher = r28;
        this.lifecycle = r29;
        this.sizeResolver = r30;
        this.scale = r31;
        this.parameters = r32;
        this.placeholderMemoryCacheKey = r33;
        this.placeholderResId = r34;
        this.placeholderDrawable = r35;
        this.errorResId = r36;
        this.errorDrawable = r37;
        this.fallbackResId = r38;
        this.fallbackDrawable = r39;
        this.defined = r40;
        this.defaults = r41;
    }

    public static final /* synthetic */ Drawable access$getErrorDrawable$p(ImageRequest r0) {
        return r0.errorDrawable;
    }

    public static final /* synthetic */ Integer access$getErrorResId$p(ImageRequest r0) {
        return r0.errorResId;
    }

    public static final /* synthetic */ Drawable access$getFallbackDrawable$p(ImageRequest r0) {
        return r0.fallbackDrawable;
    }

    public static final /* synthetic */ Integer access$getFallbackResId$p(ImageRequest r0) {
        return r0.fallbackResId;
    }

    public static final /* synthetic */ Drawable access$getPlaceholderDrawable$p(ImageRequest r0) {
        return r0.placeholderDrawable;
    }

    public static final /* synthetic */ Integer access$getPlaceholderResId$p(ImageRequest r0) {
        return r0.placeholderResId;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Object getData() {
        return this.data;
    }

    public final Target getTarget() {
        return this.target;
    }

    public final Listener getListener() {
        return this.listener;
    }

    public final MemoryCache.Key getMemoryCacheKey() {
        return this.memoryCacheKey;
    }

    public final String getDiskCacheKey() {
        return this.diskCacheKey;
    }

    public final Bitmap.Config getBitmapConfig() {
        return this.bitmapConfig;
    }

    public final ColorSpace getColorSpace() {
        return this.colorSpace;
    }

    public final Precision getPrecision() {
        return this.precision;
    }

    public final Pair<Fetcher.Factory<?>, Class<?>> getFetcherFactory() {
        return this.fetcherFactory;
    }

    public final Decoder.Factory getDecoderFactory() {
        return this.decoderFactory;
    }

    public final List<Transformation> getTransformations() {
        return this.transformations;
    }

    public final Transition.Factory getTransitionFactory() {
        return this.transitionFactory;
    }

    public final Headers getHeaders() {
        return this.headers;
    }

    public final Tags getTags() {
        return this.tags;
    }

    public final boolean getAllowConversionToBitmap() {
        return this.allowConversionToBitmap;
    }

    public final boolean getAllowHardware() {
        return this.allowHardware;
    }

    public final boolean getAllowRgb565() {
        return this.allowRgb565;
    }

    public final boolean getPremultipliedAlpha() {
        return this.premultipliedAlpha;
    }

    public final CachePolicy getMemoryCachePolicy() {
        return this.memoryCachePolicy;
    }

    public final CachePolicy getDiskCachePolicy() {
        return this.diskCachePolicy;
    }

    public final CachePolicy getNetworkCachePolicy() {
        return this.networkCachePolicy;
    }

    public final CoroutineDispatcher getInterceptorDispatcher() {
        return this.interceptorDispatcher;
    }

    public final CoroutineDispatcher getFetcherDispatcher() {
        return this.fetcherDispatcher;
    }

    public final CoroutineDispatcher getDecoderDispatcher() {
        return this.decoderDispatcher;
    }

    public final CoroutineDispatcher getTransformationDispatcher() {
        return this.transformationDispatcher;
    }

    public final Lifecycle getLifecycle() {
        return this.lifecycle;
    }

    public final SizeResolver getSizeResolver() {
        return this.sizeResolver;
    }

    public final Scale getScale() {
        return this.scale;
    }

    public final Parameters getParameters() {
        return this.parameters;
    }

    public final MemoryCache.Key getPlaceholderMemoryCacheKey() {
        return this.placeholderMemoryCacheKey;
    }

    public final DefinedRequestOptions getDefined() {
        return this.defined;
    }

    public final DefaultRequestOptions getDefaults() {
        return this.defaults;
    }

    public final Drawable getPlaceholder() {
        return Requests.getDrawableCompat(this, this.placeholderDrawable, this.placeholderResId, this.defaults.getPlaceholder());
    }

    public final Drawable getError() {
        return Requests.getDrawableCompat(this, this.errorDrawable, this.errorResId, this.defaults.getError());
    }

    public final Drawable getFallback() {
        return Requests.getDrawableCompat(this, this.fallbackDrawable, this.fallbackResId, this.defaults.getFallback());
    }

    public static /* synthetic */ Builder newBuilder$default(ImageRequest r0, Context r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.context;
    L6:
        return r0.newBuilder(r1);
    }

    public final Builder newBuilder(Context r2) {
        return new Builder(this, r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof ImageRequest) == false) goto L86;
        ImageRequest r5 = (ImageRequest) r4;
        if (Intrinsics.areEqual(this.context, r5.context) == false) goto L86;
        if (Intrinsics.areEqual(this.data, r5.data) == false) goto L86;
        if (Intrinsics.areEqual(this.target, r5.target) == false) goto L86;
        if (Intrinsics.areEqual(this.listener, r5.listener) == false) goto L86;
        if (Intrinsics.areEqual(this.memoryCacheKey, r5.memoryCacheKey) == false) goto L86;
        if (Intrinsics.areEqual(this.diskCacheKey, r5.diskCacheKey) == false) goto L86;
        if (this.bitmapConfig != r5.bitmapConfig) goto L86;
        if (Intrinsics.areEqual(this.colorSpace, r5.colorSpace) == false) goto L86;
        if (this.precision != r5.precision) goto L86;
        if (Intrinsics.areEqual(this.fetcherFactory, r5.fetcherFactory) == false) goto L86;
        if (Intrinsics.areEqual(this.decoderFactory, r5.decoderFactory) == false) goto L86;
        if (Intrinsics.areEqual(this.transformations, r5.transformations) == false) goto L86;
        if (Intrinsics.areEqual(this.transitionFactory, r5.transitionFactory) == false) goto L86;
        if (Intrinsics.areEqual(this.headers, r5.headers) == false) goto L86;
        if (Intrinsics.areEqual(this.tags, r5.tags) == false) goto L86;
        if (this.allowConversionToBitmap != r5.allowConversionToBitmap) goto L86;
        if (this.allowHardware != r5.allowHardware) goto L86;
        if (this.allowRgb565 != r5.allowRgb565) goto L86;
        if (this.premultipliedAlpha != r5.premultipliedAlpha) goto L86;
        if (this.memoryCachePolicy != r5.memoryCachePolicy) goto L86;
        if (this.diskCachePolicy != r5.diskCachePolicy) goto L86;
        if (this.networkCachePolicy != r5.networkCachePolicy) goto L86;
        if (Intrinsics.areEqual(this.interceptorDispatcher, r5.interceptorDispatcher) == false) goto L86;
        if (Intrinsics.areEqual(this.fetcherDispatcher, r5.fetcherDispatcher) == false) goto L86;
        if (Intrinsics.areEqual(this.decoderDispatcher, r5.decoderDispatcher) == false) goto L86;
        if (Intrinsics.areEqual(this.transformationDispatcher, r5.transformationDispatcher) == false) goto L86;
        if (Intrinsics.areEqual(this.placeholderMemoryCacheKey, r5.placeholderMemoryCacheKey) == false) goto L86;
        if (Intrinsics.areEqual(this.placeholderResId, r5.placeholderResId) == false) goto L86;
        if (Intrinsics.areEqual(this.placeholderDrawable, r5.placeholderDrawable) == false) goto L86;
        if (Intrinsics.areEqual(this.errorResId, r5.errorResId) == false) goto L86;
        if (Intrinsics.areEqual(this.errorDrawable, r5.errorDrawable) == false) goto L86;
        if (Intrinsics.areEqual(this.fallbackResId, r5.fallbackResId) == false) goto L86;
        if (Intrinsics.areEqual(this.fallbackDrawable, r5.fallbackDrawable) == false) goto L86;
        if (Intrinsics.areEqual(this.lifecycle, r5.lifecycle) == false) goto L86;
        if (Intrinsics.areEqual(this.sizeResolver, r5.sizeResolver) == false) goto L86;
        if (this.scale != r5.scale) goto L86;
        if (Intrinsics.areEqual(this.parameters, r5.parameters) == false) goto L86;
        if (Intrinsics.areEqual(this.defined, r5.defined) == false) goto L86;
        if (Intrinsics.areEqual(this.defaults, r5.defaults) == false) goto L86;
        return true;
    L86:
        return false;
    }

    public int hashCode() {
        int r0 = ((this.context.hashCode() * 31) + this.data.hashCode()) * 31;
        Target r1 = this.target;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        Listener r5 = this.listener;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        MemoryCache.Key r8 = this.memoryCacheKey;
        if (r8 == null) goto L13;
        int r9 = r8.hashCode();
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.diskCacheKey;
        if (r11 == null) goto L17;
        int r12 = r11.hashCode();
    L18:
        int r13 = (((r10 + r12) * 31) + this.bitmapConfig.hashCode()) * 31;
        ColorSpace r14 = this.colorSpace;
        if (r14 == null) goto L21;
        int r15 = r14.hashCode();
    L22:
        int r16 = (((r13 + r15) * 31) + this.precision.hashCode()) * 31;
        Pair<Fetcher.Factory<?>, Class<?>> r17 = this.fetcherFactory;
        if (r17 == null) goto L25;
        int r18 = r17.hashCode();
    L26:
        int r19 = (r16 + r18) * 31;
        Decoder.Factory r20 = this.decoderFactory;
        if (r20 == null) goto L29;
        int r21 = r20.hashCode();
    L30:
        int r22 = (((((((((((((((((((((((((((((((((((((((r19 + r21) * 31) + this.transformations.hashCode()) * 31) + this.transitionFactory.hashCode()) * 31) + this.headers.hashCode()) * 31) + this.tags.hashCode()) * 31) + Boolean.hashCode(this.allowConversionToBitmap)) * 31) + Boolean.hashCode(this.allowHardware)) * 31) + Boolean.hashCode(this.allowRgb565)) * 31) + Boolean.hashCode(this.premultipliedAlpha)) * 31) + this.memoryCachePolicy.hashCode()) * 31) + this.diskCachePolicy.hashCode()) * 31) + this.networkCachePolicy.hashCode()) * 31) + this.interceptorDispatcher.hashCode()) * 31) + this.fetcherDispatcher.hashCode()) * 31) + this.decoderDispatcher.hashCode()) * 31) + this.transformationDispatcher.hashCode()) * 31) + this.lifecycle.hashCode()) * 31) + this.sizeResolver.hashCode()) * 31) + this.scale.hashCode()) * 31) + this.parameters.hashCode()) * 31;
        MemoryCache.Key r23 = this.placeholderMemoryCacheKey;
        if (r23 == null) goto L33;
        int r24 = r23.hashCode();
    L34:
        int r25 = (r22 + r24) * 31;
        Integer r26 = this.placeholderResId;
        if (r26 == null) goto L37;
        int r27 = r26.hashCode();
    L38:
        int r28 = (r25 + r27) * 31;
        Drawable r29 = this.placeholderDrawable;
        if (r29 == null) goto L41;
        int r30 = r29.hashCode();
    L42:
        int r31 = (r28 + r30) * 31;
        Integer r32 = this.errorResId;
        if (r32 == null) goto L45;
        int r33 = r32.hashCode();
    L46:
        int r34 = (r31 + r33) * 31;
        Drawable r35 = this.errorDrawable;
        if (r35 == null) goto L49;
        int r36 = r35.hashCode();
    L50:
        int r37 = (r34 + r36) * 31;
        Integer r38 = this.fallbackResId;
        if (r38 == null) goto L53;
        int r39 = r38.hashCode();
    L54:
        int r40 = (r37 + r39) * 31;
        Drawable r41 = this.fallbackDrawable;
        if (r41 == null) goto L58;
        r2 = r41.hashCode();
    L58:
        return ((((r40 + r2) * 31) + this.defined.hashCode()) * 31) + this.defaults.hashCode();
    L53:
        r39 = 0;
        goto L54
    L49:
        r36 = 0;
        goto L50
    L45:
        r33 = 0;
        goto L46
    L41:
        r30 = 0;
        goto L42
    L37:
        r27 = 0;
        goto L38
    L33:
        r24 = 0;
        goto L34
    L29:
        r21 = 0;
        goto L30
    L25:
        r18 = 0;
        goto L26
    L21:
        r15 = 0;
        goto L22
    L17:
        r12 = 0;
        goto L18
    L13:
        r9 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }
}
