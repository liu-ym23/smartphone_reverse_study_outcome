package d.g.a.a;

/* JADX INFO: loaded from: classes2.dex */
class e implements com.obric.android.alog.a {
    e() {
    }

    @Override // com.obric.android.alog.a
    public void loadLibrary(String r1) {
        d.b.j.a.b("oalog", a.f16655b.e());     // Catch: Throwable -> L5
        return;
    L5:
        System.loadLibrary("oalog");
    }
}
