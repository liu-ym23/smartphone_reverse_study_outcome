package com.obric.matrix.opush.g;

import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;
import com.bytedance.bdlocation.client.LocationInfoConst;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0004J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\u0004J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0004H\u0007J\u0006\u0010\u001a\u001a\u00020\u0004J\u0006\u0010\u001b\u001a\u00020\u000bJ\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/matrix/opush/utils/DeviceUtils;", "", "()V", "TAG", "", "getBrand", "getCountry", "getLanguage", "getModel", "getModelValue", "getOsApi", "", "getOsVersion", "getOtaVersionCode", "getProduct", "getProductValue", "getPuiOsVersionValue", "getRegion", "getRom", "getSerialNumber", "getSystemProperty", "key", "defaultValue", "getTargetAppVersion", "", "pkg", "getTzName", "getTzOffset", "isTargetPkgExists", "", "o_push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f9428a = null;

    static {
        f9428a = new d();
    }

    private d() {
    }

    private final String b() {
        String r1 = Build.MODEL;
        o.e(r1, "MODEL");
        return r1;
    }

    private final String f() {
        if (o.a(g("ro.pxr.usebuildinfo", "-1"), LocationInfoConst.ALLOW_USE_LOCATION) == false) goto L6;
        String r2 = Build.PRODUCT;
        o.e(r2, "{\n            //phoenix\n…  Build.PRODUCT\n        }");
        return r2;
    L6:
        return g("pxr.vendorhw.product.model", EnvironmentCompat.MEDIA_UNKNOWN);
    }

    private final String g(String r7, String r8) {
        Method r6 = Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class});     // Catch: Exception -> L9
        o.e(r6, "systemProperties.getMeth…:class.java\n            )");     // Catch: Exception -> L9
        Object r9 = r6.invoke(null, new Object[]{r7, r8});     // Catch: Exception -> L9
        if (r9 == null) goto L8;
        return (String) r9;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");     // Catch: Exception -> L9
    L9:
        return r8;
    }

    public final String a() {
        return b();
    }

    public final int c() {
        return Build.VERSION.SDK_INT;
    }

    public final String d() {
        return g("ro.os.ota.version", EnvironmentCompat.MEDIA_UNKNOWN);
    }

    public final String e() {
        return f();
    }

    public final boolean h(String r3) {
        o.f(r3, "pkg");
        if (TextUtils.isEmpty(r3) == false) goto L10;
        return false;
    L10:
        com.bytedance.mpaas.app.a.b().getPackageManager().getPackageInfo(r3, 16384);     // Catch: PackageManager.NameNotFoundException -> L9
        return true;
    L12:
        return false;
    }
}
