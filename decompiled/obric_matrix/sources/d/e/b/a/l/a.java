package d.e.b.a.l;

import d.e.b.a.l.b.b;
import d.e.b.a.l.c.c;
import d.e.b.a.l.c.h;
import d.e.b.a.l.c.i;
import d.e.b.a.l.c.k;
import d.e.b.a.l.c.m;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final a f16632f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f16633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.e.b.a.b f16634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final k f16635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final k f16636d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final k f16637e;

    static {
        f16632f = new a();
    }

    private a() {
        b r0 = b.c();
        this.f16633a = r0;
        d.e.b.a.l.b.a r1 = new d.e.b.a.l.b.a();
        this.f16634b = r1;
        i r2 = new i("/com/google/i18n/phonenumbers/data/PhoneNumberMetadataProto");
        this.f16635c = r2;
        new h(r2, r1, r0);
        i r3 = new i("/com/google/i18n/phonenumbers/data/ShortNumberMetadataProto");
        this.f16636d = r3;
        new m(r3, r1, r0);
        i r4 = new i("/com/google/i18n/phonenumbers/data/PhoneNumberAlternateFormatsProto");
        this.f16637e = r4;
        new c(r4, r1, r0);
    }

    public static a a() {
        return f16632f;
    }

    public d.e.b.a.b b() {
        return this.f16634b;
    }

    public b c() {
        return this.f16633a;
    }

    public k d() {
        return this.f16635c;
    }
}
