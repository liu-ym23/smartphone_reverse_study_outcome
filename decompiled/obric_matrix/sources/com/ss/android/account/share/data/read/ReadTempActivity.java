package com.ss.android.account.share.data.read;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import androidx.core.app.NotificationCompat;
import androidx.window.embedding.EmbeddingCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import kotlin.Metadata;
import kotlin.n0.d.o;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b*\u0010\u000fJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0016\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0016\u0010\u0014R\"\u0010\u001d\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010%\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010)\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010 \u001a\u0004\b'\u0010\"\"\u0004\b(\u0010$¨\u0006+"}, d2 = {"Lcom/ss/android/account/share/data/read/ReadTempActivity;", "Landroid/app/Activity;", "Landroid/os/Bundle;", "savedInstanceState", "Lkotlin/f0;", "onCreate", "(Landroid/os/Bundle;)V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "finish", "()V", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", NotificationCompat.CATEGORY_EVENT, "onTouchEvent", "f", "I", "getREQUEST_CODE", "()I", "setREQUEST_CODE", "(I)V", "REQUEST_CODE", "", "g", "Ljava/lang/String;", "getReadPkg", "()Ljava/lang/String;", "setReadPkg", "(Ljava/lang/String;)V", "readPkg", "h", "getReadKey", "setReadKey", "readKey", "<init>", "sec_share_data_release"}, k = 1, mv = {1, 1, 15})
public final class ReadTempActivity extends Activity {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f11782f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f11783g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f11784h;

    public ReadTempActivity() {
        this.f11782f = 17;
        this.f11783g = "";
        this.f11784h = "";
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = EmbeddingCompat.DEBUG, value = "onStop")
    public static void b(ReadTempActivity r2) {
        r2.a();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT < 21) goto L12;
        r2.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L8
        return;
    L13:
        return;
    }

    public void a() {
        super.onStop();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent r2) {
        if (isFinishing() == true) goto L6;
        finish();
    L6:
        return super.dispatchTouchEvent(r2);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int r9, int r10, Intent r11) {
        super.onActivityResult(r9, r10, r11);
        if (r9 != this.f11782f) goto L23;
        if (r11 == null) goto L23;
        if (r10 != (-1)) goto L22;
        boolean r12 = true;
        if (1 == r11.getIntExtra("EXTRA_IS_SUCCESS", -1)) goto L11;
        r12 = false;
    L11:
        String r13 = "";
        if (r12 == false) goto L17;
        String r14 = r11.getStringExtra("EXTRA_VALUE");
        if (r14 == null) goto L16;
        r13 = r14;
    L16:
        o.b(r13, "data.getStringExtra(EXTRA_DATA) ?: \"\"");
        b r15 = new b(this.f11783g, true, null, 0, 12, null);
        r15.f(this.f11784h);
        r15.g(3);
        r15.h(r13);
    L21:
        c.f11796f.e(r15);
        goto L23
    L17:
        String r16 = r11.getStringExtra("ERROR_MSG");
        if (r16 == null) goto L20;
        r13 = r16;
    L20:
        o.b(r13, "data.getStringExtra(ERROR_MSG) ?: \"\"");
        r15 = new b(this.f11783g, false, r13, 3);
        goto L21
    L22:
        c.f11796f.e(new b(this.f11783g, false, "resultCode not ok", 3));
    L23:
        finish();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle r7) {
        super.onCreate(r7);
        String r8 = getIntent().getStringExtra("READ_PKG");
        String r0 = "";
        if (r8 != null) goto L6;
        r8 = "";
    L6:
        this.f11783g = r8;
        String r9 = getIntent().getStringExtra("EXTRA_KEY");
        if (r9 == null) goto L9;
        r0 = r9;
    L9:
        this.f11784h = r0;
        if (TextUtils.isEmpty(this.f11783g) == false) goto L22;
        finish();
    L22:
        c r2 = c.f11796f;     // Catch: Exception -> L19
        if (r2.c(this.f11783g) == true) goto L17;
        r2.e(new b(this.f11783g, false, "not support", 3));     // Catch: Exception -> L19
        finish();     // Catch: Exception -> L19
        return;
    L17:
        Intent r3 = new Intent();     // Catch: Exception -> L19
        r3.setComponent(new ComponentName(this.f11783g, "com.ss.android.account.share.data.write.activity.ShareDataActivity"));     // Catch: Exception -> L19
        r3.putExtra("EXTRA_KEY", this.f11784h);     // Catch: Exception -> L19
        startActivityForResult(r3, this.f11782f);     // Catch: Exception -> L19
        return;
    L19:
        e = move-exception;
        c.f11796f.e(new b(this.f11783g, false, String.valueOf(e.getMessage()), 3));
        com.ss.android.i.n.a.c r6 = com.ss.android.i.n.a.c.d();
        r6.b("share_sdk_read_start_share_activity_failed");
        r6.a(LocationMonitorConst.ERR_MSG, e.getMessage());
        r6.a("err_msg_stack", Log.getStackTraceString(e));
        r6.c();
    }

    @Override // android.app.Activity
    protected void onStop() {
        b(this);
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent r2) {
        if (isFinishing() == true) goto L6;
        finish();
    L6:
        return super.onTouchEvent(r2);
    }
}
