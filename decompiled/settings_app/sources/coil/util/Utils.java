package coil.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.net.Uri;
import android.os.Looper;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import coil.ComponentRegistry;
import coil.EventListener;
import coil.base.R;
import coil.decode.DataSource;
import coil.decode.Decoder;
import coil.disk.DiskCache;
import coil.fetch.Fetcher;
import coil.intercept.Interceptor;
import coil.intercept.RealInterceptorChain;
import coil.memory.MemoryCache;
import coil.request.Parameters;
import coil.request.Tags;
import coil.request.ViewTargetRequestManager;
import coil.size.Dimension;
import coil.size.Scale;
import coil.size.Size;
import coil.size.Sizes;
import com.android.settings.fuelgauge.PowerUsageDetail;
import com.android.settingslib.SliceBroadcastRelay;
import com.android.settingslib.accessibility.AccessibilityUtils;
import com.obric.oui.material.MaterialConfigFormatNames;
import java.io.Closeable;
import java.io.File;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.Deferred;
import obric.widget.calendar.MonthWeekEventsView;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.commons.io.IOUtils;

/* JADX INFO: renamed from: coil.util.-Utils, reason: invalid class name */
/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u009c\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010K\u001a\u00020\u00072\u0006\u0010L\u001a\u00020A2\u0006\u0010M\u001a\u00020\rH\u0000\u001a\u0010\u0010N\u001a\u00020\r2\u0006\u0010L\u001a\u00020AH\u0000\u001a\u0010\u0010O\u001a\u0002022\u0006\u0010P\u001a\u00020&H\u0000\u001a\b\u0010Q\u001a\u000202H\u0000\u001a\b\u0010R\u001a\u00020SH\u0000\u001a\f\u0010T\u001a\u00020U*\u00020VH\u0000\u001a\u0017\u0010W\u001a\u00020X*\u00020X2\b\u0010Y\u001a\u0004\u0018\u00010ZH\u0080\b\u001a+\u0010W\u001a\u00020X*\u00020X2\u001c\u0010[\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030]\u0012\b\u0012\u0006\u0012\u0002\b\u00030^\u0018\u00010\\H\u0080\b\u001a\u0014\u0010_\u001a\u00020`*\u00020`2\u0006\u0010a\u001a\u00020\u0001H\u0000\u001a\f\u0010b\u001a\u00020U*\u00020cH\u0000\u001a\u0019\u0010d\u001a\u0004\u0018\u00010e*\u00020f2\b\u0010g\u001a\u0004\u0018\u00010hH\u0080\n\u001a\u001f\u0010i\u001a\u0004\u0018\u0001Hj\"\u0004\b\u0000\u0010j*\b\u0012\u0004\u0012\u0002Hj0kH\u0000¢\u0006\u0002\u0010l\u001a\u0018\u0010m\u001a\u0004\u0018\u00010\u0001*\u00020n2\b\u0010o\u001a\u0004\u0018\u00010\u0001H\u0000\u001a#\u0010p\u001a\u00020\u0007*\u00020q2\u0006\u0010D\u001a\u00020E2\f\u0010r\u001a\b\u0012\u0004\u0012\u00020\u00070sH\u0080\b\u001a\f\u0010t\u001a\u000202*\u00020\u0007H\u0000\u001a\u000e\u0010u\u001a\u00020v*\u0004\u0018\u00010vH\u0000\u001a\u000e\u0010u\u001a\u00020w*\u0004\u0018\u00010wH\u0000\u001a\u000e\u0010u\u001a\u00020\t*\u0004\u0018\u00010\tH\u0000\u001a\f\u0010x\u001a\u00020y*\u00020zH\u0000\u001a\u0014\u0010{\u001a\u00020\u0007*\u00020\u00012\u0006\u0010|\u001a\u00020\u0007H\u0000\u001a\u0014\u0010}\u001a\u00020\u0007*\u00020~2\u0006\u0010D\u001a\u00020EH\u0000\u001a#\u0010\u007f\u001a\u00020\u0007*\u00020q2\u0006\u0010D\u001a\u00020E2\f\u0010r\u001a\b\u0012\u0004\u0012\u00020\u00070sH\u0080\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010\b\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u000e\u0010\u0016\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000\"\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018X\u0080\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001a\"\u0018\u0010\u001c\u001a\u00020\u0001*\u00020\u001d8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f\"\u0018\u0010 \u001a\u00020!*\u00020\"8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$\"\u001a\u0010%\u001a\u0004\u0018\u00010\u0001*\u00020&8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(\"\u0018\u0010)\u001a\u00020\u0007*\u00020*8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,\"\u0019\u0010-\u001a\u00020\u0007*\u00020.8À\u0002X\u0080\u0004¢\u0006\u0006\u001a\u0004\b/\u00100\"\u0018\u00101\u001a\u000202*\u00020\"8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b1\u00103\"\u0018\u00104\u001a\u000202*\u00020*8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b4\u00105\"\u0018\u00106\u001a\u00020\u0007*\u0002078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b8\u00109\"\u0018\u0010:\u001a\u00020;*\u00020<8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>\"\u0018\u0010?\u001a\u00020@*\u00020A8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bB\u0010C\"\u0018\u0010D\u001a\u00020E*\u00020F8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bG\u0010H\"\u0018\u0010I\u001a\u00020\u0007*\u00020*8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010,¨\u0006\u0080\u0001"}, d2 = {"ASSET_FILE_PATH_ROOT", "", "DEFAULT_BITMAP_CONFIG", "Landroid/graphics/Bitmap$Config;", "getDEFAULT_BITMAP_CONFIG", "()Landroid/graphics/Bitmap$Config;", "DEFAULT_MEMORY_CLASS_MEGABYTES", "", "EMPTY_HEADERS", "Lokhttp3/Headers;", "getEMPTY_HEADERS", "()Lokhttp3/Headers;", "LOW_MEMORY_MULTIPLIER", "", "MIME_TYPE_HEIC", "MIME_TYPE_HEIF", "MIME_TYPE_JPEG", "MIME_TYPE_WEBP", "NULL_COLOR_SPACE", "Landroid/graphics/ColorSpace;", "getNULL_COLOR_SPACE", "()Landroid/graphics/ColorSpace;", "STANDARD_MEMORY_MULTIPLIER", "VALID_TRANSFORMATION_CONFIGS", "", "getVALID_TRANSFORMATION_CONFIGS", "()[Landroid/graphics/Bitmap$Config;", "[Landroid/graphics/Bitmap$Config;", "emoji", "Lcoil/decode/DataSource;", "getEmoji", "(Lcoil/decode/DataSource;)Ljava/lang/String;", "eventListener", "Lcoil/EventListener;", "Lcoil/intercept/Interceptor$Chain;", "getEventListener", "(Lcoil/intercept/Interceptor$Chain;)Lcoil/EventListener;", "firstPathSegment", "Landroid/net/Uri;", "getFirstPathSegment", "(Landroid/net/Uri;)Ljava/lang/String;", MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "Landroid/graphics/drawable/Drawable;", "getHeight", "(Landroid/graphics/drawable/Drawable;)I", "identityHashCode", "", "getIdentityHashCode", "(Ljava/lang/Object;)I", "isPlaceholderCached", "", "(Lcoil/intercept/Interceptor$Chain;)Z", "isVector", "(Landroid/graphics/drawable/Drawable;)Z", "nightMode", "Landroid/content/res/Configuration;", "getNightMode", "(Landroid/content/res/Configuration;)I", "requestManager", "Lcoil/request/ViewTargetRequestManager;", "Landroid/view/View;", "getRequestManager", "(Landroid/view/View;)Lcoil/request/ViewTargetRequestManager;", "safeCacheDir", "Ljava/io/File;", "Landroid/content/Context;", "getSafeCacheDir", "(Landroid/content/Context;)Ljava/io/File;", "scale", "Lcoil/size/Scale;", "Landroid/widget/ImageView;", "getScale", "(Landroid/widget/ImageView;)Lcoil/size/Scale;", MaterialConfigFormatNames.WIDTH, "getWidth", "calculateMemoryCacheSize", "context", PowerUsageDetail.EXTRA_PERCENT, "defaultMemoryCacheSizePercent", "isAssetUri", SliceBroadcastRelay.EXTRA_URI, "isMainThread", "unsupported", "", "abortQuietly", "", "Lcoil/disk/DiskCache$Editor;", "addFirst", "Lcoil/ComponentRegistry$Builder;", "factory", "Lcoil/decode/Decoder$Factory;", "pair", "Lkotlin/Pair;", "Lcoil/fetch/Fetcher$Factory;", "Ljava/lang/Class;", "addUnsafeNonAscii", "Lokhttp3/Headers$Builder;", "line", "closeQuietly", "Ljava/io/Closeable;", "get", "Lcoil/memory/MemoryCache$Value;", "Lcoil/memory/MemoryCache;", "key", "Lcoil/memory/MemoryCache$Key;", "getCompletedOrNull", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/Deferred;", "(Lkotlinx/coroutines/Deferred;)Ljava/lang/Object;", "getMimeTypeFromUrl", "Landroid/webkit/MimeTypeMap;", "url", "heightPx", "Lcoil/size/Size;", "original", "Lkotlin/Function0;", "isMinOrMax", "orEmpty", "Lcoil/request/Parameters;", "Lcoil/request/Tags;", "requireBody", "Lokhttp3/ResponseBody;", "Lokhttp3/Response;", "toNonNegativeInt", "defaultValue", "toPx", "Lcoil/size/Dimension;", "widthPx", "coil-base_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class Utils {
    public static final String ASSET_FILE_PATH_ROOT = "android_asset";
    private static final Bitmap.Config DEFAULT_BITMAP_CONFIG = null;
    private static final int DEFAULT_MEMORY_CLASS_MEGABYTES = 256;
    private static final Headers EMPTY_HEADERS = null;
    private static final double LOW_MEMORY_MULTIPLIER = 0.15d;
    public static final String MIME_TYPE_HEIC = "image/heic";
    public static final String MIME_TYPE_HEIF = "image/heif";
    public static final String MIME_TYPE_JPEG = "image/jpeg";
    public static final String MIME_TYPE_WEBP = "image/webp";
    private static final ColorSpace NULL_COLOR_SPACE = null;
    private static final double STANDARD_MEMORY_MULTIPLIER = 0.2d;
    private static final Bitmap.Config[] VALID_TRANSFORMATION_CONFIGS = null;

    /* JADX INFO: renamed from: coil.util.-Utils$WhenMappings */
    /* JADX INFO: compiled from: Utils.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2 = null;

        static {
            int[] r0 = new int[DataSource.values().length];
            r0[DataSource.MEMORY_CACHE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L36:
            r0[DataSource.MEMORY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L48:
            r0[DataSource.DISK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        L38:
            r0[DataSource.NETWORK.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
        L10:
            $EnumSwitchMapping$0 = r0;
            int[] r1 = new int[ImageView.ScaleType.values().length];
            r1[ImageView.ScaleType.FIT_START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
        L42:
            r1[ImageView.ScaleType.FIT_CENTER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L25
        L30:
            r1[ImageView.ScaleType.FIT_END.ordinal()] = 3;     // Catch: NoSuchFieldError -> L26
        L40:
            r1[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L27
        L15:
            $EnumSwitchMapping$1 = r1;
            int[] r2 = new int[Scale.values().length];
            r2[Scale.FILL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L28
        L34:
            r2[Scale.FIT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L29
        L18:
            $EnumSwitchMapping$2 = r2;
        }
    }

    public static final boolean isMinOrMax(int r1) {
        if (r1 != Integer.MIN_VALUE) goto L5;
    L8:
        return true;
    L5:
        if (r1 == Integer.MAX_VALUE) goto L8;
        return false;
    }

    public static final ViewTargetRequestManager getRequestManager(View r3) {
        Object r0 = r3.getTag(R.id.coil_request_manager);
        ViewTargetRequestManager r2 = null;
        if ((r0 instanceof ViewTargetRequestManager) == false) goto L5;
        ViewTargetRequestManager r1 = (ViewTargetRequestManager) r0;
    L6:
        if (r1 != null) goto L19;
        monitor-enter(r3);
        Object r4 = r3.getTag(R.id.coil_request_manager);     // Catch: Throwable -> L16
        if ((r4 instanceof ViewTargetRequestManager) == false) goto L11;
        r2 = (ViewTargetRequestManager) r4;     // Catch: Throwable -> L16
    L11:
        if (r2 == null) goto L13;
        r1 = r2;
    L14:
        monitor-exit(r3);
        goto L19
    L13:
        r1 = new ViewTargetRequestManager(r3);     // Catch: Throwable -> L16
        r3.addOnAttachStateChangeListener(r1);     // Catch: Throwable -> L16
        r3.setTag(R.id.coil_request_manager, r1);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    L19:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public static final String getEmoji(DataSource r1) {
        int r2 = WhenMappings.$EnumSwitchMapping$0[r1.ordinal()];
        if (r2 != 1) goto L5;
    L14:
        return Emoji.BRAIN;
    L5:
        if (r2 == 2) goto L14;
        if (r2 != 3) goto L9;
        return Emoji.FLOPPY;
    L9:
        if (r2 != 4) goto L12;
        return Emoji.CLOUD;
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public static final int getWidth(Drawable r1) {
        if ((r1 instanceof BitmapDrawable) == false) goto L5;
        BitmapDrawable r0 = (BitmapDrawable) r1;
    L6:
        if (r0 == null) goto L11;
        Bitmap r2 = r0.getBitmap();
        if (r2 == null) goto L11;
        return r2.getWidth();
    L11:
        return r1.getIntrinsicWidth();
    L5:
        r0 = null;
        goto L6
    }

    public static final int getHeight(Drawable r1) {
        if ((r1 instanceof BitmapDrawable) == false) goto L5;
        BitmapDrawable r0 = (BitmapDrawable) r1;
    L6:
        if (r0 == null) goto L11;
        Bitmap r2 = r0.getBitmap();
        if (r2 == null) goto L11;
        return r2.getHeight();
    L11:
        return r1.getIntrinsicHeight();
    L5:
        r0 = null;
        goto L6
    }

    public static final boolean isVector(Drawable r1) {
        if ((r1 instanceof VectorDrawable) == false) goto L5;
    L8:
        return true;
    L5:
        if ((r1 instanceof VectorDrawableCompat) == true) goto L8;
        return false;
    }

    public static final void closeQuietly(Closeable r0) {
        r0.close();     // Catch: Exception -> L6 RuntimeException -> L4
        return;
    L4:
        e = move-exception;
        throw e;
    }

    public static final Scale getScale(ImageView r1) {
        ImageView.ScaleType r2 = r1.getScaleType();
        if (r2 != null) goto L5;
        int r3 = -1;
    L7:
        if (r3 == 1) goto L16;
        if (r3 == 2) goto L16;
        if (r3 == 3) goto L16;
        if (r3 == 4) goto L16;
        return Scale.FILL;
    L16:
        return Scale.FIT;
    L5:
        r3 = WhenMappings.$EnumSwitchMapping$1[r2.ordinal()];
        goto L7
    }

    public static final String getMimeTypeFromUrl(MimeTypeMap r3, String r4) {
        String r0 = r4;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L13;
        return null;
    L13:
        return r3.getMimeTypeFromExtension(StringsKt.substringAfterLast(StringsKt.substringAfterLast$default(StringsKt.substringBeforeLast$default(StringsKt.substringBeforeLast$default(r4, '#', null, 2, null), '?', null, 2, null), IOUtils.DIR_SEPARATOR_UNIX, null, 2, null), '.', ""));
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L10
    }

    public static final String getFirstPathSegment(Uri r0) {
        return (String) CollectionsKt.firstOrNull(r0.getPathSegments());
    }

    public static final int getNightMode(Configuration r0) {
        return r0.uiMode & 48;
    }

    public static final Bitmap.Config[] getVALID_TRANSFORMATION_CONFIGS() {
        return VALID_TRANSFORMATION_CONFIGS;
    }

    static {
        VALID_TRANSFORMATION_CONFIGS = new Bitmap.Config[]{Bitmap.Config.ARGB_8888, Bitmap.Config.RGBA_F16};
        DEFAULT_BITMAP_CONFIG = Bitmap.Config.HARDWARE;
        EMPTY_HEADERS = new Headers.Builder().build();
    }

    public static final Bitmap.Config getDEFAULT_BITMAP_CONFIG() {
        return DEFAULT_BITMAP_CONFIG;
    }

    public static final ColorSpace getNULL_COLOR_SPACE() {
        return NULL_COLOR_SPACE;
    }

    public static final Headers getEMPTY_HEADERS() {
        return EMPTY_HEADERS;
    }

    public static final Headers orEmpty(Headers r0) {
        if (r0 == null) goto L4;
        return r0;
    L4:
        return EMPTY_HEADERS;
    }

    public static final Tags orEmpty(Tags r0) {
        if (r0 == null) goto L4;
        return r0;
    L4:
        return Tags.EMPTY;
    }

    public static final Parameters orEmpty(Parameters r0) {
        if (r0 == null) goto L4;
        return r0;
    L4:
        return Parameters.EMPTY;
    }

    public static final boolean isMainThread() {
        return Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper());
    }

    public static final int getIdentityHashCode(Object r0) {
        return System.identityHashCode(r0);
    }

    public static final <T> T getCompletedOrNull(Deferred<? extends T> r0) {
        return r0.getCompleted();
    L4:
        return null;
    }

    public static final MemoryCache.Value get(MemoryCache r0, MemoryCache.Key r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return r0.get(r1);
    }

    public static final File getSafeCacheDir(Context r1) {
        File r2 = r1.getCacheDir();
        if (r2 == null) goto L7;
        r2.mkdirs();
        return r2;
    L7:
        throw new IllegalStateException("cacheDir == null".toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final ComponentRegistry.Builder addFirst(ComponentRegistry.Builder r2, Pair<? extends Fetcher.Factory<?>, ? extends Class<?>> r3) {
        if (r3 == 0) goto L4;
        r2.getFetcherFactories$coil_base_release().add(0, r3);
    L4:
        return r2;
    }

    public static final ComponentRegistry.Builder addFirst(ComponentRegistry.Builder r2, Decoder.Factory r3) {
        if (r3 == null) goto L4;
        r2.getDecoderFactories$coil_base_release().add(0, r3);
    L4:
        return r2;
    }

    public static final int toNonNegativeInt(String r2, int r3) {
        Long r4 = StringsKt.toLongOrNull(r2);
        if (r4 == null) goto L12;
        long r5 = r4.longValue();
        if (r5 <= 2147483647L) goto L8;
        return Integer.MAX_VALUE;
    L8:
        if (r5 >= 0) goto L11;
        return 0;
    L11:
        return (int) r5;
    L12:
        return r3;
    }

    public static final void abortQuietly(DiskCache.Editor r0) {
        r0.abort();     // Catch: Exception -> L4
        return;
    }

    public static final boolean isPlaceholderCached(Interceptor.Chain r1) {
        if ((r1 instanceof RealInterceptorChain) == true) goto L5;
    L7:
        return false;
    L5:
        if (((RealInterceptorChain) r1).isPlaceholderCached() == false) goto L7;
        return true;
    }

    public static final EventListener getEventListener(Interceptor.Chain r1) {
        if ((r1 instanceof RealInterceptorChain) == false) goto L6;
        return ((RealInterceptorChain) r1).getEventListener();
    L6:
        return EventListener.NONE;
    }

    public static final int widthPx(Size r1, Scale r2, Function0<Integer> r3) {
        if (Sizes.isOriginal(r1) == false) goto L6;
        return r3.invoke().intValue();
    L6:
        return toPx(r1.getWidth(), r2);
    }

    public static final int heightPx(Size r1, Scale r2, Function0<Integer> r3) {
        if (Sizes.isOriginal(r1) == false) goto L6;
        return r3.invoke().intValue();
    L6:
        return toPx(r1.getHeight(), r2);
    }

    public static final Void unsupported() {
        throw new IllegalStateException("Unsupported".toString());
    }

    public static final boolean isAssetUri(Uri r2) {
        if (Intrinsics.areEqual(r2.getScheme(), "file") == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(getFirstPathSegment(r2), ASSET_FILE_PATH_ROOT) == false) goto L7;
        return true;
    }

    public static final Headers.Builder addUnsafeNonAscii(Headers.Builder r6, String r7) {
        int r0 = StringsKt.indexOf$default(r7, AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR, 0, false, 6, null);
        if (r0 == (-1)) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L10;
        String r2 = r7.substring(0, r0);
        Intrinsics.checkNotNullExpressionValue(r2, "this as java.lang.String…ing(startIndex, endIndex)");
        String r3 = StringsKt.trim(r2).toString();
        String r8 = r7.substring(r0 + 1);
        Intrinsics.checkNotNullExpressionValue(r8, "this as java.lang.String).substring(startIndex)");
        r6.addUnsafeNonAscii(r3, r8);
        return r6;
    L10:
        throw new IllegalArgumentException(("Unexpected header: " + r7).toString());
    L5:
        r1 = false;
        goto L6
    }

    public static final ResponseBody requireBody(Response r1) {
        ResponseBody r2 = r1.body();
        if (r2 == null) goto L6;
        return r2;
    L6:
        throw new IllegalStateException("response body == null".toString());
    }

    public static final int toPx(Dimension r1, Scale r2) {
        if ((r1 instanceof Dimension.Pixels) == true) goto L14;
        int r3 = WhenMappings.$EnumSwitchMapping$2[r2.ordinal()];
        if (r3 != 1) goto L8;
        return Integer.MIN_VALUE;
    L8:
        if (r3 != 2) goto L11;
        return Integer.MAX_VALUE;
    L11:
        throw new NoWhenBranchMatchedException();
    L14:
        return ((Dimension.Pixels) r1).px;
    }

    public static final double defaultMemoryCacheSizePercent(Context r3) {
        Object r4 = ContextCompat.getSystemService(r3, ActivityManager.class);     // Catch: Exception -> L7
        Intrinsics.checkNotNull(r4);     // Catch: Exception -> L7
        if (((ActivityManager) r4).isLowRamDevice() == false) goto L10;
        return LOW_MEMORY_MULTIPLIER;
    L10:
        return 0.2d;
    L11:
        return 0.2d;
    }

    public static final int calculateMemoryCacheSize(Context r2, double r3) {
        Object r0 = ContextCompat.getSystemService(r2, ActivityManager.class);     // Catch: Exception -> L10
        Intrinsics.checkNotNull(r0);     // Catch: Exception -> L10
        ActivityManager r1 = (ActivityManager) r0;     // Catch: Exception -> L10
        if ((r2.getApplicationInfo().flags & 1048576) == 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L8;
        int r5 = r1.getLargeMemoryClass();     // Catch: Exception -> L10
    L13:
    L11:
        double r6 = 1024;
        return (int) (((r3 * ((double) r5)) * r6) * r6);
    L8:
        r5 = r1.getMemoryClass();     // Catch: Exception -> L10
        goto L13
    L5:
        r4 = false;
    L10:
        r5 = 256;
        goto L11
    }
}
