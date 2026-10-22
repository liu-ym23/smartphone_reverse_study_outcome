package com.obric.oui.image;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OImageStyleHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u0000 %2\u00020\u0001:\u0001%B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003JD\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0007HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011¨\u0006&"}, d2 = {"Lcom/obric/oui/image/OImageStyleConfig;", "", "shape", "Lcom/obric/oui/image/OImageShape;", "strokeEnabled", "", "backgroundColor", "", "strokeColor", "clipToMask", "(Lcom/obric/oui/image/OImageShape;ZLjava/lang/Integer;Ljava/lang/Integer;Z)V", "getBackgroundColor", "()Ljava/lang/Integer;", "setBackgroundColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getClipToMask", "()Z", "setClipToMask", "(Z)V", "getShape", "()Lcom/obric/oui/image/OImageShape;", "getStrokeColor", "setStrokeColor", "getStrokeEnabled", "component1", "component2", "component3", "component4", "component5", "copy", "(Lcom/obric/oui/image/OImageShape;ZLjava/lang/Integer;Ljava/lang/Integer;Z)Lcom/obric/oui/image/OImageStyleConfig;", "equals", "other", "hashCode", "toString", "", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OImageStyleConfig {
    public static final Companion Companion = null;
    private static final String TAG = "OImageStyleHelper";
    private Integer backgroundColor;
    private boolean clipToMask;
    private final OImageShape shape;
    private Integer strokeColor;
    private final boolean strokeEnabled;

    /* JADX INFO: compiled from: OImageStyleHelper.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/oui/image/OImageStyleConfig$Companion;", "", "()V", "TAG", "", "fromAttributes", "Lcom/obric/oui/image/OImageStyleConfig;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ OImageStyleConfig fromAttributes$default(Companion r1, Context r2, AttributeSet r3, int r4, int r5, int r6, Object r7) {
            if ((r6 & 4) == 0) goto L6;
            r4 = 0;
        L6:
            if ((r6 & 8) == 0) goto L9;
            r5 = 0;
        L9:
            return r1.fromAttributes(r2, r3, r4, r5);
        }

        public final OImageStyleConfig fromAttributes(Context r9, AttributeSet r10, int r11, int r12) {
            Intrinsics.checkNotNullParameter(r9, "context");
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L21
            Companion r8 = this;     // Catch: Throwable -> L21
            if (r10 != null) goto L6;
            OImageStyleConfig r13 = new OImageStyleConfig(null, false, null, null, false, 31, null);     // Catch: Throwable -> L21
        L17:
            Object r14 = Result.m774constructorimpl(r13);     // Catch: Throwable -> L21
        L23:
            Throwable r15 = Result.m777exceptionOrNullimpl(r14);
            if (r15 == null) goto L28;
            Log.w(OImageStyleConfig.TAG, "Failed to parse OImage attrs, fallback to defaults", r15);
            r14 = new OImageStyleConfig(null, false, null, null, false, 31, null);
        L28:
            return (OImageStyleConfig) r14;
        L6:
            TypedArray r16 = r9.obtainStyledAttributes(r10, R.styleable.OImage, r11, r12);     // Catch: Throwable -> L21
            int r17 = r16.getInt(R.styleable.OImage_oui_imageShape, OImageShape.STANDARD.getAttrValue());     // Catch: Throwable -> L18
            OImageShape r1 = OImageShape.Companion.fromAttrValue(r17);     // Catch: Throwable -> L18
            boolean r2 = r16.getBoolean(R.styleable.OImage_oui_imageStrokeEnabled, true);     // Catch: Throwable -> L18
            if (r16.hasValue(R.styleable.OImage_oui_imageBackgroundColor) == false) goto L10;
            Integer r18 = Integer.valueOf(r16.getColor(R.styleable.OImage_oui_imageBackgroundColor, 0));     // Catch: Throwable -> L18
        L11:
            Integer r3 = r18;
            if (r16.hasValue(R.styleable.OImage_oui_imageStrokeColor) == false) goto L14;
            int r19 = r16.getColor(R.styleable.OImage_oui_imageStrokeColor, ContextCompat.getColor(r9, R.color.oui_line_1));     // Catch: Throwable -> L18
        L15:
            OImageStyleConfig r110 = new OImageStyleConfig(r1, r2, r3, Integer.valueOf(r19), r16.getBoolean(R.styleable.OImage_oui_clipToMask, false));     // Catch: Throwable -> L18
            r16.recycle();     // Catch: Throwable -> L21
            r13 = r110;
            goto L17
        L14:
            r19 = ContextCompat.getColor(r9, R.color.oui_line_1);     // Catch: Throwable -> L18
            goto L15
        L10:
            r18 = null;
            Integer r4 = (Integer) null;     // Catch: Throwable -> L18
        L18:
            th = move-exception;
            r16.recycle();     // Catch: Throwable -> L21
            throw th;     // Catch: Throwable -> L21
        L21:
            th = move-exception;
            Result.Companion r20 = Result.Companion;
            r14 = Result.m774constructorimpl(ResultKt.createFailure(th));
            goto L23
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OImageStyleConfig() {
        this(null, false, null, null, false, 31, null);
    }

    public static /* synthetic */ OImageStyleConfig copy$default(OImageStyleConfig r3, OImageShape r4, boolean r5, Integer r6, Integer r7, boolean r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.shape;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.strokeEnabled;
    L8:
        boolean r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.backgroundColor;
    L11:
        Integer r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.strokeColor;
    L14:
        Integer r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.clipToMask;
    L17:
        OImageShape r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final OImageShape component1() {
        return this.shape;
    }

    public final boolean component2() {
        return this.strokeEnabled;
    }

    public final Integer component3() {
        return this.backgroundColor;
    }

    public final Integer component4() {
        return this.strokeColor;
    }

    public final boolean component5() {
        return this.clipToMask;
    }

    public final OImageStyleConfig copy(OImageShape r7, boolean r8, Integer r9, Integer r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r7, "shape");
        return new OImageStyleConfig(r7, r8, r9, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof OImageStyleConfig) == true) goto L8;
        return false;
    L8:
        OImageStyleConfig r6 = (OImageStyleConfig) r5;
        if (this.shape == r6.shape) goto L12;
        return false;
    L12:
        if (this.strokeEnabled == r6.strokeEnabled) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.backgroundColor, r6.backgroundColor) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.strokeColor, r6.strokeColor) == true) goto L21;
        return false;
    L21:
        if (this.clipToMask == r6.clipToMask) goto L23;
        return false;
    L23:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int r0 = this.shape.hashCode() * 31;
        boolean r1 = this.strokeEnabled;
        ?? r2 = 1;
        ?? r3 = r1;
        if (r1 == false) goto L5;
        r3 = 1;
    L5:
        int r4 = (r0 + r3) * 31;
        Integer r5 = this.backgroundColor;
        int r6 = 0;
        if (r5 != null) goto L8;
        int r7 = 0;
    L9:
        int r8 = (r4 + r7) * 31;
        Integer r9 = this.strokeColor;
        if (r9 == null) goto L13;
        r6 = r9.hashCode();
    L13:
        int r10 = (r8 + r6) * 31;
        boolean r11 = this.clipToMask;
        if (r11 == true) goto L18;
        r2 = r11;
    L18:
        return r10 + r2;
    L8:
        r7 = r5.hashCode();
        goto L9
    }

    public String toString() {
        return "OImageStyleConfig(shape=" + this.shape + ", strokeEnabled=" + this.strokeEnabled + ", backgroundColor=" + this.backgroundColor + ", strokeColor=" + this.strokeColor + ", clipToMask=" + this.clipToMask + ')';
    }

    public OImageStyleConfig(OImageShape r2, boolean r3, Integer r4, Integer r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "shape");
        this.shape = r2;
        this.strokeEnabled = r3;
        this.backgroundColor = r4;
        this.strokeColor = r5;
        this.clipToMask = r6;
    }

    public /* synthetic */ OImageStyleConfig(OImageShape r4, boolean r5, Integer r6, Integer r7, boolean r8, int r9, DefaultConstructorMarker r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = OImageShape.STANDARD;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = true;
    L8:
        boolean r11 = r5;
        Integer r0 = null;
        if ((r9 & 4) == 0) goto L11;
        Integer r1 = null;
    L13:
        if ((r9 & 8) != 0) goto L17;
        r0 = r7;
    L17:
        if ((r9 & 16) == 0) goto L19;
        r8 = false;
    L19:
        this(r4, r11, r1, r0, r8);
        return;
    L11:
        r1 = r6;
        goto L13
    }

    public final OImageShape getShape() {
        return this.shape;
    }

    public final boolean getStrokeEnabled() {
        return this.strokeEnabled;
    }

    public final Integer getBackgroundColor() {
        return this.backgroundColor;
    }

    public final void setBackgroundColor(Integer r1) {
        this.backgroundColor = r1;
    }

    public final Integer getStrokeColor() {
        return this.strokeColor;
    }

    public final void setStrokeColor(Integer r1) {
        this.strokeColor = r1;
    }

    public final boolean getClipToMask() {
        return this.clipToMask;
    }

    public final void setClipToMask(boolean r1) {
        this.clipToMask = r1;
    }
}
