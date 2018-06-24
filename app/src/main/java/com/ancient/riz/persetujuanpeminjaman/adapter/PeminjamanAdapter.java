package com.ancient.riz.persetujuanpeminjaman.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.ancient.riz.persetujuanpeminjaman.R;
import com.ancient.riz.persetujuanpeminjaman.model.PeminjamanModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;


public class PeminjamanAdapter extends RecyclerView.Adapter<PeminjamanAdapter.PeminjamanHolder> {

    List<PeminjamanModel> peminjamanModelList;
    Context mContext;

    private String[] mColors = {
            "#39add1", // light blue
            "#3079ab", // dark blue
            "#c25975", // mauve
            "#e15258", // red
            "#f9845b", // orange
            "#838cc7", // lavender
            "#7d669e", // purple
            "#53bbb4", // aqua
            "#51b46d", // green
            "#e0ab18", // mustard
            "#637a91", // dark gray
            "#f092b0", // pink
            "#b7c0c7"  // light gray
    };

    public PeminjamanAdapter(Context context, List<PeminjamanModel> peminjamanModelList) {
        this.mContext = context;
        this.peminjamanModelList = peminjamanModelList;
    }

    @NonNull
    @Override
    public PeminjamanHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_peminjaman, parent, false);
        return new PeminjamanHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PeminjamanHolder holder, int position) {
        final PeminjamanModel listPeminjamanModel = peminjamanModelList.get(position);
        SimpleDateFormat spf = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);

        String namaPeminjam = listPeminjamanModel.getNmPeminjamDpn() + " " +listPeminjamanModel.getNmPeminjamBlkng();

        holder.tvNmPeminjam.setText(namaPeminjam);
        holder.tvTglPinjam.setText(spf.format(listPeminjamanModel.getTglPinjam()));
        holder.tvTglKembali.setText(spf.format(listPeminjamanModel.getTglPinjam()));
        holder.tvNamaMobil.setText(listPeminjamanModel.getNmMobil());
        holder.tvId.setText(listPeminjamanModel.getId());

        String nama = listPeminjamanModel.getNmPeminjamDpn();
        String firstCharNama = nama.substring(0, 1);
        TextDrawable drawable = TextDrawable.builder()
                .buildRound(firstCharNama, getColor());
        holder.ivTextDrawable.setImageDrawable(drawable);
    }

    @Override
    public int getItemCount() {
        return peminjamanModelList.size();
    }

    public class PeminjamanHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ivTextDrawable)
        ImageView ivTextDrawable;
        @BindView(R.id.tvNmPeminjam)
        TextView tvNmPeminjam;
        @BindView(R.id.tvId)
        TextView tvId;
        @BindView(R.id.tvTglPinjam)
        TextView tvTglPinjam;
        @BindView(R.id.tvTglKembali)
        TextView tvTglKembali;
        @BindView(R.id.tvNamaMobil)
        TextView tvNamaMobil;

        private PeminjamanHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }

    public int getColor() {
        String color;

        // Randomly select a fact
        Random randomGenerator = new Random(); // Construct a new Random number generator
        int randomNumber = randomGenerator.nextInt(mColors.length);

        color = mColors[randomNumber];
        int colorAsInt = Color.parseColor(color);

        return colorAsInt;
    }
}
