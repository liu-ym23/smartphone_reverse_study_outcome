package cz.msebera.android.httpclient.entity.mime;

/* JADX INFO: loaded from: classes5.dex */
public final enum HttpMultipartMode extends Enum<HttpMultipartMode> {
    private static final /* synthetic */ HttpMultipartMode[] $VALUES = null;
    public static final HttpMultipartMode BROWSER_COMPATIBLE = null;
    public static final HttpMultipartMode RFC6532 = null;
    public static final HttpMultipartMode STRICT = null;

    private HttpMultipartMode(String r1, int r2) {
        super(r1, r2);
    }

    public static HttpMultipartMode valueOf(String r1) {
        return (HttpMultipartMode) Enum.valueOf(HttpMultipartMode.class, r1);
    }

    public static HttpMultipartMode[] values() {
        return (HttpMultipartMode[]) $VALUES.clone();
    }

    static {
        HttpMultipartMode r0 = new HttpMultipartMode("STRICT", 0);
        STRICT = r0;
        HttpMultipartMode r1 = new HttpMultipartMode("BROWSER_COMPATIBLE", 1);
        BROWSER_COMPATIBLE = r1;
        HttpMultipartMode r3 = new HttpMultipartMode("RFC6532", 2);
        RFC6532 = r3;
        $VALUES = new HttpMultipartMode[]{r0, r1, r3};
    }
}
