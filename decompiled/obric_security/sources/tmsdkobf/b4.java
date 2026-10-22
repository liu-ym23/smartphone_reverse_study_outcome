package tmsdkobf;

import android.os.HandlerThread;

/* JADX INFO: loaded from: classes5.dex */
public class b4 implements t6 {

    class a implements b7 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b4 f110a;

        a(b4 r1) {
            this.f110a = r1;
        }

        @Override // tmsdkobf.b7
        public void a(Runnable r1, String r2) {
            ve.f().b(r1, r2);
        }

        @Override // tmsdkobf.b7
        public void b(Runnable r1, String r2) {
            ve.f().a(r1, r2);
        }

        @Override // tmsdkobf.b7
        public HandlerThread a(String r1, int r2) {
            return ve.f().a(r1, r2);
        }
    }

    public b4() {
    }

    @Override // tmsdkobf.t6
    public y6 a() {
        return new be();
    }

    @Override // tmsdkobf.t6
    public b7 b() {
        return new a(this);
    }
}
