package com.obric.oui.calendar;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import com.obric.oui.calendar.e;
import com.ttnet.org.chromium.net.NetError;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.threeten.bp.LocalDate;

/* JADX INFO: loaded from: classes2.dex */
abstract class d<V extends e> extends PagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayDeque<V> f10875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final MaterialCalendarView f10876b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CalendarDay f10877c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    private com.obric.oui.calendar.v.g f10878d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Integer f10879e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Integer f10880f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Integer f10881g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f10882h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private CalendarDay f10883i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private CalendarDay f10884j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private f f10885k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private List<CalendarDay> f10886l;
    private com.obric.oui.calendar.v.h m;
    private com.obric.oui.calendar.v.e n;
    private com.obric.oui.calendar.v.e o;
    private List<h> p;
    private List<j> q;
    private boolean r;
    boolean s;

    d(MaterialCalendarView r3) {
        this.f10878d = com.obric.oui.calendar.v.g.f10931a;
        this.f10879e = null;
        this.f10880f = null;
        this.f10881g = null;
        this.f10882h = 4;
        this.f10883i = null;
        this.f10884j = null;
        this.f10886l = new ArrayList();
        this.m = com.obric.oui.calendar.v.h.f10932a;
        com.obric.oui.calendar.v.e r1 = com.obric.oui.calendar.v.e.f10929a;
        this.n = r1;
        this.o = r1;
        this.p = new ArrayList();
        this.q = null;
        this.r = true;
        this.f10876b = r3;
        this.f10877c = CalendarDay.q();
        ArrayDeque<V> r4 = new ArrayDeque();
        this.f10875a = r4;
        r4.iterator();
        u(null, null);
    }

    private void C() {
        int r0 = 0;
    L4:
        if (r0 >= this.f10886l.size()) goto L15;
        CalendarDay r1 = this.f10886l.get(r0);
        CalendarDay r2 = this.f10883i;
        if (r2 != null) goto L8;
    L9:
        CalendarDay r3 = this.f10884j;
        if (r3 == null) goto L14;
        if (r3.l(r1) == false) goto L14;
    L13:
        this.f10886l.remove(r0);
        this.f10876b.E(r1);
        r0 = r0 - 1;
    L14:
        r0 = r0 + 1;
        goto L4
    L8:
        if (r2.j(r1) == true) goto L13;
    }

    private void m() {
        C();
        Iterator<V> r0 = this.f10875a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().r(this.f10886l);
        goto L4
    }

    public void A(com.obric.oui.calendar.v.h r2) {
        this.m = r2;
        Iterator<V> r1 = this.f10875a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().v(r2);
        goto L4
    }

    public void B(int r2) {
        if (r2 != 0) goto L4;
        return;
    L4:
        this.f10881g = Integer.valueOf(r2);
        Iterator<V> r1 = this.f10875a.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        r1.next().w(r2);
        goto L6
    }

    public void a() {
        this.f10886l.clear();
        m();
    }

    protected abstract f b(CalendarDay r1, CalendarDay r2);

    protected abstract V c(int r1);

    protected int d() {
        Integer r0 = this.f10880f;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.intValue();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NonNull ViewGroup r1, int r2, @NonNull Object r3) {
        e r4 = (e) r3;
        this.f10875a.remove(r4);
        r1.removeView(r4);
    }

    public int e(CalendarDay r2) {
        if (r2 == null) goto L4;
        CalendarDay r0 = this.f10883i;
        if (r0 != null) goto L8;
    L11:
        CalendarDay r1 = this.f10884j;
        if (r1 == null) goto L18;
        if (r2.j(r1) == false) goto L18;
        return getCount() - 1;
    L18:
        return this.f10885k.a(r2);
    L8:
        if (r2.l(r0) == false) goto L11;
        return 0;
    L4:
        return getCount() / 2;
    }

    public CalendarDay f(int r1) {
        return this.f10885k.getItem(r1);
    }

    public f g() {
        return this.f10885k;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f10885k.getCount();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NonNull Object r3) {
        if (n(r3) == true) goto L5;
        return -2;
    L5:
        e r4 = (e) r3;
        if (r4.g() != null) goto L8;
        return -2;
    L8:
        int r2 = k(r4);
        if (r2 >= 0) goto L11;
        return -2;
    L11:
        return r2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int r2) {
        return this.f10878d.a(f(r2));
    }

    @NonNull
    public List<CalendarDay> h() {
        return Collections.unmodifiableList(this.f10886l);
    }

    public int i() {
        return this.f10882h;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(@NonNull ViewGroup r2, int r3) {
        e r4 = c(r3);
        r4.setContentDescription(this.f10876b.getCalendarContentDescription());
        r4.setAlpha(0.0f);
        r4.t(this.r);
        r4.v(this.m);
        r4.m(this.n);
        r4.n(this.o);
        Integer r0 = this.f10879e;
        if (r0 == null) goto L5;
        r4.s(r0.intValue());
    L5:
        Integer r1 = this.f10880f;
        if (r1 == null) goto L8;
        r4.l(r1.intValue());
    L8:
        Integer r5 = this.f10881g;
        if (r5 == null) goto L11;
        r4.w(r5.intValue());
    L11:
        r4.u(this.f10882h);
        r4.q(this.f10883i);
        r4.p(this.f10884j);
        r4.r(this.f10886l);
        r2.addView(r4);
        this.f10875a.add((V) r4);
        r4.o(this.q);
        return r4;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View r1, @NonNull Object r2) {
        if (r1 != r2) goto L4;
        return true;
    L4:
        return false;
    }

    protected int j() {
        Integer r0 = this.f10881g;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.intValue();
    }

    protected abstract int k(V r1);

    public void l() {
        this.q = new ArrayList();
        Iterator<h> r0 = this.p.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        h r1 = r0.next();
        i r2 = new i();
        r1.b(r2);
        if (r2.f() == false) goto L4;
        this.q.add(new j(r1, r2));
        goto L4
    L8:
        Iterator<V> r3 = this.f10875a.iterator();
    L10:
        if (r3.hasNext() == false) goto L12;
        r3.next().o(this.q);
        goto L10
    }

    protected abstract boolean n(Object r1);

    public d<?> o(d<?> r2) {
        r2.f10878d = this.f10878d;
        r2.f10879e = this.f10879e;
        r2.f10880f = this.f10880f;
        r2.f10881g = this.f10881g;
        r2.f10882h = this.f10882h;
        r2.f10883i = this.f10883i;
        r2.f10884j = this.f10884j;
        r2.f10886l = this.f10886l;
        r2.m = this.m;
        r2.n = this.n;
        r2.o = this.o;
        r2.p = this.p;
        r2.q = this.q;
        r2.r = this.r;
        return r2;
    }

    public void p(CalendarDay r3, CalendarDay r4) {
        this.f10886l.clear();
        LocalDate r5 = LocalDate.of(r3.h(), r3.g(), r3.f());
        LocalDate r6 = r4.e();
    L4:
        if (r5.isBefore(r6) == true) goto L10;
        if (r5.equals(r6) == true) goto L10;
        m();
        return;
    L10:
        this.f10886l.add(CalendarDay.d(r5));
        r5 = r5.plusDays(1);
        goto L4
    }

    public void q(CalendarDay r1, boolean r2) {
        if (r2 == false) goto L7;
        if (this.f10886l.contains(r1) == true) goto L11;
        this.f10886l.add(r1);
    L9:
        m();
        return;
    L11:
        return;
    L7:
        if (this.f10886l.contains(r1) == false) goto L12;
        this.f10886l.remove(r1);
        goto L9
    }

    public void r(int r2) {
        if (r2 != 0) goto L4;
        return;
    L4:
        this.f10880f = Integer.valueOf(r2);
        Iterator<V> r1 = this.f10875a.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        r1.next().l(r2);
        goto L6
    }

    public void s(com.obric.oui.calendar.v.e r3) {
        com.obric.oui.calendar.v.e r0 = this.o;
        if (r0 != this.n) goto L5;
        r0 = r3;
    L5:
        this.o = r0;
        this.n = r3;
        Iterator<V> r2 = this.f10875a.iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        r2.next().m(r3);
        goto L7
    }

    public void t(com.obric.oui.calendar.v.e r2) {
        this.o = r2;
        Iterator<V> r1 = this.f10875a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().n(r2);
        goto L4
    }

    public void u(CalendarDay r3, CalendarDay r4) {
        this.f10883i = r3;
        this.f10884j = r4;
        Iterator<V> r0 = this.f10875a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        V r1 = r0.next();
        r1.q(r3);
        r1.p(r4);
        goto L4
    L6:
        if (r3 != null) goto L8;
        r3 = CalendarDay.b(this.f10877c.h() + NetError.ERR_CERT_COMMON_NAME_INVALID, this.f10877c.g(), this.f10877c.f());
    L8:
        if (r4 != null) goto L10;
        r4 = CalendarDay.b(this.f10877c.h() + 200, this.f10877c.g(), this.f10877c.f());
    L10:
        this.f10885k = b(r3, r4);
        notifyDataSetChanged();
        m();
    }

    public void v(int r2) {
        this.f10879e = Integer.valueOf(r2);
        Iterator<V> r1 = this.f10875a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().s(r2);
        goto L4
    }

    public void w(boolean r3) {
        this.r = r3;
        Iterator<V> r4 = this.f10875a.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r4.next().t(this.r);
        goto L4
    }

    public void x(int r2) {
        this.f10882h = r2;
        Iterator<V> r1 = this.f10875a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().u(r2);
        goto L4
    }

    public void y(boolean r1) {
        this.s = r1;
    }

    public void z(@Nullable com.obric.oui.calendar.v.g r1) {
        if (r1 != null) goto L4;
        r1 = com.obric.oui.calendar.v.g.f10931a;
    L4:
        this.f10878d = r1;
    }
}
