package androidx.vectordrawable.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import androidx.annotation.RestrictTo;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class AnimationUtilsCompat {
    private AnimationUtilsCompat() {
    }

    private static Interpolator createInterpolatorFromXml(Context r2, Resources r3, Resources.Theme r4, XmlPullParser r5) {
        int r6 = r5.getDepth();
        Interpolator r7 = null;
    L3:
        int r0 = r5.next();
        if (r0 != 3) goto L8;
        if (r5.getDepth() > r6) goto L8;
    L45:
        return r7;
    L8:
        if (r0 == 1) goto L45;
        if (r0 != 2) goto L3;
        AttributeSet r8 = Xml.asAttributeSet(r5);
        String r1 = r5.getName();
        if (r1.equals("linearInterpolator") == true) goto L14;
        if (r1.equals("accelerateInterpolator") == true) goto L17;
        if (r1.equals("decelerateInterpolator") == true) goto L21;
        if (r1.equals("accelerateDecelerateInterpolator") == false) goto L26;
        r7 = new AccelerateDecelerateInterpolator();
        goto L3
    L26:
        if (r1.equals("cycleInterpolator") == true) goto L27;
        if (r1.equals("anticipateInterpolator") == true) goto L30;
        if (r1.equals("overshootInterpolator") == true) goto L33;
        if (r1.equals("anticipateOvershootInterpolator") == true) goto L36;
        if (r1.equals("bounceInterpolator") == false) goto L41;
        r7 = new BounceInterpolator();
        goto L3
    L41:
        if (r1.equals("pathInterpolator") == false) goto L44;
        Interpolator r9 = new PathInterpolatorCompat(r2, r8, r5);
    L18:
        r7 = r9;
        goto L3
    L44:
        throw new RuntimeException("Unknown interpolator name: " + r5.getName());
    L36:
        r9 = new AnticipateOvershootInterpolator(r2, r8);
        goto L18
    L33:
        r9 = new OvershootInterpolator(r2, r8);
        goto L18
    L30:
        r9 = new AnticipateInterpolator(r2, r8);
        goto L18
    L27:
        r9 = new CycleInterpolator(r2, r8);
        goto L18
    L21:
        r9 = new DecelerateInterpolator(r2, r8);
        goto L18
    L17:
        r9 = new AccelerateInterpolator(r2, r8);
        goto L18
    L14:
        r7 = new LinearInterpolator();
        goto L3
    }

    public static Interpolator loadInterpolator(Context r4, int r5) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        XmlResourceParser r0 = null;
        if (r5 != 17563663) goto L17;
        return new FastOutLinearInInterpolator();
    L17:
        if (r5 != 17563661) goto L21;
        return new FastOutSlowInInterpolator();
    L21:
        if (r5 == 17563662) goto L23;
        XmlResourceParser r1 = r4.getResources().getAnimation(r5);     // Catch: Throwable -> L10 IOException -> L12 XmlPullParserException -> L14
        Interpolator r6 = createInterpolatorFromXml(r4, r4.getResources(), r4.getTheme(), r1);     // Catch: Throwable -> L10 IOException -> L12 XmlPullParserException -> L14
        if (r1 == null) goto L27;
        r1.close();
    L27:
        return r6;
    L23:
        return new LinearOutSlowInInterpolator();
    L10:
        th = move-exception;
        if (0 == 0) goto L34;
        r0.close();
    L34:
        throw th;
    L12:
        e = move-exception;
        Resources.NotFoundException r2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(r5));     // Catch: Throwable -> L10
        r2.initCause(e);     // Catch: Throwable -> L10
        throw r2;     // Catch: Throwable -> L10
    L14:
        e = move-exception;
        Resources.NotFoundException r3 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(r5));     // Catch: Throwable -> L10
        r3.initCause(e);     // Catch: Throwable -> L10
        throw r3;     // Catch: Throwable -> L10
    L5:
        return AnimationUtils.loadInterpolator(r4, r5);
    }
}
