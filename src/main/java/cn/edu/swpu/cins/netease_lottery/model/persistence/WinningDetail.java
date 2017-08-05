package cn.edu.swpu.cins.netease_lottery.model.persistence;

import java.util.List;

/**
 * Created by miaomiao on 17-7-26.
 */
public class WinningDetail {
    private int id;
    private List<Integer> winNumber;
    private String bigSmall;

    public WinningDetail() {
    }

    public WinningDetail(int id, List<Integer> winNumber, String bigSmall) {
        this.id = id;
        this.winNumber = winNumber;
        this.bigSmall = bigSmall;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getWinNumber() {
        return winNumber;
    }

    public void setWinNumber(List<Integer> winNumber) {
        this.winNumber = winNumber;
    }

    public String getBigSmall() {
        return bigSmall;
    }

    public void setBigSmall(String bigSmall) {
        this.bigSmall = bigSmall;
    }
}
