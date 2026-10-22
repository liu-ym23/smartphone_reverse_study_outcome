package cz.msebera.android.httpclient.client.protocol;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpResponseInterceptor;
import cz.msebera.android.httpclient.client.entity.DecompressingEntity;
import cz.msebera.android.httpclient.client.entity.DeflateInputStreamFactory;
import cz.msebera.android.httpclient.client.entity.GZIPInputStreamFactory;
import cz.msebera.android.httpclient.client.entity.InputStreamFactory;
import cz.msebera.android.httpclient.config.Lookup;
import cz.msebera.android.httpclient.config.RegistryBuilder;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.io.IOException;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class ResponseContentEncoding implements HttpResponseInterceptor {
    public static final String UNCOMPRESSED = "http.client.response.uncompressed";
    private final Lookup<InputStreamFactory> decoderRegistry;
    private final boolean ignoreUnknown;

    public ResponseContentEncoding(Lookup<InputStreamFactory> r3, boolean r4) {
        if (r3 != null) goto L6;
        r3 = RegistryBuilder.create().register("gzip", GZIPInputStreamFactory.getInstance()).register("x-gzip", GZIPInputStreamFactory.getInstance()).register("deflate", DeflateInputStreamFactory.getInstance()).build();
    L6:
        this.decoderRegistry = r3;
        this.ignoreUnknown = r4;
    }

    public ResponseContentEncoding(boolean r2) {
        this(null, r2);
    }

    public ResponseContentEncoding(Lookup<InputStreamFactory> r2) {
        this(r2, true);
    }

    public ResponseContentEncoding() {
        this(null);
    }

    @Override // cz.msebera.android.httpclient.HttpResponseInterceptor
    public void process(HttpResponse r6, HttpContext r7) throws HttpException, IOException {
        HttpEntity r0 = r6.getEntity();
        if (HttpClientContext.adapt(r7).getRequestConfig().isContentCompressionEnabled() == false) goto L22;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.getContentLength() == 0) goto L29;
        Header r8 = r0.getContentEncoding();
        if (r8 == null) goto L30;
        HeaderElement[] r9 = r8.getElements();
        int r1 = r9.length;
        int r2 = 0;
    L10:
        if (r2 >= r1) goto L31;
        HeaderElement r3 = r9[r2];
        String r4 = r3.getName().toLowerCase(Locale.ROOT);
        InputStreamFactory r5 = this.decoderRegistry.lookup(r4);
        if (r5 == null) goto L15;
        r6.setEntity(new DecompressingEntity(r6.getEntity(), r5));
        r6.removeHeaders("Content-Length");
        r6.removeHeaders("Content-Encoding");
        r6.removeHeaders("Content-MD5");
    L21:
        r2 = r2 + 1;
        goto L10
    L15:
        if ("identity".equals(r4) == true) goto L21;
        if (this.ignoreUnknown == true) goto L21;
        throw new HttpException("Unsupported Content-Encoding: " + r3.getName());
    L31:
        return;
    L30:
        return;
    L29:
        return;
    }
}
