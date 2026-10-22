package wn;

import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.resourceprovider.media.OptionalBool;
import com.lynx.tasm.u0;
import ko.r;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends com.bytedance.ies.bullet.base.utils.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LynxContext f22884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.ies.bullet.base.utils.b f22885c;
    public final boolean d;
    public final ko.e e;

    public d(LynxContext r5) {
        this.f22884b = r5;
        u0 r10 = r5.K;
        boolean r11 = false;
        if (r10 == null) goto L5;
        boolean r12 = r10.e;
    L6:
        if (r12 == true) goto L8;
    L10:
        this.d = r11;
        this.f22885c = r5.E;
        this.e = (ko.e) r.g().e(ko.e.class);
        return;
    L8:
        if (r5.d == null) goto L10;
        r11 = true;
        goto L10
    L5:
        r12 = false;
        goto L6
    }

    @Override // com.bytedance.ies.bullet.base.utils.b
    public final OptionalBool b(String r5) {
        com.bytedance.ies.bullet.base.utils.b r10 = this.f22885c;
        if (r10 != null) goto L5;
        ko.e r11 = this.e;
        if (r11 == null) goto L22;
        int r12 = r11.isLocalResource(r5);
        if (r12 != (-1)) goto L13;
        return OptionalBool.f10952c;
    L13:
        if (r12 == 1) goto L15;
        if (r12 != 0) goto L20;
        return OptionalBool.f10951b;
    L20:
        return OptionalBool.f10952c;
    L15:
        return OptionalBool.f10950a;
    L22:
        return OptionalBool.f10952c;
    L5:
        return r10.b(r5);
    }

    @Override // com.bytedance.ies.bullet.base.utils.b
    public final String d(r r5) {
        com.bytedance.ies.bullet.base.utils.b r10 = this.f22885c;
        if (r10 != null) goto L5;
        boolean r11 = this.d;
        LynxContext r12 = this.f22884b;
        if (r11 == false) goto L11;
        return dn.a.J(r12, true, (String) r5.f18728b);
    L11:
        return dn.a.J(r12, false, (String) r5.f18728b);
    L5:
        return r10.d(r5);
    }

    @Override // com.bytedance.ies.bullet.base.utils.b
    public final void i(r r5, go.a r10) {
    }
}
