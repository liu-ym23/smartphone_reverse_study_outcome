package coil.size;

import android.icu.text.PluralRules;
import com.obric.oui.material.MaterialConfigFormatNames;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: Size.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcoil/size/Size;", "", MaterialConfigFormatNames.WIDTH, "Lcoil/size/Dimension;", MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "(Lcoil/size/Dimension;Lcoil/size/Dimension;)V", "getHeight", "()Lcoil/size/Dimension;", "getWidth", "component1", "component2", "copy", "equals", "", PluralRules.KEYWORD_OTHER, "hashCode", "", "toString", "", "Companion", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Size {
    public static final Companion Companion = null;
    public static final Size ORIGINAL = null;
    private final Dimension height;
    private final Dimension width;

    /* JADX INFO: compiled from: Size.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcoil/size/Size$Companion;", "", "()V", "ORIGINAL", "Lcoil/size/Size;", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    public static /* synthetic */ Size copy$default(Size r0, Dimension r1, Dimension r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.width;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.height;
    L9:
        return r0.copy(r1, r2);
    }

    public final Dimension component1() {
        return this.width;
    }

    public final Dimension component2() {
        return this.height;
    }

    public final Size copy(Dimension r1, Dimension r2) {
        return new Size(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Size) == true) goto L8;
        return false;
    L8:
        Size r6 = (Size) r5;
        if (Intrinsics.areEqual(this.width, r6.width) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.height, r6.height) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.width.hashCode() * 31) + this.height.hashCode();
    }

    public String toString() {
        return "Size(width=" + this.width + ", height=" + this.height + ')';
    }

    public Size(Dimension r1, Dimension r2) {
        this.width = r1;
        this.height = r2;
    }

    public final Dimension getWidth() {
        return this.width;
    }

    public final Dimension getHeight() {
        return this.height;
    }

    static {
        Companion = new Companion(null);
        ORIGINAL = new Size(Dimension.Undefined.INSTANCE, Dimension.Undefined.INSTANCE);
    }
}
