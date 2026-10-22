package coil.request;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.icu.text.PluralRules;
import coil.size.Scale;
import coil.size.Size;
import coil.util.Utils;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.tracing.internal.TracingConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;

/* JADX INFO: compiled from: Options.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u009d\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0019¢\u0006\u0002\u0010\u001cJ \u0001\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u0019J\u0013\u00108\u001a\u00020\r2\b\u00109\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010:\u001a\u00020;H\u0016R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u001a\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b,\u0010)R\u0011\u0010\u001b\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b-\u0010)R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u000f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001eR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b5\u00106¨\u0006<"}, d2 = {"Lcoil/request/Options;", "", "context", "Landroid/content/Context;", "config", "Landroid/graphics/Bitmap$Config;", "colorSpace", "Landroid/graphics/ColorSpace;", PerfConsts.PERF_DISK_FILE_SIZE, "Lcoil/size/Size;", "scale", "Lcoil/size/Scale;", "allowInexactSize", "", "allowRgb565", "premultipliedAlpha", "diskCacheKey", "", "headers", "Lokhttp3/Headers;", TracingConstants.KEY_TAGS, "Lcoil/request/Tags;", "parameters", "Lcoil/request/Parameters;", "memoryCachePolicy", "Lcoil/request/CachePolicy;", "diskCachePolicy", "networkCachePolicy", "(Landroid/content/Context;Landroid/graphics/Bitmap$Config;Landroid/graphics/ColorSpace;Lcoil/size/Size;Lcoil/size/Scale;ZZZLjava/lang/String;Lokhttp3/Headers;Lcoil/request/Tags;Lcoil/request/Parameters;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;)V", "getAllowInexactSize", "()Z", "getAllowRgb565", "getColorSpace", "()Landroid/graphics/ColorSpace;", "getConfig", "()Landroid/graphics/Bitmap$Config;", "getContext", "()Landroid/content/Context;", "getDiskCacheKey", "()Ljava/lang/String;", "getDiskCachePolicy", "()Lcoil/request/CachePolicy;", "getHeaders", "()Lokhttp3/Headers;", "getMemoryCachePolicy", "getNetworkCachePolicy", "getParameters", "()Lcoil/request/Parameters;", "getPremultipliedAlpha", "getScale", "()Lcoil/size/Scale;", "getSize", "()Lcoil/size/Size;", "getTags", "()Lcoil/request/Tags;", "copy", "equals", PluralRules.KEYWORD_OTHER, "hashCode", "", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Options {
    private final boolean allowInexactSize;
    private final boolean allowRgb565;
    private final ColorSpace colorSpace;
    private final Bitmap.Config config;
    private final Context context;
    private final String diskCacheKey;
    private final CachePolicy diskCachePolicy;
    private final Headers headers;
    private final CachePolicy memoryCachePolicy;
    private final CachePolicy networkCachePolicy;
    private final Parameters parameters;
    private final boolean premultipliedAlpha;
    private final Scale scale;
    private final Size size;
    private final Tags tags;

    public Options(Context r1, Bitmap.Config r2, ColorSpace r3, Size r4, Scale r5, boolean r6, boolean r7, boolean r8, String r9, Headers r10, Tags r11, Parameters r12, CachePolicy r13, CachePolicy r14, CachePolicy r15) {
        this.context = r1;
        this.config = r2;
        this.colorSpace = r3;
        this.size = r4;
        this.scale = r5;
        this.allowInexactSize = r6;
        this.allowRgb565 = r7;
        this.premultipliedAlpha = r8;
        this.diskCacheKey = r9;
        this.headers = r10;
        this.tags = r11;
        this.parameters = r12;
        this.memoryCachePolicy = r13;
        this.diskCachePolicy = r14;
        this.networkCachePolicy = r15;
    }

    public final Context getContext() {
        return this.context;
    }

    public /* synthetic */ Options(Context r15, Bitmap.Config r16, ColorSpace r17, Size r18, Scale r19, boolean r20, boolean r21, boolean r22, String r23, Headers r24, Tags r25, Parameters r26, CachePolicy r27, CachePolicy r28, CachePolicy r29, int r30, DefaultConstructorMarker r31) {
        if ((r30 & 2) == 0) goto L5;
        Bitmap.Config r1 = Bitmap.Config.ARGB_8888;
    L7:
        if ((r30 & 4) == 0) goto L9;
        ColorSpace r2 = Utils.getNULL_COLOR_SPACE();
    L11:
        if ((r30 & 8) == 0) goto L13;
        Size r3 = Size.ORIGINAL;
    L15:
        if ((r30 & 16) == 0) goto L17;
        Scale r4 = Scale.FIT;
    L18:
        boolean r6 = false;
        if ((r30 & 32) == 0) goto L21;
        boolean r5 = false;
    L23:
        if ((r30 & 64) != 0) goto L27;
        r6 = r21;
    L27:
        if ((r30 & 128) == 0) goto L29;
        boolean r7 = true;
    L31:
        if ((r30 & 256) == 0) goto L33;
        String r8 = null;
    L35:
        if ((r30 & 512) == 0) goto L37;
        Headers r9 = Utils.getEMPTY_HEADERS();
    L39:
        if ((r30 & 1024) == 0) goto L41;
        Tags r10 = Tags.EMPTY;
    L43:
        if ((r30 & 2048) == 0) goto L45;
        Parameters r11 = Parameters.EMPTY;
    L47:
        if ((r30 & 4096) == 0) goto L49;
        CachePolicy r12 = CachePolicy.ENABLED;
    L51:
        if ((r30 & 8192) == 0) goto L53;
        CachePolicy r13 = CachePolicy.ENABLED;
    L55:
        if ((r30 & 16384) == 0) goto L57;
        CachePolicy r0 = CachePolicy.ENABLED;
    L58:
        this(r15, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r0);
        return;
    L57:
        r0 = r29;
        goto L58
    L53:
        r13 = r28;
        goto L55
    L49:
        r12 = r27;
        goto L51
    L45:
        r11 = r26;
        goto L47
    L41:
        r10 = r25;
        goto L43
    L37:
        r9 = r24;
        goto L39
    L33:
        r8 = r23;
        goto L35
    L29:
        r7 = r22;
        goto L31
    L21:
        r5 = r20;
        goto L23
    L17:
        r4 = r19;
        goto L18
    L13:
        r3 = r18;
        goto L15
    L9:
        r2 = r17;
        goto L11
    L5:
        r1 = r16;
        goto L7
    }

    public final Bitmap.Config getConfig() {
        return this.config;
    }

    public final ColorSpace getColorSpace() {
        return this.colorSpace;
    }

    public final Size getSize() {
        return this.size;
    }

    public final Scale getScale() {
        return this.scale;
    }

    public final boolean getAllowInexactSize() {
        return this.allowInexactSize;
    }

    public final boolean getAllowRgb565() {
        return this.allowRgb565;
    }

    public final boolean getPremultipliedAlpha() {
        return this.premultipliedAlpha;
    }

    public final String getDiskCacheKey() {
        return this.diskCacheKey;
    }

    public final Headers getHeaders() {
        return this.headers;
    }

    public final Tags getTags() {
        return this.tags;
    }

    public final Parameters getParameters() {
        return this.parameters;
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

    public static /* synthetic */ Options copy$default(Options r16, Context r17, Bitmap.Config r18, ColorSpace r19, Size r20, Scale r21, boolean r22, boolean r23, boolean r24, String r25, Headers r26, Tags r27, Parameters r28, CachePolicy r29, CachePolicy r30, CachePolicy r31, int r32, Object r33) {
        if ((r32 & 1) == 0) goto L5;
        Context r2 = r16.context;
    L7:
        if ((r32 & 2) == 0) goto L9;
        Bitmap.Config r3 = r16.config;
    L11:
        if ((r32 & 4) == 0) goto L13;
        ColorSpace r4 = r16.colorSpace;
    L15:
        if ((r32 & 8) == 0) goto L17;
        Size r5 = r16.size;
    L19:
        if ((r32 & 16) == 0) goto L21;
        Scale r6 = r16.scale;
    L23:
        if ((r32 & 32) == 0) goto L25;
        boolean r7 = r16.allowInexactSize;
    L27:
        if ((r32 & 64) == 0) goto L29;
        boolean r8 = r16.allowRgb565;
    L31:
        if ((r32 & 128) == 0) goto L33;
        boolean r9 = r16.premultipliedAlpha;
    L35:
        if ((r32 & 256) == 0) goto L37;
        String r10 = r16.diskCacheKey;
    L39:
        if ((r32 & 512) == 0) goto L41;
        Headers r11 = r16.headers;
    L43:
        if ((r32 & 1024) == 0) goto L45;
        Tags r12 = r16.tags;
    L47:
        if ((r32 & 2048) == 0) goto L49;
        Parameters r13 = r16.parameters;
    L51:
        if ((r32 & 4096) == 0) goto L53;
        CachePolicy r14 = r16.memoryCachePolicy;
    L55:
        if ((r32 & 8192) == 0) goto L57;
        CachePolicy r15 = r16.diskCachePolicy;
    L59:
        if ((r32 & 16384) == 0) goto L61;
        CachePolicy r1 = r16.networkCachePolicy;
    L63:
        return r16.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r1);
    L61:
        r1 = r31;
        goto L63
    L57:
        r15 = r30;
        goto L59
    L53:
        r14 = r29;
        goto L55
    L49:
        r13 = r28;
        goto L51
    L45:
        r12 = r27;
        goto L47
    L41:
        r11 = r26;
        goto L43
    L37:
        r10 = r25;
        goto L39
    L33:
        r9 = r24;
        goto L35
    L29:
        r8 = r23;
        goto L31
    L25:
        r7 = r22;
        goto L27
    L21:
        r6 = r21;
        goto L23
    L17:
        r5 = r20;
        goto L19
    L13:
        r4 = r19;
        goto L15
    L9:
        r3 = r18;
        goto L11
    L5:
        r2 = r17;
        goto L7
    }

    public final Options copy(Context r18, Bitmap.Config r19, ColorSpace r20, Size r21, Scale r22, boolean r23, boolean r24, boolean r25, String r26, Headers r27, Tags r28, Parameters r29, CachePolicy r30, CachePolicy r31, CachePolicy r32) {
        return new Options(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof Options) == false) goto L38;
        Options r5 = (Options) r4;
        if (Intrinsics.areEqual(this.context, r5.context) == false) goto L38;
        if (this.config != r5.config) goto L38;
        if (Intrinsics.areEqual(this.colorSpace, r5.colorSpace) == false) goto L38;
        if (Intrinsics.areEqual(this.size, r5.size) == false) goto L38;
        if (this.scale != r5.scale) goto L38;
        if (this.allowInexactSize != r5.allowInexactSize) goto L38;
        if (this.allowRgb565 != r5.allowRgb565) goto L38;
        if (this.premultipliedAlpha != r5.premultipliedAlpha) goto L38;
        if (Intrinsics.areEqual(this.diskCacheKey, r5.diskCacheKey) == false) goto L38;
        if (Intrinsics.areEqual(this.headers, r5.headers) == false) goto L38;
        if (Intrinsics.areEqual(this.tags, r5.tags) == false) goto L38;
        if (Intrinsics.areEqual(this.parameters, r5.parameters) == false) goto L38;
        if (this.memoryCachePolicy != r5.memoryCachePolicy) goto L38;
        if (this.diskCachePolicy != r5.diskCachePolicy) goto L38;
        if (this.networkCachePolicy != r5.networkCachePolicy) goto L38;
        return true;
    L38:
        return false;
    }

    public int hashCode() {
        int r0 = ((this.context.hashCode() * 31) + this.config.hashCode()) * 31;
        ColorSpace r1 = this.colorSpace;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (((((((((((r0 + r3) * 31) + this.size.hashCode()) * 31) + this.scale.hashCode()) * 31) + Boolean.hashCode(this.allowInexactSize)) * 31) + Boolean.hashCode(this.allowRgb565)) * 31) + Boolean.hashCode(this.premultipliedAlpha)) * 31;
        String r5 = this.diskCacheKey;
        if (r5 == null) goto L10;
        r2 = r5.hashCode();
    L10:
        return ((((((((((((r4 + r2) * 31) + this.headers.hashCode()) * 31) + this.tags.hashCode()) * 31) + this.parameters.hashCode()) * 31) + this.memoryCachePolicy.hashCode()) * 31) + this.diskCachePolicy.hashCode()) * 31) + this.networkCachePolicy.hashCode();
    L5:
        r3 = 0;
        goto L6
    }
}
