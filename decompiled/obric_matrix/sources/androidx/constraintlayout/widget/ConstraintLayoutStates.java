package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintLayoutStates {
    private static final boolean DEBUG = false;
    public static final String TAG = "ConstraintLayoutStates";
    private final ConstraintLayout mConstraintLayout;
    private SparseArray<ConstraintSet> mConstraintSetMap;
    private ConstraintsChangedListener mConstraintsChangedListener;
    int mCurrentConstraintNumber;
    int mCurrentStateId;
    ConstraintSet mDefaultConstraintSet;
    private SparseArray<State> mStateList;

    static class State {
        int mConstraintID;
        ConstraintSet mConstraintSet;
        int mId;
        ArrayList<Variant> mVariants;

        public State(Context r6, XmlPullParser r7) {
            this.mVariants = new ArrayList();
            this.mConstraintID = -1;
            TypedArray r8 = r6.obtainStyledAttributes(Xml.asAttributeSet(r7), R.styleable.State);
            int r0 = r8.getIndexCount();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L13;
            int r2 = r8.getIndex(r1);
            if (r2 != R.styleable.State_android_id) goto L8;
            this.mId = r8.getResourceId(r2, this.mId);
        L12:
            r1 = r1 + 1;
            goto L3
        L8:
            if (r2 != R.styleable.State_constraints) goto L12;
            this.mConstraintID = r8.getResourceId(r2, this.mConstraintID);
            String r3 = r6.getResources().getResourceTypeName(this.mConstraintID);
            r6.getResources().getResourceName(this.mConstraintID);
            if ("layout".equals(r3) == false) goto L12;
            ConstraintSet r4 = new ConstraintSet();
            this.mConstraintSet = r4;
            r4.clone(r6, this.mConstraintID);
            goto L12
        L13:
            r8.recycle();
        }

        void add(Variant r1) {
            this.mVariants.add(r1);
        }

        public int findMatch(float r3, float r4) {
            int r0 = 0;
        L4:
            if (r0 >= this.mVariants.size()) goto L9;
            if (this.mVariants.get(r0).match(r3, r4) == true) goto L7;
            r0 = r0 + 1;
            goto L4
        L7:
            return r0;
        L9:
            return -1;
        }
    }

    static class Variant {
        int mConstraintID;
        ConstraintSet mConstraintSet;
        int mId;
        float mMaxHeight;
        float mMaxWidth;
        float mMinHeight;
        float mMinWidth;

        public Variant(Context r6, XmlPullParser r7) {
            this.mMinWidth = Float.NaN;
            this.mMinHeight = Float.NaN;
            this.mMaxWidth = Float.NaN;
            this.mMaxHeight = Float.NaN;
            this.mConstraintID = -1;
            TypedArray r8 = r6.obtainStyledAttributes(Xml.asAttributeSet(r7), R.styleable.Variant);
            int r0 = r8.getIndexCount();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L23;
            int r2 = r8.getIndex(r1);
            if (r2 != R.styleable.Variant_constraints) goto L10;
            this.mConstraintID = r8.getResourceId(r2, this.mConstraintID);
            String r3 = r6.getResources().getResourceTypeName(this.mConstraintID);
            r6.getResources().getResourceName(this.mConstraintID);
            if ("layout".equals(r3) == false) goto L22;
            ConstraintSet r4 = new ConstraintSet();
            this.mConstraintSet = r4;
            r4.clone(r6, this.mConstraintID);
        L22:
            r1 = r1 + 1;
            goto L3
        L10:
            if (r2 != R.styleable.Variant_region_heightLessThan) goto L13;
            this.mMaxHeight = r8.getDimension(r2, this.mMaxHeight);
            goto L22
        L13:
            if (r2 != R.styleable.Variant_region_heightMoreThan) goto L16;
            this.mMinHeight = r8.getDimension(r2, this.mMinHeight);
            goto L22
        L16:
            if (r2 != R.styleable.Variant_region_widthLessThan) goto L19;
            this.mMaxWidth = r8.getDimension(r2, this.mMaxWidth);
            goto L22
        L19:
            if (r2 != R.styleable.Variant_region_widthMoreThan) goto L21;
            this.mMinWidth = r8.getDimension(r2, this.mMinWidth);
            goto L22
        L21:
            Log.v("ConstraintLayoutStates", "Unknown tag");
            goto L22
        L23:
            r8.recycle();
        }

        boolean match(float r3, float r4) {
            if (Float.isNaN(this.mMinWidth) == true) goto L8;
            if (r3 >= this.mMinWidth) goto L8;
            return false;
        L8:
            if (Float.isNaN(this.mMinHeight) == true) goto L13;
            if (r4 >= this.mMinHeight) goto L13;
            return false;
        L13:
            if (Float.isNaN(this.mMaxWidth) == true) goto L18;
            if (r3 <= this.mMaxWidth) goto L18;
            return false;
        L18:
            if (Float.isNaN(this.mMaxHeight) == false) goto L20;
            return true;
        L20:
            if (r4 <= this.mMaxHeight) goto L24;
            return false;
        L24:
            return true;
        }
    }

    ConstraintLayoutStates(Context r2, ConstraintLayout r3, int r4) {
        this.mCurrentStateId = -1;
        this.mCurrentConstraintNumber = -1;
        this.mStateList = new SparseArray();
        this.mConstraintSetMap = new SparseArray();
        this.mConstraintsChangedListener = null;
        this.mConstraintLayout = r3;
        load(r2, r4);
    }

    private void load(Context r9, int r10) {
        XmlResourceParser r11 = r9.getResources().getXml(r10);
        State r0 = null;
        int r1 = r11.getEventType();     // Catch: IOException -> L41 XmlPullParserException -> L43
    L4:
        byte r2 = 1;
        if (r1 == 1) goto L58;
        if (r1 != 0) goto L8;
        r11.getName();     // Catch: IOException -> L41 XmlPullParserException -> L43
    L39:
        r1 = r11.next();     // Catch: IOException -> L41 XmlPullParserException -> L43
    L8:
        if (r1 != 2) goto L39;
        String r3 = r11.getName();     // Catch: IOException -> L41 XmlPullParserException -> L43
        switch(r3.hashCode()) {
            case -1349929691: goto L26;
            case 80204913: goto L23;
            case 1382829617: goto L20;
            case 1657696882: goto L17;
            case 1901439077: goto L14;
            default: goto L28;
        };     // Catch: IOException -> L41 XmlPullParserException -> L43
    L28:
        r2 = -1;
    L29:
        if (r2 == 2) goto L37;
        if (r2 == 3) goto L34;
        if (r2 != 4) goto L39;
        parseConstraintSet(r9, r11);     // Catch: IOException -> L41 XmlPullParserException -> L43
        goto L39
    L34:
        Variant r4 = new Variant(r9, r11);     // Catch: IOException -> L41 XmlPullParserException -> L43
        if (r0 == null) goto L39;
        r0.add(r4);     // Catch: IOException -> L41 XmlPullParserException -> L43
        goto L39
    L37:
        r0 = new State(r9, r11);     // Catch: IOException -> L41 XmlPullParserException -> L43
        this.mStateList.put(r0.mId, r0);     // Catch: IOException -> L41 XmlPullParserException -> L43
        goto L39
    L14:
        if (r3.equals("Variant") == false) goto L28;
        r2 = 3;
        goto L29
    L17:
        if (r3.equals("layoutDescription") == false) goto L28;
        r2 = 0;
        goto L29
    L20:
        if (r3.equals("StateSet") == false) goto L28;
    L23:
        if (r3.equals("State") == false) goto L28;
        r2 = 2;
        goto L29
    L26:
        if (r3.equals("ConstraintSet") == false) goto L28;
        r2 = 4;
        goto L29
    L58:
        return;
    L41:
        e = move-exception;
        e.printStackTrace();
        return;
    L43:
        e = move-exception;
        e.printStackTrace();
    }

    private void parseConstraintSet(Context r9, XmlPullParser r10) {
        ConstraintSet r0 = new ConstraintSet();
        int r1 = r10.getAttributeCount();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L27;
        String r3 = r10.getAttributeName(r2);
        String r4 = r10.getAttributeValue(r2);
        if (r3 == null) goto L20;
        if (r4 == null) goto L20;
        if ("id".equals(r3) == false) goto L20;
        if (r4.contains("/") == false) goto L13;
        int r5 = r9.getResources().getIdentifier(r4.substring(r4.indexOf(47) + 1), "id", r9.getPackageName());
    L14:
        if (r5 == (-1)) goto L16;
    L19:
        r0.load(r9, r10);
        this.mConstraintSetMap.put(r5, r0);
        return;
    L16:
        if (r4.length() <= 1) goto L18;
        r5 = Integer.parseInt(r4.substring(1));
        goto L19
    L18:
        Log.e("ConstraintLayoutStates", "error in parsing id");
        goto L19
    L13:
        r5 = -1;
    L20:
        r2 = r2 + 1;
        goto L3
    }

    public boolean needsToChange(int r5, float r6, float r7) {
        int r0 = this.mCurrentStateId;
        if (r0 == r5) goto L6;
        return true;
    L6:
        if (r5 != (-1)) goto L8;
        State r8 = this.mStateList.valueAt(0);
    L9:
        State r9 = r8;
        int r1 = this.mCurrentConstraintNumber;
        if (r1 == (-1)) goto L15;
        if (r9.mVariants.get(r1).match(r6, r7) == false) goto L15;
        return false;
    L15:
        if (this.mCurrentConstraintNumber != r9.findMatch(r6, r7)) goto L17;
        return false;
    L17:
        return true;
    L8:
        r8 = this.mStateList.get(r0);
        goto L9
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener r1) {
        this.mConstraintsChangedListener = r1;
    }

    public void updateConstraints(int r5, float r6, float r7) {
        int r0 = this.mCurrentStateId;
        if (r0 != r5) goto L29;
        if (r5 != (-1)) goto L6;
        State r8 = this.mStateList.valueAt(0);
    L7:
        State r9 = r8;
        int r1 = this.mCurrentConstraintNumber;
        if (r1 != (-1)) goto L10;
    L12:
        int r10 = r9.findMatch(r6, r7);
        if (this.mCurrentConstraintNumber != r10) goto L15;
        return;
    L15:
        if (r10 != (-1)) goto L17;
        ConstraintSet r11 = this.mDefaultConstraintSet;
    L18:
        if (r10 != (-1)) goto L20;
        int r12 = r9.mConstraintID;
    L21:
        if (r11 != null) goto L23;
        return;
    L23:
        this.mCurrentConstraintNumber = r10;
        ConstraintsChangedListener r13 = this.mConstraintsChangedListener;
        if (r13 == null) goto L26;
        r13.preLayoutChange(-1, r12);
    L26:
        r11.applyTo(this.mConstraintLayout);
        ConstraintsChangedListener r4 = this.mConstraintsChangedListener;
        if (r4 == null) goto L46;
        r4.postLayoutChange(-1, r12);
        return;
    L46:
        return;
    L20:
        r12 = r9.mVariants.get(r10).mConstraintID;
        goto L21
    L17:
        r11 = r9.mVariants.get(r10).mConstraintSet;
        goto L18
    L10:
        if (r9.mVariants.get(r1).match(r6, r7) == false) goto L12;
        return;
    L6:
        r8 = this.mStateList.get(r0);
        goto L7
    L29:
        this.mCurrentStateId = r5;
        State r2 = this.mStateList.get(r5);
        int r3 = r2.findMatch(r6, r7);
        if (r3 != (-1)) goto L32;
        ConstraintSet r14 = r2.mConstraintSet;
    L33:
        if (r3 != (-1)) goto L35;
        int r15 = r2.mConstraintID;
    L36:
        if (r14 != null) goto L39;
        Log.v("ConstraintLayoutStates", "NO Constraint set found ! id=" + r5 + ", dim =" + r6 + ", " + r7);
        return;
    L39:
        this.mCurrentConstraintNumber = r3;
        ConstraintsChangedListener r16 = this.mConstraintsChangedListener;
        if (r16 == null) goto L42;
        r16.preLayoutChange(r5, r15);
    L42:
        r14.applyTo(this.mConstraintLayout);
        ConstraintsChangedListener r17 = this.mConstraintsChangedListener;
        if (r17 == null) goto L48;
        r17.postLayoutChange(r5, r15);
        return;
    L48:
        return;
    L35:
        r15 = r2.mVariants.get(r3).mConstraintID;
        goto L36
    L32:
        r14 = r2.mVariants.get(r3).mConstraintSet;
        goto L33
    }
}
