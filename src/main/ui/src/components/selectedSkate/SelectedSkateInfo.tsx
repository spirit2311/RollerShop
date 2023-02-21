import * as React from 'react';
import {Skate} from "../../types";
import AttachMoneyIcon from '@mui/icons-material/AttachMoney';

const IMG_SRC = 'https://cdn11.bigcommerce.com/s-od3c3p8x4p/images/stencil/500x659/products/589/1354/MTP_Violet__19868.1665185464.jpg?c=1';

interface SelectedSkateInfoProps {
    selectedSkate: Skate;
}

const SelectedSkateInfo = ({selectedSkate}: SelectedSkateInfoProps) => {
    return (
        <div className="container">
            {
                <div className="backgroundWrapper"
                     style={{backgroundImage: `url(${IMG_SRC})`}}
                />
            }
            <div className="mainInfo">
                <img src={IMG_SRC} alt="Not Found" />
                <div className="generalInfoContainer">
                    <section className="detailsSection">
                        <h1 className="title" data-testid="Title">{selectedSkate.brand.brand} {selectedSkate.model}</h1>
                        <span data-testid="secondaryInfo" className="secondaryInfo">
                                <em className="releaseYear" data-testid="ReleaseYear">{selectedSkate.year}</em>
                        </span>
                    </section>
                    <section className="priceSection">
                        <AttachMoneyIcon fontSize="large" />
                        <span className="priceValue">{selectedSkate.price}</span>
                    </section>
                    <section className="overviewSection">
                        <h1 title='Overview' className="title">
                            Overview
                        </h1>
                        <p title={selectedSkate.description} data-testid="Overview" className="content">
                            {selectedSkate.description}
                        </p>
                    </section>
                </div>
            </div>
        </div>
    );
};

export default SelectedSkateInfo;