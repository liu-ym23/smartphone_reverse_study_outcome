package com.google.gson.internal.sql;

import com.google.gson.TypeAdapter;
import com.google.gson.a0.b;
import com.google.gson.a0.c;
import com.google.gson.s;
import com.google.gson.x;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: classes2.dex */
final class SqlDateTypeAdapter extends TypeAdapter<Date> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final x f7081b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DateFormat f7082a;

    static {
        f7081b = new AnonymousClass1();
    }

    private SqlDateTypeAdapter() {
        this.f7082a = new SimpleDateFormat("MMM d, yyyy");
    }

    /* synthetic */ SqlDateTypeAdapter(AnonymousClass1 r1) {
        this();
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ Date b(com.google.gson.a0.a r1) {
        return e(r1);
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ void d(c r1, Date r2) {
        f(r1, r2);
    }

    public Date e(com.google.gson.a0.a r5) {
        if (r5.k0() != b.n) goto L6;
        r5.g0();
        return null;
    L6:
        String r0 = r5.i0();
        monitor-enter(this);     // Catch: ParseException -> L15
        java.util.Date r1 = this.f7082a.parse(r0);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
    L11:
        return new Date(r1.getTime());
    L12:
        th = move-exception;
        throw th;     // Catch: ParseException -> L15
    L15:
        e = move-exception;
        throw new s("Failed parsing '" + r0 + "' as SQL Date; at path " + r5.F(), e);
    }

    public void f(c r2, Date r3) {
        if (r3 != null) goto L5;
        r2.O();
        return;
    L5:
        monitor-enter(this);
        String r4 = this.f7082a.format(r3);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        r2.n0(r4);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
