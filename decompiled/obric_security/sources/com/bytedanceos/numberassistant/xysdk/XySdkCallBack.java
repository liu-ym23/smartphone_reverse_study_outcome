package com.bytedanceos.numberassistant.xysdk;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes2.dex */
public interface XySdkCallBack {
    void execute(XySdkParserItem item);

    void executeNumberLogo(Bitmap logo);

    void executeNumberLogoByte(byte[] logo);

    void executeNumberPublicInfo(String publicInfo);
}
