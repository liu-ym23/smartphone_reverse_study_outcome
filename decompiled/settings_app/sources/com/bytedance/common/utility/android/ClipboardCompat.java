package com.bytedance.common.utility.android;

import android.content.ClipData;
import android.content.Context;
import android.text.ClipboardManager;

/* JADX INFO: loaded from: classes3.dex */
public class ClipboardCompat {
    private static final ClipboardImpl IMPL = null;

    static class BaseClipboardImpl implements ClipboardImpl {
        BaseClipboardImpl() {
        }

        @Override // com.bytedance.common.utility.android.ClipboardCompat.ClipboardImpl
        public void setText(Context r1, CharSequence r2, CharSequence r3) {
            ((ClipboardManager) r1.getSystemService("clipboard")).setText(r3);
        }
    }

    interface ClipboardImpl {
        void setText(Context r1, CharSequence r2, CharSequence r3);
    }

    static class HoneycombClipboardImpl implements ClipboardImpl {
        HoneycombClipboardImpl() {
        }

        @Override // com.bytedance.common.utility.android.ClipboardCompat.ClipboardImpl
        public void setText(Context r1, CharSequence r2, CharSequence r3) {
            ((android.content.ClipboardManager) r1.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(r2, r3));
        }
    }

    public ClipboardCompat() {
    }

    static {
        IMPL = new HoneycombClipboardImpl();
    }

    public static void setText(Context r1, CharSequence r2, CharSequence r3) {
        if (r1 == null) goto L11;
        if (r2 == null) goto L12;
        if (r3 == null) goto L13;
        IMPL.setText(r1, r2, r3);     // Catch: Throwable -> L8
        return;
    L14:
        return;
    L13:
        return;
    L12:
        return;
    }
}
