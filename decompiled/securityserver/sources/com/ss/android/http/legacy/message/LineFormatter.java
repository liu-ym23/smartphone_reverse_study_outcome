package com.ss.android.http.legacy.message;

import com.bytedance.frameworks.baselib.network.http.util.CharArrayBuffer;
import com.ss.android.http.legacy.Header;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public interface LineFormatter {
    CharArrayBuffer formatHeader(CharArrayBuffer r1, Header r2);
}
