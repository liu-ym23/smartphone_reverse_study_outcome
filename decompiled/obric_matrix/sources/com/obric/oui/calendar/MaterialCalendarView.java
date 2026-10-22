package com.obric.oui.calendar;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ArrayRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.temporal.WeekFields;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialCalendarView extends ViewGroup {
    private int A;
    private int B;
    private int C;
    private int D;
    private boolean E;
    private DayOfWeek F;
    private boolean G;
    private f H;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final s f10826f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final TextView f10827g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ImageView f10828h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ImageView f10829i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final com.obric.oui.calendar.c f10830j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private com.obric.oui.calendar.d<?> f10831k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private CalendarDay f10832l;
    private LinearLayout m;
    private com.obric.oui.calendar.b n;
    private boolean o;
    private final View.OnClickListener p;
    private final ViewPager.OnPageChangeListener q;
    private CalendarDay r;
    private CalendarDay s;
    private p t;
    private o u;
    private q v;
    private r w;
    CharSequence x;
    private int y;
    private int z;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f10833f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f10834g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        CalendarDay f10835h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        CalendarDay f10836i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        List<CalendarDay> f10837j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        boolean f10838k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        int f10839l;
        boolean m;
        CalendarDay n;
        boolean o;

        class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            public SavedState a(Parcel r2) {
                return new SavedState(r2, null);
            }

            public SavedState[] b(int r1) {
                return new SavedState[r1];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ SavedState createFromParcel(Parcel r1) {
                return a(r1);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ SavedState[] newArray(int r1) {
                return b(r1);
            }
        }

        static {
            CREATOR = new a();
        }

        private SavedState(Parcel r6) {
            super(r6);
            this.f10833f = 4;
            boolean r0 = true;
            this.f10834g = true;
            this.f10835h = null;
            this.f10836i = null;
            this.f10837j = new ArrayList();
            this.f10838k = true;
            this.f10839l = 1;
            this.m = false;
            this.n = null;
            this.f10833f = r6.readInt();
            if (r6.readByte() == 0) goto L5;
            boolean r1 = true;
        L6:
            this.f10834g = r1;
            ClassLoader r2 = CalendarDay.class.getClassLoader();
            this.f10835h = (CalendarDay) r6.readParcelable(r2);
            this.f10836i = (CalendarDay) r6.readParcelable(r2);
            r6.readTypedList(this.f10837j, CalendarDay.CREATOR);
            if (r6.readInt() != 1) goto L9;
            boolean r3 = true;
        L10:
            this.f10838k = r3;
            this.f10839l = r6.readInt();
            if (r6.readInt() != 1) goto L13;
            boolean r4 = true;
        L14:
            this.m = r4;
            this.n = (CalendarDay) r6.readParcelable(r2);
            if (r6.readByte() != 0) goto L18;
            r0 = false;
        L18:
            this.o = r0;
            return;
        L13:
            r4 = false;
            goto L14
        L9:
            r3 = false;
            goto L10
        L5:
            r1 = false;
            goto L6
        }

        /* synthetic */ SavedState(Parcel r1, a r2) {
            this(r1);
        }

        SavedState(Parcelable r3) {
            super(r3);
            this.f10833f = 4;
            this.f10834g = true;
            this.f10835h = null;
            this.f10836i = null;
            this.f10837j = new ArrayList();
            this.f10838k = true;
            this.f10839l = 1;
            this.m = false;
            this.n = null;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel r2, int r3) {
            super.writeToParcel(r2, r3);
            r2.writeInt(this.f10833f);
            r2.writeByte(this.f10834g ? 1 : 0);
            r2.writeParcelable(this.f10835h, 0);
            r2.writeParcelable(this.f10836i, 0);
            r2.writeTypedList(this.f10837j);
            r2.writeInt(this.f10838k ? 1 : 0);
            r2.writeInt(this.f10839l);
            r2.writeInt(this.m ? 1 : 0);
            r2.writeParcelable(this.n, 0);
            r2.writeByte(this.o ? 1 : 0);
        }
    }

    class a implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ MaterialCalendarView f10840f;

        a(MaterialCalendarView r1) {
            this.f10840f = r1;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r3) {
            if (r3 != MaterialCalendarView.a(this.f10840f)) goto L7;
            com.obric.oui.calendar.c r4 = MaterialCalendarView.b(this.f10840f);
            int r2 = MaterialCalendarView.b(this.f10840f).getCurrentItem() + 1;
        L5:
            r4.setCurrentItem(r2, true);
            return;
        L7:
            if (r3 != MaterialCalendarView.c(this.f10840f)) goto L10;
            r4 = MaterialCalendarView.b(this.f10840f);
            r2 = MaterialCalendarView.b(this.f10840f).getCurrentItem() - 1;
            goto L5
        }
    }

    class b implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ MaterialCalendarView f10841f;

        b(MaterialCalendarView r1) {
            this.f10841f = r1;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int r1) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int r1, float r2, int r3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int r3) {
            MaterialCalendarView.g(this.f10841f).k(MaterialCalendarView.e(this.f10841f));
            MaterialCalendarView r0 = this.f10841f;
            MaterialCalendarView.f(r0, MaterialCalendarView.h(r0).f(r3));
            MaterialCalendarView.i(this.f10841f);
            MaterialCalendarView r2 = this.f10841f;
            r2.q(MaterialCalendarView.e(r2));
        }
    }

    class c implements ViewPager.PageTransformer {
        c(MaterialCalendarView r1) {
        }

        @Override // androidx.viewpager.widget.ViewPager.PageTransformer, androidx.viewpager2.widget.ViewPager2.PageTransformer
        public void transformPage(View r3, float r4) {
            r3.setAlpha((float) Math.sqrt(1.0f - Math.abs(r4)));
        }
    }

    static /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f10842a = null;

        static {
            int[] r0 = new int[com.obric.oui.calendar.b.values().length];
            f10842a = r0;
            r0[com.obric.oui.calendar.b.f10870g.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f10842a[com.obric.oui.calendar.b.f10871h.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    protected static class e extends ViewGroup.MarginLayoutParams {
        public e(int r2) {
            super(-1, r2);
        }
    }

    public class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.oui.calendar.b f10843a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final DayOfWeek f10844b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final CalendarDay f10845c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final CalendarDay f10846d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f10847e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final boolean f10848f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ MaterialCalendarView f10849g;

        private f(MaterialCalendarView r1, g r2) {
            this.f10849g = r1;
            this.f10843a = g.f(r2);
            this.f10844b = g.a(r2);
            this.f10845c = g.b(r2);
            this.f10846d = g.c(r2);
            this.f10847e = g.d(r2);
            this.f10848f = g.e(r2);
        }

        /* synthetic */ f(MaterialCalendarView r1, g r2, a r3) {
            this(r1, r2);
        }

        static /* synthetic */ com.obric.oui.calendar.b a(f r0) {
            return r0.f10843a;
        }

        static /* synthetic */ DayOfWeek b(f r0) {
            return r0.f10844b;
        }

        static /* synthetic */ CalendarDay c(f r0) {
            return r0.f10845c;
        }

        static /* synthetic */ CalendarDay d(f r0) {
            return r0.f10846d;
        }

        static /* synthetic */ boolean e(f r0) {
            return r0.f10848f;
        }

        static /* synthetic */ boolean f(f r0) {
            return r0.f10847e;
        }

        public g g() {
            return new g(this.f10849g, this, null);
        }
    }

    public class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.obric.oui.calendar.b f10850a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private DayOfWeek f10851b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f10852c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private CalendarDay f10853d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private CalendarDay f10854e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f10855f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ MaterialCalendarView f10856g;

        public g(MaterialCalendarView r4) {
            this.f10856g = r4;
            this.f10852c = false;
            this.f10853d = null;
            this.f10854e = null;
            this.f10850a = com.obric.oui.calendar.b.f10870g;
            this.f10851b = LocalDate.now().with(WeekFields.of(Locale.getDefault()).dayOfWeek(), 1).getDayOfWeek();
        }

        private g(MaterialCalendarView r1, f r2) {
            this.f10856g = r1;
            this.f10852c = false;
            this.f10853d = null;
            this.f10854e = null;
            this.f10850a = f.a(r2);
            this.f10851b = f.b(r2);
            this.f10853d = f.c(r2);
            this.f10854e = f.d(r2);
            this.f10852c = f.f(r2);
            this.f10855f = f.e(r2);
        }

        /* synthetic */ g(MaterialCalendarView r1, f r2, a r3) {
            this(r1, r2);
        }

        static /* synthetic */ DayOfWeek a(g r0) {
            return r0.f10851b;
        }

        static /* synthetic */ CalendarDay b(g r0) {
            return r0.f10853d;
        }

        static /* synthetic */ CalendarDay c(g r0) {
            return r0.f10854e;
        }

        static /* synthetic */ boolean d(g r0) {
            return r0.f10852c;
        }

        static /* synthetic */ boolean e(g r0) {
            return r0.f10855f;
        }

        static /* synthetic */ com.obric.oui.calendar.b f(g r0) {
            return r0.f10850a;
        }

        public void g() {
            MaterialCalendarView r0 = this.f10856g;
            MaterialCalendarView.d(r0, new f(r0, this, null));
        }

        public g h(boolean r1) {
            this.f10852c = r1;
            return this;
        }

        public g i(com.obric.oui.calendar.b r1) {
            this.f10850a = r1;
            return this;
        }

        public g j(DayOfWeek r1) {
            this.f10851b = r1;
            return this;
        }

        public g k(@Nullable CalendarDay r1) {
            this.f10854e = r1;
            return this;
        }

        public g l(@Nullable CalendarDay r1) {
            this.f10853d = r1;
            return this;
        }

        public g m(boolean r1) {
            this.f10855f = r1;
            return this;
        }
    }

    public MaterialCalendarView(Context r11, AttributeSet r12) {
        super(r11, r12);
        new ArrayList();
        a r0 = new a(this);
        this.p = r0;
        b r1 = new b(this);
        this.q = r1;
        this.r = null;
        this.s = null;
        this.y = 0;
        this.z = -10;
        this.A = -10;
        this.B = -10;
        this.C = -10;
        this.D = 1;
        this.E = true;
        if (Build.VERSION.SDK_INT < 19) goto L5;
        setClipToPadding(false);
        setClipChildren(false);
    L6:
        View r2 = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(com.obric.common.oui.g.f8253c, null, false);
        this.m = (LinearLayout) r2.findViewById(com.obric.common.oui.f.R);
        ImageView r6 = (ImageView) r2.findViewById(com.obric.common.oui.f.G0);
        this.f10828h = r6;
        TextView r7 = (TextView) r2.findViewById(com.obric.common.oui.f.f0);
        this.f10827g = r7;
        ImageView r3 = (ImageView) r2.findViewById(com.obric.common.oui.f.g0);
        this.f10829i = r3;
        com.obric.oui.calendar.c r8 = new com.obric.oui.calendar.c(getContext());
        this.f10830j = r8;
        r6.setOnClickListener(r0);
        r3.setOnClickListener(r0);
        s r4 = new s(r7);
        this.f10826f = r4;
        r8.setOnPageChangeListener(r1);
        r8.setPageTransformer(false, new c(this));
        TypedArray r13 = r11.getTheme().obtainStyledAttributes(r12, com.obric.common.oui.k.o2, 0, 0);
        int r5 = r13.getInteger(com.obric.common.oui.k.q2, 0);     // Catch: Throwable -> L37 Exception -> L39
        int r9 = r13.getInteger(com.obric.common.oui.k.s2, -1);     // Catch: Throwable -> L37 Exception -> L39
        r4.j(r13.getInteger(com.obric.common.oui.k.G2, 0));     // Catch: Throwable -> L37 Exception -> L39
        if (r9 >= 1) goto L10;
    L13:
        DayOfWeek r10 = WeekFields.of(Locale.getDefault()).getFirstDayOfWeek();     // Catch: Throwable -> L37 Exception -> L39
    L12:
        this.F = r10;     // Catch: Throwable -> L37 Exception -> L39
        this.G = r13.getBoolean(com.obric.common.oui.k.A2, true);     // Catch: Throwable -> L37 Exception -> L39
        g r14 = A();     // Catch: Throwable -> L37 Exception -> L39
        r14.j(this.F);     // Catch: Throwable -> L37 Exception -> L39
        r14.i(com.obric.oui.calendar.b.values()[r5]);     // Catch: Throwable -> L37 Exception -> L39
        r14.m(this.G);     // Catch: Throwable -> L37 Exception -> L39
        r14.g();     // Catch: Throwable -> L37 Exception -> L39
        setSelectionMode(r13.getInteger(com.obric.common.oui.k.y2, 1));     // Catch: Throwable -> L37 Exception -> L39
        int r15 = r13.getLayoutDimension(com.obric.common.oui.k.D2, -10);     // Catch: Throwable -> L37 Exception -> L39
        if (r15 <= (-10)) goto L17;
        setTileSize(r15);     // Catch: Throwable -> L37 Exception -> L39
    L17:
        int r16 = r13.getLayoutDimension(com.obric.common.oui.k.F2, -10);     // Catch: Throwable -> L37 Exception -> L39
        if (r16 <= (-10)) goto L20;
        setTileWidth(r16);     // Catch: Throwable -> L37 Exception -> L39
    L20:
        int r17 = r13.getLayoutDimension(com.obric.common.oui.k.C2, -10);     // Catch: Throwable -> L37 Exception -> L39
        if (r17 <= (-10)) goto L23;
        setTileHeight(r17);     // Catch: Throwable -> L37 Exception -> L39
    L23:
        int r18 = r13.getLayoutDimension(com.obric.common.oui.k.B2, -10);     // Catch: Throwable -> L37 Exception -> L39
        if (r16 <= (-10)) goto L26;
        setTileHSpacing(r18);     // Catch: Throwable -> L37 Exception -> L39
    L26:
        int r19 = r13.getLayoutDimension(com.obric.common.oui.k.E2, -10);     // Catch: Throwable -> L37 Exception -> L39
        if (r16 <= (-10)) goto L29;
        setTileVSpacing(r19);     // Catch: Throwable -> L37 Exception -> L39
    L29:
        setLeftArrow(r13.getResourceId(com.obric.common.oui.k.u2, com.obric.common.oui.e.E));     // Catch: Throwable -> L37 Exception -> L39
        setRightArrow(r13.getResourceId(com.obric.common.oui.k.w2, com.obric.common.oui.e.D));     // Catch: Throwable -> L37 Exception -> L39
        setSelectionColor(r13.getColor(com.obric.common.oui.k.x2, w(r11)));     // Catch: Throwable -> L37 Exception -> L39
        CharSequence[] r110 = r13.getTextArray(com.obric.common.oui.k.H2);     // Catch: Throwable -> L37 Exception -> L39
        if (r110 == null) goto L32;
        setWeekDayFormatter(new com.obric.oui.calendar.v.a(r110));     // Catch: Throwable -> L37 Exception -> L39
    L32:
        CharSequence[] r111 = r13.getTextArray(com.obric.common.oui.k.v2);     // Catch: Throwable -> L37 Exception -> L39
        if (r111 == null) goto L35;
        setTitleFormatter(new com.obric.oui.calendar.v.f(r111));     // Catch: Throwable -> L37 Exception -> L39
    L35:
        setHeaderTextAppearance(r13.getResourceId(com.obric.common.oui.k.t2, com.obric.common.oui.j.f8283h));     // Catch: Throwable -> L37 Exception -> L39
        setWeekDayTextAppearance(r13.getResourceId(com.obric.common.oui.k.I2, com.obric.common.oui.j.f8284i));     // Catch: Throwable -> L37 Exception -> L39
        setDateTextAppearance(r13.getResourceId(com.obric.common.oui.k.r2, com.obric.common.oui.j.f8282g));     // Catch: Throwable -> L37 Exception -> L39
        setShowOtherDates(r13.getInteger(com.obric.common.oui.k.z2, 4));     // Catch: Throwable -> L37 Exception -> L39
        setAllowClickDaysOutsideCurrentMonth(r13.getBoolean(com.obric.common.oui.k.p2, true));     // Catch: Throwable -> L37 Exception -> L39
    L41:
        r13.recycle();
        I();
        CalendarDay r112 = CalendarDay.q();
        this.f10832l = r112;
        setCurrentDate(r112);
        if (isInEditMode() == false) goto L49;
        removeView(this.f10830j);
        m r113 = new m(this, this.f10832l, getFirstDayOfWeek(), true);
        r113.s(getSelectionColor());
        r113.l(this.f10831k.d());
        r113.w(this.f10831k.j());
        r113.u(getShowOtherDates());
        addView(r113, new e(this.n.f10873f + 1));
        return;
    L49:
        return;
    L10:
        if (r9 > 7) goto L13;
        r10 = DayOfWeek.of(r9);     // Catch: Throwable -> L37 Exception -> L39
    L37:
        th = move-exception;
        r13.recycle();
        throw th;
    L39:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L37
        goto L41
    L5:
        setClipChildren(true);
        setClipToPadding(true);
        goto L6
    }

    private void H(CalendarDay r3, CalendarDay r4) {
        CalendarDay r0 = this.f10832l;
        this.f10831k.u(r3, r4);
        this.f10832l = r0;
        if (r3 != null) goto L5;
    L9:
        int r5 = this.f10831k.e(r0);
        this.f10830j.setCurrentItem(r5, false);
        N();
        return;
    L5:
        if (r3.j(r0) == true) goto L8;
        r3 = this.f10832l;
    L8:
        this.f10832l = r3;
        goto L9
    }

    private void I() {
        addView(this.m);
        this.f10830j.setId(com.obric.common.oui.f.e0);
        this.f10830j.setOffscreenPageLimit(1);
        if (this.G == false) goto L5;
        int r0 = this.n.f10873f + 1;
    L6:
        addView(this.f10830j, new e(r0));
        return;
    L5:
        r0 = this.n.f10873f;
        goto L6
    }

    public static boolean J(int r0) {
        if ((r0 & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean K(int r1) {
        if ((r1 & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean L(int r0) {
        if ((r0 & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private void N() {
        this.f10826f.f(this.f10832l);
        t(this.f10828h, k());
        t(this.f10829i, l());
    }

    static /* synthetic */ ImageView a(MaterialCalendarView r0) {
        return r0.f10829i;
    }

    static /* synthetic */ com.obric.oui.calendar.c b(MaterialCalendarView r0) {
        return r0.f10830j;
    }

    static /* synthetic */ ImageView c(MaterialCalendarView r0) {
        return r0.f10828h;
    }

    static /* synthetic */ void d(MaterialCalendarView r0, f r1) {
        r0.o(r1);
    }

    static /* synthetic */ CalendarDay e(MaterialCalendarView r0) {
        return r0.f10832l;
    }

    static /* synthetic */ CalendarDay f(MaterialCalendarView r0, CalendarDay r1) {
        r0.f10832l = r1;
        return r1;
    }

    static /* synthetic */ s g(MaterialCalendarView r0) {
        return r0.f10826f;
    }

    private int getWeekCountBasedOnMode() {
        com.obric.oui.calendar.b r0 = this.n;
        int r1 = r0.f10873f;
        if (r0.equals(com.obric.oui.calendar.b.f10870g) == false) goto L12;
        if (this.o == false) goto L12;
        com.obric.oui.calendar.d<?> r2 = this.f10831k;
        if (r2 == null) goto L12;
        com.obric.oui.calendar.c r3 = this.f10830j;
        if (r3 == null) goto L12;
        LocalDate r4 = r2.f(r3.getCurrentItem()).e();
        r1 = r4.withDayOfMonth(r4.lengthOfMonth()).get(WeekFields.of(this.F, 1).weekOfMonth());
    L12:
        if (this.G == true) goto L14;
        return r1;
    L14:
        return r1 + 1;
    }

    static /* synthetic */ com.obric.oui.calendar.d h(MaterialCalendarView r0) {
        return r0.f10831k;
    }

    static /* synthetic */ void i(MaterialCalendarView r0) {
        r0.N();
    }

    private static int m(int r2, int r3) {
        int r0 = View.MeasureSpec.getMode(r3);
        int r4 = View.MeasureSpec.getSize(r3);
        if (r0 == Integer.MIN_VALUE) goto L9;
        if (r0 == 1073741824) goto L7;
        return r2;
    L7:
        return r4;
    L9:
        return Math.min(r2, r4);
    }

    private void o(f r6) {
        if (this.f10831k != null) goto L5;
    L32:
        CalendarDay r0 = null;
    L33:
        this.H = r6;
        this.n = f.a(r6);
        this.F = f.b(r6);
        this.r = f.c(r6);
        this.s = f.d(r6);
        this.G = f.e(r6);
        int r7 = d.f10842a[this.n.ordinal()];
        if (r7 != 1) goto L36;
        com.obric.oui.calendar.d<?> r8 = new l(this);
    L41:
        com.obric.oui.calendar.d<?> r2 = this.f10831k;
        if (r2 == null) goto L45;
        r8 = r2.o(r8);
    L45:
        this.f10831k = r8;
        this.f10831k.y(this.G);
        this.f10830j.setAdapter(this.f10831k);
        H(this.r, this.s);
        if (this.G == false) goto L48;
        int r9 = this.n.f10873f + 1;
    L49:
        this.f10830j.setLayoutParams(new e(r9));
        if (this.D == 1) goto L52;
    L54:
        CalendarDay r10 = CalendarDay.q();
    L55:
        setCurrentDate(r10);
        if (r0 == null) goto L58;
        this.f10830j.setCurrentItem(this.f10831k.e(r0));
    L58:
        z();
        N();
        return;
    L52:
        if (this.f10831k.h().isEmpty() == true) goto L54;
        r10 = this.f10831k.h().get(0);
        goto L55
    L48:
        r9 = this.n.f10873f;
        goto L49
    L36:
        if (r7 != 2) goto L39;
        r8 = new WeekPagerAdapter(this);
        goto L41
    L39:
        throw new IllegalArgumentException("Provided display mode which is not yet implemented");
    L5:
        if (f.f(r6) == false) goto L32;
        r0 = this.f10831k.f(this.f10830j.getCurrentItem());
        if (this.n == f.a(r6)) goto L33;
        CalendarDay r1 = getSelectedDate();
        com.obric.oui.calendar.b r3 = this.n;
        if (r3 != com.obric.oui.calendar.b.f10870g) goto L19;
        if (r1 == null) goto L19;
        CalendarDay r4 = CalendarDay.d(r0.e().plusDays(1));
        if (r1.equals(r0) == false) goto L14;
    L30:
        r0 = r1;
        goto L33
    L14:
        if (r1.j(r0) == false) goto L33;
        if (r1.l(r4) == false) goto L33;
    L19:
        if (r3 != com.obric.oui.calendar.b.f10871h) goto L33;
        CalendarDay r5 = CalendarDay.d(r0.e().plusDays(6));
        if (r1 != null) goto L23;
    L31:
        r0 = r5;
        goto L33
    L23:
        if (r1.equals(r0) == true) goto L30;
        if (r1.equals(r5) == true) goto L30;
        if (r1.j(r0) == false) goto L31;
        if (r1.l(r5) == false) goto L31;
        goto L30
    }

    private int s(int r2) {
        return (int) TypedValue.applyDimension(1, r2, getResources().getDisplayMetrics());
    }

    private static void t(View r0, boolean r1) {
        r0.setEnabled(r1);
        if (r1 == false) goto L5;
        float r2 = 1.0f;
    L6:
        r0.setAlpha(r2);
        return;
    L5:
        r2 = 0.1f;
        goto L6
    }

    private static int w(Context r4) {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        int r0 = R.attr.colorAccent;
    L6:
        TypedValue r1 = new TypedValue();
        r4.getTheme().resolveAttribute(r0, r1, true);
        return r1.data;
    L5:
        r0 = r4.getResources().getIdentifier("colorAccent", "attr", r4.getPackageName());
        goto L6
    }

    public g A() {
        return new g(this);
    }

    protected void B(@NonNull CalendarDay r4, boolean r5) {
        int r0 = this.D;
        if (r0 != 2) goto L5;
    L21:
        this.f10831k.q(r4, r5);
        p(r4, r5);
        return;
    L5:
        if (r0 == 3) goto L7;
        this.f10831k.a();
        this.f10831k.q(r4, true);
        p(r4, true);
        return;
    L7:
        List<CalendarDay> r1 = this.f10831k.h();
        if (r1.size() == 0) goto L21;
        if (r1.size() != 1) goto L20;
        CalendarDay r2 = r1.get(0);
        if (r2.equals(r4) == true) goto L21;
        if (r2.j(r4) == false) goto L18;
        this.f10831k.p(r4, r2);
    L19:
        r(this.f10831k.h());
        return;
    L18:
        this.f10831k.p(r2, r4);
        goto L19
    L20:
        this.f10831k.a();
        goto L21
    }

    protected void C(com.obric.oui.calendar.g r7) {
        CalendarDay r0 = getCurrentDate();
        CalendarDay r1 = r7.g();
        int r2 = r0.g();
        int r3 = r1.g();
        if (this.n == com.obric.oui.calendar.b.f10870g) goto L5;
    L13:
        B(r7.g(), !r7.isChecked());
        return;
    L5:
        if (this.E == false) goto L13;
        if (r2 == r3) goto L13;
        if (r0.j(r1) == false) goto L11;
        y();
        goto L13
    L11:
        if (r0.l(r1) == false) goto L13;
        x();
        goto L13
    }

    protected void D(com.obric.oui.calendar.g r2) {
        o r0 = this.u;
        if (r0 == null) goto L6;
        r0.a(this, r2.g());
        return;
    }

    protected void E(CalendarDay r2) {
        p(r2, false);
    }

    public void F(@Nullable CalendarDay r2, boolean r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        int r4 = this.f10831k.e(r2);
        this.f10830j.setCurrentItem(r4, r3);
        N();
    }

    public void G(@Nullable CalendarDay r1, boolean r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.f10831k.q(r1, r2);
    }

    public f M() {
        return this.H;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams r1) {
        return r1 instanceof e;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(@NonNull SparseArray<Parcelable> r1) {
        dispatchThawSelfOnly(r1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(@NonNull SparseArray<Parcelable> r1) {
        dispatchFreezeSelfOnly(r1);
    }

    @Override // android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return u();
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r1) {
        return v(r1);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return new e(1);
    }

    public CharSequence getCalendarContentDescription() {
        CharSequence r0 = this.x;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return getContext().getString(com.obric.common.oui.i.f8268e);
    }

    public com.obric.oui.calendar.b getCalendarMode() {
        return this.n;
    }

    public CalendarDay getCurrentDate() {
        return this.f10831k.f(this.f10830j.getCurrentItem());
    }

    public DayOfWeek getFirstDayOfWeek() {
        return this.F;
    }

    public Drawable getLeftArrow() {
        return this.f10828h.getDrawable();
    }

    public CalendarDay getMaximumDate() {
        return this.s;
    }

    public CalendarDay getMinimumDate() {
        return this.r;
    }

    public Drawable getRightArrow() {
        return this.f10829i.getDrawable();
    }

    @Nullable
    public CalendarDay getSelectedDate() {
        List<CalendarDay> r1 = this.f10831k.h();
        if (r1.isEmpty() == false) goto L7;
        return null;
    L7:
        return r1.get(r1.size() - 1);
    }

    @NonNull
    public List<CalendarDay> getSelectedDates() {
        return this.f10831k.h();
    }

    public int getSelectionColor() {
        return this.y;
    }

    public int getSelectionMode() {
        return this.D;
    }

    public int getShowOtherDates() {
        return this.f10831k.i();
    }

    public int getTileHSpacing() {
        return this.B;
    }

    public int getTileHeight() {
        return this.z;
    }

    @Deprecated
    public int getTileSize() {
        return Math.max(this.z, this.A);
    }

    public int getTileVSpacing() {
        return this.C;
    }

    public int getTileWidth() {
        return this.A;
    }

    public int getTitleAnimationOrientation() {
        return this.f10826f.i();
    }

    public boolean getTopbarVisible() {
        if (this.m.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean j() {
        return this.E;
    }

    public boolean k() {
        if (this.f10830j.getCurrentItem() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean l() {
        if (this.f10830j.getCurrentItem() < (this.f10831k.getCount() - 1)) goto L7;
        return false;
    L7:
        return true;
    }

    public void n() {
        List<CalendarDay> r0 = getSelectedDates();
        this.f10831k.a();
        Iterator<CalendarDay> r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        p(r1.next(), false);
        goto L4
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent r1) {
        super.onInitializeAccessibilityEvent(r1);
        r1.setClassName(MaterialCalendarView.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo r1) {
        super.onInitializeAccessibilityNodeInfo(r1);
        r1.setClassName(MaterialCalendarView.class.getName());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r5, int r6, int r7, int r8, int r9) {
        int r10 = getChildCount();
        int r11 = getPaddingLeft();
        int r12 = ((r8 - r6) - r11) - getPaddingRight();
        int r13 = getPaddingTop();
        int r14 = 0;
    L3:
        if (r14 >= r10) goto L9;
        View r0 = getChildAt(r14);
        if (r0.getVisibility() == 8) goto L8;
        int r1 = r0.getMeasuredWidth();
        int r3 = ((r12 - r1) / 2) + r11;
        int r2 = r0.getMeasuredHeight() + r13;
        r0.layout(r3, r13, r1 + r3, r2);
        r13 = r2;
    L8:
        r14 = r14 + 1;
        goto L3
    }

    @Override // android.view.View
    protected void onMeasure(int r12, int r13) {
        int r0 = View.MeasureSpec.getSize(r12);
        int r1 = View.MeasureSpec.getMode(r12);
        int r2 = View.MeasureSpec.getSize(r13);
        int r3 = View.MeasureSpec.getMode(r13);
        int r4 = (r0 - getPaddingLeft()) - getPaddingRight();
        int r5 = (r2 - getPaddingTop()) - getPaddingBottom();
        int r6 = getWeekCountBasedOnMode();
        if (getTopbarVisible() == false) goto L5;
        r6 = r6 + 1;
    L5:
        int r7 = r4 / 7;
        int r8 = r5 / r6;
        int r9 = this.A;
        int r10 = -1;
        if (r9 == (-10)) goto L8;
    L22:
        if (r9 <= 0) goto L24;
        r7 = r9;
    L24:
        int r11 = this.z;
        if (r11 <= 0) goto L27;
        r8 = r11;
    L27:
        r10 = r7;
        r7 = -1;
    L28:
        if (r7 <= 0) goto L30;
        r8 = r7;
    L39:
        int r14 = 0;
        int r15 = r7 * 7;
        int r16 = ((Math.max(this.C, 0) + r8) * Math.max(0, r6 - 1)) + r8;
        setMeasuredDimension(m((getPaddingLeft() + getPaddingRight()) + r15, r12), m(r16 + (getPaddingTop() + getPaddingBottom()), r13));
        int r17 = getChildCount();
        int r18 = Math.max(this.B, 0);
    L40:
        if (r14 >= r17) goto L42;
        View r19 = getChildAt(r14);
        r19.measure(View.MeasureSpec.makeMeasureSpec((r18 * 6) + r15, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) ((e) r19.getLayoutParams())).height * r8, BasicMeasure.EXACTLY));
        r14 = r14 + 1;
        goto L40
    L42:
        return;
    L30:
        if (r7 <= 0) goto L32;
        r7 = r10;
        goto L39
    L32:
        if (r10 > 0) goto L34;
        int r20 = s(44);
    L35:
        if (r8 > 0) goto L37;
        r8 = s(44);
    L37:
        r7 = r20;
        goto L39
    L34:
        r20 = r10;
        goto L35
    L8:
        if (this.z != (-10)) goto L22;
        if (r1 != 1073741824) goto L12;
    L19:
        if (r3 != 1073741824) goto L21;
        r7 = Math.min(r7, r8);
    L21:
        r8 = -1;
        goto L28
    L12:
        if (r1 == Integer.MIN_VALUE) goto L19;
        if (r3 == 1073741824) goto L18;
        if (r3 == Integer.MIN_VALUE) goto L18;
        r7 = -1;
        r8 = -1;
    L18:
        r7 = r8;
        goto L21
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable r4) {
        SavedState r5 = (SavedState) r4;
        super.onRestoreInstanceState(r5.getSuperState());
        g r0 = M().g();
        r0.l(r5.f10835h);
        r0.k(r5.f10836i);
        r0.h(r5.o);
        r0.g();
        setShowOtherDates(r5.f10833f);
        setAllowClickDaysOutsideCurrentMonth(r5.f10834g);
        n();
        Iterator<CalendarDay> r1 = r5.f10837j.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        G(r1.next(), true);
        goto L4
    L6:
        setTopbarVisible(r5.f10838k);
        setSelectionMode(r5.f10839l);
        setDynamicHeightEnabled(r5.m);
        setCurrentDate(r5.n);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState r0 = new SavedState(super.onSaveInstanceState());
        r0.f10833f = getShowOtherDates();
        r0.f10834g = j();
        r0.f10835h = getMinimumDate();
        r0.f10836i = getMaximumDate();
        r0.f10837j = getSelectedDates();
        r0.f10839l = getSelectionMode();
        r0.f10838k = getTopbarVisible();
        r0.m = this.o;
        r0.n = this.f10832l;
        r0.o = f.f(this.H);
        return r0;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r1) {
        return this.f10830j.dispatchTouchEvent(r1);
    }

    protected void p(CalendarDay r2, boolean r3) {
        p r0 = this.t;
        if (r0 == null) goto L6;
        r0.a(this, r2, r3);
        return;
    }

    protected void q(CalendarDay r2) {
        q r0 = this.v;
        if (r0 == null) goto L6;
        r0.a(this, r2);
        return;
    }

    protected void r(@NonNull List<CalendarDay> r2) {
        r r0 = this.w;
        if (r0 == null) goto L6;
        r0.a(this, r2);
        return;
    }

    public void setAllowClickDaysOutsideCurrentMonth(boolean r1) {
        this.E = r1;
    }

    public void setContentDescriptionArrowFuture(CharSequence r1) {
        this.f10829i.setContentDescription(r1);
    }

    public void setContentDescriptionArrowPast(CharSequence r1) {
        this.f10828h.setContentDescription(r1);
    }

    public void setContentDescriptionCalendar(CharSequence r1) {
        this.x = r1;
    }

    public void setCurrentDate(@Nullable CalendarDay r2) {
        F(r2, true);
    }

    public void setCurrentDate(@Nullable LocalDate r1) {
        setCurrentDate(CalendarDay.d(r1));
    }

    public void setDateTextAppearance(int r1) {
        this.f10831k.r(r1);
    }

    public void setDayFormatter(com.obric.oui.calendar.v.e r1) {
        com.obric.oui.calendar.d<?> r0 = this.f10831k;
        if (r1 != null) goto L5;
        r1 = com.obric.oui.calendar.v.e.f10929a;
    L5:
        r0.s(r1);
    }

    public void setDayFormatterContentDescription(com.obric.oui.calendar.v.e r1) {
        this.f10831k.t(r1);
    }

    public void setDynamicHeightEnabled(boolean r1) {
        this.o = r1;
    }

    public void setHeaderTextAppearance(int r2) {
        this.f10827g.setTextAppearance(getContext(), r2);
    }

    public void setLeftArrow(@DrawableRes int r1) {
        this.f10828h.setImageResource(r1);
    }

    public void setOnDateChangedListener(p r1) {
        this.t = r1;
    }

    public void setOnDateLongClickListener(o r1) {
        this.u = r1;
    }

    public void setOnMonthChangedListener(q r1) {
        this.v = r1;
    }

    public void setOnRangeSelectedListener(r r1) {
        this.w = r1;
    }

    public void setOnTitleClickListener(View.OnClickListener r1) {
        this.f10827g.setOnClickListener(r1);
    }

    public void setPagingEnabled(boolean r2) {
        this.f10830j.a(r2);
        N();
    }

    public void setRightArrow(@DrawableRes int r1) {
        this.f10829i.setImageResource(r1);
    }

    public void setSelectedDate(@Nullable CalendarDay r2) {
        n();
        if (r2 == null) goto L6;
        G(r2, true);
        return;
    }

    public void setSelectedDate(@Nullable LocalDate r1) {
        setSelectedDate(CalendarDay.d(r1));
    }

    public void setSelectionColor(int r2) {
        if (r2 == 0) goto L4;
    L7:
        this.y = r2;
        this.f10831k.v(r2);
        invalidate();
        return;
    L4:
        if (isInEditMode() == true) goto L6;
        return;
    L6:
        r2 = -7829368;
        goto L7
    }

    public void setSelectionMode(int r6) {
        int r0 = this.D;
        this.D = r6;
        boolean r1 = false;
        if (r6 == 1) goto L9;
        if (r6 == 2) goto L14;
        if (r6 == 3) goto L8;
        this.D = 0;
        if (r0 == 0) goto L14;
    L8:
        n();
    L14:
        com.obric.oui.calendar.d<?> r7 = this.f10831k;
        if (this.D == 0) goto L17;
        r1 = true;
    L17:
        r7.w(r1);
        return;
    L9:
        if (r0 == 2) goto L12;
        if (r0 != 3) goto L14;
    L12:
        if (getSelectedDates().isEmpty() == true) goto L14;
        setSelectedDate(getSelectedDate());
        goto L14
    }

    public void setShowOtherDates(int r1) {
        this.f10831k.x(r1);
    }

    public void setTileHSpacing(int r1) {
        this.B = r1;
        requestLayout();
    }

    public void setTileHeight(int r1) {
        this.z = r1;
        requestLayout();
    }

    public void setTileHeightDp(int r1) {
        setTileHeight(s(r1));
    }

    public void setTileSize(int r1) {
        this.A = r1;
        this.z = r1;
        requestLayout();
    }

    public void setTileSizeDp(int r1) {
        setTileSize(s(r1));
    }

    public void setTileVSpacing(int r1) {
        this.C = r1;
        requestLayout();
    }

    public void setTileWidth(int r1) {
        this.A = r1;
        requestLayout();
    }

    public void setTileWidthDp(int r1) {
        setTileWidth(s(r1));
    }

    public void setTitleAnimationOrientation(int r1) {
        this.f10826f.j(r1);
    }

    public void setTitleFormatter(@Nullable com.obric.oui.calendar.v.g r2) {
        this.f10826f.l(r2);
        this.f10831k.z(r2);
        N();
    }

    public void setTitleMonths(@ArrayRes int r2) {
        setTitleMonths(getResources().getTextArray(r2));
    }

    public void setTitleMonths(CharSequence[] r2) {
        setTitleFormatter(new com.obric.oui.calendar.v.f(r2));
    }

    public void setTopbarVisible(boolean r2) {
        LinearLayout r0 = this.m;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        requestLayout();
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public void setWeekDayFormatter(com.obric.oui.calendar.v.h r1) {
        com.obric.oui.calendar.d<?> r0 = this.f10831k;
        if (r1 != null) goto L5;
        r1 = com.obric.oui.calendar.v.h.f10932a;
    L5:
        r0.A(r1);
    }

    public void setWeekDayLabels(@ArrayRes int r2) {
        setWeekDayLabels(getResources().getTextArray(r2));
    }

    public void setWeekDayLabels(CharSequence[] r2) {
        setWeekDayFormatter(new com.obric.oui.calendar.v.a(r2));
    }

    public void setWeekDayTextAppearance(int r1) {
        this.f10831k.B(r1);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    protected e u() {
        return new e(1);
    }

    public e v(AttributeSet r1) {
        return new e(1);
    }

    public void x() {
        if (l() == false) goto L6;
        com.obric.oui.calendar.c r2 = this.f10830j;
        r2.setCurrentItem(r2.getCurrentItem() + 1, true);
        return;
    }

    public void y() {
        if (k() == false) goto L6;
        com.obric.oui.calendar.c r2 = this.f10830j;
        r2.setCurrentItem(r2.getCurrentItem() - 1, true);
        return;
    }

    public void z() {
        this.f10831k.l();
    }
}
