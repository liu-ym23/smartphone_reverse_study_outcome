package com.google.gson.internal.sql;

import com.google.gson.TypeAdapter;
import com.google.gson.a0.b;
import com.google.gson.a0.c;
import com.google.gson.s;
import com.google.gson.x;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: classes2.dex */
final class SqlTimeTypeAdapter extends TypeAdapter<Time> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final x f7083b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DateFormat f7084a;

    static {
        f7083b = new AnonymousClass1();
    }

    private SqlTimeTypeAdapter() {
        this.f7084a = new SimpleDateFormat("hh:mm:ss a");
    }

    /* synthetic */ SqlTimeTypeAdapter(AnonymousClass1 r1) {
        this();
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ Time b(com.google.gson.a0.a r1) {
        return e(r1);
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ void d(c r1, Time r2) {
        f(r1, r2);
    }

    public Time e(com.google.gson.a0.a r6) {
        if (r6.k0() != b.n) goto L6;
        r6.g0();
        return null;
    L6:
        String r0 = r6.i0();
        monitor-enter(this);     // Catch: ParseException -> L14
        Time r2 = new Time(this.f7084a.parse(r0).getTime());     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        return r2;
    L11:
        th = move-exception;
        throw th;     // Catch: ParseException -> L14
    L14:
        e = move-exception;
        throw new s("Failed parsing '" + r0 + "' as SQL Time; at path " + r6.F(), e);
    }

    public void f(c r2, Time r3) {
        if (r3 != null) goto L5;
        r2.O();
        return;
    L5:
        monitor-enter(this);
        String r4 = this.f7084a.format(r3);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        r2.n0(r4);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
