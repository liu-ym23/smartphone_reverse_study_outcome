package com.bytedanceos.preventdisturb;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.Property;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedanceos.preventdisturb.widget.ConversationListItem;
import com.obric.oui.bouncelayout.OListView;
import com.obric.security.R;

/* JADX INFO: loaded from: classes2.dex */
public class ConversationAdapterAnimHelper {
    private boolean mBlacklistAnimPlaying;
    private Context mContext;
    private boolean mEditAnimPlaying;
    private boolean mMarkReadAnimPlaying;

    static /* synthetic */ boolean access$002(ConversationAdapterAnimHelper r0, boolean r1) {
        r0.mMarkReadAnimPlaying = r1;
        return r1;
    }

    static /* synthetic */ boolean access$102(ConversationAdapterAnimHelper r0, boolean r1) {
        r0.mBlacklistAnimPlaying = r1;
        return r1;
    }

    static /* synthetic */ Context access$200(ConversationAdapterAnimHelper r0) {
        return r0.mContext;
    }

    static /* synthetic */ boolean access$302(ConversationAdapterAnimHelper r0, boolean r1) {
        r0.mEditAnimPlaying = r1;
        return r1;
    }

    public ConversationAdapterAnimHelper(Context context) {
        this.mContext = context;
    }

    public boolean isMarkReadAnimPlaying() {
        return this.mMarkReadAnimPlaying;
    }

    public void doMarkReadAnim(View v, final boolean unread) {
        if (v != null) goto L4;
        return;
    L4:
        ConversationListItem r5 = (ConversationListItem) v.findViewById(R.id.conversation_list_item);
        if (r5 != null) goto L7;
        return;
    L7:
        final ImageView r6 = r5.getStatusView();
        float r0 = 0.0f;
        if (unread == false) goto L10;
        float r2 = 0.0f;
    L11:
        if (unread == false) goto L13;
        r0 = 1.0f;
    L13:
        AlphaAnimation r1 = new AlphaAnimation(r2, r0);
        r1.setInterpolator(this.mContext, R.interpolator.decelerate_quad);
        if (unread == false) goto L16;
        long r3 = 200;
    L17:
        r1.setDuration(r3);
        r1.setAnimationListener(new AnonymousClass1(this, unread, r6));
        r6.startAnimation(r1);
        return;
    L16:
        r3 = 100;
        goto L17
    L10:
        r2 = 1.0f;
        goto L11
    }

    public void setBlacklistAnimPlaying(boolean blacklistAnimPlaying) {
        this.mBlacklistAnimPlaying = blacklistAnimPlaying;
    }

    public boolean isBlacklistAnimPlaying() {
        return this.mBlacklistAnimPlaying;
    }

    public void doBlacklistAnim(View v, final Contact c, final boolean inBlacklist) {
        if (v != null) goto L6;
        this.mBlacklistAnimPlaying = false;
        return;
    L6:
        final ConversationListItem r1 = (ConversationListItem) v.findViewById(R.id.conversation_list_item);
        if (r1 != null) goto L10;
        this.mBlacklistAnimPlaying = false;
        return;
    L10:
        final AnimatorSet r2 = new AnimatorSet();
        if (inBlacklist == false) goto L13;
        long r3 = 50;
    L14:
        r2.setDuration(r3);
        Context r4 = this.mContext;
        if (inBlacklist == false) goto L17;
        int r5 = android.R.interpolator.linear;
    L18:
        r2.setInterpolator(AnimationUtils.loadInterpolator(r4, r5));
        float r6 = 1.1f;
        float r7 = 1.0f;
        if (inBlacklist == false) goto L21;
        float r8 = 1.1f;
    L22:
        if (inBlacklist == false) goto L24;
        r6 = 1.0f;
    L24:
        PropertyValuesHolder r9 = PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{r8, r6});
        PropertyValuesHolder r10 = PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{r8, r6});
        Property r11 = View.ALPHA;
        float[] r12 = new float[2];
        r12[0] = 1.0f;
        if (inBlacklist == true) goto L28;
        r7 = 0.0f;
    L28:
        r12[1] = r7;
        r2.play(ObjectAnimator.ofPropertyValuesHolder(r1.getGuardrailView(), new PropertyValuesHolder[]{r9, r10, PropertyValuesHolder.ofFloat(r11, r12)}));
        r2.addListener(new AnonymousClass2(this, c, r1, inBlacklist));
        v.post(new AnonymousClass3(this, r2));
        return;
    L21:
        r8 = 1.0f;
        goto L22
    L17:
        r5 = R.interpolator.decelerate_quad;
        goto L18
    L13:
        r3 = 100;
        goto L14
    }

    public boolean isEditAnimPlaying() {
        return this.mEditAnimPlaying;
    }

    public void doEditAnim(final OListView listView, final View searchView, final View editView, final View editControlView, final boolean isEdit) {
        final AnimatorSet r10 = new AnimatorSet();
        Interpolator r11 = AnimationUtils.loadInterpolator(this.mContext, R.interpolator.decelerate_cubic);
        final RelativeLayout.LayoutParams r5 = (RelativeLayout.LayoutParams) listView.getLayoutParams();
        r10.addListener(new AnonymousClass4(this, isEdit, editView, editControlView, r5, listView));
        PropertyValuesHolder r0 = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{1.0f, 0.0f});
        PropertyValuesHolder r2 = PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{1.0f, 0.1f});
        PropertyValuesHolder r3 = PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{1.0f, 0.1f});
        PropertyValuesHolder r4 = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f});
        PropertyValuesHolder r6 = PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{0.1f, 1.0f});
        PropertyValuesHolder r7 = PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{0.1f, 1.0f});
        if (isEdit == false) goto L5;
        float r13 = MessageUtils.dp2Pixels(this.mContext, 20.0f);
    L6:
        char r14 = 0;
        int r15 = 0;
    L8:
        if (r15 >= listView.getChildCount()) goto L29;
        View r12 = listView.getChildAt(r15);
        if (r12 == null) goto L27;
        View r1 = r12.findViewById(R.id.conversation_list_item);
        if (r1 == null) goto L27;
        if ((r1 instanceof ConversationListItem) == false) goto L27;
        if (editControlView == null) goto L27;
        ConversationListItem r8 = (ConversationListItem) r1;
        if (isEdit == false) goto L21;
        View r16 = r8.getAvatarLayout();
    L22:
        PropertyValuesHolder[] r9 = new PropertyValuesHolder[3];
        r9[r14] = r0;
        r9[1] = r2;
        r9[2] = r3;
        ObjectAnimator r17 = ObjectAnimator.ofPropertyValuesHolder(r16, r9);
        if (isEdit == false) goto L25;
        View r18 = r8.getCheckView();
    L26:
        ObjectAnimator r19 = ObjectAnimator.ofPropertyValuesHolder(r18, new PropertyValuesHolder[]{r4, r6, r7});
        ObjectAnimator r20 = ObjectAnimator.ofFloat(r8.getArrow(), View.TRANSLATION_X, new float[]{r13});
        r17.setDuration(150);
        r20.setDuration(150);
        r19.setDuration(150);
        r17.setInterpolator(r11);
        r20.setInterpolator(r11);
        r19.setInterpolator(r11);
        r10.play(r17).with(r20).before(r19);
        goto L27
    L25:
        r18 = r8.getAvatarLayout();
        goto L26
    L21:
        r16 = r8.getCheckView();
    L27:
        r15 = r15 + 1;
        r2 = r2;
        r3 = r3;
        r14 = 0;
        goto L8
    L29:
        if (searchView == null) goto L47;
        if (editView == null) goto L47;
        int r21 = searchView.getWidth();
        if (isEdit == false) goto L34;
        View r22 = searchView;
    L35:
        Property r23 = View.TRANSLATION_X;
        float[] r24 = new float[2];
        r24[0] = 0.0f;
        if (isEdit == false) goto L38;
        float r25 = r21;
    L39:
        r24[1] = r25;
        ObjectAnimator r26 = ObjectAnimator.ofFloat(r22, r23, r24);
        if (isEdit == false) goto L42;
        View r27 = editView;
    L43:
        Property r28 = View.TRANSLATION_X;
        float[] r29 = new float[2];
        if (isEdit == false) goto L46;
        r21 = -r21;
    L46:
        r29[0] = r21;
        float r30 = 0.0f;
        r29[1] = 0.0f;
        ObjectAnimator r31 = ObjectAnimator.ofFloat(r27, r28, r29);
        r26.setDuration(200);
        r31.setDuration(200);
        r10.play(r26).with(r31);
    L49:
        if (editControlView == null) goto L54;
        if (isEdit == false) goto L52;
        float r110 = -this.mContext.getResources().getDimension(R.dimen.edit_control_view_height);
    L53:
        ObjectAnimator r32 = ObjectAnimator.ofFloat(editControlView, View.TRANSLATION_Y, new float[]{r110});
        r32.setInterpolator(r11);
        r32.setDuration(200);
        r10.play(r32);
        goto L54
    L52:
        r110 = r30;
    L54:
        listView.post(new AnonymousClass5(this, r10));
        return;
    L42:
        r27 = searchView;
        goto L43
    L38:
        r25 = -r21;
        goto L39
    L34:
        r22 = editView;
    L47:
        r30 = 0.0f;
        goto L49
    L5:
        r13 = 0.0f;
        goto L6
    }
}
