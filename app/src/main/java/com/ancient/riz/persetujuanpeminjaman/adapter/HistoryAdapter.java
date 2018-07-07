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
import com.ancient.riz.persetujuanpeminjaman.model.HistoryModel;
import com.ancient.riz.persetujuanpeminjaman.model.PeminjamanModel;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;


public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryDetailHolder> {

    private List<HistoryModel> historyModelList;
    private Context mContext;

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

    public HistoryAdapter(Context context, List<HistoryModel> historyModelList) {
        this.mContext = context;
        this.historyModelList = historyModelList;
    }

    @NonNull
    @Override
    public HistoryDetailHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detail_peminjaman, parent, false);
        return new HistoryDetailHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final HistoryDetailHolder holder, final int position) {
        final HistoryModel historyModel = historyModelList.get(position);
        String status = "--";

        if (historyModel.getStatus() != null){
            status = ((historyModel.getStatus().equals(1))? "Di Setujui" : (historyModel.getStatus().equals(0) ?"Di Tolak" : "--"));
        }
        final String namaApproval = historyModel.getNmDepanApp() + " " + historyModel.getNmBelakangApp();

        holder.tvStatus.setText(status);
        holder.tvDivisi.setText(historyModel.getDivisi());
        holder.tvTingkatan.setText("Level-"+historyModel.getTingkatan());
        holder.tvNamaApproval.setText(namaApproval);
        holder.tvOnUpdate.setText(historyModel.getOnUpdate());

        String nama = historyModel.getDivisi();
        String firstCharNama = nama.substring(0, 1);
        TextDrawable drawable = TextDrawable.builder()
                .buildRound(firstCharNama, getColor());
        holder.ivLogoDetail.setImageDrawable(drawable);
    }

    @Override
    public int getItemCount() {
        return historyModelList.size();
    }

    public class HistoryDetailHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ivLogoDetail)
        ImageView ivLogoDetail;
        @BindView(R.id.tvStatus)
        TextView tvStatus;
        @BindView(R.id.tvDivisi)
        TextView tvDivisi;
        @BindView(R.id.tvTingkatan)
        TextView tvTingkatan;
        @BindView(R.id.tvNamaApproval)
        TextView tvNamaApproval;
        @BindView(R.id.tvOnUpdate)
        TextView tvOnUpdate;

        private HistoryDetailHolder(View itemView) {
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
