package cz.msebera.android.httpclient;

/* JADX INFO: loaded from: classes5.dex */
public class TruncatedChunkException extends MalformedChunkCodingException {
    private static final long serialVersionUID = -23506263930279460L;

    public TruncatedChunkException(String r1) {
        super(r1);
    }

    public TruncatedChunkException(String r1, Object... r2) {
        super(HttpException.clean(String.format(r1, r2)));
    }
}
