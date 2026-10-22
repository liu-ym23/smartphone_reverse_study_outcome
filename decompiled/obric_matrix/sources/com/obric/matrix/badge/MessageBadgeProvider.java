package com.obric.matrix.badge;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import com.obric.matrix.r.c.c;

/* JADX INFO: loaded from: classes2.dex */
public class MessageBadgeProvider extends ContentProvider {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final UriMatcher f8831f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String[] f8832g = null;

    static {
        UriMatcher r0 = new UriMatcher(-1);
        f8831f = r0;
        r0.addURI("com.bytedanceos.launcher.badge", "badge", 1);
        r0.addURI("com.bytedanceos.launcher.badge", "badge/#", 2);
        f8832g = new String[]{"com.android.launcher3"};
    }

    public MessageBadgeProvider() {
    }

    public static String a(String r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        if (r1.equals("com.android.providers.telephony") == false) goto L9;
        return "com.android.mms";
    L9:
        return r1;
    }

    public static boolean b(Context r1, String r2) {
        if (r2 == null) goto L13;
        if (r1 == null) goto L14;
        if ((r1.getPackageManager().getApplicationInfo(r2, 0).flags & 1) != 0) goto L9;
        return false;
    L9:
        return true;
    L16:
        return false;
    L14:
        return false;
    L13:
        return false;
    }

    public static void c(Context r7, String r8, int r9, int r10, int r11, String r12) {
        d(r7, r8, r9, r10, r11, r12, "set");
    }

    public static void d(Context r12, String r13, int r14, int r15, int r16, String r17, String r18) {
        if (r13 != null) goto L5;
        c.e("send new message, pkg null. ");
        return;
    L5:
        String r0 = a(r13);
        String[] r9 = f8832g;     // Catch: Exception -> L10
        int r10 = r9.length;     // Catch: Exception -> L10
        int r11 = 0;
    L7:
        if (r11 >= r10) goto L16;
        g(r12, r0, r14, r15, r16, r9[r11], r17, r18);     // Catch: Exception -> L10
        r11 = r11 + 1;
        goto L7
    L16:
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
    }

    public static void e(Context r1, String r2, int r3, String r4) {
        Binder.getCallingUid();
        Binder.getCallingUserHandle().hashCode();
        f(r1, r2, r3, r4, "set");
    }

    public static void f(Context r7, String r8, int r9, String r10, String r11) {
        int r4 = Binder.getCallingUid();
        d(r7, r8, r9, Binder.getCallingUserHandle().hashCode(), r4, r10, r11);
    }

    public static void g(Context r2, String r3, int r4, int r5, int r6, String r7, String r8, String r9) {
        if (TextUtils.isEmpty(r9) == false) goto L5;
        r9 = "set";
    L5:
        c.b("MessageBadgeProvider", "sendIntent      pkg : " + r3 + "  num : " + r4 + "  userId : " + r5 + "  uid : " + r6 + "  sendTo : " + r7 + "  from : " + r8 + "  badgeOp : " + r9);
        Intent r0 = new Intent("obric.launcher.new_message");
        r0.addFlags(128);
        r0.putExtra("extra_package_name", r3);
        r0.putExtra("extra_message_count", r4);
        r0.putExtra("extra_uid", r6);
        r0.putExtra("extra_user_id", r5);
        r0.putExtra("extra_from", r8);
        r0.putExtra("extra_badge_op", r9);
        r0.setPackage(r7);
        r2.sendBroadcast(r0);
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r9, String r10, Bundle r11) {
        if ("updateMessageBadge".equals(r9) == true) goto L31;
        if ("addMessageBadge".equals(r9) == true) goto L31;
        c.j("MessageBadgeProvider", "call method:" + r9 + ", arg:" + r10);
    L30:
        return super.call(r9, r10, r11);
    L31:
        if (r11 != null) goto L12;
        c.f("MessageBadgeProvider", "call method failed, extras is null, method:" + r9 + ", arg:" + r10);     // Catch: Exception -> L27
        return null;
    L12:
        String r6 = getCallingPackage();     // Catch: Exception -> L27
        if (b(getContext(), r6) == true) goto L16;
        c.f("MessageBadgeProvider", "Call permission denied,  " + r6 + " is not system app, call method is " + r9 + ", arg is " + r10 + ", extras is " + r11);     // Catch: Exception -> L27
        return null;
    L16:
        int r2 = r11.getInt("badge_num");     // Catch: Exception -> L27
        if ("updateMessageBadge".equals(r9) == false) goto L19;
        String r1 = "set";
    L20:
        c.j("MessageBadgeProvider", "call method:" + r9 + ", badgeOp:" + r1 + ", arg:" + r10 + ", pkg:" + r6 + ", count:" + r2 + "  extras:" + r11);     // Catch: Exception -> L27
        if (r11.containsKey("alias") == false) goto L25;
        String r0 = r11.getString("alias");     // Catch: Exception -> L27
        if (TextUtils.isEmpty(r0) == true) goto L25;
        r6 = r0;
    L25:
        f(getContext(), r6, r2, "MessageBadgeProvider", r1);     // Catch: Exception -> L27
        goto L30
    L19:
        r1 = "add";
    L27:
        e = move-exception;
        e.printStackTrace();
        goto L30
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r1, String r2, String[] r3) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r3) {
        int r2 = f8831f.match(r3);
        if (r2 != 1) goto L5;
        return "vnd.android.cursor.dir/vnd.bytedance.launcher.badge";
    L5:
        if (r2 != 2) goto L9;
        return "vnd.android.cursor.item/vnd.bytedance.launcher.badge";
    L9:
        throw new IllegalArgumentException("Unknown URI: " + r3);
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r1, ContentValues r2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        c.j("MessageBadgeProvider", "onCreate()");
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        return 0;
    }
}
