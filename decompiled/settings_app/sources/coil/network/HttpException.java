package coil.network;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import kotlin.Metadata;
import okhttp3.Response;

/* JADX INFO: compiled from: HttpException.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcoil/network/HttpException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", ApmTrafficStats.TTNET_RESPONSE, "Lokhttp3/Response;", "(Lokhttp3/Response;)V", "getResponse", "()Lokhttp3/Response;", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HttpException extends RuntimeException {
    private final Response response;

    public final Response getResponse() {
        return this.response;
    }

    public HttpException(Response r3) {
        super("HTTP " + r3.code() + ": " + r3.message());
        this.response = r3;
    }
}
