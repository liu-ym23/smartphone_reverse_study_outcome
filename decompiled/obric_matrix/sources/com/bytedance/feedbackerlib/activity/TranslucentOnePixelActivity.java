package com.bytedance.feedbackerlib.activity;

import android.content.Context;
import android.content.Intent;
import android.media.projection.MediaProjectionManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.window.embedding.EmbeddingCompat;
import com.bytedance.feedbackerlib.Feedbacker;
import com.bytedance.feedbackerlib.m.w;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.google.android.material.badge.BadgeDrawable;
import java.util.concurrent.atomic.AtomicInteger;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class TranslucentOnePixelActivity extends BaseActivity {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final AtomicInteger f3980f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final SparseArray<b> f3981g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final SparseArray<a> f3982h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final SparseArray<c> f3983i = null;

    public interface a {
        void a(boolean r1);
    }

    public interface b {
        void onRequestPermissionResult(String[] r1, int[] r2);
    }

    public interface c {
        void a(int r1, @Nullable Intent r2);
    }

    static {
        f3980f = new AtomicInteger(0);
        f3981g = new SparseArray();
        f3982h = new SparseArray();
        f3983i = new SparseArray();
    }

    public TranslucentOnePixelActivity() {
    }

    private void A(int r3) {
        SparseArray<a> r0 = f3982h;
        monitor-enter(r0);
        a r1 = r0.get(r3);     // Catch: Throwable -> L17
        if (r1 != null) goto L9;
        finish();     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L17
        return;
    L9:
        r0.delete(r3);     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L17
        r1.a(w.b(this));     // Catch: Throwable -> L13
    L15:
        finish();
        return;
    L13:
        th = move-exception;
        com.bytedance.feedbackerlib.m.c.a("TranslucentOnePixelActi", "handleOverlayPermission failed", th);
    L17:
        th = move-exception;
        throw th;
    }

    private void B(int r3, int r4, @Nullable Intent r5) {
        SparseArray<c> r0 = f3983i;
        monitor-enter(r0);
        c r1 = r0.get(r3);     // Catch: Throwable -> L17
        if (r1 != null) goto L9;
        finish();     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L17
        return;
    L9:
        r0.delete(r3);     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L17
        r1.a(r4, r5);     // Catch: Throwable -> L13
    L15:
        finish();
        return;
    L13:
        th = move-exception;
        com.bytedance.feedbackerlib.m.c.a("TranslucentOnePixelActi", "handleScreenCapturePermission failed", th);
    L17:
        th = move-exception;
        throw th;
    }

    public static void C(@NonNull Context r2, @NonNull a r3) {
        int r0 = z();
        SparseArray<a> r1 = f3982h;
        monitor-enter(r1);
        r1.put(r0, r3);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        r2.startActivity(G(r2, r0));     // Catch: Throwable -> L12
        return;
    L17:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public static void D(@NonNull Context r2, @NonNull b r3, @NonNull String[] r4) {
        if (r4.length > 0) goto L5;
        return;
    L5:
        int r0 = z();
        SparseArray<b> r1 = f3981g;
        monitor-enter(r1);
        r1.put(r0, r3);     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        r2.startActivity(H(r2, r0, r4));     // Catch: Throwable -> L15
        return;
    L20:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static void E(@NonNull Context r2, @NonNull c r3) {
        int r0 = z();
        SparseArray<c> r1 = f3983i;
        monitor-enter(r1);
        r1.put(r0, r3);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        r2.startActivity(I(r2, r0));     // Catch: Throwable -> L12
        return;
    L17:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void F() {
        Window r2 = getWindow();
        WindowManager.LayoutParams r0 = r2.getAttributes();
        r0.gravity = BadgeDrawable.TOP_START;
        r0.width = 1;
        r0.height = 1;
        r0.flags = 40;
        r0.alpha = 0.0f;
        r2.setAttributes(r0);
    }

    private static Intent G(@NonNull Context r2, int r3) {
        Intent r0 = new Intent(r2, TranslucentOnePixelActivity.class);
        r0.putExtra("extra_action", 1);
        r0.putExtra("extra_request_code", r3);
        r0.addFlags(268435456);
        return r0;
    }

    private static Intent H(@NonNull Context r2, int r3, @NonNull String[] r4) {
        Intent r0 = new Intent(r2, TranslucentOnePixelActivity.class);
        r0.putExtra("extra_action", 0);
        r0.putExtra("extra_permissions", r4);
        r0.putExtra("extra_request_code", r3);
        r0.addFlags(268435456);
        return r0;
    }

    private static Intent I(@NonNull Context r2, int r3) {
        Intent r0 = new Intent(r2, TranslucentOnePixelActivity.class);
        r0.putExtra("extra_action", 2);
        r0.putExtra("extra_request_code", r3);
        r0.addFlags(268435456);
        return r0;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = EmbeddingCompat.DEBUG, value = "onStop")
    public static void v(TranslucentOnePixelActivity r2) {
        r2.u();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT < 21) goto L12;
        r2.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L8
        return;
    L13:
        return;
    }

    private void w() {
        int r0 = getIntent().getIntExtra("extra_request_code", -1);
        if (r0 >= 0) goto L5;
    L10:
        finish();
        return;
    L5:
        if (Build.VERSION.SDK_INT < 23) goto L10;
        Intent r1 = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        r1.setData(Uri.parse("package:" + getPackageName()));
        startActivityForResult(r1, r0);     // Catch: Throwable -> L12
        return;
    }

    private void x() {
        Intent r0 = getIntent();
        int r1 = r0.getIntExtra("extra_request_code", -1);
        if (r1 >= 0) goto L6;
        finish();
        return;
    L6:
        String[] r2 = r0.getStringArrayExtra("extra_permissions");
        if (r2 != null) goto L9;
    L15:
        finish();
        return;
    L9:
        if (r2.length <= 0) goto L15;
        if (Build.VERSION.SDK_INT < 23) goto L15;
        requestPermissions(r2, r1);
    }

    @RequiresApi(api = 21)
    private void y() {
        int r0 = getIntent().getIntExtra("extra_request_code", -1);
        if (r0 >= 0) goto L6;
        finish();
        return;
    L6:
        MediaProjectionManager r1 = (MediaProjectionManager) getSystemService("media_projection");
        if (r1 != null) goto L14;
        finish();
        return;
    L14:
        startActivityForResult(r1.createScreenCaptureIntent(), r0);     // Catch: Throwable -> L13
        return;
    }

    private static int z() {
        return f3980f.getAndIncrement();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    @RequiresApi(api = 21)
    protected void onActivityResult(int r4, int r5, @Nullable Intent r6) {
        super.onActivityResult(r4, r5, r6);
        int r0 = getIntent().getIntExtra("extra_action", -1);
        if (r0 >= 0) goto L7;
        finish();
        return;
    L7:
        if (r0 != 1) goto L9;
        com.bytedance.feedbackerlib.j.a.z0(Feedbacker.getApplicationContext()).f1(false);
        A(r4);
        return;
    L9:
        if (r0 == 2) goto L12;
        finish();
        return;
    L12:
        com.bytedance.feedbackerlib.j.a.z0(Feedbacker.getApplicationContext()).f1(false);
        B(r4, r5, r6);
    }

    @Override // com.bytedance.feedbackerlib.activity.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @RequiresApi(api = 21)
    protected void onCreate(Bundle r3) {
        super.onCreate(r3);
        F();
        Feedbacker.init(getApplication(), false);
        int r4 = getIntent().getIntExtra("extra_action", -1);
        if (r4 >= 0) goto L6;
        finish();
        return;
    L6:
        if (r4 != 0) goto L8;
        x();
    L14:
        com.bytedance.feedbackerlib.j.a.z0(Feedbacker.getApplicationContext()).m1();
        return;
    L8:
        if (r4 != 1) goto L10;
        w();
        goto L14
    L10:
        if (r4 == 2) goto L13;
        finish();
        return;
    L13:
        y();
        goto L14
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int r3, @NonNull String[] r4, @NonNull int[] r5) {
        super.onRequestPermissionsResult(r3, r4, r5);
        SparseArray<b> r0 = f3981g;
        monitor-enter(r0);
        b r1 = r0.get(r3);     // Catch: Throwable -> L13
        if (r1 != null) goto L9;
        finish();     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L9:
        r0.delete(r3);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        r1.onRequestPermissionResult(r4, r5);
        finish();
        return;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        v(this);
    }

    public void u() {
        super.onStop();
    }
}
