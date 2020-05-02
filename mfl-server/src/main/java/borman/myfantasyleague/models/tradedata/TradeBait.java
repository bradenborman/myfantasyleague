package borman.myfantasyleague.models.tradedata;

public class TradeBait {

    private String franchise_id;
    private String willGiveUp;
    private String inExchangeFor;

    public String getFranchise_id() {
        return franchise_id;
    }

    public void setFranchise_id(String franchise_id) {
        this.franchise_id = franchise_id;
    }

    public String getWillGiveUp() {
        return willGiveUp;
    }

    public void setWillGiveUp(String willGiveUp) {
        this.willGiveUp = willGiveUp;
    }

    public String getInExchangeFor() {
        return inExchangeFor;
    }

    public void setInExchangeFor(String inExchangeFor) {
        this.inExchangeFor = inExchangeFor;
    }

}