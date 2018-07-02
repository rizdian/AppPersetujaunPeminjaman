package com.ancient.riz.persetujuanpeminjaman.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.amulyakhare.textdrawable.TextDrawable;
import com.ancient.riz.persetujuanpeminjaman.R;
import com.ancient.riz.persetujuanpeminjaman.activity.HistoryActivity;
import com.ancient.riz.persetujuanpeminjaman.activity.MainActivity;
import com.ancient.riz.persetujuanpeminjaman.model.BaseModel;
import com.ancient.riz.persetujuanpeminjaman.model.PeminjamanModel;
import com.ancient.riz.persetujuanpeminjaman.util.SharedPrefManager;
import com.ancient.riz.persetujuanpeminjaman.util.api.BaseApiService;
import com.ancient.riz.persetujuanpeminjaman.util.api.UtilsApi;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PeminjamanAdapter extends RecyclerView.Adapter<PeminjamanAdapter.PeminjamanHolder> {

    private List<PeminjamanModel> peminjamanModelList;
    private Context mContext;
    private BaseApiService mApiService;
    private SharedPrefManager sharedPrefManager;
    private String token;

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
        sharedPrefManager = new SharedPrefManager(context);
        token = sharedPrefManager.getSPToken();
        mApiService = UtilsApi.getAPIService();
    }

    @NonNull
    @Override
    public PeminjamanHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_peminjaman, parent, false);
        return new PeminjamanHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final PeminjamanHolder holder, final int position) {
        final PeminjamanModel listPeminjamanModel = peminjamanModelList.get(position);
        SimpleDateFormat spf = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);

        final String namaPeminjam = listPeminjamanModel.getNmPeminjamDpn() + " " + listPeminjamanModel.getNmPeminjamBlkng();

        holder.tvNmPeminjam.setText(namaPeminjam);
        holder.tvTglPinjam.setText(spf.format(listPeminjamanModel.getTglPinjam()));
        holder.tvTglKembali.setText(spf.format(listPeminjamanModel.getTglPinjam()));
        holder.tvNamaMobil.setText(listPeminjamanModel.getNmMobil());
        holder.tvId.setText(String.valueOf(listPeminjamanModel.getId()));

        String nama = listPeminjamanModel.getNmPeminjamDpn();
        String firstCharNama = nama.substring(0, 1);
        TextDrawable drawable = TextDrawable.builder()
                .buildRound(firstCharNama, getColor());
        holder.ivTextDrawable.setImageDrawable(drawable);

        // Set onclicklistener pada view cvMain (CardView)
        holder.tvOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                //creating a popup menu
                PopupMenu popup = new PopupMenu(mContext, holder.tvOption);
                //inflating menu from xml resource
                popup.inflate(R.menu.options_menu);
                //adding click listener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Intent intent = new Intent();
                        switch (item.getItemId()) {
                            case R.id.menu1:
                                intent = new Intent(mContext, HistoryActivity.class);
                                mContext.startActivity(intent);
                                break;
                            case R.id.menu2:
                                final Integer id = listPeminjamanModel.getId();
                                final AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                                builder.setCancelable(true);
                                builder.setTitle("Persetujuan");
                                builder.setMessage("Apakah Anda yakin akan penyetujui peminjaman atas nama "+ namaPeminjam +"?");
                                builder.setPositiveButton("Setuju",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                getApproval(id);
                                            }
                                        });
                                builder.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });

                                AlertDialog dialog = builder.create();
                                dialog.show();
                                break;
                            case R.id.menu3:
                                Snackbar.make(view, "Clicked element 3" + namaPeminjam, Snackbar.LENGTH_LONG).show();
                                break;
                        }
                        return false;
                    }
                });
                //displaying the popup
                popup.show();
            }
        });

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
        @BindView(R.id.tvOption)
        TextView tvOption;

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

    private void getApproval(Integer id) {
        mApiService.getApproval(token,id).enqueue(new Callback<BaseModel>() {
            @Override
            public void onResponse(@NonNull Call<BaseModel> call, @NonNull Response<BaseModel> response) {
                if (response.isSuccessful()){
                    assert response.body() != null;
                    if (response.body().getStatus() == 1){
                        Toast.makeText(mContext, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        ((MainActivity)mContext).getResultListPeminjaman();
                    }else{
                        Toast.makeText(mContext, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(mContext, "Gagal mengambil data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<BaseModel> call, @NonNull Throwable t) {
                Toast.makeText(mContext, "Koneksi Internet Bermasalah", Toast.LENGTH_SHORT).show();
            }

        });
    }
}
