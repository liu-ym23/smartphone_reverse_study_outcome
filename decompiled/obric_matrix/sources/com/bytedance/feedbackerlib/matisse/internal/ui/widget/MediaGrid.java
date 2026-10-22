package com.bytedance.feedbackerlib.matisse.internal.ui.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.feedbackerlib.e;
import com.bytedance.feedbackerlib.f;
import com.bytedance.feedbackerlib.matisse.internal.entity.Item;
import com.bytedance.feedbackerlib.matisse.internal.entity.c;
import com.ttnet.org.chromium.base.TimeUtils;

/* JADX INFO: loaded from: classes.dex */
public class MediaGrid extends SquareFrameLayout implements View.OnClickListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ImageView f4431f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private CheckView f4432g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ImageView f4433h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private TextView f4434i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private View f4435j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Item f4436k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private b f4437l;
    private a m;

    public interface a {
        void a(CheckView r1, Item r2, RecyclerView.ViewHolder r3);

        void b(ImageView r1, Item r2, RecyclerView.ViewHolder r3);
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f4438a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Drawable f4439b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f4440c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        RecyclerView.ViewHolder f4441d;

        public b(int r1, Drawable r2, boolean r3, RecyclerView.ViewHolder r4) {
            this.f4438a = r1;
            this.f4439b = r2;
            this.f4440c = r3;
            this.f4441d = r4;
        }
    }

    public MediaGrid(Context r1, AttributeSet r2) {
        super(r1, r2);
        c(r1);
    }

    private void c(Context r3) {
        LayoutInflater.from(r3).inflate(f.p, this, true);
        this.f4431f = (ImageView) findViewById(e.P);
        this.f4432g = (CheckView) findViewById(e.f4019h);
        this.f4433h = (ImageView) findViewById(e.q);
        this.f4434i = (TextView) findViewById(e.k1);
        this.f4435j = findViewById(e.o);
        this.f4431f.setOnClickListener(this);
        this.f4432g.setOnClickListener(this);
    }

    private void d() {
        this.f4432g.setCountable(this.f4437l.f4440c);
    }

    private void f() {
        ImageView r0 = this.f4433h;
        if (this.f4436k.e() == false) goto L5;
        int r1 = 0;
    L6:
        r0.setVisibility(r1);
        return;
    L5:
        r1 = 8;
        goto L6
    }

    private void g() {
        if (this.f4436k.e() == false) goto L5;
        com.bytedance.feedbackerlib.k.d.a r1 = c.b().p;
        Context r2 = getContext();
        b r0 = this.f4437l;
        r1.c(r2, r0.f4438a, r0.f4439b, this.f4431f, this.f4436k.b());
        return;
    L5:
        com.bytedance.feedbackerlib.k.d.a r3 = c.b().p;
        Context r4 = getContext();
        b r5 = this.f4437l;
        r3.b(r4, r5.f4438a, r5.f4439b, this.f4431f, this.f4436k.b());
    }

    private void h() {
        if (this.f4436k.g() == false) goto L15;
        this.f4434i.setVisibility(0);
        long r2 = this.f4436k.f4337j / 1000;
        long r6 = r2 / TimeUtils.SECONDS_PER_HOUR;
        long r4 = (r2 % TimeUtils.SECONDS_PER_HOUR) / 60;
        long r3 = r2 % 60;
        String r0 = "";
        if (r6 <= 0) goto L8;
        r0 = "" + r6 + "h ";
    L8:
        if (r4 <= 0) goto L11;
        r0 = r0 + r4 + "m ";
    L11:
        if (r3 <= 0) goto L13;
        r0 = r0 + r3 + "s";
    L13:
        this.f4434i.setText(r0);
        if (TextUtils.isEmpty(r0.trim()) == true) goto L15;
        return;
    L15:
        this.f4434i.setVisibility(8);
    }

    public void a(Item r1) {
        this.f4436k = r1;
        f();
        d();
        g();
        h();
    }

    public void b() {
        this.f4435j.setVisibility(8);
    }

    public void e(b r1) {
        this.f4437l = r1;
    }

    public Item getMedia() {
        return this.f4436k;
    }

    public void i() {
        this.f4435j.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r3) {
        a r0 = this.m;
        if (r0 == null) goto L11;
        ImageView r1 = this.f4431f;
        if (r3 != r1) goto L7;
        r0.b(r1, this.f4436k, this.f4437l.f4441d);
        return;
    L7:
        CheckView r2 = this.f4432g;
        if (r3 != r2) goto L13;
        r0.a(r2, this.f4436k, this.f4437l.f4441d);
        return;
    L13:
        return;
    }

    public void setCheckEnabled(boolean r1) {
        this.f4432g.setEnabled(r1);
    }

    public void setChecked(boolean r1) {
        this.f4432g.setChecked(r1);
    }

    public void setCheckedNum(int r1) {
        this.f4432g.setCheckedNum(r1);
    }

    public void setOnMediaGridClickListener(a r1) {
        this.m = r1;
    }
}
