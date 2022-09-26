import React from 'react';
import FooterComponent from "../component/FooterComponent";
import {MainBlockAboutPageStyle, InternalBlockAboutPageStyle, AboutTextStyle} from "../styles/styles"
import {TextAbout} from "../constant/constants";

const AboutPage = () => {

    return (
        <>
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