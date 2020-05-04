import { Player } from "./player";
import { DraftPick } from "./draftpick";
import { CurrentYearDraftPicks } from "./currentYearDraftPick";

export interface Franchise {
    icon: string;
    owner_name: string;
    name: string;
    id: string;
    player: Player[];
    current_year_draft_picks: CurrentYearDraftPicks;
}