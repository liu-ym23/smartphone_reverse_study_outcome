package com.obric.oui.actionbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.f;
import com.obric.common.oui.g;
import com.obric.common.oui.k;
import com.obric.oui.button.OButton;
import com.obric.oui.divider.ODivider;
import d.g.d.b.b.e;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.i0.i;
import kotlin.i0.r;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u0002E\u0005B\u001d\b\u0007\u0012\u0006\u0010@\u001a\u00020?\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010A¢\u0006\u0004\bC\u0010DJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\n\u001a\u00020\u00042\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\f\u001a\u00020\u00042\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u001f\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0017\u0010\u0018JE\u0010!\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u00192\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001e2\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001e¢\u0006\u0004\b!\u0010\"J\u001f\u0010%\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000fH\u0014¢\u0006\u0004\b%\u0010&J7\u0010,\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020\u000fH\u0014¢\u0006\u0004\b,\u0010-R\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00101\u001a\u00020\u001b8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0013\u00100R\u0018\u00104\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010>\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010=¨\u0006F"}, d2 = {"Lcom/obric/oui/actionbar/OBottomActionBar;", "Landroid/widget/FrameLayout;", "Lcom/obric/oui/actionbar/OBottomActionBar$a;", "config", "Lkotlin/f0;", "b", "(Lcom/obric/oui/actionbar/OBottomActionBar$a;)V", "", "Lcom/obric/oui/button/OButton;", "actionButtons", "d", "(Ljava/util/List;Lcom/obric/oui/actionbar/OBottomActionBar$a;)V", "c", "Landroid/view/View;", "button", "", "index", "e", "(Landroid/view/View;I)V", "f", "()V", "Lcom/obric/oui/actionbar/OBottomActionBar$b;", "l", "setBottomButtonClickListener", "(Lcom/obric/oui/actionbar/OBottomActionBar$b;)V", "", "hasDivider", "", "buttonStyle", "lastPrimary", "", "buttonTexts", "buttonImgIds", "g", "(ZLjava/lang/String;Z[Ljava/lang/String;[Ljava/lang/Integer;)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "k", "Ljava/util/List;", "Ljava/lang/String;", "TAG", "j", "Lcom/obric/oui/actionbar/OBottomActionBar$b;", "onClickListener", "Landroid/widget/LinearLayout;", "h", "Landroid/widget/LinearLayout;", "rootView", "Lcom/obric/oui/divider/ODivider;", "i", "Lcom/obric/oui/divider/ODivider;", "dividerView", "Landroid/view/View;", "contentView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public class OBottomActionBar extends FrameLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f10724f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private View f10725g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final LinearLayout f10726h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ODivider f10727i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private b f10728j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private List<OButton> f10729k;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f10730a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f10731b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f10732c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List<String> f10733d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final List<Integer> f10734e;

        public a(boolean r2, boolean r3, String r4, List<String> r5, List<Integer> r6) {
            o.f(r4, "buttonStyle");
            this.f10730a = r2;
            this.f10731b = r3;
            this.f10732c = r4;
            this.f10733d = r5;
            this.f10734e = r6;
        }

        public final List<Integer> a() {
            return this.f10734e;
        }

        public final String b() {
            return this.f10732c;
        }

        public final List<String> c() {
            return this.f10733d;
        }

        public final boolean d() {
            return this.f10730a;
        }

        public final boolean e() {
            return this.f10731b;
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L16;
            a r4 = (a) r3;
            if (this.f10730a == r4.f10730a) goto L8;
            return false;
        L8:
            if (this.f10731b == r4.f10731b) goto L10;
            return false;
        L10:
            if (o.a(this.f10732c, r4.f10732c) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f10733d, r4.f10733d) == true) goto L14;
            return false;
        L14:
            if (o.a(this.f10734e, r4.f10734e) == true) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v10 */
        public int hashCode() {
            boolean r0 = this.f10730a;
            ?? r1 = 1;
            ?? r2 = r0;
            if (r0 == false) goto L5;
            r2 = 1;
        L5:
            int r3 = r2 * 31;
            boolean r4 = this.f10731b;
            if (r4 == true) goto L9;
            r1 = r4;
        L9:
            int r5 = (r3 + r1) * 31;
            String r6 = this.f10732c;
            int r7 = 0;
            if (r6 == null) goto L12;
            int r8 = r6.hashCode();
        L13:
            int r9 = (r5 + r8) * 31;
            List<String> r10 = this.f10733d;
            if (r10 == null) goto L16;
            int r11 = r10.hashCode();
        L17:
            int r12 = (r9 + r11) * 31;
            List<Integer> r13 = this.f10734e;
            if (r13 == null) goto L21;
            r7 = r13.hashCode();
        L21:
            return r12 + r7;
        L16:
            r11 = 0;
            goto L17
        L12:
            r8 = 0;
            goto L13
        }

        public String toString() {
            return "OBABConfig(hasDivider=" + this.f10730a + ", lastPrimary=" + this.f10731b + ", buttonStyle=" + this.f10732c + ", buttonTexts=" + this.f10733d + ", buttonImgIds=" + this.f10734e + ")";
        }
    }

    public interface b {
        void a(View r1, int r2);
    }

    static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ OBottomActionBar f10735f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f10736g;

        c(OBottomActionBar r1, int r2) {
            this.f10735f = r1;
            this.f10736g = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            OBottomActionBar r0 = this.f10735f;
            o.e(r3, "it");
            OBottomActionBar.a(r0, r3, this.f10736g);
        }
    }

    static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ OBottomActionBar f10737f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f10738g;

        d(OBottomActionBar r1, int r2) {
            this.f10737f = r1;
            this.f10738g = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            OBottomActionBar r0 = this.f10737f;
            o.e(r3, "it");
            OBottomActionBar.a(r0, r3, this.f10738g);
        }
    }

    public OBottomActionBar(Context r9, AttributeSet r10) {
        o.f(r9, "context");
        super(r9, r10);
        this.f10724f = "OBottomActionBar";
        FrameLayout.inflate(r9, g.z, this);
        setBackgroundColor(ContextCompat.getColor(r9, com.obric.common.oui.c.u));
        View r0 = findViewById(f.K0);
        o.e(r0, "findViewById(R.id.root_layout)");
        this.f10726h = (LinearLayout) r0;
        View r1 = findViewById(f.U0);
        o.e(r1, "findViewById(R.id.top_divider)");
        this.f10727i = (ODivider) r1;
        int r2 = 0;
        TypedArray r11 = r9.getTheme().obtainStyledAttributes(r10, k.f8297j, 0, 0);
        boolean r3 = r11.getBoolean(k.o, true);
        boolean r4 = r11.getBoolean(k.f8299l, false);
        String r12 = r11.getString(k.m);
        int r5 = r11.getResourceId(k.n, -1);
        int r6 = r11.getResourceId(k.f8298k, -1);
        if (r5 != (-1)) goto L5;
        List r7 = null;
    L6:
        if (r6 != (-1)) goto L8;
        List r8 = null;
    L12:
        if (r12 == null) goto L14;
        String r13 = r12;
    L15:
        b(new a(r3, r4, r13, r7, r8));
        return;
    L14:
        r13 = "l1";
        goto L15
    L8:
        TypedArray r14 = r11.getResources().obtainTypedArray(r6);
        o.e(r14, "resources.obtainTypedArray(buttonImg)");
        ArrayList r15 = new ArrayList();
        int r16 = r14.length();
    L9:
        if (r2 >= r16) goto L11;
        r15.add(Integer.valueOf(r14.getResourceId(r2, -1)));
        r2 = r2 + 1;
        goto L9
    L11:
        List r17 = r.B0(r15);
        r14.recycle();
        r8 = r17;
        goto L12
    L5:
        String[] r18 = r11.getResources().getStringArray(r5);
        o.e(r18, "resources.getStringArray(buttonResourceId)");
        r7 = i.n0(r18);
        goto L6
    }

    public static final /* synthetic */ void a(OBottomActionBar r0, View r1, int r2) {
        r0.e(r1, r2);
    }

    private final void b(a r17) {
        String r2 = r17.b();
        int r3 = r2.hashCode();
        if (r3 == (-1612256902)) goto L31;
        if (r3 == 3397) goto L28;
        if (r3 == 104387) goto L25;
        if (r3 == 678742426) goto L22;
        if (r3 == 3428) goto L19;
        if (r3 != 3429) goto L35;
        if (r2.equals("m2") == false) goto L35;
        this.f10725g = FrameLayout.inflate(getContext(), g.E, null);
        this.f10726h.addView(this.f10725g, new LinearLayout.LayoutParams(-1, -1));
        View r4 = findViewById(f.m);
        o.e(r4, "findViewById(R.id.action_button_m20)");
        View r5 = findViewById(f.n);
        o.e(r5, "findViewById(R.id.action_button_m21)");
        View r6 = findViewById(f.o);
        o.e(r6, "findViewById(R.id.action_button_m22)");
        List<OButton> r7 = r.m(new OButton[]{(OButton) r4, (OButton) r5, (OButton) r6});
    L33:
        this.f10729k = r7;
    L35:
        if (r17.b().compareTo("img") != 0) goto L37;
        c(this.f10729k, r17);
    L38:
        boolean r1 = r17.d();
        ODivider r0 = this.f10727i;
        if (r1 == false) goto L41;
        r0.setVisibility(0);
        return;
    L41:
        r0.setVisibility(8);
        return;
    L37:
        d(this.f10729k, r17);
        goto L38
    L19:
        if (r2.equals("m1") == false) goto L35;
        this.f10725g = FrameLayout.inflate(getContext(), g.D, null);
        this.f10726h.addView(this.f10725g, new LinearLayout.LayoutParams(-1, -1));
        View r8 = findViewById(f.f8242d);
        o.e(r8, "findViewById(R.id.action_button_0)");
        View r9 = findViewById(f.f8243e);
        o.e(r9, "findViewById(R.id.action_button_1)");
        View r10 = findViewById(f.f8244f);
        o.e(r10, "findViewById(R.id.action_button_2)");
        View r11 = findViewById(f.f8245g);
        o.e(r11, "findViewById(R.id.action_button_3)");
        View r12 = findViewById(f.f8246h);
        o.e(r12, "findViewById(R.id.action_button_4)");
        r7 = r.m(new OButton[]{(OButton) r8, (OButton) r9, (OButton) r10, (OButton) r11, (OButton) r12});
        goto L33
    L22:
        if (r2.equals("m2-primary") == false) goto L35;
        this.f10725g = FrameLayout.inflate(getContext(), g.F, null);
        this.f10726h.addView(this.f10725g, new LinearLayout.LayoutParams(-1, -1));
        View r13 = findViewById(f.p);
        o.e(r13, "findViewById(R.id.action_button_m2_primary0)");
        View r14 = findViewById(f.q);
        o.e(r14, "findViewById(R.id.action_button_m2_primary1)");
        r7 = r.m(new OButton[]{(OButton) r13, (OButton) r14});
        goto L33
    L25:
        if (r2.equals("img") == false) goto L35;
        this.f10725g = FrameLayout.inflate(getContext(), g.A, null);
        this.f10726h.addView(this.f10725g, new LinearLayout.LayoutParams(-1, -1));
        View r15 = findViewById(f.f8242d);
        o.e(r15, "findViewById(R.id.action_button_0)");
        View r16 = findViewById(f.f8243e);
        o.e(r16, "findViewById(R.id.action_button_1)");
        View r18 = findViewById(f.f8244f);
        o.e(r18, "findViewById(R.id.action_button_2)");
        View r19 = findViewById(f.f8245g);
        o.e(r19, "findViewById(R.id.action_button_3)");
        View r20 = findViewById(f.f8246h);
        o.e(r20, "findViewById(R.id.action_button_4)");
        View r21 = findViewById(f.f8247i);
        o.e(r21, "findViewById(R.id.action_button_5)");
        r7 = r.m(new OButton[]{(OButton) r15, (OButton) r16, (OButton) r18, (OButton) r19, (OButton) r20, (OButton) r21});
        goto L33
    L28:
        if (r2.equals("l1") == false) goto L35;
        this.f10725g = FrameLayout.inflate(getContext(), g.B, null);
        this.f10726h.addView(this.f10725g, new LinearLayout.LayoutParams(-1, -1));
        View r22 = findViewById(f.f8248j);
        o.e(r22, "findViewById(R.id.action_button_L10)");
        View r23 = findViewById(f.f8249k);
        o.e(r23, "findViewById(R.id.action_button_L11)");
        r7 = r.m(new OButton[]{(OButton) r22, (OButton) r23});
        goto L33
    L31:
        if (r2.equals("l1-primary") == false) goto L35;
        this.f10725g = FrameLayout.inflate(getContext(), g.C, null);
        this.f10726h.addView(this.f10725g, new LinearLayout.LayoutParams(-1, -1));
        View r24 = findViewById(f.f8250l);
        o.e(r24, "findViewById(R.id.action_button_L1_primary)");
        r7 = r.m(new OButton[]{(OButton) r24});
        goto L33
    }

    private final void c(List<OButton> r8, a r9) {
        if (r8 != null) goto L4;
        return;
    L4:
        int r2 = 0;
        if (r9.a() == null) goto L12;
        int r0 = Math.min(r9.a().size(), r8.size());
        if (r9.a().size() <= r8.size()) goto L9;
        Log.e(this.f10724f, "Exceeded the maximum number of buttons Max is " + r8.size());
    L9:
        int r3 = r0 - 1;
        int r4 = 0;
    L10:
        if (r4 >= r0) goto L13;
        r8.get(r4).setVisibility(0);
        r8.get(r4).setButtonSourceBitmap(r9.a().get(r4).intValue());
        r4 = r4 + 1;
    L13:
        if (r3 != (-1)) goto L15;
        r3 = r8.size() - 1;
    L15:
        if (r3 < 0) goto L19;
    L16:
        r8.get(r2).setOnClickListener(new c(this, r2));
        if (r2 == r3) goto L22;
        r2 = r2 + 1;
        goto L16
    L22:
        return;
    L19:
        return;
    L12:
        r3 = -1;
        goto L13
    }

    private final void d(List<OButton> r8, a r9) {
        if (r8 != null) goto L4;
        return;
    L4:
        int r2 = 0;
        if (r9.c() == null) goto L12;
        int r0 = Math.min(r9.c().size(), r8.size());
        if (r9.c().size() <= r8.size()) goto L9;
        Log.e(this.f10724f, "Exceeded the maximum number of buttons Max is " + r8.size());
    L9:
        int r3 = r0 - 1;
        int r4 = 0;
    L10:
        if (r4 >= r0) goto L13;
        r8.get(r4).setVisibility(0);
        r8.get(r4).setText(r9.c().get(r4));
        r4 = r4 + 1;
    L13:
        if (r3 != (-1)) goto L16;
        r3 = r8.size() - 1;
    L16:
        if (r9.e() == false) goto L25;
        r8.get(r3).setBackgroundColor(getResources().getColor(com.obric.common.oui.c.w));
        r8.get(r3).setTextColor(getResources().getColor(com.obric.common.oui.c.L));
        d.g.d.f.b r10 = d.g.d.f.b.f16934a;
        OButton r11 = r8.get(r3);
        if (r11 != null) goto L21;
    L19:
        r11 = null;
    L22:
        OButton r12 = r11;
        if (r12 == null) goto L25;
        r12.b(this.f10724f);
        goto L25
    L21:
        if ((r11 instanceof e) == false) goto L19;
    L25:
        if (r3 < 0) goto L29;
    L26:
        r8.get(r2).setOnClickListener(new d(this, r2));
        if (r2 == r3) goto L32;
        r2 = r2 + 1;
        goto L26
    L32:
        return;
    L29:
        return;
    L12:
        r3 = -1;
        goto L13
    }

    private final void e(View r1, int r2) {
        b r0 = this.f10728j;
        if (r0 == null) goto L6;
        r0.a(r1, r2);
        return;
    }

    private final void f() {
        View r0 = this.f10725g;
        if (r0 == null) goto L6;
        this.f10726h.removeView(r0);
        this.f10725g = null;
        return;
    }

    public final void g(boolean r8, String r9, boolean r10, String[] r11, Integer[] r12) {
        o.f(r9, "buttonStyle");
        f();
        if (r11 == null) goto L5;
        List r5 = i.n0(r11);
    L6:
        if (r12 == null) goto L8;
        List r6 = i.n0(r12);
    L9:
        b(new a(r8, r10, r9, r5, r6));
        return;
    L8:
        r6 = null;
        goto L9
    L5:
        r5 = null;
        goto L6
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    public final void setBottomButtonClickListener(b r1) {
        this.f10728j = r1;
    }
}
