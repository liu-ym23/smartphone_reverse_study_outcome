package com.ss.android.http.legacy;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public interface HeaderElement {
    String getName();

    NameValuePair getParameter(int r1);

    NameValuePair getParameterByName(String r1);

    int getParameterCount();

    NameValuePair[] getParameters();

    String getValue();
}
