import React from "react";
import { Franchise } from "../../../../models/franchise";
import { Player } from "../../../../models/player";

require("./roster.scss");

export interface IRosterProps {
    roster: Franchise;
}

export const Roster: React.FC<IRosterProps> = (props: IRosterProps) => {
  
    const getPlayers = (): JSX.Element[] | JSX.Element | any  => {
      let QBs = getGrouping("QB")
      let RBs = getGrouping("RB")
      let WRs = getGrouping("WR")
      let TEs = getGrouping("TE")
      let Ks = getGrouping("PK")
      let DEFs = getGrouping("Def")



      return [
        QBs, RBs, WRs, TEs, Ks, DEFs
      ]
   }
  
  const getNumberValue = (x: string) => {
    return Number(x) || 1;
  }
  
  const getGrouping = (pos: string): JSX.Element[] => {
    return props.roster.player
      .filter(platers => platers.position == pos)
      .sort((p1, p2) => getNumberValue(p2.salary) - getNumberValue(p1.salary))
       .map((player: Player, i: number) => {
           return (
             <tr key={i} className={"pos" + i}>
               <td>{player.position}</td>
               <td className={player.on_trading_block ? 'trading-block' : ''}>{player.name}</td>
               <td>{player.team}</td>
               <td>${player.salary}</td>
             </tr>
           );
       });
  }
  
    return (
      <div className="roster">
          <div className="teamInfo">
            <div className="teamLogo">
                <img src={props.roster.icon} />
            </div>
              <h1 className="teamName" >{props.roster.name}</h1>
              <h3 className="ownerName" >name placeholder</h3>
        </div>
        

        <table className="playersTable">
          <thead>
            <tr>
              <th>POS</th>
              <th>Player Name</th>
              <th>Team</th>
              <th>Salary</th>
            </tr>
          </thead>
          <tbody>
          {getPlayers()}
          </tbody>
        </table>


    </div>
  );
};