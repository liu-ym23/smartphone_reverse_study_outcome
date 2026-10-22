package com.bytedance.feedbackerlib.model;

import android.content.Context;
import android.content.Intent;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bytedance.feedbackerlib.activity.TranslucentOnePixelActivity;
import com.bytedance.feedbackerlib.service.FloatWindowService;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile b f4592d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f4593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private MediaProjection f4594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private MediaProjectionManager f4595c;

    class a implements FloatWindowService.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC0144b f4596a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f4597b;

        /* JADX INFO: renamed from: com.bytedance.feedbackerlib.model.b$a$a, reason: collision with other inner class name */
        class C0143a implements TranslucentOnePixelActivity.c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ a f4598a;

            C0143a(a r1) {
                this.f4598a = r1;
            }

            @Override // com.bytedance.feedbackerlib.activity.TranslucentOnePixelActivity.c
            @RequiresApi(api = 21)
            public void a(int r5, @Nullable Intent r6) {
                if (r6 != null) goto L9;
                InterfaceC0144b r4 = this.f4598a.f4596a;
                if (r4 == null) goto L30;
                r4.a(null);
                return;
            L30:
                return;
            L9:
                if (b.b(this.f4598a.f4597b) != null) goto L22;
                b r1 = this.f4598a.f4597b;
                monitor-enter(r1);
            L19:
                th = move-exception;
                throw th;
            L13:
                if (b.b(this.f4598a.f4597b) == null) goto L26;
            L17:
                monitor-exit(r1);     // Catch: Throwable -> L19
                goto L22
            L26:
                b r2 = this.f4598a.f4597b;     // Catch: Throwable -> L16
                b.c(r2, b.d(r2).getMediaProjection(r5, r6));     // Catch: Throwable -> L16
            L16:
                b.c(this.f4598a.f4597b, null);     // Catch: Throwable -> L19
            L22:
                a r7 = this.f4598a;
                InterfaceC0144b r8 = r7.f4596a;
                if (r8 == null) goto L31;
                r8.a(b.b(r7.f4597b));
                return;
            }
        }

        a(b r1, InterfaceC0144b r2) {
            this.f4597b = r1;
            this.f4596a = r2;
        }

        @Override // com.bytedance.feedbackerlib.service.FloatWindowService.k
        public void a() {
            TranslucentOnePixelActivity.E(b.a(this.f4597b), new C0143a(this));
        }
    }

    /* JADX INFO: renamed from: com.bytedance.feedbackerlib.model.b$b, reason: collision with other inner class name */
    public interface InterfaceC0144b {
        void a(MediaProjection r1);
    }

    @RequiresApi(api = 21)
    private b(@NonNull Context r2) {
        Context r3 = r2.getApplicationContext();
        this.f4593a = r3;
        this.f4595c = (MediaProjectionManager) r3.getSystemService("media_projection");
    }

    static /* synthetic */ Context a(b r0) {
        return r0.f4593a;
    }

    static /* synthetic */ MediaProjection b(b r0) {
        return r0.f4594b;
    }

    static /* synthetic */ MediaProjection c(b r0, MediaProjection r1) {
        r0.f4594b = r1;
        return r1;
    }

    static /* synthetic */ MediaProjectionManager d(b r0) {
        return r0.f4595c;
    }

    @RequiresApi(api = 21)
    public static b e(@NonNull Context r2) {
        if (f4592d != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f4592d != null) goto L9;
        f4592d = new b(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f4592d;
    }

    public MediaProjection f(InterfaceC0144b r3) {
        MediaProjection r0 = this.f4594b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        FloatWindowService.b0(this.f4593a, new a(this, r3));
        return null;
    }

    public void g() {
        this.f4594b = null;
    }

    public void h() {
        this.f4594b = null;
    }
}
