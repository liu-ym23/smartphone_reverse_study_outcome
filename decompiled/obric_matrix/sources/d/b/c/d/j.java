package d.b.c.d;

import android.content.Context;
import androidx.annotation.Nullable;
import com.bytedance.bdlocation.api.ILocate;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.service.BDLocationExtrasService;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static j f13155b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ILocate f13156a;

    public j() {
        this.f13156a = BDLocationExtrasService.getLocate(BDLocationConfig.getContext(), 3);
    }

    public static j a() {
        if (f13155b != null) goto L15;
        monitor-enter(h.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f13155b != null) goto L9;
        f13155b = new j();     // Catch: Throwable -> L11
    L9:
        monitor-exit(h.class);     // Catch: Throwable -> L11
    L15:
        return f13155b;
    }

    @Nullable
    private ILocate c(int r2) {
        if (r2 == 3) goto L5;
        return null;
    L5:
        return this.f13156a;
    }

    @Nullable
    public ILocate b(int r2) {
        if (BDLocationConfig.isMockEnable() == false) goto L8;
        Context r1 = BDLocationConfig.getContext();
        int r3 = 4;
    L6:
        return BDLocationExtrasService.getLocate(r1, r3);
    L8:
        if (BDLocationConfig.isOverSeas() == false) goto L10;
        r1 = BDLocationConfig.getContext();
        r3 = 0;
        goto L6
    L10:
        ILocate r4 = c(r2);
        if (r4 == null) goto L13;
        return r4;
    L13:
        return BDLocationExtrasService.getLocate(BDLocationConfig.getContext(), r2);
    }
}
