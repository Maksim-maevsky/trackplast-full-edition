import React, {useEffect, useState} from 'react';
import {ApplicationBar} from "../component/ApplicationBar";
import {MainComponent} from "../component/MainComponent";
import {StorageInfoTable} from "../component/StorageInfoTable";
import {PartStorageInfo, VictoryPieObj, VictoryPieProps} from "../pojo/types";
import StorageService from "../api/StorageService";
import FooterComponent from "../component/FooterComponent";
import PieChart from "../component/PieChart";


const StorageInfoPage = () => {

    const [storageInfo, setStorageInfo] = useState<PartStorageInfo[]>([]);

    async function getPartsStorageInfo() {

        const response = await StorageService.getAllInfo();
        setStorageInfo(response);

    }

    useEffect(() => {

        getPartsStorageInfo();

    }, [])

    const storageAndPartCountArray: VictoryPieObj[] = [];
    const storageAndVolumeByLowPriceArray: VictoryPieObj[] = [];

    for (let partStorageInfo of storageInfo) {

        storageAndPartCountArray.push({
            x: partStorageInfo.partStorage.name,
            y: partStorageInfo.countOfParts
        });

        storageAndVolumeByLowPriceArray.push({
            x: partStorageInfo.partStorage.name,
            y: partStorageInfo.volumeAtALowPrice
        })
    }


    const storageAndPartCount: VictoryPieProps = {
        pieObj: storageAndPartCountArray
    };

    const storageAndVolumeByLowPrice: VictoryPieProps = {
        pieObj: storageAndVolumeByLowPriceArray
    };


    return (
        <>
            <ApplicationBar/>

            <MainComponent>
                <StorageInfoTable partStorageInfo={storageInfo}/>
            </MainComponent>

            <div style={{

                display: 'flex',
                justifyContent: 'center'

            }}>
                <PieChart {...storageAndPartCount}/>
                <PieChart {...storageAndVolumeByLowPrice}/>
            </div>

            <FooterComponent/>
        </>
    );
};

export default StorageInfoPage;