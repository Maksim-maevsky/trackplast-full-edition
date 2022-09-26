import React from 'react';
import {FooterTextStyle} from "../styles/styles";
import {FooterText, FooterYearText} from "../constant/constants";


const FooterComponent = () => {

    return (

        <footer style={FooterTextStyle}>
            <h6>
                {FooterText}
            </h6>
            <h6>
                {FooterYearText}
            </h6>
        </footer>
    );
};

export default FooterComponent;