package borman.myfantasyleague.models.draftpickdata;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CurrentYearDraftPicks {

    private List<DraftPick> draftPick;

    public List<DraftPick> getDraftPick() {
        return draftPick;
    }

    public void setDraftPick(List<DraftPick> draftPick) {
        this.draftPick = draftPick;
    }
}