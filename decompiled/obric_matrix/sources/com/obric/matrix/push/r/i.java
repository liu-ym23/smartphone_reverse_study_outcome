package com.obric.matrix.push.r;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.i0.r;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\t\u001a\u00020\u0004J\u001c\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\u0004¨\u0006\f"}, d2 = {"Lcom/obric/matrix/push/utils/StringUtils;", "", "()V", "listToString", "", "list", "", "stringToList", "", TypedValues.Custom.S_STRING, "stringToMap", "", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f9797a = null;

    static {
        f9797a = new i();
    }

    private i() {
    }

    public final String a(List<String> r4) {
        o.f(r4, "list");
        StringBuilder r3 = new StringBuilder();
        if ((!r4.isEmpty()) == false) goto L10;
        int r0 = r4.size();
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L10;
        r3.append(r4.get(r1));
        if (r1 >= (r0 - 1)) goto L9;
        r3.append(",");
    L9:
        r1 = r1 + 1;
    L10:
        String r5 = r3.toString();
        o.e(r5, "stringBuilder.toString()");
        return r5;
    }

    public final List<String> b(String r5) {
        o.f(r5, TypedValues.Custom.S_STRING);
        ArrayList r4 = new ArrayList();
        int r1 = 0;
        if (r5.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L24;
    L19:
        return r4;
    L24:
        Object[] r6 = new kotlin.u0.i(",").f(r5, 0).toArray(new String[0]);     // Catch: Throwable -> L21
        o.d(r6, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");     // Catch: Throwable -> L21
        String[] r7 = (String[]) r6;     // Catch: Throwable -> L21
        Iterator r2 = new ArrayList(r.j(Arrays.copyOf(r7, r7.length))).iterator();     // Catch: Throwable -> L21
    L9:
        if (r2.hasNext() == false) goto L13;
        if (TextUtils.isEmpty((String) r2.next()) == false) goto L9;
        r2.remove();     // Catch: Throwable -> L21
        goto L9
    L13:
        int r3 = r7.length;     // Catch: Throwable -> L21
    L14:
        if (r1 >= r3) goto L19;
        String r8 = r7[r1];     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(r8) == true) goto L18;
        r4.add(r8);     // Catch: Throwable -> L20
    L18:
        r1 = r1 + 1;
        goto L14
    L5:
        r0 = false;
        goto L6
    }
}
