package d.b.u.d0;

import android.util.Pair;
import com.ss.android.ugc.quota.BDNetworkTagManager;

/* JADX INFO: loaded from: classes.dex */
public class c {

    static class a extends com.ss.android.ugc.quota.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f15022a;

        a(boolean r1) {
            this.f15022a = r1;
        }

        @Override // com.ss.android.ugc.quota.a, com.ss.android.ugc.quota.b
        public int triggerType() {
            return this.f15022a ? 1 : 0;
        }
    }

    public static Pair<String, String> a(boolean r2) {
    L8:
        th = move-exception;
        th.printStackTrace();
        return null;
    L4:
        if (Class.forName("com.ss.android.ugc.quota.BDNetworkTagManager") != null) goto L6;
        return null;
    L6:
        a r1 = new a(r2);     // Catch: Throwable -> L8
        return BDNetworkTagManager.d().a(r1);
    }
}
