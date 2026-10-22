package com.google.gson.internal.sql;

import com.google.gson.TypeAdapter;
import com.google.gson.a0.c;
import com.google.gson.x;
import java.sql.Timestamp;
import java.util.Date;

/* JADX INFO: loaded from: classes2.dex */
class SqlTimestampTypeAdapter extends TypeAdapter<Timestamp> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final x f7085b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TypeAdapter<Date> f7086a;

    static {
        f7085b = new AnonymousClass1();
    }

    private SqlTimestampTypeAdapter(TypeAdapter<Date> r1) {
        this.f7086a = r1;
    }

    /* synthetic */ SqlTimestampTypeAdapter(TypeAdapter r1, AnonymousClass1 r2) {
        this(r1);
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ Timestamp b(com.google.gson.a0.a r1) {
        return e(r1);
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ void d(c r1, Timestamp r2) {
        f(r1, r2);
    }

    public Timestamp e(com.google.gson.a0.a r3) {
        Date r2 = this.f7086a.b(r3);
        if (r2 != null) goto L7;
        return null;
    L7:
        return new Timestamp(r2.getTime());
    }

    public void f(c r1, Timestamp r2) {
        this.f7086a.d(r1, r2);
    }
}
