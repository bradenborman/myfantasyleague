https://www61.myfantasyleague.com/2020/export?TYPE=rosters&L=32291&APIKEY=&FRANCHISE=&JSON=1
https://www61.myfantasyleague.com/2020/export?TYPE=players&L=32291&APIKEY=&DETAILS=&SINCE=&PLAYERS=&JSON=1
https://www61.myfantasyleague.com/2020/export?TYPE=league&L=32291&APIKEY=&JSON=1
https://www61.myfantasyleague.com/2020/export?TYPE=salaries&L=32291&APIKEY=&JSON=1
https://www61.myfantasyleague.com/2020/export?TYPE=pendingTrades&L=32291&APIKEY=&FRANCHISE_ID=&JSON=1


    const getPlayers = (): JSX.Element | JSX.Element[] => {
      return props.roster.player.filter(platers => platers.on_trading_block)
        .map((player: Player, index: number) => {
            return (
              <tr>
                <td>{player.position}</td>
                <td className={player.on_trading_block ? 'trading-block' : ''}>{player.name}</td>
                <td>{player.team}</td>
                <td>${player.salary}</td>
              </tr>
            );
          });
   }