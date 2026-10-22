package x;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.fragment.app.FragmentTransaction;
import com.bumptech.glide.load.engine.bitmap_recycle.f;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
public final class e implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f22928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f22929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.lynx.animax.player.b f22930c;
    public ByteBuffer d;
    public byte[] e;
    public short[] f;
    public byte[] g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public byte[] f22931h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public byte[] f22932i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int[] f22933j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f22934k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public c f22935l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Bitmap f22936m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f22937n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f22938o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f22939p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f22940q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f22941r;
    public Boolean s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Bitmap.Config f22942t;

    public e(com.lynx.animax.player.b r5, c r10, ByteBuffer r11, int r12) {
        this.f22929b = new int[256];
        this.f22942t = Bitmap.Config.ARGB_8888;
        this.f22930c = r5;
        this.f22935l = new c();
        monitor-enter(this);
        if (r12 <= 0) goto L25;
        int r13 = Integer.highestOneBit(r12);     // Catch: Throwable -> L11
        this.f22938o = 0;     // Catch: Throwable -> L11
        this.f22935l = r10;     // Catch: Throwable -> L11
        this.f22934k = -1;     // Catch: Throwable -> L11
        ByteBuffer r14 = r11.asReadOnlyBuffer();     // Catch: Throwable -> L11
        this.d = r14;     // Catch: Throwable -> L11
        r14.position(0);     // Catch: Throwable -> L11
        this.d.order(ByteOrder.LITTLE_ENDIAN);     // Catch: Throwable -> L11
        this.f22937n = false;     // Catch: Throwable -> L11
        Iterator r15 = r10.e.iterator();     // Catch: Throwable -> L11
    L7:
        if (r15.hasNext() == false) goto L13;
        if (((b) r15.next()).g != 3) goto L7;
        this.f22937n = true;     // Catch: Throwable -> L11
    L13:
        this.f22939p = r13;     // Catch: Throwable -> L11
        int r16 = r10.f;     // Catch: Throwable -> L11
        this.f22941r = r16 / r13;     // Catch: Throwable -> L11
        int r17 = r10.g;     // Catch: Throwable -> L11
        this.f22940q = r17 / r13;     // Catch: Throwable -> L11
        int r18 = r16 * r17;     // Catch: Throwable -> L11
        f r19 = (f) this.f22930c.f9658c;     // Catch: Throwable -> L11
        if (r19 != null) goto L16;
        byte[] r20 = new byte[r18];     // Catch: Throwable -> L11
    L17:
        this.f22932i = r20;     // Catch: Throwable -> L11
        com.lynx.animax.player.b r21 = this.f22930c;     // Catch: Throwable -> L11
        int r22 = this.f22941r * this.f22940q;     // Catch: Throwable -> L11
        f r23 = (f) r21.f9658c;     // Catch: Throwable -> L11
        if (r23 != null) goto L20;
        int[] r24 = new int[r22];     // Catch: Throwable -> L11
    L21:
        this.f22933j = r24;     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L20:
        r24 = (int[]) r23.c(r22, int[].class);     // Catch: Throwable -> L11
        goto L21
    L16:
        r20 = (byte[]) r19.c(r18, byte[].class);     // Catch: Throwable -> L11
        goto L17
    L25:
        throw new IllegalArgumentException("Sample size must be >=0, not: " + r12);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public final Bitmap a() {
        Boolean r5 = this.s;
        if (r5 != null) goto L5;
    L8:
        Bitmap.Config r10 = Bitmap.Config.ARGB_8888;
    L9:
        int r11 = this.f22941r;
        int r12 = this.f22940q;
        Bitmap r13 = ((com.bumptech.glide.load.engine.bitmap_recycle.a) this.f22930c.f9657b).a(r11, r12, r10);
        r13.setHasAlpha(true);
        return r13;
    L5:
        if (r5.booleanValue() == true) goto L8;
        r10 = this.f22942t;
        goto L9
    }

    public final synchronized Bitmap b() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.f22935l.f22919c <= 0) goto L12;
        if (this.f22934k < 0) goto L12;
    L15:
        int r5 = this.f22938o;     // Catch: Throwable -> L9
        if (r5 == 1) goto L54;
        if (r5 == 2) goto L54;
        this.f22938o = 0;     // Catch: Throwable -> L9
        if (this.e != null) goto L27;
        f r10 = (f) this.f22930c.f9658c;     // Catch: Throwable -> L9
        if (r10 != null) goto L25;
        byte[] r11 = new byte[255];     // Catch: Throwable -> L9
    L26:
        this.e = r11;     // Catch: Throwable -> L9
        goto L27
    L25:
        r11 = (byte[]) r10.c(255, byte[].class);     // Catch: Throwable -> L9
    L27:
        b r12 = (b) this.f22935l.e.get(this.f22934k);     // Catch: Throwable -> L9
        int r13 = this.f22934k - 1;     // Catch: Throwable -> L9
        if (r13 < 0) goto L30;
        b r14 = (b) this.f22935l.e.get(r13);     // Catch: Throwable -> L9
    L31:
        int[] r15 = r12.f22916k;     // Catch: Throwable -> L9
        if (r15 != null) goto L35;
        r15 = this.f22935l.f22917a;     // Catch: Throwable -> L9
    L35:
        this.f22928a = r15;     // Catch: Throwable -> L9
        if (r15 != null) goto L44;
        if (Log.isLoggable("e", 3) == false) goto L40;
        Log.d("e", "No valid color table found for frame #" + this.f22934k);     // Catch: Throwable -> L9
    L40:
        this.f22938o = 1;     // Catch: Throwable -> L9
        monitor-exit(this);
        return null;
    L44:
        if (r12.f == false) goto L50;
        System.arraycopy(r15, 0, this.f22929b, 0, r15.length);     // Catch: Throwable -> L9
        int[] r16 = this.f22929b;     // Catch: Throwable -> L9
        this.f22928a = r16;     // Catch: Throwable -> L9
        r16[r12.f22913h] = 0;     // Catch: Throwable -> L9
        if (r12.g != 2) goto L50;
        if (this.f22934k != 0) goto L50;
        this.s = Boolean.TRUE;     // Catch: Throwable -> L9
    L50:
        Bitmap r17 = d(r12, r14);     // Catch: Throwable -> L9
        monitor-exit(this);
        return r17;
    L30:
        r14 = null;
    L54:
        if (Log.isLoggable("e", 3) == false) goto L56;
        Log.d("e", "Unable to decode frame, status=" + this.f22938o);     // Catch: Throwable -> L9
    L56:
        monitor-exit(this);
        return null;
    L12:
        if (Log.isLoggable("e", 3) == false) goto L14;
        Log.d("e", "Unable to decode frame, frameCount=" + this.f22935l.f22919c + ", framePointer=" + this.f22934k);     // Catch: Throwable -> L9
    L14:
        this.f22938o = 1;     // Catch: Throwable -> L9
        goto L15
    }

    public final void c(Bitmap.Config r5) {
        Bitmap.Config r10 = Bitmap.Config.ARGB_8888;
        if (r5 == r10) goto L9;
        Bitmap.Config r11 = Bitmap.Config.RGB_565;
        if (r5 == r11) goto L9;
        throw new IllegalArgumentException("Unsupported format: " + r5 + ", must be one of " + r10 + " or " + r11);
    L9:
        this.f22942t = r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v32, types: [short] */
    /* JADX WARN: Type inference failed for: r5v34 */
    public final Bitmap d(b r34, b r35) {
        int[] r10 = this.f22933j;
        com.lynx.animax.player.b r11 = this.f22930c;
        byte r12 = 0;
        if (r35 != null) goto L9;
        Bitmap r5 = this.f22936m;
        if (r5 == null) goto L7;
        ((com.bumptech.glide.load.engine.bitmap_recycle.a) r11.f9657b).b(r5);
    L7:
        this.f22936m = null;
        Arrays.fill(r10, 0);
    L9:
        if (r35 == null) goto L16;
        if (r35.g != 3) goto L16;
        if (this.f22936m != null) goto L16;
        Arrays.fill(r10, 0);
    L16:
        if (r35 == null) goto L37;
        int r13 = r35.g;
        if (r13 <= 0) goto L37;
        if (r13 == 2) goto L21;
        if (r13 != 3) goto L37;
        Bitmap r14 = this.f22936m;
        if (r14 == null) goto L37;
        int r15 = this.f22941r;
        r14.getPixels(r10, 0, r15, 0, 0, r15, this.f22940q);
        goto L37
    L21:
        if (r34.f == true) goto L26;
        c r16 = this.f22935l;
        int r17 = r16.f22923k;
        if (r34.f22916k != null) goto L25;
    L27:
        int r18 = r35.d;
        int r19 = this.f22939p;
        int r20 = r18 / r19;
        int r21 = r35.f22911b / r19;
        int r22 = r35.f22912c / r19;
        int r23 = r35.f22910a / r19;
        int r24 = this.f22941r;
        int r25 = (r21 * r24) + r23;
        int r26 = (r20 * r24) + r25;
    L28:
        if (r25 >= r26) goto L37;
        int r27 = r25 + r22;
        int r28 = r25;
    L30:
        if (r28 >= r27) goto L32;
        r10[r28] = r17;
        r28 = r28 + 1;
        goto L30
    L32:
        r25 = r25 + this.f22941r;
        goto L28
    L25:
        if (r16.f22922j != r34.f22913h) goto L27;
    L26:
        r17 = 0;
    L37:
        this.d.position(r34.f22915j);
        int r29 = r34.f22912c * r34.d;
        byte[] r30 = this.f22932i;
        if (r30 != null) goto L40;
    L41:
        f r31 = (f) r11.f9658c;
        if (r31 != null) goto L44;
        byte[] r32 = new byte[r29];
    L45:
        this.f22932i = r32;
    L46:
        byte[] r33 = this.f22932i;
        if (this.f != null) goto L49;
        this.f = new short[4096];
    L49:
        short[] r36 = this.f;
        if (this.g != null) goto L52;
        this.g = new byte[4096];
    L52:
        byte[] r37 = this.g;
        if (this.f22931h != null) goto L55;
        this.f22931h = new byte[FragmentTransaction.TRANSIT_FRAGMENT_OPEN];
    L55:
        byte[] r38 = this.f22931h;
        int r39 = this.d.get() & UByte.MAX_VALUE;
        int r110 = 1 << r39;
        int r111 = r110 + 1;
        int r112 = r110 + 2;
        int r40 = r39 + 1;
        int r113 = (1 << r40) - 1;
        int r114 = 0;
    L56:
        if (r114 >= r110) goto L58;
        r36[r114] = 0;
        r37[r114] = (byte) r114;
        r114 = r114 + 1;
        goto L56
    L58:
        byte[] r41 = this.e;
        int r210 = r40;
        int r115 = 0;
        int r211 = 0;
        int r212 = 0;
        int r213 = 0;
        int r214 = 0;
        int r215 = 0;
        int r216 = 0;
        int r217 = 0;
        int r218 = r112;
        int r219 = r113;
        int r116 = -1;
    L60:
        if (r115 >= r29) goto L97;
        if (r211 != 0) goto L69;
        int r42 = this.d.get() & UByte.MAX_VALUE;
        if (r42 <= 0) goto L66;
        ByteBuffer r117 = this.d;
        r117.get(this.e, 0, Math.min(r42, r117.remaining()));
    L66:
        if (r42 <= 0) goto L67;
        r211 = r42;
        r212 = 0;
    L70:
        r214 = r214 + ((r41[r212] & UByte.MAX_VALUE) << r213);
        r212 = r212 + 1;
        r211 = r211 - 1;
        r116 = r116;
        int r118 = r213 + 8;
        r218 = r218;
        r210 = r210;
        r115 = r115;
        r41 = r41;
        r216 = r216;
    L71:
        if (r118 < r210) goto L96;
        r10 = r10;
        int r119 = r214 & r219;
        r214 = r214 >> r210;
        r118 = r118 - r210;
        if (r119 == r110) goto L74;
        if (r119 == r111) goto L76;
        if (r116 == (-1)) goto L79;
        if (r119 < r218) goto L82;
        r38[r217] = (byte) r216;
        r217 = r217 + 1;
        short r43 = r116;
    L83:
        if (r43 < r110) goto L85;
        r38[r217] = r37[r43];
        r217 = r217 + 1;
        r43 = r36[r43];
        goto L83
    L85:
        int r44 = r37[r43] & UByte.MAX_VALUE;
        byte r120 = (byte) r44;
        r33[r215] = r120;
    L86:
        r215 = r215 + 1;
        r115 = r115 + 1;
        if (r217 <= 0) goto L90;
        r217 = r217 - 1;
        r33[r215] = r38[r217];
        goto L86
    L90:
        if (r218 >= 4096) goto L95;
        r36[r218] = (short) r116;
        r37[r218] = r120;
        r218 = r218 + 1;
        if ((r218 & r219) != 0) goto L95;
        if (r218 >= 4096) goto L95;
        r210 = r210 + 1;
        r219 = r219 + r218;
    L95:
        r116 = r119;
        r118 = r118;
        r216 = r44;
        goto L71
    L82:
        r43 = r119;
        goto L83
    L79:
        r33[r215] = r37[r119];
        r215 = r215 + 1;
        r115 = r115 + 1;
        r216 = r119;
        r116 = r216;
        r118 = r118;
        goto L71
    L76:
        r10 = r10;
        r213 = r118;
        r12 = 0;
        goto L60
    L74:
        r218 = r112;
        r219 = r113;
        r210 = r40;
        r116 = -1;
        goto L71
    L96:
        r213 = r118;
        r12 = 0;
        goto L60
    L67:
        this.f22938o = 3;
        byte r121 = 0;
    L98:
        Arrays.fill(r33, r215, r29, r121);
        if (r34.e == false) goto L101;
    L134:
        int[] r45 = this.f22933j;
        int r46 = r34.d;
        int r47 = this.f22939p;
        int r48 = r46 / r47;
        int r49 = r34.f22911b / r47;
        int r50 = r34.f22912c / r47;
        int r51 = r34.f22910a / r47;
        if (this.f22934k != 0) goto L137;
        boolean r122 = true;
    L138:
        int r52 = this.f22941r;
        int r53 = this.f22940q;
        byte[] r123 = this.f22932i;
        int[] r124 = this.f22928a;
        Boolean r125 = this.s;
        int r126 = 8;
        int r127 = 0;
        int r128 = 0;
        int r129 = 1;
    L139:
        if (r127 >= r48) goto L211;
        Boolean r310 = r125;
        if (r34.e == false) goto L155;
        if (r128 < r48) goto L153;
        int r130 = r129 + 1;
        int r131 = r48;
        if (r130 != 2) goto L146;
        r128 = 4;
    L149:
        r129 = r130;
    L154:
        int r54 = r128 + r126;
    L156:
        int r132 = r128 + r49;
        if (r47 != 1) goto L159;
        boolean r133 = true;
    L160:
        if (r132 >= r53) goto L209;
        int r134 = r132 * r52;
        int r135 = r134 + r51;
        int r55 = r135 + r50;
        int r136 = r134 + r52;
        if (r136 >= r55) goto L164;
        r55 = r136;
    L164:
        int r137 = (r127 * r47) * r34.f22912c;
        if (r133 == false) goto L177;
        r125 = r310;
        int r56 = r135;
    L167:
        if (r56 >= r55) goto L175;
        int r220 = r50;
        int r57 = r124[r123[r137] & UByte.MAX_VALUE];
        if (r57 == 0) goto L171;
        r45[r56] = r57;
    L174:
        r137 = r137 + r47;
        r56 = r56 + 1;
        r50 = r220;
        goto L167
    L171:
        if (r122 == false) goto L174;
        if (r125 != null) goto L174;
        r125 = Boolean.TRUE;
        goto L174
    L175:
        int r221 = r50;
    L176:
        int r222 = r51;
        int r311 = r52;
        int r312 = r53;
    L210:
        r127 = r127 + 1;
        r48 = r131;
        r128 = r54;
        r49 = r49;
        r50 = r221;
        r51 = r222;
        r52 = r311;
        r53 = r312;
        goto L139
    L177:
        r221 = r50;
        int r58 = ((r55 - r135) * r47) + r137;
        r125 = r310;
        int r59 = r135;
    L178:
        if (r59 >= r55) goto L176;
        int r138 = r55;
        int r60 = r34.f22912c;
        int r223 = r51;
        int r313 = r52;
        int r61 = r137;
        int r224 = 0;
        int r225 = 0;
        int r226 = 0;
        int r227 = 0;
        int r228 = 0;
    L181:
        if (r61 >= (this.f22939p + r137)) goto L189;
        byte[] r62 = this.f22932i;
        int r314 = r53;
        if (r61 >= r62.length) goto L190;
        if (r61 >= r58) goto L190;
        int r63 = this.f22928a[r62[r61] & UByte.MAX_VALUE];
        if (r63 == 0) goto L188;
        r224 = r224 + ((r63 >> 24) & 255);
        r225 = r225 + ((r63 >> 16) & 255);
        r226 = r226 + ((r63 >> 8) & 255);
        r227 = r227 + (r63 & 255);
        r228 = r228 + 1;
    L188:
        r61 = r61 + 1;
        r53 = r314;
    L190:
        int r64 = r60 + r137;
        int r65 = r64;
    L192:
        if (r65 >= (this.f22939p + r64)) goto L200;
        byte[] r66 = this.f22932i;
        if (r65 >= r66.length) goto L200;
        if (r65 >= r58) goto L200;
        int r67 = this.f22928a[r66[r65] & UByte.MAX_VALUE];
        if (r67 == 0) goto L199;
        r224 = r224 + ((r67 >> 24) & 255);
        r225 = r225 + ((r67 >> 16) & 255);
        r226 = r226 + ((r67 >> 8) & 255);
        r227 = r227 + (r67 & 255);
        r228 = r228 + 1;
    L199:
        r65 = r65 + 1;
    L200:
        if (r228 != 0) goto L202;
        int r68 = 0;
    L203:
        if (r68 == 0) goto L205;
        r45[r59] = r68;
    L208:
        r137 = r137 + r47;
        r59 = r59 + 1;
        r55 = r138;
        r51 = r223;
        r52 = r313;
        r53 = r314;
        goto L178
    L205:
        if (r122 == false) goto L208;
        if (r125 != null) goto L208;
        r125 = Boolean.TRUE;
        goto L208
    L202:
        r68 = ((((r224 / r228) << 24) | ((r225 / r228) << 16)) | ((r226 / r228) << 8)) | (r227 / r228);
        goto L203
    L189:
        r314 = r53;
        goto L190
    L209:
        r221 = r50;
        r222 = r51;
        r311 = r52;
        r312 = r53;
        r125 = r310;
        goto L210
    L159:
        r133 = false;
        goto L160
    L146:
        if (r130 != 3) goto L148;
        r126 = 4;
        r129 = r130;
        r128 = 2;
        goto L154
    L148:
        if (r130 != 4) goto L149;
        r129 = r130;
        r128 = 1;
        r126 = 2;
        goto L154
    L153:
        r131 = r48;
        goto L154
    L155:
        r131 = r48;
        r54 = r128;
        r128 = r127;
        goto L156
    L211:
        Boolean r315 = r125;
        if (this.s != null) goto L218;
        if (r315 != null) goto L215;
        boolean r139 = false;
    L216:
        this.s = Boolean.valueOf(r139);
        goto L218
    L215:
        r139 = r315.booleanValue();
    L218:
        if (this.f22937n == false) goto L227;
        int r69 = r34.g;
        if (r69 == 0) goto L224;
        if (r69 != 1) goto L227;
    L224:
        if (this.f22936m != null) goto L226;
        this.f22936m = a();
    L226:
        Bitmap r70 = this.f22936m;
        int r71 = this.f22941r;
        r70.setPixels(r10, 0, r71, 0, 0, r71, this.f22940q);
    L227:
        Bitmap r72 = a();
        int r73 = this.f22941r;
        r72.setPixels(r10, 0, r73, 0, 0, r73, this.f22940q);
        return r72;
    L137:
        r122 = false;
        goto L138
    L101:
        if (this.f22939p != 1) goto L134;
        int[] r74 = this.f22933j;
        int r75 = r34.d;
        int r76 = r34.f22911b;
        int r77 = r34.f22912c;
        int r78 = r34.f22910a;
        if (this.f22934k != 0) goto L106;
        byte r79 = 1;
    L107:
        int r80 = this.f22941r;
        byte[] r81 = this.f22932i;
        int[] r140 = this.f22928a;
        int r141 = r121;
        byte r142 = -1;
    L108:
        if (r141 >= r75) goto L122;
        int r143 = (r141 + r76) * r80;
        int r144 = r143 + r78;
        int r145 = r144 + r77;
        int r146 = r143 + r80;
        if (r146 >= r145) goto L112;
        r145 = r146;
    L112:
        int r147 = r34.f22912c * r141;
    L113:
        if (r144 >= r145) goto L121;
        int r148 = r75;
        byte r82 = r81[r147];
        int r149 = r76;
        int r83 = r82 & UByte.MAX_VALUE;
        if (r83 == r142) goto L120;
        int r84 = r140[r83];
        if (r84 == 0) goto L119;
        r74[r144] = r84;
        goto L120
    L119:
        r142 = r82;
    L120:
        r147 = r147 + 1;
        r144 = r144 + 1;
        r75 = r148;
        r76 = r149;
        goto L113
    L121:
        r141 = r141 + 1;
        goto L108
    L122:
        Boolean r85 = this.s;
        if (r85 == null) goto L127;
        if (r85.booleanValue() == false) goto L127;
    L131:
        boolean r150 = true;
    L133:
        this.s = Boolean.valueOf(r150);
    L127:
        if (this.s != null) goto L132;
        if (r79 == 0) goto L132;
        if (r142 != (-1)) goto L131;
    L132:
        r150 = false;
        goto L133
    L106:
        r79 = r121;
        goto L107
    L69:
        r40 = r40;
        r115 = r115;
        goto L70
    L97:
        r121 = r12;
        goto L98
    L44:
        r32 = (byte[]) r31.c(r29, byte[].class);
        goto L45
    L40:
        if (r30.length >= r29) goto L46;
        goto L41
    }
}
