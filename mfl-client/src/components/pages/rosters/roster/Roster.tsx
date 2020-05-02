import React from "react";
import { Franchise } from "../../../../models/franchise";
import { Player } from "../../../../models/player";

require("./roster.scss");

export interface IRosterProps {
    roster: Franchise;
}

export const Roster: React.FC<IRosterProps> = (props: IRosterProps) => {
  
    const getPlayers = (): JSX.Element | JSX.Element[] => {
        return props.roster.player.map((player: Player, index: number) => {
            return (
                <p>{player.name != null ? player.name : "PlayerName "} ({player.position != null ? player.position : " position "}) {player.salary != null ? " $" + player.salary : " salary"}</p>
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
            <div className="players">
                {getPlayers()}
            </div>
    </div>
  );
};