import React from 'react';
import FooterComponent from "../component/FooterComponent";
import {MainBlockAboutPageStyle, InternalBlockAboutPageStyle, AboutTextStyle} from "../common/styles/styles"
import {TextAbout} from "../common/constant/constants";
import {ApplicationBar} from "../component/ApplicationBar";

const AboutPage = () => {

    return (
        <>
            <ApplicationBar/>
            <div style={MainBlockAboutPageStyle}>
                <div style={InternalBlockAboutPageStyle}>
                    <strong style={AboutTextStyle}>{TextAbout}</strong>
                </div>
            </div>
            <FooterComponent/>
        </>
    );
};

export default AboutPage;