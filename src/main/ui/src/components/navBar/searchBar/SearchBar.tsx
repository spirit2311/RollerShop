import * as React from 'react';
import {ChangeEvent, FormEvent, useRef, useState} from 'react';
import {connect} from 'react-redux';
import SearchIcon from "@mui/icons-material/Search";
import CloseIcon from "@mui/icons-material/Close";
import SearchWrapper from "./SearchWrapper";
import {Skate} from "../../../types";

interface StateToProps {
    skates: Skate[];
}

interface SearchBarProps extends StateToProps {
    placeholder: string;
}

const SearchBar = ({placeholder}: SearchBarProps): JSX.Element => {
    const inputEl = useRef(null);
    const [filteredData, setFilteredData] = useState([]);
    const [wordEntered, setWordEntered] = useState('');

    const handleFilter = async (event: ChangeEvent<HTMLInputElement>): Promise<void> => {
      const searchWord = event.target.value;
      setWordEntered(searchWord);

      if (searchWord === "") {
          setFilteredData([]);
      }
    };

    const handleSubmit = (e: FormEvent<HTMLFormElement>): void => {
        e.preventDefault();
        clearDataAndCloseResults();
    };

    const handleOutsideClick = (e: Event): void => {
        if (!inputEl.current?.contains(e.target)) {
            clearDataAndCloseResults();
        }
    };

    const clearDataAndCloseResults = (): void => {
        setWordEntered('');
    };

    if (wordEntered) {
        document.addEventListener("click", handleOutsideClick, false);
    } else {
        document.removeEventListener("click", handleOutsideClick, false);
    }

    return (
        <SearchWrapper ref={inputEl} data-testid="SearchBar">
            <form data-testid="searchBarForm" onSubmit={handleSubmit}>
                <div data-testid="searchInputs" className="searchInputs">
                    <input
                        data-testid="input"
                        type="text"
                        value={wordEntered}
                        placeholder={placeholder}
                        onChange={handleFilter}
                        className={`${filteredData.length !== 0 ? 'hasResults' : ''}`}
                    />
                    <div className={`searchIcon ${!!filteredData.length ? 'hasResults' : ''}`} >
                        {
                            !filteredData.length ?
                                <SearchIcon /> :
                                <CloseIcon id="clearBtn" onClick={clearDataAndCloseResults} />
                        }
                    </div>
                </div>
            </form>
        </SearchWrapper>
    );
};

const mapStateToProps = (state: {
    skates: {
        skates: StateToProps
    }
}): StateToProps => {
    return {
        skates: state.skates.skates.skates
    };
};

export default connect(mapStateToProps)(SearchBar);