package com.bytedance.retrofit2.client;

import a.a;
import com.bytedance.retrofit2.mime.TypedInput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class Response {
    private final TypedInput body;
    private Object extraInfo;
    private final List<Header> headers;
    private String message;
    private final String reason;
    private final int status;
    private String traceCode;
    private final String url;

    public Response(String r2, int r3, String r4, List<Header> r5, TypedInput r6) {
        if (r2 == null) goto L17;
        if (r3 < 200) goto L15;
        if (r4 == null) goto L13;
        if (r5 == null) goto L11;
        this.url = r2;
        this.status = r3;
        this.reason = r4;
        this.headers = Collections.unmodifiableList(new ArrayList(r5));
        this.body = r6;
        return;
    L11:
        throw new IllegalArgumentException("headers == null");
    L13:
        throw new IllegalArgumentException("reason == null");
    L15:
        throw new IllegalArgumentException(a.e(r3, "Invalid status code: "));
    L17:
        throw new IllegalArgumentException("url == null");
    }

    public TypedInput getBody() {
        return this.body;
    }

    public Object getExtraInfo() {
        return this.extraInfo;
    }

    public Header getFirstHeader(String r4) {
        if (r4 == null) goto L13;
        List<Header> r3 = this.headers;
        if (r3 == null) goto L13;
        Iterator<Header> r5 = r3.iterator();
    L9:
        if (r5.hasNext() == false) goto L13;
        Header r1 = r5.next();
        if (r4.equalsIgnoreCase(r1.getName()) == false) goto L9;
        return r1;
    L13:
        return null;
    }

    public List<Header> getHeaders() {
        return this.headers;
    }

    public String getReason() {
        return this.reason;
    }

    public int getStatus() {
        return this.status;
    }

    public String getTraceCode() {
        return this.traceCode;
    }

    public String getUrl() {
        return this.url;
    }

    public List<Header> headers(String r4) {
        ArrayList r0 = null;
        if (r4 == null) goto L15;
        List<Header> r3 = this.headers;
        if (r3 == null) goto L15;
        Iterator<Header> r5 = r3.iterator();
    L9:
        if (r5.hasNext() == false) goto L15;
        Header r1 = r5.next();
        if (r4.equalsIgnoreCase(r1.getName()) == false) goto L9;
        if (r0 != null) goto L14;
        r0 = new ArrayList();
    L14:
        r0.add(r1);
    L15:
        return r0;
    }

    public boolean isSuccessful() {
        int r1 = this.status;
        if (r1 >= 200) goto L5;
    L7:
        return false;
    L5:
        if (r1 >= 300) goto L7;
        return true;
    }

    public String message() {
        return this.message;
    }

    public void setExtraInfo(Object r1) {
        this.extraInfo = r1;
    }

    public void setMessage(String r1) {
        this.message = r1;
    }

    public void setTraceCode(String r1) {
        this.traceCode = r1;
    }
}
