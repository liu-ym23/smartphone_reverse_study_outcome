package tmsdkobf;

import android.os.LocaleList;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public final class n5 implements k5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LocaleList f363a;

    public n5(Object r1) {
        this.f363a = (LocaleList) r1;
    }

    @Override // tmsdkobf.k5
    public Locale a(int r1) {
        return this.f363a.get(r1);
    }

    public int hashCode() {
        return this.f363a.hashCode();
    }

    @Override // tmsdkobf.k5
    public int a() {
        return this.f363a.size();
    }
}
