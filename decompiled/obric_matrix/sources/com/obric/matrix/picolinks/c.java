package com.obric.matrix.picolinks;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.util.Log;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.i0.j0;
import kotlin.n0.d.o;
import kotlin.r0.e;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0012J\u0016\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011J%\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0000¢\u0006\u0002\b\u0017J\u001d\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0019J\u0018\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u0004H\u0002J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/matrix/picolinks/PicoLinksUtils;", "", "()V", "ACTION_PICO_LINKS", "", "PICO_LINKS_ID", "PICO_LINKS_URL", "PKG_NAME_STORE", "QUERY_KEY_ACTION", "QUERY_KEY_CATEGORY", "QUERY_KEY_COMPONENT", "QUERY_KEY_INSTALL_GUIDE", "QUERY_KEY_PARAMS", "doComponentLaunch", "", "packageName", "uri", "Landroid/net/Uri;", "doComponentLaunch$picolinks_cnRelease", "doDeepLinksLaunch", "doPicoLinksLaunch", "callbackId", "", "doPicoLinksLaunch$picolinks_cnRelease", "gotoStoreDetailIfNeed", "gotoStoreDetailIfNeed$picolinks_cnRelease", "isInstalled", "context", "Landroid/content/Context;", "launchActivity", "", "intent", "Landroid/content/Intent;", "picolinks_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f9482a = null;

    static {
        f9482a = new c();
    }

    private c() {
    }

    private final boolean e(Context r3, String r4) {
        if (r3.getPackageManager().getPackageInfo(r4, 0) == null) goto L11;
        return true;
    L11:
        return false;
    L6:
        e = move-exception;
        com.obric.matrix.r.c.c.g("PicoLinks", "can't find package: " + r4, e);
        return false;
    }

    private final void f(Context r1, Intent r2) {
        r2.addFlags(134217728);
        r1.startActivity(r2);
    }

    public final boolean a(String r8, Uri r9) {
        o.f(r8, "packageName");
        o.f(r9, "uri");
        Context r1 = com.bytedance.mpaas.app.a.a();
        Intent r2 = new Intent("android.intent.action.MAIN");
        r2.setPackage(r8);
        String r3 = r9.getQueryParameter("action");
        if (r3 == null) goto L5;
        r2.setAction(r3);
    L5:
        String r4 = r9.getQueryParameter("component");
        if (r4 == null) goto L8;
        r2.setClassName(r8, r4);
    L8:
        String r10 = r9.getQueryParameter("category");
        if (r10 == null) goto L38;
        JSONArray r5 = new JSONArray(r10);
        Iterator<Integer> r11 = e.m(0, r5.length()).iterator();
    L12:
        if (r11.hasNext() == false) goto L38;
        r2.addCategory(r5.getString(((j0) r11).nextInt()));
    L38:
        String r12 = r9.getQueryParameter("params");     // Catch: Throwable -> L31
        if (r12 == null) goto L33;
        JSONObject r13 = new JSONObject(r12);     // Catch: Throwable -> L31
        Iterator<String> r14 = r13.keys();     // Catch: Throwable -> L31
        o.e(r14, "jsonParams.keys()");     // Catch: Throwable -> L31
    L17:
        if (r14.hasNext() == false) goto L33;
        String r6 = r14.next();     // Catch: Throwable -> L31
        Object r7 = r13.get(r6);     // Catch: Throwable -> L31
        if ((r7 instanceof Integer) == true) goto L21;
        if ((r7 instanceof Boolean) == true) goto L24;
        if ((r7 instanceof String) == false) goto L29;
        String r15 = (String) r7;     // Catch: Throwable -> L31
    L28:
        r2.putExtra(r6, r15);     // Catch: Throwable -> L31
        goto L17
    L29:
        r15 = r7.toString();     // Catch: Throwable -> L31
        goto L28
    L24:
        r2.putExtra(r6, ((Boolean) r7).booleanValue());     // Catch: Throwable -> L31
        goto L17
    L21:
        r2.putExtra(r6, ((Number) r7).intValue());     // Catch: Throwable -> L31
    L33:
        List<ResolveInfo> r16 = r1.getPackageManager().queryIntentActivities(r2, 64);
        o.e(r16, "context.packageManager.q…ent, GET_RESOLVED_FILTER)");
        if ((!r16.isEmpty()) == false) goto L37;
        Log.d("PicoLinks", "launch via component:" + r2);
        o.e(r1, "context");
        f(r1, r2);
        return true;
    L37:
        return false;
    L31:
        th = move-exception;
        Log.w("PicoLinks", th);
        goto L33
    }

    public final boolean b(String r4, Uri r5) {
        o.f(r4, "packageName");
        o.f(r5, "uri");
        Context r0 = com.bytedance.mpaas.app.a.a();
        Intent r1 = new Intent("android.intent.action.VIEW");
        r1.setPackage(r4);
        r1.setData(r5);
        List<ResolveInfo> r6 = r0.getPackageManager().queryIntentActivities(r1, 64);
        o.e(r6, "context.packageManager.q…ent, GET_RESOLVED_FILTER)");
        if ((!r6.isEmpty()) == false) goto L6;
        Log.d("PicoLinks", "launch via deep links:" + r1);
        o.e(r0, "context");
        f(r0, r1);
        return true;
    L6:
        return false;
    }

    public final boolean c(String r4, Uri r5, int r6) {
        o.f(r4, "packageName");
        o.f(r5, "uri");
        Context r0 = com.bytedance.mpaas.app.a.a();
        Intent r1 = new Intent("pico.intent.action.PICO_LINKS_LAUNCH");
        r1.setPackage(r4);
        List<ResolveInfo> r7 = r0.getPackageManager().queryIntentActivities(r1, 64);
        o.e(r7, "context.packageManager.q…ent, GET_RESOLVED_FILTER)");
        if ((!r7.isEmpty()) == false) goto L6;
        r1.putExtra("pico_links_id", r6);
        r1.putExtra("pico_links_url", r5);
        Log.d("PicoLinks", "launch via pico links:" + r1);
        o.e(r0, "context");
        f(r0, r1);
        return true;
    L6:
        return false;
    }

    public final boolean d(String r3, Uri r4) {
        o.f(r3, "packageName");
        o.f(r4, "uri");
        Context r0 = com.bytedance.mpaas.app.a.a();
        o.e(r0, "context");
        if (e(r0, r3) == false) goto L6;
        return false;
    L6:
        if (o.a(r4.getQueryParameter("installGuide"), "false") == false) goto L8;
        return false;
    L8:
        Log.d("PicoLinks", "app not installed goto store ");
        Uri r5 = Uri.parse("store://com.picovr.store/detail?type=2&package_name=" + r3);
        o.e(r5, "parse(storeUrl)");
        return b("com.picovr.store", r5);
    }
}
