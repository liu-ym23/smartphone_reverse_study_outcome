package zm;

import com.lynx.react.bridge.ReadableType;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f23538a = null;

    static {
        int[] r5 = new int[ReadableType.values().length];
        f23538a = r5;
        r5[ReadableType.String.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
    L16:
        f23538a[ReadableType.Int.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
    L20:
        f23538a[ReadableType.Long.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
    L26:
        f23538a[ReadableType.Number.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
    L18:
        f23538a[ReadableType.Boolean.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
    L22:
        f23538a[ReadableType.Null.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
        return;
    }
}
