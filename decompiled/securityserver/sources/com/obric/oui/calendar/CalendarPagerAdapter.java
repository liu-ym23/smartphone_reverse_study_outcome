package com.obric.oui.calendar;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.obric.oui.calendar.CalendarPagerView;
import com.obric.oui.calendar.format.DateFormatDayFormatter;
import com.obric.oui.calendar.format.DayFormatter;
import com.obric.oui.calendar.format.TitleFormatter;
import com.obric.oui.calendar.format.WeekDayFormatter;
import com.ttnet.org.chromium.net.NetError;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.threeten.bp.LocalDate;

/* JADX INFO: loaded from: classes2.dex */
abstract class CalendarPagerAdapter<V extends CalendarPagerView> extends PagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayDeque f177a;
    public final MaterialCalendarView b;
    public final CalendarDay c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TitleFormatter f178d;
    public Integer e;
    public Integer f;
    public Integer g;
    public int h;
    public CalendarDay i;
    public CalendarDay j;
    public DateRangeIndex k;
    public List l;
    public WeekDayFormatter m;
    public DayFormatter n;
    public DayFormatter o;
    public List p;
    public List q;
    public boolean r;
    public boolean s;

    public CalendarPagerAdapter(MaterialCalendarView r3) {
        this.f178d = TitleFormatter.f193a;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = 4;
        this.i = null;
        this.j = null;
        this.l = new ArrayList();
        this.m = WeekDayFormatter.f194a;
        DateFormatDayFormatter r1 = DayFormatter.f192a;
        this.n = r1;
        this.o = r1;
        this.p = new ArrayList();
        this.q = null;
        this.r = true;
        this.b = r3;
        this.c = CalendarDay.h();
        ArrayDeque r4 = new ArrayDeque();
        this.f177a = r4;
        r4.iterator();
        t(null, null);
    }

    public void A(int r2) {
        if (r2 != 0) goto L4;
        return;
    L4:
        this.g = Integer.valueOf(r2);
        Iterator r1 = this.f177a.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        ((CalendarPagerView) r1.next()).p(r2);
        goto L6
    }

    public void a() {
        this.l.clear();
        l();
    }

    public abstract DateRangeIndex b(CalendarDay r1, CalendarDay r2);

    public abstract CalendarPagerView c(int r1);

    public final int d() {
        Integer r0 = this.f;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.intValue();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup r1, int r2, Object r3) {
        CalendarPagerView r4 = (CalendarPagerView) r3;
        this.f177a.remove(r4);
        r1.removeView(r4);
    }

    public int e(CalendarDay r2) {
        if (r2 == null) goto L4;
        CalendarDay r0 = this.i;
        if (r0 != null) goto L8;
    L11:
        CalendarDay r1 = this.j;
        if (r1 == null) goto L18;
        if (r2.f(r1) == false) goto L18;
        return getCount() - 1;
    L18:
        return this.k.a(r2);
    L8:
        if (r2.g(r0) == false) goto L11;
        return 0;
    L4:
        return getCount() / 2;
    }

    public CalendarDay f(int r1) {
        return this.k.getItem(r1);
    }

    public List g() {
        return Collections.unmodifiableList(this.l);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.k.getCount();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object r3) {
        if (m(r3) == true) goto L5;
        return -2;
    L5:
        CalendarPagerView r4 = (CalendarPagerView) r3;
        if (r4.j != null) goto L8;
        return -2;
    L8:
        int r2 = j(r4);
        if (r2 >= 0) goto L11;
        return -2;
    L11:
        return r2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int r2) {
        return this.f178d.a(f(r2));
    }

    public int h() {
        return this.h;
    }

    public final int i() {
        Integer r0 = this.g;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.intValue();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup r2, int r3) {
        CalendarPagerView r4 = c(r3);
        r4.setContentDescription(this.b.getCalendarContentDescription());
        r4.setAlpha(0.0f);
        r4.m(this.r);
        r4.o(this.m);
        r4.h(this.n);
        r4.i(this.o);
        Integer r0 = this.e;
        if (r0 == null) goto L5;
        r4.l(r0.intValue());
    L5:
        Integer r1 = this.f;
        if (r1 == null) goto L8;
        r4.g(r1.intValue());
    L8:
        Integer r5 = this.g;
        if (r5 == null) goto L11;
        r4.p(r5.intValue());
    L11:
        r4.n(this.h);
        r4.k = this.i;
        r4.q();
        r4.l = this.j;
        r4.q();
        r4.k(this.l);
        r2.addView(r4);
        this.f177a.add(r4);
        r4.j(this.q);
        return r4;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View r1, Object r2) {
        if (r1 != r2) goto L4;
        return true;
    L4:
        return false;
    }

    public abstract int j(CalendarPagerView r1);

    public void k() {
        this.q = new ArrayList();
        Iterator r0 = this.p.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        DayViewDecorator r1 = (DayViewDecorator) r0.next();
        DayViewFacade r2 = new DayViewFacade();
        r1.a();
        if (r2.f179a == false) goto L4;
        this.q.add(new DecoratorResult(r1, r2));
        goto L4
    L8:
        Iterator r3 = this.f177a.iterator();
    L10:
        if (r3.hasNext() == false) goto L12;
        ((CalendarPagerView) r3.next()).j(this.q);
        goto L10
    }

    public final void l() {
        int r1 = 0;
    L4:
        if (r1 >= this.l.size()) goto L15;
        CalendarDay r2 = (CalendarDay) this.l.get(r1);
        CalendarDay r3 = this.i;
        if (r3 != null) goto L8;
    L9:
        CalendarDay r4 = this.j;
        if (r4 == null) goto L14;
        if (r4.g(r2) == false) goto L14;
    L13:
        this.l.remove(r1);
        this.b.c(r2, false);
        r1 = r1 - 1;
    L14:
        r1 = r1 + 1;
        goto L4
    L8:
        if (r3.f(r2) == true) goto L13;
    L15:
        Iterator r0 = this.f177a.iterator();
    L17:
        if (r0.hasNext() == false) goto L19;
        ((CalendarPagerView) r0.next()).k(this.l);
        goto L17
    }

    public abstract boolean m(Object r1);

    public CalendarPagerAdapter n(CalendarPagerAdapter r2) {
        r2.f178d = this.f178d;
        r2.e = this.e;
        r2.f = this.f;
        r2.g = this.g;
        r2.h = this.h;
        r2.i = this.i;
        r2.j = this.j;
        r2.l = this.l;
        r2.m = this.m;
        r2.n = this.n;
        r2.o = this.o;
        r2.p = this.p;
        r2.q = this.q;
        r2.r = this.r;
        return r2;
    }

    public void o(CalendarDay r3, CalendarDay r4) {
        this.l.clear();
        LocalDate r5 = LocalDate.of(r3.e(), r3.d(), r3.c());
        LocalDate r6 = r4.b();
    L4:
        if (r5.isBefore(r6) == true) goto L10;
        if (r5.equals(r6) == true) goto L10;
        l();
        return;
    L10:
        this.l.add(CalendarDay.a(r5));
        r5 = r5.plusDays(1);
        goto L4
    }

    public void p(CalendarDay r1, boolean r2) {
        if (r2 == false) goto L7;
        if (this.l.contains(r1) == true) goto L10;
        this.l.add(r1);
        l();
        return;
    L10:
        return;
    L7:
        if (this.l.contains(r1) == false) goto L12;
        this.l.remove(r1);
        l();
        return;
    }

    public void q(int r2) {
        if (r2 != 0) goto L4;
        return;
    L4:
        this.f = Integer.valueOf(r2);
        Iterator r1 = this.f177a.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        ((CalendarPagerView) r1.next()).g(r2);
        goto L6
    }

    public void r(DayFormatter r3) {
        DayFormatter r0 = this.o;
        if (r0 != this.n) goto L5;
        r0 = r3;
    L5:
        this.o = r0;
        this.n = r3;
        Iterator r2 = this.f177a.iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        ((CalendarPagerView) r2.next()).h(r3);
        goto L7
    }

    public void s(DayFormatter r2) {
        this.o = r2;
        Iterator r1 = this.f177a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((CalendarPagerView) r1.next()).i(r2);
        goto L4
    }

    public void t(CalendarDay r5, CalendarDay r6) {
        this.i = r5;
        this.j = r6;
        Iterator r0 = this.f177a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        CalendarPagerView r1 = (CalendarPagerView) r0.next();
        r1.k = r5;
        r1.q();
        r1.l = r6;
        r1.q();
        goto L4
    L6:
        CalendarDay r2 = this.c;
        if (r5 != null) goto L9;
        r5 = new CalendarDay(r2.e() + NetError.ERR_CERT_COMMON_NAME_INVALID, r2.d(), r2.c());
    L9:
        if (r6 != null) goto L11;
        r6 = new CalendarDay(r2.e() + 200, r2.d(), r2.c());
    L11:
        this.k = b(r5, r6);
        notifyDataSetChanged();
        l();
    }

    public void u(int r2) {
        this.e = Integer.valueOf(r2);
        Iterator r1 = this.f177a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((CalendarPagerView) r1.next()).l(r2);
        goto L4
    }

    public void v(boolean r3) {
        this.r = r3;
        Iterator r4 = this.f177a.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        ((CalendarPagerView) r4.next()).m(this.r);
        goto L4
    }

    public void w(int r2) {
        this.h = r2;
        Iterator r1 = this.f177a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((CalendarPagerView) r1.next()).n(r2);
        goto L4
    }

    public void x(boolean r1) {
        this.s = r1;
    }

    public void y(TitleFormatter r1) {
        if (r1 != null) goto L4;
        r1 = TitleFormatter.f193a;
    L4:
        this.f178d = r1;
    }

    public void z(WeekDayFormatter r2) {
        this.m = r2;
        Iterator r1 = this.f177a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((CalendarPagerView) r1.next()).o(r2);
        goto L4
    }
}
