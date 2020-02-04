package com.example.bohataalarider;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class RriderB {
    @SerializedName("new")

    private List<NewRetro> _new = new ArrayList<>();
    @SerializedName("inProgress")

    private List<InProgressRetro> inProgress = new ArrayList<>();

    public List<NewRetro> getNew() {
        return _new;
    }

    public void setNew(List<NewRetro> _new) {
        this._new = _new;
    }

    public List<InProgressRetro> getInProgress() {
        return inProgress;
    }

    public void setInProgress(List<InProgressRetro> inProgress) {
        this.inProgress = inProgress;
    }

}
