package com.android.settings.provision;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.android.settings.R;
import com.obric.oui.lisitem.OListItemCheck;

/* JADX INFO: loaded from: classes2.dex */
public class PasswordAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private int currentIndex;
    private final Activity mActivity;
    private PasswordItem[] mData;

    static class PasswordItem {
        public int pinLength;
        public int quality;
        public String title;

        PasswordItem() {
        }
    }

    class PasswordViewHolder extends RecyclerView.ViewHolder {
        private final OListItemCheck itemcheck;
        final /* synthetic */ PasswordAdapter this$0;

        public PasswordViewHolder(PasswordAdapter r1, View r2) {
            this.this$0 = r1;
            super(r2);
            this.itemcheck = (OListItemCheck) r2.findViewById(R.id.item_check);
        }

        public void bindData(final int r3) {
            OListItemCheck r0 = this.itemcheck;
            if (r3 != PasswordAdapter.access$000(this.this$0)) goto L5;
            boolean r1 = true;
        L6:
            r0.setChecked(r1);
            this.itemcheck.setTitle(PasswordAdapter.access$100(this.this$0)[r3].title);
            this.itemcheck.setOnClickListener(new PasswordAdapter$PasswordViewHolder$$ExternalSyntheticLambda0(this, r3));
            return;
        L5:
            r1 = false;
            goto L6
        }

        /* JADX INFO: renamed from: lambda$bindData$0$com-android-settings-provision-PasswordAdapter$PasswordViewHolder, reason: not valid java name */
        /* synthetic */ void m543x6b42c340(int r2, View r3) {
            if (this.itemcheck.isChecked() == false) goto L5;
            return;
        L5:
            this.itemcheck.setChecked(true);
            PasswordAdapter.access$002(this.this$0, r2);
            this.this$0.notifyDataSetChanged();
        }
    }

    static /* synthetic */ int access$000(PasswordAdapter r0) {
        return r0.currentIndex;
    }

    static /* synthetic */ int access$002(PasswordAdapter r0, int r1) {
        r0.currentIndex = r1;
        return r1;
    }

    static /* synthetic */ PasswordItem[] access$100(PasswordAdapter r0) {
        return r0.mData;
    }

    public PasswordAdapter(Activity r2) {
        this.currentIndex = 0;
        this.mActivity = r2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        return new PasswordViewHolder(this, LayoutInflater.from(this.mActivity).inflate(R.layout.o_wrap_list_content_item_check, r3, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        ((PasswordViewHolder) r1).bindData(r2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        PasswordItem[] r0 = this.mData;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.length;
    }

    public void setData(PasswordItem[] r1) {
        this.mData = r1;
    }

    public int getCurrentIndex() {
        return this.currentIndex;
    }
}
