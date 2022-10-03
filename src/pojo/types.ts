export type PartStorage = {

    id: number,
    name: string
}

export type PartStorageInfo = {

    partStorage: PartStorage,
    countOfParts: number,
    volumeAtALowPrice: number
}

export type VictoryPieObj = {

    x: string,
    y: number

}

export type VictoryPieProps = {

    pieObj: VictoryPieObj[],
    name: string

}



