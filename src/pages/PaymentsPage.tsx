import React from 'react';
import FooterComponent from "../component/FooterComponent";
import {MainBlockAboutPageStyle, InternalBlockAboutPageStyle, AboutTextStyle} from "../common/styles/styles"
import {TextAbout} from "../common/constant/constants";
import {ApplicationBar} from "../component/ApplicationBar";

const PaymentsPage = () => {

    return (
        <>
            <ApplicationBar/>
            <div style={{
                display: "flex",
                justifyContent: "center",
                marginTop: "150px"
            }}>
                <div>
                    <strong>"PAGE IN PROGRESS"</strong>
                </div>
            </div>
            <FooterComponent/>
        </>
    );
};

export default PaymentsPage;