package com.android.settings.graph;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public class UsageView extends FrameLayout {
    private final TextView[] mBottomLabels;
    private final TextView[] mLabels;
    private final UsageGraph mUsageGraph;

    public UsageView(Context r8, AttributeSet r9) {
        super(r8, r9);
        LayoutInflater.from(r8).inflate(R.layout.usage_view, this);
        this.mUsageGraph = (UsageGraph) findViewById(R.id.usage_graph);
        TextView[] r1 = {(TextView) findViewById(R.id.label_bottom), (TextView) findViewById(R.id.label_middle), (TextView) findViewById(R.id.label_top)};
        this.mLabels = r1;
        this.mBottomLabels = new TextView[]{(TextView) findViewById(R.id.label_start), (TextView) findViewById(R.id.label_end)};
        TypedArray r10 = r8.obtainStyledAttributes(r9, R.styleable.UsageView, 0, 0);
        if (r10.hasValue(3) == false) goto L6;
        setSideLabels(r10.getTextArray(3));
    L6:
        if (r10.hasValue(2) == false) goto L9;
        setBottomLabels(r10.getTextArray(2));
    L9:
        if (r10.hasValue(4) == false) goto L17;
        int r11 = r10.getColor(4, 0);
        int r0 = r1.length;
        int r2 = 0;
    L11:
        if (r2 >= r0) goto L13;
        r1[r2].setTextColor(r11);
        r2 = r2 + 1;
        goto L11
    L13:
        TextView[] r3 = this.mBottomLabels;
        int r4 = r3.length;
        int r5 = 0;
    L14:
        if (r5 >= r4) goto L17;
        r3[r5].setTextColor(r11);
        r5 = r5 + 1;
    L17:
        if (r10.hasValue(0) == false) goto L26;
        int r12 = r10.getInt(0, 0);
        if (r12 != 8388613) goto L22;
        LinearLayout r13 = (LinearLayout) findViewById(R.id.graph_label_group);
        LinearLayout r6 = (LinearLayout) findViewById(R.id.label_group);
        r13.removeView(r6);
        r13.addView(r6);
        r6.setGravity(GravityCompat.END);
        LinearLayout r14 = (LinearLayout) findViewById(R.id.bottom_label_group);
        View r7 = r14.findViewById(R.id.bottom_label_space);
        r14.removeView(r7);
        r14.addView(r7);
        goto L26
    L22:
        if (r12 == 8388611) goto L26;
        throw new IllegalArgumentException("Unsupported gravity " + r12);
    L26:
        this.mUsageGraph.setAccentColor(r10.getColor(1, 0));
        r10.recycle();
    }

    public void clearPaths() {
        this.mUsageGraph.clearPaths();
    }

    public void addPath(SparseIntArray r1) {
        this.mUsageGraph.addPath(r1);
    }

    public void configureGraph(int r2, int r3, boolean r4, boolean r5) {
        this.mUsageGraph.setMax(r2, r3);
        this.mUsageGraph.setShowProjection(r4, r5);
    }

    public void setAccentColor(int r1) {
        this.mUsageGraph.setAccentColor(r1);
    }

    public void setDividerLoc(int r1) {
        this.mUsageGraph.setDividerLoc(r1);
    }

    public void setDividerColors(int r1, int r2) {
        this.mUsageGraph.setDividerColors(r1, r2);
    }

    public void setSideLabelWeights(float r2, float r3) {
        setWeight(R.id.space1, r2);
        setWeight(R.id.space2, r3);
    }

    private void setWeight(int r1, float r2) {
        View r0 = findViewById(r1);
        LinearLayout.LayoutParams r3 = (LinearLayout.LayoutParams) r0.getLayoutParams();
        r3.weight = r2;
        r0.setLayoutParams(r3);
    }

    public void setSideLabels(CharSequence[] r4) {
        if (r4.length != this.mLabels.length) goto L10;
        int r0 = 0;
    L5:
        TextView[] r1 = this.mLabels;
        if (r0 >= r1.length) goto L8;
        r1[r0].setText(r4[r0]);
        r0 = r0 + 1;
        goto L5
    L8:
        return;
    L10:
        throw new IllegalArgumentException("Invalid number of labels");
    }

    public void setBottomLabels(CharSequence[] r4) {
        if (r4.length != this.mBottomLabels.length) goto L10;
        int r0 = 0;
    L5:
        TextView[] r1 = this.mBottomLabels;
        if (r0 >= r1.length) goto L8;
        r1[r0].setText(r4[r0]);
        r0 = r0 + 1;
        goto L5
    L8:
        return;
    L10:
        throw new IllegalArgumentException("Invalid number of labels");
    }
}
