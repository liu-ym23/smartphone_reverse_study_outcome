package d.b.s.a.t;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.annotation.NonNull;
import d.b.s.a.k;
import d.b.s.a.l;
import d.b.s.a.m;
import d.b.s.a.o;

/* JADX INFO: loaded from: classes.dex */
public class d extends Dialog {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private c f14929f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f14930g;

    class a implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f14931f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ d f14932g;

        a(d r1, View.OnClickListener r2) {
            this.f14932g = r1;
            this.f14931f = r2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r2) {
            d.a(this.f14932g);
            View.OnClickListener r1 = this.f14931f;
            if (r1 == null) goto L6;
            r1.onClick(r2);
            return;
        }
    }

    class b implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f14933f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ d f14934g;

        b(d r1, View.OnClickListener r2) {
            this.f14934g = r1;
            this.f14933f = r2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r2) {
            d.a(this.f14934g);
            View.OnClickListener r1 = this.f14933f;
            if (r1 == null) goto L6;
            r1.onClick(r2);
            return;
        }
    }

    public d(@NonNull Context r2) {
        super(r2, o.f14875a);
        this.f14930g = false;
    }

    static /* synthetic */ void a(d r0) {
        r0.b();
    }

    private void b() {
        this.f14930g = true;
        dismiss();
    }

    public void c(c r1) {
        this.f14929f = r1;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        if (this.f14930g == true) goto L10;
        c r0 = this.f14929f;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.c() == null) goto L12;
        this.f14929f.c().onClick(null);
        return;
    L12:
        return;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle r10) {
        super.onCreate(r10);
        View r11 = LayoutInflater.from(getContext()).inflate(m.f14866a, null);
        TextView r0 = (TextView) r11.findViewById(l.f14845f);
        TextView r1 = (TextView) r11.findViewById(l.f14844e);
        r11.findViewById(l.f14846g);
        r11.findViewById(l.f14840a);
        TextView r2 = (TextView) r11.findViewById(l.f14842c);
        TextView r3 = (TextView) r11.findViewById(l.f14843d);
        View r4 = r11.findViewById(l.f14841b);
        int r5 = getContext().getResources().getColor(k.f14826a);
        int r6 = getContext().getResources().getColor(k.f14827b);
        if (TextUtils.isEmpty(this.f14929f.e()) == false) goto L5;
        r0.setVisibility(8);
    L7:
        if (TextUtils.isEmpty(this.f14929f.b()) == false) goto L9;
        r1.setVisibility(8);
    L10:
        d.b.s.a.t.a r7 = this.f14929f.a();
        d.b.s.a.t.a r8 = this.f14929f.d();
        if (r7 != null) goto L13;
    L15:
        if (r8 != null) goto L17;
    L19:
        setCanceledOnTouchOutside(this.f14929f.f());
        setContentView(r11);
        return;
    L17:
        if (TextUtils.isEmpty(r8.b()) == true) goto L19;
        r3.setVisibility(0);
        r3.setText(r8.b());
        r3.setTextColor(r6);
        r3.setOnClickListener(new b(this, r8.a()));
        goto L19
    L13:
        if (TextUtils.isEmpty(r7.b()) == true) goto L15;
        r4.setVisibility(0);
        r2.setVisibility(0);
        r2.setText(r7.b());
        r2.setTextColor(r5);
        r2.setOnClickListener(new a(this, r7.a()));
        goto L15
    L9:
        r1.setText(this.f14929f.b());
        r1.setTextColor(r5);
        goto L10
    L5:
        r0.setText(this.f14929f.e());
        r0.setTextColor(r5);
        goto L7
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        Window r0 = getWindow();
        if (r0 == null) goto L6;
        r0.setLayout((int) (((double) getContext().getResources().getDisplayMetrics().widthPixels) * 0.73d), -2);
        return;
    }
}
