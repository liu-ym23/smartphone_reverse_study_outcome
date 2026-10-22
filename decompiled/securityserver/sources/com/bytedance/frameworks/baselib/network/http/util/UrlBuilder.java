package com.bytedance.frameworks.baselib.network.http.util;

import com.bytedance.common.utility.StringUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class UrlBuilder {
    private final Map<String, List<String>> mParamMap;
    private String mUrl;

    public UrlBuilder(String r2) {
        this.mParamMap = new LinkedHashMap();
        this.mUrl = r2;
    }

    public void addParam(String r2, int r3) {
        List<String> r0 = this.mParamMap.get(r2);
        if (r0 != null) goto L5;
        r0 = new LinkedList();
    L5:
        r0.add(String.valueOf(r3));
        this.mParamMap.put(r2, r0);
    }

    public String build() {
        if (this.mParamMap.isEmpty() == true) goto L5;
        String r0 = UrlUtils.format(this.mParamMap, "UTF-8");
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

    public Map<String, String> getParams() {
        LinkedHashMap r0 = new LinkedHashMap();
        Map<String, List<String>> r1 = this.mParamMap;
        if (r1 != null) goto L5;
    L19:
        return r0;
    L5:
        if (r1.size() <= 0) goto L19;
        Iterator<Map.Entry<String, List<String>>> r4 = this.mParamMap.entrySet().iterator();
    L8:
        if (r4.hasNext() == false) goto L19;
        Map.Entry<String, List<String>> r2 = r4.next();
        String r3 = r2.getKey();
        if (StringUtils.isEmpty(r3) == true) goto L8;
        List<String> r5 = r2.getValue();
        if (r5 != null) goto L15;
    L17:
        String r6 = "";
    L18:
        r0.put(r3, r6);
        goto L8
    L15:
        if (r5.size() <= 0) goto L17;
        r6 = r5.get(0);
        goto L18
    }

    public Map<String, List<String>> getParamsWithValueList() {
        return this.mParamMap;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void setUrl(String r1) {
        this.mUrl = r1;
    }

    public String toString() {
        return build();
    }

    public UrlBuilder() {
        this.mParamMap = new LinkedHashMap();
        this.mUrl = null;
    }

    public void addParam(String r2, long r3) {
        List<String> r0 = this.mParamMap.get(r2);
        if (r0 != null) goto L5;
        r0 = new LinkedList();
    L5:
        r0.add(String.valueOf(r3));
        this.mParamMap.put(r2, r0);
    }

    public void addParam(String r2, double r3) {
        List<String> r0 = this.mParamMap.get(r2);
        if (r0 != null) goto L5;
        r0 = new LinkedList();
    L5:
        r0.add(String.valueOf(r3));
        this.mParamMap.put(r2, r0);
    }

    public void addParam(String r2, String r3) {
        List<String> r0 = this.mParamMap.get(r2);
        if (r0 != null) goto L5;
        r0 = new LinkedList();
    L5:
        r0.add(String.valueOf(r3));
        this.mParamMap.put(r2, r0);
    }
}
