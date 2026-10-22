package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
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
        sKeyMakers.put("KeyPosition", KeyPosition.class.getConstructor(new Class[0]));     // Catch: NoSuchMethodException -> L5
        sKeyMakers.put("KeyCycle", KeyCycle.class.getConstructor(new Class[0]));     // Catch: NoSuchMethodException -> L5
        sKeyMakers.put("KeyTimeCycle", KeyTimeCycle.class.getConstructor(new Class[0]));     // Catch: NoSuchMethodException -> L5
        sKeyMakers.put("KeyTrigger", KeyTrigger.class.getConstructor(new Class[0]));     // Catch: NoSuchMethodException -> L5
        return;
    L5:
        e = move-exception;
        Log.e(TAG, "unable to load", e);
    }

    public void addKey(Key key) {
        if (this.mFramesMap.containsKey(Integer.valueOf(key.mTargetId)) == true) goto L5;
        this.mFramesMap.put(Integer.valueOf(key.mTargetId), new ArrayList());
    L5:
        ArrayList<Key> r3 = this.mFramesMap.get(Integer.valueOf(key.mTargetId));
        if (r3 == null) goto L9;
        r3.add(key);
        return;
    }

    public KeyFrames() {
        this.mFramesMap = new HashMap();
    }

    public KeyFrames(Context context, XmlPullParser parser) {
        this.mFramesMap = new HashMap();
        int r0 = parser.getEventType();     // Catch: IOException -> L43 XmlPullParserException -> L45
        Key r1 = null;
    L5:
        if (r0 == 1) goto L69;
        if (r0 != 2) goto L9;
        String r2 = parser.getName();     // Catch: IOException -> L43 XmlPullParserException -> L45
        if (sKeyMakers.containsKey(r2) == false) goto L30;
        Constructor<? extends Key> r3 = sKeyMakers.get(r2);     // Catch: Exception -> L25 IOException -> L43 XmlPullParserException -> L45
        if (r3 == null) goto L24;
        Key r4 = r3.newInstance(new Object[0]);     // Catch: Exception -> L25 IOException -> L43 XmlPullParserException -> L45
        r4.load(context, Xml.asAttributeSet(parser));     // Catch: Exception -> L21 IOException -> L43 XmlPullParserException -> L45
        addKey(r4);     // Catch: Exception -> L21 IOException -> L43 XmlPullParserException -> L45
    L28:
        r1 = r4;
    L41:
        r0 = parser.next();     // Catch: IOException -> L43 XmlPullParserException -> L45
    L21:
        Exception e = e;
    L27:
        Log.e(TAG, "unable to create ", e);     // Catch: IOException -> L43 XmlPullParserException -> L45
        goto L28
    L24:
        throw new NullPointerException("Keymaker for " + r2 + " not found");     // Catch: Exception -> L25 IOException -> L43 XmlPullParserException -> L45
    L25:
        e = move-exception;
        Key r5 = r1;
        e = e;
        r4 = r5;
        goto L27
    L30:
        if (r2.equalsIgnoreCase("CustomAttribute") == false) goto L36;
        if (r1 == null) goto L41;
        if (r1.mCustomConstraints == null) goto L41;
        ConstraintAttribute.parse(context, parser, r1.mCustomConstraints);     // Catch: IOException -> L43 XmlPullParserException -> L45
        goto L41
    L36:
        if (r2.equalsIgnoreCase("CustomMethod") == false) goto L41;
        if (r1 == null) goto L41;
        if (r1.mCustomConstraints == null) goto L41;
        ConstraintAttribute.parse(context, parser, r1.mCustomConstraints);     // Catch: IOException -> L43 XmlPullParserException -> L45
        goto L41
    L9:
        if (r0 != 3) goto L41;
        if ("KeyFrameSet".equals(parser.getName()) == false) goto L41;
        return;
    L69:
        return;
    L43:
        e = move-exception;
        e.printStackTrace();
        return;
    L45:
        e = move-exception;
        e.printStackTrace();
    }

    public void addAllFrames(MotionController motionController) {
        ArrayList<Key> r1 = this.mFramesMap.get(-1);
        if (r1 == null) goto L6;
        motionController.addKeys(r1);
        return;
    }

    public void addFrames(MotionController motionController) {
        ArrayList<Key> r0 = this.mFramesMap.get(Integer.valueOf(motionController.mId));
        if (r0 == null) goto L5;
        motionController.addKeys(r0);
    L5:
        ArrayList<Key> r2 = this.mFramesMap.get(-1);
        if (r2 == null) goto L13;
        Iterator<Key> r3 = r2.iterator();
    L9:
        if (r3.hasNext() == false) goto L19;
        Key r1 = r3.next();
        if (r1.matches(((ConstraintLayout.LayoutParams) motionController.mView.getLayoutParams()).constraintTag) == false) goto L9;
        motionController.addKey(r1);
        goto L9
    L19:
        return;
    }

    static String name(int viewId, Context context) {
        return context.getResources().getResourceEntryName(viewId);
    }

    public Set<Integer> getKeys() {
        return this.mFramesMap.keySet();
    }

    public ArrayList<Key> getKeyFramesForView(int id) {
        return this.mFramesMap.get(Integer.valueOf(id));
    }
}
