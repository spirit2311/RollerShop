import React from 'react';
import {Skate} from "../../types";
// @ts-expect-error js file not migrated to ts
import ReactCardFlipper from "react-card-flipper";
import {CardContent, CardMedia, Dialog, Typography} from "@mui/material";
import SkateCard from "./SkateCard";
import {useDispatch} from "react-redux";
import {deleteSkate, fetchSkates, selectSkate} from "../../actions/skates";
import EditIcon from '@mui/icons-material/Edit';
import DeleteIcon from '@mui/icons-material/Delete';
import {ThunkDispatch} from "@reduxjs/toolkit";
import UpdateSkateDialogContent from "./UpdateSkateDialogContent";
import {SkatesActions} from "../../actions/types";

const IMG_SRC = 'https://cdn11.bigcommerce.com/s-od3c3p8x4p/images/stencil/500x659/products/589/1354/MTP_Violet__19868.1665185464.jpg?c=1';

const Skate = ({skate}: { skate: Skate }): JSX.Element => {
    const dispatch: ThunkDispatch<{}, {}, SkatesActions> = useDispatch();
    const {uuid, model, year, price, description, brand: { brand: brandName }} = skate;
    const [openEditSkateDialog, setOpenEditSkateDialog] = React.useState(false);

    const onCardClicked = () => {
        dispatch(selectSkate(skate));
    };

    const onEditClicked = (e: React.MouseEvent<HTMLSpanElement, MouseEvent>) => {
      e.preventDefault();
        setOpenEditSkateDialog(true);
    };

    const onDeleteClicked = async (e: React.MouseEvent<HTMLSpanElement, MouseEvent>) => {
        e.preventDefault();
        await dispatch(deleteSkate(uuid)).then(async () => {
            await dispatch(fetchSkates());
        });
    };

    const handleCloseEditSkateDialog = () => {
        setOpenEditSkateDialog(false);
    };

    return (
        <span>
            <ReactCardFlipper
                width="250px"
                height="340px"
                behavior="hover"
                className={"SkateCard"}>
                <div className="text-center">
                    <SkateCard id={uuid} onCardClicked={onCardClicked}>
                        <CardMedia
                            component="img"
                            height="330"
                            src={IMG_SRC}
                            alt="green iguana"
                        />
                        <CardContent className="CardContent">
                            <Typography gutterBottom variant="h5" component="div">
                                {brandName} {model}
                            </Typography>
                            <Typography variant="body2" color="text.secondary">
                                <span className="secondaryText">
                                    <span className="priceAndReleaseDate">$ {price}, {year}</span>
                                </span>
                            </Typography>
                        </CardContent>
                    </SkateCard>
                </div>
                <div className="text-center">
                    <SkateCard id={uuid} onCardClicked={onCardClicked}>
                        <CardContent className="CardContent">
                            <Typography gutterBottom variant="h5" component="div">
                                <em className="overviewContent">
                                    <h1 className="title">Overview</h1>
                                    <div className="content">{description || 'Not found'}</div>
                                </em>
                            </Typography>
                            <span className="actions">
                                <span className="actionIcon" onClick={onEditClicked}>
                                    <EditIcon fontSize="large" />
                                </span>
                                <span className="actionIcon" onClick={onDeleteClicked}>
                                    <DeleteIcon fontSize="large" />
                                </span>
                            </span>
                        </CardContent>
                    </SkateCard>
                </div>
            </ReactCardFlipper>
            {/** @ts-expect-error maxWidth is a string */}
            <Dialog maxWidth={'1000px'} open={openEditSkateDialog} onClose={handleCloseEditSkateDialog}>
                <UpdateSkateDialogContent skate={skate} onClose={handleCloseEditSkateDialog} />
          </Dialog>
        </span>
    );
};

export default Skate;