package xs;

import com.ss.android.agilelogger.utils.FormatUtils$TYPE;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f23221a = null;

    static {
        int[] r5 = new int[FormatUtils$TYPE.values().length];
        f23221a = r5;
        r5[FormatUtils$TYPE.MSG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
    L24:
        f23221a[FormatUtils$TYPE.STACKTRACE_STR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
    L28:
        f23221a[FormatUtils$TYPE.BORDER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
    L38:
        f23221a[FormatUtils$TYPE.JSON.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
    L26:
        f23221a[FormatUtils$TYPE.BUNDLE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
    L30:
        f23221a[FormatUtils$TYPE.INTENT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
    L32:
        f23221a[FormatUtils$TYPE.THROWABLE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
    L34:
        f23221a[FormatUtils$TYPE.THREAD.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
    L22:
        f23221a[FormatUtils$TYPE.STACKTRACE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L21
        return;
    }
}
