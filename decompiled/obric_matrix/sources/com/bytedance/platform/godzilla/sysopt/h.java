package com.bytedance.platform.godzilla.sysopt;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class h extends d.b.p.a.g.b {
    public h() {
    }

    @Override // d.b.p.a.g.a
    public String b() {
        return "SysOptPlugin";
    }

    @Override // d.b.p.a.g.b
    protected List<d.b.p.a.g.a> g() {
        ArrayList r2 = new ArrayList();
        r2.add(new c());
        r2.add(new a());
        r2.add(new g());
        r2.add(new e());
        r2.add(new f(false));
        r2.add(new d());
        r2.add(new b());
        return r2;
    }
}
