package com.ss.android.common.util;

import com.ss.android.http.legacy.message.BasicNameValuePair;
import com.ss.android.http.legacy.utils.URLEncodedUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class UrlBuilder {
    private final List<BasicNameValuePair> mList;
    private String mUrl;

    public UrlBuilder(String r2) {
        this.mList = new ArrayList();
        this.mUrl = r2;
    }

    public UrlBuilder() {
        this.mList = new ArrayList();
        this.mUrl = null;
    }

    public void setUrl(String r1) {
        this.mUrl = r1;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void addParam(String r2, int r3) {
        this.mList.add(new BasicNameValuePair(r2, String.valueOf(r3)));
    }

    public void addParam(String r2, long r3) {
        this.mList.add(new BasicNameValuePair(r2, String.valueOf(r3)));
    }

    public void addParam(String r2, double r3) {
        this.mList.add(new BasicNameValuePair(r2, String.valueOf(r3)));
    }

    public void addParam(String r2, String r3) {
        this.mList.add(new BasicNameValuePair(r2, r3));
    }

    public List<BasicNameValuePair> getParamList() {
        return this.mList;
    }

    public String build() {
        if (this.mList.isEmpty() == true) goto L5;
        String r0 = URLEncodedUtils.format(this.mList, "UTF-8");
        String r1 = this.mUrl;
        if (r1 != null) goto L9;
    L17:
        return r0;
    L9:
        if (r1.length() == 0) goto L17;
        if (this.mUrl.indexOf(63) < 0) goto L16;
        return this.mUrl + "&" + r0;
    L16:
        return this.mUrl + "?" + r0;
    L5:
        return this.mUrl;
    }

    public String toString() {
        return build();
    }
}
