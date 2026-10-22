package zm;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.behavior.shadow.text.AbsoluteSizeSpan;
import com.lynx.tasm.utils.DeviceUtils;
import com.lynx.tasm.utils.DisplayMetricsHolder;
import java.text.DecimalFormat;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public abstract class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DecimalFormat f23539a = null;

    static {
        f23539a = new DecimalFormat("###################.###########");
    }

    public static int a(int r10, Paint.FontMetricsInt r11, boolean r12) {
        int r5 = r11.top;
        int r13 = r11.ascent;
        int r14 = r11.descent;
        int r15 = r14 - r13;
        int r16 = (r10 - r15) / 2;
        int r17 = (r10 - r16) - r15;
        int r18 = r11.bottom;
        int r19 = r18 - r5;
        int r20 = (r10 - r19) / 2;
        int r21 = r13 - r16;
        r11.ascent = r21;
        int r22 = r14 + r17;
        r11.descent = r22;
        int r23 = r5 - r20;
        r11.top = r23;
        int r24 = r18 + ((r10 - r20) - r19);
        r11.bottom = r24;
        if (r22 >= 0) goto L5;
        r11.ascent = r21 - r22;
        r11.descent = 0;
    L5:
        int r25 = r11.ascent;
        if (r25 <= 0) goto L8;
        r11.descent -= r25;
        r11.ascent = 0;
    L8:
        if (r24 >= 0) goto L10;
        r11.top = r23 - r24;
        r11.bottom = 0;
    L10:
        int r26 = r11.top;
        if (r26 <= 0) goto L13;
        r11.bottom -= r26;
        r11.top = 0;
    L13:
        if (r12 == false) goto L17;
        return r5 - r11.top;
    L17:
        return r13 - r11.ascent;
    }

    public static TextPaint b(float r5, String r10) {
        TextPaint r11 = new TextPaint(1);
        r11.setTextSize(r5);
        if (TextUtils.isEmpty(r10) == true) goto L5;
        Typeface r12 = g0.a(0, r10);
    L6:
        if (r12 == null) goto L9;
        r11.setTypeface(r12);
        return r11;
    L9:
        r11.setTypeface(DeviceUtils.b());
        return r11;
    L5:
        r12 = null;
        goto L6
    }

    public static TextPaint c(q r10, Typeface r11) {
        TextPaint r12 = new TextPaint(1);
        r12.setTextSize(r10.f23523n);
        if (TextUtils.isEmpty(r10.f23529u) == true) goto L6;
        if (r11 == null) goto L6;
        r12.setTypeface(r11);
    L8:
        if (r10.E == true) goto L11;
        String r13 = r10.C;
    L10:
        String r5 = r13;
        String r14 = r10.D;
        int r15 = r10.f23517h;
        if (r15 == 0) goto L19;
    L22:
        h(r12, r10.f23529u, r15, r10.g, r5, r14, r10.A);
    L23:
        Integer r16 = r10.f23516c;
        if (r16 == null) goto L26;
        r12.setColor(r16.intValue());
    L26:
        float r17 = r10.f23521l;
        if (r17 == 1.0E21f) goto L29;
        r12.setLetterSpacing(r17 / r12.getTextSize());
    L29:
        com.lynx.tasm.behavior.ui.r r18 = r10.G;
        if (r18 == null) goto L32;
        r12.setShadowLayer(r18.d, r18.f10592b, r18.f10593c, r18.f10591a);
    L32:
        return r12;
    L19:
        if (r10.g != 0) goto L22;
        if (r5 != null) goto L22;
        if (r14 == null) goto L23;
    L11:
        String r19 = r10.C;
        if (r19 != null) goto L15;
        r19 = "";
    L15:
        StringBuilder r20 = com.lynx.tasm.utils.j.d(r19, "'opsz' ");
        r20.append(r10.f23523n);
        r13 = r20.toString();
    L6:
        r12.setTypeface(DeviceUtils.b());
        goto L8
    }

    public static JavaOnlyMap d(String r10, String r11, String r12, String r13, int r14) {
        float r15 = com.lynx.tasm.utils.k.c(r11, 0.0f, 0.0f, 0.0f, 0.0f, com.lynx.tasm.utils.g.a(14.0f, 0.0f), DisplayMetricsHolder.a());
        if (TextUtils.isEmpty(r13) == false) goto L5;
        float r16 = 0.0f;
    L6:
        JavaOnlyMap r5 = new JavaOnlyMap();
        if (r10.isEmpty() == false) goto L9;
    L28:
        r5.putDouble("width", 0.0f);
        return r5;
    L9:
        if (r15 <= 0.0f) goto L28;
        if (r14 > 1) goto L13;
    L15:
        if (r14 == 1) goto L17;
    L19:
        TextPaint r17 = b(r15, r12);
        JavaOnlyArray r18 = new JavaOnlyArray();
        int r19 = 0;
        StaticLayout.Builder r110 = StaticLayout.Builder.obtain(r10, 0, r10.length(), r17, (int) Math.floor(r16));
        r110.setMaxLines(r14);
        StaticLayout r111 = r110.build();
        float r112 = -1.0f;
        int r113 = 0;
    L21:
        if (r113 >= r111.getLineCount()) goto L23;
        r112 = Math.max(r112, r111.getLineMax(r113));
        r113 = r113 + 1;
        goto L21
    L23:
        float r114 = r112 / DisplayMetricsHolder.a().density;
        int r115 = r111.getLineCount();
    L24:
        if (r19 >= r115) goto L26;
        r18.add(r10.substring(r111.getLineStart(r19), r111.getLineEnd(r19)));
        r19 = r19 + 1;
        goto L24
    L26:
        r5.putDouble("width", r114);
        r5.putArray("content", r18);
        return r5;
    L17:
        if (r16 >= 1.0f) goto L19;
        r16 = 32767.0f;
        goto L19
    L13:
        if (r16 >= 1.0f) goto L15;
    L5:
        r16 = com.lynx.tasm.utils.k.c(r13, 0.0f, 0.0f, 0.0f, 0.0f, com.lynx.tasm.utils.g.a(0.0f, 0.0f), DisplayMetricsHolder.a());
        goto L6
    }

    public static void e(Canvas r22, Layout r23) {
        Spanned r5 = (Spanned) r23.getText();
        r[] r10 = (r[]) r5.getSpans(0, r5.length(), r.class);
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.length == 0) goto L51;
        int r11 = r5.getSpanStart(r10[0]);
        int r12 = r5.getSpanEnd(r10[0]);
        int r13 = (int) r23.getPaint().getTextSize();
        if (r11 != 0) goto L35;
        int r14 = 1;
    L11:
        if (r14 >= r10.length) goto L33;
        int r15 = r5.getSpanStart(r10[r14]);
        int r16 = r5.getSpanEnd(r10[r14]);
        AbsoluteSizeSpan[] r17 = (AbsoluteSizeSpan[]) r5.getSpans(r15, r16, AbsoluteSizeSpan.class);
        if (r17.length == 0) goto L15;
        int r20 = r17[0].getSize();
    L16:
        r r18 = r10[r14];
        f(r22, r23, r18.f23537c, r18.d, r18.f23535a, r18.f23536b, r15, r16, r20);
        if (r15 < r11) goto L32;
        if (r16 > r12) goto L32;
        r r19 = r10[0];
        f(r22, r23, r19.f23537c, r19.d, r19.f23535a, r19.f23536b, r16 + 1, r12, r13);
        r r21 = r10[0];
        if (r21.f23535a == true) goto L22;
    L24:
        boolean r110 = false;
    L26:
        if (r21.f23536b == true) goto L28;
    L30:
        boolean r111 = false;
    L31:
        f(r22, r23, r21.f23537c, r21.d, r110, r111, r15, r16, r20);
        r12 = r15;
        goto L32
    L28:
        if (r10[r14].f23536b == true) goto L30;
        r111 = true;
        goto L31
    L22:
        if (r10[r14].f23535a == true) goto L24;
        r110 = true;
    L32:
        r14 = r14 + 1;
        goto L11
    L15:
        r20 = r13;
        goto L16
    L33:
        r r24 = r10[0];
        f(r22, r23, r24.f23537c, r24.d, r24.f23535a, r24.f23536b, r11, r12, r13);
        return;
    L35:
        int r25 = 0;
    L37:
        if (r25 >= r10.length) goto L52;
        int r26 = r5.getSpanStart(r10[r25]);
        int r27 = r5.getSpanEnd(r10[r25]);
        AbsoluteSizeSpan[] r28 = (AbsoluteSizeSpan[]) r5.getSpans(r26, r27, AbsoluteSizeSpan.class);
        if (r28.length == 0) goto L41;
        int r29 = r28[0].getSize();
    L42:
        r r30 = r10[r25];
        f(r22, r23, r30.f23537c, r30.d, r30.f23535a, r30.f23536b, r26, r27, r29);
        r25 = r25 + 1;
        goto L37
    L41:
        r29 = r13;
        goto L42
    L52:
        return;
    }

    public static void f(Canvas r27, Layout r28, int r29, int r30, boolean r31, boolean r32, int r33, int r34, int r35) {
        Layout r10 = r28;
        int r11 = r34;
        if (r33 >= r11) goto L110;
        if (r31 == true) goto L8;
        if (r32 == true) goto L8;
        return;
    L8:
        if (r29 != 4) goto L10;
        float r12 = r35;
        Paint r13 = new Paint();
        r13.setColor(r30);
        float r14 = r12 / 3.0f;
        r13.setStrokeWidth(r14 / 5.0f);
        int r15 = r10.getLineForOffset(r33);
        int r16 = r10.getLineForOffset(r11);
        int r17 = r15;
    L93:
        if (r17 > r16) goto L135;
        float r5 = r10.getLineLeft(r17);
        float r18 = r10.getLineBaseline(r17);
        float r19 = r10.getLineMax(r17);
        if (r17 != r15) goto L97;
        r19 = (r5 + r19) - r10.getPrimaryHorizontal(r33);
        r5 = r10.getPrimaryHorizontal(r33);
    L97:
        float r110 = r5;
        if (r17 != r16) goto L100;
        r19 = r10.getPrimaryHorizontal(r11) - r110;
    L100:
        float r111 = r19;
        if (r31 == false) goto L105;
        float r20 = (r14 / 3.0f) + r18;
        r27.drawLine(r110, r20, r110 + r111, r20, r13);
    L105:
        if (r32 == false) goto L109;
        float r21 = r18 - ((r12 / 15.0f) * 4.0f);
        r27.drawLine(r110, r21, r110 + r111, r21, r13);
    L109:
        r17 = r17 + 1;
        goto L93
    L135:
        return;
    L10:
        if (r29 != 8) goto L12;
        float r22 = r35;
        Paint r112 = new Paint();
        r112.setColor(r30);
        float r113 = r22 / 3.0f;
        int r114 = r10.getLineForOffset(r33);
        int r115 = r10.getLineForOffset(r11);
        float r116 = r113 / 5.0f;
        r112.setStrokeWidth(r116);
        int r23 = r114;
    L78:
        if (r23 > r115) goto L134;
        float r24 = r10.getLineLeft(r23);
        float r25 = r10.getLineBaseline(r23);
        float r26 = r10.getLineMax(r23);
        if (r23 != r114) goto L82;
        r26 = (r24 + r26) - r10.getPrimaryHorizontal(r33);
        r24 = r10.getPrimaryHorizontal(r33);
    L82:
        float r117 = r24;
        if (r23 != r115) goto L85;
        r26 = r10.getPrimaryHorizontal(r11) - r117;
    L85:
        float r118 = r26;
        if (r31 == false) goto L88;
        float r210 = (r113 / 3.0f) + r25;
        float r211 = r117 + r118;
        float r212 = r25;
        r27.drawLine(r117, r210, r211, r210, r112);
        float r36 = (r116 * 3.0f) + r212;
        r27.drawLine(r117, r36, r211, r36, r112);
    L89:
        if (r32 == false) goto L91;
        float r213 = r212 - ((r22 / 15.0f) * 4.0f);
        float r119 = r117 + r118;
        r27.drawLine(r117, r213, r119, r213, r112);
        float r37 = ((r113 / 15.0f) * 4.0f) + r213;
        r27.drawLine(r117, r37, r119, r37, r112);
    L91:
        r23 = r23 + 1;
        goto L78
    L88:
        r212 = r25;
        goto L89
    L134:
        return;
    L12:
        if (r29 != 16) goto L14;
        int r38 = 0;
        float r39 = r35;
        Paint r40 = new Paint();
        r40.setColor(r30);
        float r41 = r39 / 3.0f;
        float r120 = r39 / 4.0f;
        int r42 = r10.getLineForOffset(r33);
        int r121 = r10.getLineForOffset(r11);
        r40.setStrokeWidth(r41 / 5.0f);
        int r43 = r42;
    L55:
        if (r43 > r121) goto L132;
        float r122 = r10.getLineLeft(r43);
        float r123 = r10.getLineBaseline(r43);
        float r124 = r10.getLineMax(r43);
        if (r43 != r42) goto L59;
        r124 = (r122 + r124) - r10.getPrimaryHorizontal(r33);
        r122 = r10.getPrimaryHorizontal(r33);
    L59:
        if (r43 != r121) goto L61;
        r124 = r10.getPrimaryHorizontal(r11) - r122;
    L61:
        int r214 = r42;
        int r44 = (int) Math.floor(r124 / r120);
        if (r44 == 0) goto L133;
        if (r31 == false) goto L70;
        int r45 = r38;
        float r125 = 0.0f;
    L67:
        if (r45 >= (r44 + 1)) goto L69;
        r27.drawPoint(r122 + r125, (r41 / 3.0f) + r123, r40);
        r125 = r125 + r120;
        r45 = r45 + 1;
        r41 = r41;
        goto L67
    L69:
        float r310 = r41;
    L71:
        if (r32 == false) goto L76;
        float r126 = r123 - ((r39 / 15.0f) * 4.0f);
        int r46 = 0;
        float r47 = 0.0f;
    L74:
        if (r46 >= (r44 + 1)) goto L76;
        r27.drawPoint(r122 + r47, r126, r40);
        r47 = r47 + r120;
        r46 = r46 + 1;
    L76:
        r43 = r43 + 1;
        r42 = r214;
        r41 = r310;
        r38 = 0;
        goto L55
    L70:
        r310 = r41;
        goto L71
    L133:
        return;
    L132:
        return;
    L14:
        if (r29 != 32) goto L16;
        float r48 = r35;
        int r127 = r28.getLineForOffset(r33);
        int r128 = r28.getLineForOffset(r34);
        Paint r129 = new Paint();
        r129.setColor(r30);
        float r130 = r48 / 3.0f;
        r129.setStrokeWidth(r130 / 5.0f);
        r129.setPathEffect(new DashPathEffect(new float[]{r48 / 7.0f, r48 / 20.0f}, 0.0f));
        int r131 = r127;
    L40:
        if (r131 > r128) goto L131;
        float r49 = r28.getLineLeft(r131);
        float r50 = r28.getLineBaseline(r131);
        float r51 = r28.getLineMax(r131);
        if (r131 != r127) goto L44;
        r51 = (r49 + r51) - r28.getPrimaryHorizontal(r33);
        r49 = r28.getPrimaryHorizontal(r33);
    L44:
        float r132 = r49;
        if (r131 != r128) goto L47;
        r51 = r28.getPrimaryHorizontal(r34) - r132;
    L47:
        float r133 = r51;
        if (r31 == false) goto L51;
        float r52 = (r130 / 3.0f) + r50;
        r27.drawLine(r132, r52, r132 + r133, r52, r129);
    L51:
        if (r32 == false) goto L53;
        float r53 = r50 - ((r48 / 15.0f) * 4.0f);
        r27.drawLine(r132, r53, r132 + r133, r53, r129);
    L53:
        r131 = r131 + 1;
        goto L40
    L131:
        return;
    L16:
        if (r29 != 64) goto L129;
        float r54 = r35;
        float r55 = 2.0f;
        float r56 = r54 / 2.0f;
        float r134 = r54 / 3.0f;
        int r135 = r10.getLineForOffset(r33);
        int r57 = r10.getLineForOffset(r11);
        Paint r136 = new Paint();
        r136.setStyle(Paint.Style.STROKE);
        r136.setColor(r30);
        r136.setStrokeWidth(r134 / 5.0f);
        int r58 = r135;
    L19:
        if (r58 > r57) goto L130;
        float r59 = r10.getLineLeft(r58);
        float r137 = r10.getLineBaseline(r58);
        float r215 = r10.getLineMax(r58);
        if (r58 != r135) goto L23;
        r215 = (r59 + r215) - r10.getPrimaryHorizontal(r33);
        r59 = r10.getPrimaryHorizontal(r33);
    L23:
        if (r58 != r57) goto L25;
        r215 = r10.getPrimaryHorizontal(r11) - r59;
    L25:
        int r138 = Math.round(r215 / r56);
        if (r31 == false) goto L31;
        Path r139 = new Path();
        float r60 = (r134 / r55) + r137;
        r139.moveTo(r59, r60);
        int r61 = 0;
        float r216 = 0.0f;
    L28:
        if (r61 >= r138) goto L30;
        float r217 = r56 / 4.0f;
        r139.quadTo((r59 + r217) + r216, r137, ((r56 / 2.0f) + r59) + r216, r60);
        r139.quadTo(((r217 * 3.0f) + r59) + r216, r137 + r134, (r59 + r56) + r216, r60);
        r216 = r216 + r56;
        r61 = r61 + 1;
        r135 = r135;
        goto L28
    L30:
        int r218 = r135;
        r27.drawPath(r139, r136);
    L32:
        if (r32 == false) goto L37;
        Path r62 = new Path();
        float r63 = 4.0f;
        float r140 = r137 - ((r54 / 15.0f) * 4.0f);
        r62.moveTo(r59, r140);
        int r64 = 0;
        float r65 = 0.0f;
    L34:
        if (r64 >= r138) goto L36;
        float r141 = r56 / r63;
        float r219 = r134 / 2.0f;
        r62.quadTo((r59 + r141) + r65, r140 - r219, ((r56 / 2.0f) + r59) + r65, r140);
        r62.quadTo(((r141 * 3.0f) + r59) + r65, r140 + r219, (r59 + r56) + r65, r140);
        r65 = r65 + r56;
        r64 = r64 + 1;
        r54 = r54;
        r63 = 4.0f;
        goto L34
    L36:
        float r220 = r54;
        int r66 = 1;
        r27.drawPath(r62, r136);
    L38:
        r58 = r58 + r66;
        r10 = r28;
        r11 = r34;
        r57 = r57;
        r54 = r220;
        r135 = r218;
        r55 = 2.0f;
        goto L19
    L37:
        r220 = r54;
        r66 = 1;
        goto L38
    L31:
        r218 = r135;
        goto L32
    L130:
        return;
    L129:
        return;
    }

    public static void g(Layout r10, Canvas r11) {
        Spanned r5 = (Spanned) r10.getText();
        j[] r12 = (j[]) r5.getSpans(0, r5.length(), j.class);
        if (r12 != null) goto L5;
        return;
    L5:
        if (r12.length <= 0) goto L15;
        int r13 = r12.length;
        int r14 = 0;
    L7:
        if (r14 >= r13) goto L9;
        r12[r14].d = true;
        r14 = r14 + 1;
        goto L7
    L9:
        r10.draw(r11);
        int r15 = r12.length;
        int r16 = 0;
    L10:
        if (r16 >= r15) goto L16;
        r12[r16].d = false;
        r16 = r16 + 1;
        goto L10
    L16:
        return;
    }

    public static void h(TextPaint r5, String r10, int r11, int r12, String r13, String r14, boolean r15) {
        Typeface r16 = r5.getTypeface();
        int r17 = Build.VERSION.SDK_INT;
        boolean r18 = true;
        if (r12 != 1) goto L5;
        int r19 = 700;
    L9:
        if (r11 == 2) goto L12;
        r18 = false;
    L12:
        Typeface r20 = Typeface.create(r16, r19, r18);
        r5.setTypeface(r20);
        if (r11 > 0) goto L15;
    L22:
        if (r13 != null) goto L24;
        if (r14 != null) goto L24;
        return;
    L24:
        com.lynx.tasm.fontface.h r21 = new com.lynx.tasm.fontface.h(r13, r10, r5.getTextSize());
        com.lynx.tasm.fontface.g r22 = com.lynx.tasm.fontface.f.f10866a;
        Typeface r23 = (Typeface) r22.f10869c.get(r21);
        if (r23 == null) goto L27;
        r5.setTypeface(r23);
    L43:
        if (r14 == null) goto L47;
        r5.setFontFeatureSettings(r14);
        return;
    L47:
        return;
    L27:
        if (r13 != null) goto L29;
    L39:
        if (r15 == false) goto L43;
        Typeface r24 = r5.getTypeface();
        if (r24 == null) goto L43;
        r22.f10869c.put(r21, r24);
        goto L43
    L29:
        if (r17 == 35) goto L31;
    L38:
        r5.setFontVariationSettings(r13);
        goto L39
    L31:
        if (com.lynx.tasm.utils.j.j() == true) goto L38;
        String r25 = Build.BRAND;
        if (r25 == null) goto L38;
        if (r25.toLowerCase(Locale.ENGLISH).indexOf("honor") <= (-1)) goto L38;
    L15:
        if (TextUtils.isEmpty(r10) == false) goto L22;
        if (r20 == null) goto L18;
        int r26 = r20.getStyle();
    L19:
        int r27 = r11 & (~r26);
        r5.setFakeBoldText(false);
        if ((r27 & 2) == 0) goto L22;
        r5.setTextSkewX(-0.25f);
        goto L22
    L18:
        r26 = 0;
        goto L19
    L5:
        if (r12 != 0) goto L7;
        r19 = 400;
        goto L9
    L7:
        r19 = (r12 - 1) * 100;
        goto L9
    }
}
