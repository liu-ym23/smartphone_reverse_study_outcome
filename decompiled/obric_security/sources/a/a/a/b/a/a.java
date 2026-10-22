package a.a.a.b.a;

import a.a.a.a.a.c.c;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.obric.matrix.sdk.push.IRegisterCallback;
import com.obric.matrix.sdk.push.PushConfiguration;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u001e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/matrix/sdk/push/PushImpl;", "", "()V", "TAG", "", "onEvent", "", "context", "Landroid/content/Context;", "registerPush", "pushConfiguration", "Lcom/obric/matrix/sdk/push/PushConfiguration;", "registerCallback", "Lcom/obric/matrix/sdk/push/IRegisterCallback;", "unRegisterPush", "sdk_push_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a.a.a.b.a.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/obric/matrix/sdk/push/PushImpl$onEvent$1", "Lcom/obric/matrix/push/common/cross_process/interfaze/ICrossProcessCallback;", "onCallback", "", "params", "", "", "sdk_push_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class C0003a implements a.a.a.a.a.b.c.a {
        public C0003a() {
        }

        @Override // a.a.a.a.a.b.c.a
        public void a(List<Object> r2) {
            String r1 = "sdk event: " + r2;
            Intrinsics.checkNotNullParameter(r1, NotificationCompat.CATEGORY_MESSAGE);
            c.a("", r1);
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/obric/matrix/sdk/push/PushImpl$registerPush$1", "Lcom/obric/matrix/push/common/cross_process/interfaze/ICrossProcessCallback;", "onCallback", "", "params", "", "", "sdk_push_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b implements a.a.a.a.a.b.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f10a;
        public final /* synthetic */ IRegisterCallback b;

        public b(a r1, IRegisterCallback r2) {
            this.f10a = r1;
            this.b = r2;
        }

        @Override // a.a.a.a.a.b.c.a
        public void a(List<Object> r5) {
            this.f10a.getClass();
            c.a("PushImpl", "on  register_channel method callback");
            if (r5 == null) goto L17;
            IRegisterCallback r0 = this.b;
            Object r1 = r5.get(0);
            if (r1 == null) goto L16;
            String r2 = (String) r1;
            Object r6 = r5.get(1);
            if (r6 == null) goto L14;
            String r7 = (String) r6;
            if (TextUtils.equals(r2, "success") == false) goto L11;
            r0.onSuccess(r7);
        L12:
            Unit r8 = Unit.INSTANCE;
        L18:
            if (r8 != null) goto L21;
            this.b.onFailed("102", "error when call push_service!");
            return;
        L21:
            return;
        L11:
            r0.onFailed("103", r7);
            goto L12
        L14:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L16:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L17:
            r8 = null;
            goto L18
        }
    }

    public a() {
    }

    public final void a(Context r4) {
        Context r3 = r4.getApplicationContext();     // Catch: Throwable -> L6
        String r5 = r4.getPackageName();     // Catch: Throwable -> L6
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L6
        r0.put("package_name", r5);     // Catch: Throwable -> L6
        ArrayList<Object> r6 = new ArrayList();     // Catch: Throwable -> L6
        r6.add("push_sdk_register");     // Catch: Throwable -> L6
        r6.add(r0.toString());     // Catch: Throwable -> L6
        a.a.a.a.a.a r1 = a.a.a.a.a.a.f5a;     // Catch: Throwable -> L6
        Intrinsics.checkNotNull(r3);     // Catch: Throwable -> L6
        a.a.a.a.a.b.c.c r7 = r1.a(r3);     // Catch: Throwable -> L6
        r7.invoke("com.obric.matrix", "sdk_event", r6, new C0003a());     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        String r8 = Log.getStackTraceString(th);
        Intrinsics.checkNotNullExpressionValue(r8, "getStackTraceString(e)");
        c.a(r8);
    }

    public final void a(Context r4, PushConfiguration r5, IRegisterCallback r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "pushConfiguration");
        Intrinsics.checkNotNullParameter(r6, "registerCallback");
        c.a("PushImpl", "registerPush");
        if (TextUtils.isEmpty(r5.getAppId()) == false) goto L8;
        String r3 = "appId is empty!";
    L5:
        r6.onFailed("101", r3);
        return;
    L8:
        if (TextUtils.isEmpty(r5.getAppKey()) == false) goto L10;
        r3 = "appSecret is empty!";
        goto L5
    L10:
        ArrayList<Object> r0 = new ArrayList();
        r0.add(r5.getAppId());
        r0.add(r5.getAppKey());
        c.a("PushImpl", "invoke register_channel");
        a(r4);     // Catch: Throwable -> L15
        a.a.a.a.a.a.f5a.a(r4).invoke("com.obric.matrix", "register_channel", r0, new b(this, r6));     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        r6.onFailed("102", "error when call push_service! " + th.getMessage());
    }
}
