import * as React from 'react';
import BottomNavigation from '@mui/material/BottomNavigation';
import BottomNavigationAction from '@mui/material/BottomNavigationAction';
import HouseIcon from '@mui/icons-material/House';
import AssessmentIcon from '@mui/icons-material/Assessment';
import LocalShippingIcon from '@mui/icons-material/LocalShipping';
import PaidIcon from '@mui/icons-material/Paid';
import {useNavigate} from "react-router-dom";
import InfoIcon from '@mui/icons-material/Info';

export default function MenuButtonNavigation() {

    const buttonColor = {
        color: "white"
    }

    const navigate = useNavigate();


    return (

        <BottomNavigation sx={{width: 500}} style={{
            backgroundColor: "inherit"
        }}>
            <BottomNavigationAction
                label="Home"
                value="home"
                icon={<HouseIcon style={buttonColor}/>}
                onClick={() => {
                    navigate("/");
                }}
            />

            <BottomNavigationAction
                label="Report"
                value="report"
                icon={<AssessmentIcon style={buttonColor}/>}
                onClick={() => {
                    navigate("/report");
                }}
            />

            <BottomNavigationAction
                label="Logistics"
                value="logistics"
                icon={<LocalShippingIcon style={buttonColor}/>}
                onClick={() => {
                    navigate("/logistics");
                }}
            />

            <BottomNavigationAction
                label="Payments"
                value="payments"
                icon={<PaidIcon style={buttonColor}/>}
                onClick={() => {
                    navigate("/payments");
                }}
            />

            <BottomNavigationAction
                label="About"
                value="about"
                icon={<InfoIcon style={buttonColor}/>}
                onClick={() => {
                    navigate("/about");
                }}
            />

        </BottomNavigation>
    );
}
