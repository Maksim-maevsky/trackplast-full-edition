import React from 'react';

type MainProps = {

    children: React.ReactNode;
};

export function MainComponent(props: MainProps) {


    return (

        <main style={{
            display: 'flex',
            marginTop: 150,
            justifyContent: 'center'
        }}>

            {props.children}

        </main>

    )
};
