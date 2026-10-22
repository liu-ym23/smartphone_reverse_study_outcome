package coil.size;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: coil.size.-Dimensions, reason: invalid class name */
/* JADX INFO: compiled from: Dimension.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0086\b¨\u0006\b"}, d2 = {"Dimension", "Lcoil/size/Dimension$Pixels;", "px", "", "pxOrElse", "Lcoil/size/Dimension;", "block", "Lkotlin/Function0;", "coil-base_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class Dimensions {
    public static final Dimension.Pixels Dimension(int r1) {
        return new Dimension.Pixels(r1);
    }

    public static final int pxOrElse(Dimension r1, Function0<Integer> r2) {
        if ((r1 instanceof Dimension.Pixels) == false) goto L6;
        return ((Dimension.Pixels) r1).px;
    L6:
        return r2.invoke().intValue();
    }
}
