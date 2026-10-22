package com.obric.matrix.r.d;

import android.content.Context;
import androidx.annotation.NonNull;
import com.obric.matrix.r.e.g;
import com.slardaros.client.i;

/* JADX INFO: loaded from: classes2.dex */
public class b extends d {
    public b(@NonNull String r1) {
        super(r1);
    }

    @Override // com.obric.matrix.r.d.d
    protected void k(@NonNull Context r9) {
        String r3 = d() + "\ncreatedTime=\n" + com.obric.matrix.r.e.c.a(c()) + "\ncategory=\n" + g.a(b(), "=", "\n") + "\nmetrics=\n" + g.a(f(), "=", "\n") + "\nextra=\n" + g.a(e(), "=", "\n");
        com.obric.matrix.r.c.c.f("OApmCustomError", "sendCustomError: " + r3);
        i.g("report_error", r3, "", false, r9.getPackageName(), true);
        c r10 = new c("custom_error");
        r10.a(c());
        r10.j();
    }
}
