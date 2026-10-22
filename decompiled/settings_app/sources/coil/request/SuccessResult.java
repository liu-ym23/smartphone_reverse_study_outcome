package coil.request;

import android.graphics.drawable.Drawable;
import android.icu.text.PluralRules;
import coil.decode.DataSource;
import coil.memory.MemoryCache;
import com.obric.capabilitykit.common.Ext;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImageResult.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0002\u0010\u000fJP\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\rJ\u0013\u0010\u001c\u001a\u00020\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0096\u0002J\b\u0010\u001f\u001a\u00020 H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0016R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006!"}, d2 = {"Lcoil/request/SuccessResult;", "Lcoil/request/ImageResult;", "drawable", "Landroid/graphics/drawable/Drawable;", Ext.KEY_REQUEST, "Lcoil/request/ImageRequest;", "dataSource", "Lcoil/decode/DataSource;", "memoryCacheKey", "Lcoil/memory/MemoryCache$Key;", "diskCacheKey", "", "isSampled", "", "isPlaceholderCached", "(Landroid/graphics/drawable/Drawable;Lcoil/request/ImageRequest;Lcoil/decode/DataSource;Lcoil/memory/MemoryCache$Key;Ljava/lang/String;ZZ)V", "getDataSource", "()Lcoil/decode/DataSource;", "getDiskCacheKey", "()Ljava/lang/String;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "()Z", "getMemoryCacheKey", "()Lcoil/memory/MemoryCache$Key;", "getRequest", "()Lcoil/request/ImageRequest;", "copy", "equals", PluralRules.KEYWORD_OTHER, "", "hashCode", "", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SuccessResult extends ImageResult {
    private final DataSource dataSource;
    private final String diskCacheKey;
    private final Drawable drawable;
    private final boolean isPlaceholderCached;
    private final boolean isSampled;
    private final MemoryCache.Key memoryCacheKey;
    private final ImageRequest request;

    public /* synthetic */ SuccessResult(Drawable r11, ImageRequest r12, DataSource r13, MemoryCache.Key r14, String r15, boolean r16, boolean r17, int r18, DefaultConstructorMarker r19) {
        if ((r18 & 8) == 0) goto L5;
        MemoryCache.Key r6 = null;
    L7:
        if ((r18 & 16) == 0) goto L9;
        String r7 = null;
    L11:
        if ((r18 & 32) == 0) goto L13;
        boolean r8 = false;
    L15:
        if ((r18 & 64) == 0) goto L17;
        boolean r9 = false;
    L18:
        this(r11, r12, r13, r6, r7, r8, r9);
        return;
    L17:
        r9 = r17;
        goto L18
    L13:
        r8 = r16;
        goto L15
    L9:
        r7 = r15;
        goto L11
    L5:
        r6 = r14;
        goto L7
    }

    @Override // coil.request.ImageResult
    public Drawable getDrawable() {
        return this.drawable;
    }

    @Override // coil.request.ImageResult
    public ImageRequest getRequest() {
        return this.request;
    }

    public final DataSource getDataSource() {
        return this.dataSource;
    }

    public final MemoryCache.Key getMemoryCacheKey() {
        return this.memoryCacheKey;
    }

    public final String getDiskCacheKey() {
        return this.diskCacheKey;
    }

    public final boolean isSampled() {
        return this.isSampled;
    }

    public final boolean isPlaceholderCached() {
        return this.isPlaceholderCached;
    }

    public SuccessResult(Drawable r2, ImageRequest r3, DataSource r4, MemoryCache.Key r5, String r6, boolean r7, boolean r8) {
        super(null);
        this.drawable = r2;
        this.request = r3;
        this.dataSource = r4;
        this.memoryCacheKey = r5;
        this.diskCacheKey = r6;
        this.isSampled = r7;
        this.isPlaceholderCached = r8;
    }

    public static /* synthetic */ SuccessResult copy$default(SuccessResult r5, Drawable r6, ImageRequest r7, DataSource r8, MemoryCache.Key r9, String r10, boolean r11, boolean r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.getDrawable();
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.getRequest();
    L8:
        ImageRequest r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.dataSource;
    L11:
        DataSource r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.memoryCacheKey;
    L14:
        MemoryCache.Key r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.diskCacheKey;
    L17:
        String r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.isSampled;
    L20:
        boolean r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.isPlaceholderCached;
    L23:
        Drawable r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final SuccessResult copy(Drawable r9, ImageRequest r10, DataSource r11, MemoryCache.Key r12, String r13, boolean r14, boolean r15) {
        return new SuccessResult(r9, r10, r11, r12, r13, r14, r15);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof SuccessResult) == false) goto L22;
        SuccessResult r5 = (SuccessResult) r4;
        if (Intrinsics.areEqual(getDrawable(), r5.getDrawable()) == false) goto L22;
        if (Intrinsics.areEqual(getRequest(), r5.getRequest()) == false) goto L22;
        if (this.dataSource != r5.dataSource) goto L22;
        if (Intrinsics.areEqual(this.memoryCacheKey, r5.memoryCacheKey) == false) goto L22;
        if (Intrinsics.areEqual(this.diskCacheKey, r5.diskCacheKey) == false) goto L22;
        if (this.isSampled != r5.isSampled) goto L22;
        if (this.isPlaceholderCached != r5.isPlaceholderCached) goto L22;
        return true;
    L22:
        return false;
    }

    public int hashCode() {
        int r0 = ((((getDrawable().hashCode() * 31) + getRequest().hashCode()) * 31) + this.dataSource.hashCode()) * 31;
        MemoryCache.Key r1 = this.memoryCacheKey;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.diskCacheKey;
        if (r5 == null) goto L10;
        r2 = r5.hashCode();
    L10:
        return ((((r4 + r2) * 31) + Boolean.hashCode(this.isSampled)) * 31) + Boolean.hashCode(this.isPlaceholderCached);
    L5:
        r3 = 0;
        goto L6
    }
}
