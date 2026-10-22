package com.ss.android.http.legacy;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public interface Header {
    HeaderElement[] getElements() throws ParseException;

    String getName();

    String getValue();
}
