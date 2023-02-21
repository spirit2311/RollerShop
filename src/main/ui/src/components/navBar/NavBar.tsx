import * as React from 'react';
import NavBarContainer from "./NavBarContainer";
import SearchBar from "./searchBar/SearchBar";
import HomeBtn from "./searchBar/HomeBtn";
import CreateBtn from "./CreateBtn";
import {Link} from "react-router-dom";

const NavBar = () => ((
    <NavBarContainer>
        <HomeBtn/>
        <SearchBar placeholder="Enter a skate title..."/>
        <CreateBtn />
        <Link to='/disciplines'>
            <span className="DisciplinesList">
                DISCIPLINES
            </span>
        </Link>
        <Link to='/brands'>
            <span className="BrandsList">
                BRANDS
            </span>
        </Link>
    </NavBarContainer>
));

export default NavBar;