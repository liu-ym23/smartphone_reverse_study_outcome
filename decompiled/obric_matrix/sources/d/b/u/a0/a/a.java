package d.b.u.a0.a;

import androidx.room.TypeConverter;

/* JADX INFO: loaded from: classes.dex */
public class a {
    @TypeConverter
    public static int a(d.b.u.y.a r0) {
        if (r0 != null) goto L6;
        return d.b.u.y.a.f15124g.b();
    L6:
        return r0.b();
    }

    @TypeConverter
    public static d.b.u.y.a b(int r0) {
        d.b.u.y.a r1 = d.b.u.y.a.a(r0);
        if (r1 == null) goto L5;
        return r1;
    L5:
        return d.b.u.y.a.f15124g;
    }
}
