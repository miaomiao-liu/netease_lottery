package cn.edu.swpu.cins.netease_lottery.model.view;

/**
 * Created by miaomiao on 17-7-28.
 */
public class OrderIsWin {
    private String isWin;
    private int winGrade;
    private int winMoney;

    public OrderIsWin() {
    }

    public OrderIsWin(String isWin, int winGrade, int winMoney) {
        this.isWin = isWin;
        this.winGrade = winGrade;
        this.winMoney = winMoney;
    }

    public int getWinGrade() {
        return winGrade;
    }

    public void setWinGrade(int winGrade) {
        this.winGrade = winGrade;
    }

    public String getIsWin() {
        return isWin;
    }

    public void setIsWin(String isWin) {
        this.isWin = isWin;
    }

    public int getWinMoney() {
        return winMoney;
    }

    public void setWinMoney(int winMoney) {
        this.winMoney = winMoney;
    }
}
