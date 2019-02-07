package kz.alibi.hday;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UsersList {

    @SerializedName("list")
    @Expose
    private List<Listz> list = null;

    public UsersList(Listz list) {
    }

    public List<Listz> getList() {
        return list;
    }

    public void setList(List<Listz> list) {
        this.list = list;
    }

    public static class membersAdapter {
    }
}