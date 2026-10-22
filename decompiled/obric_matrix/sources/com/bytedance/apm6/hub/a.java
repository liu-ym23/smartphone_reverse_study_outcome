package com.bytedance.apm6.hub;

import com.bytedance.apm6.hub.b.e;
import com.bytedance.apm6.hub.b.f;
import com.bytedance.apm6.hub.b.h;
import com.bytedance.services.apm.api.IEncrypt;
import com.bytedance.services.apm.api.IHttpService;
import d.b.b.e.a.g;
import d.b.b.i.c.b;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements b {
    public a() {
    }

    @Override // d.b.b.i.c.b
    public JSONObject e() {
        return null;
    }

    protected d.b.b.d.b.b h() {
        return new com.bytedance.apm6.hub.b.a();
    }

    protected com.bytedance.apm6.hub.b.b i() {
        return new com.bytedance.apm6.hub.b.b();
    }

    protected abstract d.b.b.n.d.a j();

    protected abstract d.b.b.n.e.a k();

    protected abstract IEncrypt l();

    protected e m() {
        return new e();
    }

    protected abstract IHttpService n();

    protected f o() {
        return new f();
    }

    protected abstract d.b.b.k.a p();

    protected abstract d.b.b.k.f.b q();

    protected d.b.b.e.a.h.b r() {
        return new h(d());
    }

    protected abstract g s();

    protected long t() {
        return 0;
    }
}
