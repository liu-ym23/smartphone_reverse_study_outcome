package com.obric.oui.forms;

import a.a;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.SpannableString;
import android.text.method.DigitsKeyListener;
import android.text.method.KeyListener;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewGroupKt;
import com.obric.common.oui.R;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.layout.OUIConstraintLayout;
import com.obric.oui.text.OTextView;
import com.obric.oui.utils.log.L;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SuppressLint({"ClickableViewAccessibility"})
public class OInputView extends ConstraintLayout {
    public static final /* synthetic */ int e0 = 0;
    public final boolean A;
    public int B;
    public final OUIConstraintLayout C;
    public final LinearLayout D;
    public final OTextView E;
    public final ImageView F;
    public final OEditText G;
    public final FrameLayout H;
    public final FrameLayout I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final View f225J;
    public final View K;
    public final View L;
    public final ImageView M;
    public final View N;
    public final OTextView O;
    public final OTextView P;
    public final OTextView Q;
    public final TextView R;
    public boolean S;
    public OnTextClearedListener T;
    public OnTextExceedLengthListener U;
    public View.OnClickListener V;
    public boolean W;
    public int a0;
    public boolean b;
    public boolean b0;
    public int c;
    public ValueAnimator c0;
    public ValueAnimator d0;
    public boolean e;
    public int f;
    public float i;
    public float j;
    public boolean k;
    public final boolean l;
    public final boolean m;
    public boolean n;
    public int o;
    public boolean p;
    public boolean q;
    public boolean r;
    public String s;
    public boolean t;
    public boolean u;
    public Integer v;
    public String w;
    public int x;
    public String y;
    public String z;

    @Metadata
    public static final class Companion {
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Metadata
    public @interface InputMode {
    }

    @Metadata
    public static final enum LabelUIState extends Enum<LabelUIState> {
        public static final LabelUIState b = null;
        public static final LabelUIState c = null;
        public static final LabelUIState e = null;
        public static final /* synthetic */ LabelUIState[] f = null;

        static {
            LabelUIState r0 = new LabelUIState("REAL_LABEL_SHOW", 0);
            b = r0;
            LabelUIState r1 = new LabelUIState("FAKE_LABEL_SHOW", 1);
            c = r1;
            LabelUIState r2 = new LabelUIState("LABEL_NONE", 2);
            e = r2;
            f = new LabelUIState[]{r0, r1, r2};
        }

        public static LabelUIState valueOf(String r1) {
            return (LabelUIState) Enum.valueOf(LabelUIState.class, r1);
        }

        public static LabelUIState[] values() {
            return (LabelUIState[]) f.clone();
        }
    }

    @Metadata
    public interface OnTextClearedListener {
        void a();

        void b();
    }

    @Metadata
    public interface OnTextExceedLengthListener {
        void a();
    }

    @Metadata
    public final /* synthetic */ class WhenMappings {
        static {
            int[] r0 = new int[LabelUIState.values().length];
            r0[0] = 1;
            r0[1] = 2;
            r0[2] = 3;
        }
    }

    @JvmOverloads
    public OInputView(@NotNull Context r13, @Nullable AttributeSet r14) {
        Intrinsics.f(r13, "context");
        super(r13, r14, 0);
        int r1 = 1;
        this.b = true;
        this.e = true;
        this.f = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.l = true;
        this.m = true;
        this.o = -1;
        this.p = true;
        this.r = true;
        this.u = true;
        this.B = a.d("Resources.getSystem()", 1, 10);
        TypedArray r15 = r13.getTheme().obtainStyledAttributes(r14, R.styleable.l, 0, 0);
        this.k = r15.getBoolean(14, false);
        this.l = r15.getBoolean(8, true);
        this.m = r15.getBoolean(24, true);
        this.p = r15.getBoolean(20, true);
        this.q = r15.getBoolean(21, false);
        this.r = r15.getBoolean(22, true);
        this.s = r15.getString(15);
        this.y = r15.getString(11);
        this.z = r15.getString(10);
        boolean r0 = r15.getBoolean(19, false);
        this.A = r0;
        this.B = r15.getDimensionPixelSize(12, this.B);
        this.b = r15.getBoolean(9, true);
        this.c = r15.getInt(16, 0);
        this.e = r15.getBoolean(17, true);
        int r5 = r15.getDimensionPixelSize(13, 0);
        if (r5 <= 0) goto L5;
        this.v = Integer.valueOf(r5);
    L5:
        this.o = r15.getInt(18, -1);
        this.n = r15.getBoolean(23, false);
        CharSequence r3 = r15.getText(6);
        this.w = r15.getString(4);
        this.x = r15.getInt(7, 0);
        String r6 = r15.getString(3);
        this.u = r15.getBoolean(0, true);
        this.f = r15.getInt(5, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        r15.getInt(2, 0);
        int r2 = r15.getInt(1, 16);
        r15.recycle();
        LayoutInflater.from(r13).inflate(getContentViewRes(), this);
        View r16 = findViewById(com.bytedance.securityserver.R.id.o_input_border_container);
        Intrinsics.e(r16, "findViewById(R.id.o_input_border_container)");
        OUIConstraintLayout r17 = (OUIConstraintLayout) r16;
        this.C = r17;
        r17.setRadius(this.B);
        View r18 = findViewById(com.bytedance.securityserver.R.id.o_input_title_container);
        Intrinsics.e(r18, "findViewById(R.id.o_input_title_container)");
        this.D = (LinearLayout) r18;
        View r19 = findViewById(com.bytedance.securityserver.R.id.o_input_title);
        Intrinsics.e(r19, "findViewById(R.id.o_input_title)");
        this.E = (OTextView) r19;
        View r110 = findViewById(com.bytedance.securityserver.R.id.o_input_title_icon);
        Intrinsics.e(r110, "findViewById(R.id.o_input_title_icon)");
        this.F = (ImageView) r110;
        View r111 = findViewById(com.bytedance.securityserver.R.id.o_input);
        Intrinsics.e(r111, "findViewById(R.id.o_input)");
        OEditText r112 = (OEditText) r111;
        this.G = r112;
        r112.setVerticalScrollBarEnabled(false);
        View r4 = findViewById(com.bytedance.securityserver.R.id.o_input_left_view_container);
        Intrinsics.e(r4, "findViewById(R.id.o_input_left_view_container)");
        this.H = (FrameLayout) r4;
        View r7 = findViewById(com.bytedance.securityserver.R.id.o_input_custom_action_container);
        Intrinsics.e(r7, "findViewById(R.id.o_input_custom_action_container)");
        this.I = (FrameLayout) r7;
        View r8 = findViewById(com.bytedance.securityserver.R.id.o_input_action_container);
        Intrinsics.e(r8, "findViewById(R.id.o_input_action_container)");
        this.f225J = r8;
        View r9 = findViewById(com.bytedance.securityserver.R.id.o_input_clear);
        Intrinsics.e(r9, "findViewById(R.id.o_input_clear)");
        this.K = r9;
        View r10 = findViewById(com.bytedance.securityserver.R.id.o_input_combo_arrow);
        Intrinsics.e(r10, "findViewById(R.id.o_input_combo_arrow)");
        this.L = r10;
        View r11 = findViewById(com.bytedance.securityserver.R.id.o_input_eyes_slash);
        Intrinsics.e(r11, "findViewById(R.id.o_input_eyes_slash)");
        ImageView r12 = (ImageView) r11;
        this.M = r12;
        View r20 = findViewById(com.bytedance.securityserver.R.id.o_input_resizer);
        Intrinsics.e(r20, "findViewById(R.id.o_input_resizer)");
        this.N = r20;
        View r21 = findViewById(com.bytedance.securityserver.R.id.o_input_error_tip);
        Intrinsics.e(r21, "findViewById(R.id.o_input_error_tip)");
        OTextView r22 = (OTextView) r21;
        this.O = r22;
        View r23 = findViewById(com.bytedance.securityserver.R.id.o_input_common_tip);
        Intrinsics.e(r23, "findViewById(R.id.o_input_common_tip)");
        OTextView r24 = (OTextView) r23;
        this.P = r24;
        View r113 = findViewById(com.bytedance.securityserver.R.id.o_input_limit_indicator);
        Intrinsics.e(r113, "findViewById(R.id.o_input_limit_indicator)");
        this.Q = (OTextView) r113;
        this.R = (TextView) findViewById(com.bytedance.securityserver.R.id.o_input_view_fake_label);
        setFocusableInTouchMode(true);
        setFocusable(true);
        setDescendantFocusability(262144);
        if (r3 == null) goto L11;
        r112.setKeyListener(DigitsKeyListener.getInstance(String.valueOf(r3)));
        int r25 = this.x;
        if (r25 == 0) goto L10;
        r1 = r25;
    L10:
        this.x = r1;
    L11:
        r112.setGravity(r2);
        Integer r26 = this.v;
        if (r26 == null) goto L14;
        setInputHeight(r26.intValue());
    L14:
        r112.b.f224a = new AnonymousClass3(this);
        r112.c.b = new AnonymousClass4(this);
        Function4<CharSequence, Integer, Integer, Integer, Unit> r27 = new AnonymousClass5(this);
        OEditText.TextWatcherWrapper r28 = r112.e;
        r28.b = r27;
        r28.c = new AnonymousClass6(this);
        r9.setOnClickListener(new AnonymousClass7(this));
        setCommonTip(this.z);
        ViewExtensionsKt.f(r24, r0);
        setErrorTip(this.y);
        ViewExtensionsKt.f(r22, false);
        setComboInputEnabled(this.b);
        setLabel(this.s);
        setShowLabel(this.p);
        setShowLabelIcon(this.r);
        setLimitCount(this.o);
        setShowLimitIndicator(this.n);
        setSingleLine(this.e);
        setMaxLines(this.f);
        setHint(this.w);
        setText(r6);
        setInputMode(this.c);
        setEnabled(this.u);
        o();
        n(r112.hasFocus());
        int r114 = this.x;
        if (r114 == 0) goto L17;
        setInputType(r114);
    L17:
        p();
        r12.setOnClickListener(new AnonymousClass8(this));
        r17.setOnClickListener(new AnonymousClass9(this));
        h("init");
    }

    public static final void g(final OInputView r11, boolean r12) {
        if (r11.q == true) goto L6;
        return;
    L6:
        if (r11.p == true) goto L9;
        return;
    L9:
        if (r11.e == false) goto L61;
        final TextView r1 = r11.R;
        if (r1 == null) goto L62;
        Editable r2 = r11.G.getText();
        if (r2 == null) goto L21;
        if (r2.length() == 0) goto L21;
        r11.q(LabelUIState.b, r1, "playLabelAnim, hasFocus: " + r12);
        return;
    L21:
        if (r12 == false) goto L38;
        ValueAnimator r13 = r11.d0;
        if (r13 == null) goto L25;
        r13.cancel();
    L25:
        ValueAnimator r14 = r11.d0;
        if (r14 == null) goto L28;
        r14.removeAllUpdateListeners();
    L28:
        ValueAnimator r15 = r11.d0;
        if (r15 == null) goto L31;
        r15.removeAllListeners();
    L31:
        ValueAnimator r16 = r11.c0;
        if (r16 != null) goto L34;
    L37:
        final int r17 = ContextCompat.getColor(r11.getContext(), com.bytedance.securityserver.R.color.oui_text_3);
        final int r6 = ContextCompat.getColor(r11.getContext(), com.bytedance.securityserver.R.color.oui_text_4);
        final float r7 = r11.getFakeInputOffsetY();
        final float r8 = r11.k(r1);
        r1.setPivotX(0.0f);
        r1.setPivotY(-r7);
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        Intrinsics.e(r0, "animator");
        r0.setDuration(200);
        r0.setInterpolator(new DecelerateInterpolator());
        r0.addUpdateListener(new OInputView$genLabelShowAnim$1(r11, r7, r6, r17, r8, r1));
        r0.addListener(new OInputView$genLabelShowAnim$2(r11, r1));
        r11.c0 = r0;
        r0.start();
        L.a("OInputView", "start label show anim");
        return;
    L34:
        if (r16.isRunning() != true) goto L37;
        L.g("OInputView", "label show anim is running, do nothing");
        return;
    L38:
        ValueAnimator r18 = r11.c0;
        if (r18 == null) goto L41;
        r18.cancel();
    L41:
        ValueAnimator r19 = r11.c0;
        if (r19 == null) goto L44;
        r19.removeAllUpdateListeners();
    L44:
        ValueAnimator r110 = r11.c0;
        if (r110 == null) goto L47;
        r110.removeAllListeners();
    L47:
        ValueAnimator r111 = r11.d0;
        if (r111 != null) goto L50;
    L53:
        final int r112 = ContextCompat.getColor(r11.getContext(), com.bytedance.securityserver.R.color.oui_text_3);
        final int r9 = ContextCompat.getColor(r11.getContext(), com.bytedance.securityserver.R.color.oui_text_4);
        final float r10 = r11.getFakeInputOffsetY();
        final float r20 = r11.k(r1);
        r1.setPivotX(0.0f);
        r1.setPivotY(-r10);
        ValueAnimator r3 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        Intrinsics.e(r3, "animator");
        r3.setDuration(200);
        r3.setInterpolator(new DecelerateInterpolator());
        r3.addUpdateListener(new OInputView$genLabelHideAnim$1(r11, r10, r112, r9, r20, r1));
        r3.addListener(new OInputView$genLabelHideAnim$2(r11, r1));
        r11.d0 = r3;
        r3.start();
        L.a("OInputView", "start label hide anim");
        return;
    L50:
        if (r111.isRunning() != true) goto L53;
        L.g("OInputView", "label hide anim is running, do nothing");
        return;
    L62:
        return;
    }

    private final float getFakeInputOffsetY() {
        LinearLayout r0 = this.D;
        if (r0.getHeight() > 0) goto L5;
    L7:
        L.g("OInputView", "getFakeInputOffsetY, use default offset, vTitleContainer.height: " + r0.getHeight() + ", height: " + getHeight());
        Resources r4 = Resources.getSystem();
        Intrinsics.e(r4, "Resources.getSystem()");
        float r1 = TypedValue.applyDimension(1, -11.0f, r4.getDisplayMetrics());
    L8:
        L.a("OInputView", "getFakeInputOffsetY, offsetY: " + r1);
        return r1;
    L5:
        if (getHeight() <= 0) goto L7;
        r1 = ((r0.getHeight() / 2.0f) + r0.getY()) - (getHeight() / 2.0f);
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r7) {
        if (r7 == null) goto L36;
        if (this.k == false) goto L36;
        float r0 = r7.getX();
        float r1 = r7.getY();
        int r2 = r7.getAction();
        if (r2 != 0) goto L8;
        this.i = r1;
        goto L36
    L8:
        if (r2 != 1) goto L10;
        super.requestDisallowInterceptTouchEvent(false);
        goto L36
    L10:
        if (r2 != 2) goto L12;
        float r3 = this.j;
        OEditText r5 = this.G;
        if (r0 <= r3) goto L20;
        if (r5.canScrollHorizontally(-1) == false) goto L20;
    L31:
        super.requestDisallowInterceptTouchEvent(true);
    L32:
        this.j = r0;
        this.i = r1;
    L20:
        if (r0 >= this.j) goto L24;
        if (r5.canScrollHorizontally(1) == true) goto L31;
    L24:
        if (r1 >= this.i) goto L28;
        if (r5.canScrollVertically(1) == true) goto L31;
    L28:
        if (r1 <= this.i) goto L32;
        if (r5.canScrollVertically(-1) == false) goto L32;
    L12:
        if (r2 != 3) goto L36;
        super.requestDisallowInterceptTouchEvent(false);
    L36:
        return super.dispatchTouchEvent(r7);
    }

    public final boolean getAutoHideSoftInputWhenLoseFocus() {
        return this.W;
    }

    @Nullable
    public final OEditText.CommitCompletionListener getCommitCompletionListener() {
        return this.G.getCommitCompletionListener();
    }

    public int getContentViewRes() {
        return com.bytedance.securityserver.R.layout.o_input_view_layout_vertical;
    }

    public final int getInputType() {
        return this.x;
    }

    public final int getLimitCount() {
        return this.o;
    }

    @Override // android.view.View
    @Nullable
    public View.OnFocusChangeListener getOnFocusChangeListener() {
        return this.G.getOnFocusChangeListener();
    }

    @Nullable
    public String getText() {
        Editable r0 = this.G.getText();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.toString();
    }

    @NotNull
    public final OEditText getVInput() {
        return this.G;
    }

    public final void h(String r6) {
        if (this.q == true) goto L5;
        return;
    L5:
        TextView r0 = this.R;
        if (r0 == null) goto L24;
        boolean r1 = this.p;
        OEditText r3 = this.G;
        if (r1 == true) goto L10;
        r3.setHint(this.w);
        q(LabelUIState.e, r0, a.k("adjustInputViewAndLabel, ", r6, ", no label"));
        return;
    L10:
        boolean r2 = this.e;
        LabelUIState r4 = LabelUIState.b;
        if (r2 == true) goto L13;
        r3.setHint(this.w);
        q(r4, r0, "adjustInputViewAndLabel, " + r6 + ", can not show label anim");
        return;
    L13:
        r3.setHint("");
        r0.setText(this.s);
        Editable r5 = r3.getText();
        if (r5 == null) goto L20;
        if (r5.length() == 0) goto L20;
        q(r4, r0, a.k("adjustInputViewAndLabel, ", r6, ", can show label anim, vInput.text not empty"));
        return;
    L20:
        if (r3.hasFocus() == false) goto L22;
        q(r4, r0, a.k("adjustInputViewAndLabel, ", r6, ", can show label anim, vInput.text empty, focused"));
        return;
    L22:
        q(LabelUIState.c, r0, a.k("adjustInputViewAndLabel, ", r6, ", can show label anim, vInput.text empty, not focused"));
        return;
    }

    public void i(Editable r1) {
    }

    public int j(CharSequence r1) {
        if (r1 != null) goto L6;
        return 0;
    L6:
        return r1.length();
    }

    public final float k(TextView r4) {
        OTextView r3 = this.E;
        float r1 = 0;
        if (r3.getTextSize() > r1) goto L5;
    L7:
        L.g("OInputView", "getScaleRatio, use default scale, vTitle.textSize: " + r3.getTextSize() + ", vFakeInput.textSize: " + r4.getTextSize());
        float r5 = 0.857143f;
    L8:
        L.a("OInputView", "getScaleRatio, scale: " + r5);
        return r5;
    L5:
        if (r4.getTextSize() <= r1) goto L7;
        r5 = r3.getTextSize() / r4.getTextSize();
        goto L8
    }

    public final boolean l() {
        int r5 = this.x & 4095;
        if (r5 != 129) goto L5;
        boolean r0 = true;
    L7:
        if (r5 != 225) goto L9;
        boolean r3 = true;
    L11:
        if (r5 != 18) goto L13;
        boolean r6 = true;
    L14:
        if (r0 == true) goto L18;
        if (r3 == true) goto L18;
        if (r6 == true) goto L18;
        return false;
    L18:
        return true;
    L13:
        r6 = false;
        goto L14
    L9:
        r3 = false;
        goto L11
    L5:
        r0 = false;
        goto L7
    }

    public final void m(boolean r4) {
        int r0 = this.a0;
        OUIConstraintLayout r1 = this.C;
        if (r0 == 0) goto L6;
        r1.setBackgroundResource(r0);
        return;
    L6:
        boolean r2 = this.u;
        int r3 = com.bytedance.securityserver.R.drawable.o_input_view_pressed_background;
        if (r2 == false) goto L15;
        if (r4 == true) goto L15;
        if (this.G.hasFocus() == false) goto L14;
        r3 = com.bytedance.securityserver.R.drawable.o_input_view_focused_background;
        goto L15
    L14:
        r3 = com.bytedance.securityserver.R.drawable.o_input_view_normal_background;
    L15:
        r1.setBackgroundResource(r3);
    }

    public final void n(boolean r7) {
        int r1 = 0;
        if (this.u == true) goto L6;
    L4:
        float r0 = 0;
    L5:
        int r2 = a.d("Resources.getSystem()", 1, r0);
        OUIConstraintLayout r4 = this.C;
        r4.setBorderWidth(r2);
        if (this.u == true) goto L15;
        r1 = a.d("Resources.getSystem()", 1, 0);
    L19:
        if (r1 == 0) goto L22;
        r4.setBorderColor(ContextCompat.getColor(getContext(), r1));
        return;
    L22:
        return;
    L15:
        if (this.t == false) goto L17;
        r1 = com.bytedance.securityserver.R.color.oui_functional_red_7;
        goto L19
    L17:
        if (r7 == false) goto L19;
        r1 = com.bytedance.securityserver.R.color.oui_basic_line_3;
        goto L19
    L6:
        if (r7 == false) goto L9;
        r0 = 2;
        goto L5
    L9:
        if (this.t == false) goto L4;
        r0 = (float) 1.2d;
        goto L5
    }

    public final void o() {
        if (this.l == true) goto L5;
        return;
    L5:
        boolean r1 = true;
        if (l() == false) goto L8;
    L19:
        boolean r0 = false;
    L20:
        View r3 = this.K;
        ViewExtensionsKt.f(r3, r0);
        ImageView r4 = this.M;
        if (r0 == false) goto L24;
        ViewExtensionsKt.f(r4, false);
    L24:
        if (r3.getVisibility() != 0) goto L27;
    L33:
        ViewExtensionsKt.f(this.f225J, r1);
        return;
    L27:
        if (r4.getVisibility() == 0) goto L33;
        if (this.L.getVisibility() == 0) goto L33;
        r1 = false;
        goto L33
    L8:
        if (this.c != 0) goto L19;
        if (this.u == false) goto L19;
        OEditText r2 = this.G;
        if (r2.hasFocus() == false) goto L19;
        Editable r5 = r2.getText();
        if (r5 == null) goto L19;
        if (r5.length() == 0) goto L19;
        r0 = true;
        goto L20
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r6) {
        if (r6 != null) goto L5;
    L13:
        if (r6 != null) goto L15;
    L22:
        return super.onInterceptTouchEvent(r6);
    L15:
        if (r6.getAction() == 1) goto L19;
        if (r6.getAction() != 3) goto L22;
    L19:
        if (this.S == false) goto L22;
        this.S = false;
        goto L22
    L5:
        if (r6.getAction() != 0) goto L13;
        float r2 = r6.getX();
        OEditText r3 = this.G;
        int r4 = r3.getLeft();
        int r5 = r3.getRight();
        if (r2 >= r4) goto L9;
    L12:
        this.S = false;
        goto L22
    L9:
        if (r2 > r5) goto L12;
        this.S = true;
        return true;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r5) {
        if (r5 == null) goto L12;
        if (this.S == false) goto L12;
        MotionEvent r0 = MotionEvent.obtain(r5);
        OEditText r1 = this.G;
        r0.offsetLocation(-r1.getLeft(), -r1.getTop());
        boolean r2 = r1.dispatchTouchEvent(r0);
        r0.recycle();
        if (r5.getAction() != 1) goto L8;
    L9:
        this.S = false;
    L10:
        return r2;
    L8:
        if (r5.getAction() != 3) goto L10;
    L12:
        return super.onTouchEvent(r5);
    }

    public final void p() {
        boolean r1 = true;
        if (l() == true) goto L5;
    L14:
        boolean r0 = false;
    L15:
        ImageView r3 = this.M;
        ViewExtensionsKt.f(r3, r0);
        View r4 = this.K;
        if (r0 == false) goto L19;
        ViewExtensionsKt.f(r4, false);
    L19:
        if (r4.getVisibility() != 0) goto L22;
    L28:
        ViewExtensionsKt.f(this.f225J, r1);
        return;
    L22:
        if (r3.getVisibility() == 0) goto L28;
        if (this.L.getVisibility() == 0) goto L28;
        r1 = false;
        goto L28
    L5:
        if (this.u == false) goto L14;
        Editable r2 = this.G.getText();
        if (r2 == null) goto L14;
        if (r2.length() == 0) goto L14;
        if (this.b0 == true) goto L14;
        r0 = true;
        goto L15
    }

    public final void q(LabelUIState r5, TextView r6, String r7) {
        L.a("OInputView", "updateLabelUIState, state: " + r5 + ", scene: [" + r7 + ']');
        int r8 = r5.ordinal();
        OEditText r2 = this.G;
        LinearLayout r4 = this.D;
        if (r8 != 0) goto L5;
        r4.setVisibility(0);
        r6.setVisibility(8);
        r2.setAlpha(1.0f);
        return;
    L5:
        if (r8 != 1) goto L7;
        r4.setVisibility(4);
        r6.setVisibility(0);
        r2.setAlpha(0.0f);
        return;
    L7:
        if (r8 != 2) goto L15;
        r4.setVisibility(8);
        r6.setVisibility(8);
        r2.setAlpha(1.0f);
        return;
    }

    public final void r(String r6) {
        if (this.n == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        OTextView r2 = this.Q;
        ViewExtensionsKt.f(r2, r0);
        if (this.n == true) goto L11;
        return;
    L11:
        if (this.o <= 0) goto L18;
        int r7 = j(r6);
        String r1 = getResources().getString(com.bytedance.securityserver.R.string.oui_form_counter, new Object[]{String.valueOf(r7), String.valueOf(this.o)});
        Intrinsics.e(r1, "resources.getString(\n   ….toString()\n            )");
        SpannableString r3 = new SpannableString(r1);
        if (r7 <= this.o) goto L15;
        r3.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), com.bytedance.securityserver.R.color.oui_functional_red_7)), 0, String.valueOf(r7).length(), 18);
    L15:
        r2.setText(r3, TextView.BufferType.SPANNABLE);
        return;
    L18:
        return;
    L5:
        if (this.o <= 0) goto L7;
        r0 = true;
        goto L8
    }

    public final void setActionView(@NotNull Function1<? super FrameLayout, Unit> r2) {
        Intrinsics.f(r2, "creator");
        FrameLayout r1 = this.I;
        r1.removeAllViews();
        r2.invoke(r1);
        if (r1.getChildCount() <= 0) goto L5;
        boolean r3 = true;
    L6:
        ViewExtensionsKt.f(r1, r3);
        return;
    L5:
        r3 = false;
        goto L6
    }

    public final void setAlwaysHideEye(boolean r1) {
        this.b0 = r1;
        if (r1 == false) goto L6;
        ViewExtensionsKt.f(this.M, false);
        return;
    }

    public final void setAutoHideSoftInputWhenLoseFocus(boolean r1) {
        this.W = r1;
    }

    public final void setBgResId(int r1) {
        this.a0 = r1;
        m(true);
    }

    public final void setComboInputEnabled(boolean r2) {
        this.b = r2;
        OEditText r0 = this.G;
        r0.setFocusable(r2);
        r0.setFocusableInTouchMode(r2);
        View.OnClickListener r1 = this.V;
        if (r1 == null) goto L6;
        r0.setOnClickListener(r1);
        return;
    }

    public final void setCommitCompletionListener(@NotNull OEditText.CommitCompletionListener r2) {
        Intrinsics.f(r2, "commitCompletionListener");
        this.G.setCommitCompletionListener(r2);
    }

    public final void setCommonTip(@Nullable String r1) {
        this.z = r1;
        this.P.setText(r1);
    }

    @Override // android.view.View
    public void setEnabled(boolean r3) {
        this.u = r3;
        super.setEnabled(r3);
        Iterator r0 = ViewGroupKt.getChildren(this).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((View) r0.next()).setEnabled(r3);
        goto L4
    L6:
        OEditText r1 = this.G;
        r1.setEnabled(r3);
        n(r1.hasFocus());
        m(false);
    }

    public final void setErrorState(boolean r1) {
        this.t = r1;
        n(this.G.hasFocus());
        m(false);
    }

    public final void setErrorTip(@Nullable String r1) {
        this.y = r1;
        this.O.setText(r1);
    }

    public final void setHint(@Nullable String r2) {
        this.w = r2;
        this.G.setHint(r2);
        h("setHint");
    }

    public final void setInputHeight(int r2) {
        this.v = Integer.valueOf(r2);
        OEditText r1 = this.G;
        ViewGroup.LayoutParams r0 = r1.getLayoutParams();
        if (r0 == null) goto L7;
        ConstraintLayout.LayoutParams r3 = (ConstraintLayout.LayoutParams) r0;
        ((ViewGroup.MarginLayoutParams) r3).height = r2;
        r1.setLayoutParams(r3);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public final void setInputMode(@InputMode int r7) {
        this.c = r7;
        ImageView r0 = this.M;
        View r1 = this.K;
        View r2 = this.f225J;
        boolean r3 = false;
        View r4 = this.L;
        if (r7 == 0) goto L16;
        if (r7 != 1) goto L28;
        setSingleLine(true);
        ViewExtensionsKt.f(r4, true);
        if (r1.getVisibility() != 0) goto L10;
    L14:
        r3 = true;
    L15:
        ViewExtensionsKt.f(r2, r3);
        setComboInputEnabled(this.b);
        return;
    L10:
        if (r0.getVisibility() == 0) goto L14;
        if (r4.getVisibility() != 0) goto L15;
    L28:
        return;
    L16:
        ViewExtensionsKt.f(r4, false);
        if (r1.getVisibility() != 0) goto L20;
    L24:
        r3 = true;
    L25:
        ViewExtensionsKt.f(r2, r3);
        OEditText r6 = this.G;
        r6.setFocusable(true);
        r6.setFocusableInTouchMode(true);
        return;
    L20:
        if (r0.getVisibility() == 0) goto L24;
        if (r4.getVisibility() != 0) goto L25;
        goto L24
    }

    public final void setInputType(int r3) {
        if ((r3 & 1) == 0) goto L5;
    L11:
        this.x = r3;
        OEditText r0 = this.G;
        if (r3 != r0.getInputType()) goto L15;
        i(r0.getText());
        return;
    L15:
        r0.setInputType(this.x);
        p();
        i(r0.getText());
        return;
    L5:
        if ((r3 & 2) != 0) goto L11;
        if ((r3 & 3) != 0) goto L11;
        if ((r3 & 4) != 0) goto L11;
        r3 = r3 | 1;
        goto L11
    }

    public final void setIsInScrollableView(boolean r1) {
        this.k = r1;
    }

    public final void setKeyListener(@Nullable KeyListener r1) {
        this.G.setKeyListener(r1);
    }

    public final void setLabel(@Nullable String r1) {
        this.s = r1;
        this.E.setText(r1);
    }

    public final void setLeftView(@NotNull Function1<? super FrameLayout, Unit> r2) {
        Intrinsics.f(r2, "creator");
        FrameLayout r1 = this.H;
        r1.removeAllViews();
        r2.invoke(r1);
        if (r1.getChildCount() <= 0) goto L5;
        boolean r3 = true;
    L6:
        ViewExtensionsKt.f(r1, r3);
        return;
    L5:
        r3 = false;
        goto L6
    }

    public void setLimitCount(int r2) {
        setLimitCountValue(r2);
        OEditText r3 = this.G;
        Editable r0 = r3.getText();
        if (r0 == null) goto L5;
        String r1 = r0.toString();
    L6:
        r(r1);
        i(r3.getText());
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void setLimitCountValue(int r1) {
        this.o = r1;
    }

    public final void setMaxLines(int r3) {
        int r0 = 1;
        if (r3 >= 1) goto L5;
        r3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    L5:
        this.f = r3;
        if (this.e == true) goto L9;
        r0 = r3;
    L9:
        this.G.setMaxLines(r0);
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener r3) {
        if (this.c == 1) goto L5;
    L7:
        super.setOnClickListener(r3);
        return;
    L5:
        if (this.b == true) goto L7;
        this.L.setOnClickListener(r3);
        this.G.setOnClickListener(r3);
        goto L7
    }

    public final void setOnComboArrowClickListener(@Nullable View.OnClickListener r2) {
        this.V = r2;
        this.L.setOnClickListener(r2);
        if (this.b == true) goto L8;
        View.OnClickListener r3 = this.V;
        if (r3 == null) goto L9;
        this.G.setOnClickListener(r3);
        return;
    L9:
        return;
    }

    @Override // android.view.View
    public void setOnFocusChangeListener(@Nullable View.OnFocusChangeListener r1) {
        this.G.setOnFocusChangeListener(r1);
    }

    public final void setOnTextClearedListener(@NotNull OnTextClearedListener r2) {
        Intrinsics.f(r2, "listener");
        this.T = r2;
    }

    public final void setOnTextExceedLengthListener(@Nullable OnTextExceedLengthListener r1) {
        this.U = r1;
    }

    public final void setRadius(int r2) {
        if (r2 != this.B) goto L5;
        return;
    L5:
        this.B = r2;
        this.C.setRadius(r2);
    }

    public final void setShowLabel(boolean r5) {
        this.p = r5;
        ViewExtensionsKt.f(this.D, r5);
        OEditText r6 = this.G;
        ViewGroup.LayoutParams r0 = r6.getLayoutParams();
        if (r0 == null) goto L12;
        ConstraintLayout.LayoutParams r1 = (ConstraintLayout.LayoutParams) r0;
        if (this.p == false) goto L8;
        int r2 = 16;
    L7:
        int r3 = a.d("Resources.getSystem()", 1, r2);
        r1.goneLeftMargin = r3;
        r1.goneStartMargin = r3;
        r6.setLayoutParams(r1);
        h("setShowLabel");
        return;
    L8:
        r2 = 12;
        goto L7
    L12:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public final void setShowLabelAnim(boolean r1) {
        this.q = r1;
        h("setShowLabelAnim");
    }

    public final void setShowLabelIcon(boolean r1) {
        this.r = r1;
        ViewExtensionsKt.f(this.F, r1);
    }

    public final void setShowLimitIndicator(boolean r1) {
        this.n = r1;
        Editable r2 = this.G.getText();
        if (r2 == null) goto L5;
        String r3 = r2.toString();
    L6:
        r(r3);
        return;
    L5:
        r3 = null;
        goto L6
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void setSingleLine(boolean r17) {
        this.e = r17;
        int r2 = getResources().getDimensionPixelSize(com.bytedance.securityserver.R.dimen.o_input_view_space_top_bottom);
        FrameLayout r4 = this.H;
        FrameLayout r5 = this.I;
        View r6 = this.f225J;
        View r9 = this.N;
        OEditText r12 = this.G;
        if (r17 == false) goto L40;
        ViewExtensionsKt.f(r9, false);
        r12.setMaxLines(1);
        r12.setSingleLine(true);
        ViewGroup.LayoutParams r1 = r12.getLayoutParams();
        if (r1 == null) goto L39;
        ConstraintLayout.LayoutParams r3 = (ConstraintLayout.LayoutParams) r1;
        ViewGroup.LayoutParams r10 = getLayoutParams();
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == true) goto L9;
        r10 = null;
    L9:
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) r10;
        if (r11 == null) goto L12;
        int r13 = r11.leftMargin;
    L13:
        ViewGroup.LayoutParams r14 = getLayoutParams();
        if ((r14 instanceof ViewGroup.MarginLayoutParams) == true) goto L16;
        r14 = null;
    L16:
        ViewGroup.MarginLayoutParams r15 = (ViewGroup.MarginLayoutParams) r14;
        if (r15 == null) goto L19;
        int r7 = r15.rightMargin;
    L20:
        r3.setMargins(r13, 0, r7, r2);
        r3.goneTopMargin = r2;
        if (this.p == false) goto L24;
        float r8 = 16;
    L23:
        int r16 = a.d("Resources.getSystem()", 1, r8);
        r3.goneLeftMargin = r16;
        r3.goneStartMargin = r16;
        r12.setLayoutParams(r3);
        ViewGroup.LayoutParams r18 = r6.getLayoutParams();
        if (r18 == null) goto L37;
        ConstraintLayout.LayoutParams r19 = (ConstraintLayout.LayoutParams) r18;
        r19.topToTop = 0;
        r19.bottomToBottom = 0;
        r6.setLayoutParams(r19);
        ViewGroup.LayoutParams r20 = r5.getLayoutParams();
        if (r20 == null) goto L35;
        ConstraintLayout.LayoutParams r21 = (ConstraintLayout.LayoutParams) r20;
        r21.topToTop = 0;
        r21.bottomToBottom = 0;
        r5.setLayoutParams(r21);
        ViewGroup.LayoutParams r22 = r4.getLayoutParams();
        if (r22 == null) goto L33;
        ConstraintLayout.LayoutParams r23 = (ConstraintLayout.LayoutParams) r22;
        float r24 = 4;
        r23.setMargins(a.d("Resources.getSystem()", 1, r24), a.d("Resources.getSystem()", 1, r24), 0, a.d("Resources.getSystem()", 1, r24));
        r23.topToTop = 0;
        r23.bottomToBottom = 0;
        r4.setLayoutParams(r23);
    L91:
        h("setSingleLine");
        return;
    L33:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L35:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L37:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L24:
        r8 = 12;
        goto L23
    L19:
        r7 = 0;
        goto L20
    L12:
        r13 = 0;
        goto L13
    L39:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L40:
        ViewExtensionsKt.f(r9, this.m);
        r12.setMaxLines(this.f);
        r12.setSingleLine(false);
        r12.setPadding(getPaddingLeft(), a.d("Resources.getSystem()", 1, 2), getPaddingRight(), getPaddingBottom());
        r12.setGravity(48);
        ViewGroup.LayoutParams r25 = r12.getLayoutParams();
        if (r25 == null) goto L100;
        ConstraintLayout.LayoutParams r26 = (ConstraintLayout.LayoutParams) r25;
        ViewGroup.LayoutParams r27 = getLayoutParams();
        if ((r27 instanceof ViewGroup.MarginLayoutParams) == true) goto L45;
        r27 = null;
    L45:
        ViewGroup.MarginLayoutParams r28 = (ViewGroup.MarginLayoutParams) r27;
        if (r28 == null) goto L48;
        int r29 = r28.leftMargin;
    L49:
        ViewGroup.LayoutParams r30 = getLayoutParams();
        if ((r30 instanceof ViewGroup.MarginLayoutParams) == true) goto L52;
        r30 = null;
    L52:
        ViewGroup.MarginLayoutParams r31 = (ViewGroup.MarginLayoutParams) r30;
        if (r31 == null) goto L55;
        int r32 = r31.rightMargin;
    L56:
        float r33 = 8;
        r26.setMargins(r29, 0, r32, a.d("Resources.getSystem()", 1, r33));
        r26.goneTopMargin = a.d("Resources.getSystem()", 1, r33);
        if (this.p == false) goto L60;
        float r34 = 16;
    L59:
        int r35 = a.d("Resources.getSystem()", 1, r34);
        r26.goneLeftMargin = r35;
        r26.goneStartMargin = r35;
        r12.setLayoutParams(r26);
        ViewGroup.LayoutParams r36 = r6.getLayoutParams();
        if (r36 == null) goto L98;
        ConstraintLayout.LayoutParams r37 = (ConstraintLayout.LayoutParams) r36;
        r37.topToTop = 0;
        ViewGroup.LayoutParams r38 = getLayoutParams();
        if ((r38 instanceof ViewGroup.MarginLayoutParams) == true) goto L66;
        r38 = null;
    L66:
        ViewGroup.MarginLayoutParams r39 = (ViewGroup.MarginLayoutParams) r38;
        if (r39 == null) goto L70;
        int r40 = r39.leftMargin;
    L71:
        float r41 = 4;
        int r42 = a.d("Resources.getSystem()", 1, r41);
        ViewGroup.LayoutParams r43 = getLayoutParams();
        if ((r43 instanceof ViewGroup.MarginLayoutParams) == true) goto L74;
        r43 = null;
    L74:
        ViewGroup.MarginLayoutParams r44 = (ViewGroup.MarginLayoutParams) r43;
        if (r44 == null) goto L77;
        int r45 = r44.rightMargin;
    L78:
        ViewGroup.LayoutParams r46 = getLayoutParams();
        if ((r46 instanceof ViewGroup.MarginLayoutParams) == true) goto L81;
        ViewGroup.LayoutParams r110 = null;
    L82:
        ViewGroup.MarginLayoutParams r111 = (ViewGroup.MarginLayoutParams) r110;
        if (r111 == null) goto L85;
        int r47 = r111.bottomMargin;
    L86:
        r37.setMargins(r40, r42, r45, r47);
        r37.bottomToBottom = -1;
        r6.setLayoutParams(r37);
        ViewGroup.LayoutParams r48 = r5.getLayoutParams();
        if (r48 == null) goto L96;
        ConstraintLayout.LayoutParams r49 = (ConstraintLayout.LayoutParams) r48;
        r49.topToTop = 0;
        r49.bottomToBottom = 0;
        r5.setLayoutParams(r49);
        ViewGroup.LayoutParams r50 = r4.getLayoutParams();
        if (r50 == null) goto L94;
        ConstraintLayout.LayoutParams r51 = (ConstraintLayout.LayoutParams) r50;
        r51.setMargins(a.d("Resources.getSystem()", 1, r41), a.d("Resources.getSystem()", 1, r41), 0, 0);
        r51.topToTop = 0;
        r51.bottomToBottom = -1;
        r4.setLayoutParams(r51);
        goto L91
    L94:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L96:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L85:
        r47 = 0;
        goto L86
    L81:
        r110 = r46;
        goto L82
    L77:
        r45 = 0;
        goto L78
    L70:
        r40 = 0;
        goto L71
    L98:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L60:
        r34 = 12;
        goto L59
    L55:
        r32 = 0;
        goto L56
    L48:
        r29 = 0;
        goto L49
    L100:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public final void setText(@Nullable String r2) {
        OEditText r0 = this.G;
        r0.setText(r2);
        h("setText");
        i(r0.getText());
    }
}
