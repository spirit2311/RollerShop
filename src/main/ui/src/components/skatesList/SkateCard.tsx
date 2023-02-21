import * as React from 'react';
import {Card, CardActionArea} from "@mui/material";
import {Link} from "react-router-dom";

interface SkateCardProps {
    id: string;
    children: JSX.Element | JSX.Element[];
    onCardClicked: () => void;
}

const SkateCard = (props: SkateCardProps): JSX.Element => ((
    <Link to={`/skates/info/${props.id}`} onClick={props.onCardClicked} style={{ textDecoration: 'none', cursor: 'pointer' }}>
        <Card sx={{height: 420, width: 250}} className="CardWrapper">
            <CardActionArea>
                {props.children}
            </CardActionArea>
        </Card>
    </Link>
));

export default SkateCard;