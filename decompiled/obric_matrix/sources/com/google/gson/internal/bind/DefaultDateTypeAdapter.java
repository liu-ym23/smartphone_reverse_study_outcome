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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class DefaultDateTypeAdapter<T extends Date> extends TypeAdapter<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b<T> f6932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<DateFormat> f6933b;

    static /* synthetic */ class a {
    }

    public static abstract class b<T extends Date> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b<Date> f6934b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class<T> f6935a;

        class a extends b<Date> {
            a(Class r1) {
                super(r1);
            }

            @Override // com.google.gson.internal.bind.DefaultDateTypeAdapter.b
            protected Date d(Date r1) {
                return r1;
            }
        }

        static {
            f6934b = new a(Date.class);
        }

        protected b(Class<T> r1) {
            this.f6935a = r1;
        }

        private x c(DefaultDateTypeAdapter<T> r1) {
            return TypeAdapters.a(this.f6935a, r1);
        }

        public final x a(int r3, int r4) {
            return c(new DefaultDateTypeAdapter(this, r3, r4, null));
        }

        public final x b(String r3) {
            return c(new DefaultDateTypeAdapter(this, r3, null));
        }

        protected abstract T d(Date r1);
    }

    private DefaultDateTypeAdapter(b<T> r2, int r3, int r4) {
        ArrayList r0 = new ArrayList();
        this.f6933b = r0;
        Objects.requireNonNull(r2);
        this.f6932a = r2;
        Locale r1 = Locale.US;
        r0.add(DateFormat.getDateTimeInstance(r3, r4, r1));
        if (Locale.getDefault().equals(r1) == true) goto L6;
        r0.add(DateFormat.getDateTimeInstance(r3, r4));
    L6:
        if (d.d() == false) goto L9;
        r0.add(i.c(r3, r4));
        return;
    }

    /* synthetic */ DefaultDateTypeAdapter(b r1, int r2, int r3, a r4) {
        this(r1, r2, r3);
    }

    private DefaultDateTypeAdapter(b<T> r2, String r3) {
        ArrayList r0 = new ArrayList();
        this.f6933b = r0;
        Objects.requireNonNull(r2);
        this.f6932a = r2;
        Locale r4 = Locale.US;
        r0.add(new SimpleDateFormat(r3, r4));
        if (Locale.getDefault().equals(r4) == true) goto L6;
        r0.add(new SimpleDateFormat(r3));
        return;
    }

    /* synthetic */ DefaultDateTypeAdapter(b r1, String r2, a r3) {
        this(r1, r2);
    }

    private Date e(com.google.gson.a0.a r5) {
        String r0 = r5.i0();
        List<DateFormat> r1 = this.f6933b;
        monitor-enter(r1);
        Iterator<DateFormat> r4 = this.f6933b.iterator();     // Catch: Throwable -> L17
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
    public /* bridge */ /* synthetic */ Object b(com.google.gson.a0.a r1) {
        return f(r1);
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ void d(c r1, Object r2) {
        g(r1, (Date) r2);
    }

    public T f(com.google.gson.a0.a r3) {
        if (r3.k0() != com.google.gson.a0.b.n) goto L6;
        r3.g0();
        return null;
    L6:
        Date r4 = e(r3);
        return (T) this.f6932a.d(r4);
    }

    public void g(c r3, Date r4) {
        if (r4 != null) goto L5;
        r3.O();
        return;
    L5:
        DateFormat r0 = this.f6933b.get(0);
        List<DateFormat> r2 = this.f6933b;
        monitor-enter(r2);
        String r5 = r0.format(r4);     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        r3.n0(r5);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public String toString() {
        DateFormat r3 = this.f6933b.get(0);
        if ((r3 instanceof SimpleDateFormat) == false) goto L7;
        StringBuilder r0 = new StringBuilder();
        r0.append("DefaultDateTypeAdapter(");
        String r4 = ((SimpleDateFormat) r3).toPattern();
    L5:
        r0.append(r4);
        r0.append(')');
        return r0.toString();
    L7:
        r0 = new StringBuilder();
        r0.append("DefaultDateTypeAdapter(");
        r4 = r3.getClass().getSimpleName();
        goto L5
    }
}
