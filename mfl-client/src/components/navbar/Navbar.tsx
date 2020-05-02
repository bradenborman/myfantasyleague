import React from "react";

require("./navbar.scss");

export interface INavProps {}

export const Navbar: React.FC<INavProps> = (props: INavProps) => {
  return (
    <div className="nav">
      <div className="logo">
        <p>Borman Dynasty League</p>
        </div>
    </div>
  );
};
