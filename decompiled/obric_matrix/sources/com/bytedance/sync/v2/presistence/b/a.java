package com.bytedance.sync.v2.presistence.b;

import androidx.room.TypeConverter;

/* JADX INFO: loaded from: classes.dex */
public class a {
    @TypeConverter
    public static int a(com.bytedance.sync.v2.j.g r0) {
        if (r0 != null) goto L6;
        return com.bytedance.sync.v2.j.g.f6091g.getValue();
    L6:
        return r0.getValue();
    }

    @TypeConverter
    public static com.bytedance.sync.v2.j.g b(int r0) {
        com.bytedance.sync.v2.j.g r1 = com.bytedance.sync.v2.j.g.a(r0);
        if (r1 == null) goto L5;
        return r1;
    L5:
        return com.bytedance.sync.v2.j.g.f6091g;
    }
}
