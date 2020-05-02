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
    <div className="rosters">
      {getEachRoster()}
    </div>
  );


};