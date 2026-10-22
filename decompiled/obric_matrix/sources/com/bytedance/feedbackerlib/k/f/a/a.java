package com.bytedance.feedbackerlib.k.f.a;

import android.media.ExifInterface;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class a {
    static {
    }

    public static ExifInterface a(String r1) {
        Objects.requireNonNull(r1, "filename should not be null");
        return new ExifInterface(r1);
    }
}
