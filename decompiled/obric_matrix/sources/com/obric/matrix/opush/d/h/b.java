package com.obric.matrix.opush.d.h;

import android.app.Application;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.UserHandle;
import android.text.TextUtils;
import com.obric.matrix.opush.d.g.f;
import com.obric.matrix.opush.service.NotificationEventService;
import com.obric.matrix.v.a.g;
import com.obric.matrix.v.a.h;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.d.o;
import kotlin.v;
import kotlin.w;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\n\u0010\u0012\u001a\u00060\u0013j\u0002`\u0014J,\u0010\u0015\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\n\u0010\u0012\u001a\u00060\u0013j\u0002`\u0014J,\u0010\u0016\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\n\u0010\u0012\u001a\u00060\u0013j\u0002`\u0014H\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0004H\u0002J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\nJ8\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u0004H\u0002J8\u0010$\u001a\u00020\u001d2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/obric/matrix/opush/base/notification/NotificationPushEventHandler;", "", "()V", "PUSH_CLICK_TYPE_CUSTOM", "", "PUSH_CLICK_TYPE_CUSTOM_BROADCAST", "PUSH_CLICK_TYPE_DETAIL", "PUSH_CLICK_TYPE_HOME", "PUSH_CLICK_TYPE_URL", "TAG", "", "buildContentIntent", "Landroid/app/PendingIntent;", "context", "Landroid/content/Context;", "requestCode", "message", "Lcom/obric/matrix/o/push/Message;", "notification", "Lcom/obric/matrix/o/push/Notification;", "Lcom/obric/matrix/opush/ONotification;", "buildDeleteIntent", "createIntent", "Landroid/content/Intent;", "action", "createUserHandle", "Landroid/os/UserHandle;", "userId", "processPushEvent", "", "notificationIntent", "sendBroadcastByUser", "intent", "msgId", "pkgName", "clickType", "startActivityByUser", "o_push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f9375a = null;

    static {
        f9375a = new b();
    }

    private b() {
    }

    private final Intent c(Context r2, String r3, g r4, h r5) {
        Intent r1 = new Intent(r3);
        r1.putExtra("msg_id", r4.m);
        r1.putExtra("package_name", r4.o);
        com.obric.matrix.opush.d.g.g r6 = com.obric.matrix.opush.d.g.g.f9359a;
        f r0 = r6.c(r4);
        if (r0 == null) goto L5;
        r6.e(r1, r0);
    L5:
        r1.putExtra("click_type", r5.f10110d.f10048c.f10053e.f10057a);
        String r7 = r5.f10110d.f10048c.f10053e.f10061e;
        if (r7 == null) goto L8;
        o.e(r7, "extraData");
        r1.putExtra("additional_data", r7);
    L8:
        String r8 = r5.f10110d.f10048c.f10053e.f10059c;
        if (r8 == null) goto L11;
        o.e(r8, "action");
        r1.putExtra("open_url", r8);
    L11:
        Integer r9 = r4.n;
        if (r9 == null) goto L14;
        o.e(r9, "user_id");
        r1.putExtra("user_id", r9.intValue());
    L14:
        r1.setPackage(r2.getPackageName());
        return r1;
    }

    private final UserHandle d(int r8) {
        Class<?> r0 = Class.forName("android.os.UserHandle");
        v.a r3 = v.f21457g;     // Catch: Throwable -> L8
        Object r4 = r0.getMethod("of", new Class[]{Integer.TYPE}).invoke(null, new Object[]{Integer.valueOf(r8)});     // Catch: Throwable -> L8
        if (r4 == null) goto L7;
        Object r5 = (UserHandle) r4;     // Catch: Throwable -> L8
        v.b(r5);     // Catch: Throwable -> L8
    L11:
        if (v.d(r5) == null) goto L15;
        Object r9 = r0.getConstructor(new Class[]{Integer.TYPE}).newInstance(new Object[]{Integer.valueOf(r8)});
        Objects.requireNonNull(r9, "null cannot be cast to non-null type android.os.UserHandle");
        r5 = (UserHandle) r9;
    L15:
        return (UserHandle) r5;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.os.UserHandle");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        v.a r6 = v.f21457g;
        r5 = w.a(th);
        v.b(r5);
        goto L11
    }

    private final void f(Context r8, Intent r9, int r10, String r11, String r12, int r13) {
        if (r10 > 0) goto L13;
        r8.sendBroadcast(r9);
        return;
    L13:
        v.a r0 = v.f21457g;     // Catch: Throwable -> L7
        Object r7 = Context.class.getMethod("sendBroadcastAsUser", new Class[]{Intent.class, UserHandle.class}).invoke(r8, new Object[]{r9, d(r10)});     // Catch: Throwable -> L7
        v.b(r7);     // Catch: Throwable -> L7
    L9:
        Throwable r14 = v.d(r7);
        if (r14 == null) goto L15;
        com.obric.matrix.opush.c.f9247a.i("NotificationPushEventHandler", "sendBroadcastAsUser failed, fallback to sendBroadcast, msgId=" + r11 + " pkgName=" + r12 + " clickType=" + r13 + " userId=" + r10 + " actionType=broadcast", r14);
        r8.sendBroadcast(r9);
        return;
    L15:
        return;
    L7:
        th = move-exception;
        v.a r1 = v.f21457g;
        r7 = w.a(th);
        v.b(r7);
        goto L9
    }

    private final void g(Context r8, Intent r9, int r10, String r11, String r12, int r13) {
        if (r10 > 0) goto L13;
        r8.startActivity(r9);
        return;
    L13:
        v.a r0 = v.f21457g;     // Catch: Throwable -> L7
        Object r7 = Context.class.getMethod("startActivityAsUser", new Class[]{Intent.class, UserHandle.class}).invoke(r8, new Object[]{r9, d(r10)});     // Catch: Throwable -> L7
        v.b(r7);     // Catch: Throwable -> L7
    L9:
        Throwable r14 = v.d(r7);
        if (r14 == null) goto L15;
        com.obric.matrix.opush.c.f9247a.i("NotificationPushEventHandler", "startActivityAsUser failed, fallback to startActivity, msgId=" + r11 + " pkgName=" + r12 + " clickType=" + r13 + " userId=" + r10 + " actionType=activity", r14);
        r8.startActivity(r9);
        return;
    L15:
        return;
    L7:
        th = move-exception;
        v.a r1 = v.f21457g;
        r7 = w.a(th);
        v.b(r7);
        goto L9
    }

    public final PendingIntent a(Context r2, int r3, g r4, h r5) {
        o.f(r2, "context");
        o.f(r4, "message");
        o.f(r5, "notification");
        return PendingIntent.getBroadcast(r2, r3, c(r2, com.obric.matrix.opush.f.b.G.b(), r4, r5), 201326592);
    L5:
        th = move-exception;
        com.obric.matrix.r.c.c.f("NotificationPushEventHandler", "buildContentIntent error: " + th);
        return null;
    }

    public final PendingIntent b(Context r2, int r3, g r4, h r5) {
        o.f(r2, "context");
        o.f(r4, "message");
        o.f(r5, "notification");
        Intent r1 = c(r2, com.obric.matrix.opush.f.b.G.c(), r4, r5);     // Catch: Throwable -> L5
        r1.getExtras();     // Catch: Throwable -> L5
        return PendingIntent.getBroadcast(r2, r3, r1, 201326592);
    L5:
        th = move-exception;
        com.obric.matrix.r.c.c.f("NotificationPushEventHandler", "buildDeleteIntent error: " + th);
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r0v37, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v26, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r21v0, types: [com.obric.matrix.opush.d.h.b] */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v2, types: [int] */
    /* JADX WARN: Type inference failed for: r4v27 */
    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v6, types: [com.obric.matrix.opush.d.g.g] */
    /* JADX WARN: Type inference failed for: r4v7, types: [com.obric.matrix.opush.service.NotificationEventService$a] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void e(Intent r22, String r23) {
        o.f(r22, "notificationIntent");
        o.f(r23, "action");
        Application r8 = com.bytedance.mpaas.app.a.b();     // Catch: Exception -> L133
        String r15 = r22.getStringExtra("msg_id");     // Catch: Exception -> L133
        if (r15 == null) goto L132;
        String r14 = r22.getStringExtra("package_name");     // Catch: Exception -> L133
        if (r14 == null) goto L130;
        int r13 = r22.getIntExtra("click_type", -1);     // Catch: Exception -> L133
        String r9 = r22.getStringExtra("additional_data");     // Catch: Exception -> L133
        String r10 = r22.getStringExtra("open_url");     // Catch: Exception -> L133
        int r11 = r22.getIntExtra("open_url_type", 0);     // Catch: Exception -> L133
        ?? r4 = r22.getIntExtra("user_id", 0);     // Catch: Exception -> L133
        com.obric.matrix.opush.c.f9247a.h("NotificationPushEventHandler", "processPushEvent, id: " + r15 + ", package_name: " + r14 + " click_type: " + r13 + " additional_data: " + r9 + " open_url: " + r10 + " open_url_type: " + r11 + " user_id: " + r4);     // Catch: Exception -> L133
        StringBuilder r1 = new StringBuilder();     // Catch: Exception -> L133
        r1.append("processPushEvent, id: ");     // Catch: Exception -> L133
        r1.append(r15);     // Catch: Exception -> L133
        r1.append(", action: ");     // Catch: Exception -> L133
        r1.append(r23);     // Catch: Exception -> L133
        com.obric.matrix.r.c.c.b("NotificationPushEventHandler", r1.toString());     // Catch: Exception -> L133
        com.obric.matrix.opush.f.b r0 = com.obric.matrix.opush.f.b.G;     // Catch: Exception -> L133
        if (o.a(r23, r0.b()) == true) goto L143;
        String r2 = r15;
        ?? r3 = r2;
        if (o.a(r23, r0.c()) == false) goto L128;
        JSONObject r12 = new JSONObject();     // Catch: Exception -> L133
        r12.put("msg_id", r2);     // Catch: Exception -> L133
        r12.put("package_name", r14);     // Catch: Exception -> L133
        r12.put("result", r0.y());     // Catch: Exception -> L133
        com.obric.matrix.opush.d.g.g r5 = com.obric.matrix.opush.d.g.g.f9359a;     // Catch: Exception -> L133
        f r7 = r5.a(r22);     // Catch: Exception -> L133
        if (r7 == null) goto L127;
        r5.f(r12, r7);     // Catch: Exception -> L133
    L127:
        NotificationEventService.a r6 = NotificationEventService.f9442f;     // Catch: Exception -> L133
        o.e(r8, "context");     // Catch: Exception -> L133
        Intent r16 = r6.a(r8, r12, r0.D());     // Catch: Exception -> L133
        ?? r17 = r2;
    L121:
        r8.startService(r16);     // Catch: Exception -> L133
        r3 = r17;
    L128:
        com.obric.matrix.r.c.c.b("NotificationPushEventHandler", "processPushEvent success, id: " + r3 + ", action: " + r23);     // Catch: Exception -> L133
        return;
    L143:
        v.a r18 = v.f21457g;     // Catch: Throwable -> L111
        ?? r19 = 1;
        if (r13 != 1) goto L141;
        r19 = r15;
        Intent r110 = r8.getPackageManager().getLaunchIntentForPackage(r14);     // Catch: Throwable -> L109
        if (r110 == null) goto L106;
        o.e(r110, "context.packageManager.g…(\"launch intent is null\")");     // Catch: Throwable -> L109
        if (r9 == null) goto L101;
        r110.putExtra("additional_data", r9);     // Catch: Throwable -> L109
    L101:
        r110.setFlags(268435456);     // Catch: Throwable -> L109
        o.e(r8, "context");     // Catch: Throwable -> L109
        String r20 = r14;
        g(r8, r110, r4, r19, r14, r13);     // Catch: Throwable -> L107
        ?? r21 = r19;
    L104:
        Object r24 = f0.f18324a;     // Catch: Throwable -> L107
        v.b(r24);     // Catch: Throwable -> L107
        ?? r25 = r21;
        ?? r26 = r20;
    L114:
        Throwable r27 = v.d(r24);     // Catch: Exception -> L133
        if (r27 == null) goto L117;
        com.obric.matrix.opush.c.e(com.obric.matrix.opush.c.f9247a, "NotificationPushEventHandler", "click failed, error: " + r27, null, 4, null);     // Catch: Exception -> L133
    L117:
        ?? r28 = new JSONObject();     // Catch: Exception -> L133
        r28.put("msg_id", r25);     // Catch: Exception -> L133
        r28.put("package_name", r26);     // Catch: Exception -> L133
        ?? r29 = com.obric.matrix.opush.d.g.g.f9359a;     // Catch: Exception -> L133
        f r30 = r29.a(r22);     // Catch: Exception -> L133
        if (r30 == null) goto L120;
        r29.f(r28, r30);     // Catch: Exception -> L133
    L120:
        ?? r31 = NotificationEventService.f9442f;     // Catch: Exception -> L133
        o.e(r8, "context");     // Catch: Exception -> L133
        r16 = r31.a(r8, r28, com.obric.matrix.opush.f.b.G.C());     // Catch: Exception -> L133
        r17 = r25;
        goto L121
    L106:
        throw new Exception("launch intent is null");     // Catch: Throwable -> L107
    L109:
        th = th;
        r4 = r14;
    L113:
        v.a r32 = v.f21457g;     // Catch: Exception -> L133
        r24 = w.a(th);     // Catch: Exception -> L133
        v.b(r24);     // Catch: Exception -> L133
        r25 = r19;
        r26 = r4;
        goto L114
    L141:
        if (r13 == 2) goto L77;
        if (r13 == 3) goto L61;
        if (r13 != 4) goto L20;
    L24:
        if (r10 != null) goto L26;
    L29:
        boolean r111 = true;
    L30:
        if (r111 == true) goto L59;
        Intent r33 = Intent.parseUri(r10, 1);     // Catch: Throwable -> L111
        if (r9 == null) goto L35;
        r33.putExtra("additional_data", r9);     // Catch: Throwable -> L111
    L35:
        if (r13 != 4) goto L44;
        r33.setFlags(268435456);     // Catch: Throwable -> L111
        o.e(r8, "context");     // Catch: Throwable -> L111
        o.e(r33, "intent");     // Catch: Throwable -> L111
        g(r8, r33, r4, r15, r14, r13);     // Catch: Throwable -> L41
        r20 = r14;
        r21 = r15;
    L41:
        th = th;
        r4 = r14;
        r19 = r15;
        goto L113
    L44:
        String r34 = r33.getStringExtra("intent_action");     // Catch: Throwable -> L111
        String r35 = r33.getStringExtra("intent_class");     // Catch: Throwable -> L111
        if (TextUtils.isEmpty(r34) == true) goto L47;
        r33.setAction(r34);     // Catch: Throwable -> L111
    L47:
        if (r35 != null) goto L49;
    L52:
        boolean r112 = true;
    L53:
        if (r112 == true) goto L55;
        r33.setComponent(new ComponentName(r14, r35));     // Catch: Throwable -> L111
    L55:
        o.e(r8, "context");     // Catch: Throwable -> L111
        o.e(r33, "intent");     // Catch: Throwable -> L111
        f(r8, r33, r4, r15, r14, r13);     // Catch: Throwable -> L93
    L90:
        r21 = r15;
        r20 = r14;
        goto L104
    L49:
        if (r35.length() == 0) goto L52;
        r112 = false;
        goto L53
    L59:
        throw new Exception("open_url is null");     // Catch: Throwable -> L93
    L26:
        if (r10.length() == 0) goto L29;
        r111 = false;
        goto L30
    L20:
        if (r13 == 5) goto L24;
        throw new Exception("unknown click type: " + r13);     // Catch: Throwable -> L111
    L61:
        if (r10 != null) goto L63;
    L66:
        boolean r113 = true;
    L67:
        if (r113 == true) goto L75;
        Uri r36 = Uri.parse(r10);     // Catch: Throwable -> L111
        o.e(r36, "parse(this)");     // Catch: Throwable -> L111
        Intent r114 = new Intent("android.intent.action.VIEW", r36);     // Catch: Throwable -> L111
        if (r9 == null) goto L71;
        r114.putExtra("additional_data", r9);     // Catch: Throwable -> L111
    L71:
        r114.setFlags(268435456);     // Catch: Throwable -> L111
        o.e(r8, "context");     // Catch: Throwable -> L111
    L89:
        g(r8, r114, r4, r15, r14, r13);     // Catch: Throwable -> L93
        goto L90
    L75:
        throw new Exception("open_url is null");     // Catch: Throwable -> L93
    L63:
        if (r10.length() == 0) goto L66;
        r113 = false;
        goto L67
    L77:
        if (r10 != null) goto L79;
    L82:
        boolean r115 = true;
    L83:
        if (r115 == true) goto L92;
        Uri r37 = Uri.parse(r10);     // Catch: Throwable -> L111
        o.e(r37, "parse(this)");     // Catch: Throwable -> L111
        r114 = new Intent("android.intent.action.VIEW", r37);     // Catch: Throwable -> L111
        if (r9 == null) goto L87;
        r114.putExtra("additional_data", r9);     // Catch: Throwable -> L111
    L87:
        r114.setFlags(268435456);     // Catch: Throwable -> L111
        o.e(r8, "context");     // Catch: Throwable -> L111
        goto L89
    L92:
        throw new Exception("open_url is null");     // Catch: Throwable -> L93
    L79:
        if (r10.length() == 0) goto L82;
        r115 = false;
    L93:
        th = th;
        r19 = "additional_data";
    L107:
        th = th;
    L111:
        th = th;
        r4 = r14;
        r19 = r15;
        goto L113
    L130:
        throw new Exception("package_name is null");     // Catch: Exception -> L133
    L132:
        throw new Exception("id is null");     // Catch: Exception -> L133
    L133:
        e = move-exception;
        com.obric.matrix.r.c.c.f("NotificationPushEventHandler", "processPushEvent failed, action: " + r23 + ", error: " + e);
    }
}
