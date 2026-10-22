package tmsdk.common.module.update;

import android.content.Context;
import java.util.List;
import tmsdk.common.creator.BaseManagerC;
import tmsdkobf.d;
import tmsdkobf.f;

/* JADX INFO: loaded from: classes5.dex */
public final class UpdateManager extends BaseManagerC {
    private a b;

    public UpdateManager() {
    }

    public void addObserver(long r1, IUpdateObserver r3) {
        this.b.addObserver(r1, r3);
    }

    public void cancel() {
        this.b.cancel();
    }

    public void check(long r1, ICheckListener r3, long r4) {
        f.b(29968, "" + r1);
        this.b.a(r1, r3);
        d.a();
    }

    public String getFileSavePath() {
        return this.b.getFileSavePath();
    }

    @Override // tmsdkobf.b0
    public void onCreate(Context r2) {
        a r0 = new a();
        this.b = r0;
        r0.onCreate(r2);
        a(this.b);
    }

    public void removeObserver(long r1) {
        this.b.removeObserver(r1);
    }

    public boolean update(List<UpdateInfo> r1, IUpdateListener r2) {
        return this.b.update(r1, r2);
    }
}
