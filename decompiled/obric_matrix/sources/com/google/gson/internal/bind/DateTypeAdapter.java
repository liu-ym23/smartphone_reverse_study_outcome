package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.a0.c;
import com.google.gson.internal.d;
import com.google.gson.internal.i;
import com.google.gson.s;
import com.google.gson.x;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class DateTypeAdapter extends TypeAdapter<Date> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final x f6930b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<DateFormat> f6931a;

    static {
        f6930b = new AnonymousClass1();
    }

    public DateTypeAdapter() {
        ArrayList r0 = new ArrayList();
        this.f6931a = r0;
        Locale r3 = Locale.US;
        r0.add(DateFormat.getDateTimeInstance(2, 2, r3));
        if (Locale.getDefault().equals(r3) == true) goto L6;
        r0.add(DateFormat.getDateTimeInstance(2, 2));
    L6:
        if (d.d() == false) goto L9;
        r0.add(i.c(2, 2));
        return;
    }

    private Date e(com.google.gson.a0.a r5) {
        String r0 = r5.i0();
        List<DateFormat> r1 = this.f6931a;
        monitor-enter(r1);
        Iterator<DateFormat> r4 = this.f6931a.iterator();     // Catch: Throwable -> L17
    L6:
        if (r4.hasNext() == false) goto L11;
        Date r6 = r4.next().parse(r0);     // Catch: ParseException -> L20 Throwable -> L17
        monitor-exit(r1);     // Catch: Throwable -> L17
        return r6;
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L17
        return com.google.gson.internal.bind.c.a.c(r0, new ParsePosition(0));
    L14:
        e = move-exception;
        throw new s("Failed parsing '" + r0 + "' as Date; at path " + r5.F(), e);
    L17:
        th = move-exception;
        throw th;
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ Date b(com.google.gson.a0.a r1) {
        return f(r1);
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ void d(c r1, Date r2) {
        g(r1, r2);
    }

    public Date f(com.google.gson.a0.a r3) {
        if (r3.k0() != com.google.gson.a0.b.n) goto L7;
        r3.g0();
        return null;
    L7:
        return e(r3);
    }

    public void g(c r3, Date r4) {
        if (r4 != null) goto L5;
        r3.O();
        return;
    L5:
        DateFormat r0 = this.f6931a.get(0);
        List<DateFormat> r2 = this.f6931a;
        monitor-enter(r2);
        String r5 = r0.format(r4);     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        r3.n0(r5);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
