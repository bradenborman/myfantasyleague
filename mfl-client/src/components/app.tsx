import React, { useState, useEffect } from "react";
import Spinner from "react-bootstrap/Spinner";
import axios from "axios";


import {
  BrowserRouter as ReactRouter,
  Route as ReactRoute
} from "react-router-dom";
import { Navbar } from "./navbar/Navbar";
import { Rosters } from "./pages/rosters/Rosters";
import { LeagueData } from "../models/leagueData";

require("./app.scss");

export interface IAppProps {}

export const App: React.FC<IAppProps> = (props: IAppProps) => {

  const [leagueData, setLeagueData] = useState<LeagueData>(),
  [fetching, setFetching] = useState<boolean>(true),
  [fetchError, setFetchError] = useState<boolean>(false);
  
  useEffect(() => {
    fetchData();
  }, []);

  const fetchData = async () => {
    setFetching(true);
    try {
      const res: any = await axios.get(`/api/static-data`);
      setFetching(false);
      setLeagueData(res.data);
      setFetchError(false);
    } catch (err) {
      console.error(err);
      setFetching(false);
      setFetchError(true);
    }
  };

  const getRosterPage = (): JSX.Element | null => {
    if(leagueData != null)
      return <Rosters leagueData={leagueData} />;
    return null;
  }

  const getAppropriatePage = (): JSX.Element | JSX.Element[] => {
    
    if(fetching)
      return <p>Please while while loading</p>
    else if (fetchError)
      return <p>Error Loading Data</p>
    
    return (
      <ReactRouter>            
        <ReactRoute path="/rosters" component={getRosterPage} />
      </ReactRouter>
    )

  }

  return (
    <div className="app">
      <Navbar />
      {getAppropriatePage()}
    </div>
  );
};
