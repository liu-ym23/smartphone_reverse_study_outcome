package com.bytedance.push.settings.storage;

import android.net.Uri;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f5496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f5497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f5498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    String f5499d;

    b(String r1, String r2, String r3, String r4) {
        this.f5496a = r1;
        this.f5497b = r2;
        this.f5498c = r3;
        this.f5499d = r4;
    }

    public static b a(Uri r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        List<String> r5 = r4.getPathSegments();
        if (r5 != null) goto L8;
    L12:
        return null;
    L8:
        if (r5.size() < 4) goto L12;
        return new b(r5.get(0), r5.get(1), r5.get(2), r5.get(3));
    }

    Uri b(Uri r2) {
        return r2.buildUpon().appendPath(this.f5496a).appendPath(this.f5497b).appendPath(this.f5498c).appendPath(this.f5499d).build();
    }
}
