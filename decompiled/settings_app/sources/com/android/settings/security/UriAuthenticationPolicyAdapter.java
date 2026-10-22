package com.android.settings.security;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.android.settings.R;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class UriAuthenticationPolicyAdapter extends RecyclerView.Adapter<UriViewHolder> {
    private final List<Uri> mUris;

    public class UriViewHolder extends RecyclerView.ViewHolder {
        TextView mUriNameView;
        final /* synthetic */ UriAuthenticationPolicyAdapter this$0;

        public UriViewHolder(UriAuthenticationPolicyAdapter r1, View r2) {
            this.this$0 = r1;
            super(r2);
            this.mUriNameView = (TextView) this.itemView.findViewById(R.id.uri_name);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        onBindViewHolder((UriViewHolder) r1, r2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return onCreateViewHolder(r1, r2);
    }

    UriAuthenticationPolicyAdapter(List<Uri> r1) {
        this.mUris = r1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public UriViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        return new UriViewHolder(this, LayoutInflater.from(r3.getContext()).inflate(R.layout.app_authentication_uri_item, r3, false));
    }

    public void onBindViewHolder(UriViewHolder r1, int r2) {
        Uri r0 = this.mUris.get(r2);
        r1.mUriNameView.setText(Uri.decode(r0.toString()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mUris.size();
    }
}
