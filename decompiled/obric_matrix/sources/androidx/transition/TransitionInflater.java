package androidx.transition;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.res.TypedArrayUtils;
import java.io.IOException;
import java.lang.reflect.Constructor;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class TransitionInflater {
    private static final ArrayMap<String, Constructor<?>> CONSTRUCTORS = null;
    private static final Class<?>[] CONSTRUCTOR_SIGNATURE = null;
    private final Context mContext;

    static {
        CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class};
        CONSTRUCTORS = new ArrayMap();
    }

    private TransitionInflater(@NonNull Context r1) {
        this.mContext = r1;
    }

    private Object createCustom(AttributeSet r6, Class<?> r7, String r8) {
        String r0 = r6.getAttributeValue(null, "class");
        if (r0 == null) goto L21;
        ArrayMap<String, Constructor<?>> r9 = CONSTRUCTORS;     // Catch: Exception -> L17
        monitor-enter(r9);     // Catch: Exception -> L17
        Constructor<?> r1 = r9.get(r0);     // Catch: Throwable -> L14
        if (r1 != null) goto L11;
        Class<? extends U> r4 = Class.forName(r0, false, this.mContext.getClassLoader()).asSubclass(r7);     // Catch: Throwable -> L14
        if (r4 == 0) goto L11;
        r1 = r4.getConstructor(CONSTRUCTOR_SIGNATURE);     // Catch: Throwable -> L14
        r1.setAccessible(true);     // Catch: Throwable -> L14
        r9.put(r0, r1);     // Catch: Throwable -> L14
    L11:
        Object r5 = r1.newInstance(new Object[]{this.mContext, r6});     // Catch: Throwable -> L14
        monitor-exit(r9);     // Catch: Throwable -> L14
        return r5;
    L14:
        th = move-exception;
        throw th;     // Catch: Exception -> L17
    L17:
        e = move-exception;
        throw new InflateException("Could not instantiate " + r7 + " class " + r0, e);
    L21:
        throw new InflateException(r8 + " tag must have a 'class' attribute");
    }

    private Transition createTransitionFromXml(XmlPullParser r8, AttributeSet r9, Transition r10) {
        int r0 = r8.getDepth();
        if ((r10 instanceof TransitionSet) == false) goto L5;
        TransitionSet r1 = (TransitionSet) r10;
    L6:
        Transition r3 = null;
    L7:
        int r4 = r8.next();
        if (r4 != 3) goto L12;
        if (r8.getDepth() > r0) goto L12;
    L83:
        return r3;
    L12:
        if (r4 == 1) goto L83;
        if (r4 != 2) goto L7;
        String r5 = r8.getName();
        if ("fade".equals(r5) == false) goto L20;
        r3 = new Fade(this.mContext, r9);
    L69:
        if (r3 == null) goto L7;
        if (r8.isEmptyElementTag() == true) goto L73;
        createTransitionFromXml(r8, r9, r3);
    L73:
        if (r1 != null) goto L74;
        if (r10 == null) goto L7;
        throw new InflateException("Could not add transition to another transition.");
    L74:
        r1.addTransition(r3);
        goto L6
    L20:
        if ("changeBounds".equals(r5) == false) goto L23;
        r3 = new ChangeBounds(this.mContext, r9);
        goto L69
    L23:
        if ("slide".equals(r5) == false) goto L26;
        r3 = new Slide(this.mContext, r9);
        goto L69
    L26:
        if ("explode".equals(r5) == false) goto L29;
        r3 = new Explode(this.mContext, r9);
        goto L69
    L29:
        if ("changeImageTransform".equals(r5) == false) goto L32;
        r3 = new ChangeImageTransform(this.mContext, r9);
        goto L69
    L32:
        if ("changeTransform".equals(r5) == false) goto L35;
        r3 = new ChangeTransform(this.mContext, r9);
        goto L69
    L35:
        if ("changeClipBounds".equals(r5) == false) goto L38;
        r3 = new ChangeClipBounds(this.mContext, r9);
        goto L69
    L38:
        if (TypedValues.TransitionType.S_AUTO_TRANSITION.equals(r5) == false) goto L41;
        r3 = new AutoTransition(this.mContext, r9);
        goto L69
    L41:
        if ("changeScroll".equals(r5) == false) goto L44;
        r3 = new ChangeScroll(this.mContext, r9);
        goto L69
    L44:
        if ("transitionSet".equals(r5) == false) goto L47;
        r3 = new TransitionSet(this.mContext, r9);
        goto L69
    L47:
        if ("transition".equals(r5) == false) goto L50;
        r3 = (Transition) createCustom(r9, Transition.class, "transition");
        goto L69
    L50:
        if ("targets".equals(r5) == false) goto L53;
        getTargetIds(r8, r9, r10);
        goto L69
    L53:
        if ("arcMotion".equals(r5) == false) goto L60;
        if (r10 == null) goto L58;
        PathMotion r6 = new ArcMotion(this.mContext, r9);
    L56:
        r10.setPathMotion(r6);
        goto L69
    L58:
        throw new RuntimeException("Invalid use of arcMotion element");
    L60:
        if ("pathMotion".equals(r5) == false) goto L66;
        if (r10 == null) goto L64;
        r6 = (PathMotion) createCustom(r9, PathMotion.class, "pathMotion");
        goto L56
    L64:
        throw new RuntimeException("Invalid use of pathMotion element");
    L66:
        if ("patternPathMotion".equals(r5) == false) goto L82;
        if (r10 == null) goto L80;
        r6 = new PatternPathMotion(this.mContext, r9);
        goto L56
    L80:
        throw new RuntimeException("Invalid use of patternPathMotion element");
    L82:
        throw new RuntimeException("Unknown scene name: " + r8.getName());
    L5:
        r1 = null;
        goto L6
    }

    private TransitionManager createTransitionManagerFromXml(XmlPullParser r5, AttributeSet r6, ViewGroup r7) {
        int r0 = r5.getDepth();
        TransitionManager r1 = null;
    L3:
        int r2 = r5.next();
        if (r2 != 3) goto L8;
        if (r5.getDepth() > r0) goto L8;
    L21:
        return r1;
    L8:
        if (r2 == 1) goto L21;
        if (r2 != 2) goto L3;
        String r3 = r5.getName();
        if (r3.equals("transitionManager") == true) goto L14;
        if (r3.equals("transition") == false) goto L20;
        if (r1 == null) goto L20;
        loadTransition(r6, r5, r7, r1);
    L20:
        throw new RuntimeException("Unknown scene name: " + r5.getName());
    L14:
        r1 = new TransitionManager();
        goto L3
    }

    @NonNull
    public static TransitionInflater from(@NonNull Context r1) {
        return new TransitionInflater(r1);
    }

    @SuppressLint({"RestrictedApi"})
    private void getTargetIds(XmlPullParser r8, AttributeSet r9, Transition r10) {
        int r0 = r8.getDepth();
    L3:
        int r1 = r8.next();
        if (r1 != 3) goto L8;
        if (r8.getDepth() > r0) goto L8;
        return;
    L8:
        if (r1 == 1) goto L48;
        if (r1 != 2) goto L3;
        if (r8.getName().equals(TypedValues.AttributesType.S_TARGET) == false) goto L37;
        TypedArray r2 = this.mContext.obtainStyledAttributes(r9, Styleable.TRANSITION_TARGET);
        int r5 = TypedArrayUtils.getNamedResourceId(r2, r8, "targetId", 1, 0);
        if (r5 == 0) goto L17;
        r10.addTarget(r5);
    L32:
        r2.recycle();
        goto L3
    L17:
        int r4 = TypedArrayUtils.getNamedResourceId(r2, r8, "excludeId", 2, 0);
        if (r4 == 0) goto L20;
        r10.excludeTarget(r4, true);
        goto L32
    L20:
        String r6 = TypedArrayUtils.getNamedString(r2, r8, "targetName", 4);
        if (r6 == null) goto L23;
        r10.addTarget(r6);
        goto L32
    L23:
        String r7 = TypedArrayUtils.getNamedString(r2, r8, "excludeName", 5);
        if (r7 == null) goto L26;
        r10.excludeTarget(r7, true);
        goto L32
    L26:
        String r3 = TypedArrayUtils.getNamedString(r2, r8, "excludeClass", 3);
        if (r3 != null) goto L39;
        String r11 = TypedArrayUtils.getNamedString(r2, r8, "targetClass", 0);     // Catch: ClassNotFoundException -> L33
        if (r11 == null) goto L32;
        r10.addTarget(Class.forName(r11));     // Catch: ClassNotFoundException -> L33
        goto L32
    L39:
        r10.excludeTarget(Class.forName(r3), true);     // Catch: ClassNotFoundException -> L33
    L33:
        e = move-exception;
        r2.recycle();
        throw new RuntimeException("Could not create " + r3, e);
    L37:
        throw new RuntimeException("Unknown scene name: " + r8.getName());
    }

    @SuppressLint({"RestrictedApi"})
    private void loadTransition(AttributeSet r7, XmlPullParser r8, ViewGroup r9, TransitionManager r10) {
        TypedArray r11 = this.mContext.obtainStyledAttributes(r7, Styleable.TRANSITION_MANAGER);
        int r0 = TypedArrayUtils.getNamedResourceId(r11, r8, "transition", 2, -1);
        int r1 = TypedArrayUtils.getNamedResourceId(r11, r8, "fromScene", 0, -1);
        Scene r3 = null;
        if (r1 >= 0) goto L5;
        Scene r2 = null;
    L6:
        int r12 = TypedArrayUtils.getNamedResourceId(r11, r8, "toScene", 1, -1);
        if (r12 < 0) goto L10;
        r3 = Scene.getSceneForLayout(r9, r12, this.mContext);
    L10:
        if (r0 < 0) goto L19;
        Transition r6 = inflateTransition(r0);
        if (r6 == null) goto L19;
        if (r3 == null) goto L18;
        if (r2 != null) goto L16;
        r10.setTransition(r3, r6);
        goto L19
    L16:
        r10.setTransition(r2, r3, r6);
        goto L19
    L18:
        throw new RuntimeException("No toScene for transition ID " + r0);
    L19:
        r11.recycle();
        return;
    L5:
        r2 = Scene.getSceneForLayout(r9, r1, this.mContext);
        goto L6
    }

    public Transition inflateTransition(int r4) {
        XmlResourceParser r5 = this.mContext.getResources().getXml(r4);
        Transition r3 = createTransitionFromXml(r5, Xml.asAttributeSet(r5), null);     // Catch: Throwable -> L6 IOException -> L8 XmlPullParserException -> L11
        r5.close();
        return r3;
    L6:
        th = move-exception;
        r5.close();
        throw th;
    L8:
        e = move-exception;
        throw new InflateException(r5.getPositionDescription() + ": " + e.getMessage(), e);     // Catch: Throwable -> L6
    L11:
        e = move-exception;
        throw new InflateException(e.getMessage(), e);     // Catch: Throwable -> L6
    }

    public TransitionManager inflateTransitionManager(int r3, ViewGroup r4) {
        XmlResourceParser r5 = this.mContext.getResources().getXml(r3);
        TransitionManager r2 = createTransitionManagerFromXml(r5, Xml.asAttributeSet(r5), r4);     // Catch: Throwable -> L6 IOException -> L8 XmlPullParserException -> L11
        r5.close();
        return r2;
    L6:
        th = move-exception;
        r5.close();
        throw th;
    L8:
        e = move-exception;
        InflateException r6 = new InflateException(r5.getPositionDescription() + ": " + e.getMessage());     // Catch: Throwable -> L6
        r6.initCause(e);     // Catch: Throwable -> L6
        throw r6;     // Catch: Throwable -> L6
    L11:
        e = move-exception;
        InflateException r7 = new InflateException(e.getMessage());     // Catch: Throwable -> L6
        r7.initCause(e);     // Catch: Throwable -> L6
        throw r7;     // Catch: Throwable -> L6
    }
}
