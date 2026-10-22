package ul;

import com.bytedance.geckox.GeckoGlobalConfig;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f22367a = null;

    static {
        int[] r5 = new int[GeckoGlobalConfig.ENVType.values().length];
        r5[GeckoGlobalConfig.ENVType.BOE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
    L9:
        r5[GeckoGlobalConfig.ENVType.DEV.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
    L5:
        f22367a = r5;
    }
}
