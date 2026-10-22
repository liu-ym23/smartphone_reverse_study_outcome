package cz.msebera.android.httpclient.impl.client.cache;

import com.bytedance.networkstackapplib.NetworkStackConstant;

/* JADX INFO: loaded from: classes5.dex */
final enum RequestProtocolError extends Enum<RequestProtocolError> {
    private static final /* synthetic */ RequestProtocolError[] $VALUES = null;
    public static final RequestProtocolError BODY_BUT_NO_LENGTH_ERROR = null;
    public static final RequestProtocolError NO_CACHE_DIRECTIVE_WITH_FIELD_NAME = null;
    public static final RequestProtocolError UNKNOWN = null;
    public static final RequestProtocolError WEAK_ETAG_AND_RANGE_ERROR = null;
    public static final RequestProtocolError WEAK_ETAG_ON_PUTDELETE_METHOD_ERROR = null;

    private RequestProtocolError(String r1, int r2) {
        super(r1, r2);
    }

    public static RequestProtocolError valueOf(String r1) {
        return (RequestProtocolError) Enum.valueOf(RequestProtocolError.class, r1);
    }

    public static RequestProtocolError[] values() {
        return (RequestProtocolError[]) $VALUES.clone();
    }

    static {
        RequestProtocolError r0 = new RequestProtocolError(NetworkStackConstant.UNKNOWN_TYPE, 0);
        UNKNOWN = r0;
        RequestProtocolError r1 = new RequestProtocolError("BODY_BUT_NO_LENGTH_ERROR", 1);
        BODY_BUT_NO_LENGTH_ERROR = r1;
        RequestProtocolError r3 = new RequestProtocolError("WEAK_ETAG_ON_PUTDELETE_METHOD_ERROR", 2);
        WEAK_ETAG_ON_PUTDELETE_METHOD_ERROR = r3;
        RequestProtocolError r5 = new RequestProtocolError("WEAK_ETAG_AND_RANGE_ERROR", 3);
        WEAK_ETAG_AND_RANGE_ERROR = r5;
        RequestProtocolError r7 = new RequestProtocolError("NO_CACHE_DIRECTIVE_WITH_FIELD_NAME", 4);
        NO_CACHE_DIRECTIVE_WITH_FIELD_NAME = r7;
        $VALUES = new RequestProtocolError[]{r0, r1, r3, r5, r7};
    }
}
