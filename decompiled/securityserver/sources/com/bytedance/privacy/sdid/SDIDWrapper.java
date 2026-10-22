package com.bytedance.privacy.sdid;

import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public class SDIDWrapper {
    static {
        Uri.parse("content://com.bytedance.securityserver.oaidprovider");
        Uri.parse("content://com.bytedance.securityserver.udidprovider");
    }
}
