package com.bytedance.sync.v2.h;

import android.content.Context;
import android.net.Uri;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.sync.v2.f.l;
import d.b.u.w.j;

/* JADX INFO: loaded from: classes.dex */
public class c implements com.bytedance.sync.v2.f.g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final d.b.u.e f5951f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.bytedance.sync.v2.f.i f5952g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.bytedance.sync.v2.f.g f5953h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Context f5954i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f5955j;

    public c(Context r1, d.b.u.e r2, com.bytedance.sync.v2.f.i r3, com.bytedance.sync.v2.f.g r4) {
        this.f5954i = r1;
        this.f5951f = r2;
        this.f5952g = r3;
        this.f5953h = r4;
        this.f5955j = -1;
    }

    private Uri.Builder F(com.bytedance.sync.v2.j.e r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        d.b.u.c0.a.d r3 = ((d.b.u.w.b) com.ss.android.ug.bus.b.a(d.b.u.w.b.class)).e();
        return Uri.parse(this.f5951f.f15029g).buildUpon().appendPath("v2/bytesync/api/pipeline").appendQueryParameter(WsConstants.KEY_DEVICE_ID, r3.f15019a).appendQueryParameter(WsConstants.KEY_PLATFORM, BDLocationException.ERROR_TIMEOUT);
    }

    private void M(f r4, int r5, int r6) {
        if (r4 == null) goto L6;
        r4.f5965a = 2;
        r4.f5966b = r5;
        r4.f5967c = r6;
        r4.f5968d = this.f5951f.f15025c.j() ? 1 : 0;
        r4.a();
    L6:
        if (com.bytedance.sync.v2.l.a.f6160a.b(r6) == false) goto L9;
        ((l) com.ss.android.ug.bus.b.a(l.class)).k0(2, r5, System.currentTimeMillis());
        return;
    }

    @Override // com.bytedance.sync.v2.f.g
    public void W(com.bytedance.sync.v2.g.a r10) {
        d.b.u.x.b.a("[SendMsg] send msg with https : " + d.r0(r10.f5945a) + ", can fallback: " + r10.f5946b);
        Uri.Builder r0 = F(r10.f5945a);
        if (r0 != null) goto L7;
        String r9 = "[SendMsg] mismatch url with payload:" + d.r0(r10.f5945a);
    L5:
        d.b.u.x.b.b(r9);
        return;
    L7:
        r0.appendQueryParameter(WsConstants.KEY_APP_ID, this.f5951f.f15023a);
        com.bytedance.sync.v2.l.a r1 = com.bytedance.sync.v2.l.a.f6160a;
        int r2 = r1.c(r10.f5945a).intValue();
        long r3 = System.currentTimeMillis();
        int r4 = d.b.u.b0.b.g(this.f5954i).f().j();
        if (r1.a(r2) == false) goto L13;
        if ((r3 - this.f5955j) >= r4) goto L13;
        r9 = "[SendMsg] send poll the distance from last send is less than pollInterval";
    L13:
        if (r1.a(r2) == false) goto L15;
        this.f5955j = r3;
    L15:
        com.bytedance.sync.v2.j.e r5 = ((j) com.ss.android.ug.bus.b.a(j.class)).b0(this.f5954i, r10.f5945a);
        if (r5 == null) goto L19;
        M(r10.f5948d, 1, r2);
        d.b.u.x.b.a("[SendMsg] send payload success with https " + d.r0(r10.f5945a));
        this.f5952g.a(1, r5);
        return;
    L19:
        if (r10.f5946b == false) goto L23;
        d.b.u.x.b.a("[SendMsg] send payload failed with https " + d.r0(r10.f5945a) + ",do fallback");
        r10.f5946b = false;
        com.bytedance.sync.v2.f.g r6 = this.f5953h;
        if (r6 == null) goto L24;
        r6.W(r10);
        return;
    L24:
        M(r10.f5948d, 2, r2);
        return;
    L23:
        d.b.u.x.b.b("[SendMsg] send payload failed with https " + d.r0(r10.f5945a) + ", throw it");
        goto L24
    }

    @Override // com.bytedance.sync.v2.f.g
    public boolean c() {
        return false;
    }
}
