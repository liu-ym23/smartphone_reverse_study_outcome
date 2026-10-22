package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("base::android")
public class ImportantFileWriterAndroid {

    interface Natives {
        boolean writeFileAtomically(String r1, byte[] r2);
    }

    public ImportantFileWriterAndroid() {
    }

    public static boolean writeFileAtomically(String r1, byte[] r2) {
        return ImportantFileWriterAndroidJni.get().writeFileAtomically(r1, r2);
    }
}
