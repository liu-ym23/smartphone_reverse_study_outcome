package xe;

import android.R;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import com.bytedance.ies.xelement.viewpager.CustomAppBarLayout;
import com.bytedance.ies.xelement.viewpager.LynxTabBarView;
import com.bytedance.ies.xelement.viewpager.Pager$Adapter;
import com.bytedance.ies.xelement.viewpager.ReversingAdapter;
import com.bytedance.ies.xelement.viewpager.childitem.LynxViewpagerItem;
import com.bytedance.ies.xelement.viewpager.foldview.FoldViewLayout;
import com.bytedance.ies.xelement.viewpager.viewpager.BaseCustomViewPager;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.lynx.base.log.LynxLog;
import com.obric.launcher.widget.R$drawable;
import com.obric.launcher.widget.R$id;
import com.obric.launcher.widget.R$layout;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import ym.o;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i extends LinearLayout {
    public final Rect A;
    public final Rect B;
    public boolean C;
    public int D;
    public o E;
    public String F;
    public String G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BaseCustomViewPager f23113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LynxTabBarView f23114b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f23115c;
    public final Pager$Adapter d;
    public boolean e;
    public boolean f;
    public final ArrayList g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList f23116h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList f23117i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TabLayout f23118j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f23119k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f23120l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f23121m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f23122n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f23123o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f23124p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f23125q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public f f23126r;
    public TabLayout.OnTabSelectedListener s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public g f23127t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f23128u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f23129v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f23130w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final HashMap f23131x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final HashSet f23132y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int[] f23133z;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [androidx.viewpager.widget.PagerAdapter, com.bytedance.ies.xelement.viewpager.Pager$Adapter] */
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
    public i(BaseCustomViewPager r5, Context r10) {
        Intrinsics.checkNotNullParameter(r5, "mViewPager");
        Intrinsics.checkNotNullParameter(r10, "context");
        new LinkedHashMap();
        super(r10);
        this.f23113a = r5;
        this.f23115c = 9.0f;
        ?? r11 = new Pager$Adapter(this);
        this.d = r11;
        this.f = true;
        this.g = new ArrayList();
        this.f23116h = new ArrayList();
        this.f23117i = new ArrayList();
        this.f23120l = 16.0f;
        this.f23122n = 16.0f;
        this.f23128u = -1109;
        this.f23129v = -1109;
        this.f23131x = new HashMap();
        this.f23132y = new HashSet();
        this.f23133z = new int[2];
        this.A = new Rect();
        this.B = new Rect();
        setOrientation(1);
        this.f23113a.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.f23113a.setAdapter(r11);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        addView(this.f23113a, 0);
    }

    public final void a() {
        Drawable r5 = null;
        if (this.f23118j != null) goto L5;
        c(null);
    L5:
        TabLayout r10 = this.f23118j;
        if (r10 == null) goto L8;
        r5 = r10.getBackground();
    L8:
        if (r5 != null) goto L18;
        TabLayout r11 = this.f23118j;
        if (r11 == null) goto L12;
        r11.setBackgroundResource(R$drawable.lynx_tab_line_bg);
    L12:
        TabLayout r12 = this.f23118j;
        if (r12 == null) goto L19;
        Drawable r13 = r12.getBackground();
        if (r13 == null) goto L20;
        r13.mutate();
        return;
    L20:
        return;
    L19:
        return;
    }

    public final void b(float r5, boolean r10) {
        ViewGroup.LayoutParams r11 = null;
        if (r10 == false) goto L10;
        TabLayout r12 = this.f23118j;
        if (r12 == null) goto L7;
        r11 = r12.getLayoutParams();
    L7:
        if (r11 == null) goto L16;
        Context r13 = getContext();
        Intrinsics.checkNotNullParameter(r13, "context");
        r11.height = (int) ((r5 * r13.getResources().getDisplayMetrics().widthPixels) / 750);
    L16:
        TabLayout r14 = this.f23118j;
        if (r14 == null) goto L19;
        r14.getLayoutParams();
    L19:
        TabLayout r15 = this.f23118j;
        if (r15 == null) goto L23;
        r15.requestLayout();
        return;
    L23:
        return;
    L10:
        TabLayout r16 = this.f23118j;
        if (r16 == null) goto L13;
        r11 = r16.getLayoutParams();
    L13:
        if (r11 == null) goto L16;
        r11.height = com.lynx.jsbridge.a.a(getContext(), r5);
        goto L16
    }

    public final void c(ze.a r10) {
        View r5 = null;
        if (r10 == null) goto L5;
        removeView(this.f23118j);
        TabLayout r11 = this.f23118j;
        if (r11 == null) goto L13;
        r11.setupWithViewPager(null);
    L13:
        this.f23118j = r10;
        this.f23117i.clear();
        this.f23119k = 1;
    L14:
        TabLayout r12 = this.f23118j;
        if (r12 == null) goto L17;
        r12.setupWithViewPager(this.f23113a);
    L17:
        this.f23113a.setAdapter(this.d);
        boolean r13 = this.e;
        ReversingAdapter r14 = this.f23113a.getReversingAdapter();
        int r15 = this.f23113a.getCurrentItem();
        this.e = r13;
        this.f23113a.setRTL(r13);
        if (r14 == null) goto L20;
        r14.f6524b = r13;
        r14.notifyDataSetChanged();
    L20:
        int r16 = 0;
        if (this.f23119k != 1) goto L25;
        LynxTabBarView r17 = this.f23114b;
        if (r17 == null) goto L26;
        r17.b(0, r15);
    L26:
        this.f23113a.setCurrentItem(r15);
        TabLayout r18 = this.f23118j;
        if (r18 == null) goto L29;
        ViewParent r19 = r18.getParent();
    L30:
        if (r19 != null) goto L32;
        addView(this.f23118j, 0);
    L32:
        g r20 = this.f23127t;
        if (r20 == null) goto L55;
        TabLayout r21 = this.f23118j;
        com.bytedance.ies.xelement.viewpager.foldview.b r22 = (com.bytedance.ies.xelement.viewpager.foldview.b) r20;
        bf.g r23 = r22.f6557a;
        if (r21 == null) goto L37;
        r23.removeView(r21);
    L38:
        FoldViewLayout r24 = r22.f6558b;
        if (r21 == null) goto L51;
        AppBarLayout r25 = r24.f6510b;
        CustomAppBarLayout r26 = (CustomAppBarLayout) r25;
        int r27 = r26.getChildCount();
    L42:
        if (r16 >= r27) goto L48;
        View r28 = r26.getChildAt(r16);
        if ((r28 instanceof TabLayout) == true) goto L45;
        r16 = r16 + 1;
        goto L42
    L45:
        r5 = r28;
    L48:
        if (((TabLayout) r5) == null) goto L50;
        r26.removeView(r5);
    L50:
        Intrinsics.checkNotNullParameter(r21, "mView");
        r25.addView(r21);
    L51:
        ((CustomAppBarLayout) r24.findViewById(R$id.app_bar_layout)).getClass();
        return;
    L37:
        r23.getClass();
        goto L38
    L55:
        return;
    L29:
        r19 = null;
        goto L30
    L25:
        e();
        goto L26
    L5:
        if (this.f23118j != null) goto L56;
        int r29 = LynxTabBarView.f6512k;
        ze.a r30 = com.lynx.tasm.behavior.ui.utils.e.h(getContext());
        this.f23118j = r30;
        TabLayout.OnTabSelectedListener r31 = this.s;
        if (r31 == null) goto L14;
        r30.addOnTabSelectedListener(r31);
        goto L14
    }

    public final void d() {
        HashSet r5 = new HashSet();
        ArrayList r10 = new ArrayList();
        HashMap r11 = this.f23131x;
        Iterator r12 = r11.keySet().iterator();
    L3:
        boolean r13 = r12.hasNext();
        HashSet r14 = this.f23132y;
        if (r13 == false) goto L16;
        View r15 = (View) r12.next();
        e r16 = (e) r11.get(r15);
        if (r16 == null) goto L3;
        if (r15.isShown() == false) goto L3;
        if (r16.f23112b == false) goto L3;
        int r17 = r15.getWidth();
        int r18 = r15.getHeight();
        Rect r19 = this.B;
        r19.set(0, 0, r17, r18);
        int[] r20 = this.f23133z;
        r15.getLocationOnScreen(r20);
        r19.offset(r20[0], r20[1]);
        if (r19.intersect(this.A) == false) goto L3;
        d r21 = new d(this.D, r16.f23111a);
        r5.add(r21);
        if (r14.contains(r21) == true) goto L3;
        r10.add(r21);
        goto L3
    L16:
        r14.removeAll(r5);
        Iterator r22 = r14.iterator();
    L17:
        String r23 = "";
        if (r22.hasNext() == false) goto L26;
        d r24 = (d) r22.next();
        StringBuilder r25 = new StringBuilder("disappear: [sign, position] = [");
        r25.append(r24.f23109a);
        r25.append(", ");
        int r26 = r24.f23110b;
        r25.append(r26);
        LynxLog.b(2, "Foldview#BaseViewPagerImpl", r25.toString());
        o r27 = this.E;
        if (r27 == null) goto L17;
        String r28 = this.G;
        if (r28 == null) goto L25;
        r23 = r28;
    L25:
        r27.d(r26, r23);
        goto L17
    L26:
        r14.clear();
        r14.addAll(r5);
        Iterator r29 = r10.iterator();
    L28:
        if (r29.hasNext() == false) goto L35;
        d r30 = (d) r29.next();
        StringBuilder r31 = new StringBuilder("appear: [sign, position] = [");
        r31.append(r30.f23109a);
        r31.append(", ");
        int r32 = r30.f23110b;
        r31.append(r32);
        LynxLog.b(2, "Foldview#BaseViewPagerImpl", r31.toString());
        o r33 = this.E;
        if (r33 == null) goto L28;
        String r34 = this.F;
        if (r34 != null) goto L34;
        r34 = "";
    L34:
        r33.d(r32, r34);
        goto L28
    }

    public final void e() {
        if (this.f23119k != 1) goto L9;
        LynxTabBarView r5 = this.f23114b;
        if (r5 == null) goto L68;
        r5.c(this.f23130w);
        return;
    L68:
        return;
    L9:
        if (this.f23118j != null) goto L11;
        this.f23113a.setCurrentItem(this.f23130w, false);
    L11:
        HashMap r10 = this.f23131x;
        r10.clear();
        TabLayout r11 = this.f23118j;
        if (r11 == null) goto L14;
        int r12 = r11.getTabCount();
        int r13 = 0;
    L15:
        if (r13 >= r12) goto L76;
        TabLayout r14 = this.f23118j;
        if (r14 == null) goto L67;
        TabLayout.Tab r15 = r14.getTabAt(r13);
        if (r15 == null) goto L67;
        if (r13 != this.f23130w) goto L25;
        r15.select();
    L25:
        if (r15.getCustomView() != null) goto L67;
        View r16 = LayoutInflater.from(getContext()).inflate(R$layout.layout_custom_tab, r15.view, false);
        TextView r17 = (TextView) r16.findViewById(R.id.text1);
        r17.setText(r15.getText());
        TabLayout r18 = this.f23118j;
        if (r18 != null) goto L29;
    L37:
        r17.setTextSize(1, this.f23122n);
        if (this.f23125q == false) goto L40;
        Typeface r19 = Typeface.DEFAULT_BOLD;
    L41:
        r17.setTypeface(r19);
        int r20 = this.f23123o;
        if (r20 == 0) goto L45;
        r17.setTextColor(r20);
    L45:
        if (this.C == false) goto L47;
        r16.addOnAttachStateChangeListener(new bf.b(this, 7));
        r10.put(r16, new e(r15.getPosition()));
    L47:
        r15.setCustomView(r16);
        r15.view.setBackgroundColor(0);
        int r21 = com.lynx.jsbridge.a.a(getContext(), this.f23115c);
        if (this.f23128u != (-1109)) goto L51;
        this.f23128u = r21;
    L51:
        if (this.f23129v != (-1109)) goto L53;
        this.f23129v = r21;
    L53:
        if (r13 != 0) goto L55;
        int r22 = this.f23128u;
    L57:
        if (r13 != (this.f23117i.size() - 1)) goto L59;
        r21 = this.f23129v;
    L59:
        View r23 = r15.getCustomView();
        if (r23 == null) goto L62;
        ViewCompat.setPaddingRelative(r23, r22, r23.getPaddingTop(), r21, r23.getPaddingBottom());
    L62:
        TabLayout.TabView r24 = r15.view;
        if (r24 == null) goto L66;
        r24.setOnClickListener(new com.google.android.material.snackbar.a(9, this, r15));
        goto L67
    L66:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L55:
        r22 = r21;
        goto L57
    L40:
        r19 = Typeface.DEFAULT;
        goto L41
    L29:
        if (r13 != r18.getSelectedTabPosition()) goto L37;
        r17.setTextSize(1, this.f23120l);
        if (this.f23124p == false) goto L33;
        Typeface r25 = Typeface.DEFAULT_BOLD;
    L34:
        r17.setTypeface(r25);
        int r26 = this.f23121m;
        if (r26 == 0) goto L45;
        r17.setTextColor(r26);
        goto L45
    L33:
        r25 = Typeface.DEFAULT;
    L67:
        r13 = r13 + 1;
        goto L15
    L76:
        return;
    L14:
        r12 = 0;
        r13 = 0;
        goto L15
    }

    public final boolean getMChanged() {
        return this.f;
    }

    public final List<LynxViewpagerItem> getMPendingChildren() {
        return this.f23116h;
    }

    public final LynxTabBarView getMTabBarView() {
        return this.f23114b;
    }

    public final TabLayout getMTabLayout() {
        return this.f23118j;
    }

    public final List<String> getMTabLayoutTitles() {
        return this.f23117i;
    }

    public final BaseCustomViewPager getMViewPager() {
        return this.f23113a;
    }

    public final int getTabLayoutCodeMode() {
        return this.f23119k;
    }

    public final void setAllowHorizontalGesture(boolean r5) {
        this.f23113a.setMAllowHorizontalGesture(r5);
    }

    public final void setBorderHeight(float r5) {
        a();
        TabLayout r10 = this.f23118j;
        if (r10 == null) goto L5;
        Drawable r11 = r10.getBackground();
    L6:
        if (r11 == null) goto L14;
        Drawable r12 = ((LayerDrawable) r11).getDrawable(1);
        if (r12 == null) goto L12;
        GradientDrawable r13 = (GradientDrawable) r12;
        r13.setSize(r13.getIntrinsicWidth(), com.lynx.jsbridge.a.a(getContext(), r5));
        com.lynx.jsbridge.a.a(getContext(), r5);
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.LayerDrawable");
    L5:
        r11 = null;
        goto L6
    }

    public final void setBorderLineColor(String r5) {
        Intrinsics.checkNotNullParameter(r5, "color");
        a();
        TabLayout r10 = this.f23118j;
        if (r10 == null) goto L5;
        Drawable r11 = r10.getBackground();
    L6:
        if (r11 == null) goto L14;
        Drawable r12 = ((LayerDrawable) r11).getDrawable(1);
        if (r12 == null) goto L12;
        ((GradientDrawable) r12).setColor(com.lynx.jsbridge.a.b(r5));
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.LayerDrawable");
    L5:
        r11 = null;
        goto L6
    }

    public final void setBorderWidth(float r5) {
        a();
        Context r10 = getContext();
        Intrinsics.checkNotNullParameter(r10, "context");
        int r11 = (int) ((r5 / 375.0f) * r10.getResources().getDisplayMetrics().widthPixels);
        TabLayout r12 = this.f23118j;
        if (r12 == null) goto L5;
        Drawable r13 = r12.getBackground();
    L6:
        if (r13 == null) goto L14;
        Drawable r14 = ((LayerDrawable) r13).getDrawable(1);
        if (r14 == null) goto L12;
        GradientDrawable r15 = (GradientDrawable) r14;
        r15.setSize(r11, r15.getIntrinsicHeight());
        com.lynx.jsbridge.a.a(getContext(), r5);
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.LayerDrawable");
    L5:
        r13 = null;
        goto L6
    }

    public final void setCurrentSelectIndex(int r5) {
        this.f23113a.setCurrentItem(r5);
    }

    public final void setKeepItemView(boolean r5) {
        if (r5 == false) goto L5;
        this.f23113a.setOffscreenPageLimit(Integer.MAX_VALUE);
        return;
    L5:
        this.f23113a.setOffscreenPageLimit(1);
    }

    public final void setLynxDirection(int r10) {
        if (r10 == 2) goto L7;
        if (r10 == 2) goto L7;
        boolean r11 = false;
    L9:
        if (r11 == this.e) goto L21;
        ReversingAdapter r5 = this.f23113a.getReversingAdapter();
        int r12 = this.f23113a.getCurrentItem();
        this.e = r11;
        this.f23113a.setRTL(r11);
        if (r5 == null) goto L14;
        r5.f6524b = r11;
        r5.notifyDataSetChanged();
    L14:
        if (this.f23119k != 1) goto L18;
        LynxTabBarView r13 = this.f23114b;
        if (r13 == null) goto L19;
        r13.b(0, r12);
    L19:
        this.f23113a.setCurrentItem(r12);
        return;
    L18:
        e();
        goto L19
    L21:
        return;
    L7:
        r11 = true;
        goto L9
    }

    public final void setMChanged(boolean r5) {
        this.f = r5;
    }

    public final void setMTabBarView(LynxTabBarView r5) {
        this.f23114b = r5;
    }

    public final void setMTabLayout(TabLayout r5) {
        this.f23118j = r5;
    }

    public final void setMViewPager(BaseCustomViewPager r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f23113a = r5;
    }

    public final void setRTLMode(boolean r5) {
        this.e = r5;
    }

    public final void setSelectedIndex(int r5) {
        this.f23130w = r5;
    }

    public final void setSelectedTabIndicatorColor(String r5) {
        Intrinsics.checkNotNullParameter(r5, "color");
        if (this.f23118j != null) goto L5;
        c(null);
    L5:
        TabLayout r10 = this.f23118j;
        if (r10 == null) goto L9;
        r10.setSelectedTabIndicatorColor(com.lynx.jsbridge.a.b(r5));
        return;
    }

    public final void setSelectedTextColor(String r5) {
        Intrinsics.checkNotNullParameter(r5, "color");
        this.f23121m = com.lynx.jsbridge.a.b(r5);
        TabLayout r10 = this.f23118j;
        TabLayout.Tab r11 = null;
        if (r10 == null) goto L5;
        Integer r12 = Integer.valueOf(r10.getSelectedTabPosition());
    L6:
        if (r12 == null) goto L10;
        int r13 = r12.intValue();
        TabLayout r14 = this.f23118j;
        if (r14 == null) goto L10;
        r11 = r14.getTabAt(r13);
    L10:
        if (r11 == null) goto L17;
        View r15 = r11.getCustomView();
        if (r15 == null) goto L18;
        TextView r16 = (TextView) r15.findViewById(R.id.text1);
        if (r16 == null) goto L19;
        setSelectedTextStyle(r16);
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    L5:
        r12 = null;
        goto L6
    }

    public final void setSelectedTextSize(float r5) {
        this.f23120l = r5;
        TabLayout r10 = this.f23118j;
        TabLayout.Tab r11 = null;
        if (r10 == null) goto L5;
        Integer r12 = Integer.valueOf(r10.getSelectedTabPosition());
    L6:
        if (r12 == null) goto L10;
        int r13 = r12.intValue();
        TabLayout r14 = this.f23118j;
        if (r14 == null) goto L10;
        r11 = r14.getTabAt(r13);
    L10:
        if (r11 == null) goto L17;
        View r15 = r11.getCustomView();
        if (r15 == null) goto L18;
        TextView r16 = (TextView) r15.findViewById(R.id.text1);
        if (r16 == null) goto L19;
        setSelectedTextStyle(r16);
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    L5:
        r12 = null;
        goto L6
    }

    public final void setSelectedTextStyle(TextView r5) {
        Intrinsics.checkNotNullParameter(r5, "textView");
        if (this.f23119k == 0) goto L5;
        return;
    L5:
        r5.setTextSize(1, this.f23120l);
        if (this.f23124p == false) goto L8;
        Typeface r10 = Typeface.DEFAULT_BOLD;
    L9:
        r5.setTypeface(r10);
        r5.setTextColor(this.f23121m);
        return;
    L8:
        r10 = Typeface.DEFAULT;
        goto L9
    }

    public final void setTabBarDragEnable(boolean r5) {
    }

    public abstract void setTabBarElementAdded(boolean r5);

    public final void setTabClickListenerListener(f r5) {
        Intrinsics.checkNotNullParameter(r5, "tabClickListener");
        this.f23126r = r5;
    }

    public final void setTabIndicatorHeight(float r5) {
        GradientDrawable r10 = null;
        if (this.f23118j != null) goto L5;
        c(null);
    L5:
        TabLayout r11 = this.f23118j;
        if (r11 == null) goto L8;
        Drawable r12 = r11.getTabSelectedIndicator();
    L10:
        if ((r12 instanceof LayerDrawable) == false) goto L12;
        LayerDrawable r13 = (LayerDrawable) r12;
    L13:
        if (r13 == null) goto L15;
        Drawable r14 = r13.getDrawable(0);
    L17:
        if ((r14 instanceof GradientDrawable) == false) goto L19;
        r10 = (GradientDrawable) r14;
    L19:
        if (r10 == null) goto L21;
        r10.setSize(r10.getIntrinsicWidth(), com.lynx.jsbridge.a.a(getContext(), r5));
    L21:
        TabLayout r15 = this.f23118j;
        if (r15 == null) goto L25;
        r15.requestLayout();
        return;
    L25:
        return;
    L15:
        r14 = null;
        goto L17
    L12:
        r13 = null;
        goto L13
    L8:
        r12 = null;
        goto L10
    }

    public final void setTabIndicatorRadius(float r5) {
        GradientDrawable r10 = null;
        if (this.f23118j != null) goto L5;
        c(null);
    L5:
        TabLayout r11 = this.f23118j;
        if (r11 == null) goto L8;
        Drawable r12 = r11.getTabSelectedIndicator();
    L10:
        if ((r12 instanceof LayerDrawable) == false) goto L12;
        LayerDrawable r13 = (LayerDrawable) r12;
    L13:
        if (r13 == null) goto L15;
        Drawable r14 = r13.getDrawable(0);
    L17:
        if ((r14 instanceof GradientDrawable) == false) goto L19;
        r10 = (GradientDrawable) r14;
    L19:
        if (r10 == null) goto L22;
        r10.setCornerRadius(com.lynx.jsbridge.a.a(getContext(), r5));
    L22:
        TabLayout r15 = this.f23118j;
        if (r15 == null) goto L26;
        r15.requestLayout();
        return;
    L26:
        return;
    L15:
        r14 = null;
        goto L17
    L12:
        r13 = null;
        goto L13
    L8:
        r12 = null;
        goto L10
    }

    public final void setTabIndicatorWidth(float r5) {
        GradientDrawable r10 = null;
        if (this.f23118j != null) goto L5;
        c(null);
    L5:
        TabLayout r11 = this.f23118j;
        if (r11 == null) goto L8;
        Drawable r12 = r11.getTabSelectedIndicator();
    L10:
        if ((r12 instanceof LayerDrawable) == false) goto L12;
        LayerDrawable r13 = (LayerDrawable) r12;
    L13:
        if (r13 == null) goto L15;
        Drawable r14 = r13.getDrawable(0);
    L17:
        if ((r14 instanceof GradientDrawable) == false) goto L19;
        r10 = (GradientDrawable) r14;
    L19:
        if (r10 == null) goto L21;
        Context r15 = getContext();
        Intrinsics.checkNotNullParameter(r15, "context");
        r10.setSize((int) ((r5 / 375.0f) * r15.getResources().getDisplayMetrics().widthPixels), r10.getIntrinsicHeight());
    L21:
        TabLayout r16 = this.f23118j;
        if (r16 == null) goto L25;
        r16.requestLayout();
        return;
    L25:
        return;
    L15:
        r14 = null;
        goto L17
    L12:
        r13 = null;
        goto L13
    L8:
        r12 = null;
        goto L10
    }

    public final void setTabInterspace(float r5) {
        this.f23115c = r5 / 2;
    }

    public final void setTabLayout(LynxTabBarView r5) {
        Intrinsics.checkNotNullParameter(r5, "lynxTabBarView");
        this.f23114b = r5;
        ze.a r10 = r5.f6514b;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r10 = null;
    L5:
        c(r10);
    }

    public final void setTabLayoutUpdateListener$x_element_fold_view_release(g r5) {
        Intrinsics.checkNotNullParameter(r5, "mOnTabLayoutUpdateListener");
        this.f23127t = r5;
    }

    public final void setTabPaddingBottom(int r5) {
        com.lynx.jsbridge.a.a(getContext(), r5);
        e();
    }

    public final void setTabPaddingEnd(int r5) {
        this.f23129v = com.lynx.jsbridge.a.a(getContext(), r5);
        e();
    }

    public final void setTabPaddingStart(int r5) {
        this.f23128u = com.lynx.jsbridge.a.a(getContext(), r5);
        e();
    }

    public final void setTabPaddingTop(int r5) {
        com.lynx.jsbridge.a.a(getContext(), r5);
        e();
    }

    public final void setTabSelectedListener$x_element_fold_view_release(TabLayout.OnTabSelectedListener r5) {
        this.s = r5;
    }

    public final void setTabbarBackground(String r5) {
        Intrinsics.checkNotNullParameter(r5, "color");
        a();
        TabLayout r10 = this.f23118j;
        if (r10 == null) goto L5;
        Drawable r11 = r10.getBackground();
    L6:
        if (r11 == null) goto L14;
        Drawable r12 = ((LayerDrawable) r11).getDrawable(0);
        if (r12 == null) goto L12;
        ((GradientDrawable) r12).setColor(com.lynx.jsbridge.a.b(r5));
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.LayerDrawable");
    L5:
        r11 = null;
        goto L6
    }

    public final void setTablayoutGravity(String r10) {
        Intrinsics.checkNotNullParameter(r10, "gravity");
        Object r5 = null;
        ViewGroup.LayoutParams r11 = null;
        ViewGroup.LayoutParams r12 = null;
        if (this.f23118j != null) goto L5;
        c(null);
    L5:
        String r13 = r10.toLowerCase(Locale.ROOT);
        int r14 = r13.hashCode();
        if (r14 == (-1364013995)) goto L47;
        if (r14 == 3143043) goto L26;
        if (r14 == 3317767) goto L13;
        return;
    L13:
        if (r13.equals(OpenPageMethod.ALIGN_LEFT) == false) goto L85;
        TabLayout r15 = this.f23118j;
        if (r15 == null) goto L18;
        r11 = r15.getLayoutParams();
    L18:
        if (r11 == null) goto L21;
        r11.width = -1;
    L21:
        TabLayout r16 = this.f23118j;
        if (r16 == null) goto L81;
        r16.requestLayout();
        return;
    L81:
        return;
    L85:
        return;
    L26:
        if (r13.equals("fill") == false) goto L86;
        TabLayout r17 = this.f23118j;
        if (r17 == null) goto L32;
        r17.setTabMode(1);
    L32:
        TabLayout r18 = this.f23118j;
        if (r18 == null) goto L35;
        r12 = r18.getLayoutParams();
    L35:
        if (r12 == null) goto L38;
        r12.width = -1;
    L38:
        TabLayout r19 = this.f23118j;
        if (r19 == null) goto L42;
        r19.setTabGravity(0);
    L42:
        TabLayout r20 = this.f23118j;
        if (r20 == null) goto L82;
        r20.requestLayout();
        return;
    L82:
        return;
    L86:
        return;
    L47:
        if (r13.equals("center") == false) goto L87;
        TabLayout r21 = this.f23118j;
        if (r21 == null) goto L53;
        r21.setTabGravity(1);
    L53:
        TabLayout r22 = this.f23118j;
        if (r22 == null) goto L56;
        ViewGroup.LayoutParams r23 = r22.getLayoutParams();
    L57:
        if (r23 == null) goto L80;
        r23.width = -1;
    L80:
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L63
        TabLayout r25 = this.f23118j;     // Catch: Throwable -> L63
        if (r25 == null) goto L65;
        Field r26 = r25.getClass().getDeclaredField("slidingTabIndicator");     // Catch: Throwable -> L63
    L66:
        if (r26 == null) goto L69;
        r26.setAccessible(true);     // Catch: Throwable -> L63
    L69:
        if (r26 == null) goto L71;
        r5 = r26.get(this.f23118j);     // Catch: Throwable -> L63
    L71:
        if (r5 == null) goto L74;
        LinearLayout r27 = (LinearLayout) r5;     // Catch: Throwable -> L63
        r27.setGravity(17);     // Catch: Throwable -> L63
        r27.getLayoutParams().width = -2;     // Catch: Throwable -> L63
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L63
    L76:
        TabLayout r28 = this.f23118j;
        if (r28 == null) goto L83;
        r28.requestLayout();
        return;
    L83:
        return;
    L74:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout");     // Catch: Throwable -> L63
    L65:
        r26 = null;
    L63:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L76
    L56:
        r23 = null;
        goto L57
    }

    public final void setTextBold(String r5) {
        Intrinsics.checkNotNullParameter(r5, "boldMode");
        if (Intrinsics.areEqual(r5, "selected") == false) goto L7;
        this.f23124p = true;
        this.f23125q = false;
        return;
    L7:
        if (Intrinsics.areEqual(r5, "unselected") == false) goto L10;
        this.f23124p = false;
        this.f23125q = true;
        return;
    }

    public final void setUnSelectedTextColor(String r5) {
        Intrinsics.checkNotNullParameter(r5, "color");
        TabLayout r10 = this.f23118j;
        if (r10 == null) goto L5;
        Integer r11 = Integer.valueOf(r10.getSelectedTabPosition());
    L6:
        this.f23123o = com.lynx.jsbridge.a.b(r5);
        TabLayout r12 = this.f23118j;
        int r13 = 0;
        if (r12 == null) goto L9;
        int r14 = r12.getTabCount();
    L10:
        if (r13 >= r14) goto L26;
        if (r11 != null) goto L14;
    L15:
        TabLayout r15 = this.f23118j;
        if (r15 == null) goto L25;
        TabLayout.Tab r16 = r15.getTabAt(r13);
        if (r16 == null) goto L25;
        View r17 = r16.getCustomView();
        if (r17 == null) goto L25;
        TextView r18 = (TextView) r17.findViewById(R.id.text1);
        if (r18 == null) goto L25;
        setUnSelectedTextStyle(r18);
    L25:
        r13 = r13 + 1;
        goto L10
    L14:
        if (r11.intValue() == r13) goto L25;
    L26:
        return;
    L9:
        r14 = 0;
        goto L10
    L5:
        r11 = null;
        goto L6
    }

    public final void setUnSelectedTextSize(float r5) {
        this.f23122n = r5;
        TabLayout r10 = this.f23118j;
        if (r10 == null) goto L5;
        Integer r11 = Integer.valueOf(r10.getSelectedTabPosition());
    L6:
        TabLayout r12 = this.f23118j;
        int r13 = 0;
        if (r12 == null) goto L9;
        int r14 = r12.getTabCount();
    L10:
        if (r13 >= r14) goto L26;
        if (r11 != null) goto L14;
    L15:
        TabLayout r15 = this.f23118j;
        if (r15 == null) goto L25;
        TabLayout.Tab r16 = r15.getTabAt(r13);
        if (r16 == null) goto L25;
        View r17 = r16.getCustomView();
        if (r17 == null) goto L25;
        TextView r18 = (TextView) r17.findViewById(R.id.text1);
        if (r18 == null) goto L25;
        setUnSelectedTextStyle(r18);
    L25:
        r13 = r13 + 1;
        goto L10
    L14:
        if (r11.intValue() == r13) goto L25;
    L26:
        return;
    L9:
        r14 = 0;
        goto L10
    L5:
        r11 = null;
        goto L6
    }

    public final void setUnSelectedTextStyle(TextView r5) {
        Intrinsics.checkNotNullParameter(r5, "textView");
        if (this.f23119k == 0) goto L5;
        return;
    L5:
        r5.setTextSize(1, this.f23122n);
        if (this.f23125q == false) goto L8;
        Typeface r10 = Typeface.DEFAULT_BOLD;
    L9:
        r5.setTypeface(r10);
        r5.setTextColor(this.f23123o);
        return;
    L8:
        r10 = Typeface.DEFAULT;
        goto L9
    }
}
