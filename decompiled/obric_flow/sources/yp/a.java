package yp;

import com.obric.common.oea.style.scene.alpha.alphaplayer.model.ScaleType;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f23315a = null;

    static {
        int[] r5 = new int[ScaleType.values().length];
        f23315a = r5;
        r5[ScaleType.ScaleAspectFitCenter.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
    L26:
        f23315a[ScaleType.ScaleAspectFill.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
    L32:
        f23315a[ScaleType.TopFill.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
    L42:
        f23315a[ScaleType.BottomFill.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
    L28:
        f23315a[ScaleType.LeftFill.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
    L34:
        f23315a[ScaleType.RightFill.ordinal()] = 6;     // Catch: NoSuchFieldError -> L19
    L36:
        f23315a[ScaleType.TopFit.ordinal()] = 7;     // Catch: NoSuchFieldError -> L20
    L38:
        f23315a[ScaleType.BottomFit.ordinal()] = 8;     // Catch: NoSuchFieldError -> L21
    L24:
        f23315a[ScaleType.LeftFit.ordinal()] = 9;     // Catch: NoSuchFieldError -> L22
    L30:
        f23315a[ScaleType.RightFit.ordinal()] = 10;     // Catch: NoSuchFieldError -> L23
        return;
    }
}
