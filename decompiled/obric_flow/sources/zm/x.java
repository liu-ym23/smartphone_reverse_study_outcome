package zm;

import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.shadow.MeasureMode;
import com.lynx.tasm.behavior.shadow.text.AbsoluteSizeSpan;
import java.text.Bidi;
import java.text.DecimalFormat;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Layout f23545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b0 f23546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f23547c;
    public float d;
    public float e;
    public float f;

    static {
        new BoringLayout.Metrics();
    }

    public x(LynxContext r14, b0 r15) {
        int r5 = 0;
        this.f23547c = 0;
        this.d = 0.0f;
        this.e = 0.0f;
        this.f = -1.0f;
        this.f23546b = r15;
        e(r14);
        if (r15.g == false) goto L27;
        if (r15.f23467h == true) goto L27;
        Layout r10 = this.f23545a;
        if (r10.getEllipsisCount(r10.getLineCount() - 1) == 0) goto L27;
        a0 r16 = r15.f23464a;
        if ((r16.f23459a instanceof SpannableStringBuilder) == false) goto L27;
        int r11 = this.f23545a.getLineCount() - 1;
        int r12 = this.f23545a.getEllipsisStart(r11) + this.f23545a.getLineStart(r11);
        SpannableStringBuilder r13 = new SpannableStringBuilder(r16.f23459a);
        j[] r17 = (j[]) r13.getSpans(0, 1, j.class);
        if (r17 == null) goto L27;
        if (r17.length == 0) goto L27;
        j[] r18 = (j[]) r13.getSpans(r12, r12 + 1, j.class);
        if (r18 == null) goto L27;
        if (r18.length == 0) goto L27;
        j r19 = r18[r18.length - 1];
        int r20 = r13.getSpanStart(r19);
        int r21 = r13.getSpanEnd(r19);
        r13.removeSpan(r19);
        if (r20 >= r12) goto L25;
        r13.setSpan(r19, r20, r12, 33);
    L25:
        r13.setSpan(new j(r17[0].f23494a), r12, r21, 34);
        r16.f23459a = r13;
        this.f23545a = null;
        e(r14);
    L27:
        if (this.f23545a.getWidth() != 0) goto L29;
        return;
    L29:
        if (this.f23545a.getHeight() == 0) goto L85;
        Spanned r110 = (Spanned) this.f23545a.getText();
        m[] r111 = (m[]) r110.getSpans(0, r110.length(), m.class);
        int r22 = r111.length;
        int r23 = 0;
    L32:
        if (r23 >= r22) goto L52;
        m r24 = r111[r23];
        int r25 = r110.getSpanStart(r24);
        int r26 = r110.getSpanEnd(r24);
        if (r25 == 0) goto L36;
    L38:
        int r27 = this.f23545a.getLineForOffset(r25);
        int r28 = this.f23545a.getLineForOffset(r26);
        Rect r29 = new Rect();
        int r30 = r27;
    L39:
        if (r30 > r28) goto L50;
        Rect r112 = new Rect();
        this.f23545a.getLineBounds(r30, r112);
        if (r30 != r27) goto L43;
        r112.left = Math.max(r112.left, (int) this.f23545a.getPrimaryHorizontal(r25));
    L43:
        if (r30 != r28) goto L46;
        r112.right = Math.min(r112.right, (int) this.f23545a.getPrimaryHorizontal(r26));
    L46:
        if (r112.right == 0) goto L49;
        r29.union(r112);
    L49:
        r30 = r30 + 1;
        goto L39
    L50:
        r24.f23503a.set(r29);
    L51:
        r23 = r23 + 1;
        goto L32
    L36:
        if (r26 != r110.length()) goto L38;
        float r31 = a();
        float r32 = -this.d;
        r24.f23503a.set(new Rect((int) r32, 0, (int) (r32 + r31), this.f23545a.getHeight()));
        goto L51
    L52:
        l[] r113 = (l[]) r110.getSpans(0, r110.length(), l.class);
    L54:
        if (r5 >= r113.length) goto L86;
        l r114 = r113[r5];
        Layout r33 = this.f23545a;
        r114.getClass();
        r114.d = new HashMap();
        int r34 = r33.getLineForOffset(r114.f23500a);
    L57:
        if (r34 > r33.getLineForOffset(r114.f23501b)) goto L73;
        int r35 = r33.getLineStart(r34);
        int r36 = r33.getLineEnd(r34);
        int r37 = r114.f23500a;
        if (r37 <= r35) goto L62;
        if (r37 >= r36) goto L62;
        r35 = r37;
    L62:
        int r38 = r114.f23501b;
        if (r38 <= r35) goto L66;
        if (r38 >= r36) goto L66;
        r36 = r38;
    L66:
        int r39 = (int) r33.getPrimaryHorizontal(r35);
        int r40 = (int) r33.getPrimaryHorizontal(r36);
        if (r35 != r33.getLineStart(r34)) goto L70;
        r39 = (int) r33.getLineLeft(r34);
    L70:
        if (r36 != r33.getLineEnd(r34)) goto L72;
        r40 = (int) r33.getLineRight(r34);
    L72:
        r114.d.put(Integer.valueOf(r34), new int[]{r39, r40});
        r34 = r34 + 1;
        goto L57
    L73:
        r5 = r5 + 1;
        goto L54
    L86:
        return;
    }

    public final float a() {
        float r5 = this.f;
        if (r5 < 0.0f) goto L5;
        return r5;
    L5:
        this.f = -1.0f;
        int r10 = 0;
    L6:
        int r11 = h();
        a0 r12 = this.f23546b.f23464a;
        if (r10 >= r11) goto L14;
        float r13 = this.f;
        if (r12.f23460b.a(false) != Layout.Alignment.ALIGN_NORMAL) goto L11;
        float r14 = this.f23545a.getLineMax(r10);
    L12:
        this.f = Math.max(r13, r14);
        r10 = r10 + 1;
        goto L6
    L11:
        r14 = this.f23545a.getLineMax(r10) - this.f23545a.getParagraphLeft(r10);
        goto L12
    L14:
        if (r12.f23459a.length() == 0) goto L27;
        if (r12.f23460b.f23517h == 2) goto L24;
        g[] r15 = (g[]) ((SpannableStringBuilder) r12.f23459a).getSpans(0, this.f23545a.getLineEnd(h() - 1), g.class);
        int r16 = 0;
    L21:
        if (r16 >= r15.length) goto L27;
        if (r15[r16].f23482a == 2) goto L24;
        r16 = r16 + 1;
    L24:
        this.f = (float) ((((double) (-this.f23545a.getLineAscent(0))) * 0.2d) + this.f);
    L27:
        return this.f;
    }

    public final float b(float r10) {
        if (this.f23545a.getLineLeft(0) != 0.0f) goto L6;
        return 0.0f;
    L6:
        if (this.f23545a.getAlignment() == Layout.Alignment.ALIGN_CENTER) goto L8;
        Layout.Alignment r5 = this.f23545a.getAlignment();
        Layout.Alignment r11 = Layout.Alignment.ALIGN_OPPOSITE;
        if (r5 == r11) goto L18;
        if (this.f23545a.getParagraphDirection(0) == (-1)) goto L18;
        if (this.f23545a.getParagraphAlignment(0) == r11) goto L18;
        return 0.0f;
    L18:
        return -(this.f23545a.getWidth() - r10);
    L8:
        return (-(this.f23545a.getWidth() - r10)) / 2.0f;
    }

    public final StaticLayout.Builder c(CharSequence r5, Layout.Alignment r10, TextPaint r11, float r12) {
        StaticLayout.Builder r13 = StaticLayout.Builder.obtain(r5, 0, r5.length(), r11, (int) Math.floor(r12));
        r13.setAlignment(r10);
        b0 r14 = this.f23546b;
        a0 r15 = r14.f23464a;
        r13.setLineSpacing(r15.f23460b.f23522m, 1.0f);
        r13.setIncludePad(r15.f23460b.f23528t);
        r13.setTextDirection(r15.f23460b.c());
        r13.setBreakStrategy(r14.f);
        r13.setUseLineSpacingFromFallbacks(true);
        return r13;
    }

    public final void d(int r5, w r10) {
        SpannableStringBuilder r11 = (SpannableStringBuilder) r10.f23542a;
        int r12 = 0;
        AbsoluteSizeSpan[] r13 = (AbsoluteSizeSpan[]) r11.getSpans(0, r11.length(), AbsoluteSizeSpan.class);
    L4:
        if (r12 >= r13.length) goto L6;
        r11.removeSpan(r13[r12]);
        r12 = r12 + 1;
        goto L4
    L6:
        r10.f.setTextSize(r5);
        f(r10);
    }

    public final void e(LynxContext r21) {
        b0 r5 = this.f23546b;
        a0 r10 = r5.f23464a;
        if (r10.f23459a == null) goto L218;
        w r11 = new w();
        DecimalFormat r12 = t.f23539a;
        q r13 = r10.f23460b;
        String r14 = r13.f23529u;
        if (TextUtils.isEmpty(r14) == true) goto L7;
        Typeface r15 = g0.c(r21, r14, r13.d());
    L8:
        r11.f = t.c(r10.f23460b, r15);
        q r16 = r10.f23460b;
        int r17 = r16.f23518i;
        if (r17 != 1) goto L11;
    L14:
        boolean r18 = true;
    L15:
        r11.f23543b = r18;
        if (r16.f23519j != 1) goto L18;
        boolean r19 = true;
    L19:
        if (r17 != 1) goto L21;
        int r20 = 1;
    L22:
        if (r19 == false) goto L26;
        if (r20 == (-1)) goto L25;
        int r22 = 0;
    L27:
        r11.d = r22;
        CharSequence r23 = r10.f23459a;
        int r24 = r16.f23515b;
        int r25 = r23.length();
        CharSequence r26 = r23;
        r26 = r23;
        if (r24 == (-1)) goto L37;
        if (r24 >= r25) goto L37;
        SpannableStringBuilder r27 = (SpannableStringBuilder) r23;
        SpannableStringBuilder r28 = (SpannableStringBuilder) r27.subSequence(0, Math.min(r27.length(), Math.max(0, r24)));
        a0 r29 = r5.f23464a;
        if (r29.f23460b.c() != TextDirectionHeuristics.LTR) goto L34;
        r28.append("\u200e");
    L36:
        r28.append("…");
        r26 = r28;
        goto L37
    L34:
        if (r29.f23460b.c() != TextDirectionHeuristics.RTL) goto L36;
        r28.append("\u200f");
    L37:
        r11.f23542a = r26;
        MeasureMode r30 = MeasureMode.f10340c;
        float r31 = r5.d;
        MeasureMode r110 = r5.f23465b;
        if (r110 != r30) goto L40;
    L43:
        float r32 = r31;
    L44:
        r11.f23544c = r32;
        boolean r33 = r11.f23543b;
        q r111 = r10.f23460b;
        if (r33 == false) goto L47;
        int r34 = 1;
    L48:
        r11.e = r34;
        if (r111.f23518i != 1) goto L57;
        String r35 = r26.toString();
        SpannableStringBuilder r36 = new SpannableStringBuilder(r11.f23542a);
        int r37 = r35.indexOf(10);
        if (r37 <= 0) goto L54;
        r36.delete(r37, r36.length());
    L54:
        r11.f23542a = r36;
        if (r10.f23460b.f23519j == 1) goto L57;
        r11.f23544c = 32767.0f;
    L57:
        f(r11);
        boolean r38 = r10.f23460b.f23530v;
        MeasureMode r39 = r5.f23466c;
        float r112 = r5.e;
        if (r38 == false) goto L133;
        if (r110 == MeasureMode.f10339b) goto L133;
        boolean r40 = k();
        int r113 = (int) r10.f23460b.f23523n;
        CharSequence r114 = r10.f23459a;
        AbsoluteSizeSpan[] r41 = (AbsoluteSizeSpan[]) ((Spanned) r114).getSpans(0, r114.length(), AbsoluteSizeSpan.class);
        int r42 = 0;
    L63:
        if (r42 >= r41.length) goto L68;
        if (r113 >= r41[r42].getSize()) goto L67;
        r113 = r41[r42].getSize();
    L67:
        r42 = r42 + 1;
        goto L63
    L68:
        if (r40 == true) goto L70;
    L106:
        q r43 = r10.f23460b;
        float[] r44 = r43.f23534z;
        if (r44 == null) goto L115;
        int r45 = 0;
    L110:
        if (r45 >= r44.length) goto L125;
        float r46 = r44[r45];
        if (r46 > r113) goto L113;
        r45 = r45 + 1;
        goto L110
    L113:
        int r47 = (int) r46;
    L126:
        if (r47 < 0) goto L133;
        d(r47, r11);
        if (k() == true) goto L130;
        r113 = r47;
        goto L106
    L130:
        d(r113, r11);
    L125:
        r47 = -1;
        goto L126
    L115:
        float r48 = r113;
        float r49 = r43.f23533y;
        if (r49 > 0.0f) goto L119;
        r49 = 1.0f;
    L119:
        int r50 = (int) (r49 + r48);
        if (r50 == r113) goto L125;
        if (r50 > r43.f23531w) goto L125;
        r47 = r50;
        goto L126
    L70:
        if (ym.k.b(r10.f23460b.f23520k) == true) goto L81;
        if (r39 == MeasureMode.f10339b) goto L81;
        if (r10.f23460b.f23520k <= r112) goto L81;
        if (this.f23545a.getLineCount() > h()) goto L81;
        Layout r51 = this.f23545a;
        if (r51.getEllipsisCount(r51.getLineCount() - 1) > 0) goto L81;
        Layout r52 = this.f23545a;
        if (r52.getLineEnd(r52.getLineCount() - 1) >= this.f23545a.getText().length()) goto L133;
    L81:
        q r53 = r10.f23460b;
        float[] r54 = r53.f23534z;
        if (r54 == null) goto L90;
        int r55 = r54.length - 1;
    L84:
        if (r55 < 0) goto L100;
        float r115 = r54[r55];
        if (r115 < r113) goto L87;
        r55 = r55 - 1;
        goto L84
    L87:
        int r56 = (int) r115;
    L88:
        r113 = r56;
    L101:
        if (r113 < 0) goto L133;
        d(r113, r11);
        if (k() == true) goto L81;
    L100:
        r113 = -1;
        goto L101
    L90:
        float r57 = r113;
        float r58 = r53.f23533y;
        if (r58 > 0.0f) goto L94;
        r58 = 1.0f;
    L94:
        r56 = (int) (r57 - r58);
        if (r56 == r113) goto L100;
        if (r56 < r53.f23532x) goto L100;
    L133:
        if (r11.d != (-1)) goto L135;
        int r59 = -1;
        float r116 = r31;
    L154:
        if (r11.d == r59) goto L198;
        TextDirectionHeuristic r60 = r10.f23460b.c();
        TextDirectionHeuristic r61 = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        boolean r62 = r5.g;
        if (r60 != r61) goto L159;
        if (r62 == false) goto L198;
    L159:
        int r63 = this.f23545a.getLineCount() - 1;
        int r64 = this.f23545a.getEllipsisCount(r63);
        this.f23547c = r64;
        if (r64 <= 0) goto L198;
        int r65 = this.f23545a.getEllipsisStart(r63) + this.f23545a.getLineStart(r63);
        SpannableStringBuilder r66 = new SpannableStringBuilder(this.f23545a.getText().subSequence(0, r65 + 1));
        if (r62 == false) goto L169;
        j[] r67 = (j[]) r66.getSpans(0, 1, j.class);
        if (r67 == null) goto L169;
        if (r67.length == 0) goto L169;
        r66.setSpan(new j(r67[0].f23494a), r65, r66.length(), 17);
        boolean r68 = true;
    L171:
        if (r10.f23460b.c() == r61) goto L183;
        if (r65 >= 0) goto L174;
    L182:
        r68 = true;
        goto L183
    L174:
        if (r65 > r66.length()) goto L182;
        if (r10.f23460b.c() != TextDirectionHeuristics.LTR) goto L180;
        r66.insert(r65, "\u200e");
        goto L182
    L180:
        if (r10.f23460b.c() != TextDirectionHeuristics.RTL) goto L182;
        r66.insert(r65, "\u200f");
    L183:
        if (r68 == false) goto L198;
        r11.f23542a = r66;
        r11.d = -1;
        int r69 = this.f23545a.getLineCount();
        f(r11);
        if (this.f23545a.getLineCount() <= r69) goto L198;
    L188:
        if (this.f23545a.getLineCount() <= r69) goto L198;
        int r70 = 2;
        if (r11.f23542a.length() < 2) goto L198;
        CharSequence r71 = r11.f23542a;
        if (Character.isLowSurrogate(r71.charAt(r71.length() - 2)) == true) goto L194;
    L196:
        r70 = 1;
    L197:
        CharSequence r72 = r11.f23542a;
        r11.f23542a = ((SpannableStringBuilder) r72).delete((r72.length() - 1) - r70, r11.f23542a.length() - 1);
        f(r11);
        goto L188
    L194:
        if (r11.f23542a.length() <= 2) goto L196;
    L169:
        r68 = false;
    L198:
        MeasureMode r73 = MeasureMode.f10340c;
        if (r110 != r73) goto L203;
        int r74 = 1;
        if (r10.f23460b.f23518i != 1) goto L213;
    L204:
        float r75 = a();
        q r76 = r10.f23460b;
        if (r76.f23518i != r74) goto L212;
        if (r110 != r73) goto L212;
        if (r116 <= r75) goto L212;
        if (r76.f23519j == r74) goto L213;
        this.d = b(r116);
    L212:
        this.d = b(r75);
    L213:
        this.e = 0.0f;
        if (j() == false) goto L238;
        this.e = t.a((int) Math.ceil(r10.f23460b.f23520k), this.f23545a.getPaint().getFontMetricsInt(), r10.f23460b.f23528t);
        return;
    L238:
        return;
    L203:
        r74 = 1;
        goto L204
    L135:
        float r77 = r10.f23460b.f23520k;
        int r78 = this.f23545a.getLineCount();
        int r79 = this.f23545a.getHeight();
        r116 = r31;
        if (ym.k.b(r77) == false) goto L139;
        double r80 = 0.0d;
    L140:
        int r81 = (int) Math.ceil(r112 + Math.max(r80, 0.0d));
        if (r39 == MeasureMode.f10339b) goto L145;
        if (r79 <= r81) goto L145;
        if (r11.f23543b == true) goto L145;
        int r82 = r78 - 1;
    L147:
        if (r82 <= 0) goto L150;
        if (this.f23545a.getLineBottom(r82) <= r112) goto L150;
        r82 = r82 - 1;
    L150:
        r59 = -1;
        r11.e = r82 + 1;
        r11.d = 0;
        f(r11);
    L145:
        r59 = -1;
        goto L154
    L139:
        double r83 = r77;
        r80 = (Math.ceil(r83) - r83) * ((double) r78);
        goto L140
    L47:
        r34 = r111.f23514a;
        goto L48
    L40:
        if (r110 == MeasureMode.d) goto L43;
        r32 = 32767.0f;
        goto L44
    L25:
        r22 = 1;
        goto L27
    L26:
        r22 = -1;
        goto L27
    L21:
        r20 = r16.f23514a;
        goto L22
    L18:
        r19 = false;
        goto L19
    L11:
        if (r16.f23514a == 1) goto L14;
        r18 = false;
        goto L15
    L7:
        r15 = null;
        goto L8
    L218:
        throw new RuntimeException("prepareSpan() should be called!");
    }

    public final void f(w r20) {
        b0 r5 = this.f23546b;
        a0 r10 = r5.f23464a;
        q r11 = r10.f23460b;
        int r12 = r11.d;
        if (r12 == 0) goto L6;
        if (r12 == 2) goto L6;
    L8:
        Layout.Alignment r13 = r11.a(false);
    L9:
        SpannableStringBuilder r14 = (SpannableStringBuilder) r20.f23542a;
        if (r5.f23468i == false) goto L38;
        q r15 = r10.f23460b;
        if (r15.f23527r == true) goto L38;
        if (r15.f23526q == true) goto L38;
        if (r15.e == 2) goto L38;
        if (r15.f23518i == 1) goto L26;
        if (r15.f23514a != 1) goto L24;
        if (r15.f23519j == 1) goto L26;
    L24:
        if (r5.f23465b != MeasureMode.f10339b) goto L38;
    L26:
        if (r14.length() != 0) goto L28;
    L31:
        BoringLayout.Metrics r16 = BoringLayout.isBoring(r20.f23542a, r20.f);
        if (r16 != null) goto L34;
    L39:
        if (r16 != null) goto L64;
        StaticLayout.Builder r17 = c(r20.f23542a, r13, r20.f, r20.f23544c);
        if (r20.d != 0) goto L43;
        r17.setEllipsize(TextUtils.TruncateAt.END).setEllipsizedWidth((int) Math.floor(r20.f23544c)).setMaxLines(r20.e);
    L43:
        int r18 = r20.e;
        if (r18 <= 0) goto L47;
        r17.setMaxLines(r18);
    L47:
        if (r20.f23543b == false) goto L49;
        r17.setMaxLines(1);
    L49:
        q r19 = r10.f23460b;
        if (r19.d != 5) goto L55;
        if (r19.f23527r == true) goto L55;
        r17.setJustificationMode(1);
    L55:
        if (r10.f23460b.B == false) goto L57;
        r17.setHyphenationFrequency(2);
        r17.setBreakStrategy(1);
    L57:
        StaticLayout r21 = r17.build();
        this.f23545a = r21;
        if (r20.d != 0) goto L64;
        r21.getLineCount();
        Layout r22 = this.f23545a;
        if (r22.getLineWidth(r22.getLineCount() - 1) <= r20.f23544c) goto L64;
        Layout r23 = this.f23545a;
        if (r23.getEllipsisCount(r23.getLineCount() - 1) <= 0) goto L64;
        StaticLayout.Builder r24 = c(r20.f23542a, r13, r20.f, r20.f23544c);
        r24.setMaxLines(r20.e);
        r24.setEllipsize(TextUtils.TruncateAt.END);
        double r25 = Math.floor(r20.f23544c) * 2.0d;
        Layout r26 = this.f23545a;
        r24.setEllipsizedWidth((int) (r25 - ((double) r26.getLineWidth(r26.getLineCount() - 1))));
        this.f23545a = r24.build();
    L64:
        this.f = -1.0f;
        return;
    L34:
        if (r20.d != 0) goto L36;
        CharSequence r27 = r20.f23542a;
        TextPaint r110 = r20.f;
        int r111 = (int) Math.floor(r20.f23544c);
        q r28 = r10.f23460b;
        BoringLayout r29 = BoringLayout.make(r27, r110, r111, r13, 1.0f, r28.f23522m, r16, r28.f23528t, TextUtils.TruncateAt.END, (int) Math.floor(r20.f23544c));
    L37:
        this.f23545a = r29;
        goto L39
    L36:
        CharSequence r30 = r20.f23542a;
        TextPaint r112 = r20.f;
        int r113 = (int) Math.floor(r20.f23544c);
        q r31 = r10.f23460b;
        r29 = BoringLayout.make(r30, r112, r113, r13, 1.0f, r31.f23522m, r16, r31.f23528t);
        goto L37
    L28:
        if (((d[]) r14.getSpans(0, r14.length(), d.class)).length != 0) goto L38;
        if (((k[]) r14.getSpans(0, r14.length(), k.class)).length == 0) goto L31;
    L38:
        r16 = null;
    L6:
        if (r11.e != 0) goto L8;
        r13 = r10.f23460b.a(!new Bidi(r20.f23542a.toString(), -2).baseIsLeftToRight());
        goto L9
    }

    public final int g() {
        b0 r5 = this.f23546b;
        if (r5.f23465b != MeasureMode.f10340c) goto L9;
        float r10 = this.f23545a.getWidth();
        float r11 = r5.d;
        if (r10 > r11) goto L9;
        double r12 = Math.ceil(r11);
    L8:
        return (int) r12;
    L9:
        r12 = Math.ceil(a());
        goto L8
    }

    public final int h() {
        int r5 = this.f23546b.f23464a.f23460b.f23514a;
        if (r5 == (-1)) goto L9;
        if (r5 > this.f23545a.getLineCount()) goto L9;
        return r5;
    L9:
        return this.f23545a.getLineCount();
    }

    public final int i() {
        boolean r5 = j();
        a0 r10 = this.f23546b.f23464a;
        if (r5 == true) goto L5;
        q r11 = r10.f23460b;
        int r12 = r11.f23514a;
        if (r11.f23518i == 1) goto L9;
        if (r12 == 1) goto L9;
    L11:
        if (r12 == (-1)) goto L18;
        if (r12 > this.f23545a.getLineCount()) goto L18;
        return this.f23545a.getLineBottom(r12 - 1);
    L18:
        return this.f23545a.getHeight();
    L9:
        r12 = 1;
        goto L11
    L5:
        return (int) Math.ceil(r10.f23460b.f23520k);
    }

    public final boolean j() {
        b0 r5 = this.f23546b;
        if (ym.k.b(r5.f23464a.f23460b.f23520k) == false) goto L5;
        return false;
    L5:
        if (r5.f23468i == true) goto L7;
        return false;
    L7:
        if (r5.f23467h == false) goto L18;
        q r10 = r5.f23464a.f23460b;
        if (r10.f23518i == 1) goto L11;
        return false;
    L11:
        if (r10.f23526q == false) goto L13;
        return false;
    L13:
        if (r10.f23527r == true) goto L21;
        return true;
    L21:
        return false;
    L18:
        return false;
    }

    public final boolean k() {
        b0 r5 = this.f23546b;
        if (r5.f23466c == MeasureMode.f10339b) goto L7;
        if (this.f23545a.getHeight() <= r5.e) goto L7;
    L17:
        return true;
    L7:
        if (a() > r5.d) goto L17;
        if (this.f23545a.getLineCount() > h()) goto L17;
        Layout r10 = this.f23545a;
        if (r10.getEllipsisCount(r10.getLineCount() - 1) > 0) goto L17;
        Layout r11 = this.f23545a;
        if (r11.getLineEnd(r11.getLineCount() - 1) < this.f23545a.getText().length()) goto L17;
        return false;
    }
}
