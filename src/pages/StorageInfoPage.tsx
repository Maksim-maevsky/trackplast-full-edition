import React, {useEffect, useState} from 'react';
import {ApplicationBar} from "../component/ApplicationBar";
import {MainComponent} from "../component/MailnComponent";
import {StorageInfoTable} from "../component/StorageInfoTable";
import {PartStorageInfo} from "../pojo/types";
import StorageService from "../api/StorageService";

const StorageInfoPage = () => {

    const [storageInfo, setStorageInfo] = useState<PartStorageInfo[]>([]);

    async function getPartsStorageInfo() {

        const response = await StorageService.getAllInfo();
        setStorageInfo(response);

    }

    useEffect(() => {

        getPartsStorageInfo();

    }, [])

    return (
        <>
            <ApplicationBar/>

            <MainComponent>
                <StorageInfoTable partStorageInfo={storageInfo}/>
            </MainComponent>
        </>
    );
};

export default StorageInfoPage;