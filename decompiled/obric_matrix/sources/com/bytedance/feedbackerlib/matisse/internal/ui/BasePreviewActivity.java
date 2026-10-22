package com.bytedance.feedbackerlib.matisse.internal.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.feedbackerlib.e;
import com.bytedance.feedbackerlib.f;
import com.bytedance.feedbackerlib.g;
import com.bytedance.feedbackerlib.k.f.a.d;
import com.bytedance.feedbackerlib.m.j;
import com.bytedance.feedbackerlib.matisse.internal.entity.Item;
import com.bytedance.feedbackerlib.matisse.internal.ui.adapter.PreviewPagerAdapter;
import com.bytedance.feedbackerlib.matisse.internal.ui.widget.CheckRadioView;
import com.bytedance.feedbackerlib.matisse.internal.ui.widget.CheckView;
import com.bytedance.feedbackerlib.matisse.internal.ui.widget.IncapableDialog;
import com.bytedance.sysoptimizer.BadParcelableCrashOptimizer;
import com.ttnet.org.chromium.base.TimeUtils;
import d.b.k.a.q;
import d.b.k.a.t;
import d.b.k.a.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public abstract class BasePreviewActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener, com.bytedance.feedbackerlib.k.g.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final com.bytedance.feedbackerlib.matisse.internal.model.a f4379f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected com.bytedance.feedbackerlib.matisse.internal.entity.c f4380g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected ViewPager f4381h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected PreviewPagerAdapter f4382i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected CheckView f4383j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected TextView f4384k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected TextView f4385l;
    protected TextView m;
    protected int n;
    private LinearLayout o;
    private CheckRadioView p;
    private TextView q;
    private RecyclerView r;
    private c s;
    protected boolean t;
    private LinearLayout u;
    private FrameLayout v;
    private boolean w;

    class a implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ BasePreviewActivity f4386f;

        a(BasePreviewActivity r1) {
            this.f4386f = r1;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r3) {
            BasePreviewActivity r4 = this.f4386f;
            Item r5 = r4.f4382i.b(r4.f4381h.getCurrentItem());
            if (this.f4386f.f4379f.j(r5) == false) goto L10;
            BasePreviewActivity r0 = this.f4386f;
            boolean r1 = r0.f4380g.f4350f;
            CheckView r2 = r0.f4383j;
            if (r1 == false) goto L7;
            r2.setCheckedNum(Integer.MIN_VALUE);
        L8:
            BasePreviewActivity.v(this.f4386f).g(r5);
        L15:
            BasePreviewActivity.w(this.f4386f);
            BasePreviewActivity.y(this.f4386f);
            BasePreviewActivity r6 = this.f4386f;
            com.bytedance.feedbackerlib.k.g.c r7 = r6.f4380g.r;
            if (r7 == null) goto L19;
            r7.a(r6.f4379f.d(), this.f4386f.f4379f.c());
            return;
        L19:
            return;
        L7:
            r2.setChecked(false);
            goto L8
        L10:
            if (BasePreviewActivity.x(this.f4386f, r5) == false) goto L15;
            BasePreviewActivity.v(this.f4386f).f(r5);
            BasePreviewActivity r8 = this.f4386f;
            if (r8.f4380g.f4350f == false) goto L14;
            r8.f4383j.setCheckedNum(r8.f4379f.e(r5));
            goto L15
        L14:
            r8.f4383j.setChecked(true);
            goto L15
        }
    }

    class b implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ BasePreviewActivity f4387f;

        b(BasePreviewActivity r1) {
            this.f4387f = r1;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r6) {
            int r7 = BasePreviewActivity.z(this.f4387f);
            if (r7 <= 0) goto L6;
            IncapableDialog.b("", this.f4387f.getString(g.f4039d, new Object[]{Integer.valueOf(r7), Integer.valueOf(this.f4387f.f4380g.v)})).show(this.f4387f.getSupportFragmentManager(), IncapableDialog.class.getName());
            return;
        L6:
            BasePreviewActivity r8 = this.f4387f;
            r8.t = true ^ r8.t;
            BasePreviewActivity.A(r8).setChecked(this.f4387f.t);
            BasePreviewActivity r9 = this.f4387f;
            if (r9.t == true) goto L9;
            BasePreviewActivity.A(r9).setColor(-1);
        L9:
            BasePreviewActivity r10 = this.f4387f;
            com.bytedance.feedbackerlib.k.g.a r0 = r10.f4380g.w;
            if (r0 == null) goto L12;
            r0.a(r10.t);
        L12:
            BasePreviewActivity.B(this.f4387f);
        }
    }

    class c extends RecyclerView.Adapter<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<Item> f4388a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ BasePreviewActivity f4389b;

        class a extends RecyclerView.ViewHolder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private Item f4390a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private ImageView f4391b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private TextView f4392c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private View f4393d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ c f4394e;

            /* JADX INFO: renamed from: com.bytedance.feedbackerlib.matisse.internal.ui.BasePreviewActivity$c$a$a, reason: collision with other inner class name */
            class ViewOnClickListenerC0130a implements View.OnClickListener {

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ a f4395f;

                ViewOnClickListenerC0130a(a r1, c r2) {
                    this.f4395f = r1;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View r2) {
                    if (a.a(this.f4395f) == null) goto L6;
                    a r1 = this.f4395f;
                    BasePreviewActivity r3 = r1.f4394e.f4389b;
                    r3.f4381h.setCurrentItem(r3.f4382i.getItemPosition(a.a(r1)));
                    return;
                }
            }

            public a(@NonNull c r2, View r3) {
                this.f4394e = r2;
                super(r3);
                this.f4391b = (ImageView) r3.findViewById(e.s);
                this.f4392c = (TextView) r3.findViewById(e.C0);
                this.f4393d = r3.findViewById(e.p);
                this.f4391b.setOnClickListener(new ViewOnClickListenerC0130a(this, r2));
            }

            static /* synthetic */ Item a(a r0) {
                return r0.f4390a;
            }

            public void b(Item r13) {
                this.f4390a = r13;
                ViewPager r0 = this.f4394e.f4389b.f4381h;
                if (r0 == null) goto L14;
                PreviewPagerAdapter r1 = (PreviewPagerAdapter) r0.getAdapter();
                if (r1 != null) goto L7;
                return;
            L7:
                Item r2 = r1.b(this.f4394e.f4389b.f4381h.getCurrentItem());
                if (r2 != null) goto L10;
            L12:
                this.f4391b.setPadding(0, 0, 0, 0);
                goto L14
            L10:
                if (r2.equals(this.f4390a) == false) goto L12;
                this.f4391b.setPadding(8, 8, 8, 8);
            L14:
                if (r13.f4335h == null) goto L31;
                TypedArray r3 = this.f4394e.f4389b.getTheme().obtainStyledAttributes(new int[]{com.bytedance.feedbackerlib.a.f3832a});
                r3.getDrawable(0);
                r3.recycle();
                t r4 = q.f(r13.f4335h);
                r4.a(u.f14079l);
                d.b.k.a.e.b r5 = d.b.k.a.e.i();
                r5.j(12.0f);
                r4.e(r5.i());
                r4.d("FeedbackActivity");
                r4.S(this.f4391b);
                r4.g();
                if (j.i(r13.f4335h) == false) goto L29;
                long r6 = r13.f4337j / 1000;
                long r7 = r6 / TimeUtils.SECONDS_PER_HOUR;
                long r8 = (r6 % TimeUtils.SECONDS_PER_HOUR) / 60;
                long r9 = r6 % 60;
                String r10 = "";
                if (r7 <= 0) goto L21;
                r10 = "" + r7 + "h ";
            L21:
                if (r8 <= 0) goto L24;
                r10 = r10 + r8 + "m ";
            L24:
                if (r9 <= 0) goto L27;
                r10 = r10 + r9 + "s";
            L27:
                if (TextUtils.isEmpty(r10.trim()) == true) goto L29;
                this.f4392c.setText(r10);
                this.f4392c.setVisibility(0);
            L29:
                this.f4392c.setVisibility(8);
            L31:
                if (c.d(this.f4394e).indexOf(r13) >= 0) goto L33;
            L35:
                this.f4393d.setVisibility(8);
                return;
            L33:
                if (this.f4394e.f4389b.f4379f.e(this.f4390a) > 0) goto L35;
                this.f4393d.setVisibility(0);
            }
        }

        c(BasePreviewActivity r1) {
            this.f4389b = r1;
            this.f4388a = new ArrayList();
        }

        @Proxy("getApplicationContext")
        @TargetClass(scope = Scope.ALL, value = "android.content.Context")
        public static Context c(BasePreviewActivity r2) {
            return r2.getApplicationContext();
        L4:
            e = move-exception;
            com.obric.matrix.r.c.c.g("hookGetApplicationContext", "getApplicationContext error", e);
            return com.bytedance.mpaas.app.a.a();
        }

        static /* synthetic */ List d(c r0) {
            return r0.f4388a;
        }

        public Item e(int r2) {
            if ((this.f4389b instanceof AlbumPreviewActivity) == false) goto L10;
            if (r2 >= getItemCount()) goto L12;
            Item r1 = this.f4389b.f4379f.b().get(r2);
        L8:
            return r1;
        L12:
            return null;
        L10:
            if (r2 >= this.f4388a.size()) goto L14;
            r1 = this.f4388a.get(r2);
            goto L8
        L14:
            return null;
        }

        public void f(Item r3) {
            this.f4389b.f4379f.a(r3);
            BasePreviewActivity r0 = this.f4389b;
            if ((r0 instanceof AlbumPreviewActivity) == false) goto L7;
            notifyItemInserted(r0.f4379f.f() - 1);
            int r4 = this.f4389b.f4379f.e(r3);
            if (r4 <= 0) goto L11;
            BasePreviewActivity.C(this.f4389b).scrollToPosition(r4 - 1);
            return;
        L11:
            return;
        L7:
            int r5 = this.f4388a.indexOf(r3);
            if (r5 < 0) goto L13;
            notifyItemChanged(r5);
            return;
        }

        public void g(Item r3) {
            BasePreviewActivity r0 = this.f4389b;
            boolean r1 = r0 instanceof AlbumPreviewActivity;
            com.bytedance.feedbackerlib.matisse.internal.model.a r2 = r0.f4379f;
            if (r1 == false) goto L8;
            int r4 = r2.e(r3);
            if (r4 > 0) goto L7;
            return;
        L7:
            this.f4389b.f4379f.p(r3);
            notifyItemRemoved(r4 - 1);
            return;
        L8:
            r2.p(r3);
            int r5 = this.f4388a.indexOf(r3);
            if (r5 >= 0) goto L11;
            return;
        L11:
            notifyItemChanged(r5);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            BasePreviewActivity r0 = this.f4389b;
            if ((r0 instanceof AlbumPreviewActivity) == false) goto L7;
            return r0.f4379f.f();
        L7:
            return this.f4388a.size();
        }

        public void h(Item r2) {
            int r3 = this.f4389b.f4379f.e(r2);
            if (r3 <= 0) goto L5;
            BasePreviewActivity.C(this.f4389b).scrollToPosition(r3 - 1);
        L5:
            notifyDataSetChanged();
        }

        public void i(@NonNull a r1, int r2) {
            r1.b(e(r2));
        }

        @NonNull
        public a j(@NonNull ViewGroup r4, int r5) {
            return new a(this, LayoutInflater.from(c(this.f4389b)).inflate(f.u, r4, false));
        }

        public void k(com.bytedance.feedbackerlib.matisse.internal.model.a r2) {
            this.f4388a.clear();
            this.f4388a.addAll(r2.b());
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ void onBindViewHolder(@NonNull RecyclerView.ViewHolder r1, int r2) {
            i((a) r1, r2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup r1, int r2) {
            return j(r1, r2);
        }
    }

    public BasePreviewActivity() {
        this.f4379f = new com.bytedance.feedbackerlib.matisse.internal.model.a(this);
        this.n = -1;
        this.s = new c(this);
        this.w = false;
    }

    static /* synthetic */ CheckRadioView A(BasePreviewActivity r0) {
        return r0.p;
    }

    static /* synthetic */ void B(BasePreviewActivity r0) {
        r0.I();
    }

    static /* synthetic */ RecyclerView C(BasePreviewActivity r0) {
        return r0.r;
    }

    private boolean D(Item r2) {
        com.bytedance.feedbackerlib.matisse.internal.entity.b r3 = this.f4379f.i(r2);
        com.bytedance.feedbackerlib.matisse.internal.entity.b.a(this, r3);
        if (r3 != null) goto L5;
        return true;
    L5:
        return false;
    }

    private int E() {
        int r0 = this.f4379f.f();
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L10;
        Item r3 = this.f4379f.b().get(r1);
        if (r3.f() == false) goto L9;
        if (d.d(r3.f4336i) <= this.f4380g.v) goto L9;
        r2 = r2 + 1;
    L9:
        r1 = r1 + 1;
        goto L3
    L10:
        return r2;
    }

    private void F() {
        if ((this instanceof AlbumPreviewActivity) == true) goto L5;
    L8:
        this.r.setVisibility(0);
        return;
    L5:
        if (this.f4379f.f() > 0) goto L8;
        this.r.setVisibility(8);
    }

    private void H() {
        com.bytedance.feedbackerlib.j.e r0 = com.bytedance.feedbackerlib.j.e.e();
        int r1 = this.f4379f.f();
        if (r1 != 0) goto L7;
        this.f4385l.setText(r0.g("complete"));
        this.f4385l.setEnabled(false);
        TextView r2 = this.f4385l;
        int r3 = com.bytedance.feedbackerlib.d.f4004f;
    L5:
        r2.setBackgroundResource(r3);
        if (this.f4380g.s == false) goto L16;
        this.o.setVisibility(0);
        I();
        return;
    L16:
        this.o.setVisibility(8);
        return;
    L7:
        if (r1 == 1) goto L9;
    L11:
        this.f4385l.setEnabled(true);
        this.f4385l.setText(r0.g("complete") + " (" + r1 + ")");
    L12:
        r2 = this.f4385l;
        r3 = com.bytedance.feedbackerlib.d.f4003e;
        goto L5
    L9:
        if (this.f4380g.h() == false) goto L11;
        this.f4385l.setText(r0.g("complete"));
        this.f4385l.setEnabled(true);
        goto L12
    }

    private void I() {
        this.p.setChecked(this.t);
        if (this.t == true) goto L6;
        this.p.setColor(-1);
    L6:
        if (E() > 0) goto L8;
    L10:
        ArrayList<Item> r0 = this.f4379f.b();
        if (r0 == null) goto L16;
        Iterator<Item> r1 = r0.iterator();
        long r3 = 0;
    L14:
        if (r1.hasNext() == false) goto L17;
        r3 = r3 + r1.next().f4336i;
    L17:
        com.bytedance.feedbackerlib.j.e r2 = com.bytedance.feedbackerlib.j.e.e();
        if (r3 > 0) goto L20;
    L22:
        TextView r7 = this.q;
        String r4 = r2.g("fll_image");
    L23:
        r7.setText(r4);
        return;
    L20:
        if (this.t == false) goto L22;
        float r5 = d.d(r3);
        r7 = this.q;
        r4 = r2.g("fll_image") + "(" + r5 + "M)";
        goto L23
    L16:
        r3 = 0;
        goto L17
    L8:
        if (this.t == false) goto L10;
        IncapableDialog.b("", getString(g.f4040e, new Object[]{Integer.valueOf(this.f4380g.v)})).show(getSupportFragmentManager(), IncapableDialog.class.getName());
        this.p.setChecked(false);
        this.p.setColor(-1);
        this.t = false;
        goto L10
    }

    @Proxy("getBundleExtra")
    @TargetClass("android.content.Intent")
    public static Bundle u(Intent r0, String r1) {
        Bundle r2 = r0.getBundleExtra(r1);
        Context r3 = BadParcelableCrashOptimizer.getContext();
        if (r2 == null) goto L6;
        if (r3 == null) goto L6;
        r2.setClassLoader(r3.getClassLoader());
    L6:
        return r2;
    }

    static /* synthetic */ c v(BasePreviewActivity r0) {
        return r0.s;
    }

    static /* synthetic */ void w(BasePreviewActivity r0) {
        r0.F();
    }

    static /* synthetic */ boolean x(BasePreviewActivity r0, Item r1) {
        return r0.D(r1);
    }

    static /* synthetic */ void y(BasePreviewActivity r0) {
        r0.H();
    }

    static /* synthetic */ int z(BasePreviewActivity r0) {
        return r0.E();
    }

    protected void G(boolean r4) {
        Intent r0 = new Intent();
        r0.putExtra("extra_result_bundle", this.f4379f.h());
        r0.putExtra("extra_result_apply", r4);
        r0.putExtra("extra_result_original_enable", this.t);
        setResult(-1, r0);
    }

    protected void J(Item r7) {
        if (r7.e() == false) goto L5;
        this.m.setVisibility(0);
        this.m.setText(d.d(r7.f4336i) + "M");
    L7:
        if (r7.g() == false) goto L10;
        this.o.setVisibility(8);
        return;
    L10:
        if (this.f4380g.s == false) goto L14;
        this.o.setVisibility(0);
        return;
    L14:
        return;
    L5:
        this.m.setVisibility(8);
        goto L7
    }

    @Override // com.bytedance.feedbackerlib.k.g.b
    public void a() {
        if (this.f4380g.u == true) goto L6;
        return;
    L6:
        if (this.w == false) goto L8;
        this.v.animate().setInterpolator(new FastOutSlowInInterpolator()).translationYBy(this.v.getMeasuredHeight()).start();
        ViewPropertyAnimator r0 = this.u.animate().translationYBy(-this.u.getMeasuredHeight()).setInterpolator(new FastOutSlowInInterpolator());
    L9:
        r0.start();
        this.w = !this.w;
        return;
    L8:
        this.v.animate().setInterpolator(new FastOutSlowInInterpolator()).translationYBy(-this.v.getMeasuredHeight()).start();
        r0 = this.u.animate().setInterpolator(new FastOutSlowInInterpolator()).translationYBy(this.u.getMeasuredHeight());
        goto L9
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        G(false);
        super.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r3) {
        if (r3.getId() != e.f4017f) goto L6;
        onBackPressed();
        return;
    L6:
        if (r3.getId() != e.f4016e) goto L10;
        G(true);
        finish();
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(@Nullable Bundle r4) {
        setTheme(com.bytedance.feedbackerlib.matisse.internal.entity.c.b().f4348d);
        super.onCreate(r4);
        if (com.bytedance.feedbackerlib.matisse.internal.entity.c.b().q == true) goto L6;
        setResult(0);
        finish();
        return;
    L6:
        setContentView(f.f4034k);
        if (com.bytedance.feedbackerlib.k.f.a.e.b() == false) goto L9;
        getWindow().addFlags(67108864);
    L9:
        com.bytedance.feedbackerlib.matisse.internal.entity.c r0 = com.bytedance.feedbackerlib.matisse.internal.entity.c.b();
        this.f4380g = r0;
        if (r0.c() == false) goto L12;
        setRequestedOrientation(this.f4380g.f4349e);
    L12:
        if (r4 != null) goto L14;
        this.f4379f.l(u(getIntent(), "extra_default_bundle"));
        boolean r5 = getIntent().getBooleanExtra("extra_result_original_enable", false);
    L15:
        this.t = r5;
        this.f4384k = (TextView) findViewById(e.f4017f);
        this.f4385l = (TextView) findViewById(e.f4016e);
        this.q = (TextView) findViewById(e.O0);
        this.m = (TextView) findViewById(e.j0);
        this.f4384k.setOnClickListener(this);
        this.f4385l.setOnClickListener(this);
        ViewPager r6 = (ViewPager) findViewById(e.T);
        this.f4381h = r6;
        r6.addOnPageChangeListener(this);
        PreviewPagerAdapter r7 = new PreviewPagerAdapter(getSupportFragmentManager(), null);
        this.f4382i = r7;
        this.f4381h.setAdapter(r7);
        CheckView r8 = (CheckView) findViewById(e.f4019h);
        this.f4383j = r8;
        r8.setCountable(this.f4380g.f4350f);
        this.u = (LinearLayout) findViewById(e.f4015d);
        this.v = (FrameLayout) findViewById(e.n0);
        this.f4383j.setOnClickListener(new a(this));
        RecyclerView r9 = (RecyclerView) findViewById(e.V);
        this.r = r9;
        r9.setLayoutManager(new LinearLayoutManager(this, 0, false));
        this.r.setAdapter(this.s);
        F();
        this.s.k(this.f4379f);
        this.o = (LinearLayout) findViewById(e.S);
        this.p = (CheckRadioView) findViewById(e.R);
        this.o.setOnClickListener(new b(this));
        H();
        return;
    L14:
        this.f4379f.l(r4);
        r5 = r4.getBoolean("checkState");
        goto L15
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int r1) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int r1, float r2, int r3) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int r6) {
        PreviewPagerAdapter r0 = (PreviewPagerAdapter) this.f4381h.getAdapter();
        int r1 = this.n;
        if (r1 == (-1)) goto L16;
        if (r1 == r6) goto L16;
        ((PreviewItemFragment) r0.instantiateItem(this.f4381h, r1)).d();
        Item r2 = r0.b(r6);
        boolean r3 = true;
        if (this.f4380g.f4350f == false) goto L10;
        int r4 = this.f4379f.e(r2);
        this.f4383j.setCheckedNum(r4);
        if (r4 > 0) goto L12;
    L14:
        CheckView r5 = this.f4383j;
        r3 = true ^ this.f4379f.k();
    L13:
        r5.setEnabled(r3);
        J(r2);
    L12:
        r5 = this.f4383j;
        goto L13
    L10:
        boolean r7 = this.f4379f.j(r2);
        this.f4383j.setChecked(r7);
        if (r7 == false) goto L14;
    L16:
        this.n = r6;
        Item r8 = r0.b(r6);
        if (r8 == null) goto L19;
        this.s.h(r8);
    L19:
        F();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle r3) {
        this.f4379f.m(r3);
        r3.putBoolean("checkState", this.t);
        super.onSaveInstanceState(r3);
    }
}
