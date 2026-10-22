package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class StateSet {
    private static final boolean DEBUG = false;
    public static final String TAG = "ConstraintLayoutStates";
    private SparseArray<ConstraintSet> mConstraintSetMap;
    private ConstraintsChangedListener mConstraintsChangedListener;
    int mCurrentConstraintNumber;
    int mCurrentStateId;
    ConstraintSet mDefaultConstraintSet;
    int mDefaultState;
    private SparseArray<State> mStateList;

    public static class State {
        int mConstraintID;
        int mId;
        boolean mIsLayout;
        ArrayList<Variant> mVariants;

        public State(Context r6, XmlPullParser r7) {
            this.mVariants = new ArrayList();
            this.mConstraintID = -1;
            int r0 = 0;
            this.mIsLayout = false;
            TypedArray r8 = r6.obtainStyledAttributes(Xml.asAttributeSet(r7), R.styleable.State);
            int r1 = r8.getIndexCount();
        L3:
            if (r0 >= r1) goto L13;
            int r2 = r8.getIndex(r0);
            if (r2 != R.styleable.State_android_id) goto L8;
            this.mId = r8.getResourceId(r2, this.mId);
        L12:
            r0 = r0 + 1;
            goto L3
        L8:
            if (r2 != R.styleable.State_constraints) goto L12;
            this.mConstraintID = r8.getResourceId(r2, this.mConstraintID);
            String r3 = r6.getResources().getResourceTypeName(this.mConstraintID);
            r6.getResources().getResourceName(this.mConstraintID);
            if ("layout".equals(r3) == false) goto L12;
            this.mIsLayout = true;
            goto L12
        L13:
            r8.recycle();
        }

        public void add(Variant r1) {
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

    public static class Variant {
        int mConstraintID;
        int mId;
        boolean mIsLayout;
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
            int r0 = 0;
            this.mIsLayout = false;
            TypedArray r8 = r6.obtainStyledAttributes(Xml.asAttributeSet(r7), R.styleable.Variant);
            int r1 = r8.getIndexCount();
        L3:
            if (r0 >= r1) goto L23;
            int r2 = r8.getIndex(r0);
            if (r2 != R.styleable.Variant_constraints) goto L10;
            this.mConstraintID = r8.getResourceId(r2, this.mConstraintID);
            String r3 = r6.getResources().getResourceTypeName(this.mConstraintID);
            r6.getResources().getResourceName(this.mConstraintID);
            if ("layout".equals(r3) == false) goto L22;
            this.mIsLayout = true;
        L22:
            r0 = r0 + 1;
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

        public boolean match(float r3, float r4) {
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

    public StateSet(Context r2, XmlPullParser r3) {
        this.mDefaultState = -1;
        this.mCurrentStateId = -1;
        this.mCurrentConstraintNumber = -1;
        this.mStateList = new SparseArray();
        this.mConstraintSetMap = new SparseArray();
        this.mConstraintsChangedListener = null;
        load(r2, r3);
    }

    private void load(Context r9, XmlPullParser r10) {
        TypedArray r0 = r9.obtainStyledAttributes(Xml.asAttributeSet(r10), R.styleable.StateSet);
        int r1 = r0.getIndexCount();
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L8;
        int r4 = r0.getIndex(r3);
        if (r4 != R.styleable.StateSet_defaultState) goto L7;
        this.mDefaultState = r0.getResourceId(r4, this.mDefaultState);
    L7:
        r3 = r3 + 1;
        goto L3
    L8:
        r0.recycle();
        int r2 = r10.getEventType();     // Catch: IOException -> L21 XmlPullParserException -> L23
        State r5 = null;
    L11:
        byte r6 = 1;
        if (r2 == 1) goto L69;
        if (r2 != 0) goto L15;
        r10.getName();     // Catch: IOException -> L21 XmlPullParserException -> L23
    L49:
        r2 = r10.next();     // Catch: IOException -> L21 XmlPullParserException -> L23
        goto L11
    L15:
        if (r2 == 2) goto L25;
        if (r2 != 3) goto L49;
        if ("StateSet".equals(r10.getName()) == false) goto L49;
        return;
    L25:
        String r7 = r10.getName();     // Catch: IOException -> L21 XmlPullParserException -> L23
        switch(r7.hashCode()) {
            case 80204913: goto L38;
            case 1301459538: goto L35;
            case 1382829617: goto L32;
            case 1901439077: goto L29;
            default: goto L40;
        };     // Catch: IOException -> L21 XmlPullParserException -> L23
    L40:
        r6 = -1;
    L41:
        if (r6 == 2) goto L47;
        if (r6 != 3) goto L49;
        Variant r8 = new Variant(r9, r10);     // Catch: IOException -> L21 XmlPullParserException -> L23
        if (r5 == null) goto L49;
        r5.add(r8);     // Catch: IOException -> L21 XmlPullParserException -> L23
        goto L49
    L47:
        r5 = new State(r9, r10);     // Catch: IOException -> L21 XmlPullParserException -> L23
        this.mStateList.put(r5.mId, r5);     // Catch: IOException -> L21 XmlPullParserException -> L23
        goto L49
    L29:
        if (r7.equals("Variant") == false) goto L40;
        r6 = 3;
        goto L41
    L32:
        if (r7.equals("StateSet") == false) goto L40;
    L35:
        if (r7.equals("LayoutDescription") == false) goto L40;
        r6 = 0;
        goto L41
    L38:
        if (r7.equals("State") == false) goto L40;
        r6 = 2;
        goto L41
    L69:
        return;
    L21:
        e = move-exception;
        e.printStackTrace();
        return;
    L23:
        e = move-exception;
        e.printStackTrace();
    }

    public int convertToConstraintSet(int r4, int r5, float r6, float r7) {
        State r3 = this.mStateList.get(r5);
        if (r3 != null) goto L6;
        return r5;
    L6:
        if (r6 == (-1.0f)) goto L25;
        if (r7 == (-1.0f)) goto L25;
        Iterator<Variant> r8 = r3.mVariants.iterator();
        Variant r0 = null;
    L12:
        if (r8.hasNext() == false) goto L19;
        Variant r1 = r8.next();
        if (r1.match(r6, r7) == false) goto L12;
        if (r4 == r1.mConstraintID) goto L17;
        r0 = r1;
        goto L12
    L17:
        return r4;
    L19:
        if (r0 == null) goto L23;
        return r0.mConstraintID;
    L23:
        return r3.mConstraintID;
    L25:
        if (r3.mConstraintID != r4) goto L27;
        return r4;
    L27:
        Iterator<Variant> r9 = r3.mVariants.iterator();
    L29:
        if (r9.hasNext() == false) goto L34;
        if (r4 != r9.next().mConstraintID) goto L29;
        return r4;
    L34:
        return r3.mConstraintID;
    }

    public boolean needsToChange(int r5, float r6, float r7) {
        int r0 = this.mCurrentStateId;
        if (r0 == r5) goto L6;
        return true;
    L6:
        if (r5 != (-1)) goto L9;
        State r8 = this.mStateList.valueAt(0);
    L8:
        State r9 = r8;
        int r1 = this.mCurrentConstraintNumber;
        if (r1 == (-1)) goto L16;
        if (r9.mVariants.get(r1).match(r6, r7) == false) goto L16;
        return false;
    L16:
        if (this.mCurrentConstraintNumber != r9.findMatch(r6, r7)) goto L18;
        return false;
    L18:
        return true;
    L9:
        r8 = this.mStateList.get(r0);
        goto L8
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener r1) {
        this.mConstraintsChangedListener = r1;
    }

    public int stateGetConstraintID(int r2, int r3, int r4) {
        return updateConstraints(-1, r2, r3, r4);
    }

    public int updateConstraints(int r3, int r4, float r5, float r6) {
        if (r3 != r4) goto L21;
        if (r4 != (-1)) goto L6;
        State r7 = this.mStateList.valueAt(0);
    L7:
        if (r7 != null) goto L10;
        return -1;
    L10:
        if (this.mCurrentConstraintNumber != (-1)) goto L12;
    L14:
        int r2 = r7.findMatch(r5, r6);
        if (r3 != r2) goto L17;
        return r3;
    L17:
        if (r2 != (-1)) goto L20;
        return r7.mConstraintID;
    L20:
        return r7.mVariants.get(r2).mConstraintID;
    L12:
        if (r7.mVariants.get(r3).match(r5, r6) == false) goto L14;
        return r3;
    L6:
        r7 = this.mStateList.get(this.mCurrentStateId);
        goto L7
    L21:
        State r8 = this.mStateList.get(r4);
        if (r8 != null) goto L24;
        return -1;
    L24:
        int r9 = r8.findMatch(r5, r6);
        if (r9 != (-1)) goto L28;
        return r8.mConstraintID;
    L28:
        return r8.mVariants.get(r9).mConstraintID;
    }
}
