import { Player } from "./player";

export interface Franchise {
    icon: string;
    owner_name: string;
    name: string;
    id: string;
    player: Player[];
}