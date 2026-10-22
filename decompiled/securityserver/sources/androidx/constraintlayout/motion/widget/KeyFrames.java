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
        r0.put("KeyAttribute", KeyAttributes.class.getConstructor(null));     // Catch: NoSuchMethodException -> L5
        sKeyMakers.put(TypedValues.PositionType.NAME, KeyPosition.class.getConstructor(null));     // Catch: NoSuchMethodException -> L5
        sKeyMakers.put(TypedValues.CycleType.NAME, KeyCycle.class.getConstructor(null));     // Catch: NoSuchMethodException -> L5
        sKeyMakers.put("KeyTimeCycle", KeyTimeCycle.class.getConstructor(null));     // Catch: NoSuchMethodException -> L5
        sKeyMakers.put(TypedValues.TriggerType.NAME, KeyTrigger.class.getConstructor(null));     // Catch: NoSuchMethodException -> L5
        return;
    L5:
        e = move-exception;
        Log.e(TAG, "unable to load", e);
    }

    public KeyFrames() {
        this.mFramesMap = new HashMap();
    }

    public static String name(int r0, Context r1) {
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

    public KeyFrames(Context r8, XmlPullParser r9) {
        this.mFramesMap = new HashMap();
        int r0 = r9.getEventType();     // Catch: IOException -> L14 XmlPullParserException -> L16
        Key r2 = null;
    L5:
        if (r0 == 1) goto L70;
        if (r0 != 2) goto L9;
        String r1 = r9.getName();     // Catch: IOException -> L14 XmlPullParserException -> L16
        if (sKeyMakers.containsKey(r1) == false) goto L33;
        Constructor<? extends Key> r3 = sKeyMakers.get(r1);     // Catch: Exception -> L27
        if (r3 == null) goto L30;
        Key r4 = r3.newInstance(null);     // Catch: Exception -> L27
        r4.load(r8, Xml.asAttributeSet(r9));     // Catch: Exception -> L25
        addKey(r4);     // Catch: Exception -> L25
    L24:
        r2 = r4;
    L44:
        r0 = r9.next();     // Catch: IOException -> L14 XmlPullParserException -> L16
    L25:
        Exception e = e;
    L31:
        Log.e(TAG, "unable to create ", e);     // Catch: IOException -> L14 XmlPullParserException -> L16
        goto L24
    L30:
        throw new NullPointerException("Keymaker for " + r1 + " not found");     // Catch: Exception -> L27
    L27:
        e = move-exception;
        Key r6 = r2;
        e = e;
        r4 = r6;
        goto L31
    L33:
        if (r1.equalsIgnoreCase("CustomAttribute") == false) goto L39;
        if (r2 == null) goto L44;
        HashMap<String, ConstraintAttribute> r5 = r2.mCustomConstraints;     // Catch: IOException -> L14 XmlPullParserException -> L16
        if (r5 == null) goto L44;
        ConstraintAttribute.parse(r8, r9, r5);     // Catch: IOException -> L14 XmlPullParserException -> L16
        goto L44
    L39:
        if (r1.equalsIgnoreCase("CustomMethod") == false) goto L44;
        if (r2 == null) goto L44;
        HashMap<String, ConstraintAttribute> r7 = r2.mCustomConstraints;     // Catch: IOException -> L14 XmlPullParserException -> L16
        if (r7 == null) goto L44;
        ConstraintAttribute.parse(r8, r9, r7);     // Catch: IOException -> L14 XmlPullParserException -> L16
        goto L44
    L9:
        if (r0 != 3) goto L44;
        if (ViewTransition.KEY_FRAME_SET_TAG.equals(r9.getName()) == false) goto L44;
        return;
    L70:
        return;
    L14:
        e = move-exception;
        e.printStackTrace();
        return;
    L16:
        e = move-exception;
        e.printStackTrace();
    }
}
