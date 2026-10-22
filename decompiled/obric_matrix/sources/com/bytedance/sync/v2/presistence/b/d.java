package com.bytedance.sync.v2.presistence.b;

import androidx.room.TypeConverter;
import com.bytedance.sync.v2.j.n;

/* JADX INFO: loaded from: classes.dex */
public class d {
    @TypeConverter
    public static int a(n r0) {
        if (r0 != null) goto L6;
        return n.f6123g.getValue();
    L6:
        return r0.getValue();
    }

    @TypeConverter
    public static n b(int r0) {
        n r1 = n.a(r0);
        if (r1 == null) goto L5;
        return r1;
    L5:
        return n.f6123g;
    }
}
