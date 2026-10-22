package cz.msebera.android.httpclient.client.entity;

import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.client.utils.URLEncodedUtils;
import cz.msebera.android.httpclient.entity.ContentType;
import cz.msebera.android.httpclient.entity.StringEntity;
import cz.msebera.android.httpclient.protocol.HTTP;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class UrlEncodedFormEntity extends StringEntity {
    public UrlEncodedFormEntity(List<? extends NameValuePair> r2, String r3) throws UnsupportedEncodingException {
        if (r3 == null) goto L4;
        String r0 = r3;
    L5:
        super(URLEncodedUtils.format(r2, r0), ContentType.create("application/x-www-form-urlencoded", r3));
        return;
    L4:
        r0 = HTTP.DEF_CONTENT_CHARSET.name();
        goto L5
    }

    public UrlEncodedFormEntity(Iterable<? extends NameValuePair> r2, Charset r3) {
        if (r3 == null) goto L4;
        Charset r0 = r3;
    L5:
        super(URLEncodedUtils.format(r2, r0), ContentType.create("application/x-www-form-urlencoded", r3));
        return;
    L4:
        r0 = HTTP.DEF_CONTENT_CHARSET;
        goto L5
    }

    public UrlEncodedFormEntity(List<? extends NameValuePair> r3) throws UnsupportedEncodingException {
        Charset r1 = (Charset) null;
        this(r3, null);
    }

    public UrlEncodedFormEntity(Iterable<? extends NameValuePair> r2) {
        this(r2, null);
    }
}
