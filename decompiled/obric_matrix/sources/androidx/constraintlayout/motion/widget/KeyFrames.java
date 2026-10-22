package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class KeyFrames {
    private static final String CUSTOM_ATTRIBUTE = "CustomAttribute";
    private static final String CUSTOM_METHOD = "CustomMethod";
    private static final String TAG = "KeyFrames";
    public static final int UNSET = -1;
    static HashMap<String, Constructor<? extends Key>> sKeyMakers;
    private HashMap<Integer, ArrayList<Key>> mFramesMap;

    static {
        HashMap<String, Constructor<? extends Key>> r0 = new HashMap();
        sKeyMakers = r0;
        r0.put("KeyAttribute", KeyAttributes.class.getConstructor(new Class[0]));     // Catch: NoSuchMethodException -> L5
        sKeyMakers.put(TypedValues.PositionType.NAME, KeyPosition.class.getConstructor(new Class[0]));     // Catch: NoSuchMethodException -> L5
        sKeyMakers.put(TypedValues.CycleType.NAME, KeyCycle.class.getConstructor(new Class[0]));     // Catch: NoSuchMethodException -> L5
        sKeyMakers.put("KeyTimeCycle", KeyTimeCycle.class.getConstructor(new Class[0]));     // Catch: NoSuchMethodException -> L5
        sKeyMakers.put(TypedValues.TriggerType.NAME, KeyTrigger.class.getConstructor(new Class[0]));     // Catch: NoSuchMethodException -> L5
        return;
    L5:
        e = move-exception;
        Log.e(TAG, "unable to load", e);
    }

    public KeyFrames() {
        this.mFramesMap = new HashMap();
    }

    public KeyFrames(Context r7, XmlPullParser r8) {
        this.mFramesMap = new HashMap();
        Key r0 = null;
        int r1 = r8.getEventType();     // Catch: IOException -> L43 XmlPullParserException -> L45
    L5:
        if (r1 == 1) goto L68;
        if (r1 != 2) goto L9;
        String r2 = r8.getName();     // Catch: IOException -> L43 XmlPullParserException -> L45
        if (sKeyMakers.containsKey(r2) == false) goto L30;
        Constructor<? extends Key> r3 = sKeyMakers.get(r2);     // Catch: Exception -> L25
        if (r3 == null) goto L24;
        Key r4 = r3.newInstance(new Object[0]);     // Catch: Exception -> L25
        r4.load(r7, Xml.asAttributeSet(r8));     // Catch: Exception -> L21
        addKey(r4);     // Catch: Exception -> L21
    L28:
        r0 = r4;
    L41:
        r1 = r8.next();     // Catch: IOException -> L43 XmlPullParserException -> L45
    L21:
        Exception e2 = e;
    L27:
        Log.e(TAG, "unable to create ", e2);     // Catch: IOException -> L43 XmlPullParserException -> L45
        goto L28
    L24:
        throw new NullPointerException("Keymaker for " + r2 + " not found");     // Catch: Exception -> L25
    L25:
        e = move-exception;
        r4 = r0;
        e2 = e;
        goto L27
    L30:
        if (r2.equalsIgnoreCase("CustomAttribute") == false) goto L36;
        if (r0 == null) goto L41;
        HashMap<String, ConstraintAttribute> r5 = r0.mCustomConstraints;     // Catch: IOException -> L43 XmlPullParserException -> L45
        if (r5 == null) goto L41;
    L34:
        ConstraintAttribute.parse(r7, r8, r5);     // Catch: IOException -> L43 XmlPullParserException -> L45
        goto L41
    L36:
        if (r2.equalsIgnoreCase("CustomMethod") == false) goto L41;
        if (r0 == null) goto L41;
        r5 = r0.mCustomConstraints;     // Catch: IOException -> L43 XmlPullParserException -> L45
        if (r5 == null) goto L41;
    L9:
        if (r1 != 3) goto L41;
        if (ViewTransition.KEY_FRAME_SET_TAG.equals(r8.getName()) == false) goto L41;
        return;
    L68:
        return;
    L43:
        e = move-exception;
        e.printStackTrace();
        return;
    L45:
        e = move-exception;
        e.printStackTrace();
    }

    static String name(int r0, Context r1) {
        return r1.getResources().getResourceEntryName(r0);
    }

    public void addAllFrames(MotionController r2) {
        ArrayList<Key> r1 = this.mFramesMap.get(-1);
        if (r1 == null) goto L6;
        r2.addKeys(r1);
        return;
    }

    public void addFrames(MotionController r3) {
        ArrayList<Key> r0 = this.mFramesMap.get(Integer.valueOf(r3.mId));
        if (r0 == null) goto L5;
        r3.addKeys(r0);
    L5:
        ArrayList<Key> r2 = this.mFramesMap.get(-1);
        if (r2 == null) goto L13;
        Iterator<Key> r4 = r2.iterator();
    L9:
        if (r4.hasNext() == false) goto L19;
        Key r1 = r4.next();
        if (r1.matches(((ConstraintLayout.LayoutParams) r3.mView.getLayoutParams()).constraintTag) == false) goto L9;
        r3.addKey(r1);
        goto L9
    L19:
        return;
    }

    public void addKey(Key r4) {
        if (this.mFramesMap.containsKey(Integer.valueOf(r4.mTargetId)) == true) goto L5;
        this.mFramesMap.put(Integer.valueOf(r4.mTargetId), new ArrayList());
    L5:
        ArrayList<Key> r3 = this.mFramesMap.get(Integer.valueOf(r4.mTargetId));
        if (r3 == null) goto L9;
        r3.add(r4);
        return;
    }

    public ArrayList<Key> getKeyFramesForView(int r1) {
        return this.mFramesMap.get(Integer.valueOf(r1));
    }

    public Set<Integer> getKeys() {
        return this.mFramesMap.keySet();
    }
}
