import React from 'react';
import {VictoryPie} from 'victory';
import {VictoryPieProps} from "../pojo/types";


const PieChart = (props: VictoryPieProps) => {

    const colorArray = ["tomato", "orange", "gold", "cyan", "navy"]

    return (
        <div style={{
            height: 250,
            width: 350
        }}>

            <VictoryPie data={props.pieObj} colorScale={colorArray}/>

        </div>
    );
};

export default PieChart;