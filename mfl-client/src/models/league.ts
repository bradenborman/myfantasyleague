import { Franchises } from "./franchises";

export interface League {
    franchises: Franchises;
    name: string;
    base_url: string;
}