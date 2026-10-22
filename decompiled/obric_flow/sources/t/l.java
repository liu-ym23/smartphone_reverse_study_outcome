package t;

import com.airbnb.lottie.parser.moshi.JsonReader$Token;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f22035a = null;

    static {
        int[] r5 = new int[JsonReader$Token.values().length];
        f22035a = r5;
        r5[JsonReader$Token.NUMBER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
    L10:
        f22035a[JsonReader$Token.BEGIN_ARRAY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
    L12:
        f22035a[JsonReader$Token.BEGIN_OBJECT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
        return;
    }
}
