package cn.edu.swpu.cins.netease_lottery.model.view;

/**
 * Created by miaomiao on 17-7-28.
 */
public class OrderIsWin {
    private int wins;
    private String isWin;
    private int winGrade;
    private int winMoney;

    public OrderIsWin() {
    }

    public OrderIsWin(int wins, String isWin, int winGrade, int winMoney) {
        this.wins = wins;
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

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }
}
