import React from 'react';
import AddCircleOutlineIcon from '@mui/icons-material/AddCircleOutline';
import {Link} from "react-router-dom";

const CreateBtn = () => {
    return (
        <Link className="iconContainer" to="/create">
            <AddCircleOutlineIcon fontSize="large"></AddCircleOutlineIcon>
        </Link>
    );
};

export default CreateBtn;