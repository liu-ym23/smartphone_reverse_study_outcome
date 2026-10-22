package com.android.settings.quickphrases;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.view.View;
import android.widget.ListView;
import com.android.settings.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ModeChanger {
    private Animator mAnimator;
    private Context mContext;
    private boolean mEditMode;
    private int mEditableViewId;

    public ModeChanger(int r1, Context r2) {
        this.mEditableViewId = r1;
        this.mContext = r2;
    }

    public boolean isEditMode() {
        return this.mEditMode;
    }

    public boolean isEnable() {
        Animator r0 = this.mAnimator;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.isRunning() == false) goto L8;
        return false;
    }

    public void beginEdit(ListView r5, Animator r6, Animator.AnimatorListener r7) {
        this.mEditMode = true;
        AnimatorSet r1 = new AnimatorSet();
        Animator r8 = makeEditAnimator(r5, this.mEditMode);
        if (r6 == null) goto L5;
        r1.playSequentially(new Animator[]{r8, r6});
    L6:
        this.mAnimator = r1;
        if (r7 == null) goto L9;
        r1.addListener(r7);
    L9:
        this.mAnimator.start();
        return;
    L5:
        r1.play(r8);
        goto L6
    }

    public void endEdit(ListView r4, Animator r5, Animator.AnimatorListener r6) {
        this.mEditMode = false;
        AnimatorSet r1 = new AnimatorSet();
        Animator r7 = makeEditAnimator(r4, this.mEditMode);
        if (r5 == null) goto L5;
        r1.playSequentially(new Animator[]{r7, r5});
    L6:
        this.mAnimator = r1;
        if (r6 == null) goto L9;
        r1.addListener(r6);
    L9:
        this.mAnimator.start();
        return;
    L5:
        r1.play(r7);
        goto L6
    }

    public void beginEdit(ListView r2, Animator.AnimatorListener r3) {
        beginEdit(r2, null, r3);
    }

    public void endEdit(ListView r2, Animator.AnimatorListener r3) {
        endEdit(r2, null, r3);
    }

    private Animator makeEditAnimator(ListView r5, boolean r6) {
        List<SettingItemEditable> r7 = getVisibleChild(r5);
        if (r7 == null) goto L17;
        ArrayList r0 = new ArrayList(r7.size());
        Iterator<SettingItemEditable> r8 = r7.iterator();
    L6:
        if (r8.hasNext() == false) goto L15;
        SettingItemEditable r1 = r8.next();
        if (r6 == false) goto L10;
        Animator r2 = r1.beginEdit();
    L11:
        r0.add(r2);
        r1.setEnabled(r6);
        if (r6 == true) goto L13;
        r1.getTextView().setTextColor(this.mContext.getResources().getColor(R.color.setting_item_text_color));
        goto L6
    L13:
        r1.getTextView().setTextColor(this.mContext.getResources().getColorStateList(R.color.setting_item_text_colorlist));
        goto L6
    L10:
        r2 = r1.endEdit();
        goto L11
    L15:
        AnimatorSet r4 = new AnimatorSet();
        r4.playTogether(r0);
        return r4;
    L17:
        return null;
    }

    private List<SettingItemEditable> getVisibleChild(ListView r5) {
        if (r5 == null) goto L8;
        int r0 = r5.getFirstVisiblePosition();
        int r1 = r5.getLastVisiblePosition();
        ArrayList r2 = new ArrayList((r1 - r0) + 1);
    L4:
        if (r0 > r1) goto L7;
        r2.add(Integer.valueOf(r0));
        r0 = r0 + 1;
        goto L4
    L7:
        return getChildrenFromPosition(r5, r2);
    L8:
        return null;
    }

    List<SettingItemEditable> getChildrenFromPosition(ListView r5, Collection<Integer> r6) {
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L4:
        if (r1 >= r5.getChildCount()) goto L11;
        View r2 = r5.getChildAt(r1);
        if (r6.contains(Integer.valueOf(r5.getPositionForView(r2))) == false) goto L10;
        if (r2.findViewById(this.mEditableViewId) == null) goto L10;
        r0.add((SettingItemEditable) r2);
    L10:
        r1 = r1 + 1;
        goto L4
    L11:
        return r0;
    }

    List<View> getChildren(ListView r2, Collection<Integer> r3) {
        ArrayList r1 = new ArrayList();
        Iterator<Integer> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r1.add(r2.getChildAt(r4.next().intValue()));
        goto L4
    L6:
        return r1;
    }

    public void endAnimator() {
        Animator r0 = this.mAnimator;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isRunning() == false) goto L9;
        this.mAnimator.end();
        return;
    }

    public void resetEditMode() {
        this.mEditMode = false;
    }
}
