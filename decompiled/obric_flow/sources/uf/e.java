package uf;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.common.utility.UIUtils;
import com.obric.launcher.widget.R$id;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import sf.f;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends b implements of.d {
    public final d e;
    public WeakReference f;
    public WeakReference g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayList f22349h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f22350i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f22351j;

    public e(Context r5) {
        super(r5);
        this.e = null;
        this.f = null;
        this.g = null;
        this.f22349h = new ArrayList();
        this.f22350i = false;
        this.f22351j = false;
        setClipChildren(false);
        FrameLayout.LayoutParams r10 = new FrameLayout.LayoutParams(-1, -1);
        d r11 = new d(r5);
        this.e = r11;
        r11.setAlpha(getAdjustAlpha());
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        r10.gravity = 17;
        addView(this.e, r10);
        UIUtils.setViewVisibility(this.e, 8);
        this.e.setSurfaceTextureListener(new c(1, this));
    }

    private float getAdjustAlpha() {
        String r5 = Build.MODEL;
        if (r5.equals("TAH-AN00") == false) goto L5;
        return 0.99f;
    L5:
        if (r5.equals("TAH-N29") == false) goto L7;
        return 0.99f;
    L7:
        if (r5.equals("RLI-AN00") == false) goto L9;
        return 0.99f;
    L9:
        if (r5.equals("RLI-N29") == false) goto L11;
        return 0.99f;
    L11:
        if (r5.equals("TAH-AN00m") == false) goto L13;
        return 0.99f;
    L13:
        if (r5.equals("RHA-AN00m") == false) goto L15;
        return 0.99f;
    L15:
        if (r5.equals("MRX-AL09") == false) goto L17;
        return 0.99f;
    L17:
        if (r5.equals("MRX-AL19") == false) goto L19;
        return 0.99f;
    L19:
        if (r5.equals("MRX-AN19") == false) goto L21;
        return 0.99f;
    L21:
        if (r5.equals("MRX-W09") == false) goto L23;
        return 0.99f;
    L23:
        if (r5.equals("IN2010") == false) goto L25;
        return 0.99f;
    L25:
        if (r5.equals("SM-G9650") == true) goto L40;
        r5.equals("MRX-W19");
        return 0.99f;
    L40:
        return 0.99f;
    }

    @Override // of.d
    public final void a(of.b r5) {
        Surface r10 = getSurface();
        if (r10 == null) goto L11;
        if (r10.isValid() == false) goto L11;
        of.e r11 = this.f22339b;
        if (r11 == null) goto L11;
        r11.d(r10);
        r5.run();
        return;
    L11:
        if (this.f22349h != null) goto L13;
        this.f22349h = new ArrayList();
    L13:
        this.f22349h.add(r5);
    }

    public final void d(Boolean r10) {
        if (c() == true) goto L5;
        return;
    L5:
        if (this.f22339b.f20565l == true) goto L122;
        WeakReference r5 = this.g;
        if (r5 == null) goto L119;
        of.a r11 = (of.a) r5.get();
        if (r11 == null) goto L120;
        this.f22339b.f20565l = true;
        f r12 = (f) r11;
        boolean r13 = r10.booleanValue();
        Intrinsics.checkNotNullParameter(this, "videoView");
        FrameLayout r14 = r12.g;
        Integer r15 = null;
        Context r16 = r12.f21894a;
        if (r14 == null) goto L14;
    L35:
        ViewGroup r17 = r12.f21897h;
        if (r17 == null) goto L48;
        Intrinsics.checkNotNull(r17);
        int r18 = r17.getChildCount();
        ViewGroup r19 = r12.f21897h;
        Intrinsics.checkNotNull(r19);
        View r20 = r19.getChildAt(r18 - 1);
        FrameLayout r21 = r12.g;
        if (r20 == r21) goto L48;
        if (r21 == null) goto L48;
        if (r21.getParent() == null) goto L47;
        ViewParent r22 = r21.getParent();
        if ((r22 instanceof ViewGroup) == false) goto L47;
        ((ViewGroup) r22).removeView(r21);
    L47:
        ViewGroup r23 = r12.f21897h;
        Intrinsics.checkNotNull(r23);
        r23.addView(r12.g, new FrameLayout.LayoutParams(-1, -1));
    L48:
        ViewGroup r24 = getParentLayout();
        ViewGroup.LayoutParams r25 = r24.getLayoutParams();
        r25.height = r24.getHeight();
        r25.width = r24.getWidth();
        r24.setLayoutParams(r25);
        r24.removeAllViews();
        int r26 = !r13 ? 1 : 0;
        Activity r27 = f.l(r16);
        if (r27 == null) goto L51;
        int r28 = r27.getRequestedOrientation();
    L52:
        if (r26 == (-1)) goto L57;
        if (r26 == r28) goto L57;
        Activity r29 = f.l(r16);
        if (r29 == null) goto L57;
        r29.setRequestedOrientation(r26);
    L57:
        Activity r30 = f.l(r16);
        if (r30 == null) goto L64;
        Window r31 = r30.getWindow();
        if (r31 == null) goto L64;
        WindowManager.LayoutParams r32 = r31.getAttributes();
        if (r32 == null) goto L64;
        r12.f21898i = r32.layoutInDisplayCutoutMode;
        r32.layoutInDisplayCutoutMode = 1;
    L64:
        if (r30 == null) goto L68;
        Window r33 = r30.getWindow();
        if (r33 == null) goto L68;
        Integer r34 = Integer.valueOf(r33.getStatusBarColor());
    L69:
        r12.f21900k = r34;
        if (r30 == null) goto L72;
        Window r35 = r30.getWindow();
    L74:
        if (r35 == null) goto L78;
        r35.setStatusBarColor(0);
    L78:
        if (r30 == null) goto L82;
        Window r36 = r30.getWindow();
        if (r36 == null) goto L82;
        r36.setFlags(1024, 1024);
    L82:
        FrameLayout r37 = r12.g;
        if (r37 == null) goto L86;
        r37.setVisibility(0);
    L86:
        FrameLayout r38 = r12.g;
        if (r38 == null) goto L89;
        r38.addView(this, new FrameLayout.LayoutParams(-1, -1));
    L89:
        Activity r39 = f.l(r16);
        if (r39 == null) goto L96;
        Window r40 = r39.getWindow();
        if (r40 == null) goto L96;
        View r41 = r40.getDecorView();
        if (r41 == null) goto L96;
        r15 = Integer.valueOf(r41.getSystemUiVisibility());
    L96:
        r12.f21899j = r15;
        Activity r42 = f.l(r16);
        if (r42 == null) goto L111;
        Window r43 = r42.getWindow();
        if (r43 == null) goto L111;
        View r44 = r43.getDecorView();
        if (r44 == null) goto L111;
        if (r43.getAttributes() == null) goto L109;
        if ((r43.getAttributes().flags & 1024) != 1024) goto L109;
        r43.clearFlags(1024);
    L109:
        if (r44.getSystemUiVisibility() == 5638) goto L111;
        r44.setSystemUiVisibility(5638);
    L111:
        rf.a r45 = this.f22340c;
        if (r45 == null) goto L121;
        ((rf.b) r45).f21737a.i("fullscreenchange", MapsKt.hashMapOf(new Pair[]{TuplesKt.to("fullscreen", Boolean.TRUE)}));
        return;
    L121:
        return;
    L72:
        r35 = null;
    L68:
        r34 = null;
        goto L69
    L51:
        r28 = 1;
        goto L52
    L14:
        if (r12.f21897h != null) goto L26;
        View r46 = r12.f;
    L17:
        if (r46.getParent() == null) goto L25;
        if ((r46.getParent() instanceof ViewGroup) == false) goto L25;
        ViewParent r47 = r46.getParent();
        if (r47 == null) goto L24;
        r46 = (ViewGroup) r47;
        goto L17
    L24:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L25:
        r12.f21897h = (ViewGroup) r46.findViewById(R.id.content);
    L26:
        ViewGroup r48 = r12.f21897h;
        if (r48 == null) goto L29;
        Intrinsics.checkNotNull(r48);
        View r49 = r48.findViewById(R$id.media_fullscreen_view);
    L30:
        if (r49 != null) goto L32;
    L34:
        FrameLayout r50 = new FrameLayout(r16);
        r12.g = r50;
        Intrinsics.checkNotNull(r50);
        r50.setId(R$id.media_fullscreen_view);
        goto L35
    L32:
        if ((r49 instanceof FrameLayout) == false) goto L34;
        r12.g = (FrameLayout) r49;
        goto L35
    L29:
        r49 = null;
        goto L30
    L120:
        return;
    L119:
        return;
    }

    public ViewGroup getParentLayout() {
        return (ViewGroup) this.f.get();
    }

    public Surface getSurface() {
        d r5 = this.e;
        if (r5 != null) goto L5;
        return null;
    L5:
        return r5.getSurface();
    }

    public void setParentLayout(ViewGroup r5) {
        this.f = new WeakReference(r5);
    }

    public void setTextureLayout(int r5) {
        d r10 = this.e;
        if (r10 == null) goto L6;
        r10.setVideoViewLayout(r5);
        return;
    }

    public void setTransformer(of.a r5) {
        this.g = new WeakReference(r5);
    }

    @Override // of.d
    public final void a() {
        UIUtils.setViewVisibility(this.e, 0);
    }
}
