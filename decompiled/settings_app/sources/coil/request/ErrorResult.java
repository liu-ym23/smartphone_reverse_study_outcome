package coil.request;

import android.graphics.drawable.Drawable;
import android.icu.text.PluralRules;
import com.obric.capabilitykit.common.Ext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImageResult.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcoil/request/ErrorResult;", "Lcoil/request/ImageResult;", "drawable", "Landroid/graphics/drawable/Drawable;", Ext.KEY_REQUEST, "Lcoil/request/ImageRequest;", "throwable", "", "(Landroid/graphics/drawable/Drawable;Lcoil/request/ImageRequest;Ljava/lang/Throwable;)V", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "getRequest", "()Lcoil/request/ImageRequest;", "getThrowable", "()Ljava/lang/Throwable;", "copy", "equals", "", PluralRules.KEYWORD_OTHER, "", "hashCode", "", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ErrorResult extends ImageResult {
    private final Drawable drawable;
    private final ImageRequest request;
    private final Throwable throwable;

    @Override // coil.request.ImageResult
    public Drawable getDrawable() {
        return this.drawable;
    }

    @Override // coil.request.ImageResult
    public ImageRequest getRequest() {
        return this.request;
    }

    public final Throwable getThrowable() {
        return this.throwable;
    }

    public ErrorResult(Drawable r2, ImageRequest r3, Throwable r4) {
        super(null);
        this.drawable = r2;
        this.request = r3;
        this.throwable = r4;
    }

    public static /* synthetic */ ErrorResult copy$default(ErrorResult r0, Drawable r1, ImageRequest r2, Throwable r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.getDrawable();
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.getRequest();
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.throwable;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final ErrorResult copy(Drawable r1, ImageRequest r2, Throwable r3) {
        return new ErrorResult(r1, r2, r3);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof ErrorResult) == false) goto L14;
        ErrorResult r5 = (ErrorResult) r4;
        if (Intrinsics.areEqual(getDrawable(), r5.getDrawable()) == false) goto L14;
        if (Intrinsics.areEqual(getRequest(), r5.getRequest()) == false) goto L14;
        if (Intrinsics.areEqual(this.throwable, r5.throwable) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        Drawable r0 = getDrawable();
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L7:
        return (((r1 * 31) + getRequest().hashCode()) * 31) + this.throwable.hashCode();
    L5:
        r1 = 0;
        goto L7
    }
}
