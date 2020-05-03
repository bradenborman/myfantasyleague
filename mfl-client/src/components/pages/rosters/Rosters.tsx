import React from "react";
import { LeagueData } from "../../../models/leagueData";
import { Franchise } from "../../../models/franchise";
import { Roster } from "./roster/Roster";

require("./rosters.scss");

export interface IRostersProps {
  leagueData: LeagueData;
}

export const Rosters: React.FC<IRostersProps> = (props: IRostersProps) => {
  
  const getEachRoster = (): JSX.Element | JSX.Element[] => {
    return props.leagueData.league.franchises.franchise.map((franchise: Franchise, index: number) => {
      return (
        <Roster roster={franchise} key={index} /> 
      );
    });
  }
  
  return (
    <div>
      <div className="search-Filters">
        <div className="filters-section">
          <div className="heading">
            Filters
          </div>

          <div className="filer">
              Quarterback
          </div>
          <div className="filer">
            Running Back
          </div>
          <div className="filer">
            Wide Reiceiver
          </div>
          <div className="filer">
            Tight Ends
          </div>
          <div className="filer">
            Kicker
          </div>
          <div className="filer">
            Defense
          </div>

        </div>
      </div>
      <div className="rosters">
          {getEachRoster()}
      </div>
    </div>
  );


};