package com.obric.matrix.push.base.settings;

import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.push.settings.e;
import com.obric.matrix.push.r.d;
import com.obric.matrix.push.r.i;
import com.squareup.wire.internal.Internal;
import java.util.List;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0004H\u0016J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0002J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0004H\u0016J\u0016\u0010\u0011\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/matrix/push/base/settings/PushSettingsService;", "Lcom/obric/matrix/push/base/settings/IPushSettingsService;", "()V", "HOST_APP_LIST", "", "TAG", "hostAppList", "", "getLocalSettings", "Lcom/obric/matrix/push/base/settings/PushLocalSettings;", "isHostAppList", "", "pkgName", "putHostAppList", "", "readAppList", "removeHostAppList", "writeAppList", "appList", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<String> f9521b;

    public b() {
        this.f9520a = "host_app_list";
    }

    private final List<String> e() {
        String r3 = Settings.Secure.getString(com.bytedance.mpaas.app.a.b().getContentResolver(), this.f9520a);
        if (TextUtils.isEmpty(r3) == true) goto L5;
        i r0 = i.f9797a;
        d r1 = d.f9793a;
        o.e(r3, "oldAppListStr");
        return r0.b(r1.b(r3));
    L5:
        return Internal.newMutableList();
    }

    private final void f(List<String> r4) {
        Settings.Secure.putString(com.bytedance.mpaas.app.a.b().getContentResolver(), this.f9520a, d.f9793a.a(i.f9797a.a(r4)));
    }

    @Override // com.obric.matrix.push.base.settings.a
    public PushLocalSettings a() {
        Object r1 = e.b(com.bytedance.mpaas.app.a.b(), PushLocalSettings.class);
        o.e(r1, "obtain(LaunchApplication…ocalSettings::class.java)");
        return (PushLocalSettings) r1;
    }

    @Override // com.obric.matrix.push.base.settings.a
    public void b(String r3) {
        o.f(r3, "pkgName");
        List<String> r0 = e();
        if (r0.contains(r3) == false) goto L9;
        r0.remove(r3);
        List<String> r1 = this.f9521b;
        if (r1 == null) goto L7;
        r1.remove(r3);
    L7:
        f(r0);
        return;
    }

    @Override // com.obric.matrix.push.base.settings.a
    public boolean c(String r2) {
        o.f(r2, "pkgName");
        List<String> r0 = this.f9521b;
        if (r0 == null) goto L7;
        o.c(r0);
    L6:
        return r0.contains(r2);
    L7:
        r0 = e();
        this.f9521b = r0;
        goto L6
    }

    @Override // com.obric.matrix.push.base.settings.a
    public void d(String r3) {
        o.f(r3, "pkgName");
        List<String> r0 = e();
        if (r0.contains(r3) == false) goto L5;
        return;
    L5:
        r0.add(r3);
        List<String> r1 = this.f9521b;
        if (r1 == null) goto L8;
        r1.add(r3);
    L8:
        f(r0);
    }
}
