package com.bytedance.sync.v2.presistence.b;

import androidx.room.TypeConverter;
import com.bytedance.sync.v2.j.h;

/* JADX INFO: loaded from: classes.dex */
public class b {
    @TypeConverter
    public static int a(h r0) {
        return r0.getValue();
    }

    @TypeConverter
    public static h b(int r0) {
        h r1 = h.a(r0);
        if (r1 == null) goto L5;
        return r1;
    L5:
        return h.f6097h;
    }
}
