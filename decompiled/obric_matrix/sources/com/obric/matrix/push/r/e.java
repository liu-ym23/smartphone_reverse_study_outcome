package com.obric.matrix.push.r;

import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import androidx.core.os.EnvironmentCompat;
import com.bytedance.bdlocation.client.LocationInfoConst;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0004J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\u0004J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0004H\u0007J\u0006\u0010\u001a\u001a\u00020\u0004J\u0006\u0010\u001b\u001a\u00020\u000bJ\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/matrix/push/utils/DeviceUtils;", "", "()V", "TAG", "", "getBrand", "getCountry", "getLanguage", "getModel", "getModelValue", "getOsApi", "", "getOsVersion", "getOtaVersionCode", "getProduct", "getProductValue", "getPuiOsVersionValue", "getRegion", "getRom", "getSerialNumber", "getSystemProperty", "key", "defaultValue", "getTargetAppVersion", "", "pkg", "getTzName", "getTzOffset", "isTargetPkgExists", "", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f9794a = null;

    static {
        f9794a = new e();
    }

    private e() {
    }

    private final String e() {
        if (o.a(o("ro.pxr.usebuildinfo", "-1"), LocationInfoConst.ALLOW_USE_LOCATION) == false) goto L6;
        String r2 = Build.MODEL;
        o.e(r2, "{\n            Build.MODEL\n        }");
        return r2;
    L6:
        return o("pxr.vendorhw.product.name", EnvironmentCompat.MEDIA_UNKNOWN);
    }

    private final String j() {
        if (o.a(o("ro.pxr.usebuildinfo", "-1"), LocationInfoConst.ALLOW_USE_LOCATION) == false) goto L6;
        String r2 = Build.PRODUCT;
        o.e(r2, "{\n            //phoenix\n…  Build.PRODUCT\n        }");
        return r2;
    L6:
        return o("pxr.vendorhw.product.model", EnvironmentCompat.MEDIA_UNKNOWN);
    }

    private final String k() {
        return o("ro.pui.build.version", "");
    }

    private final String o(String r7, String r8) {
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
        return "obric";
    }

    public final String b() {
        String r2 = Resources.getSystem().getConfiguration().locale.getCountry();
        o.e(r2, "getSystem().configuration.locale.country");
        Locale r0 = Locale.ROOT;
        o.e(r0, "ROOT");
        String r3 = r2.toUpperCase(r0);
        o.e(r3, "this as java.lang.String).toUpperCase(locale)");
        return r3;
    }

    public final String c() {
        String r1 = Locale.getDefault().toLanguageTag();
        o.e(r1, "getDefault().toLanguageTag()");
        return r1;
    }

    public final String d() {
        return e();
    }

    public final int f() {
        return Build.VERSION.SDK_INT;
    }

    public final String g() {
        String r2 = k();
        if (TextUtils.isEmpty(r2) == false) goto L8;
        String r3 = Build.VERSION.RELEASE;
        o.e(r3, "RELEASE");
        if (r3.length() <= 10) goto L9;
        String r4 = r3.substring(0, 10);
        o.e(r4, "this as java.lang.String…ing(startIndex, endIndex)");
        return r4;
    L9:
        return r3;
    L8:
        return r2;
    }

    public final String h() {
        return o("ro.os.ota.version", EnvironmentCompat.MEDIA_UNKNOWN);
    }

    public final String i() {
        return j();
    }

    public final String l() {
        String r2 = Locale.getDefault().getCountry();
        o.e(r2, "getDefault().country");
        Locale r0 = Locale.ROOT;
        o.e(r0, "ROOT");
        String r3 = r2.toLowerCase(r0);
        o.e(r3, "this as java.lang.String).toLowerCase(locale)");
        return r3;
    }

    public final String m() {
        String r1 = Build.DISPLAY;
        o.e(r1, "DISPLAY");
        return r1;
    }

    public final String n() {
        String r1 = Build.getSerial();     // Catch: Throwable -> L4
        o.e(r1, "{\n            android.os…ild.getSerial()\n        }");     // Catch: Throwable -> L4
        return r1;
    L4:
        return "pico_sn_err";
    }

    @RequiresApi(28)
    public final long p(String r2) {
        o.f(r2, "pkg");
        return com.bytedance.mpaas.app.a.b().getPackageManager().getPackageInfo(r2, 16384).getLongVersionCode();
    }

    public final String q() {
        String r1 = Calendar.getInstance().getTimeZone().getID();
        o.e(r1, "timeZone.id");
        return r1;
    }

    public final int r() {
        return Calendar.getInstance().getTimeZone().getOffset(System.currentTimeMillis()) / 1000;
    }

    public final boolean s(String r3) {
        o.f(r3, "pkg");
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return false;
    L5:
        List<PackageInfo> r2 = com.bytedance.mpaas.app.a.b().getPackageManager().getInstalledPackages(16384);
        o.e(r2, "packageManager.getInstal…nager.GET_CONFIGURATIONS)");
        Iterator<PackageInfo> r4 = r2.iterator();
    L7:
        if (r4.hasNext() == false) goto L12;
        if (TextUtils.equals(r4.next().packageName, r3) == false) goto L7;
        return true;
    L12:
        return false;
    }
}
