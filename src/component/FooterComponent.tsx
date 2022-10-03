import React from 'react';
import {FooterTextStyle} from "../common/styles/styles";
import {FooterText, FooterYearText} from "../common/constant/constants";


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