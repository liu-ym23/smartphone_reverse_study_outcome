package com.bytedance.sync.v2.presistence.b;

import androidx.room.TypeConverter;
import com.bytedance.sync.v2.j.p;

/* JADX INFO: loaded from: classes.dex */
public class g {
    @TypeConverter
    public static int a(p r0) {
        if (r0 != null) goto L6;
        return p.f6134g.getValue();
    L6:
        return r0.getValue();
    }

    @TypeConverter
    public static p b(int r0) {
        p r1 = p.a(r0);
        if (r1 == null) goto L5;
        return r1;
    L5:
        return p.f6134g;
    }
}
