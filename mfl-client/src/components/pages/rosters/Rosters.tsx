import React, { useState } from "react";
import { LeagueData } from "../../../models/leagueData";
import { Franchise } from "../../../models/franchise";
import { Roster } from "./roster/Roster";

require("./rosters.scss");

export interface IRostersProps {
  leagueData: LeagueData;
}

export const Rosters: React.FC<IRostersProps> = (props: IRostersProps) => {
  

  const [activeFilers, setActiveFilers] = useState<string[]>(["QB", "RB", "WR", "TE", "PK", "Def"]);
  const [lowSalaryRange, setLowSalaryRange] = useState<number>(1);
  const [upSalaryRange, setUpSalaryRange] = useState<number>(100);

  const getEachRoster = (): JSX.Element | JSX.Element[] => {
    return props.leagueData.league.franchises.franchise.map((franchise: Franchise, index: number) => {
      return (
        <Roster roster={franchise} key={index}
          activeFilters={activeFilers}
          upperSalaryLimit={upSalaryRange != null || upSalaryRange != undefined ? upSalaryRange : 0}
          lowerSalaryLimit={upSalaryRange != null || lowSalaryRange != undefined ? lowSalaryRange : 0}
        /> 
      );
    });
  }
  
  const handleUpSalaryChange = (e: any) => {
    setUpSalaryRange(e)
  }

  const handleLowSalaryChange = (e: any) => {
    setLowSalaryRange(e)
  }

const handleFilterChange = (pos: string):void => {
  const newFilers = [...activeFilers]
  if (activeFilers.indexOf(pos) > -1) 
    newFilers.splice(activeFilers.indexOf(pos), 1)
  else
    newFilers.push(pos)
  
  setActiveFilers(newFilers)
}

  const activeChosen = (pos: string): string => {
    return activeFilers.indexOf(pos) > -1 ? "filter active" : "filter not-active"
}
  
  return (
    <div>
      <div className="search-Filters">
        <div className="filters-section">
          <div className="heading">
            Position Filters
          </div>
          <div className={activeChosen("QB")} onClick={e => handleFilterChange("QB")}>
              Quarterback
          </div>
          <div className={activeChosen("RB")}  onClick={e => handleFilterChange("RB")}>
            Running Back
          </div>
          <div className={activeChosen("WR")}  onClick={e => handleFilterChange("WR")}>
            Wide Reiceiver
          </div>
          <div className={activeChosen("TE")}  onClick={e => handleFilterChange("TE")}>
            Tight Ends
          </div>
          <div className={activeChosen("PK")}  onClick={e => handleFilterChange("PK")}>
            Kicker
          </div>
          <div className={activeChosen("Def")}  onClick={e => handleFilterChange("Def")}>
            Defense
          </div>

          <div className="salary-limit-filter">
            <label className="heading">Salary Range:</label><br />
            <div className="input-wrapper">
            <input
              className="salary-range-input"
              type="number"
              value={lowSalaryRange}
              onChange={e => handleLowSalaryChange(e.target.value)}
            />
            to
            <input
              className="salary-range-input"
              type="number"
              value={upSalaryRange}
              onChange={e => handleUpSalaryChange(e.target.value)}
              />
            </div>

          </div>

        </div>
      </div>
      <div className="rosters">
          {getEachRoster()}
      </div>
    </div>
  );


};