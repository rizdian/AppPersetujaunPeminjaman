package com.ancient.riz.persetujuanpeminjaman.model;

import java.util.List;

public class AllHistoryModel extends BaseModel {

    private List<HistoryModel> data;

    public List<HistoryModel> getData() {
        return data;
    }

    public void setData(List<HistoryModel> data) {
        this.data = data;
    }
}
