import React from 'react';
import {VictoryPie} from 'victory';
import {VictoryPieProps} from "../pojo/types";


const PieChart = (pieData: VictoryPieProps) => {

    const colorArray = ["tomato", "#8cc3ffff", "#668070ff", "cyan", "navy"]

    return (

        <div style={{
            display: "flex",
            flexDirection: "column",
            alignItems: "center",
            height: 250,
            width: 400
        }}>

            <h4 style={{
                marginBottom: 5
            }}> {pieData.name} </h4>
            <VictoryPie data={pieData.pieObj} colorScale={colorArray}/>

        </div>
    );
};

export default PieChart;