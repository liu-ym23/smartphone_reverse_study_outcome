package com.android.apksig.internal.apk;

/* JADX INFO: loaded from: classes.dex */
public final enum ContentDigestAlgorithm extends Enum<ContentDigestAlgorithm> {
    private static final /* synthetic */ ContentDigestAlgorithm[] $VALUES = null;
    public static final ContentDigestAlgorithm CHUNKED_SHA256 = null;
    public static final ContentDigestAlgorithm CHUNKED_SHA512 = null;
    public static final ContentDigestAlgorithm SHA256 = null;
    public static final ContentDigestAlgorithm VERITY_CHUNKED_SHA256 = null;
    private final int mChunkDigestOutputSizeBytes;
    private final int mId;
    private final String mJcaMessageDigestAlgorithm;

    static {
        ContentDigestAlgorithm r6 = new ContentDigestAlgorithm("CHUNKED_SHA256", 0, 1, "SHA-256", 32);
        CHUNKED_SHA256 = r6;
        ContentDigestAlgorithm r0 = new ContentDigestAlgorithm("CHUNKED_SHA512", 1, 2, "SHA-512", 64);
        CHUNKED_SHA512 = r0;
        ContentDigestAlgorithm r1 = new ContentDigestAlgorithm("VERITY_CHUNKED_SHA256", 2, 3, "SHA-256", 32);
        VERITY_CHUNKED_SHA256 = r1;
        ContentDigestAlgorithm r2 = new ContentDigestAlgorithm("SHA256", 3, 4, "SHA-256", 32);
        SHA256 = r2;
        $VALUES = new ContentDigestAlgorithm[]{r6, r0, r1, r2};
    }

    private ContentDigestAlgorithm(String r1, int r2, int r3, String r4, int r5) {
        super(r1, r2);
        this.mId = r3;
        this.mJcaMessageDigestAlgorithm = r4;
        this.mChunkDigestOutputSizeBytes = r5;
    }

    public static ContentDigestAlgorithm valueOf(String r1) {
        return (ContentDigestAlgorithm) Enum.valueOf(ContentDigestAlgorithm.class, r1);
    }

    public static ContentDigestAlgorithm[] values() {
        return (ContentDigestAlgorithm[]) $VALUES.clone();
    }
}
