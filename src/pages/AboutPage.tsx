import React from 'react';
import {Paper} from "@mui/material";

const AboutPage = () => {

    const textAbout = 'Создан для внутреннего польщования сотрудников,\n' +
        '        повышения производительсти и оптимизации процессов\n' +
        '        в компании';

    return (
        <div style={{

            display: 'flex',
            alignItems: 'center',
            justifyContent: 'center',
            marginTop: 150

        }}>
            <Paper>
                <strong>{textAbout}</strong>
            </Paper>
        </div>
    );
};

export default AboutPage;